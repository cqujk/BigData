package org.bigdata.demos.web.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "all_news")
public class News {
    @Id
    private String id;
    private String news_article;
    private String news_time;
    private String news_title;
}
