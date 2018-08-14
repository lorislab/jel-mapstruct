/*
 * Copyright 2018 andrej.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lorislab.jee.rs.service;

import org.lorislab.jee.jpa.service.AbstractEntityService;
import org.lorislab.jee.rs.mapper.AbstractEntityMapper;
import org.lorislab.jee.rs.mapper.EntityMapperImpl;
import org.lorislab.jee.rs.mapper.model.Entity;
import org.lorislab.jee.rs.mapper.model.EntityDTO;

/**
 *
 * @author andrej
 */
public class EntityRestServiceImpl extends AbstractEntityRestService<Entity, EntityDTO, String> {

    private AbstractEntityService<Entity, String> service;

    public EntityRestServiceImpl(AbstractEntityService<Entity, String> service) {
        this.service = service;
    }
    
    @Override
    protected AbstractEntityMapper<Entity, EntityDTO, String> getMapper() {
        return new EntityMapperImpl();
    }

    @Override
    protected AbstractEntityService<Entity, String> getService() {
        return service;
    }
    
}
