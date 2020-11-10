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

    @Query( "select ul from UserLanguage ul where ul.userLanguageID.languageId = :languageId and ul.level LIKE '%:level%'")
    List<UserLanguage> findUserLanguageByLanguageIdLevelName(
            @Param("languageId") Long languageId, @Param("level") String level);


    @Query( "select ul from UserLanguage ul where ul.userLanguageID.languageId = :languageId")
    List<UserLanguage> findUserLanguageByLanguageId(@Param("languageId") Long languageId);

    Optional<UserLanguage> findByUserLanguageID(UserLanguageID userLanguageID);

    void deleteByUserLanguageID(UserLanguageID userLanguageID);

}
