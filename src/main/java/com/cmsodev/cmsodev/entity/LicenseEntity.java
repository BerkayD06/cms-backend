package com.cmsodev.cmsodev.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "license")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class LicenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "licenses", cascade = CascadeType.DETACH)
    private Set<ContentEntity> contents;

    private Long startTime;
    private Long endTime;


    public LicenseEntity(Long id,Long endTime ) {
        this.id = id;
        this.endTime = endTime;
    }

}
