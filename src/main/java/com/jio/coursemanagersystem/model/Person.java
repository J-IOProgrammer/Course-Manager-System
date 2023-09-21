package com.jio.coursemanagersystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("persons")
public class Person {
    @Id
    private Long id;
    private String name;
}
