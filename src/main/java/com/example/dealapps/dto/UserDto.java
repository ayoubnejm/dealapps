package com.example.dealapps.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author NEJMEDDINE Ayoub
 * @created 03/08/2020 -16:02
 */
@Data
public class UserDto {

    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String firstName;
    private String lastName;
    @NotBlank(message = "Name is mandatory")
    private String mail;
    private String phone;
    private Date dateBirth;

}
