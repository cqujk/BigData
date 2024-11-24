package org.bigdata;

import java.util.*;
import java.math.*;

import ch.qos.logback.classic.Logger;
import org.bigdata.demos.web.controller.StockController;
import org.bigdata.demos.web.entity.News;
import org.bigdata.demos.web.service.NewsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import static org.mockito.Mockito.when;


public class NewsServiceTest {
   // private static final Logger logger = (Logger) LoggerFactory.getLogger(StockController.class);
    @InjectMocks
    private NewsService newsService;

    @Mock
    private MongoTemplate newsMongoTemplate;

    private List<News> newsList;

    @BeforeEach
    public void setUp() {
        newsList = new ArrayList<>();
    }

    @Test
    public void getAllNews_ShouldReturnAllNews() {
        // Arrange
        when(newsMongoTemplate.findAll(News.class)).thenReturn(newsList);

        // Act
        List<News> result = newsService.getAllNews();
        //logger.info("result: "+result);
        System.out.println(result);
        // Assert

    }
}