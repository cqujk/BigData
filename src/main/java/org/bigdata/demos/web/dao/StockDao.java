package org.bigdata.demos.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class StockDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Map<String, Object>> getStockPricesForAllCodes() {
        List<Map<String, Object>> allStockPrices = jdbcTemplate.queryForList(
                "SELECT TABLE_NAME AS code FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'stock_prices'"
        );

        for (Map<String, Object> stockPrice : allStockPrices) {
            String code = (String) stockPrice.get("code");
            List<Map<String, Object>> prices = getStockPricesByCode(code);
            stockPrice.put("prices", prices);
        }

        return allStockPrices;
    }

    public List<Map<String, Object>> getStockPricesByCode(String code) {
        return jdbcTemplate.queryForList(
                "SELECT date, close_price FROM " + code
        );
    }
}
