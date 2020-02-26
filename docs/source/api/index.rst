.. _Using-the-API:

Using the API
=============

NEC ID exposes a secure :abbr:`REST (Representational State Transfer)` API, allowing users to interact with the NEC ID biometric service over HTTPS. JSON is returned by all API responses including errors and HTTP response status codes are used to designate success and failure.

The platform also provides a means to manage your tenancy configuration via secure :abbr:`REST (Representational State Transfer)` API, allowing tenants to provision new galleries and applications.

The following documentation details the authentiction and authorisation requirements and the various endpoints.

Download NEC ID API Swagger `JSON <https://github.com/necau/necid-sdk/blob/master/swagger/necid-v1_1.json>`_ or  `YAML <https://github.com/necau/necid-sdk/blob/master/swagger/necid-v1_1.yaml>`_

Authentication and Authorisation
--------------------------------

NEC ID authentiction requires and AWS Signature Version 4 authorization header to be included with each request. This requires the **AccessKey** and **SecretKey** provided in the NEC ID Welcome Pack and the use of the ``ap-southeast-2`` **AWS Region** and ``execute-api`` **Service name**.

The provided :ref:`NEC-ID-SDKs` handle the signing process using your parameters and tools such as Postman have an in-built AWS Signature authorisation type.

Alternativly this header can be generated using the `Amazon's authenticating requests guide <https://docs.aws.amazon.com/AmazonS3/latest/API/sigv4-auth-using-authorization-header.html>`_.

The following is an example of a request with the **Authorization** and **x-amz-date** header values. Line breaks are added to this Authorization line for readability.

In addition, an application API Key must be included in requests that pertain to a specific gallery by using the **x-api-key** header to identify the target application.

**Example request**:

   .. sourcecode:: http

      POST /v1.1/subjects HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      Content-Type: application/json
      x-api-key: 73n4n74p1k3y
      x-amz-date: 20180816T032046Z
      Authorization: AWS4-HMAC-SHA256
      Credential=AKIAIOSFODNN8EXAMPLE/20190304/ap-southeast-2/execute-api/aws4_request,
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

Failure to include a valid API Key via the x-api-key header in particular requests will result in a 403 forbidden HTTP response status codes, with a JSON message of Forbidden.

**Example response**:

   .. sourcecode:: http

      HTTP/1.1 403 Forbidden
      Content-Type: application/json

      {
        "message": "Forbidden"
      }

Biometric REST Endpoints
------------------------

NEC ID support endpoints for:

- registering, updating, listing and unregistering subjects;
- registering, updating, listing and unregistering subject events;
- performing face extraction, search and verification;
- creating, renaming, deleting and retrieving tags;
- performing a bulk subject registration;

Subjects
~~~~~~~~

Manage subjects for search and verification matching.

List Subjects
+++++++++++++

.. http:get:: /v1.1/subjects

   Retrieve all subjects for a specific gallery.

   **Example request**:

   .. sourcecode:: http

      GET /v1.1/subjects HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :query start: Optional starting index of the request, defaults to 0 if not provided.
   :query length: Optional length of the list, defaults to 1000 if not provided. Limited to a maximum of 1000 per request.
   :query dir: Optional last updated sort direction (asc or desc). default is asc.
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
        "subjects": [
          {
            "id": "necidguid-fcdf-49eb-9182-5a6825ed2a3b",
            "eventId": "eventguid-caf3-4e0f-92b9-101a9e73a3ee",
            "status": "A",
            "lastUpdated": "2018-12-18T00:27:56.427+00:00"
          },
          {
            "id": "necidguid-fcdf-49eb-9182-5a6825ed2a3b",
            "eventId": "eventguid-f99a-41dc-8eb1-cd7b1b3dcdec",
            "status": "D",
            "lastUpdated": "2019-02-28T18:11:49.157+00:00"
          },
          {
            "id": "necidguid-fcdf-49eb-9182-5a6825ed2a3b",
            "eventId": "eventguid-f99a-41dc-8eb1-cd7b1b3dcdec",
            "status": "A",
            "lastUpdated": "2019-02-28T18:11:49.174+00:00"
          }
        ],
        "total": 3
      }

   :>json array subjects: Containing **id** *(string)*: Subject id, **eventId** *(string)*: Event id, **status** *(string)*: Status (D = Deleted or A = Active), **lastUpdated** *(ISO 8601 timestamp)*: Last Updated Time.
   :>json int total: Total number of events in gallery.
   :resheader Content-Type: application/json
   :status 200: OK.
   :status 404: Subjects not found.

