package com.cmsodev.cmsodev.controller;

import com.cmsodev.cmsodev.entity.ContentEntity;
import com.cmsodev.cmsodev.entity.LicenseEntity;
import com.cmsodev.cmsodev.service.ContentService;
import com.cmsodev.cmsodev.service.implementation.CronjobImple;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
@EnableAutoConfiguration
@AllArgsConstructor
@CrossOrigin(origins = "*")

public class ContentController {
    @Autowired
    CronjobImple cronjobImple;
    private final ContentService contentService;

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return ResponseEntity.ok(contentService.getById(id));
    }

    @GetMapping()
    public ResponseEntity getAll() {
        return ResponseEntity.ok(contentService.getAll());

    }

    @PostMapping()
    public ResponseEntity Create(@RequestBody ContentEntity contentEntity) {
        return ResponseEntity.ok(contentService.create(contentEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody ContentEntity contentEntity, @PathVariable Long id) {
        return ResponseEntity.ok(contentService.update(contentEntity, id));

    }

    @PutMapping("/{id}/license")
    public ResponseEntity updateLisans(@RequestBody List<LicenseEntity> listlicense, @PathVariable Long id) {
        return ResponseEntity.ok(contentService.updatelisans(listlicense, id));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contentService.delete(id);
    }
    @PutMapping("/contentlisans/{id}")
    public ResponseEntity createlisans(@RequestBody LicenseEntity listlicense, @PathVariable Long id) {
        return ResponseEntity.ok(contentService.lisanscreate(id, listlicense));

    }

}



