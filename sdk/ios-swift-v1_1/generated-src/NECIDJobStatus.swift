/*
 Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

 Licensed under the Apache License, Version 2.0 (the "License").
 You may not use this file except in compliance with the License.
 A copy of the License is located at

 http://aws.amazon.com/apache2.0

 or in the "license" file accompanying this file. This file is distributed
 on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 express or implied. See the License for the specific language governing
 permissions and limitations under the License.
 */


import Foundation
import AWSCore


@objcMembers
public class NECIDJobStatus : AWSModel {
    
    var id: String?
    var filename: String?
    var attempts: NSNumber?
    var eventId: String?
    var subjectId: String?
    var registerStatus: String?
    var reason: String?
    var status: String?
    var attributesJson: String?
    
   	public override static func jsonKeyPathsByPropertyKey() -> [AnyHashable : Any]!{
		var params:[AnyHashable : Any] = [:]
		params["id"] = "id"
		params["filename"] = "filename"
		params["attempts"] = "attempts"
		params["eventId"] = "eventId"
		params["subjectId"] = "subjectId"
		params["registerStatus"] = "registerStatus"
		params["reason"] = "reason"
		params["status"] = "status"
		params["attributesJson"] = "attributesJson"
		
        return params
	}
}
