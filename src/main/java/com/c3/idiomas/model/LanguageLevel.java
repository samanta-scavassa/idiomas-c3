package com.c3.idiomas.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "language_level")
public class LanguageLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="level", length = 50, nullable = false)
    private String level;

    public LanguageLevel(String level) {
        this.level = level;
    }

}
