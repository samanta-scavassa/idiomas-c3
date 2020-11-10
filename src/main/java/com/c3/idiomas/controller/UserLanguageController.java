package com.c3.idiomas.controller;

import com.c3.idiomas.json.UserLanguageRequestJson;
import com.c3.idiomas.model.UserLanguage;
import com.c3.idiomas.model.UserLanguageID;
import com.c3.idiomas.service.UserLanguageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user/language")
@CrossOrigin
public class UserLanguageController {

    ModelMapper modelMapper;

    @Autowired
    private UserLanguageService userLanguageService;

    @GetMapping()
    public ResponseEntity<Iterable<UserLanguage>> getUserLanguages() {
        return ResponseEntity.ok(userLanguageService.getUserLanguages());
    }

    @GetMapping("/{userId}/{languageId}")
    public ResponseEntity<UserLanguage> getUserLanguageByUserLanguageId(@PathVariable("useId") Long userId,
                                                                        @PathVariable("languageId") Long languageId ) {

        UserLanguageID userLanguageID = new UserLanguageID(userId, languageId);

        Optional<UserLanguage> userLanguage = userLanguageService.getUserLanguageByUserLanguageId(userLanguageID);

        return userLanguage
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserLanguage> getUserLanguageByUserId(@PathVariable("userId") Long userId) {

        Optional<UserLanguage> userLanguage = userLanguageService.getUserLanguageByUserId(userId);

        return userLanguage
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/lingua/{languageId}/level/{level}")
    public ResponseEntity<List<UserLanguage>> getUserLanguageByLanguageIdLevelId(@PathVariable("languageId") Long languageId,
                                                                           @PathVariable("level")  String level) {

        List<UserLanguage> userLanguage = userLanguageService.getUserLanguageByLanguageIdLevelId(languageId, level);

        return userLanguage != null ?
                ResponseEntity.ok(userLanguage) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/lingua/{languageId}")
    public ResponseEntity<List<UserLanguage>> getUserLanguageByLanguageId(@PathVariable("languageId") Long languageId) {

        List<UserLanguage> userLanguage = userLanguageService.getUserLanguageByLanguageId(languageId);

        return userLanguage != null ?
                ResponseEntity.ok(userLanguage) :
                ResponseEntity.notFound().build();
    }


    @PostMapping("/register-user-language")
    public ResponseEntity postLanguage(@Valid @RequestBody UserLanguageRequestJson request) {

        try {
            UserLanguage userLanguage = modelMapper.map(request, UserLanguage.class);
            userLanguageService.saveUserLanguage(userLanguage);
            return ResponseEntity.created(null).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/{userId}/{languageId}")
    public ResponseEntity putLanguage(@PathVariable("useId") Long userId,
            @PathVariable("languageId") Long languageId, @Valid @RequestBody UserLanguage userLanguage) {

        UserLanguageID userLanguageID = new UserLanguageID(userId, languageId);

        UserLanguage ul = userLanguageService.updateUserLanguage(userLanguage, userLanguageID);

        return ul != null ?
                ResponseEntity.ok(ul) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userId}/{languageId}")
    public ResponseEntity deleteLanguage(@PathVariable("useId") Long userId,
                                         @PathVariable("languageId") Long languageId) {

        UserLanguageID userLanguageID = new UserLanguageID(userId, languageId);

        boolean ok = userLanguageService.deleteUserLanguage(userLanguageID);

        return ok ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
