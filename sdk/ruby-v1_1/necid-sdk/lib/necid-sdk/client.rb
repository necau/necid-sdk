require 'seahorse/client/plugins/content_length.rb'
require 'aws-sdk-core/plugins/logging.rb'
require 'aws-sdk-core/plugins/param_converter.rb'
require 'aws-sdk-core/plugins/param_validator.rb'
require 'aws-sdk-core/plugins/helpful_socket_errors.rb'
require 'aws-sdk-core/plugins/retry_errors.rb'
require 'aws-sdk-core/plugins/global_configuration.rb'
require 'aws-sdk-core/plugins/response_paging.rb'
require 'aws-sdk-core/plugins/stub_responses.rb'
require 'aws-sdk-core/plugins/idempotency_token.rb'
require 'aws-sdk-core/plugins/jsonvalue_converter.rb'
require 'aws-sdk-core/plugins/client_metrics_plugin.rb'
require 'aws-sdk-core/plugins/client_metrics_send_plugin.rb'
require 'aws-sdk-core/plugins/signature_v4.rb'
require 'aws-sdk-core/plugins/protocols/api_gateway.rb'
require 'aws-sdk-core/plugins/api_key.rb'
require 'aws-sdk-core/plugins/apig_user_agent.rb'
require 'aws-sdk-core/plugins/apig_authorizer_token.rb'
require 'aws-sdk-core/plugins/apig_credentials_configuration.rb'
require 'necid-sdk/plugins/authorizer.rb'
require 'necid-sdk/plugins/apig_endpoint.rb'

Aws::Plugins::GlobalConfiguration.add_identifier(:necid)

