module NECID
  # @api private
  module ClientApi

    include Seahorse::Model

    ApiFaceExtractPostRequest = Shapes::StructureShape.new(name: 'ApiFaceExtractPostRequest')
    ApiFaceExtractPostResponse = Shapes::StructureShape.new(name: 'ApiFaceExtractPostResponse')
    ApiFaceSearchPostRequest = Shapes::StructureShape.new(name: 'ApiFaceSearchPostRequest')
    ApiFaceSearchPostResponse = Shapes::StructureShape.new(name: 'ApiFaceSearchPostResponse')
    ApiFaceVerifyPostRequest = Shapes::StructureShape.new(name: 'ApiFaceVerifyPostRequest')
    ApiFaceVerifyPostResponse = Shapes::StructureShape.new(name: 'ApiFaceVerifyPostResponse')
    ApiSubjectsByIdDeleteRequest = Shapes::StructureShape.new(name: 'ApiSubjectsByIdDeleteRequest')
    ApiSubjectsByIdEventByIdDeleteRequest = Shapes::StructureShape.new(name: 'ApiSubjectsByIdEventByIdDeleteRequest')
    ApiSubjectsByIdEventByIdPutRequest = Shapes::StructureShape.new(name: 'ApiSubjectsByIdEventByIdPutRequest')
    ApiSubjectsByIdEventByIdPutResponse = Shapes::StructureShape.new(name: 'ApiSubjectsByIdEventByIdPutResponse')
    ApiSubjectsByIdEventsGetRequest = Shapes::StructureShape.new(name: 'ApiSubjectsByIdEventsGetRequest')
    ApiSubjectsByIdEventsGetResponse = Shapes::StructureShape.new(name: 'ApiSubjectsByIdEventsGetResponse')
    ApiSubjectsByIdEventsPostRequest = Shapes::StructureShape.new(name: 'ApiSubjectsByIdEventsPostRequest')
    ApiSubjectsByIdEventsPostResponse = Shapes::StructureShape.new(name: 'ApiSubjectsByIdEventsPostResponse')
    ApiSubjectsByIdPutRequest = Shapes::StructureShape.new(name: 'ApiSubjectsByIdPutRequest')
    ApiSubjectsByIdPutResponse = Shapes::StructureShape.new(name: 'ApiSubjectsByIdPutResponse')
    ApiSubjectsGetRequest = Shapes::StructureShape.new(name: 'ApiSubjectsGetRequest')
    ApiSubjectsGetResponse = Shapes::StructureShape.new(name: 'ApiSubjectsGetResponse')
    ApiSubjectsPostRequest = Shapes::StructureShape.new(name: 'ApiSubjectsPostRequest')
    ApiSubjectsPostResponse = Shapes::StructureShape.new(name: 'ApiSubjectsPostResponse')
    Attributes = Shapes::StructureShape.new(name: 'Attributes')
    BulkRegisterRequest = Shapes::StructureShape.new(name: 'BulkRegisterRequest')
    BulkRegisterResponse = Shapes::StructureShape.new(name: 'BulkRegisterResponse')
    Candidate = Shapes::StructureShape.new(name: 'Candidate')
    CreateTagRequest = Shapes::StructureShape.new(name: 'CreateTagRequest')
    CreateTagResponse = Shapes::StructureShape.new(name: 'CreateTagResponse')
    DeleteTagRequest = Shapes::StructureShape.new(name: 'DeleteTagRequest')
    DeleteTagResponse = Shapes::StructureShape.new(name: 'DeleteTagResponse')
    Event = Shapes::StructureShape.new(name: 'Event')
    Events = Shapes::StructureShape.new(name: 'Events')
    ExtractResult = Shapes::StructureShape.new(name: 'ExtractResult')
    FaceArea = Shapes::StructureShape.new(name: 'FaceArea')
    GetBulkRegisterProgressPagedRequest = Shapes::StructureShape.new(name: 'GetBulkRegisterProgressPagedRequest')
    GetBulkRegisterProgressPagedResponse = Shapes::StructureShape.new(name: 'GetBulkRegisterProgressPagedResponse')
    GetBulkRegisterProgressRequest = Shapes::StructureShape.new(name: 'GetBulkRegisterProgressRequest')
    GetBulkRegisterProgressResponse = Shapes::StructureShape.new(name: 'GetBulkRegisterProgressResponse')
    GetHealthRequest = Shapes::StructureShape.new(name: 'GetHealthRequest')
    GetHealthResponse = Shapes::StructureShape.new(name: 'GetHealthResponse')
    GetRequest = Shapes::StructureShape.new(name: 'GetRequest')
    GetResponse = Shapes::StructureShape.new(name: 'GetResponse')
    HeadArea = Shapes::StructureShape.new(name: 'HeadArea')
    Job = Shapes::StructureShape.new(name: 'Job')
    JobStatus = Shapes::StructureShape.new(name: 'JobStatus')
    JobSummary = Shapes::StructureShape.new(name: 'JobSummary')
    LeftEyeCenter = Shapes::StructureShape.new(name: 'LeftEyeCenter')
    NotFoundException = Shapes::StructureShape.new(name: 'NotFoundException')
    RightEyeCenter = Shapes::StructureShape.new(name: 'RightEyeCenter')
    SearchResult = Shapes::StructureShape.new(name: 'SearchResult')
    Subject = Shapes::StructureShape.new(name: 'Subject')
    SubjectList = Shapes::StructureShape.new(name: 'SubjectList')
    Tag = Shapes::StructureShape.new(name: 'Tag')
    UpdateTagRequest = Shapes::StructureShape.new(name: 'UpdateTagRequest')
    UpdateTagResponse = Shapes::StructureShape.new(name: 'UpdateTagResponse')
    boolean = Shapes::BooleanShape.new(name: 'boolean')
    double = Shapes::FloatShape.new(name: 'double')
    integer = Shapes::IntegerShape.new(name: 'integer')
    listOfAttributes = Shapes::ListShape.new(name: 'listOfAttributes')
    listOfCandidate = Shapes::ListShape.new(name: 'listOfCandidate')
    listOfEvent = Shapes::ListShape.new(name: 'listOfEvent')
    listOfJobStatus = Shapes::ListShape.new(name: 'listOfJobStatus')
    listOfSubject = Shapes::ListShape.new(name: 'listOfSubject')
    long = Shapes::IntegerShape.new(name: 'long')
    string = Shapes::StringShape.new(name: 'string')
    timestampIso8601 = Shapes::TimestampShape.new(name: 'timestampIso8601', timestampFormat: "iso8601")
    timestampUnix = Shapes::TimestampShape.new(name: 'timestampUnix', timestampFormat: "iso8601")

    ApiFaceExtractPostRequest.struct_class = Types::ApiFaceExtractPostRequest

    ApiFaceExtractPostResponse.add_member(:extract_result, Shapes::ShapeRef.new(shape: ExtractResult, required: true, location_name: "ExtractResult"))
    ApiFaceExtractPostResponse.struct_class = Types::ApiFaceExtractPostResponse
    ApiFaceExtractPostResponse[:payload] = :extract_result
    ApiFaceExtractPostResponse[:payload_member] = ApiFaceExtractPostResponse.member(:extract_result)

    ApiFaceSearchPostRequest.struct_class = Types::ApiFaceSearchPostRequest

    ApiFaceSearchPostResponse.add_member(:search_result, Shapes::ShapeRef.new(shape: SearchResult, required: true, location_name: "SearchResult"))
    ApiFaceSearchPostResponse.struct_class = Types::ApiFaceSearchPostResponse
    ApiFaceSearchPostResponse[:payload] = :search_result
    ApiFaceSearchPostResponse[:payload_member] = ApiFaceSearchPostResponse.member(:search_result)

    ApiFaceVerifyPostRequest.struct_class = Types::ApiFaceVerifyPostRequest

    ApiFaceVerifyPostResponse.add_member(:candidate, Shapes::ShapeRef.new(shape: Candidate, required: true, location_name: "Candidate"))
    ApiFaceVerifyPostResponse.struct_class = Types::ApiFaceVerifyPostResponse
    ApiFaceVerifyPostResponse[:payload] = :candidate
    ApiFaceVerifyPostResponse[:payload_member] = ApiFaceVerifyPostResponse.member(:candidate)

    ApiSubjectsByIdDeleteRequest.add_member(:subject_id, Shapes::ShapeRef.new(shape: string, required: true, location: "uri", location_name: "subjectId"))
    ApiSubjectsByIdDeleteRequest.struct_class = Types::ApiSubjectsByIdDeleteRequest

    ApiSubjectsByIdEventByIdDeleteRequest.add_member(:event_id, Shapes::ShapeRef.new(shape: string, required: true, location: "uri", location_name: "eventId"))
    ApiSubjectsByIdEventByIdDeleteRequest.add_member(:subject_id, Shapes::ShapeRef.new(shape: string, required: true, location: "uri", location_name: "subjectId"))
    ApiSubjectsByIdEventByIdDeleteRequest.struct_class = Types::ApiSubjectsByIdEventByIdDeleteRequest

    ApiSubjectsByIdEventByIdPutRequest.add_member(:event_id, Shapes::ShapeRef.new(shape: string, required: true, location: "uri", location_name: "eventId"))
    ApiSubjectsByIdEventByIdPutRequest.add_member(:subject_id, Shapes::ShapeRef.new(shape: string, required: true, location: "uri", location_name: "subjectId"))
    ApiSubjectsByIdEventByIdPutRequest.struct_class = Types::ApiSubjectsByIdEventByIdPutRequest

    ApiSubjectsByIdEventByIdPutResponse.add_member(:event, Shapes::ShapeRef.new(shape: Event, required: true, location_name: "Event"))
    ApiSubjectsByIdEventByIdPutResponse.struct_class = Types::ApiSubjectsByIdEventByIdPutResponse
    ApiSubjectsByIdEventByIdPutResponse[:payload] = :event
    ApiSubjectsByIdEventByIdPutResponse[:payload_member] = ApiSubjectsByIdEventByIdPutResponse.member(:event)

    ApiSubjectsByIdEventsGetRequest.add_member(:subject_id, Shapes::ShapeRef.new(shape: string, required: true, location: "uri", location_name: "subjectId"))
    ApiSubjectsByIdEventsGetRequest.struct_class = Types::ApiSubjectsByIdEventsGetRequest

    ApiSubjectsByIdEventsGetResponse.add_member(:events, Shapes::ShapeRef.new(shape: Events, required: true, location_name: "Events"))
    ApiSubjectsByIdEventsGetResponse.struct_class = Types::ApiSubjectsByIdEventsGetResponse
    ApiSubjectsByIdEventsGetResponse[:payload] = :events
    ApiSubjectsByIdEventsGetResponse[:payload_member] = ApiSubjectsByIdEventsGetResponse.member(:events)

    ApiSubjectsByIdEventsPostRequest.add_member(:subject_id, Shapes::ShapeRef.new(shape: string, required: true, location: "uri", location_name: "subjectId"))
    ApiSubjectsByIdEventsPostRequest.struct_class = Types::ApiSubjectsByIdEventsPostRequest

    ApiSubjectsByIdEventsPostResponse.add_member(:event, Shapes::ShapeRef.new(shape: Event, required: true, location_name: "Event"))
    ApiSubjectsByIdEventsPostResponse.struct_class = Types::ApiSubjectsByIdEventsPostResponse
    ApiSubjectsByIdEventsPostResponse[:payload] = :event
    ApiSubjectsByIdEventsPostResponse[:payload_member] = ApiSubjectsByIdEventsPostResponse.member(:event)

    ApiSubjectsByIdPutRequest.add_member(:subject_id, Shapes::ShapeRef.new(shape: string, required: true, location: "uri", location_name: "subjectId"))
    ApiSubjectsByIdPutRequest.struct_class = Types::ApiSubjectsByIdPutRequest

    ApiSubjectsByIdPutResponse.add_member(:subject, Shapes::ShapeRef.new(shape: Subject, required: true, location_name: "Subject"))
    ApiSubjectsByIdPutResponse.struct_class = Types::ApiSubjectsByIdPutResponse
    ApiSubjectsByIdPutResponse[:payload] = :subject
    ApiSubjectsByIdPutResponse[:payload_member] = ApiSubjectsByIdPutResponse.member(:subject)

    ApiSubjectsGetRequest.struct_class = Types::ApiSubjectsGetRequest

    ApiSubjectsGetResponse.add_member(:subject_list, Shapes::ShapeRef.new(shape: SubjectList, required: true, location_name: "SubjectList"))
    ApiSubjectsGetResponse.struct_class = Types::ApiSubjectsGetResponse
    ApiSubjectsGetResponse[:payload] = :subject_list
    ApiSubjectsGetResponse[:payload_member] = ApiSubjectsGetResponse.member(:subject_list)

    ApiSubjectsPostRequest.struct_class = Types::ApiSubjectsPostRequest

    ApiSubjectsPostResponse.add_member(:subject, Shapes::ShapeRef.new(shape: Subject, required: true, location_name: "Subject"))
    ApiSubjectsPostResponse.struct_class = Types::ApiSubjectsPostResponse
    ApiSubjectsPostResponse[:payload] = :subject
    ApiSubjectsPostResponse[:payload_member] = ApiSubjectsPostResponse.member(:subject)

    Attributes.add_member(:face_area, Shapes::ShapeRef.new(shape: FaceArea, location_name: "faceArea"))
    Attributes.add_member(:face_pan, Shapes::ShapeRef.new(shape: string, location_name: "facePan"))
    Attributes.add_member(:face_quality_score, Shapes::ShapeRef.new(shape: string, location_name: "faceQualityScore"))
    Attributes.add_member(:face_roll, Shapes::ShapeRef.new(shape: string, location_name: "faceRoll"))
    Attributes.add_member(:face_score, Shapes::ShapeRef.new(shape: string, location_name: "faceScore"))
    Attributes.add_member(:face_tilt, Shapes::ShapeRef.new(shape: string, location_name: "faceTilt"))
    Attributes.add_member(:frontal_face_score, Shapes::ShapeRef.new(shape: string, location_name: "frontalFaceScore"))
    Attributes.add_member(:head_area, Shapes::ShapeRef.new(shape: HeadArea, location_name: "headArea"))
    Attributes.add_member(:left_eye_center, Shapes::ShapeRef.new(shape: LeftEyeCenter, location_name: "leftEyeCenter"))
    Attributes.add_member(:right_eye_center, Shapes::ShapeRef.new(shape: RightEyeCenter, location_name: "rightEyeCenter"))
    Attributes.struct_class = Types::Attributes

    BulkRegisterRequest.struct_class = Types::BulkRegisterRequest

    BulkRegisterResponse.add_member(:job, Shapes::ShapeRef.new(shape: Job, required: true, location_name: "Job"))
    BulkRegisterResponse.struct_class = Types::BulkRegisterResponse
    BulkRegisterResponse[:payload] = :job
    BulkRegisterResponse[:payload_member] = BulkRegisterResponse.member(:job)

    Candidate.add_member(:events, Shapes::ShapeRef.new(shape: listOfEvent, location_name: "events"))
    Candidate.add_member(:id, Shapes::ShapeRef.new(shape: string, location_name: "id"))
    Candidate.add_member(:score, Shapes::ShapeRef.new(shape: integer, location_name: "score"))
    Candidate.struct_class = Types::Candidate

    CreateTagRequest.add_member(:name, Shapes::ShapeRef.new(shape: string, required: true, location: "uri", location_name: "name"))
    CreateTagRequest.struct_class = Types::CreateTagRequest

    CreateTagResponse.struct_class = Types::CreateTagResponse

    DeleteTagRequest.add_member(:name, Shapes::ShapeRef.new(shape: string, required: true, location: "uri", location_name: "name"))
    DeleteTagRequest.struct_class = Types::DeleteTagRequest

    DeleteTagResponse.struct_class = Types::DeleteTagResponse

    Event.add_member(:id, Shapes::ShapeRef.new(shape: string, location_name: "id"))
    Event.add_member(:score, Shapes::ShapeRef.new(shape: integer, location_name: "score"))
    Event.struct_class = Types::Event

    Events.add_member(:events, Shapes::ShapeRef.new(shape: listOfEvent, location_name: "events"))
    Events.struct_class = Types::Events

    ExtractResult.add_member(:faces, Shapes::ShapeRef.new(shape: listOfAttributes, location_name: "faces"))
    ExtractResult.struct_class = Types::ExtractResult

    FaceArea.add_member(:bottom, Shapes::ShapeRef.new(shape: string, location_name: "bottom"))
    FaceArea.add_member(:left, Shapes::ShapeRef.new(shape: string, location_name: "left"))
    FaceArea.add_member(:right, Shapes::ShapeRef.new(shape: string, location_name: "right"))
    FaceArea.add_member(:top, Shapes::ShapeRef.new(shape: string, location_name: "top"))
    FaceArea.struct_class = Types::FaceArea

    GetBulkRegisterProgressPagedRequest.add_member(:batch_id, Shapes::ShapeRef.new(shape: string, required: true, location: "uri", location_name: "batchId"))
    GetBulkRegisterProgressPagedRequest.add_member(:paging_id, Shapes::ShapeRef.new(shape: string, required: true, location: "querystring", location_name: "pagingId"))
    GetBulkRegisterProgressPagedRequest.struct_class = Types::GetBulkRegisterProgressPagedRequest

    GetBulkRegisterProgressPagedResponse.add_member(:job_summary, Shapes::ShapeRef.new(shape: JobSummary, required: true, location_name: "JobSummary"))
    GetBulkRegisterProgressPagedResponse.struct_class = Types::GetBulkRegisterProgressPagedResponse
    GetBulkRegisterProgressPagedResponse[:payload] = :job_summary
    GetBulkRegisterProgressPagedResponse[:payload_member] = GetBulkRegisterProgressPagedResponse.member(:job_summary)

    GetBulkRegisterProgressRequest.add_member(:batch_id, Shapes::ShapeRef.new(shape: string, required: true, location: "uri", location_name: "batchId"))
    GetBulkRegisterProgressRequest.struct_class = Types::GetBulkRegisterProgressRequest

    GetBulkRegisterProgressResponse.add_member(:job_summary, Shapes::ShapeRef.new(shape: JobSummary, required: true, location_name: "JobSummary"))
    GetBulkRegisterProgressResponse.struct_class = Types::GetBulkRegisterProgressResponse
    GetBulkRegisterProgressResponse[:payload] = :job_summary
    GetBulkRegisterProgressResponse[:payload_member] = GetBulkRegisterProgressResponse.member(:job_summary)

    GetHealthRequest.struct_class = Types::GetHealthRequest

    GetHealthResponse.struct_class = Types::GetHealthResponse

    GetRequest.struct_class = Types::GetRequest

    GetResponse.add_member(:tag, Shapes::ShapeRef.new(shape: Tag, required: true, location_name: "Tag"))
    GetResponse.struct_class = Types::GetResponse
    GetResponse[:payload] = :tag
    GetResponse[:payload_member] = GetResponse.member(:tag)

    HeadArea.add_member(:bottom, Shapes::ShapeRef.new(shape: string, location_name: "bottom"))
    HeadArea.add_member(:left, Shapes::ShapeRef.new(shape: string, location_name: "left"))
    HeadArea.add_member(:right, Shapes::ShapeRef.new(shape: string, location_name: "right"))
    HeadArea.add_member(:top, Shapes::ShapeRef.new(shape: string, location_name: "top"))
    HeadArea.struct_class = Types::HeadArea

    Job.add_member(:batch_id, Shapes::ShapeRef.new(shape: string, location_name: "batchId"))
    Job.struct_class = Types::Job

    JobStatus.add_member(:attempts, Shapes::ShapeRef.new(shape: integer, location_name: "attempts"))
    JobStatus.add_member(:attributes_json, Shapes::ShapeRef.new(shape: string, location_name: "attributesJson"))
    JobStatus.add_member(:event_id, Shapes::ShapeRef.new(shape: string, location_name: "eventId"))
    JobStatus.add_member(:filename, Shapes::ShapeRef.new(shape: string, location_name: "filename"))
    JobStatus.add_member(:id, Shapes::ShapeRef.new(shape: string, location_name: "id"))
    JobStatus.add_member(:reason, Shapes::ShapeRef.new(shape: string, location_name: "reason"))
    JobStatus.add_member(:register_status, Shapes::ShapeRef.new(shape: string, location_name: "registerStatus"))
    JobStatus.add_member(:status, Shapes::ShapeRef.new(shape: string, location_name: "status"))
    JobStatus.add_member(:subject_id, Shapes::ShapeRef.new(shape: string, location_name: "subjectId"))
    JobStatus.struct_class = Types::JobStatus

    JobSummary.add_member(:batch_id, Shapes::ShapeRef.new(shape: string, location_name: "batchId"))
    JobSummary.add_member(:last_evaluated_key, Shapes::ShapeRef.new(shape: string, location_name: "lastEvaluatedKey"))
    JobSummary.add_member(:processed, Shapes::ShapeRef.new(shape: listOfJobStatus, location_name: "processed"))
    JobSummary.struct_class = Types::JobSummary

    LeftEyeCenter.add_member(:x, Shapes::ShapeRef.new(shape: string, location_name: "x"))
    LeftEyeCenter.add_member(:y, Shapes::ShapeRef.new(shape: string, location_name: "y"))
    LeftEyeCenter.struct_class = Types::LeftEyeCenter

    RightEyeCenter.add_member(:x, Shapes::ShapeRef.new(shape: string, location_name: "x"))
    RightEyeCenter.add_member(:y, Shapes::ShapeRef.new(shape: string, location_name: "y"))
    RightEyeCenter.struct_class = Types::RightEyeCenter

    SearchResult.add_member(:attributes, Shapes::ShapeRef.new(shape: Attributes, location_name: "attributes"))
    SearchResult.add_member(:candidates, Shapes::ShapeRef.new(shape: listOfCandidate, location_name: "candidates"))
    SearchResult.struct_class = Types::SearchResult

    Subject.add_member(:attributes, Shapes::ShapeRef.new(shape: Attributes, location_name: "attributes"))
    Subject.add_member(:event_id, Shapes::ShapeRef.new(shape: string, location_name: "eventId"))
    Subject.add_member(:id, Shapes::ShapeRef.new(shape: string, location_name: "id"))
    Subject.struct_class = Types::Subject

    SubjectList.add_member(:subjects, Shapes::ShapeRef.new(shape: listOfSubject, location_name: "subjects"))
    SubjectList.add_member(:total, Shapes::ShapeRef.new(shape: integer, location_name: "total"))
    SubjectList.struct_class = Types::SubjectList

    Tag.add_member(:id, Shapes::ShapeRef.new(shape: integer, location_name: "id"))
    Tag.add_member(:name, Shapes::ShapeRef.new(shape: string, location_name: "name"))
    Tag.struct_class = Types::Tag

    UpdateTagRequest.add_member(:name, Shapes::ShapeRef.new(shape: string, required: true, location: "uri", location_name: "name"))
    UpdateTagRequest.struct_class = Types::UpdateTagRequest

    UpdateTagResponse.struct_class = Types::UpdateTagResponse

    listOfAttributes.member = Shapes::ShapeRef.new(shape: Attributes)

    listOfCandidate.member = Shapes::ShapeRef.new(shape: Candidate)

    listOfEvent.member = Shapes::ShapeRef.new(shape: Event)

    listOfJobStatus.member = Shapes::ShapeRef.new(shape: JobStatus)

    listOfSubject.member = Shapes::ShapeRef.new(shape: Subject)


    # @api private
    API = Seahorse::Model::Api.new.tap do |api|

      api.version = "1.1"

      api.metadata = {
        "apiVersion" => "1.1",
        "endpointPrefix" => "api",
        "protocol" => "api-gateway",
        "serviceFullName" => "Biometric API",
        "serviceId" => "Biometric API",
        "signatureVersion" => "v4",
        "signingName" => "execute-api",
        "uid" => "api-1.1",
      }

      api.add_operation(:api_face_extract_post, Seahorse::Model::Operation.new.tap do |o|
        o.name = "ApiFaceExtractPost"
        o.http_method = "POST"
        o.http_request_uri = "/v1.1/face/extract"
        o.input = Shapes::ShapeRef.new(shape: ApiFaceExtractPostRequest)
        o.output = Shapes::ShapeRef.new(shape: ApiFaceExtractPostResponse)
        o.errors << Shapes::ShapeRef.new(shape: NotFoundException)
      end)

      api.add_operation(:api_face_search_post, Seahorse::Model::Operation.new.tap do |o|
        o.name = "ApiFaceSearchPost"
        o.http_method = "POST"
        o.http_request_uri = "/v1.1/face/search"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: ApiFaceSearchPostRequest)
        o.output = Shapes::ShapeRef.new(shape: ApiFaceSearchPostResponse)
        o.errors << Shapes::ShapeRef.new(shape: NotFoundException)
      end)

      api.add_operation(:api_face_verify_post, Seahorse::Model::Operation.new.tap do |o|
        o.name = "ApiFaceVerifyPost"
        o.http_method = "POST"
        o.http_request_uri = "/v1.1/face/verify"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: ApiFaceVerifyPostRequest)
        o.output = Shapes::ShapeRef.new(shape: ApiFaceVerifyPostResponse)
        o.errors << Shapes::ShapeRef.new(shape: NotFoundException)
      end)

      api.add_operation(:api_subjects_by_id_delete, Seahorse::Model::Operation.new.tap do |o|
        o.name = "ApiSubjectsByIdDelete"
        o.http_method = "DELETE"
        o.http_request_uri = "/v1.1/subjects/{subjectId}"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: ApiSubjectsByIdDeleteRequest)
        o.output = Shapes::ShapeRef.new(shape: Shapes::StructureShape.new(struct_class: Aws::EmptyStructure))
        o.errors << Shapes::ShapeRef.new(shape: NotFoundException)
      end)

      api.add_operation(:api_subjects_by_id_event_by_id_delete, Seahorse::Model::Operation.new.tap do |o|
        o.name = "ApiSubjectsByIdEventByIdDelete"
        o.http_method = "DELETE"
        o.http_request_uri = "/v1.1/subjects/{subjectId}/events/{eventId}"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: ApiSubjectsByIdEventByIdDeleteRequest)
        o.output = Shapes::ShapeRef.new(shape: Shapes::StructureShape.new(struct_class: Aws::EmptyStructure))
        o.errors << Shapes::ShapeRef.new(shape: NotFoundException)
      end)

      api.add_operation(:api_subjects_by_id_event_by_id_put, Seahorse::Model::Operation.new.tap do |o|
        o.name = "ApiSubjectsByIdEventByIdPut"
        o.http_method = "PUT"
        o.http_request_uri = "/v1.1/subjects/{subjectId}/events/{eventId}"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: ApiSubjectsByIdEventByIdPutRequest)
        o.output = Shapes::ShapeRef.new(shape: ApiSubjectsByIdEventByIdPutResponse)
        o.errors << Shapes::ShapeRef.new(shape: NotFoundException)
      end)

      api.add_operation(:api_subjects_by_id_events_get, Seahorse::Model::Operation.new.tap do |o|
        o.name = "ApiSubjectsByIdEventsGet"
        o.http_method = "GET"
        o.http_request_uri = "/v1.1/subjects/{subjectId}/events"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: ApiSubjectsByIdEventsGetRequest)
        o.output = Shapes::ShapeRef.new(shape: ApiSubjectsByIdEventsGetResponse)
        o.errors << Shapes::ShapeRef.new(shape: NotFoundException)
      end)

      api.add_operation(:api_subjects_by_id_events_post, Seahorse::Model::Operation.new.tap do |o|
        o.name = "ApiSubjectsByIdEventsPost"
        o.http_method = "POST"
        o.http_request_uri = "/v1.1/subjects/{subjectId}/events"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: ApiSubjectsByIdEventsPostRequest)
        o.output = Shapes::ShapeRef.new(shape: ApiSubjectsByIdEventsPostResponse)
        o.errors << Shapes::ShapeRef.new(shape: NotFoundException)
      end)

      api.add_operation(:api_subjects_by_id_put, Seahorse::Model::Operation.new.tap do |o|
        o.name = "ApiSubjectsByIdPut"
        o.http_method = "PUT"
        o.http_request_uri = "/v1.1/subjects/{subjectId}"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: ApiSubjectsByIdPutRequest)
        o.output = Shapes::ShapeRef.new(shape: ApiSubjectsByIdPutResponse)
        o.errors << Shapes::ShapeRef.new(shape: NotFoundException)
      end)

      api.add_operation(:api_subjects_get, Seahorse::Model::Operation.new.tap do |o|
        o.name = "ApiSubjectsGet"
        o.http_method = "GET"
        o.http_request_uri = "/v1.1/subjects"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: ApiSubjectsGetRequest)
        o.output = Shapes::ShapeRef.new(shape: ApiSubjectsGetResponse)
      end)

      api.add_operation(:api_subjects_post, Seahorse::Model::Operation.new.tap do |o|
        o.name = "ApiSubjectsPost"
        o.http_method = "POST"
        o.http_request_uri = "/v1.1/subjects"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: ApiSubjectsPostRequest)
        o.output = Shapes::ShapeRef.new(shape: ApiSubjectsPostResponse)
      end)

      api.add_operation(:bulk_register, Seahorse::Model::Operation.new.tap do |o|
        o.name = "BulkRegister"
        o.http_method = "POST"
        o.http_request_uri = "/v1.1/jobs/bulkregister"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: BulkRegisterRequest)
        o.output = Shapes::ShapeRef.new(shape: BulkRegisterResponse)
      end)

      api.add_operation(:create_tag, Seahorse::Model::Operation.new.tap do |o|
        o.name = "CreateTag"
        o.http_method = "POST"
        o.http_request_uri = "/v1.1/tags/{name}"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: CreateTagRequest)
        o.output = Shapes::ShapeRef.new(shape: CreateTagResponse)
      end)

      api.add_operation(:delete_tag, Seahorse::Model::Operation.new.tap do |o|
        o.name = "DeleteTag"
        o.http_method = "DELETE"
        o.http_request_uri = "/v1.1/tags/{name}"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: DeleteTagRequest)
        o.output = Shapes::ShapeRef.new(shape: DeleteTagResponse)
      end)

      api.add_operation(:get, Seahorse::Model::Operation.new.tap do |o|
        o.name = "Get"
        o.http_method = "GET"
        o.http_request_uri = "/v1.1/tags"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: GetRequest)
        o.output = Shapes::ShapeRef.new(shape: GetResponse)
      end)

      api.add_operation(:get_bulk_register_progress, Seahorse::Model::Operation.new.tap do |o|
        o.name = "GetBulkRegisterProgress"
        o.http_method = "GET"
        o.http_request_uri = "/v1.1/jobs/bulkregister/{batchId}"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: GetBulkRegisterProgressRequest)
        o.output = Shapes::ShapeRef.new(shape: GetBulkRegisterProgressResponse)
      end)

      api.add_operation(:get_bulk_register_progress_paged, Seahorse::Model::Operation.new.tap do |o|
        o.name = "GetBulkRegisterProgressPaged"
        o.http_method = "GET"
        o.http_request_uri = "/v1.1/jobs/bulkregister/{batchId}/{pagingId}"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: GetBulkRegisterProgressPagedRequest)
        o.output = Shapes::ShapeRef.new(shape: GetBulkRegisterProgressPagedResponse)
      end)

      api.add_operation(:get_health, Seahorse::Model::Operation.new.tap do |o|
        o.name = "GetHealth"
        o.http_method = "GET"
        o.http_request_uri = "/v1.1/health"
        o['authtype'] = "none"
        o.input = Shapes::ShapeRef.new(shape: GetHealthRequest)
        o.output = Shapes::ShapeRef.new(shape: GetHealthResponse)
      end)

      api.add_operation(:update_tag, Seahorse::Model::Operation.new.tap do |o|
        o.name = "UpdateTag"
        o.http_method = "PUT"
        o.http_request_uri = "/v1.1/tags/{name}"
        o.require_apikey = true
        o.input = Shapes::ShapeRef.new(shape: UpdateTagRequest)
        o.output = Shapes::ShapeRef.new(shape: UpdateTagResponse)
      end)
    end

  end
end
