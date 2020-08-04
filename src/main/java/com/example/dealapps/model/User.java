package com.example.dealapps.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author NEJMEDDINE Ayoub
 * @created 28/07/2020 -16:47
 */
@Data
@Entity
public class User extends AbstractTimestampEntity {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String firstName;
    private String lastName;
    @NotBlank(message = "Name is mandatory")
    private String mail;
    private String phone;
    private Date dateBirth;

    public String getFullName() {
        return firstName != null ? firstName.concat(" ").concat(lastName) : "";
    }
}
