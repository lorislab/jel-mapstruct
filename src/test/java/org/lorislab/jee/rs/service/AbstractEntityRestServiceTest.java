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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lorislab.jee.exception.ServiceException;
import org.lorislab.jee.rs.mapper.model.Entity;
import org.lorislab.jee.rs.mapper.model.EntityDTO;

/**
 *
 * @author andrej
 */
public class AbstractEntityRestServiceTest {

    @Test
    public void createTest() throws Exception {
        EntityDTO dto = new EntityDTO();
        dto.setName("NAME");

        EntityRestServiceImpl rs = new EntityRestServiceImpl(new EntityServiceImpl() {
            @Override
            public Entity create(Entity entity) throws ServiceException {
                Assertions.assertNotNull(entity);
                Assertions.assertEquals(dto.getName(), entity.getName());
                return entity;
            }
        });

        EntityDTO result = rs.create(dto);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(dto.getName(), result.getName());
    }
}
