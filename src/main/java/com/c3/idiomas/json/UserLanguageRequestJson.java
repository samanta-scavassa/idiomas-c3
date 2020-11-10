package com.c3.idiomas.json;

import com.c3.idiomas.model.Language;
import com.c3.idiomas.model.LanguageLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLanguageRequestJson {

    private Language language;

    private Long userId;

    private LanguageLevel level;

    private String classificacao;
}
