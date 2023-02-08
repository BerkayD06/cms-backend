package com.cmsodev.cmsodev.service.implementation;

import com.cmsodev.cmsodev.entity.LicenseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CronjobImple {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Scheduled(cron = "0 * * * * ?")
    public void checkAndDeleteExpiredLicenses() {
        List<LicenseEntity> licenses = jdbcTemplate.query(
                "SELECT * FROM public.license",
                (rs, rowNum) -> new LicenseEntity(
                        rs.getLong("id"),
                        rs.getLong("end_time")
                ));

        for (LicenseEntity license : licenses) {
            if (isExpired(new Date(license.getEndTime()))) {
                deleteLicense(license.getId());
            }
        }
    }

    private boolean isExpired(Date endTime) {
        return endTime.before(new Date());
    }

    private void deleteLicense(Long id) {
        jdbcTemplate.update("DELETE FROM public.license WHERE id = ?", id);
    }
}
