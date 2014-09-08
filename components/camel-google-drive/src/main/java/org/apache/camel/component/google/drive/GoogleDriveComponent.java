/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.google.drive;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.util.component.AbstractApiComponent;
import org.apache.camel.component.google.drive.internal.DriveFilesApiMethod;
import org.apache.camel.component.google.drive.internal.GoogleDriveApiCollection;
import org.apache.camel.component.google.drive.internal.GoogleDriveApiName;

/**
 * Represents the component that manages {@link GoogleDriveEndpoint}.
 */
@UriEndpoint(scheme = "google-drive", consumerClass = GoogleDriveConsumer.class, consumerPrefix = "consumer")
public class GoogleDriveComponent extends AbstractApiComponent<GoogleDriveApiName, GoogleDriveConfiguration, GoogleDriveApiCollection> {

    public GoogleDriveComponent() {
        super(GoogleDriveEndpoint.class, GoogleDriveApiName.class, GoogleDriveApiCollection.getCollection());
    }

    public GoogleDriveComponent(CamelContext context) {
        super(context, GoogleDriveEndpoint.class, GoogleDriveApiName.class, GoogleDriveApiCollection.getCollection());
    }

    @Override
    protected GoogleDriveApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return GoogleDriveApiName.fromValue(apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, GoogleDriveApiName apiName,
                                      GoogleDriveConfiguration endpointConfiguration) {
        return new GoogleDriveEndpoint(uri, this, apiName, methodName, endpointConfiguration);
    }
}
