package com.c3.idiomas.controller;

import com.c3.idiomas.model.Language;
import com.c3.idiomas.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/language")
@CrossOrigin
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping()
    public ResponseEntity<Iterable<Language>> getLanguages() {
        return ResponseEntity.ok(languageService.getLanguages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable("id") Long id) {

        Optional<Language> language = languageService.getLanguageById(id);

        return language
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("lingua/{lingua}")
    public ResponseEntity<Language> getLanguageByName(@PathVariable("lingua") String lingua) {

        Language language = languageService.getLanguageByName(lingua);

        return language != null ?
                ResponseEntity.ok(language) :
                ResponseEntity.notFound().build();
    }

    @PostMapping("/register-language")
    public ResponseEntity postLanguage(@Valid @RequestBody Language language) {

        try {
           languageService.saveLanguage(language);
            return ResponseEntity.created(null).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity putLanguage(@PathVariable("id") Long id, @Valid @RequestBody Language language) {

        language.setId(id);

        Language l = languageService.updateLanguage(language, id);

        return l != null ?
                ResponseEntity.ok(l) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLanguage(@PathVariable("id") Long id) {
        boolean ok = languageService.deleteLanguage(id);

        return ok ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
