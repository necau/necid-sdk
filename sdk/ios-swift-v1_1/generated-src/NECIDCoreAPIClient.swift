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


import AWSCore
import AWSAPIGateway

public class NECIDCoreAPIClient: AWSAPIGatewayClient {

	static let AWSInfoClientKey = "NECIDCoreAPIClient"

	private static let _serviceClients = AWSSynchronizedMutableDictionary()
	private static let _defaultClient:NECIDCoreAPIClient = {
		var serviceConfiguration: AWSServiceConfiguration? = nil
        let serviceInfo = AWSInfo.default().defaultServiceInfo(AWSInfoClientKey)
        if let serviceInfo = serviceInfo {
            serviceConfiguration = AWSServiceConfiguration(region: serviceInfo.region, credentialsProvider: serviceInfo.cognitoCredentialsProvider)
        } else if (AWSServiceManager.default().defaultServiceConfiguration != nil) {
            serviceConfiguration = AWSServiceManager.default().defaultServiceConfiguration
        } else {
            serviceConfiguration = AWSServiceConfiguration(region: .Unknown, credentialsProvider: nil)
        }
        
        return NECIDCoreAPIClient(configuration: serviceConfiguration!)
	}()
    
	/**
	 Returns the singleton service client. If the singleton object does not exist, the SDK instantiates the default service client with `defaultServiceConfiguration` from `AWSServiceManager.defaultServiceManager()`. The reference to this object is maintained by the SDK, and you do not need to retain it manually.
	
	 If you want to enable AWS Signature, set the default service configuration in `func application(application: UIApplication, didFinishLaunchingWithOptions launchOptions: [NSObject: AnyObject]?)`
	
	     func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
	        let credentialProvider = AWSCognitoCredentialsProvider(regionType: .USEast1, identityPoolId: "YourIdentityPoolId")
	        let configuration = AWSServiceConfiguration(region: .USEast1, credentialsProvider: credentialProvider)
	        AWSServiceManager.default().defaultServiceConfiguration = configuration
	 
	        return true
	     }
	
	 Then call the following to get the default service client:
	
	     let serviceClient = NECIDCoreAPIClient.default()

     Alternatively, this configuration could also be set in the `info.plist` file of your app under `AWS` dictionary with a configuration dictionary by name `NECIDCoreAPIClient`.
	
	 @return The default service client.
	 */ 
	 
	public class func `default`() -> NECIDCoreAPIClient{
		return _defaultClient
	}

	/**
	 Creates a service client with the given service configuration and registers it for the key.
	
	 If you want to enable AWS Signature, set the default service configuration in `func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?)`
	
	     func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
	         let credentialProvider = AWSCognitoCredentialsProvider(regionType: .USEast1, identityPoolId: "YourIdentityPoolId")
	         let configuration = AWSServiceConfiguration(region: .USWest2, credentialsProvider: credentialProvider)
	         NECIDCoreAPIClient.registerClient(withConfiguration: configuration, forKey: "USWest2NECIDCoreAPIClient")
	
	         return true
	     }
	
	 Then call the following to get the service client:
	
	
	     let serviceClient = NECIDCoreAPIClient.client(forKey: "USWest2NECIDCoreAPIClient")
	
	 @warning After calling this method, do not modify the configuration object. It may cause unspecified behaviors.
	
	 @param configuration A service configuration object.
	 @param key           A string to identify the service client.
	 */
	
	public class func registerClient(withConfiguration configuration: AWSServiceConfiguration, forKey key: String){
		_serviceClients.setObject(NECIDCoreAPIClient(configuration: configuration), forKey: key  as NSString);
	}

