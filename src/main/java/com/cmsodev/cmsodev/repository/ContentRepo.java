package com.cmsodev.cmsodev.repository;

import com.cmsodev.cmsodev.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepo extends JpaRepository<ContentEntity, Long> {
    ContentEntity findOneById(Long id);

}
