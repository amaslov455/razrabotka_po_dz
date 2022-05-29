package ru.hibernate.project_po.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, Person> person;
	public static volatile SingularAttribute<Student, Long> id;
	public static volatile SingularAttribute<Student, String> group;
	public static volatile SingularAttribute<Student, RecordBook> recordBook;

	public static final String PERSON = "person";
	public static final String ID = "id";
	public static final String GROUP = "group";
	public static final String RECORD_BOOK = "recordBook";

}

