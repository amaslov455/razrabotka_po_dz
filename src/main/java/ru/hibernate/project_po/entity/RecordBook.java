package ru.hibernate.project_po.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "record_book")
public class RecordBook {
    private Long id;
    private Integer code;

    public RecordBook() {
    }

    public RecordBook(Integer code) {
        this.code = code;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true)
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RecordBook{" +
                "id=" + id +
                ", code=" + code +
                '}';
    }
}
