import jakarta.persistence.EntityManager;
import ru.hibernate.project_po.dao.PersonDAO;
import ru.hibernate.project_po.dao.RecordBookDAO;
import ru.hibernate.project_po.dao.StudentDAO;
import ru.hibernate.project_po.entity.Person;
import ru.hibernate.project_po.entity.RecordBook;
import ru.hibernate.project_po.entity.Student;
import ru.hibernate.project_po.utils.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MainApp {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateSessionFactory.getSessionFactory().createEntityManager();
        PersonDAO personDAO = new PersonDAO(entityManager);
        RecordBookDAO recordBookDAO = new RecordBookDAO(entityManager);
        StudentDAO studentDAO = new StudentDAO(entityManager);

        entityManager.getTransaction().begin();
        List<Person> persons = new ArrayList<>();
        List<String> lastNames = Arrays.asList("Субботина", "Тарасова", "Егоров", "Николаев", "Волошин", "Щеглова", "Степанов", "Казаков", "Попова", "Борисова");
        List<String> firstNames = Arrays.asList("Алиса", "Агата", "Савелий", "Лев", "Артем", "Любовь", "Лев", "Николай", "Полина", "Анна");
        List<String> middleNames = Arrays.asList("Демидовна", "Максимовна", "Семенович", "Максимович", "Юрьевич", "Максимовна", "Мирославович", "Филиппович", "Данииловна", "Данииловна");

        for (int i = 0; i < 10; i++) {
            persons.add(
                    new Person(
                            ThreadLocalRandom.current().nextInt(1000, 10000),
                            ThreadLocalRandom.current().nextInt(1000, 10000),
                            lastNames.get(i),
                            firstNames.get(i),
                            middleNames.get(i)
                    )
            );
        }

        persons.forEach(personDAO::save);

        // Создание случайного количества зачетных книжек
        List<RecordBook> recordBooks = new ArrayList<>();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(1, 9); i++) {
            RecordBook recordBook = new RecordBook(ThreadLocalRandom.current().nextInt(100, 1000));
            recordBooks.add(recordBook);
            recordBookDAO.save(recordBook);
        }

        // Создание 10 студентов
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setPerson(persons.get(i));
            student.setGroup(Integer.toString(ThreadLocalRandom.current().nextInt(100, 1000)));
            if (i < recordBooks.size()) {
                student.setRecordBook(recordBooks.get(i));
            }
            studentDAO.save(student);
        }

        entityManager.getTransaction().commit();

        // Пункт 5.4 дз
        System.out.println("Выбор студентов с символом 'a' (HQL)");
        studentDAO.selectByFIOinHQLwithStringPattern("%а%").forEach(System.out::println);

        System.out.println("Выбор студентов с символом 'a' (Criteria)");
        studentDAO.selectByFIOinCriteriaWithStringPattern("%а%").forEach(System.out::println);

        // Пункт 5.5 дз
        System.out.println("Выбор студентов без зачетной книжки (Criteria)");
        studentDAO.selectByRBbyHQLStudentsWithoutRB().forEach(System.out::println);

        System.out.println("Выбор студентов без зачетной книжки (Criteria)");
        studentDAO.selectByRBbyCriteriaStudentsWithoutRB().forEach(System.out::println);

        entityManager.close();
    }
}
