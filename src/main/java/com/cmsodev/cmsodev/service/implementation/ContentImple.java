package com.cmsodev.cmsodev.service.implementation;
import com.cmsodev.cmsodev.constant.ContentStatus;
import com.cmsodev.cmsodev.entity.ContentEntity;
import com.cmsodev.cmsodev.entity.LicenseEntity;
import com.cmsodev.cmsodev.repository.ContentRepo;
import com.cmsodev.cmsodev.service.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ContentImple implements ContentService {

    private final ContentRepo contentRepo;

    @Override
    public ContentEntity getById(Long id) {
        return contentRepo.findOneById(id);
    }

    @Override
    public List<ContentEntity> getAll() {
        return contentRepo.findAll();
    }

    @Override
    public ContentEntity create(ContentEntity contentEntity) {

            contentEntity.setStatus(ContentStatus.InProgress);
        return contentRepo.save(contentEntity);
    }

    @Override
    public ContentEntity update(ContentEntity contentEntity, Long id) {
        ContentEntity contentDB = contentRepo.findOneById(id);
        contentDB.setPosterUrl(contentEntity.getPosterUrl());
        contentDB.setVideoUrl((contentEntity.getVideoUrl()));
        contentDB.setName(contentEntity.getName());
        contentDB.setLicenses(contentEntity.getLicenses());
        if(contentEntity.getName()!=null && contentEntity.getPosterUrl()!=null && contentEntity.getVideoUrl()!=null && contentEntity.getLicenses()!=null){
            contentDB.setStatus(ContentStatus.Published);
        }else {
            contentDB.setStatus(ContentStatus.InProgress);
        }
        return contentRepo.save(contentDB);
    }

    @Override
    public void delete(Long id) {
        contentRepo.deleteById(id);

    }

    @Override
    public ContentEntity updatelisans(List<LicenseEntity> listlicense, Long id) {
        Set<LicenseEntity> licenseEntities=new HashSet<>(listlicense);
        ContentEntity ContentDB=contentRepo.findOneById(id);
        ContentDB.setLicenses(licenseEntities);
        if(ContentDB.getName()!=null && ContentDB.getPosterUrl()!=null && ContentDB.getVideoUrl()!=null && ContentDB.getLicenses()!=null){
            ContentDB.setStatus(ContentStatus.Published);
        }else {
            ContentDB.setStatus(ContentStatus.InProgress);
        }
        return contentRepo.save(ContentDB);
    }

    @Override
    public ContentEntity lisanscreate(Long id, LicenseEntity licenseEntity) {
        List<LicenseEntity> ListLicense=new ArrayList<>();
        ListLicense.add(licenseEntity);
        Set<LicenseEntity> licenseEntities=new HashSet<>(ListLicense);
        ContentEntity contentEntity=contentRepo.findOneById(id);
        contentEntity.setLicenses(licenseEntities);
        return contentRepo.save(contentEntity);
    }


}
