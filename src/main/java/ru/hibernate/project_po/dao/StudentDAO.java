package ru.hibernate.project_po.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import ru.hibernate.project_po.entity.Person;
import ru.hibernate.project_po.entity.Student;

import java.util.List;

public class StudentDAO {
    private EntityManager entityManager;

    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Student student) {
        entityManager.persist(student);
    }

    public void delete(Student student) {
        entityManager.remove(student);
    }

    public List<Student> findAll() {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Student> selectByFIOinHQLwithStringPattern(String pattern) {
        return entityManager.createQuery("""
                select s
                from Student s
                join s.person p
                where p.firstName like :pattern or p.lastName like :pattern or p.middleName like :pattern
                """, Student.class).setParameter("pattern", pattern).getResultList();
    }

    public List<Student> selectByFIOinCriteriaWithStringPattern(String pattern) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        Join<Student, Person> join = root.join("person");
        query.select(root)
                .where(criteriaBuilder
                        .or(criteriaBuilder.like(join.get("firstName"), pattern),
                                criteriaBuilder.like(join.get("lastName"), pattern),
                                criteriaBuilder.like(join.get("middleName"), pattern)));
        return entityManager
                .createQuery(query)
                .getResultList();
    }

    public List<Student> selectByRBbyHQLStudentsWithoutRB() {
        return entityManager.createQuery("""
                        select s
                        from Student s
                        where s.recordBook is not null
                        """, Student.class)
                .getResultList();
    }

    public List<Student> selectByRBbyCriteriaStudentsWithoutRB() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root)
                .where(criteriaBuilder.isNotNull(root.get("recordBook")));
        return entityManager
                .createQuery(query)
                .getResultList();
    }
}
