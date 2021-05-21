package ro.fasttrackit.homework11.student.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.homework11.student.model.entity.Student;
import ro.fasttrackit.homework11.student.model.StudentFilters;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {
}
