package ro.fasttrackit.homework11.student.model;

import lombok.Value;

@Value
public class StudentFilters {
    String name;
    Integer age;
    Integer minAge;
    Integer maxAge;
    String studentId;
}
