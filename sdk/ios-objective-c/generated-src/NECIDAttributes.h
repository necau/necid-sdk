/*
 Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.

 Licensed under the Apache License, Version 2.0 (the "License").
 You may not use this file except in compliance with the License.
 A copy of the License is located at

 http://aws.amazon.com/apache2.0

 or in the "license" file accompanying this file. This file is distributed
 on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 express or implied. See the License for the specific language governing
 permissions and limitations under the License.
 */
 

#import <Foundation/Foundation.h>
#import <AWSCore/AWSCore.h>
#import "NECIDAttributes_faceArea.h"
#import "NECIDAttributes_headArea.h"
#import "NECIDAttributes_leftEyeCenter.h"
#import "NECIDAttributes_rightEyeCenter.h"

 
@interface NECIDAttributes : AWSModel

@property (nonatomic, strong, nullable) NECIDAttributes_faceArea *faceArea;


@property (nonatomic, strong, nullable) NECIDAttributes_headArea *headArea;


@property (nonatomic, strong, nullable) NECIDAttributes_rightEyeCenter *rightEyeCenter;


@property (nonatomic, strong, nullable) NECIDAttributes_leftEyeCenter *leftEyeCenter;


@property (nonatomic, strong, nullable) NSString *frontalFaceScore;


@property (nonatomic, strong, nullable) NSString *faceRoll;


@property (nonatomic, strong, nullable) NSString *facePan;


@property (nonatomic, strong, nullable) NSString *faceTilt;


@property (nonatomic, strong, nullable) NSString *faceScore;


@property (nonatomic, strong, nullable) NSString *faceQualityScore;


@end
