package com.groupeight.quwen.controller;

import com.groupeight.quwen.entity.News;
import com.groupeight.quwen.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("toList")
    public String getNewsList(Model model){
        List<News> news = newsService.getAllNews();
        model.addAttribute("news",news);
        return "news-list";
    }




}
