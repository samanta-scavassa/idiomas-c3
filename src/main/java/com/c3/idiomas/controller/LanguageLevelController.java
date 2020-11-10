package com.c3.idiomas.controller;

import com.c3.idiomas.model.LanguageLevel;
import com.c3.idiomas.service.LanguageLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/language/level")
public class LanguageLevelController {

    @Autowired
    private LanguageLevelService languageLevelService;

    @GetMapping()
    public ResponseEntity<Iterable<LanguageLevel>> getLanguages() {
        return ResponseEntity.ok(languageLevelService.getLanguageLevels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageLevel> getLanguageLevelById(@PathVariable("id") Long id) {

        Optional<LanguageLevel> level = languageLevelService.getLanguageLevelById(id);

        return level
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register-level")
    public ResponseEntity postLanguageLevel(@Valid @RequestBody LanguageLevel level) {

        try {
            languageLevelService.saveLanguageLevel(level);
            return ResponseEntity.created(null).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity putLanguageLevel(@PathVariable("id") Long id, @Valid @RequestBody LanguageLevel level) {

        level.setId(id);

        LanguageLevel l = languageLevelService.updateLanguageLevel(level, id);

        return l != null ?
                ResponseEntity.ok(l) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLanguageLevel(@PathVariable("id") Long id) {
        boolean ok = languageLevelService.deleteLanguageLevel(id);

        return ok ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
