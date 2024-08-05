package com.example.education3.student.repo;

import com.example.education3.student.entity.Teacher;
import com.example.education3.student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomTeacherRepo {

    private final EntityManager em;

    public CustomTeacherRepo(EntityManager em) {
        this.em = em;
    }

    public List<Teacher> getList(String name,
                                 String surname,
                                 String email,
                                 Integer universityId,
                                 Integer age) {

        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Teacher> cq = cb.createQuery(Teacher.class);
        final Root<Teacher> root = cq.from(Teacher.class);

        final List<Predicate> predicates = new ArrayList<>();
        if(name != null && !name.isEmpty()) {
            predicates.add(cb.like(root.get("firstName"), "%" + name + "%"));
        }
        if(surname != null && !surname.isEmpty()) {
            predicates.add(cb.like(root.get("surname"), "%" + surname + "%"));
        }
        if(email != null && !email.isEmpty()) {
            predicates.add(cb.like(root.get("email"), "%" + email + "%"));
        }
        if(age != null) {
            predicates.add(cb.equal(root.get("age"), age));
        }
        if(universityId != null) {
            predicates.add(cb.equal(root.get("university").get("id"), universityId));
        }

        final Predicate and = cb.and(predicates.toArray(new Predicate[0]));

        cq.where(and);
        cq.select(root);

        return em.createQuery(cq).getResultList();
    }

    public List<Object[]> getTeachersAndStudents(String teacherName,
                                                 String studentName,
                                                 Integer universityId) {

        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        final Root<Teacher> teacherRoot = cq.from(Teacher.class);
        final Root<Student> studentRoot = cq.from(Student.class);

        final List<Predicate> predicates = new ArrayList<>();
        if (teacherName != null && !teacherName.isEmpty()) {
            predicates.add(cb.like(teacherRoot.get("firstName"), "%" + teacherName + "%"));
        }
        if (studentName != null && !studentName.isEmpty()) {
            predicates.add(cb.like(studentRoot.get("firstName"), "%" + studentName + "%"));
        }
        if (universityId != null) {
            predicates.add(cb.equal(teacherRoot.get("university").get("id"), universityId));
            predicates.add(cb.equal(studentRoot.get("university").get("id"), universityId));
        }

        final Predicate and = cb.and(predicates.toArray(new Predicate[0]));
        cq.where(and);

        cq.multiselect(teacherRoot, studentRoot);

        return em.createQuery(cq).getResultList();
    }
}
