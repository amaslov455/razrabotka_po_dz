package ru.hibernate.project_po.dao;

import jakarta.persistence.EntityManager;
import ru.hibernate.project_po.entity.RecordBook;

import java.util.List;

public class RecordBookDAO {
    private EntityManager entityManager;

    public RecordBookDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(RecordBook recordBook) {
        entityManager.persist(recordBook);
    }

    public void delete(RecordBook recordBook) {
        entityManager.remove(recordBook);
    }

    public List<RecordBook> findAll() {
        return entityManager.createQuery("from RecordBook", RecordBook.class).getResultList();
    }

    public RecordBook findById(Long id) {
        return entityManager.find(RecordBook.class, id);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
