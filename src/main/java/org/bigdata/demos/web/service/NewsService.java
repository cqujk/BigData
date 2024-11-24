package org.bigdata.demos.web.service;


import ch.qos.logback.classic.Logger;
import org.bigdata.demos.web.controller.StockController;
import org.bigdata.demos.web.entity.News;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class NewsService {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(StockController.class);
    @Autowired
    @Qualifier("newsMongoTemplate")
    private MongoTemplate newsMongoTemplate;

    public List<News> getAllNews() {
        try {
            List<News> newsList = newsMongoTemplate.findAll(News.class);
            logger.debug("Fetched {} news items from MongoDB", newsList.size());
            return newsList;
        } catch (Exception e) {
            logger.error("Error fetching news from MongoDB", e);
            throw new RuntimeException("Failed to fetch news from MongoDB", e);
        }
    }
    public List<News> getNewsByPage(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            List<News> newsList = newsMongoTemplate.find(new Query().with(pageable), News.class);
            logger.debug("Fetched {} news items from MongoDB", newsList.size());
            return newsList;
        } catch (Exception e) {
            logger.error("Error fetching news from MongoDB", e);
            throw new RuntimeException("Failed to fetch news from MongoDB", e);
        }
    }

    // 其他业务逻辑
}