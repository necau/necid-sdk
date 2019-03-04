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


public class AttributesHeadArea {
    @com.google.gson.annotations.SerializedName("left")
    private String left = null;
    @com.google.gson.annotations.SerializedName("top")
    private String top = null;
    @com.google.gson.annotations.SerializedName("right")
    private String right = null;
    @com.google.gson.annotations.SerializedName("bottom")
    private String bottom = null;

    /**
     * Gets left
     *
     * @return left
     **/
    public String getLeft() {
        return left;
    }

    /**
     * Sets the value of left.
     *
     * @param left the new value
     */
    public void setLeft(String left) {
        this.left = left;
    }

    /**
     * Gets top
     *
     * @return top
     **/
    public String getTop() {
        return top;
    }

    /**
     * Sets the value of top.
     *
     * @param top the new value
     */
    public void setTop(String top) {
        this.top = top;
    }

    /**
     * Gets right
     *
     * @return right
     **/
    public String getRight() {
        return right;
    }

    /**
     * Sets the value of right.
     *
     * @param right the new value
     */
    public void setRight(String right) {
        this.right = right;
    }

    /**
     * Gets bottom
     *
     * @return bottom
     **/
    public String getBottom() {
        return bottom;
    }

    /**
     * Sets the value of bottom.
     *
     * @param bottom the new value
     */
    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

}
