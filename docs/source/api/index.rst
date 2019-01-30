.. _Using-the-API:

Using the API
=============

NEC ID exposes a secure :abbr:`REST (Representational State Transfer)` API, allowing users to interact with the NEC ID biometric service over HTTPS. JSON is returned by all API responses including errors and HTTP response status codes are used to designate success and failure.

The following documentation details the authentiction and authorisation requirements and the various endpoints.

Download NEC ID API Swagger `JSON <https://github.com/necau/necid-sdk/blob/master/swagger/necid-api.json>`_ or  `YAML <https://github.com/necau/necid-sdk/blob/master/swagger/necid-api.yaml>`_

Authentication and Authorisation
--------------------------------

NEC ID authentiction requires and AWS Signature Version 4 authorization header to be included with each request. This requires the **AccessKey** and **SecretKey** provided in the NEC ID Welcome Pack and the use of the ``ap-southeast-2`` **AWS Region** and ``execute-api`` **Service name**.

The provided :ref:`NEC-ID-SDKs` handle the signing process using your parameters and tools such as Postman have an in-built AWS Signature authorisation type.

Alternativly this header can be generated using the `Amazon's authenticating requests guide <https://docs.aws.amazon.com/AmazonS3/latest/API/sigv4-auth-using-authorization-header.html>`_.

The following is an example of a request with the **Authorization** and **x-amz-date** header values. Line breaks are added to this Authorization line for readability.

In addition, an application API Key must be included in each request using the **x-api-key** header to identify the target application.

**Example request**:

   .. sourcecode:: http

      POST /v1.1/subjects HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: 20180816T032046Z
      Authorization: AWS4-HMAC-SHA256
      Credential=AKIAIOSFODNN8EXAMPLE/20130524/ap-southeast-2/execute-api/aws4_request,
      SignedHeaders=content-length;content-type;host;x-amz-date;x-api-key, 
      Signature=fe5f80f77d5fa3beca038a248ff027d0445342fe2855ddc963176630326f1024

Failure to include a valid Authorization header will result in a 403 forbidden HTTP response status code, with a JSON message describing the issue with the signature.

**Example response**:

   .. sourcecode:: http

      HTTP/1.1 403 Forbidden
      Content-Type: application/json

      {
        "message": "Signature expired: 20180816T032046Z is now earlier than 20180816T040329Z (20180816T040829Z - 5 min.)"
      }

Failure to include a valid API Key in the x-api-key header will result in a 403 forbidden HTTP response status codes, with a JSON message of Forbidden.

**Example response**:

   .. sourcecode:: http

      HTTP/1.1 403 Forbidden
      Content-Type: application/json

      {
        "message": "Forbidden"
      }

REST Endpoints
--------------

NEC ID support endpoints for:

- registering, updating and unregistering subjects;
- registering, updating, listing and unregistering subject events;
- performing face extraction, search and verification;
- creating, renaming, deleting and retrieving tags
- performing a bulk subject registration

Subjects
~~~~~~~~

Manage subjects for search and verification matching.

Register Subject
++++++++++++++++

.. http:post:: /v1.1/subjects
   
   Registers a new subject.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/subjects HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "face": "[FACE]",
        "tags": [ "passport" ]
      }

   :<json string face: Base64 encoded image.
   :<json array tags: Optional list of tag names to register against the subject.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.


   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 201 Created
      Content-Type: application/json

      {
        "id": "necidguid-fcdf-49eb-9182-5a6825ed2a3b",
        "eventId": "eventguid-caf3-4e0f-92b9-101a9e73a3ee",
        "attributes": {
          "faceArea": {
                "left": "161",
                "top": "156",
                "right": "318",
                "bottom": "313"
          },
          "headArea": {
                "left": "131",
                "top": "86",
                "right": "345",
                "bottom": "343"
          },
          "rightEyeCenter": {
                "x": "195",
                "y": "198"
          },
          "leftEyeCenter": {
                "x": "276",
                "y": "191"
          },
          "frontalFaceScore": "0.569824",
          "faceRoll": "4.93922",
          "facePan": "-9.34863",
          "faceTilt": "7.613",
          "faceScore": "0.999591",
          "faceQualityScore": "0.86541"
        }
      }

   :>json string id: Subject id.
   :>json string eventId: Event id.
   :>json attributes: See `Face Attributes`_
   :resheader Content-Type: application/json
   :status 201: Subject has been created.

