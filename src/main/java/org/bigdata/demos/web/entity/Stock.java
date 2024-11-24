package org.bigdata.demos.web.entity;

import lombok.Data;

@Data
public class Stock {
    private String id;
    private String name;
    private double positiveProbability;
    private double predictedValue;
    private double[] actualValues;
    private double[] predictedValues;
    private String[] dates;
}
