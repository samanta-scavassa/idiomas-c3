package com.c3.idiomas.repository;

import com.c3.idiomas.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    Language findLanguageByNameIgnoreCase(String lingua);

}
