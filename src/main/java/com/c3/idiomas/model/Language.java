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
@Table(name = "languages")
public class Language implements Serializable {

    private static final long serialVersionUID = -6256496809436939677L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length = 50, nullable = false)
    private String name;

}