	/**
	 Retrieves the service client associated with the key. You need to call `registerClient(withConfiguration:configuration, forKey:)` before invoking this method or alternatively, set the configuration in your application's `info.plist` file. If `registerClientWithConfiguration(configuration, forKey:)` has not been called in advance or if a configuration is not present in the `info.plist` file of the app, this method returns `nil`.
	
	 For example, set the default service configuration in `func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) `
	
	     func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
	         let credentialProvider = AWSCognitoCredentialsProvider(regionType: .USEast1, identityPoolId: "YourIdentityPoolId")
	         let configuration = AWSServiceConfiguration(region: .USWest2, credentialsProvider: credentialProvider)
	         NECIDCoreAPIClient.registerClient(withConfiguration: configuration, forKey: "USWest2NECIDCoreAPIClient")
	
	         return true
	     }
	
	 Then call the following to get the service client:
	 
	 	let serviceClient = NECIDCoreAPIClient.client(forKey: "USWest2NECIDCoreAPIClient")
	 
	 @param key A string to identify the service client.
	 @return An instance of the service client.
	 */
	public class func client(forKey key: String) -> NECIDCoreAPIClient {
		objc_sync_enter(self)
		if let client: NECIDCoreAPIClient = _serviceClients.object(forKey: key) as? NECIDCoreAPIClient {
			objc_sync_exit(self)
		    return client
		}

		let serviceInfo = AWSInfo.default().defaultServiceInfo(AWSInfoClientKey)
		if let serviceInfo = serviceInfo {
			let serviceConfiguration = AWSServiceConfiguration(region: serviceInfo.region, credentialsProvider: serviceInfo.cognitoCredentialsProvider)
			NECIDCoreAPIClient.registerClient(withConfiguration: serviceConfiguration!, forKey: key)
		}
		objc_sync_exit(self)
		return _serviceClients.object(forKey: key) as! NECIDCoreAPIClient;
	}

	/**
	 Removes the service client associated with the key and release it.
	 
	 @warning Before calling this method, make sure no method is running on this client.
	 
	 @param key A string to identify the service client.
	 */
	public class func removeClient(forKey key: String) -> Void{
		_serviceClients.remove(key)
	}
	
