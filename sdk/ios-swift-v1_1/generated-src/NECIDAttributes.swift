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
public class NECIDAttributes : AWSModel {
    
    var faceArea: NECIDAttributes_faceArea?
    var headArea: NECIDAttributes_headArea?
    var rightEyeCenter: NECIDAttributes_rightEyeCenter?
    var leftEyeCenter: NECIDAttributes_leftEyeCenter?
    var frontalFaceScore: String?
    var faceRoll: String?
    var facePan: String?
    var faceTilt: String?
    var faceScore: String?
    var faceQualityScore: String?
    
   	public override static func jsonKeyPathsByPropertyKey() -> [AnyHashable : Any]!{
		var params:[AnyHashable : Any] = [:]
		params["faceArea"] = "faceArea"
		params["headArea"] = "headArea"
		params["rightEyeCenter"] = "rightEyeCenter"
		params["leftEyeCenter"] = "leftEyeCenter"
		params["frontalFaceScore"] = "frontalFaceScore"
		params["faceRoll"] = "faceRoll"
		params["facePan"] = "facePan"
		params["faceTilt"] = "faceTilt"
		params["faceScore"] = "faceScore"
		params["faceQualityScore"] = "faceQualityScore"
		
        return params
	}
	class func faceAreaJSONTransformer() -> ValueTransformer{
	    return ValueTransformer.awsmtl_JSONDictionaryTransformer(withModelClass: NECIDAttributes_faceArea.self);
	}
	class func headAreaJSONTransformer() -> ValueTransformer{
	    return ValueTransformer.awsmtl_JSONDictionaryTransformer(withModelClass: NECIDAttributes_headArea.self);
	}
	class func rightEyeCenterJSONTransformer() -> ValueTransformer{
	    return ValueTransformer.awsmtl_JSONDictionaryTransformer(withModelClass: NECIDAttributes_rightEyeCenter.self);
	}
	class func leftEyeCenterJSONTransformer() -> ValueTransformer{
	    return ValueTransformer.awsmtl_JSONDictionaryTransformer(withModelClass: NECIDAttributes_leftEyeCenter.self);
	}
}
