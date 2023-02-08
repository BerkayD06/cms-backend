package com.cmsodev.cmsodev.service.implementation;
import com.cmsodev.cmsodev.Pojo.LicenseP;
import com.cmsodev.cmsodev.entity.LicenseEntity;
import com.cmsodev.cmsodev.repository.LicenseRepo;
import com.cmsodev.cmsodev.service.LicenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class LicenseImple implements LicenseService {
    private final LicenseRepo licenseRepo;
    @Override
    public LicenseEntity getById(Long id) {
        return licenseRepo.findOneById(id);
    }
    @Override
    public List<LicenseEntity> getAll() {
        return licenseRepo.findAll();
    }
    @Override
    public LicenseEntity create(LicenseEntity license)
    {
        LicenseEntity licenseEntity=new LicenseEntity();
        return licenseRepo.save(license);
    }

    @Override
    public LicenseEntity update(LicenseEntity licenseEntity, Long id) {
        LicenseEntity licenseDB=licenseRepo.findOneById(id);
        licenseDB.setName(licenseEntity.getName());
        licenseDB.setStartTime(licenseEntity.getStartTime());
        licenseDB.setEndTime(licenseEntity.getEndTime());

        return licenseRepo.save(licenseDB);
    }

    @Override
    public void delete(Long id) {
        licenseRepo.deleteById(id);

    }

}