Update Subject
++++++++++++++

.. http:put:: /v1.1/subjects/(string:subjectId)

   Update an existing subject.

   **Example request**:

   .. sourcecode:: http

      PUT /v1.1/subjects/necidguid-fcdf-49eb-9182-5a6825ed2a3b HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "face": "[FACE]",
        "tags": [ "passport" ]
      }

   :query subjectId: Subject id.
   :<json string face: Base64 encoded image.
   :<json array tags: Optional list of tag names to register against the subject.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "id": "necidguid-fcdf-49eb-9182-5a6825ed2a3b",
        "eventId": "eventguid-caf3-4e0f-92b9-101a9e73a3ee",
        "attributes": {
          "faceArea": {
                "left": "161",
                "top": "156",
                "right": "318",
                "bottom": "313"
          },
          "headArea": {
                "left": "131",
                "top": "86",
                "right": "345",
                "bottom": "343"
          },
          "rightEyeCenter": {
                "x": "195",
                "y": "198"
          },
          "leftEyeCenter": {
                "x": "276",
                "y": "191"
          },
          "frontalFaceScore": "0.569824",
          "faceRoll": "4.93922",
          "facePan": "-9.34863",
          "faceTilt": "7.613",
          "faceScore": "0.999591",
          "faceQualityScore": "0.86541"
        }
      }

   :>json string id: Subject id.
   :>json string eventId: Event id.
   :>json attributes: See `Face Attributes`_
   :resheader Content-Type: application/json
   :status 200: Subject has been updated.
   :status 404: Subject with id not found.

Unregister Subject
++++++++++++++++++

.. http:delete:: /v1.1/subjects/(string:subjectId)

   Unregister an existing subject and related events.

   **Example request**:

   .. sourcecode:: http

      DELETE /v1.1/subjects/necidguid-fcdf-49eb-9182-5a6825ed2a3b HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :query subjectId: Subject id.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 204 OK
      Content-Type: application/json

   :resheader Content-Type: application/json
   :status 204: Subject has been unregistered.
   :status 404: Subject with id not found.

Events
~~~~~~

Events provides the ability to register multiple biometrics events for a subject. The API allows you to, list register, update and unregister subject events.

List Events
+++++++++++

.. http:get:: /v1.1/subjects/(string:subjectId)/events

   Retrieve all events for a given subject.

   **Example request**:

   .. sourcecode:: http

      GET /v1.1/subjects/necidguid-fcdf-49eb-9182-5a6825ed2a3b/events HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :query subjectId: Subject id.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "id": "necidguid-fcdf-49eb-9182-5a6825ed2a3b",
        "events": [
          {
            "id": "eventguid-caf3-4e0f-92b9-101a9e73a3ee"
          },
          {
            "id": "eventguid-f99a-41dc-8eb1-cd7b1b3dcdec"
          }
        ]
      }

   :>json string id: Subject id.
   :>json array events: Containing **id** *(string)*: Event id.
   :resheader Content-Type: application/json
   :status 200: OK.
   :status 404: Subject with id not found.

Register Event
++++++++++++++

