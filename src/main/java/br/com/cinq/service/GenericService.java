/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinq.service;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.logging.Logger;

/**
 *
 * @author William
 * @param <T>
 * @param <ID>
 */
public class GenericService<T, ID extends Serializable> {

    protected EntityManager em;
    private final Logger log = Logger.getLogger(GenericService.class.getName());

    @Transactional
    public T getById(Class classe, Integer id) throws Exception {
        if (id == null) {
            return null;
        }
        return (T) em.find(classe, id);
    }

    @Transactional
    public void remove(T entity) throws Exception {
        em.remove(entity);
    }

    @Transactional
    public T save(T entity) throws Exception {
        if (entity == null) {
            return null;
        }
        if (em.contains(entity)) {
            return entity;
        }

        em.persist(entity);
        em.flush();
        return entity;
    }

    @Transactional
    public T edit(T entity) throws Exception {
        if (entity == null) {
            return null;
        }
        if (em.contains(entity)) {
            return entity;
        }

        em.merge(entity);
        return entity;
    }
}
