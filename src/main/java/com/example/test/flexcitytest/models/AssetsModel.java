package com.example.test.flexcitytest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