.. http:POST:: /v1.1/subjects/(string:subjectId)/events

   Register a new event for a given subject.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/subjects/necidguid-fcdf-49eb-9182-5a6825ed2a3b/events HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "face": "[FACE]",
        "tags": [ "licence" ]
      }

   :<json string face: Base64 encoded image.
   :<json array tags: Optional list of tag names to register against the subject.
   :query subjectId: Subject id.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http
  
      HTTP/1.1 201 Created
      Content-Type: application/json

      {
        "id": "necidguid-fcdf-49eb-9182-5a6825ed2a3b",
        "eventId": "eventguid-f99a-41dc-8eb1-cd7b1b3dcdec",
        "attributes": {
          "faceArea": {
                "left": "161",
                "top": "156",
                "right": "318",
                "bottom": "313"
          },
          "headArea": {
                "left": "131",
                "top": "86",
                "right": "345",
                "bottom": "343"
          },
          "rightEyeCenter": {
                "x": "195",
                "y": "198"
          },
          "leftEyeCenter": {
                "x": "276",
                "y": "191"
          },
          "frontalFaceScore": "0.569824",
          "faceRoll": "4.93922",
          "facePan": "-9.34863",
          "faceTilt": "7.613",
          "faceScore": "0.999591",
          "faceQualityScore": "0.86541"
        }
      }

   :>json string id: Subject id.
   :>json string eventId: Event id.
   :>json attributes: See `Face Attributes`_
   :resheader Content-Type: application/json
   :status 201: Event has been created.
   :status 404: Subject with id not found.

Update Event
++++++++++++

.. http:PUT:: /v1.1/subjects/(string:subjectId)/events/(string:eventId)

   Update an existing event for a given subject.

   **Example request**:

   .. sourcecode:: http

      PUT /v1.1/subjects/necidguid-fcdf-49eb-9182-5a6825ed2a3b/events/eventguid-f99a-41dc-8eb1-cd7b1b3dcdec HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "face": "[FACE]",
        "tags": [ "licence" ]
      }

   :<json string face: Base64 encoded image.
   :<json array tags: Optional list of tag names to register against the subject.
   :query subjectId: Subject id.
   :query eventId: Event id.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 201 Created
      Content-Type: application/json

      {
        "id": "necidguid-fcdf-49eb-9182-5a6825ed2a3b",
        "eventId": "eventguid-f99a-41dc-8eb1-cd7b1b3dcdec",
        "attributes": {
          "faceArea": {
                "left": "161",
                "top": "156",
                "right": "318",
                "bottom": "313"
          },
          "headArea": {
                "left": "131",
                "top": "86",
                "right": "345",
                "bottom": "343"
          },
          "rightEyeCenter": {
                "x": "195",
                "y": "198"
          },
          "leftEyeCenter": {
                "x": "276",
                "y": "191"
          },
          "frontalFaceScore": "0.569824",
          "faceRoll": "4.93922",
          "facePan": "-9.34863",
          "faceTilt": "7.613",
          "faceScore": "0.999591",
          "faceQualityScore": "0.86541"
        }
      }

   :>json string id: Subject id.
   :>json string eventId: Event id.
   :>json attributes: See `Face Attributes`_
   :resheader Content-Type: application/json
   :status 200: Event has been updated.
   :status 404: Subject with id and eventId not found.

Unregister Event
++++++++++++++++

.. http:DELETE:: /v1.1/subjects/(string:subjectId)/events/(string:eventId)

   Unregister an existing event for a given subject.

   **Example request**:

   .. sourcecode:: http

      DELETE /v1.1/subjects/necidguid-fcdf-49eb-9182-5a6825ed2a3b/events/eventguid-f99a-41dc-8eb1-cd7b1b3dcdec HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :query subjectId: Subject id.
   :query eventId: Event id.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 204 OK
      Content-Type: application/json

   :resheader Content-Type: application/json
   :status 204: Event has been unregistered.
   :status 404: Subject with id and eventId not found.

Face
~~~~

Extract faces, search and verify probe images against registered subjects.

Extract
+++++++

