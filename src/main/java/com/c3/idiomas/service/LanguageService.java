package com.c3.idiomas.service;

import com.c3.idiomas.model.Language;
import com.c3.idiomas.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public Iterable<Language> getLanguages() {
        return languageRepository.findAll();
    }

    public Optional<Language> getLanguageById(Long id) {
        return languageRepository.findById(id);
    }

    public Language getLanguageByName(String lingua) {
        return languageRepository.findLanguageByNameIgnoreCase(lingua);
    }

    public Language saveLanguage(Language language) {
        return languageRepository.save(language);
    }

    public Language updateLanguage(Language language, Long id) {

        Assert.notNull(id, "Update failed");

        Optional<Language> optional = getLanguageById(id);

        if(optional.isPresent()) {
            Language db = optional.get();
            db.setName((language.getName()));

            System.out.println("Language level id: " + db.getId());

            languageRepository.save(db);

            return db;
        } else {
            return null;
        }
    }

    public boolean deleteLanguage(Long id) {
        if(getLanguageById(id).isPresent()) {
            languageRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
