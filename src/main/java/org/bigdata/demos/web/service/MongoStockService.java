//package org.bigdata.demos.web.service;
//
//import org.bigdata.demos.web.entity.StockPrice;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class MongoStockService {
//    @Autowired
//    @Qualifier("stockMongoTemplate")
//    private MongoTemplate stockMongoTemplate;
//
//    public List<StockPrice> getAllStockPrices(String collectionName) {
//        return stockMongoTemplate.findAll(StockPrice.class, collectionName);
//    }
//}
