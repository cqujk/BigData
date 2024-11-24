package org.bigdata.demos.web.controller;

import org.bigdata.demos.web.entity.News;
import org.bigdata.demos.web.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @GetMapping("/allNews")
    public List<News> getNews() {
        return newsService.getAllNews();
    }
    @GetMapping("/page")
    public List<News> getNewsByPage(@RequestParam(value = "page", defaultValue = "0") int page,
                                    @RequestParam(value = "size", defaultValue = "10") int size) {
        return newsService.getNewsByPage(page, size);
    }
}
//@RestController
//public class MongoStockController {
//    @Autowired
//    private MongoStockService mongoStockService;
//    @GetMapping("/stocks")
//    public List<StockPrice> getStockPrices(@RequestParam String collectionName) {
//        return mongoStockService.getAllStockPrices(collectionName);
//    }
//}