package com.c3.idiomas.repository;

import com.c3.idiomas.model.UserLanguage;
import com.c3.idiomas.model.UserLanguageID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserLanguageRepository extends JpaRepository<UserLanguage, UserLanguageID> {

    @Query( "select ul from UserLanguage ul where ul.userLanguageID.userId = :userId")
    Optional<UserLanguage> findUserLanguageByUserId(@Param("userId") Long userId);

    @Query( "select ul from UserLanguage ul where ul.userLanguageID.language.id = :languageId and ul.level.id = :levelId")
    Optional<UserLanguage> findUserLanguageByLanguageIdLevelId(
            @Param("languageId") Long languageId, @Param("levelId") Long levelId);

    @Query( "select ul from UserLanguage ul where ul.userLanguageID.language.id = :languageId")
    List<UserLanguage> findUserLanguageByLanguageId(@Param("languageId") Long languageId);

    List<UserLanguage> findByUserId(Long userId);

    List<UserLanguage> findByLanguageId(Long languageId);

    Optional<UserLanguage> findByUserLanguageID(UserLanguageID userLanguageID);

    void deleteByUserLanguageID(UserLanguageID userLanguageID);

}