module NECID
  class Client < Seahorse::Client::Base

    include Aws::ClientStubs

    @identifier = :necid

    set_api(ClientApi::API)

    add_plugin(Seahorse::Client::Plugins::ContentLength)
    add_plugin(Aws::Plugins::Logging)
    add_plugin(Aws::Plugins::ParamConverter)
    add_plugin(Aws::Plugins::ParamValidator)
    add_plugin(Aws::Plugins::HelpfulSocketErrors)
    add_plugin(Aws::Plugins::RetryErrors)
    add_plugin(Aws::Plugins::GlobalConfiguration)
    add_plugin(Aws::Plugins::ResponsePaging)
    add_plugin(Aws::Plugins::StubResponses)
    add_plugin(Aws::Plugins::IdempotencyToken)
    add_plugin(Aws::Plugins::JsonvalueConverter)
    add_plugin(Aws::Plugins::ClientMetricsPlugin)
    add_plugin(Aws::Plugins::ClientMetricsSendPlugin)
    add_plugin(Aws::Plugins::SignatureV4)
    add_plugin(Aws::Plugins::Protocols::ApiGateway)
    add_plugin(Aws::Plugins::ApiKey)
    add_plugin(Aws::Plugins::APIGUserAgent)
    add_plugin(Aws::Plugins::APIGAuthorizerToken)
    add_plugin(Aws::Plugins::APIGCredentialsConfiguration)
    add_plugin(NECID::Plugins::Authorizer)
    add_plugin(NECID::Plugins::APIGEndpoint)

    # @overload initialize(options)
    #   @param [Hash] options
    #   @option options [String] :access_key_id
    #
    #   @option options [String] :api_key
    #     When provided, `x-api-key` header will be injected with the value provided.
    #
    #   @option options [Boolean] :client_side_monitoring (false)
    #     When `true`, client-side metrics will be collected for all API requests from
    #     this client.
    #
    #   @option options [String] :client_side_monitoring_client_id ("")
    #     Allows you to provide an identifier for this client which will be attached to
    #     all generated client side metrics. Defaults to an empty string.
    #
    #   @option options [Integer] :client_side_monitoring_port (31000)
    #     Required for publishing client metrics. The port that the client side monitoring
    #     agent is running on, where client metrics will be published via UDP.
    #
    #   @option options [Aws::ClientSideMonitoring::Publisher] :client_side_monitoring_publisher (Aws::ClientSideMonitoring::Publisher)
    #     Allows you to provide a custom client-side monitoring publisher class. By default,
    #     will use the Client Side Monitoring Agent Publisher.
    #
    #   @option options [Boolean] :convert_params (true)
    #     When `true`, an attempt is made to coerce request parameters into
    #     the required types.
    #
    #   @option options [Aws::CredentialProvider] :credentials
    #     AWS Credentials options is only required when your API uses
    #     [AWS Signature Version 4](http://docs.aws.amazon.com/general/latest/gr/signature-version-4.html),
    #     more AWS Credentials Configuration Options are available [here](https://github.com/aws/aws-sdk-ruby#configuration).
    #
    #   @option options [Aws::Log::Formatter] :log_formatter (Aws::Log::Formatter.default)
    #     The log formatter.
    #
    #   @option options [Symbol] :log_level (:info)
    #     The log level to send messages to the `:logger` at.
    #
    #   @option options [Logger] :logger
    #     The Logger instance to send log messages to.  If this option
    #     is not set, logging will be disabled.
    #
    #   @option options [String] :profile
    #
    #   @option options [Float] :retry_base_delay (0.3)
    #     The base delay in seconds used by the default backoff function.
    #
    #   @option options [Symbol] :retry_jitter (:none)
    #     A delay randomiser function used by the default backoff function. Some predefined functions can be referenced by name - :none, :equal, :full, otherwise a Proc that takes and returns a number.
    #
    #     @see https://www.awsarchitectureblog.com/2015/03/backoff.html
    #
    #   @option options [Integer] :retry_limit (3)
    #     The maximum number of times to retry failed requests.  Only
    #     ~ 500 level server errors and certain ~ 400 level client errors
    #     are retried.  Generally, these are throttling errors, data
    #     checksum errors, networking errors, timeout errors and auth
    #     errors from expired credentials.
    #
    #   @option options [Integer] :retry_max_delay (0)
    #     The maximum number of seconds to delay between retries (0 for no limit) used by the default backoff function.
    #
    #   @option options [String] :secret_access_key
    #
    #   @option options [String] :session_token
    #
    #   @option options [Boolean] :stub_responses (false)
    #     Causes the client to return stubbed responses. By default
    #     fake responses are generated and returned. You can specify
    #     the response data to return or errors to raise by calling
    #     {ClientStubs#stub_responses}. See {ClientStubs} for more information.
    #
    #     ** Please note ** When response stubbing is enabled, no HTTP
    #     requests are made, and retries are disabled.
    #
    #   @option options [Boolean] :validate_params (true)
    #     When `true`, request parameters are validated before
    #     sending the request.
    #
    #   @option options [URI::HTTP,String] :http_proxy A proxy to send
    #     requests through.  Formatted like 'http://proxy.com:123'.
    #
    #   @option options [Float] :http_open_timeout (15) The number of
    #     seconds to wait when opening a HTTP session before rasing a
    #     `Timeout::Error`.
    #
    #   @option options [Integer] :http_read_timeout (60) The default
    #     number of seconds to wait for response data.  This value can
    #     safely be set
    #     per-request on the session yeidled by {#session_for}.
    #
    #   @option options [Float] :http_idle_timeout (5) The number of
    #     seconds a connection is allowed to sit idble before it is
    #     considered stale.  Stale connections are closed and removed
    #     from the pool before making a request.
    #
    #   @option options [Float] :http_continue_timeout (1) The number of
    #     seconds to wait for a 100-continue response before sending the
    #     request body.  This option has no effect unless the request has
    #     "Expect" header set to "100-continue".  Defaults to `nil` which
    #     disables this behaviour.  This value can safely be set per
    #     request on the session yeidled by {#session_for}.
    #
    #   @option options [Boolean] :http_wire_trace (false) When `true`,
    #     HTTP debug output will be sent to the `:logger`.
    #
    #   @option options [Boolean] :ssl_verify_peer (true) When `true`,
    #     SSL peer certificates are verified when establishing a
    #     connection.
    #
    #   @option options [String] :ssl_ca_bundle Full path to the SSL
    #     certificate authority bundle file that should be used when
    #     verifying peer certificates.  If you do not pass
    #     `:ssl_ca_bundle` or `:ssl_ca_directory` the the system default
    #     will be used if available.
    #
    #   @option options [String] :ssl_ca_directory Full path of the
    #     directory that contains the unbundled SSL certificate
    #     authority files for verifying peer certificates.  If you do
    #     not pass `:ssl_ca_bundle` or `:ssl_ca_directory` the the
    #     system default will be used if available.
    #
    def initialize(*args)
      super
    end

    # @!group API Operations

    # @return [Types::ApiFaceExtractPostResponse] Returns a {Seahorse::Client::Response response} object which responds to the following methods:
    #
    #   * {Types::ApiFaceExtractPostResponse#extract_result #extract_result} => Types::ExtractResult
    #
    # @example Response structure
    #
    #   resp.extract_result.faces #=> Array
    #   resp.extract_result.faces[0].face_area.bottom #=> String
    #   resp.extract_result.faces[0].face_area.left #=> String
    #   resp.extract_result.faces[0].face_area.right #=> String
    #   resp.extract_result.faces[0].face_area.top #=> String
    #   resp.extract_result.faces[0].face_pan #=> String
    #   resp.extract_result.faces[0].face_quality_score #=> String
    #   resp.extract_result.faces[0].face_roll #=> String
    #   resp.extract_result.faces[0].face_score #=> String
    #   resp.extract_result.faces[0].face_tilt #=> String
    #   resp.extract_result.faces[0].frontal_face_score #=> String
    #   resp.extract_result.faces[0].head_area.bottom #=> String
    #   resp.extract_result.faces[0].head_area.left #=> String
    #   resp.extract_result.faces[0].head_area.right #=> String
    #   resp.extract_result.faces[0].head_area.top #=> String
    #   resp.extract_result.faces[0].left_eye_center.x #=> String
    #   resp.extract_result.faces[0].left_eye_center.y #=> String
    #   resp.extract_result.faces[0].right_eye_center.x #=> String
    #   resp.extract_result.faces[0].right_eye_center.y #=> String
    #
    # @overload api_face_extract_post(params = {})
    # @param [Hash] params ({})
    def api_face_extract_post(params = {}, options = {})
      req = build_request(:api_face_extract_post, params)
      req.send_request(options)
    end

    # @return [Types::ApiFaceSearchPostResponse] Returns a {Seahorse::Client::Response response} object which responds to the following methods:
    #
    #   * {Types::ApiFaceSearchPostResponse#search_result #search_result} => Types::SearchResult
    #
    # @example Response structure
    #
    #   resp.search_result.attributes.face_area.bottom #=> String
    #   resp.search_result.attributes.face_area.left #=> String
    #   resp.search_result.attributes.face_area.right #=> String
    #   resp.search_result.attributes.face_area.top #=> String
    #   resp.search_result.attributes.face_pan #=> String
    #   resp.search_result.attributes.face_quality_score #=> String
    #   resp.search_result.attributes.face_roll #=> String
    #   resp.search_result.attributes.face_score #=> String
    #   resp.search_result.attributes.face_tilt #=> String
    #   resp.search_result.attributes.frontal_face_score #=> String
    #   resp.search_result.attributes.head_area.bottom #=> String
    #   resp.search_result.attributes.head_area.left #=> String
    #   resp.search_result.attributes.head_area.right #=> String
    #   resp.search_result.attributes.head_area.top #=> String
    #   resp.search_result.attributes.left_eye_center.x #=> String
    #   resp.search_result.attributes.left_eye_center.y #=> String
    #   resp.search_result.attributes.right_eye_center.x #=> String
    #   resp.search_result.attributes.right_eye_center.y #=> String
    #   resp.search_result.candidates #=> Array
    #   resp.search_result.candidates[0].events #=> Array
    #   resp.search_result.candidates[0].events[0].id #=> String
    #   resp.search_result.candidates[0].events[0].score #=> Integer
    #   resp.search_result.candidates[0].id #=> String
    #   resp.search_result.candidates[0].score #=> Integer
    #
    # @overload api_face_search_post(params = {})
    # @param [Hash] params ({})
    def api_face_search_post(params = {}, options = {})
      req = build_request(:api_face_search_post, params)
      req.send_request(options)
    end

    # @return [Types::ApiFaceVerifyPostResponse] Returns a {Seahorse::Client::Response response} object which responds to the following methods:
    #
    #   * {Types::ApiFaceVerifyPostResponse#candidate #candidate} => Types::Candidate
    #
    # @example Response structure
    #
    #   resp.candidate.events #=> Array
    #   resp.candidate.events[0].id #=> String
    #   resp.candidate.events[0].score #=> Integer
    #   resp.candidate.id #=> String
    #   resp.candidate.score #=> Integer
    #
    # @overload api_face_verify_post(params = {})
    # @param [Hash] params ({})
    def api_face_verify_post(params = {}, options = {})
      req = build_request(:api_face_verify_post, params)
      req.send_request(options)
    end

    # @option params [required, String] :subject_id
    #
    # @return [Struct] Returns an empty {Seahorse::Client::Response response}.
    #
    # @example Request syntax with placeholder values
    #
    #   resp = client.api_subjects_by_id_delete({
    #     subject_id: "__string", # required
    #   })
    #
    # @overload api_subjects_by_id_delete(params = {})
    # @param [Hash] params ({})
    def api_subjects_by_id_delete(params = {}, options = {})
      req = build_request(:api_subjects_by_id_delete, params)
      req.send_request(options)
    end

    # @option params [required, String] :event_id
    #
    # @option params [required, String] :subject_id
    #
    # @return [Struct] Returns an empty {Seahorse::Client::Response response}.
    #
    # @example Request syntax with placeholder values
    #
    #   resp = client.api_subjects_by_id_event_by_id_delete({
    #     event_id: "__string", # required
    #     subject_id: "__string", # required
    #   })
    #
    # @overload api_subjects_by_id_event_by_id_delete(params = {})
    # @param [Hash] params ({})
    def api_subjects_by_id_event_by_id_delete(params = {}, options = {})
      req = build_request(:api_subjects_by_id_event_by_id_delete, params)
      req.send_request(options)
    end

    # @option params [required, String] :event_id
    #
    # @option params [required, String] :subject_id
    #
    # @return [Types::ApiSubjectsByIdEventByIdPutResponse] Returns a {Seahorse::Client::Response response} object which responds to the following methods:
    #
    #   * {Types::ApiSubjectsByIdEventByIdPutResponse#event #event} => Types::Event
    #
    # @example Request syntax with placeholder values
    #
    #   resp = client.api_subjects_by_id_event_by_id_put({
    #     event_id: "__string", # required
    #     subject_id: "__string", # required
    #   })
    #
    # @example Response structure
    #
    #   resp.event.id #=> String
    #   resp.event.score #=> Integer
    #
    # @overload api_subjects_by_id_event_by_id_put(params = {})
    # @param [Hash] params ({})
    def api_subjects_by_id_event_by_id_put(params = {}, options = {})
      req = build_request(:api_subjects_by_id_event_by_id_put, params)
      req.send_request(options)
    end

    # @option params [required, String] :subject_id
    #
    # @return [Types::ApiSubjectsByIdEventsGetResponse] Returns a {Seahorse::Client::Response response} object which responds to the following methods:
    #
    #   * {Types::ApiSubjectsByIdEventsGetResponse#events #events} => Types::Events
    #
    # @example Request syntax with placeholder values
    #
    #   resp = client.api_subjects_by_id_events_get({
    #     subject_id: "__string", # required
    #   })
    #
    # @example Response structure
    #
    #   resp.events.events #=> Array
    #   resp.events.events[0].id #=> String
    #   resp.events.events[0].score #=> Integer
    #
    # @overload api_subjects_by_id_events_get(params = {})
    # @param [Hash] params ({})
    def api_subjects_by_id_events_get(params = {}, options = {})
      req = build_request(:api_subjects_by_id_events_get, params)
      req.send_request(options)
    end

    # @option params [required, String] :subject_id
    #
    # @return [Types::ApiSubjectsByIdEventsPostResponse] Returns a {Seahorse::Client::Response response} object which responds to the following methods:
    #
    #   * {Types::ApiSubjectsByIdEventsPostResponse#event #event} => Types::Event
    #
    # @example Request syntax with placeholder values
    #
    #   resp = client.api_subjects_by_id_events_post({
    #     subject_id: "__string", # required
    #   })
    #
    # @example Response structure
    #
    #   resp.event.id #=> String
    #   resp.event.score #=> Integer
    #
    # @overload api_subjects_by_id_events_post(params = {})
    # @param [Hash] params ({})
    def api_subjects_by_id_events_post(params = {}, options = {})
      req = build_request(:api_subjects_by_id_events_post, params)
      req.send_request(options)
    end

    # @option params [required, String] :subject_id
    #
    # @return [Types::ApiSubjectsByIdPutResponse] Returns a {Seahorse::Client::Response response} object which responds to the following methods:
    #
    #   * {Types::ApiSubjectsByIdPutResponse#subject #subject} => Types::Subject
    #
    # @example Request syntax with placeholder values
    #
    #   resp = client.api_subjects_by_id_put({
    #     subject_id: "__string", # required
    #   })
    #
    # @example Response structure
    #
    #   resp.subject.attributes.face_area.bottom #=> String
    #   resp.subject.attributes.face_area.left #=> String
    #   resp.subject.attributes.face_area.right #=> String
    #   resp.subject.attributes.face_area.top #=> String
    #   resp.subject.attributes.face_pan #=> String
    #   resp.subject.attributes.face_quality_score #=> String
    #   resp.subject.attributes.face_roll #=> String
    #   resp.subject.attributes.face_score #=> String
    #   resp.subject.attributes.face_tilt #=> String
    #   resp.subject.attributes.frontal_face_score #=> String
    #   resp.subject.attributes.head_area.bottom #=> String
    #   resp.subject.attributes.head_area.left #=> String
    #   resp.subject.attributes.head_area.right #=> String
    #   resp.subject.attributes.head_area.top #=> String
    #   resp.subject.attributes.left_eye_center.x #=> String
    #   resp.subject.attributes.left_eye_center.y #=> String
    #   resp.subject.attributes.right_eye_center.x #=> String
    #   resp.subject.attributes.right_eye_center.y #=> String
    #   resp.subject.event_id #=> String
    #   resp.subject.id #=> String
    #
    # @overload api_subjects_by_id_put(params = {})
    # @param [Hash] params ({})
    def api_subjects_by_id_put(params = {}, options = {})
      req = build_request(:api_subjects_by_id_put, params)
      req.send_request(options)
    end

    # @return [Types::ApiSubjectsGetResponse] Returns a {Seahorse::Client::Response response} object which responds to the following methods:
    #
    #   * {Types::ApiSubjectsGetResponse#subject_list #subject_list} => Types::SubjectList
    #
    # @example Response structure
    #
    #   resp.subject_list.subjects #=> Array
    #   resp.subject_list.subjects[0].attributes.face_area.bottom #=> String
    #   resp.subject_list.subjects[0].attributes.face_area.left #=> String
    #   resp.subject_list.subjects[0].attributes.face_area.right #=> String
    #   resp.subject_list.subjects[0].attributes.face_area.top #=> String
    #   resp.subject_list.subjects[0].attributes.face_pan #=> String
    #   resp.subject_list.subjects[0].attributes.face_quality_score #=> String
    #   resp.subject_list.subjects[0].attributes.face_roll #=> String
    #   resp.subject_list.subjects[0].attributes.face_score #=> String
    #   resp.subject_list.subjects[0].attributes.face_tilt #=> String
    #   resp.subject_list.subjects[0].attributes.frontal_face_score #=> String
    #   resp.subject_list.subjects[0].attributes.head_area.bottom #=> String
    #   resp.subject_list.subjects[0].attributes.head_area.left #=> String
    #   resp.subject_list.subjects[0].attributes.head_area.right #=> String
    #   resp.subject_list.subjects[0].attributes.head_area.top #=> String
    #   resp.subject_list.subjects[0].attributes.left_eye_center.x #=> String
    #   resp.subject_list.subjects[0].attributes.left_eye_center.y #=> String
    #   resp.subject_list.subjects[0].attributes.right_eye_center.x #=> String
    #   resp.subject_list.subjects[0].attributes.right_eye_center.y #=> String
    #   resp.subject_list.subjects[0].event_id #=> String
    #   resp.subject_list.subjects[0].id #=> String
    #   resp.subject_list.total #=> Integer
    #
    # @overload api_subjects_get(params = {})
    # @param [Hash] params ({})
    def api_subjects_get(params = {}, options = {})
      req = build_request(:api_subjects_get, params)
      req.send_request(options)
    end

    # @return [Types::ApiSubjectsPostResponse] Returns a {Seahorse::Client::Response response} object which responds to the following methods:
    #
    #   * {Types::ApiSubjectsPostResponse#subject #subject} => Types::Subject
    #
    # @example Response structure
    #
    #   resp.subject.attributes.face_area.bottom #=> String
    #   resp.subject.attributes.face_area.left #=> String
    #   resp.subject.attributes.face_area.right #=> String
    #   resp.subject.attributes.face_area.top #=> String
    #   resp.subject.attributes.face_pan #=> String
    #   resp.subject.attributes.face_quality_score #=> String
    #   resp.subject.attributes.face_roll #=> String
    #   resp.subject.attributes.face_score #=> String
    #   resp.subject.attributes.face_tilt #=> String
    #   resp.subject.attributes.frontal_face_score #=> String
    #   resp.subject.attributes.head_area.bottom #=> String
    #   resp.subject.attributes.head_area.left #=> String
    #   resp.subject.attributes.head_area.right #=> String
    #   resp.subject.attributes.head_area.top #=> String
    #   resp.subject.attributes.left_eye_center.x #=> String
    #   resp.subject.attributes.left_eye_center.y #=> String
    #   resp.subject.attributes.right_eye_center.x #=> String
    #   resp.subject.attributes.right_eye_center.y #=> String
    #   resp.subject.event_id #=> String
    #   resp.subject.id #=> String
    #
    # @overload api_subjects_post(params = {})
    # @param [Hash] params ({})
    def api_subjects_post(params = {}, options = {})
      req = build_request(:api_subjects_post, params)
      req.send_request(options)
    end

    # @return [Types::BulkRegisterResponse] Returns a {Seahorse::Client::Response response} object which responds to the following methods:
    #
    #   * {Types::BulkRegisterResponse#job #job} => Types::Job
    #
    # @example Response structure
    #
    #   resp.job.batch_id #=> String
    #
    # @overload bulk_register(params = {})
    # @param [Hash] params ({})
    def bulk_register(params = {}, options = {})
      req = build_request(:bulk_register, params)
      req.send_request(options)
    end

    # @option params [required, String] :name
    #
    # @return [Struct] Returns an empty {Seahorse::Client::Response response}.
    #
    # @example Request syntax with placeholder values
    #
    #   resp = client.create_tag({
    #     name: "__string", # required
    #   })
    #
    # @overload create_tag(params = {})
    # @param [Hash] params ({})
    def create_tag(params = {}, options = {})
      req = build_request(:create_tag, params)
      req.send_request(options)
    end

    # @option params [required, String] :name
    #
    # @return [Struct] Returns an empty {Seahorse::Client::Response response}.
    #
    # @example Request syntax with placeholder values
    #
    #   resp = client.delete_tag({
    #     name: "__string", # required
    #   })
    #
    # @overload delete_tag(params = {})
    # @param [Hash] params ({})
    def delete_tag(params = {}, options = {})
      req = build_request(:delete_tag, params)
      req.send_request(options)
    end

    # @return [Types::GetResponse] Returns a {Seahorse::Client::Response response} object which responds to the following methods:
    #
    #   * {Types::GetResponse#tag #tag} => Types::Tag
    #
    # @example Response structure
    #
    #   resp.tag.id #=> Integer
    #   resp.tag.name #=> String
    #
    # @overload get(params = {})
    # @param [Hash] params ({})
    def get(params = {}, options = {})
      req = build_request(:get, params)
      req.send_request(options)
    end

    # @option params [required, String] :batch_id
    #
    # @return [Types::GetBulkRegisterProgressResponse] Returns a {Seahorse::Client::Response response} object which responds to the following methods:
    #
    #   * {Types::GetBulkRegisterProgressResponse#job_summary #job_summary} => Types::JobSummary
    #
    # @example Request syntax with placeholder values
    #
    #   resp = client.get_bulk_register_progress({
    #     batch_id: "__string", # required
    #   })
    #
    # @example Response structure
    #
    #   resp.job_summary.batch_id #=> String
    #   resp.job_summary.last_evaluated_key #=> String
    #   resp.job_summary.processed #=> Array
    #   resp.job_summary.processed[0].attempts #=> Integer
    #   resp.job_summary.processed[0].attributes_json #=> String
    #   resp.job_summary.processed[0].event_id #=> String
    #   resp.job_summary.processed[0].filename #=> String
    #   resp.job_summary.processed[0].id #=> String
    #   resp.job_summary.processed[0].reason #=> String
    #   resp.job_summary.processed[0].register_status #=> String
    #   resp.job_summary.processed[0].status #=> String
    #   resp.job_summary.processed[0].subject_id #=> String
    #
    # @overload get_bulk_register_progress(params = {})
    # @param [Hash] params ({})
    def get_bulk_register_progress(params = {}, options = {})
      req = build_request(:get_bulk_register_progress, params)
      req.send_request(options)
    end

    # @option params [required, String] :batch_id
    #
    # @option params [required, String] :paging_id
    #
    # @return [Types::GetBulkRegisterProgressPagedResponse] Returns a {Seahorse::Client::Response response} object which responds to the following methods:
    #
    #   * {Types::GetBulkRegisterProgressPagedResponse#job_summary #job_summary} => Types::JobSummary
    #
    # @example Request syntax with placeholder values
    #
    #   resp = client.get_bulk_register_progress_paged({
    #     batch_id: "__string", # required
    #     paging_id: "__string", # required
    #   })
    #
    # @example Response structure
    #
    #   resp.job_summary.batch_id #=> String
    #   resp.job_summary.last_evaluated_key #=> String
    #   resp.job_summary.processed #=> Array
    #   resp.job_summary.processed[0].attempts #=> Integer
    #   resp.job_summary.processed[0].attributes_json #=> String
    #   resp.job_summary.processed[0].event_id #=> String
    #   resp.job_summary.processed[0].filename #=> String
    #   resp.job_summary.processed[0].id #=> String
    #   resp.job_summary.processed[0].reason #=> String
    #   resp.job_summary.processed[0].register_status #=> String
    #   resp.job_summary.processed[0].status #=> String
    #   resp.job_summary.processed[0].subject_id #=> String
    #
    # @overload get_bulk_register_progress_paged(params = {})
    # @param [Hash] params ({})
    def get_bulk_register_progress_paged(params = {}, options = {})
      req = build_request(:get_bulk_register_progress_paged, params)
      req.send_request(options)
    end

    # @return [Struct] Returns an empty {Seahorse::Client::Response response}.
    #
    # @overload get_health(params = {})
    # @param [Hash] params ({})
    def get_health(params = {}, options = {})
      req = build_request(:get_health, params)
      req.send_request(options)
    end

    # @option params [required, String] :name
    #
    # @return [Struct] Returns an empty {Seahorse::Client::Response response}.
    #
    # @example Request syntax with placeholder values
    #
    #   resp = client.update_tag({
    #     name: "__string", # required
    #   })
    #
    # @overload update_tag(params = {})
    # @param [Hash] params ({})
    def update_tag(params = {}, options = {})
      req = build_request(:update_tag, params)
      req.send_request(options)
    end

    # @!endgroup

    # @param params ({})
    # @api private
    def build_request(operation_name, params = {})
      handlers = @handlers.for(operation_name)
      authorizer = nil
      if config.api.operation(operation_name).authorizer
        authorizer_name = config.api.operation(operation_name).authorizer
        config.api.authorizers.each do |_, auth|
          authorizer = auth if auth.name == authorizer_name
        end
      end
      context = Seahorse::Client::RequestContext.new(
        operation_name: operation_name,
        operation: config.api.operation(operation_name),
        authorizer: authorizer,
        client: self,
        params: params,
        config: config)
      context[:gem_name] = 'necid-sdk'
      context[:gem_version] = '1.0.0'
      Seahorse::Client::Request.new(handlers, context)
    end

    # @api private
    # @deprecated
    def waiter_names
      []
    end

    class << self

      # @api private
      attr_reader :identifier

      # @api private
      def errors_module
        Errors
      end

    end
  end
end