.. note:: As a subject can have many events, the subject's id will be repeated for each of its eventIds. Plus, in order to reuse slots within a gallery, deleted events are flagged with a **status** of DELETED until the slot is recycled. This means that the list of subjects can include deleted subjects, plus subjects we have been updated, which appear as deleted (D) and active (A) with the same ids.

Register Subject
++++++++++++++++

.. http:post:: /v1.1/subjects
   
   Registers a new subject.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/subjects HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      Content-Type: application/json
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
   :reqheader Content-Type: application/json
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
   :>json attributes: See `Face Attributes`_.
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
      Content-Type: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "face": "[FACE]",
        "tags": [ "passport" ]
      }

   :param subjectId: Subject id.
   :<json string face: Base64 encoded image.
   :<json array tags: Optional list of tag names to register against the subject.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader Content-Type: application/json
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
   :>json attributes: See `Face Attributes`_.
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
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :param subjectId: Subject id.
   :reqheader Host: api.id.nec.com.au
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 204 No Content
   
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

   :param subjectId: Subject id.
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
      Content-Type: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "face": "[FACE]",
        "tags": [ "licence" ]
      }

   :<json string face: Base64 encoded image.
   :<json array tags: Optional list of tag names to register against the subject.
   :param subjectId: Subject id.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader Content-Type: application/json
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
   :>json attributes: See `Face Attributes`_.
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
      Content-Type: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "face": "[FACE]",
        "tags": [ "licence" ]
      }

   :<json string face: Base64 encoded image.
   :<json array tags: Optional list of tag names to register against the subject.
   :param subjectId: Subject id.
   :param eventId: Event id.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader Content-Type: application/json
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
   :>json attributes: See `Face Attributes`_.
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
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :param subjectId: Subject id.
   :param eventId: Event id.
   :reqheader Host: api.id.nec.com.au
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 204 No Content
   
   :status 204: Event has been unregistered.
   :status 404: Subject with id and eventId not found.

Face
~~~~

Extract faces, search and verify probe images against registered subjects.

Extract Faces
+++++++++++++

.. http:post:: /v1.1/face/extract

   Extract face attributes.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/face/extract HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      Content-Type: application/json
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "faces": "[FACES]",
        "limit": 12
      }

   :<json string faces: Base64 encoded image containing one or more faces.
   :<json int limit: Optional limit of total faces returned, default is 10. Note, if the time taken to retrive the faces is beyond 30 seconds, the request will timeout.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader Content-Type: application/json
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

   :>json array faces: Containing **attributes**: See `Face Attributes`_.
   :resheader Content-Type: application/json
   :status 200: Face attributes extracted.

Verify Face
+++++++++++

.. http:post:: /v1.1/face/verify

   Verify a face against a probe.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/face/verify HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      Content-Type: application/json
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "face": "[FACE]",
        "probe": "[PROBE]"
      }

   :<json string probe: Base64 encoded image.
   :<json string face: Base64 encoded image.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader Content-Type: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "score": 8200
      }

   :>json int score: Match score.
   :resheader Content-Type: application/json
   :status 200: Subject verified.
   :status 404: Subject not verified.

Verify Subject
++++++++++++++

