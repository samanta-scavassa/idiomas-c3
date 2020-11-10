package com.c3.idiomas.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_language")
public class UserLanguage implements Serializable {

    private static final long serialVersionUID = -5327568071899930741L;

    @EmbeddedId
    UserLanguageID userLanguageID;

    @OneToOne
    private LanguageLevel level;

    @Column(name="classification", length = 50, nullable = false)
    private String classification;

}
