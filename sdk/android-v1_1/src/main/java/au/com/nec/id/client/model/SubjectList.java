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

import java.util.*;
import au.com.nec.id.client.model.Subject;

public class SubjectList {
    @com.google.gson.annotations.SerializedName("subjects")
    private List<Subject> subjects = null;
    @com.google.gson.annotations.SerializedName("total")
    private Integer total = null;

    /**
     * Gets subjects
     *
     * @return subjects
     **/
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Sets the value of subjects.
     *
     * @param subjects the new value
     */
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     * Gets total
     *
     * @return total
     **/
    public Integer getTotal() {
        return total;
    }

    /**
     * Sets the value of total.
     *
     * @param total the new value
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

}
