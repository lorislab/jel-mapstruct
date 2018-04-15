package org.lorislab.jee.rs.service;

import java.util.List;
import java.util.Map;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.lorislab.jee.exception.ServiceException;
import org.lorislab.jee.jpa.model.Persistent;
import org.lorislab.jee.jpa.service.AbstractEntityService;
import org.lorislab.jee.rs.mapper.AbstractEntityMapper;
import org.lorislab.jee.rs.service.EntityRestService;


/**
 * The abstract rest entity service.
 *
 * @param <ENTITY> the entity model type.
 * @param <DTO> the DTO model type.
 * 
 * @author Andrej Petras
 */
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public abstract class AbstractEntityRestService<ENTITY extends Persistent, DTO> implements EntityRestService<DTO> {

    /**
     * Gets the entity mapper.
     *
     * @return the entity mapper.
     */
    protected abstract AbstractEntityMapper<ENTITY, DTO> getMapper();

    /**
     * Gets the entity service.
     *
     * @return the entity service.
     */
    protected abstract AbstractEntityService<ENTITY> getService();

    /**
     * {@inheritDoc }
     */
    @Override
    public List<DTO> find(Integer from, Integer count) throws ServiceException {
        List<ENTITY> tmp = getService().find(from, count);
        return getMapper().finds(tmp);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public DTO findByGuid(String guid) throws ServiceException {
        ENTITY tmp = getService().findByGuid(guid);
        return getMapper().find(tmp);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<DTO> findByGuids(List<String> guids) throws ServiceException {
        List<ENTITY> tmp = getService().findByGuids((List)guids);
        return getMapper().finds(tmp);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    @SuppressWarnings("unchecked")
    public Map<String, DTO> findByGuidsMap(List<String> guids) throws ServiceException {
        Map<String, ENTITY> tmp = getService().findByGuidsMap((List)guids);
        return getMapper().findsMap(tmp);
    }
            
    /**
     * {@inheritDoc }
     */
    @Override
    public DTO update(String guid, DTO object) throws ServiceException {
        ENTITY conf = getService().loadByGuid(guid);
        getMapper().update(conf, object);
        conf = getService().update(conf);
        return getMapper().find(conf);
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public DTO create(DTO object) throws ServiceException {
        ENTITY tmp = getMapper().create(object);
        ENTITY conf = getService().create(tmp);
        return getMapper().find(conf);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int deleteAll() throws ServiceException {
        return getService().deleteAll();
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public boolean deleteByGuid(String guid) throws ServiceException {
        return getService().deleteByGuid(guid);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    @SuppressWarnings("unchecked")
    public int deleteByGuids(List<String> guids) throws ServiceException {
        return getService().deleteByGuids((List) guids);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<DTO> loadAll() throws ServiceException {
        List<ENTITY> tmp = getService().loadAll();
        return getMapper().loads(tmp);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public DTO loadByGuid(String guid) throws ServiceException {
        ENTITY tmp = getService().loadByGuid(guid);
        return getMapper().load(tmp);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<DTO> loadByGuids(List<String> guids) throws ServiceException {
        List<ENTITY> tmp = getService().loadByGuids((List) guids);
        return getMapper().loads(tmp);
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    @SuppressWarnings("unchecked")
    public Map<String, DTO> loadByGuidsMap(List<String> guids) throws ServiceException {
        Map<String, ENTITY> tmp = getService().loadByGuidsMap((List)guids);
        return getMapper().findsMap(tmp);
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public int deleteQueryAll() throws ServiceException {
        return getService().deleteQueryAll();
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public boolean deleteQueryByGuid(String guid) throws ServiceException {
        return getService().deleteQueryByGuid(guid);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    @SuppressWarnings("unchecked")
    public int deleteQueryByGuids(List<String> guids) throws ServiceException {
        return getService().deleteQueryByGuids((List)guids);
    }
   
}