.. http:post:: /v1.1/face/verify

   Verify a subject, and their one or more events, against a probe.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/face/verify HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      Content-Type: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "id": "necidguid-fcdf-49eb-9182-5a6825ed2a3b",
        "probe": "[PROBE]"
      }

   :<json string probe: Base64 encoded image.
   :<json string id: Subject id.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader Content-Type: application/json
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
   :>json int score: Match score of the subject's hightest scoring event.
   :resheader Content-Type: application/json
   :status 200: Subject verified.
   :status 404: Subject not verified.

Search Subjects
+++++++++++++++

.. http:post:: /v1.1/face/search

   Search for subjects using a probe.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/face/search HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      Content-Type: application/json
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
   :<json int limit: Optional limit of total events returned, ranges from 1 to 50, default is 10.
   :<json array tags: Option list of tag names to refine the search against, using OR to filter subjects.
   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader Content-Type: application/json
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

   :>json array candidates: Containing **id** *(string)*: Subject id, **score** *(int)*: Highest match score and **event** *(array)*: Containing **id** *(string)*: Event id and **score** *(int)*: Match score.
   :>json attributes: See `Face Attributes`_.
   :resheader Content-Type: application/json
   :status 200: Candidates found.
   :status 404: Candidates not found.

Tags
~~~~

Create, update, delete and retrieve tags. Tags provide the ability to tag subjects and events. You can then search for subjects based on these tags.

Tags must be created first, before using them in register and search requests.

List Tags
+++++++++

.. http:get:: /v1.1/tags

   Retrieve all tags for a specific gallery.

   **Example request**:

   .. sourcecode:: http

      GET /v1.1/tags HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      [
        "passport",
        "licence"
      ]

   :>json array: Containing tag names.
   :resheader Content-Type: application/json
   :status 200: OK.

.. note:: Each gallery has a hard limit of 64 tags

Create Tag
++++++++++

.. http:post:: /v1.1/tags/(string:name)

   Create a tag.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/tags/staff HTTP/1.1
      Host: api.id.nec.com.au
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :param name: The tag name. Tag name must not be empty and must be unique.
   :reqheader Host: api.id.nec.com.au
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
   
   :status 200: Tag created.

Update Tag
++++++++++

.. http:put:: /v1.1/tags/(string:oldName)

   Update a tag.

   **Example request**:

   .. sourcecode:: http

      POST /v1.1/tags/licence HTTP/1.1
      Host: api.id.nec.com.au
      Content-Type: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "newName": "identification"
      }

   :<json string newName: The tag's new name. Tag name must not be empty and must be unique.
   :param oldName: The tag's current name.
   :reqheader Host: api.id.nec.com.au
   :reqheader Content-Type: application/json
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
   
   :status 200: Tag updated.

Delete Tag
++++++++++

.. http:delete:: /v1.1/tags/(string:name)

   Deletes a tag. Note that existing subjects and events are not updated.

   **Example request**:

   .. sourcecode:: http

      DELETE /v1.1/tags/passport HTTP/1.1
      Host: api.id.nec.com.au
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :param name: The name of the tag to delete.
   :reqheader Host: api.id.nec.com.au
   :reqheader x-api-key: Application API Key.
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
   
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
      Content-Type: application/json
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
   :reqheader Content-Type: application/json
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

   :>json string batchId: Batch id.
   :resheader Content-Type: application/json
   :status 200: Job created.

Bulk Register Progress
++++++++++++++++++++++

.. http:get:: /v1.1/jobs/bulkregister/(string:batchId)/(string:pagingId)

   Retrieves the progress of the batch operation. In the event of the batch operation having more records than the maximum page size (1000), the results will be paged and the lastEvaluatedKey will contain a value that needs to be sent as the pagingId to retrieve the next page of data.

   **Example request**:

   .. sourcecode:: http

      GET /v1.1/jobs/bulkregister/batchguid-eec5-440a-89fc-60817f5546c8 HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :param batchId: The batchId of the job. 
   :param pagingId: (Optional) The lastEvaluatedKey from the previous request.
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
            "registerStatus": "Success",
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

   :>json string batchId: Batch Id.
   :>json array processed: List of records within the batch with a summary. See `Register Request Summaries`_
   :>json string lastEvaluatedKey: Key to be sent as the pagingId to retrieve the next page of data.
   :resheader Content-Type: application/json
   :status 200: OK

   Register Request Summaries
   ++++++++++++++++++++++++++

   Object describing a register request summary which contains the subjectId and eventId on success.

   :id: The operation id. Note this is not the subject or event id.
   :filename: The filename from the original request.
   :attempts: The number of attempts.
   :eventId: The event id on success.
   :subjectId: The subject id on success.
   :registerStatus: Once the status is "Processed", this will have a value of "Success" or "Failed".
   :reason: The failure reason on failure.
   :status: The status of the operation. Either "New" or "Processed".
   :attributesJson: The Face Attributes - see `Face Attributes`_.

