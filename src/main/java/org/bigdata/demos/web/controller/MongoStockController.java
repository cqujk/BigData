//package org.bigdata.demos.web.controller;
//
//import org.bigdata.demos.web.entity.StockPrice;
//import org.bigdata.demos.web.service.MongoStockService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class MongoStockController {
//    @Autowired
//    private MongoStockService mongoStockService;
//    @GetMapping("/stocks")
//    public List<StockPrice> getStockPrices(@RequestParam String collectionName) {
//        return mongoStockService.getAllStockPrices(collectionName);
//    }
//}
