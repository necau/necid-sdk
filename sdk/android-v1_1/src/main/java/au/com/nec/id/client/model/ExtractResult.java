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
import java.util.*;

public class ExtractResult {
    @com.google.gson.annotations.SerializedName("faces")
    private List<Attributes> faces = null;

    /**
     * Gets faces
     *
     * @return faces
     **/
    public List<Attributes> getFaces() {
        return faces;
    }

    /**
     * Sets the value of faces.
     *
     * @param faces the new value
     */
    public void setFaces(List<Attributes> faces) {
        this.faces = faces;
    }

}
