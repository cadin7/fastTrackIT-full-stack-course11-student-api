package ro.fasttrackit.homework11.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.homework11.student.model.StudentFilters;
import ro.fasttrackit.homework11.student.model.entity.Student;
import ro.fasttrackit.homework11.student.repository.dao.StudentDao;
import ro.fasttrackit.homework11.student.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentDao studentDao;
    private final StudentRepository studentRepository;

    public List<Student> getAll(StudentFilters studentFilters) {
        return studentDao.findAll(studentFilters);
    }

    public Optional<Student> getStudent(String studentId) {
        return studentRepository.findById(studentId);
    }

    public Student addStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }
}
