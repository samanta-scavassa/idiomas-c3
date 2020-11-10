package com.c3.idiomas.service;

import com.c3.idiomas.model.UserLanguage;
import com.c3.idiomas.model.UserLanguageID;
import com.c3.idiomas.repository.UserLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class UserLanguageService {

    @Autowired
    private UserLanguageRepository userLanguageRepository;

    public Iterable<UserLanguage> getUserLanguages() {
        return userLanguageRepository.findAll();
    }

    public Optional<UserLanguage> getUserLanguageByUserLanguageId(UserLanguageID userLanguageID) {
        return userLanguageRepository.findByUserLanguageID(userLanguageID);
    }

    public Optional<UserLanguage> getUserLanguageByUserId(Long userId) {
        return userLanguageRepository.findUserLanguageByUserId(userId);
    }

    public Optional<UserLanguage> getUserLanguageByLanguageIdLevelId(Long languageId, Long levelId) {
        return userLanguageRepository.findUserLanguageByLanguageIdLevelId(languageId, levelId);
    }

    public List<UserLanguage> getUserLanguageByLanguageId(Long languageId) {
        return userLanguageRepository.findUserLanguageByLanguageId(languageId);
    }

    public UserLanguage saveUserLanguage(UserLanguage userLanguage) {
        return userLanguageRepository.save(userLanguage);
    }

    public UserLanguage updateUserLanguage(UserLanguage userLanguage, UserLanguageID userLanguageID) {

        Assert.notNull(userLanguageID, "Update failed");

        Optional<UserLanguage> optional = getUserLanguageByUserLanguageId(userLanguageID);

        if(optional.isPresent()) {
            UserLanguage db = optional.get();
            db.setLevel(userLanguage.getLevel());
            db.setClassification(userLanguage.getClassification());

            userLanguageRepository.save(db);

            return db;
        } else {
            return null;
        }
    }

    public boolean deleteUserLanguage(UserLanguageID userLanguageID) {
        if(getUserLanguageByUserLanguageId(userLanguageID).isPresent()) {
            userLanguageRepository.deleteByUserLanguageID(userLanguageID);
            return true;
        }
        return false;
    }
}
