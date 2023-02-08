package com.cmsodev.cmsodev.controller;
import com.cmsodev.cmsodev.entity.LicenseEntity;
import com.cmsodev.cmsodev.service.LicenseService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/license")
@EnableAutoConfiguration
@AllArgsConstructor
public class LicenseController {
    private final LicenseService licenseService;
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return ResponseEntity.ok(licenseService.getById(id));
    }

    @GetMapping()
    public ResponseEntity getAll() {
        return ResponseEntity.ok(licenseService.getAll());
    }

    @PostMapping()
    public ResponseEntity Create(@RequestBody LicenseEntity licenseEntity) {
        return ResponseEntity.ok(licenseService.create(licenseEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody LicenseEntity licenseEntity, @PathVariable Long id) {
        return ResponseEntity.ok(licenseService.update(licenseEntity,id));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        licenseService.delete(id);
    }

}
