package com;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class DAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Item save(Item item){
        entityManager.persist(item);
        return item;
    }

    public Item update(Item item){
        entityManager.merge(item);
        return item;
    }

    public Item delete(long id){
        Item item = entityManager.find(Item.class,id);
        entityManager.remove(item);
        return item;
    }
}
