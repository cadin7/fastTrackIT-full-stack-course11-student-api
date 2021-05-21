package ro.fasttrackit.homework11.student.model.entity;

import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Value
@Document
public class Student {
    @Id
    String id;

    String name;
    int age;
}
