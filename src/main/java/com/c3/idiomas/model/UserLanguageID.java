package com.c3.idiomas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLanguageID implements Serializable {
    private static final long serialVersionUID = 2419259088651286220L;

    private Long languageId;

    private Long userId;

}
