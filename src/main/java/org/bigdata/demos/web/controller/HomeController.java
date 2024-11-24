package org.bigdata.demos.web.controller;

import org.bigdata.demos.web.service.NewsService;
import org.bigdata.demos.web.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
@Controller
public class HomeController {
    @Autowired
    private StockService stockService;
    private NewsService newsService;

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
}
