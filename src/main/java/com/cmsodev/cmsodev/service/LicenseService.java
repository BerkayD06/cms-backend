package com.cmsodev.cmsodev.service;

import com.cmsodev.cmsodev.Pojo.LicenseP;
import com.cmsodev.cmsodev.entity.LicenseEntity;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LicenseService {
    LicenseEntity getById(Long id);

    List<LicenseEntity> getAll();


    LicenseEntity create(LicenseEntity licenseEntity);


    LicenseEntity update(LicenseEntity licenseEntity, Long id);

    void delete(Long id);

}