.. http:post:: /v1.1/face/extract

   Extract face attributes.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/face/extract HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "faces": "[FACES]"
      }

   :<json string faces: Base64 encoded image containing one or more faces.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "faces": [
          {
              "attributes": {
                  "faceArea": {
                      "left": "434",
                      "top": "449",
                      "right": "503",
                      "bottom": "518"
                  },
                  "headArea": {
                      "left": "423",
                      "top": "418",
                      "right": "515",
                      "bottom": "531"
                  },
                  "rightEyeCenter": {
                      "x": "451",
                      "y": "464"
                  },
                  "leftEyeCenter": {
                      "x": "487",
                      "y": "466"
                  },
                  "frontalFaceScore": "0.574219",
                  "faceRoll": "-3.17983",
                  "facePan": "-9.72147",
                  "faceTilt": "7.93723",
                  "faceScore": "0.999993",
                  "faceQualityScore": "0.749248"
              }
          },
          {
              "attributes": {
                  "faceArea": {
                      "left": "850",
                      "top": "416",
                      "right": "921",
                      "bottom": "486"
                  },
                  "headArea": {
                      "left": "838",
                      "top": "383",
                      "right": "933",
                      "bottom": "500"
                  },
                  "rightEyeCenter": {
                      "x": "866",
                      "y": "431"
                  },
                  "leftEyeCenter": {
                      "x": "904",
                      "y": "431"
                  },
                  "frontalFaceScore": "0.574707",
                  "faceRoll": "-0",
                  "facePan": "8.36667",
                  "faceTilt": "1.05248",
                  "faceScore": "0.999994",
                  "faceQualityScore": "0.764253"
              }
          }
        ]
      }

   :>json array faces: Containing **attributes**: See `Face Attributes`_
   :resheader Content-Type: application/json
   :status 200: Candidates found.
   :status 404: Candidates not found.

Search
++++++

.. http:post:: /v1.1/face/search

   Search for subjects using a probe.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/face/search HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "probe": "[PROBE]",
        "threshold": 7500,
        "limit": 3,
        "tags": [ "passport", "licence" ]
      }

   :<json string probe: Base64 encoded image.
   :<json int threshold: Optional score threshold, ranges from 0 to 9999, default is 7000.
   :<json int limit: Optional limit, ranges from 1 to 50, default is 10.
   :<json array tags: Option list of tag names to refine the search against, using OR to filter subjects.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "candidates": [
          {
            "id": "necidguid-fcdf-49eb-9182-5a6825ed2a3b",
            "score": 8200,
            "events": [
              {
                "id": "eventguid-caf3-4e0f-92b9-101a9e73a3ee"
                "score": 8200
              },
              {
                "id": "eventguid-f99a-41dc-8eb1-cd7b1b3dcdec"
                "score": 8000
              }
            ]
          },
          {
            "id": "necidguid-ad57-465b-b538-71b6c9b02447",
            "score": 8000,
            "events": [
              {
                "id": "eventguid-37f4-4bd9-9d64-27ed466bdb78"
                "score": 8000
              }
            ]
          },
          {
            "id": "necidguid-0d05-4052-a44f-83f6b243e70b",
            "score": 7600,
            "events": [
              {
                "id": "eventguid-f8bc-47d1-a976-7e8b953da664"
                "score": 7600
              }
            ]
          }
        ],
        "attributes": {
          "faceArea": {
                "left": "161",
                "top": "156",
                "right": "318",
                "bottom": "313"
          },
          "headArea": {
                "left": "131",
                "top": "86",
                "right": "345",
                "bottom": "343"
          },
          "rightEyeCenter": {
                "x": "195",
                "y": "198"
          },
          "leftEyeCenter": {
                "x": "276",
                "y": "191"
          },
          "frontalFaceScore": "0.569824",
          "faceRoll": "4.93922",
          "facePan": "-9.34863",
          "faceTilt": "7.613",
          "faceScore": "0.999591",
          "faceQualityScore": "0.86541"
        }
      }

   :>json array candidates: Containing **id** *(string)*: Subject id and **score** *(int)*: Match score.
   :>json attributes: See `Face Attributes`_
   :resheader Content-Type: application/json
   :status 200: Candidates found.
   :status 404: Candidates not found.

