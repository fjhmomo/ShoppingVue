package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class item {
    int id;
    private String name;
    private String information;
    private double price;
    private int number;
    private int category;
}
