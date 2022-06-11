package ru.hibernate.project_po.entity;

import jakarta.persistence.PreRemove;
import ru.hibernate.project_po.entity.Student;

// Перед удалением выводим студента
public class StudentListener {
    @PreRemove
    private void beforeRemove(Student student){
        System.out.println("Удаление студента: " + student.toString());
    }
}
