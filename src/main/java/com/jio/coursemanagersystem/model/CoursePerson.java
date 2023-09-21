package com.jio.coursemanagersystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("course_person")
public class CoursePerson {
    @Id
    private Long id;

    @Column("course_id")
    private Long courseId;

    @Column("person_id")
    private Long personId;
}
