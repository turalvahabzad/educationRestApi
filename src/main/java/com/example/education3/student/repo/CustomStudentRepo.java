package com.example.education3.student.repo;
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
public class CustomStudentRepo {

    private final EntityManager em;

    public CustomStudentRepo(final EntityManager em) {
        this.em = em;
    }

    public List<Student> getList(String name,
                                 String surname,
                                 String email,
                                 Integer universityId,
                                 Integer age) {

        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        final Root<Student> root = cq.from(Student.class);
        final List<Predicate> predicates = new ArrayList<>();
        if(name!=null && !name.isEmpty()) {
            predicates.add(cb.like(root.get("firstName"), "%" + name + "%"));
        }
        if(surname!=null && !surname.isEmpty()) {
            predicates.add(cb.like(root.get("surname"), "%" + surname + "%"));
        }
        if(email!=null && !email.isEmpty()) {
            predicates.add(cb.like(root.get("email"), "%" + email + "%"));
        }
        if(age!=null) {
            predicates.add(cb.equal(root.get("age"), age));
        }
        if(universityId!=null) {
            predicates.add(cb.equal(root.get("university").get("id"), universityId));
        }

        final Predicate and = cb.and(predicates.toArray(new Predicate[0]));

        cq.where(and);//where name like %name% and surname like %surname%
        cq.select(root);//select * from student where name like %name% and surname like %surname%

        return em.createQuery(cq).getResultList();
    }

}
