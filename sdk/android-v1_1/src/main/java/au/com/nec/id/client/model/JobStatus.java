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


public class JobStatus {
    @com.google.gson.annotations.SerializedName("id")
    private String id = null;
    @com.google.gson.annotations.SerializedName("filename")
    private String filename = null;
    @com.google.gson.annotations.SerializedName("attempts")
    private Integer attempts = null;
    @com.google.gson.annotations.SerializedName("eventId")
    private String eventId = null;
    @com.google.gson.annotations.SerializedName("subjectId")
    private String subjectId = null;
    @com.google.gson.annotations.SerializedName("registerStatus")
    private String registerStatus = null;
    @com.google.gson.annotations.SerializedName("reason")
    private String reason = null;
    @com.google.gson.annotations.SerializedName("status")
    private String status = null;
    @com.google.gson.annotations.SerializedName("attributesJson")
    private String attributesJson = null;

    /**
     * Gets id
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    /**
     * Sets the value of id.
     *
     * @param id the new value
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets filename
     *
     * @return filename
     **/
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the value of filename.
     *
     * @param filename the new value
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Gets attempts
     *
     * @return attempts
     **/
    public Integer getAttempts() {
        return attempts;
    }

    /**
     * Sets the value of attempts.
     *
     * @param attempts the new value
     */
    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    /**
     * Gets eventId
     *
     * @return eventId
     **/
    public String getEventId() {
        return eventId;
    }

    /**
     * Sets the value of eventId.
     *
     * @param eventId the new value
     */
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    /**
     * Gets subjectId
     *
     * @return subjectId
     **/
    public String getSubjectId() {
        return subjectId;
    }

    /**
     * Sets the value of subjectId.
     *
     * @param subjectId the new value
     */
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Gets registerStatus
     *
     * @return registerStatus
     **/
    public String getRegisterStatus() {
        return registerStatus;
    }

    /**
     * Sets the value of registerStatus.
     *
     * @param registerStatus the new value
     */
    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }

    /**
     * Gets reason
     *
     * @return reason
     **/
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of reason.
     *
     * @param reason the new value
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Gets status
     *
     * @return status
     **/
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of status.
     *
     * @param status the new value
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets attributesJson
     *
     * @return attributesJson
     **/
    public String getAttributesJson() {
        return attributesJson;
    }

    /**
     * Sets the value of attributesJson.
     *
     * @param attributesJson the new value
     */
    public void setAttributesJson(String attributesJson) {
        this.attributesJson = attributesJson;
    }

}