	init(configuration: AWSServiceConfiguration) {
	    super.init()
	
	    self.configuration = configuration.copy() as! AWSServiceConfiguration
	    var URLString: String = "https://api.id.nec.com.au/v1.1"
	    if URLString.hasSuffix("/") {
	        URLString = URLString.substring(to: URLString.index(before: URLString.endIndex))
	    }
	    self.configuration.endpoint = AWSEndpoint(region: configuration.regionType, service: .APIGateway, url: URL(string: URLString))
	    let signer: AWSSignatureV4Signer = AWSSignatureV4Signer(credentialsProvider: configuration.credentialsProvider, endpoint: self.configuration.endpoint)
	    if let endpoint = self.configuration.endpoint {
	    	self.configuration.baseURL = endpoint.url
	    }
	    self.configuration.requestInterceptors = [AWSNetworkingRequestInterceptor(), signer]
	}

	
    /*
     
     
     
     return type: NECIDExtractResult
     */
    public func faceExtractPost() -> AWSTask<NECIDExtractResult> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("POST", urlString: "/face/extract", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: NECIDExtractResult.self) as! AWSTask<NECIDExtractResult>
	}

	
    /*
     
     
     
     return type: 
     */
    public func faceExtractOptions() -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("OPTIONS", urlString: "/face/extract", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     
     return type: NECIDSearchResult
     */
    public func faceSearchPost() -> AWSTask<NECIDSearchResult> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("POST", urlString: "/face/search", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: NECIDSearchResult.self) as! AWSTask<NECIDSearchResult>
	}

	
    /*
     
     
     
     return type: 
     */
    public func faceSearchOptions() -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("OPTIONS", urlString: "/face/search", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     
     return type: NECIDCandidate
     */
    public func faceVerifyPost() -> AWSTask<NECIDCandidate> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("POST", urlString: "/face/verify", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: NECIDCandidate.self) as! AWSTask<NECIDCandidate>
	}

	
    /*
     
     
     
     return type: 
     */
    public func faceVerifyOptions() -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("OPTIONS", urlString: "/face/verify", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     
     return type: 
     */
    public func healthGet() -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("GET", urlString: "/health", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     
     return type: 
     */
    public func healthOptions() -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("OPTIONS", urlString: "/health", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     
     return type: NECIDJob
     */
    public func jobsBulkregisterPost() -> AWSTask<NECIDJob> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("POST", urlString: "/jobs/bulkregister", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: NECIDJob.self) as! AWSTask<NECIDJob>
	}

	
    /*
     
     
     
     return type: 
     */
    public func jobsBulkregisterOptions() -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("OPTIONS", urlString: "/jobs/bulkregister", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     @param batchId 
     
     return type: NECIDJobSummary
     */
    public func jobsBulkregisterBatchIdGet(batchId: String) -> AWSTask<NECIDJobSummary> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["batchId"] = batchId
	    
	    return self.invokeHTTPRequest("GET", urlString: "/jobs/bulkregister/{batchId}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: NECIDJobSummary.self) as! AWSTask<NECIDJobSummary>
	}

	
    /*
     
     
     @param batchId 
     @param pagingId 
     
     return type: 
     */
    public func jobsBulkregisterBatchIdOptions(batchId: String, pagingId: String?) -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    var queryParameters:[String:Any] = [:]
	    queryParameters["pagingId"] = pagingId
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["batchId"] = batchId
	    
	    return self.invokeHTTPRequest("OPTIONS", urlString: "/jobs/bulkregister/{batchId}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     @param pagingId 
     @param batchId 
     
     return type: NECIDJobSummary
     */
    public func jobsBulkregisterBatchIdPagingIdGet(pagingId: String, batchId: String) -> AWSTask<NECIDJobSummary> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    var queryParameters:[String:Any] = [:]
	    queryParameters["pagingId"] = pagingId
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["batchId"] = batchId
	    
	    return self.invokeHTTPRequest("GET", urlString: "/jobs/bulkregister/{batchId}/{pagingId}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: NECIDJobSummary.self) as! AWSTask<NECIDJobSummary>
	}

	
    /*
     
     
     @param batchId 
     @param pagingId 
     
     return type: 
     */
    public func jobsBulkregisterBatchIdPagingIdOptions(batchId: String, pagingId: String?) -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    var queryParameters:[String:Any] = [:]
	    queryParameters["pagingId"] = pagingId
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["batchId"] = batchId
	    
	    return self.invokeHTTPRequest("OPTIONS", urlString: "/jobs/bulkregister/{batchId}/{pagingId}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     
     return type: NECIDSubjectList
     */
    public func subjectsGet() -> AWSTask<NECIDSubjectList> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("GET", urlString: "/subjects", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: NECIDSubjectList.self) as! AWSTask<NECIDSubjectList>
	}

	
    /*
     
     
     
     return type: NECIDSubject
     */
    public func subjectsPost() -> AWSTask<NECIDSubject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("POST", urlString: "/subjects", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: NECIDSubject.self) as! AWSTask<NECIDSubject>
	}

	
    /*
     
     
     
     return type: 
     */
    public func subjectsOptions() -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("OPTIONS", urlString: "/subjects", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     @param subjectId 
     
     return type: NECIDSubject
     */
    public func subjectsSubjectIdPut(subjectId: String) -> AWSTask<NECIDSubject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["subjectId"] = subjectId
	    
	    return self.invokeHTTPRequest("PUT", urlString: "/subjects/{subjectId}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: NECIDSubject.self) as! AWSTask<NECIDSubject>
	}

	
    /*
     
     
     @param subjectId 
     
     return type: 
     */
    public func subjectsSubjectIdDelete(subjectId: String) -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["subjectId"] = subjectId
	    
	    return self.invokeHTTPRequest("DELETE", urlString: "/subjects/{subjectId}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     @param subjectId 
     
     return type: 
     */
    public func subjectsSubjectIdOptions(subjectId: String) -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["subjectId"] = subjectId
	    
	    return self.invokeHTTPRequest("OPTIONS", urlString: "/subjects/{subjectId}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     @param subjectId 
     
     return type: NECIDEvents
     */
    public func subjectsSubjectIdEventsGet(subjectId: String) -> AWSTask<NECIDEvents> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["subjectId"] = subjectId
	    
	    return self.invokeHTTPRequest("GET", urlString: "/subjects/{subjectId}/events", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: NECIDEvents.self) as! AWSTask<NECIDEvents>
	}

	
    /*
     
     
     @param subjectId 
     
     return type: NECIDEvent
     */
    public func subjectsSubjectIdEventsPost(subjectId: String) -> AWSTask<NECIDEvent> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["subjectId"] = subjectId
	    
	    return self.invokeHTTPRequest("POST", urlString: "/subjects/{subjectId}/events", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: NECIDEvent.self) as! AWSTask<NECIDEvent>
	}

	
    /*
     
     
     @param subjectId 
     
     return type: 
     */
    public func subjectsSubjectIdEventsOptions(subjectId: String) -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["subjectId"] = subjectId
	    
	    return self.invokeHTTPRequest("OPTIONS", urlString: "/subjects/{subjectId}/events", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     @param eventId 
     @param subjectId 
     
     return type: NECIDEvent
     */
    public func subjectsSubjectIdEventsEventIdPut(eventId: String, subjectId: String) -> AWSTask<NECIDEvent> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["eventId"] = eventId
	    pathParameters["subjectId"] = subjectId
	    
	    return self.invokeHTTPRequest("PUT", urlString: "/subjects/{subjectId}/events/{eventId}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: NECIDEvent.self) as! AWSTask<NECIDEvent>
	}

	
    /*
     
     
     @param eventId 
     @param subjectId 
     
     return type: 
     */
    public func subjectsSubjectIdEventsEventIdDelete(eventId: String, subjectId: String) -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["eventId"] = eventId
	    pathParameters["subjectId"] = subjectId
	    
	    return self.invokeHTTPRequest("DELETE", urlString: "/subjects/{subjectId}/events/{eventId}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     @param eventId 
     @param subjectId 
     
     return type: 
     */
    public func subjectsSubjectIdEventsEventIdOptions(eventId: String, subjectId: String) -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["eventId"] = eventId
	    pathParameters["subjectId"] = subjectId
	    
	    return self.invokeHTTPRequest("OPTIONS", urlString: "/subjects/{subjectId}/events/{eventId}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     
     return type: NECIDTag
     */
    public func tagsGet() -> AWSTask<NECIDTag> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("GET", urlString: "/tags", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: NECIDTag.self) as! AWSTask<NECIDTag>
	}

	
    /*
     
     
     
     return type: 
     */
    public func tagsOptions() -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    let pathParameters:[String:Any] = [:]
	    
	    return self.invokeHTTPRequest("OPTIONS", urlString: "/tags", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     @param name 
     
     return type: 
     */
    public func tagsNamePut(name: String) -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["name"] = name
	    
	    return self.invokeHTTPRequest("PUT", urlString: "/tags/{name}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     @param name 
     
     return type: 
     */
    public func tagsNamePost(name: String) -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["name"] = name
	    
	    return self.invokeHTTPRequest("POST", urlString: "/tags/{name}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     @param name 
     
     return type: 
     */
    public func tagsNameDelete(name: String) -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["name"] = name
	    
	    return self.invokeHTTPRequest("DELETE", urlString: "/tags/{name}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}

	
    /*
     
     
     @param name 
     
     return type: 
     */
    public func tagsNameOptions(name: String) -> AWSTask<AnyObject> {
	    let headerParameters = [
                   "Content-Type": "application/json",
                   "Accept": "application/json",
                   
	            ]
	    
	    let queryParameters:[String:Any] = [:]
	    
	    var pathParameters:[String:Any] = [:]
	    pathParameters["name"] = name
	    
	    return self.invokeHTTPRequest("OPTIONS", urlString: "/tags/{name}", pathParameters: pathParameters, queryParameters: queryParameters, headerParameters: headerParameters, body: nil, responseClass: nil)
	}




}
