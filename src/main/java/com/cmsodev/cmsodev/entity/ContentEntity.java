package com.cmsodev.cmsodev.entity;

import com.cmsodev.cmsodev.constant.ContentStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="content")
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
@EqualsAndHashCode(of = {"id"})


public class ContentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = true,updatable = true)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ContentStatus status;
    private String posterUrl;
    @ManyToMany(targetEntity = LicenseEntity.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "content_license",
            joinColumns = {@JoinColumn(name = "content_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "license_id", nullable = false, updatable = false)})
    private Set<LicenseEntity> licenses = new HashSet<>();
    private String videoUrl;


}

