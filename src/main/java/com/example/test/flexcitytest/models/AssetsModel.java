package com.example.test.flexcitytest.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssetsModel {
    private Integer id;
    private String code;
    private String name;
    private Double activationCost;
    private List<String> availability;
    private Integer volume;
}
