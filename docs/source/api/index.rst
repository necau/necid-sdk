Using the API
=============

NEC ID exposes a secure :abbr:`REST (Representational State Transfer)` API, allowing users to interact with the NEC ID biometric service over HTTPS. JSON is returned by all API responses including errors and HTTP response status codes are used to designate success and failure.

The following documentation details the authentiction and authorisation requirements and the various endpoints.

Download NEC ID API Swagger `JSON <https://github.com/necau/necid-sdk/blob/master/swagger/necid-api.json>`_ or  `YAML <https://github.com/necau/necid-sdk/blob/master/swagger/necid-api.yaml>`_

Authentication
--------------

NEC ID authentiction requires and AWS Signature Version 4 authorization header to be included with each request. Please read `Amazon's authenticating requests guide <https://docs.aws.amazon.com/AmazonS3/latest/API/sigv4-auth-using-authorization-header.html>`_ for more details.

The following is an example of a request with the Authorization and x-amz-date header values. Line breaks are added to this Authorization line for readability:

**Example request**:

   .. sourcecode:: http

      POST /v1/subjects HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-amz-date: 20180816T032046Z
      Authorization: AWS4-HMAC-SHA256
      Credential=AKIAIOSFODNN7EXAMPLE/20130524/ap-southeast-2/execute-api/aws4_request,
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

Authorisation
-------------

In order to interact with the NEC ID REST endpoints, an application API Key must be included in each request using the x-api-key header.

**Example request**:

   .. sourcecode:: http

      POST /v1/subjects HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [YOURAPIKEY]

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

NEC ID support endpoints for registering, updating and unregistering subjects, as well as performing face search and verification.

Subjects
~~~~~~~~

Manage subjects for search and verification matching.

Register
++++++++

.. http:post:: /v1/subjects

   Registers a new subject.

   **Example request**:

   .. sourcecode:: http

      POST /v1/subjects HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [YOURAPIKEY]

      {
        "face": "[FACE]"
      }

   :<json string face: Base64 encoded image.
   :reqheader Accept: application/json
   :reqheader x-api-key: API Key

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 201 Created
      Content-Type: application/json

      {
        "id": "[GUID]"
      }

   :>json string next: Subject id.
   :resheader Content-Type: application/json
   :status 201: Subject has been created.

Update
++++++

.. http:put:: /v1/subjects/(string:id)

   Update an existing subject.

   **Example request**:

   .. sourcecode:: http

      PUT /v1/subjects HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [YOURAPIKEY]

      {
        "face": "[FACE]"
      }

   :query id: subject id
   :<json string face: Base64 encoded image.
   :reqheader Accept: application/json
   :reqheader x-api-key: API Key

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "id": "[GUID]"
      }

   :>json string id: Subject id.
   :resheader Content-Type: application/json
   :status 200: Subject has been updated.
   :status 404: Subject with id not found.

Unregister
++++++++++

.. http:delete:: /v1/subjects/(string:id)

   Unregister an existing subject.

   **Example request**:

   .. sourcecode:: http

      DELETE /v1/subjects HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [YOURAPIKEY]

   :query id: Subject id.
   :reqheader Accept: application/json
   :reqheader x-api-key: API Key

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 204 OK
      Content-Type: application/json

   :resheader Content-Type: application/json
   :status 204: Subject has been unregistered.
   :status 404: Subject with id not found.

Face
~~~~

Search and verify probe images against registered subjects.

Search
++++++

.. http:post:: /v1/face/search

   Search for subjects using a probe.

   **Example request**:

   .. sourcecode:: http

      POST /v1/face/search HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [YOURAPIKEY]

      {
        "probe": "[PROBE]",
        "threshold": 7500,
        "limit": 3
      }

   :<json string probe: Base64 encoded image
   :<json int threshold: optional score threshold, ranges from 0 to 9999, default is X.
   :<json int limit: optional limit, ranges from 1 to 50, default is 10.
   :reqheader Accept: application/json
   :reqheader x-api-key: API Key

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      [
        {
          "id": "[GUID]",
          "score": 8200
        },
        {
          "id": "[GUID]",
          "score": 8000
        },
        {
          "id": "[GUID]",
          "score": 7600
        }
      ]

   :>json string id: Subject id.
   :>json int score: Match score.
   :resheader Content-Type: application/json
   :status 200: Candidates found.
   :status 404: Candidates not found.

Verify
++++++

.. http:post:: /v1/face/verify

   Verify a subject against a probe.

   **Example request**:

   .. sourcecode:: http

      POST /v1/face/verify HTTP/1.1
      Host: api.id.nec.com.au
      Accept: application/json
      x-api-key: [YOURAPIKEY]

      {
        "probe": "[PROBE]",
        "id": [GUID]
      }

   :<json string probe: Base64 encoded image.
   :<json string id: Subject id.
   :reqheader Accept: application/json
   :reqheader x-api-key: API Key

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Content-Type: application/json

      {
        "id": "[GUID]",
        "score": 8200
      }

   :>json string id: Subject id.
   :>json int score: Match score.
   :resheader Content-Type: application/json
   :status 200: Subject verified.
   :status 404: Subject not verified.