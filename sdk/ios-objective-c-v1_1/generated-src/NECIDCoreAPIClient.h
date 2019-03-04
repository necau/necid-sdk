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
#import <AWSAPIGateway/AWSAPIGateway.h>

#import "NECIDExtractResult.h"
#import "NECIDSearchResult.h"
#import "NECIDCandidate.h"
#import "NECIDJob.h"
#import "NECIDJobSummary.h"
#import "NECIDSubjectList.h"
#import "NECIDSubject.h"
#import "NECIDEvents.h"
#import "NECIDEvent.h"
#import "NECIDTag.h"


NS_ASSUME_NONNULL_BEGIN

/**
 The service client object.
 */
@interface NECIDCoreAPIClient: AWSAPIGatewayClient

/**
 Returns the singleton service client. If the singleton object does not exist, the SDK instantiates the default service client with `defaultServiceConfiguration` from `[AWSServiceManager defaultServiceManager]`. The reference to this object is maintained by the SDK, and you do not need to retain it manually.

 If you want to enable AWS Signature, set the default service configuration in `- application:didFinishLaunchingWithOptions:`
 
 *Swift*

     func application(application: UIApplication, didFinishLaunchingWithOptions launchOptions: [NSObject: AnyObject]?) -> Bool {
         let credentialProvider = AWSCognitoCredentialsProvider(regionType: .USEast1, identityPoolId: "YourIdentityPoolId")
         let configuration = AWSServiceConfiguration(region: .USEast1, credentialsProvider: credentialProvider)
         AWSServiceManager.defaultServiceManager().defaultServiceConfiguration = configuration

         return true
     }

 *Objective-C*

     - (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
          AWSCognitoCredentialsProvider *credentialsProvider = [[AWSCognitoCredentialsProvider alloc] initWithRegionType:AWSRegionUSEast1
                                                                                                          identityPoolId:@"YourIdentityPoolId"];
          AWSServiceConfiguration *configuration = [[AWSServiceConfiguration alloc] initWithRegion:AWSRegionUSEast1
                                                                               credentialsProvider:credentialsProvider];
          [AWSServiceManager defaultServiceManager].defaultServiceConfiguration = configuration;

          return YES;
      }

 Then call the following to get the default service client:

 *Swift*

     let serviceClient = NECIDCoreAPIClient.defaultClient()

 *Objective-C*

     NECIDCoreAPIClient *serviceClient = [NECIDCoreAPIClient defaultClient];

 Alternatively, this configuration could also be set in the `info.plist` file of your app under `AWS` dictionary with a configuration dictionary by name `NECIDCoreAPIClient`.

 @return The default service client.
 */
+ (instancetype)defaultClient;

/**
 Creates a service client with the given service configuration and registers it for the key.

 If you want to enable AWS Signature, set the default service configuration in `- application:didFinishLaunchingWithOptions:`

 *Swift*

     func application(application: UIApplication, didFinishLaunchingWithOptions launchOptions: [NSObject: AnyObject]?) -> Bool {
         let credentialProvider = AWSCognitoCredentialsProvider(regionType: .USEast1, identityPoolId: "YourIdentityPoolId")
         let configuration = AWSServiceConfiguration(region: .USWest2, credentialsProvider: credentialProvider)
         NECIDCoreAPIClient.registerClientWithConfiguration(configuration, forKey: "USWest2NECIDCoreAPIClient")

         return true
     }

 *Objective-C*

     - (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
         AWSCognitoCredentialsProvider *credentialsProvider = [[AWSCognitoCredentialsProvider alloc] initWithRegionType:AWSRegionUSEast1
                                                                                                         identityPoolId:@"YourIdentityPoolId"];
         AWSServiceConfiguration *configuration = [[AWSServiceConfiguration alloc] initWithRegion:AWSRegionUSWest2
                                                                              credentialsProvider:credentialsProvider];

         [NECIDCoreAPIClient registerClientWithConfiguration:configuration forKey:@"USWest2NECIDCoreAPIClient"];

         return YES;
     }

 Then call the following to get the service client:

 *Swift*

     let serviceClient = NECIDCoreAPIClient(forKey: "USWest2NECIDCoreAPIClient")

 *Objective-C*

     NECIDCoreAPIClient *serviceClient = [NECIDCoreAPIClient clientForKey:@"USWest2NECIDCoreAPIClient"];

 @warning After calling this method, do not modify the configuration object. It may cause unspecified behaviors.

 @param configuration A service configuration object.
 @param key           A string to identify the service client.
 */
+ (void)registerClientWithConfiguration:(AWSServiceConfiguration *)configuration forKey:(NSString *)key;

/**
 Retrieves the service client associated with the key. You need to call `+ registerClientWithConfiguration:forKey:` before invoking this method or alternatively, set the configuration in your application's `info.plist` file. If `+ registerClientWithConfiguration:forKey:` has not been called in advance or if a configuration is not present in the `info.plist` file of the app, this method returns `nil`.

 For example, set the default service configuration in `- application:didFinishLaunchingWithOptions:`

 *Swift*

     func application(application: UIApplication, didFinishLaunchingWithOptions launchOptions: [NSObject: AnyObject]?) -> Bool {
         let credentialProvider = AWSCognitoCredentialsProvider(regionType: .USEast1, identityPoolId: "YourIdentityPoolId")
         let configuration = AWSServiceConfiguration(region: .USWest2, credentialsProvider: credentialProvider)
         NECIDCoreAPIClient.registerClientWithConfiguration(configuration, forKey: "USWest2NECIDCoreAPIClient")

         return true
     }

 *Objective-C*

     - (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
         AWSCognitoCredentialsProvider *credentialsProvider = [[AWSCognitoCredentialsProvider alloc] initWithRegionType:AWSRegionUSEast1
                                                                                                         identityPoolId:@"YourIdentityPoolId"];
         AWSServiceConfiguration *configuration = [[AWSServiceConfiguration alloc] initWithRegion:AWSRegionUSWest2
                                                                              credentialsProvider:credentialsProvider];

         [NECIDCoreAPIClient registerClientWithConfiguration:configuration forKey:@"USWest2NECIDCoreAPIClient"];

         return YES;
     }

 Then call the following to get the service client:

 *Swift*

     let serviceClient = NECIDCoreAPIClient(forKey: "USWest2NECIDCoreAPIClient")

 *Objective-C*

     NECIDCoreAPIClient *serviceClient = [NECIDCoreAPIClient clientForKey:@"USWest2NECIDCoreAPIClient"];

 @param key A string to identify the service client.

 @return An instance of the service client.
 */
