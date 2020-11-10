package com.c3.idiomas.service;


import com.c3.idiomas.model.LanguageLevel;
import com.c3.idiomas.repository.LanguageLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class LanguageLevelService {

    @Autowired
    private LanguageLevelRepository languageLevelRepository;

    public Iterable<LanguageLevel> getLanguageLevels() {
        return languageLevelRepository.findAll();
    }

    public Optional<LanguageLevel> getLanguageLevelById(Long id) {
        return languageLevelRepository.findById(id);
    }

    public LanguageLevel saveLanguageLevel(LanguageLevel level) {
        return languageLevelRepository.save(level);
    }

    public LanguageLevel updateLanguageLevel(LanguageLevel level, Long id) {

        Assert.notNull(id, "Update failed");

        Optional<LanguageLevel> optional = getLanguageLevelById(id);

        if(optional.isPresent()) {
            LanguageLevel db = optional.get();
            db.setLevel((level.getLevel()));

            System.out.println("Language level id: " + db.getId());

            languageLevelRepository.save(db);

            return db;
        } else {
            return null;
        }
    }

    public boolean deleteLanguageLevel(Long id) {
        if(getLanguageLevelById(id).isPresent()) {
            languageLevelRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
