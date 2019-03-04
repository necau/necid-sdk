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

import au.com.nec.id.client.model.AttributesFaceArea;
import au.com.nec.id.client.model.AttributesHeadArea;
import au.com.nec.id.client.model.AttributesLeftEyeCenter;
import au.com.nec.id.client.model.AttributesRightEyeCenter;

public class Attributes {
    @com.google.gson.annotations.SerializedName("faceArea")
    private AttributesFaceArea faceArea = null;
    @com.google.gson.annotations.SerializedName("headArea")
    private AttributesHeadArea headArea = null;
    @com.google.gson.annotations.SerializedName("rightEyeCenter")
    private AttributesRightEyeCenter rightEyeCenter = null;
    @com.google.gson.annotations.SerializedName("leftEyeCenter")
    private AttributesLeftEyeCenter leftEyeCenter = null;
    @com.google.gson.annotations.SerializedName("frontalFaceScore")
    private String frontalFaceScore = null;
    @com.google.gson.annotations.SerializedName("faceRoll")
    private String faceRoll = null;
    @com.google.gson.annotations.SerializedName("facePan")
    private String facePan = null;
    @com.google.gson.annotations.SerializedName("faceTilt")
    private String faceTilt = null;
    @com.google.gson.annotations.SerializedName("faceScore")
    private String faceScore = null;
    @com.google.gson.annotations.SerializedName("faceQualityScore")
    private String faceQualityScore = null;

    /**
     * Gets faceArea
     *
     * @return faceArea
     **/
    public AttributesFaceArea getFaceArea() {
        return faceArea;
    }

    /**
     * Sets the value of faceArea.
     *
     * @param faceArea the new value
     */
    public void setFaceArea(AttributesFaceArea faceArea) {
        this.faceArea = faceArea;
    }

    /**
     * Gets headArea
     *
     * @return headArea
     **/
    public AttributesHeadArea getHeadArea() {
        return headArea;
    }

    /**
     * Sets the value of headArea.
     *
     * @param headArea the new value
     */
    public void setHeadArea(AttributesHeadArea headArea) {
        this.headArea = headArea;
    }

    /**
     * Gets rightEyeCenter
     *
     * @return rightEyeCenter
     **/
    public AttributesRightEyeCenter getRightEyeCenter() {
        return rightEyeCenter;
    }

    /**
     * Sets the value of rightEyeCenter.
     *
     * @param rightEyeCenter the new value
     */
    public void setRightEyeCenter(AttributesRightEyeCenter rightEyeCenter) {
        this.rightEyeCenter = rightEyeCenter;
    }

    /**
     * Gets leftEyeCenter
     *
     * @return leftEyeCenter
     **/
    public AttributesLeftEyeCenter getLeftEyeCenter() {
        return leftEyeCenter;
    }

    /**
     * Sets the value of leftEyeCenter.
     *
     * @param leftEyeCenter the new value
     */
    public void setLeftEyeCenter(AttributesLeftEyeCenter leftEyeCenter) {
        this.leftEyeCenter = leftEyeCenter;
    }

    /**
     * Gets frontalFaceScore
     *
     * @return frontalFaceScore
     **/
    public String getFrontalFaceScore() {
        return frontalFaceScore;
    }

    /**
     * Sets the value of frontalFaceScore.
     *
     * @param frontalFaceScore the new value
     */
    public void setFrontalFaceScore(String frontalFaceScore) {
        this.frontalFaceScore = frontalFaceScore;
    }

    /**
     * Gets faceRoll
     *
     * @return faceRoll
     **/
    public String getFaceRoll() {
        return faceRoll;
    }

    /**
     * Sets the value of faceRoll.
     *
     * @param faceRoll the new value
     */
    public void setFaceRoll(String faceRoll) {
        this.faceRoll = faceRoll;
    }

    /**
     * Gets facePan
     *
     * @return facePan
     **/
    public String getFacePan() {
        return facePan;
    }

    /**
     * Sets the value of facePan.
     *
     * @param facePan the new value
     */
    public void setFacePan(String facePan) {
        this.facePan = facePan;
    }

    /**
     * Gets faceTilt
     *
     * @return faceTilt
     **/
    public String getFaceTilt() {
        return faceTilt;
    }

    /**
     * Sets the value of faceTilt.
     *
     * @param faceTilt the new value
     */
    public void setFaceTilt(String faceTilt) {
        this.faceTilt = faceTilt;
    }

    /**
     * Gets faceScore
     *
     * @return faceScore
     **/
    public String getFaceScore() {
        return faceScore;
    }

    /**
     * Sets the value of faceScore.
     *
     * @param faceScore the new value
     */
    public void setFaceScore(String faceScore) {
        this.faceScore = faceScore;
    }

    /**
     * Gets faceQualityScore
     *
     * @return faceQualityScore
     **/
    public String getFaceQualityScore() {
        return faceQualityScore;
    }

    /**
     * Sets the value of faceQualityScore.
     *
     * @param faceQualityScore the new value
     */
    public void setFaceQualityScore(String faceQualityScore) {
        this.faceQualityScore = faceQualityScore;
    }

}