Health
~~~~~~

Check the status of the service.

.. http:get:: /v1.1/health

   **Example request**:

   .. sourcecode:: http

      GET /v1.1/health HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [Application API key]
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :reqheader Host: api.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "status": "OK"
      }

   :>json string status: Service status.
   :resheader Content-Type: application/json
   :status 200: OK.

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

Tenant Management REST Endpoints
--------------------------------

NEC ID support endpoints for:

- creating and deleting galleries and applications with which to access them;

Galleries
~~~~~~~~~

Manage tenant galleries.

List Galleries
++++++++++++++

.. http:get:: /api/galleries

   Retrieve all galleries.

   **Example request**:

   .. sourcecode:: http

      GET /api/galleries HTTP/1.1
      Host: portal.id.nec.com.au
      Accept: application/json
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :reqheader Host: portal.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "galleries": [
          {
            "id": "galleryguid-327D-4D31-8E25-35891A034220",
            "name": "Staff",
            "description": "Staff",
            "size": 10000,
            "count": 3891
          },
          {
            "id": "galleryguid-5570-4f20-a95c-8e50e0bca0cb",
            "name": "Y9Students",
            "description": "Year 9 students",
            "size": 1000,
            "count": 873
          },
          {
            "id": "galleryguid-b751-4b5e-9e4d-cc1a314788db",
            "name": "Visitors",
            "description": "Visitors",
            "size": 10000,
            "count": 431
          }
        ]
      }

   :>json array galleries: Containing **id** *(string)*: Gallery id, **name** *(string)*: Name, **description** *(string)*: Description, **size** *(int)*: Size, **count** *(int)*: Count.
   :resheader Content-Type: application/json
   :status 200: OK.

Get Gallery
+++++++++++

.. http:get:: /api/galleries/(string:galleryId)

   Retrieve gallery details, including associated applications and their apiKey.

   **Example request**:

   .. sourcecode:: http

      GET /api/galleries/galleryguid-327D-4D31-8E25-35891A034220 HTTP/1.1
      Host: portal.id.nec.com.au
      Accept: application/json
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :param galleryId: Gallery id.
   :reqheader Host: portal.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "id": "galleryguid-327D-4D31-8E25-35891A034220",
        "name": "Staff",
        "description": "Staff",
        "size": 10000,
        "count": 3891,
        "applications": [
          {
            "id": "applicationId02",
            "name": "Building Access System",
            "apiKey": [Application API key]
        ]
      }

   :>json string id: Gallery id.
   :>json string name: Name.
   :>json string description: Description.
   :>json int size: Size.
   :>json int count: Count.
   :>json array applications: Containing **id** *(string)*: Application id, **name** *(string)*: Name, **apiKey** *(string)*: API Key.
   :resheader Content-Type: application/json
   :status 200: OK.

Create Gallery
++++++++++++++

