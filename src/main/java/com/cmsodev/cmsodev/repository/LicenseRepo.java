package com.cmsodev.cmsodev.repository;

import com.cmsodev.cmsodev.entity.LicenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepo extends JpaRepository<LicenseEntity, Long> {
    LicenseEntity findOneById(Long id);

}
