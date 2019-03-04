/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

var apigClientFactory = {};
apigClientFactory.newClient = function (config) {
    var apigClient = { };
    if(config === undefined) {
        config = {
            accessKey: '',
            secretKey: '',
            sessionToken: '',
            region: '',
            apiKey: undefined,
            defaultContentType: 'application/json',
            defaultAcceptType: 'application/json'
        };
    }
    if(config.accessKey === undefined) {
        config.accessKey = '';
    }
    if(config.secretKey === undefined) {
        config.secretKey = '';
    }
    if(config.apiKey === undefined) {
        config.apiKey = '';
    }
    if(config.sessionToken === undefined) {
        config.sessionToken = '';
    }
    if(config.region === undefined) {
        config.region = 'us-east-1';
    }
    //If defaultContentType is not defined then default to application/json
    if(config.defaultContentType === undefined) {
        config.defaultContentType = 'application/json';
    }
    //If defaultAcceptType is not defined then default to application/json
    if(config.defaultAcceptType === undefined) {
        config.defaultAcceptType = 'application/json';
    }

    
    // extract endpoint and path from url
    var invokeUrl = 'https://api.id.nec.com.au/v1.1';
    var endpoint = /(^https?:\/\/[^\/]+)/g.exec(invokeUrl)[1];
    var pathComponent = invokeUrl.substring(endpoint.length);

    var sigV4ClientConfig = {
        accessKey: config.accessKey,
        secretKey: config.secretKey,
        sessionToken: config.sessionToken,
        serviceName: 'execute-api',
        region: config.region,
        endpoint: endpoint,
        defaultContentType: config.defaultContentType,
        defaultAcceptType: config.defaultAcceptType
    };

    var authType = 'NONE';
    if (sigV4ClientConfig.accessKey !== undefined && sigV4ClientConfig.accessKey !== '' && sigV4ClientConfig.secretKey !== undefined && sigV4ClientConfig.secretKey !== '') {
        authType = 'AWS_IAM';
    }

    var simpleHttpClientConfig = {
        endpoint: endpoint,
        defaultContentType: config.defaultContentType,
        defaultAcceptType: config.defaultAcceptType
    };

    var apiGatewayClient = apiGateway.core.apiGatewayClientFactory.newClient(simpleHttpClientConfig, sigV4ClientConfig);
    
    
    
    apigClient.faceExtractPost = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var faceExtractPostRequest = {
            verb: 'post'.toUpperCase(),
            path: pathComponent + uritemplate('/face/extract').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(faceExtractPostRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.faceExtractOptions = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var faceExtractOptionsRequest = {
            verb: 'options'.toUpperCase(),
            path: pathComponent + uritemplate('/face/extract').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(faceExtractOptionsRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.faceSearchPost = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var faceSearchPostRequest = {
            verb: 'post'.toUpperCase(),
            path: pathComponent + uritemplate('/face/search').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(faceSearchPostRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.faceSearchOptions = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var faceSearchOptionsRequest = {
            verb: 'options'.toUpperCase(),
            path: pathComponent + uritemplate('/face/search').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(faceSearchOptionsRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.faceVerifyPost = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var faceVerifyPostRequest = {
            verb: 'post'.toUpperCase(),
            path: pathComponent + uritemplate('/face/verify').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(faceVerifyPostRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.faceVerifyOptions = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var faceVerifyOptionsRequest = {
            verb: 'options'.toUpperCase(),
            path: pathComponent + uritemplate('/face/verify').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(faceVerifyOptionsRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.healthGet = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var healthGetRequest = {
            verb: 'get'.toUpperCase(),
            path: pathComponent + uritemplate('/health').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(healthGetRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.healthOptions = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var healthOptionsRequest = {
            verb: 'options'.toUpperCase(),
            path: pathComponent + uritemplate('/health').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(healthOptionsRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.jobsBulkregisterPost = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var jobsBulkregisterPostRequest = {
            verb: 'post'.toUpperCase(),
            path: pathComponent + uritemplate('/jobs/bulkregister').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(jobsBulkregisterPostRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.jobsBulkregisterOptions = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var jobsBulkregisterOptionsRequest = {
            verb: 'options'.toUpperCase(),
            path: pathComponent + uritemplate('/jobs/bulkregister').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(jobsBulkregisterOptionsRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.jobsBulkregisterBatchIdGet = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['batchId'], ['body']);
        
        var jobsBulkregisterBatchIdGetRequest = {
            verb: 'get'.toUpperCase(),
            path: pathComponent + uritemplate('/jobs/bulkregister/{batchId}').expand(apiGateway.core.utils.parseParametersToObject(params, ['batchId'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(jobsBulkregisterBatchIdGetRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.jobsBulkregisterBatchIdOptions = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['batchId', 'pagingId'], ['body']);
        
        var jobsBulkregisterBatchIdOptionsRequest = {
            verb: 'options'.toUpperCase(),
            path: pathComponent + uritemplate('/jobs/bulkregister/{batchId}').expand(apiGateway.core.utils.parseParametersToObject(params, ['batchId', ])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, ['pagingId']),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(jobsBulkregisterBatchIdOptionsRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.jobsBulkregisterBatchIdPagingIdGet = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['pagingId', 'batchId'], ['body']);
        
        var jobsBulkregisterBatchIdPagingIdGetRequest = {
            verb: 'get'.toUpperCase(),
            path: pathComponent + uritemplate('/jobs/bulkregister/{batchId}/{pagingId}').expand(apiGateway.core.utils.parseParametersToObject(params, ['batchId'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, ['pagingId', ]),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(jobsBulkregisterBatchIdPagingIdGetRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.jobsBulkregisterBatchIdPagingIdOptions = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['batchId', 'pagingId'], ['body']);
        
        var jobsBulkregisterBatchIdPagingIdOptionsRequest = {
            verb: 'options'.toUpperCase(),
            path: pathComponent + uritemplate('/jobs/bulkregister/{batchId}/{pagingId}').expand(apiGateway.core.utils.parseParametersToObject(params, ['batchId', ])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, ['pagingId']),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(jobsBulkregisterBatchIdPagingIdOptionsRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.subjectsGet = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var subjectsGetRequest = {
            verb: 'get'.toUpperCase(),
            path: pathComponent + uritemplate('/subjects').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(subjectsGetRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.subjectsPost = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var subjectsPostRequest = {
            verb: 'post'.toUpperCase(),
            path: pathComponent + uritemplate('/subjects').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(subjectsPostRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.subjectsOptions = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var subjectsOptionsRequest = {
            verb: 'options'.toUpperCase(),
            path: pathComponent + uritemplate('/subjects').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(subjectsOptionsRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.subjectsSubjectIdPut = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['subjectId'], ['body']);
        
        var subjectsSubjectIdPutRequest = {
            verb: 'put'.toUpperCase(),
            path: pathComponent + uritemplate('/subjects/{subjectId}').expand(apiGateway.core.utils.parseParametersToObject(params, ['subjectId'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(subjectsSubjectIdPutRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.subjectsSubjectIdDelete = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['subjectId'], ['body']);
        
        var subjectsSubjectIdDeleteRequest = {
            verb: 'delete'.toUpperCase(),
            path: pathComponent + uritemplate('/subjects/{subjectId}').expand(apiGateway.core.utils.parseParametersToObject(params, ['subjectId'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(subjectsSubjectIdDeleteRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.subjectsSubjectIdOptions = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['subjectId'], ['body']);
        
        var subjectsSubjectIdOptionsRequest = {
            verb: 'options'.toUpperCase(),
            path: pathComponent + uritemplate('/subjects/{subjectId}').expand(apiGateway.core.utils.parseParametersToObject(params, ['subjectId'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(subjectsSubjectIdOptionsRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.subjectsSubjectIdEventsGet = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['subjectId'], ['body']);
        
        var subjectsSubjectIdEventsGetRequest = {
            verb: 'get'.toUpperCase(),
            path: pathComponent + uritemplate('/subjects/{subjectId}/events').expand(apiGateway.core.utils.parseParametersToObject(params, ['subjectId'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(subjectsSubjectIdEventsGetRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.subjectsSubjectIdEventsPost = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['subjectId'], ['body']);
        
        var subjectsSubjectIdEventsPostRequest = {
            verb: 'post'.toUpperCase(),
            path: pathComponent + uritemplate('/subjects/{subjectId}/events').expand(apiGateway.core.utils.parseParametersToObject(params, ['subjectId'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(subjectsSubjectIdEventsPostRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.subjectsSubjectIdEventsOptions = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['subjectId'], ['body']);
        
        var subjectsSubjectIdEventsOptionsRequest = {
            verb: 'options'.toUpperCase(),
            path: pathComponent + uritemplate('/subjects/{subjectId}/events').expand(apiGateway.core.utils.parseParametersToObject(params, ['subjectId'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(subjectsSubjectIdEventsOptionsRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.subjectsSubjectIdEventsEventIdPut = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['eventId', 'subjectId'], ['body']);
        
        var subjectsSubjectIdEventsEventIdPutRequest = {
            verb: 'put'.toUpperCase(),
            path: pathComponent + uritemplate('/subjects/{subjectId}/events/{eventId}').expand(apiGateway.core.utils.parseParametersToObject(params, ['eventId', 'subjectId'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(subjectsSubjectIdEventsEventIdPutRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.subjectsSubjectIdEventsEventIdDelete = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['eventId', 'subjectId'], ['body']);
        
        var subjectsSubjectIdEventsEventIdDeleteRequest = {
            verb: 'delete'.toUpperCase(),
            path: pathComponent + uritemplate('/subjects/{subjectId}/events/{eventId}').expand(apiGateway.core.utils.parseParametersToObject(params, ['eventId', 'subjectId'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(subjectsSubjectIdEventsEventIdDeleteRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.subjectsSubjectIdEventsEventIdOptions = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['eventId', 'subjectId'], ['body']);
        
        var subjectsSubjectIdEventsEventIdOptionsRequest = {
            verb: 'options'.toUpperCase(),
            path: pathComponent + uritemplate('/subjects/{subjectId}/events/{eventId}').expand(apiGateway.core.utils.parseParametersToObject(params, ['eventId', 'subjectId'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(subjectsSubjectIdEventsEventIdOptionsRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.tagsGet = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var tagsGetRequest = {
            verb: 'get'.toUpperCase(),
            path: pathComponent + uritemplate('/tags').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(tagsGetRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.tagsOptions = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, [], ['body']);
        
        var tagsOptionsRequest = {
            verb: 'options'.toUpperCase(),
            path: pathComponent + uritemplate('/tags').expand(apiGateway.core.utils.parseParametersToObject(params, [])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(tagsOptionsRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.tagsNamePut = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['name'], ['body']);
        
        var tagsNamePutRequest = {
            verb: 'put'.toUpperCase(),
            path: pathComponent + uritemplate('/tags/{name}').expand(apiGateway.core.utils.parseParametersToObject(params, ['name'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(tagsNamePutRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.tagsNamePost = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['name'], ['body']);
        
        var tagsNamePostRequest = {
            verb: 'post'.toUpperCase(),
            path: pathComponent + uritemplate('/tags/{name}').expand(apiGateway.core.utils.parseParametersToObject(params, ['name'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(tagsNamePostRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.tagsNameDelete = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['name'], ['body']);
        
        var tagsNameDeleteRequest = {
            verb: 'delete'.toUpperCase(),
            path: pathComponent + uritemplate('/tags/{name}').expand(apiGateway.core.utils.parseParametersToObject(params, ['name'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(tagsNameDeleteRequest, authType, additionalParams, config.apiKey);
    };
    
    
    apigClient.tagsNameOptions = function (params, body, additionalParams) {
        if(additionalParams === undefined) { additionalParams = {}; }
        
        apiGateway.core.utils.assertParametersDefined(params, ['name'], ['body']);
        
        var tagsNameOptionsRequest = {
            verb: 'options'.toUpperCase(),
            path: pathComponent + uritemplate('/tags/{name}').expand(apiGateway.core.utils.parseParametersToObject(params, ['name'])),
            headers: apiGateway.core.utils.parseParametersToObject(params, []),
            queryParams: apiGateway.core.utils.parseParametersToObject(params, []),
            body: body
        };
        
        
        return apiGatewayClient.makeRequest(tagsNameOptionsRequest, authType, additionalParams, config.apiKey);
    };
    

    return apigClient;
};