+ (instancetype)clientForKey:(NSString *)key;

/**
 Removes the service client associated with the key and release it.
 
 @warning Before calling this method, make sure no method is running on this client.
 
 @param key A string to identify the service client.
 */
+ (void)removeClientForKey:(NSString *)key;

/**
 
 
 
 return type: NECIDExtractResult *
 */
- (AWSTask *)faceExtractPost;

/**
 
 
 
 return type: 
 */
- (AWSTask *)faceExtractOptions;

/**
 
 
 
 return type: NECIDSearchResult *
 */
- (AWSTask *)faceSearchPost;

/**
 
 
 
 return type: 
 */
- (AWSTask *)faceSearchOptions;

/**
 
 
 
 return type: NECIDCandidate *
 */
- (AWSTask *)faceVerifyPost;

/**
 
 
 
 return type: 
 */
- (AWSTask *)faceVerifyOptions;

/**
 
 
 
 return type: 
 */
- (AWSTask *)healthGet;

/**
 
 
 
 return type: 
 */
- (AWSTask *)healthOptions;

/**
 
 
 
 return type: NECIDJob *
 */
- (AWSTask *)jobsBulkregisterPost;

/**
 
 
 
 return type: 
 */
- (AWSTask *)jobsBulkregisterOptions;

/**
 
 
 @param batchId 
 
 return type: NECIDJobSummary *
 */
- (AWSTask *)jobsBulkregisterBatchIdGet:( NSString *)batchId;

/**
 
 
 @param batchId 
 @param pagingId 
 
 return type: 
 */
- (AWSTask *)jobsBulkregisterBatchIdOptions:( NSString *)batchId pagingId:(nullable NSString *)pagingId;

/**
 
 
 @param pagingId 
 @param batchId 
 
 return type: NECIDJobSummary *
 */
- (AWSTask *)jobsBulkregisterBatchIdPagingIdGet:( NSString *)pagingId batchId:( NSString *)batchId;

/**
 
 
 @param batchId 
 @param pagingId 
 
 return type: 
 */
- (AWSTask *)jobsBulkregisterBatchIdPagingIdOptions:( NSString *)batchId pagingId:(nullable NSString *)pagingId;

/**
 
 
 
 return type: NECIDSubjectList *
 */
- (AWSTask *)subjectsGet;

/**
 
 
 
 return type: NECIDSubject *
 */
- (AWSTask *)subjectsPost;

/**
 
 
 
 return type: 
 */
- (AWSTask *)subjectsOptions;

/**
 
 
 @param subjectId 
 
 return type: NECIDSubject *
 */
- (AWSTask *)subjectsSubjectIdPut:( NSString *)subjectId;

/**
 
 
 @param subjectId 
 
 return type: 
 */
- (AWSTask *)subjectsSubjectIdDelete:( NSString *)subjectId;

/**
 
 
 @param subjectId 
 
 return type: 
 */
- (AWSTask *)subjectsSubjectIdOptions:( NSString *)subjectId;

/**
 
 
 @param subjectId 
 
 return type: NECIDEvents *
 */
- (AWSTask *)subjectsSubjectIdEventsGet:( NSString *)subjectId;

/**
 
 
 @param subjectId 
 
 return type: NECIDEvent *
 */
- (AWSTask *)subjectsSubjectIdEventsPost:( NSString *)subjectId;

/**
 
 
 @param subjectId 
 
 return type: 
 */
- (AWSTask *)subjectsSubjectIdEventsOptions:( NSString *)subjectId;

/**
 
 
 @param eventId 
 @param subjectId 
 
 return type: NECIDEvent *
 */
- (AWSTask *)subjectsSubjectIdEventsEventIdPut:( NSString *)eventId subjectId:( NSString *)subjectId;

/**
 
 
 @param eventId 
 @param subjectId 
 
 return type: 
 */
- (AWSTask *)subjectsSubjectIdEventsEventIdDelete:( NSString *)eventId subjectId:( NSString *)subjectId;

/**
 
 
 @param eventId 
 @param subjectId 
 
 return type: 
 */
- (AWSTask *)subjectsSubjectIdEventsEventIdOptions:( NSString *)eventId subjectId:( NSString *)subjectId;

/**
 
 
 
 return type: NECIDTag *
 */
- (AWSTask *)tagsGet;

/**
 
 
 
 return type: 
 */
- (AWSTask *)tagsOptions;

/**
 
 
 @param name 
 
 return type: 
 */
- (AWSTask *)tagsNamePut:( NSString *)name;

/**
 
 
 @param name 
 
 return type: 
 */
- (AWSTask *)tagsNamePost:( NSString *)name;

/**
 
 
 @param name 
 
 return type: 
 */
- (AWSTask *)tagsNameDelete:( NSString *)name;

/**
 
 
 @param name 
 
 return type: 
 */
- (AWSTask *)tagsNameOptions:( NSString *)name;

@end

NS_ASSUME_NONNULL_END
