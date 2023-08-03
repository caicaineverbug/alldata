/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.manager.dao.mapper;

import org.apache.inlong.manager.common.tenant.MultiTenantQuery;
import org.apache.inlong.manager.dao.entity.WorkflowApproverEntity;
import org.apache.inlong.manager.pojo.workflow.ApproverPageRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@MultiTenantQuery
public interface WorkflowApproverEntityMapper {

    int insert(WorkflowApproverEntity record);

    WorkflowApproverEntity selectById(Integer id);

    List<WorkflowApproverEntity> selectByCondition(ApproverPageRequest request);

    int updateById(WorkflowApproverEntity record);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("modifier") String modifier);

}
