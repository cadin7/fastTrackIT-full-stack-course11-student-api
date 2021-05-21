package ro.fasttrackit.homework11.student.repository.dao;

import org.springframework.stereotype.Repository;
import ro.fasttrackit.homework11.student.model.entity.Student;
import ro.fasttrackit.homework11.student.model.StudentFilters;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

@Repository
public class StudentDao {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public StudentDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        criteriaBuilder = this.entityManager.getCriteriaBuilder();
    }

    public List<Student> findAll(StudentFilters studentFilters) {
        CriteriaQuery<Student> studentCriteria = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = studentCriteria.from(Student.class);

        CriteriaQuery<Student> query = studentCriteria.select(studentRoot)
                .where(getWhereClause(studentFilters, studentRoot).toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }

    private List<Predicate> getWhereClause(StudentFilters studentFilters, Root<Student> studentRoot) {
        List<Predicate> whereClause = new ArrayList<>();
        ofNullable(studentFilters.getName())
                .ifPresent(name -> whereClause.add(criteriaBuilder.equal(studentRoot.get("name"), name)));
        ofNullable(studentFilters.getAge())
                .ifPresent(age -> whereClause.add(criteriaBuilder.equal(studentRoot.get("age"), age)));
        ofNullable(studentFilters.getMinAge())
                .ifPresent(minAge -> whereClause.add(criteriaBuilder.gt(studentRoot.get("age"), minAge)));
        ofNullable(studentFilters.getMaxAge())
                .ifPresent(maxAge -> whereClause.add(criteriaBuilder.lt(studentRoot.get("age"), maxAge)));
        ofNullable(studentFilters.getStudentId())
                .ifPresent(studentId -> whereClause.add(criteriaBuilder.equal(studentRoot.get("id"), studentId)));
        return whereClause;
    }
}
