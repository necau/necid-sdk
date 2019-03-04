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

package au.com.nec.id.client.model;

import au.com.nec.id.client.model.JobStatus;
import java.util.*;

public class JobSummary {
    @com.google.gson.annotations.SerializedName("batchId")
    private String batchId = null;
    @com.google.gson.annotations.SerializedName("processed")
    private List<JobStatus> processed = null;
    @com.google.gson.annotations.SerializedName("lastEvaluatedKey")
    private String lastEvaluatedKey = null;

    /**
     * Gets batchId
     *
     * @return batchId
     **/
    public String getBatchId() {
        return batchId;
    }

    /**
     * Sets the value of batchId.
     *
     * @param batchId the new value
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    /**
     * Gets processed
     *
     * @return processed
     **/
    public List<JobStatus> getProcessed() {
        return processed;
    }

    /**
     * Sets the value of processed.
     *
     * @param processed the new value
     */
    public void setProcessed(List<JobStatus> processed) {
        this.processed = processed;
    }

    /**
     * Gets lastEvaluatedKey
     *
     * @return lastEvaluatedKey
     **/
    public String getLastEvaluatedKey() {
        return lastEvaluatedKey;
    }

    /**
     * Sets the value of lastEvaluatedKey.
     *
     * @param lastEvaluatedKey the new value
     */
    public void setLastEvaluatedKey(String lastEvaluatedKey) {
        this.lastEvaluatedKey = lastEvaluatedKey;
    }

}
