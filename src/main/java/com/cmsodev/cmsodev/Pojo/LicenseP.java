package com.cmsodev.cmsodev.Pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class LicenseP {
    private Long id;
    private String name;
    private String startTime;
    private String endTime;
}
