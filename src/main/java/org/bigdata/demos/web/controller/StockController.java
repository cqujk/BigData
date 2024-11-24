package org.bigdata.demos.web.controller;

import ch.qos.logback.classic.Logger;
import org.bigdata.demos.web.entity.Stock;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.bigdata.demos.web.service.StockService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class StockController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(StockController.class);
    @Autowired
    private StockService stockService;

    @GetMapping("/")
    public ModelAndView getAllStocks(Model model) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("stocksData", stockService.getAllStocks());
        LocalDate currentDate = LocalDate.now();
        modelAndView.addObject("currentDate", currentDate.toString());
        //System.out.println("getAllStocks"+stockService.getAllStocks());
//        logger.info("the stocksData is"+stockService.getAllStocks());
//        return "home";
        return modelAndView;
    }

    @GetMapping("/stock/{id}")
    public String getStockById(@PathVariable String id, Model model) {
//        Stock stock = stockService.getStockById(id);
//        if (stock != null) {
//            model.addAttribute("stock", stock);
//            model.addAttribute("newsList", stockService.getNewsByStockId(id));
//            model.addAttribute("positiveCount", stockService.countPositiveNews(id));
//            model.addAttribute("negativeCount", stockService.countNegativeNews(id));
            return "stock";
//        } else {
//            return "error";
//        }
    }
}