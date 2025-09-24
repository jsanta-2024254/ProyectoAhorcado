package com.joshuasantacruz.Hanged.Project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Words")
public class Words {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code_word;

    @NotBlank(message = "La palabra no puede estar vacía")
    @Size(min = 8, message = "La palabra debe tener al menos 8 caracteres")
    @Column(name = "word", unique = true)
    private String word;

    @NotBlank(message = "La pista no puede estar vacía")
    @Size(min = 3, max = 100, message = "La pista debe tener entre 3 y 100 caracteres")
    @Column(name = "hint")
    private String hint;

    // Getters y Setters

    public Integer getCode_word() {
        return code_word;
    }

    public void setCode_word(Integer code_word) {
        this.code_word = code_word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
