package com.joshuasantacruz.Hanged.Project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Useer")
public class Useer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_code")
    private Integer userCode;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 3, max = 40, message = "El nombre de usuario debe tener entre 3 y 40 caracteres")
    @Column(name = "user_name", unique = true)
    private String userName;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 4, max = 10, message = "La contraseña debe tener entre 4 y 10 caracteres")
    @Column(name = "user_password")
    private String userPassword;

    // Getters y Setters

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}