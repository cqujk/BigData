package org.bigdata.demos.web.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class StockMongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Bean(name = "stockMongoClient")
    public MongoClient stockMongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Bean(name = "stockMongoTemplate")
    public MongoTemplate stockMongoTemplate(MongoConverter converter) {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(stockMongoClient(), "stock"), converter);
    }

    @Bean
    public MongoMappingContext mongoMappingContext() {
        return new MongoMappingContext();
    }

    @Bean
    @Primary
    public MappingMongoConverter stockMappingMongoConverter(MongoMappingContext context) {
        return new MappingMongoConverter(new SimpleMongoClientDatabaseFactory(stockMongoClient(), "stock"), context);
    }
}
