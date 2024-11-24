package org.bigdata.demos.web.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class NewsMongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Bean(name = "newsMongoClient")
    public MongoClient newsMongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Bean(name = "newsMongoTemplate")
    public MongoTemplate newsMongoTemplate(MongoConverter converter) {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(newsMongoClient(), "news"), converter);
    }


    @Bean
    public MappingMongoConverter newsMappingMongoConverter(MongoMappingContext context) {
        return new MappingMongoConverter(new SimpleMongoClientDatabaseFactory(newsMongoClient(), "news"), context);
    }
}
