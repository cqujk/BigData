package org.bigdata.demos.web.entity;

import lombok.Data;

@Data
public class News {
    private String id;
    private String title;
    private String url;
    private boolean isPositive;
}
