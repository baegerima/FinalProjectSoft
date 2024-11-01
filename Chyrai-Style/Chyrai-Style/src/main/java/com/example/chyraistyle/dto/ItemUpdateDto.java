package com.example.chyraistyle.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemUpdateDto {
    private String name;
    private String color;
    private String season;
    private String weatherType;
    private String category;
}