Verify
++++++

.. http:post:: /v1.1/face/verify

   Verify a subject against a probe.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/face/verify HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "probe": "[PROBE]",
        "id": necidguid-fcdf-49eb-9182-5a6825ed2a3b
      }

   :<json string probe: Base64 encoded image.
   :<json string id: Subject id.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "id": "necidguid-fcdf-49eb-9182-5a6825ed2a3b",
        "score": 8200
      }

   :>json string id: Subject id.
   :>json int score: Match score.
   :resheader Content-Type: application/json
   :status 200: Subject verified.
   :status 404: Subject not verified.

Tags
~~~~

Create, update, delete and retrieve tags. Tags provide the ability to tag subjects and events. You can then search for subjects based on these tags.

Tags must be created first using the create request. Each API key has a hard limit of 64 tags.

Create Tag
++++++++++

.. http:post:: /v1.1/tags/(string:name)

   Create a tag.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/tags/staff HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :query name: The tag name. Tag name must not be empty and must be unique.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

   :resheader Content-Type: application/json
   :status 200: Tag created.

Update Tag
++++++++++

.. http:put:: /v1.1/tags/(string:oldName)

   Update a tag.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/tags/staff/employees HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "newName": "employee"
      }

   :<json string newName: The tag's new name. Tag name must not be empty and must be unique.
   :query oldName: The tag's current name.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

   :resheader Content-Type: application/json
   :status 200: Tag updated.

Delete Tag
++++++++++

.. http:delete:: /v1.1/tags/(string:name)

   Deletes a tag. Note that existing subjects and events are not updated.

   **Example request**:

   .. sourcecode:: http

      DELETE /v1.1/tags/staff HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :query name: The name of the tag to delete.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

   :resheader Content-Type: application/json
   :status 200: Tag deleted.

Jobs
~~~~

Jobs allow you to perform bulk operations on your gallery such as bulk registrations.

Bulk Register
+++++++++++++

.. http:post:: /v1.1/jobs/bulkregister

   Creates a job to run bulk registration against the supplied registrations.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/jobs/bulkregister HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "registrations": [
          {
            "filename": "1.jpg",
            "tags": [ "passport" ]
          },
          {
            "filename": "2.jpg",
            "tags": [ "passport" ]
          }
        ]
      }

   :<json array registrations: Containing **filename** *(string)*: Name of file in S3 bucket and **tags** *(array)*: List of tags.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "batchId": "batchguid-eec5-440a-89fc-60817f5546c8"
      }

   :resheader Content-Type: application/json
   :status 200: Job created.

Bulk Register Progress
++++++++++++++++++++++

.. http:get:: /v1.1/jobs/bulkregister/(string:batchId)/(string:pagingId?)

   Retrieves the progress of the batch operation. In the event of the batch operation having more records than the maximum page size (1000), the results will be paged and the lastEvaluatedKey will contain a value that needs to be sent as the pagingId to retrieve the next page of data.

   **Example request**:

   .. sourcecode:: http

      GET /v1.1/jobs/bulkregister/batchguid-eec5-440a-89fc-60817f5546c8 HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :query batchId: The batchId of the job. 
   :query pagingId: (Optional) The lastEvaluatedKey from the previous request.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "batchId": "batchguid-eec5-440a-89fc-60817f5546c8",
        "processsed": [
          {
            "id": "51448BB9-956D-44FD-89AC-A5065D30D084",
            "filename": "1.jpg",
            "attempts": "1",
            "eventId": "eventguid-B190-466E-A1C2-9E85F436775A",
            "subjectId": "necidguid-45EC-4A97-88F0-F064A829FC90",
            "registerStatus": "",
            "reason": "",
            "status": "Processed",
            "attributesJson": "..."
          },
          {
            "id": "EFE569DA-AE74-43CC-A75F-BD85B07A7401",
            "filename": "2.jpg",
            "attempts": "1",
            "eventId": "eventguid-F3BE-4428-AAC3-8C9631776364",
            "subjectId": "necidguid-113B-4726-A267-4267816EC8FB",
            "registerStatus": "Failed",
            "reason": "Image too small",
            "status": "Processed",
            "attributesJson": "..."
          }
        ],
        "lastEvaluatedKey": ""
      }

   :<json string batchId: Base64 encoded image.
   :<json array processed: List of records within the batch with a summary. See `Register Request Summaries`_
   :<json string lastEvaluatedKey: Key to be sent as the pagingId to retrieve the next page of data.
   :resheader Content-Type: application/json
   :status 200: OK

