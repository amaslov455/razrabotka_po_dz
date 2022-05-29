package ru.hibernate.yarullin.homework.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ {

	public static volatile SingularAttribute<Person, Integer> passportNumber;
	public static volatile SingularAttribute<Person, String> lastName;
	public static volatile SingularAttribute<Person, String> firstName;
	public static volatile SingularAttribute<Person, String> middleName;
	public static volatile SingularAttribute<Person, Long> id;
	public static volatile SingularAttribute<Person, Integer> passportSeries;

	public static final String PASSPORT_NUMBER = "passportNumber";
	public static final String LAST_NAME = "lastName";
	public static final String FIRST_NAME = "firstName";
	public static final String MIDDLE_NAME = "middleName";
	public static final String ID = "id";
	public static final String PASSPORT_SERIES = "passportSeries";

}

