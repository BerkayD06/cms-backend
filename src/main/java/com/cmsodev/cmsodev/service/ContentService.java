package com.cmsodev.cmsodev.service;

import com.cmsodev.cmsodev.entity.ContentEntity;
import com.cmsodev.cmsodev.entity.LicenseEntity;

import java.util.List;

public interface ContentService {
    ContentEntity getById(Long id);
    List<ContentEntity>getAll();
    ContentEntity create(ContentEntity contentEntity);
    ContentEntity update(ContentEntity contentEntity,Long id);
    void delete(Long id);
    ContentEntity updatelisans(List<LicenseEntity> listlicense, Long id);
    ContentEntity lisanscreate(Long id, LicenseEntity licenseEntity);


}
