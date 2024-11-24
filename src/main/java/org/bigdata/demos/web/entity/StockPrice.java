package org.bigdata.demos.web.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class StockPrice {
    @Id
    private String _id;
    private Double close;
    private Double high;
    private Double low;
    private Double open;
    private Double volume;
    private String date;
}
