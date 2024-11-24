package org.bigdata.demos.web.controller;

import org.bigdata.demos.web.entity.StockPrice;
import org.bigdata.demos.web.service.MongoStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class MongoStockController {
    @Autowired
    private MongoStockService mongoStockService;
    @GetMapping("/collections")
    public Page<String> getStockPrices(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return mongoStockService.getStockCollectionsPaged(page, size);
    }
}
