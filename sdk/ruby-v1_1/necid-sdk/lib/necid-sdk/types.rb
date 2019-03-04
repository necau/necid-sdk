module NECID
  module Types

    # @api private
    #
    class ApiFaceExtractPostRequest < Aws::EmptyStructure; end

    # @!attribute [rw] extract_result
    #   @return [Types::ExtractResult]
    #
    class ApiFaceExtractPostResponse < Struct.new(
      :extract_result)
      include Aws::Structure
    end

    # @api private
    #
    class ApiFaceSearchPostRequest < Aws::EmptyStructure; end

    # @!attribute [rw] search_result
    #   @return [Types::SearchResult]
    #
    class ApiFaceSearchPostResponse < Struct.new(
      :search_result)
      include Aws::Structure
    end

    # @api private
    #
    class ApiFaceVerifyPostRequest < Aws::EmptyStructure; end

    # @!attribute [rw] candidate
    #   @return [Types::Candidate]
    #
    class ApiFaceVerifyPostResponse < Struct.new(
      :candidate)
      include Aws::Structure
    end

    # @note When making an API call, you may pass ApiSubjectsByIdDeleteRequest
    #   data as a hash:
    #
    #       {
    #         subject_id: "__string", # required
    #       }
    #
    # @!attribute [rw] subject_id
    #   @return [String]
    #
    class ApiSubjectsByIdDeleteRequest < Struct.new(
      :subject_id)
      include Aws::Structure
    end

    # @note When making an API call, you may pass ApiSubjectsByIdEventByIdDeleteRequest
    #   data as a hash:
    #
    #       {
    #         event_id: "__string", # required
    #         subject_id: "__string", # required
    #       }
    #
    # @!attribute [rw] event_id
    #   @return [String]
    #
    # @!attribute [rw] subject_id
    #   @return [String]
    #
    class ApiSubjectsByIdEventByIdDeleteRequest < Struct.new(
      :event_id,
      :subject_id)
      include Aws::Structure
    end

    # @note When making an API call, you may pass ApiSubjectsByIdEventByIdPutRequest
    #   data as a hash:
    #
    #       {
    #         event_id: "__string", # required
    #         subject_id: "__string", # required
    #       }
    #
    # @!attribute [rw] event_id
    #   @return [String]
    #
    # @!attribute [rw] subject_id
    #   @return [String]
    #
    class ApiSubjectsByIdEventByIdPutRequest < Struct.new(
      :event_id,
      :subject_id)
      include Aws::Structure
    end

    # @!attribute [rw] event
    #   @return [Types::Event]
    #
    class ApiSubjectsByIdEventByIdPutResponse < Struct.new(
      :event)
      include Aws::Structure
    end

    # @note When making an API call, you may pass ApiSubjectsByIdEventsGetRequest
    #   data as a hash:
    #
    #       {
    #         subject_id: "__string", # required
    #       }
    #
    # @!attribute [rw] subject_id
    #   @return [String]
    #
    class ApiSubjectsByIdEventsGetRequest < Struct.new(
      :subject_id)
      include Aws::Structure
    end

    # @!attribute [rw] events
    #   @return [Types::Events]
    #
    class ApiSubjectsByIdEventsGetResponse < Struct.new(
      :events)
      include Aws::Structure
    end

    # @note When making an API call, you may pass ApiSubjectsByIdEventsPostRequest
    #   data as a hash:
    #
    #       {
    #         subject_id: "__string", # required
    #       }
    #
    # @!attribute [rw] subject_id
    #   @return [String]
    #
    class ApiSubjectsByIdEventsPostRequest < Struct.new(
      :subject_id)
      include Aws::Structure
    end

    # @!attribute [rw] event
    #   @return [Types::Event]
    #
    class ApiSubjectsByIdEventsPostResponse < Struct.new(
      :event)
      include Aws::Structure
    end

    # @note When making an API call, you may pass ApiSubjectsByIdPutRequest
    #   data as a hash:
    #
    #       {
    #         subject_id: "__string", # required
    #       }
    #
    # @!attribute [rw] subject_id
    #   @return [String]
    #
    class ApiSubjectsByIdPutRequest < Struct.new(
      :subject_id)
      include Aws::Structure
    end

    # @!attribute [rw] subject
    #   @return [Types::Subject]
    #
    class ApiSubjectsByIdPutResponse < Struct.new(
      :subject)
      include Aws::Structure
    end

    # @api private
    #
    class ApiSubjectsGetRequest < Aws::EmptyStructure; end

    # @!attribute [rw] subject_list
    #   @return [Types::SubjectList]
    #
    class ApiSubjectsGetResponse < Struct.new(
      :subject_list)
      include Aws::Structure
    end

    # @api private
    #
    class ApiSubjectsPostRequest < Aws::EmptyStructure; end

    # @!attribute [rw] subject
    #   @return [Types::Subject]
    #
    class ApiSubjectsPostResponse < Struct.new(
      :subject)
      include Aws::Structure
    end

    # @!attribute [rw] face_area
    #   @return [Types::FaceArea]
    #
    # @!attribute [rw] face_pan
    #   @return [String]
    #
    # @!attribute [rw] face_quality_score
    #   @return [String]
    #
    # @!attribute [rw] face_roll
    #   @return [String]
    #
    # @!attribute [rw] face_score
    #   @return [String]
    #
    # @!attribute [rw] face_tilt
    #   @return [String]
    #
    # @!attribute [rw] frontal_face_score
    #   @return [String]
    #
    # @!attribute [rw] head_area
    #   @return [Types::HeadArea]
    #
    # @!attribute [rw] left_eye_center
    #   @return [Types::LeftEyeCenter]
    #
    # @!attribute [rw] right_eye_center
    #   @return [Types::RightEyeCenter]
    #
    class Attributes < Struct.new(
      :face_area,
      :face_pan,
      :face_quality_score,
      :face_roll,
      :face_score,
      :face_tilt,
      :frontal_face_score,
      :head_area,
      :left_eye_center,
      :right_eye_center)
      include Aws::Structure
    end

    # @api private
    #
    class BulkRegisterRequest < Aws::EmptyStructure; end

    # @!attribute [rw] job
    #   @return [Types::Job]
    #
    class BulkRegisterResponse < Struct.new(
      :job)
      include Aws::Structure
    end

    # @!attribute [rw] events
    #   @return [Array<Types::Event>]
    #
    # @!attribute [rw] id
    #   @return [String]
    #
    # @!attribute [rw] score
    #   @return [Integer]
    #
    class Candidate < Struct.new(
      :events,
      :id,
      :score)
      include Aws::Structure
    end

    # @note When making an API call, you may pass CreateTagRequest
    #   data as a hash:
    #
    #       {
    #         name: "__string", # required
    #       }
    #
    # @!attribute [rw] name
    #   @return [String]
    #
    class CreateTagRequest < Struct.new(
      :name)
      include Aws::Structure
    end

    class CreateTagResponse < Aws::EmptyStructure; end

    # @note When making an API call, you may pass DeleteTagRequest
    #   data as a hash:
    #
    #       {
    #         name: "__string", # required
    #       }
    #
    # @!attribute [rw] name
    #   @return [String]
    #
    class DeleteTagRequest < Struct.new(
      :name)
      include Aws::Structure
    end

    class DeleteTagResponse < Aws::EmptyStructure; end

    # @!attribute [rw] id
    #   @return [String]
    #
    # @!attribute [rw] score
    #   @return [Integer]
    #
    class Event < Struct.new(
      :id,
      :score)
      include Aws::Structure
    end

    # @!attribute [rw] events
    #   @return [Array<Types::Event>]
    #
    class Events < Struct.new(
      :events)
      include Aws::Structure
    end

    # @!attribute [rw] faces
    #   @return [Array<Types::Attributes>]
    #
    class ExtractResult < Struct.new(
      :faces)
      include Aws::Structure
    end

    # @!attribute [rw] bottom
    #   @return [String]
    #
    # @!attribute [rw] left
    #   @return [String]
    #
    # @!attribute [rw] right
    #   @return [String]
    #
    # @!attribute [rw] top
    #   @return [String]
    #
    class FaceArea < Struct.new(
      :bottom,
      :left,
      :right,
      :top)
      include Aws::Structure
    end

    # @note When making an API call, you may pass GetBulkRegisterProgressPagedRequest
    #   data as a hash:
    #
    #       {
    #         batch_id: "__string", # required
    #         paging_id: "__string", # required
    #       }
    #
    # @!attribute [rw] batch_id
    #   @return [String]
    #
    # @!attribute [rw] paging_id
    #   @return [String]
    #
    class GetBulkRegisterProgressPagedRequest < Struct.new(
      :batch_id,
      :paging_id)
      include Aws::Structure
    end

    # @!attribute [rw] job_summary
    #   @return [Types::JobSummary]
    #
    class GetBulkRegisterProgressPagedResponse < Struct.new(
      :job_summary)
      include Aws::Structure
    end

    # @note When making an API call, you may pass GetBulkRegisterProgressRequest
    #   data as a hash:
    #
    #       {
    #         batch_id: "__string", # required
    #       }
    #
    # @!attribute [rw] batch_id
    #   @return [String]
    #
    class GetBulkRegisterProgressRequest < Struct.new(
      :batch_id)
      include Aws::Structure
    end

    # @!attribute [rw] job_summary
    #   @return [Types::JobSummary]
    #
    class GetBulkRegisterProgressResponse < Struct.new(
      :job_summary)
      include Aws::Structure
    end

    # @api private
    #
    class GetHealthRequest < Aws::EmptyStructure; end

    class GetHealthResponse < Aws::EmptyStructure; end

    # @api private
    #
    class GetRequest < Aws::EmptyStructure; end

    # @!attribute [rw] tag
    #   @return [Types::Tag]
    #
    class GetResponse < Struct.new(
      :tag)
      include Aws::Structure
    end

    # @!attribute [rw] bottom
    #   @return [String]
    #
    # @!attribute [rw] left
    #   @return [String]
    #
    # @!attribute [rw] right
    #   @return [String]
    #
    # @!attribute [rw] top
    #   @return [String]
    #
    class HeadArea < Struct.new(
      :bottom,
      :left,
      :right,
      :top)
      include Aws::Structure
    end

    # @!attribute [rw] batch_id
    #   @return [String]
    #
    class Job < Struct.new(
      :batch_id)
      include Aws::Structure
    end

    # @!attribute [rw] attempts
    #   @return [Integer]
    #
    # @!attribute [rw] attributes_json
    #   @return [String]
    #
    # @!attribute [rw] event_id
    #   @return [String]
    #
    # @!attribute [rw] filename
    #   @return [String]
    #
    # @!attribute [rw] id
    #   @return [String]
    #
    # @!attribute [rw] reason
    #   @return [String]
    #
    # @!attribute [rw] register_status
    #   @return [String]
    #
    # @!attribute [rw] status
    #   @return [String]
    #
    # @!attribute [rw] subject_id
    #   @return [String]
    #
    class JobStatus < Struct.new(
      :attempts,
      :attributes_json,
      :event_id,
      :filename,
      :id,
      :reason,
      :register_status,
      :status,
      :subject_id)
      include Aws::Structure
    end

    # @!attribute [rw] batch_id
    #   @return [String]
    #
    # @!attribute [rw] last_evaluated_key
    #   @return [String]
    #
    # @!attribute [rw] processed
    #   @return [Array<Types::JobStatus>]
    #
    class JobSummary < Struct.new(
      :batch_id,
      :last_evaluated_key,
      :processed)
      include Aws::Structure
    end

    # @!attribute [rw] x
    #   @return [String]
    #
    # @!attribute [rw] y
    #   @return [String]
    #
    class LeftEyeCenter < Struct.new(
      :x,
      :y)
      include Aws::Structure
    end

    # @!attribute [rw] x
    #   @return [String]
    #
    # @!attribute [rw] y
    #   @return [String]
    #
    class RightEyeCenter < Struct.new(
      :x,
      :y)
      include Aws::Structure
    end

    # @!attribute [rw] attributes
    #   @return [Types::Attributes]
    #
    # @!attribute [rw] candidates
    #   @return [Array<Types::Candidate>]
    #
    class SearchResult < Struct.new(
      :attributes,
      :candidates)
      include Aws::Structure
    end

    # @!attribute [rw] attributes
    #   @return [Types::Attributes]
    #
    # @!attribute [rw] event_id
    #   @return [String]
    #
    # @!attribute [rw] id
    #   @return [String]
    #
    class Subject < Struct.new(
      :attributes,
      :event_id,
      :id)
      include Aws::Structure
    end

    # @!attribute [rw] subjects
    #   @return [Array<Types::Subject>]
    #
    # @!attribute [rw] total
    #   @return [Integer]
    #
    class SubjectList < Struct.new(
      :subjects,
      :total)
      include Aws::Structure
    end

    # @!attribute [rw] id
    #   @return [Integer]
    #
    # @!attribute [rw] name
    #   @return [String]
    #
    class Tag < Struct.new(
      :id,
      :name)
      include Aws::Structure
    end

    # @note When making an API call, you may pass UpdateTagRequest
    #   data as a hash:
    #
    #       {
    #         name: "__string", # required
    #       }
    #
    # @!attribute [rw] name
    #   @return [String]
    #
    class UpdateTagRequest < Struct.new(
      :name)
      include Aws::Structure
    end

    class UpdateTagResponse < Aws::EmptyStructure; end

  end
end
