package com.c3.idiomas.model;

import com.c3.idiomas.enums.Classification;
import com.c3.idiomas.enums.Level;
import com.c3.idiomas.json.UserLanguageRequestJson;
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

    @Column(name="level", nullable = false)
    private String level;

    @Column(name="classification", nullable = false)
    private String classification;

    public UserLanguage(UserLanguageRequestJson request) {
        this.userLanguageID = new UserLanguageID(request.getLanguageRequest().getId(), request.getUserId());
        this.level = request.getLanguageRequest().getLevel();
        this.classification = request.getLanguageRequest().getClassification();
    }

}
