require 'aws-sdk-core'
require 'aws-sigv4'

require_relative 'necid-sdk/types'
require_relative 'necid-sdk/client_api'
require_relative 'necid-sdk/client'
require_relative 'necid-sdk/errors'
require_relative 'necid-sdk/resource'
require_relative 'necid-sdk/customizations'

# This module provides support for Biometric API. This module is available in the
# `necid-sdk` gem.
#
# # Client
#
# The {Client} class provides one method for each API operation. Operation
# methods each accept a hash of request parameters and return a response
# structure.
#
# See {Client} for more information.
#
# # Errors
#
# Errors returned from Biometric API all
# extend {Errors::ServiceError}.
#
#     begin
#       # do stuff
#     rescue NECID::Errors::ServiceError
#       # rescues all service API errors
#     end
#
# See {Errors} for more information.
#
# @service
module NECID

  GEM_VERSION = '1.0.0'

end
