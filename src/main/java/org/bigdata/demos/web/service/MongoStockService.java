package org.bigdata.demos.web.service;

import org.bigdata.demos.web.entity.StockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MongoStockService {
    @Autowired
    @Qualifier("stockMongoTemplate")
    private MongoTemplate stockMongoTemplate;

    // 获取所有股票集合的名称
    public List<String> getAllStockCollections() {
        return stockMongoTemplate.getCollectionNames().stream()
                .filter(name -> !name.startsWith("system")) // 过滤掉系统集合
                .collect(Collectors.toList());
    }
    // 分页获取股票集合的名称
    public Page<String> getStockCollectionsPaged(int page, int size) {
        List<String> allCollections = getAllStockCollections();
        int start = page * size;
        int end = Math.min(start + size, allCollections.size());
        List<String> pagedCollections = allCollections.subList(start, end);
        return new PageImpl<>(pagedCollections, PageRequest.of(page, size), allCollections.size());
    }
    // 根据股票代码获取详细信息
    public StockPrice getStockPrice(String collectionName) {
        Query query = new Query();
        return stockMongoTemplate.findOne(query, StockPrice.class, collectionName);
    }
    public Page<StockPrice> getAllStockPrices(String collectionName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Query query = new Query().with(pageable);
        long total = stockMongoTemplate.count(query, StockPrice.class, collectionName);
        List<StockPrice> stockPrices = stockMongoTemplate.find(query, StockPrice.class, collectionName);
        return new PageImpl<>(stockPrices, pageable, total);
    }
}
