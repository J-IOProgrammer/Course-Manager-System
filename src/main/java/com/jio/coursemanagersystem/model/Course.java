package com.jio.coursemanagersystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("courses")
public class Course {
    @Id
    private Long id;
    private String name;
}
