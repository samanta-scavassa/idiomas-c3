package com.c3.idiomas.json;

import lombok.Data;

@Data
public class LanguageRequestJson {

    private Long id;

    private String name;

    private String level;

    private String classification;
}