Register Request Summaries
~~~~~~~~~~~~~~~~~~~~~~~~~~

Object describing a register request summary which contains the subjectId and eventId on success.

:id: The operation id. Note this is not the subject or event id.
:filename: The filename from the original request.
:attempts: The number of attempts.
:eventId: The event id on success.
:subjectId: The subject id on success.
:registerStatus: Once the status is "Processed", this will have a value of "Success" or "Failed".
:reason: The failure reason on failure.
:status: The status of the operation. Either "New" or "Processed".
:attributesJson: The Face Attributes - see `Face Attributes`_

Face Attributes
~~~~~~~~~~~~~~~

Sucessful requests to the **register**, **update** and **search** endpoints will return an ``attributes`` property containing a collection of face attributes related to the submitted ``face`` or ``probe`` image. In the case of **extract**, the returned ``faces`` property contains an array of objects with the ``attrbiutes`` property, representing each face found (up to 20 faces) in the submitted ``faces`` image.

:faceArea: Pixel coordinates (left, top, right and bottom) defining the bounds of the face.
:headArea: Pixel coordinates (left, top, right and bottom) defining the bounds of the face.
:rightEyeCenter: Pixel coordinates (x and y) of the centre of the right eye.
:rightEyeCenter: Pixel coordinates (x and y) of the centre of the left eye.
:faceScore: Measure of likeness to a face.
:frontalFaceScore: Degree of frontal view of face.
:faceQualityScore: Estimated overall quality of face.
:faceRoll: Roll angle of face in degrees.
:facePan: Pan angle of face in degrees.
:faceTilt: Tilt angle of face in degrees.

.. note:: The overall faceQualityScore should be used to determine the quality of the face prior to registration.

Errors
~~~~~~

In addition to the valid successful and unsuccessful status codes listed for each endpoint, exceptions will result in a error response (400 or 500 status code) with a JSON Object containing the error details.

For example, a request to **register** endpoint which does not include the mandatory ``face`` property, will return the following:

.. http:POST:: /v1.1/subjects

   .. sourcecode:: http

      HTTP/1.1 400 Bad Request
      Content-Type: application/json

      {
        "message": "face property must be provided.",
        "errorCode": 1001,
        "errorType": "InvalidRequest"
      }

   :>json string mesage: Description of the error.
   :>json int errorCode: Numeric code representing the error. See `Error Codes and Types`_.
   :>json string errorType: Named constant representing the error. See `Error Codes and Types`_.
   :resheader Content-Type: application/json
   :status 400: Client exception.
   :status 500: Server exception.

Error Codes and Types
+++++++++++++++++++++

============== ==== =======================================================================================
Type           Code Description
============== ==== =======================================================================================
InvalidRequest 1001 Request is invalid, possible missing parameters.
NoFace         2001 No face was found in the provided image.
PoorQuality    2002 The overall ``faceQualityScore`` was too low to process.
MultipleFaces  2003 Multiple faces were found in the image. Only one is permitted for this type of request.
============== ==== =======================================================================================