.. http:post:: /api/galleries

   Create a gallery and an application with which to access it.

   **Example request**:

   .. sourcecode:: http

      POST /api/galleries HTTP/1.1
      Host: portal.id.nec.com.au
      Accept: application/json
      Content-Type: application/json
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "name": "Y10Students",
        "description": "Year 10 Students",
        "faceMinimumQualityScore": 0.8,
        "size": 1000,
      }

   :<json string name: Name of the gallery.
   :<json string description: Description of the gallery.
   :<json float faceMinimumQualityScore: Minimum estimated overall quality of face - see `Face Attributes`_, must be greater than or equal to 0.45.
   :<json int size: Size of the gallery.
   :reqheader Host: portal.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader Content-Type: application/json
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "id": "galleryguid-28da-4dd4-b10b-e48c6be09689",
        "name": "Y10Students",
        "description": "Year 10 Students",
        "size": 1000,
        "apiKey": [Application API key]
      }

   :>json string id: Gallery id.
   :>json string name: Name.
   :>json string description: Description.
   :>json int size: Size.
   :>json string apiKey: Application API Key.
   :resheader Content-Type: application/json
   :status 200: Gallery created.

.. note:: If the gallery already exists, a 400 response will be returned, with the error type ``Duplicate`` and the existing ``apiKey`` in the message.

Update Gallery
++++++++++++++

.. http:patch:: /api/galleries/(string:galleryId)

   Update a gallery.

   **Example request**:

   .. sourcecode:: http

      PATCH /api/galleries HTTP/1.1
      Host: portal.id.nec.com.au
      Accept: application/json
      Content-Type: application/json
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "name": "Y10Students",
        "description": "Year 10 Students",
        "size": 2000,
      }

   :param galleryId: Gallery id.
   :<json string name: Name of the gallery.
   :<json string description: Description of the gallery.
   :<json int size: Size of the gallery.
   :reqheader Host: portal.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader Content-Type: application/json
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "id": "galleryguid-28da-4dd4-b10b-e48c6be09689",
        "name": "Y10Students",
        "description": "Year 10 Students",
        "size": 2000
      }

   :>json string id: Gallery id.
   :>json string name: Name.
   :>json string description: Description.
   :>json int size: Size.
   :resheader Content-Type: application/json
   :status 200: Gallery updated.

.. note:: Gallery size can only be increased.

Delete Gallery
++++++++++++++

.. http:delete:: /api/galleries/(string:galleryId)

   Deletes a gallery and its realted applications.

   **Example request**:

   .. sourcecode:: http

      DELETE /api/galleries/galleryguid-28da-4dd4-b10b-e48c6be09689 HTTP/1.1
      Host: portal.id.nec.com.au
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :param galleryId: Gallery id.
   :reqheader Host: portal.id.nec.com.au
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 204 No Content
   
   :status 204: Gallery deleted.

Applications
~~~~~~~~~~~~

Manage tenant applications.

List Applications
+++++++++++++++++

.. http:get:: /api/applications

   Retrieve all applications.

   **Example request**:

   .. sourcecode:: http

      GET /api/applications HTTP/1.1
      Host: portal.id.nec.com.au
      Accept: application/json
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :reqheader Host: portal.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "applications": [
          {
            "id": "applicationId01",
            "name": "HR System",
            "apiKey": [Application API key]
          },
          {
            "id": "applicationId02",
            "name": "Building Access System",
            "apiKey": [Application API key]
          }
        ]
      }

   :>json array applications: Containing **id** *(string)*: Application id, **name** *(string)*: Name, **apiKey** *(string)*: Application API Key.
   :resheader Content-Type: application/json
   :status 200: OK.

Get Application
+++++++++++++++

.. http:get:: /api/applications/(string:applicationId)

   Retrieve application details.

   **Example request**:

   .. sourcecode:: http

      GET /api/applications/applicationId01 HTTP/1.1
      Host: portal.id.nec.com.au
      Accept: application/json
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :param applicationId: Application id.
   :reqheader Host: portal.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "id": "applicationId01",
        "name": "HR System",
        "description": "HR System",
        "apiKey": [Application API key],
        "faceMinimumQualityScore": 0.6
      }

   :>json string id: Gallery id.
   :>json string name: Name.
   :>json string description: Description.
   :>json string apiKey: Application API Key.
   :<json float faceMinimumQualityScore: Minimum estimated overall quality of face - see `Face Attributes`_.
   :resheader Content-Type: application/json
   :status 200: OK.

