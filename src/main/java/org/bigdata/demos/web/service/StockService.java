package org.bigdata.demos.web.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bigdata.demos.web.dao.StockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StockService {
    @Autowired
    private StockDao stockDao;

    public StockService() {
    }

//    public List<Map<String, Object>> getAllStocks() {
//        return stockDao.getStockPricesForAllCodes();
//    }
    public String getAllStocks() {
        System.out.println("getAllStocks"+stockDao.getStockPricesForAllCodes());
        // 自定义 Gson，设置日期格式
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        System.out.println("getAllStocks"+gson.toJson(stockDao.getStockPricesForAllCodes()));
        return gson.toJson(stockDao.getStockPricesForAllCodes());
    }

//    public Stock getStockById(String id) {
//        return stocks.stream().filter(stock -> stock.getId().equals(id)).findFirst().orElse(null);
//    }
//
//    public List<News> getNewsByStockId(String id) {
//        return newsList.stream().filter(news -> news.isPositive()).collect(Collectors.toList());
//    }
//
//    public int countPositiveNews(String id) {
//        return (int) newsList.stream().filter(news -> news.isPositive()).count();
//    }
//
//    public int countNegativeNews(String id) {
//        return (int) newsList.stream().filter(news -> !news.isPositive()).count();
//    }
}

