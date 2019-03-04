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

import au.com.nec.id.client.model.Attributes;
import au.com.nec.id.client.model.Candidate;
import java.util.*;

public class SearchResult {
    @com.google.gson.annotations.SerializedName("candidates")
    private List<Candidate> candidates = null;
    @com.google.gson.annotations.SerializedName("attributes")
    private Attributes attributes = null;

    /**
     * Gets candidates
     *
     * @return candidates
     **/
    public List<Candidate> getCandidates() {
        return candidates;
    }

    /**
     * Sets the value of candidates.
     *
     * @param candidates the new value
     */
    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    /**
     * Gets attributes
     *
     * @return attributes
     **/
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of attributes.
     *
     * @param attributes the new value
     */
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

}