Create Application
++++++++++++++++++

.. http:post:: /api/applications

   Create an application.

   **Example request**:

   .. sourcecode:: http

      POST /api/applications HTTP/1.1
      Host: portal.id.nec.com.au
      Accept: application/json
      Content-Type: application/json
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "name": "Building Access System",
        "description": "Building Access System",
        "faceMinimumQualityScore": 0.8,
        "galleryId": "galleryguid-327D-4D31-8E25-35891A034220",
      }

   :<json string name: Name of the application.
   :<json string description: Description of the application.
   :<json float faceMinimumQualityScore: Minimum estimated overall quality of face - see `Face Attributes`_, must be greater than or equal to 0.45.
   :<json string galleryId: Id of the target gallery.
   :reqheader Host: portal.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader Content-Type: application/json
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "id": "applicationId02",
        "name": "Building Access System",
        "description": "Building Access System",
        "apiKey": [Application API key],
        "faceMinimumQualityScore": 0.8
      }

   :>json string id: Application id.
   :>json string name: Name.
   :>json string description: Description.
   :>json string apiKey: Application API Key.
   :<json float faceMinimumQualityScore: Minimum estimated overall quality of face - see `Face Attributes`_.
   :resheader Content-Type: application/json
   :status 200: Application created.

Update Application
++++++++++++++++++

.. http:patch:: /api/applications/(string:applicationId)

   Update an application.

   **Example request**:

   .. sourcecode:: http

      PATCH /api/applications HTTP/1.1
      Host: portal.id.nec.com.au
      Accept: application/json
      Content-Type: application/json
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

      {
        "name": "Building Access System",
        "description": "Building Access System",
        "faceMinimumQualityScore": 0.6
      }

   :param applicationId: Application id.
   :<json string name: Name of the application.
   :<json string description: Description of the application.
   :<json float faceMinimumQualityScore: Minimum estimated overall quality of face - see `Face Attributes`_, must be greater than or equal to 0.45.
   :reqheader Host: portal.id.nec.com.au
   :reqheader Accept: application/json
   :reqheader Content-Type: application/json
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "id": "applicationId02",
        "name": "Building Access System",
        "description": "Building Access System"
        "apiKey": [Application API key],
        "faceMinimumQualityScore": 0.8
      }

   :>json string id: Application id.
   :>json string name: Name.
   :>json string description: Description.
   :>json string apiKey: Application API Key.
   :<json float faceMinimumQualityScore: Minimum estimated overall quality of face - see `Face Attributes`_.
   :resheader Content-Type: application/json
   :status 200: Application updated.

Delete Application
++++++++++++++++++

.. http:delete:: /api/applications/(string:applicationId)

   Deletes an application.

   **Example request**:

   .. sourcecode:: http

      DELETE /api/applications/applicationid02 HTTP/1.1
      Host: portal.id.nec.com.au
      x-amz-date: [YYYYMMDD'T'HHMMSS'Z' UTC timestamp]
      Authorization: [AWS Signature Version 4]

   :param applicationId: Application id.
   :reqheader Host: portal.id.nec.com.au
   :reqheader x-amz-date: UTC timestamp using ISO 8601 format: YYYYMMDD'T'HHMMSS'Z'.
   :reqheader Authorization: AWS Signature Version 4.

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 204 No Content
   
   :status 204: Application deleted.

Error Handling
--------------

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
~~~~~~~~~~~~~~~~~~~~~

============== ==== =======================================================================================
Type           Code Description
============== ==== =======================================================================================
InvalidRequest 1001 Request is invalid, possible missing parameters.
Duplicate      1002 Duplicate request, identifier in message.
Timeout        1003 Request timed out.
NoFace         2001 No face was found in the provided image.
PoorQuality    2002 The overall ``faceQualityScore`` was too low to process.
MultipleFaces  2003 Multiple faces were found in the image. Only one is permitted for this type of request.
============== ==== =======================================================================================
