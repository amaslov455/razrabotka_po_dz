package ru.hibernate.project_po.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    private Long id;
    private String group;
    private RecordBook recordBook;
    private Person person;

    public Student() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "student_group")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_book_id")
    public RecordBook getRecordBook() {
        return recordBook;
    }

    public void setRecordBook(RecordBook recordBook) {
        this.recordBook = recordBook;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", group='" + group + '\'' +
                ", recordBook=" + recordBook +
                ", person=" + person +
                '}';
    }
}
