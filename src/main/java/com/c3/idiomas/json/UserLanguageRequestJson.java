package com.c3.idiomas.json;

import com.c3.idiomas.model.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLanguageRequestJson {

    private Language language;

    private Long userId;

}
