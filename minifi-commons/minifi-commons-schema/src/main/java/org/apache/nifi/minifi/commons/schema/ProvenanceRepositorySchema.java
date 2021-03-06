/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.nifi.minifi.commons.schema;

import org.apache.nifi.minifi.commons.schema.common.BaseSchema;
import org.apache.nifi.minifi.commons.schema.common.WritableSchema;

import java.util.Map;

import static org.apache.nifi.minifi.commons.schema.common.CommonPropertyKeys.PROVENANCE_REPO_KEY;

public class ProvenanceRepositorySchema extends BaseSchema implements WritableSchema {

    public static final String PROVENANCE_REPO_ROLLOVER_TIME_KEY = "provenance rollover time";
    public static final String DEFAULT_PROVENANCE_ROLLOVER_TIME = "1 min";

    public static final String PROVENANCE_REPOSITORY_KEY = "implementation";
    public static final String DEFAULT_PROVENANCE_REPOSITORY = "org.apache.nifi.provenance.MiNiFiPersistentProvenanceRepository";

    private String provenanceRepoRolloverTime = DEFAULT_PROVENANCE_ROLLOVER_TIME;
    private String provenanceRepository = DEFAULT_PROVENANCE_REPOSITORY;

    public ProvenanceRepositorySchema(){
    }

    public ProvenanceRepositorySchema(Map map) {
        provenanceRepoRolloverTime = getOptionalKeyAsType(map, PROVENANCE_REPO_ROLLOVER_TIME_KEY, String.class,
                PROVENANCE_REPO_KEY, DEFAULT_PROVENANCE_ROLLOVER_TIME);
        provenanceRepository = getOptionalKeyAsType(map, PROVENANCE_REPOSITORY_KEY, String.class,
                PROVENANCE_REPO_KEY, DEFAULT_PROVENANCE_REPOSITORY);
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> result = mapSupplier.get();
        result.put(PROVENANCE_REPO_ROLLOVER_TIME_KEY, provenanceRepoRolloverTime);
        result.put(PROVENANCE_REPOSITORY_KEY, provenanceRepository);
        return result;
    }

    public String getProvenanceRepository() {
        return provenanceRepository;
    }

    public String getProvenanceRepoRolloverTimeKey() {
        return provenanceRepoRolloverTime;
    }
}
