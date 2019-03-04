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

package au.com.nec.id.client;

import java.util.*;

import au.com.nec.id.client.model.ExtractResult;
import au.com.nec.id.client.model.SearchResult;
import au.com.nec.id.client.model.Candidate;
import au.com.nec.id.client.model.Job;
import au.com.nec.id.client.model.JobSummary;
import au.com.nec.id.client.model.SubjectList;
import au.com.nec.id.client.model.Subject;
import au.com.nec.id.client.model.Events;
import au.com.nec.id.client.model.Event;
import au.com.nec.id.client.model.Tag;


@com.amazonaws.mobileconnectors.apigateway.annotation.Service(endpoint = "https://api.id.nec.com.au/v1.1")
public interface CoreAPIClient {


    /**
     * A generic invoker to invoke any API Gateway endpoint.
     * @param request
     * @return ApiResponse
     */
    com.amazonaws.mobileconnectors.apigateway.ApiResponse execute(com.amazonaws.mobileconnectors.apigateway.ApiRequest request);
    
    /**
     * 
     * 
     * @return ExtractResult
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/face/extract", method = "POST")
    ExtractResult faceExtractPost();
    
    /**
     * 
     * 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/face/extract", method = "OPTIONS")
    void faceExtractOptions();
    
    /**
     * 
     * 
     * @return SearchResult
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/face/search", method = "POST")
    SearchResult faceSearchPost();
    
    /**
     * 
     * 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/face/search", method = "OPTIONS")
    void faceSearchOptions();
    
    /**
     * 
     * 
     * @return Candidate
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/face/verify", method = "POST")
    Candidate faceVerifyPost();
    
    /**
     * 
     * 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/face/verify", method = "OPTIONS")
    void faceVerifyOptions();
    
    /**
     * 
     * 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/health", method = "GET")
    void healthGet();
    
    /**
     * 
     * 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/health", method = "OPTIONS")
    void healthOptions();
    
    /**
     * 
     * 
     * @return Job
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/jobs/bulkregister", method = "POST")
    Job jobsBulkregisterPost();
    
    /**
     * 
     * 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/jobs/bulkregister", method = "OPTIONS")
    void jobsBulkregisterOptions();
    
    /**
     * 
     * 
     * @param batchId 
     * @return JobSummary
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/jobs/bulkregister/{batchId}", method = "GET")
    JobSummary jobsBulkregisterBatchIdGet(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "batchId", location = "path")
            String batchId);
    
    /**
     * 
     * 
     * @param batchId 
     * @param pagingId 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/jobs/bulkregister/{batchId}", method = "OPTIONS")
    void jobsBulkregisterBatchIdOptions(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "batchId", location = "path")
            String batchId,
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "pagingId", location = "query")
            String pagingId);
    
    /**
     * 
     * 
     * @param pagingId 
     * @param batchId 
     * @return JobSummary
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/jobs/bulkregister/{batchId}/{pagingId}", method = "GET")
    JobSummary jobsBulkregisterBatchIdPagingIdGet(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "pagingId", location = "query")
            String pagingId,
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "batchId", location = "path")
            String batchId);
    
    /**
     * 
     * 
     * @param batchId 
     * @param pagingId 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/jobs/bulkregister/{batchId}/{pagingId}", method = "OPTIONS")
    void jobsBulkregisterBatchIdPagingIdOptions(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "batchId", location = "path")
            String batchId,
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "pagingId", location = "query")
            String pagingId);
    
    /**
     * 
     * 
     * @return SubjectList
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/subjects", method = "GET")
    SubjectList subjectsGet();
    
    /**
     * 
     * 
     * @return Subject
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/subjects", method = "POST")
    Subject subjectsPost();
    
    /**
     * 
     * 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/subjects", method = "OPTIONS")
    void subjectsOptions();
    
    /**
     * 
     * 
     * @param subjectId 
     * @return Subject
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/subjects/{subjectId}", method = "PUT")
    Subject subjectsSubjectIdPut(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "subjectId", location = "path")
            String subjectId);
    
    /**
     * 
     * 
     * @param subjectId 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/subjects/{subjectId}", method = "DELETE")
    void subjectsSubjectIdDelete(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "subjectId", location = "path")
            String subjectId);
    
    /**
     * 
     * 
     * @param subjectId 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/subjects/{subjectId}", method = "OPTIONS")
    void subjectsSubjectIdOptions(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "subjectId", location = "path")
            String subjectId);
    
    /**
     * 
     * 
     * @param subjectId 
     * @return Events
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/subjects/{subjectId}/events", method = "GET")
    Events subjectsSubjectIdEventsGet(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "subjectId", location = "path")
            String subjectId);
    
    /**
     * 
     * 
     * @param subjectId 
     * @return Event
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/subjects/{subjectId}/events", method = "POST")
    Event subjectsSubjectIdEventsPost(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "subjectId", location = "path")
            String subjectId);
    
    /**
     * 
     * 
     * @param subjectId 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/subjects/{subjectId}/events", method = "OPTIONS")
    void subjectsSubjectIdEventsOptions(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "subjectId", location = "path")
            String subjectId);
    
    /**
     * 
     * 
     * @param eventId 
     * @param subjectId 
     * @return Event
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/subjects/{subjectId}/events/{eventId}", method = "PUT")
    Event subjectsSubjectIdEventsEventIdPut(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "eventId", location = "path")
            String eventId,
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "subjectId", location = "path")
            String subjectId);
    
    /**
     * 
     * 
     * @param eventId 
     * @param subjectId 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/subjects/{subjectId}/events/{eventId}", method = "DELETE")
    void subjectsSubjectIdEventsEventIdDelete(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "eventId", location = "path")
            String eventId,
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "subjectId", location = "path")
            String subjectId);
    
    /**
     * 
     * 
     * @param eventId 
     * @param subjectId 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/subjects/{subjectId}/events/{eventId}", method = "OPTIONS")
    void subjectsSubjectIdEventsEventIdOptions(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "eventId", location = "path")
            String eventId,
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "subjectId", location = "path")
            String subjectId);
    
    /**
     * 
     * 
     * @return Tag
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/tags", method = "GET")
    Tag tagsGet();
    
    /**
     * 
     * 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/tags", method = "OPTIONS")
    void tagsOptions();
    
    /**
     * 
     * 
     * @param name 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/tags/{name}", method = "PUT")
    void tagsNamePut(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "name", location = "path")
            String name);
    
    /**
     * 
     * 
     * @param name 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/tags/{name}", method = "POST")
    void tagsNamePost(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "name", location = "path")
            String name);
    
    /**
     * 
     * 
     * @param name 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/tags/{name}", method = "DELETE")
    void tagsNameDelete(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "name", location = "path")
            String name);
    
    /**
     * 
     * 
     * @param name 
     * @return void
     */
    @com.amazonaws.mobileconnectors.apigateway.annotation.Operation(path = "/tags/{name}", method = "OPTIONS")
    void tagsNameOptions(
            @com.amazonaws.mobileconnectors.apigateway.annotation.Parameter(name = "name", location = "path")
            String name);
    
}

