package com.example.dealapps.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * @author NEJMEDDINE Ayoub
 * @created 04/08/2020 -10:02
 */
@Entity
@Data
public class Category extends AbstractTimestampEntity {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String title;
    private boolean isActive;
    private String parentId;

}
