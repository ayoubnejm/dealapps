package com.example.dealapps.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author NEJMEDDINE Ayoub
 * @created 04/08/2020 -10:16
 */
@Data
public class CategoryDto {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String title;
    private boolean isActive;
}
