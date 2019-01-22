package com.groupeight.quwen.controller;

import com.groupeight.quwen.entity.Category;
import com.groupeight.quwen.entity.News;
import com.groupeight.quwen.entity.NewsForm;
import com.groupeight.quwen.service.CategoryService;
import com.groupeight.quwen.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.DateUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;

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

    @GetMapping("toAdd")
    public String toAdd(Model model){
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categoryList",categories);
        model.addAttribute("news",new News());
        return "news-add";
    }

    @PostMapping("add")
    public String addNews(@RequestParam(value = "title") String title,
            @RequestParam(value = "cateName")String cateName,
            @RequestParam(value = "cover")MultipartFile file,
            @RequestParam(value = "content")String content,
            @RequestParam(value = "author")String author,
            @RequestParam(value = "status")Integer status,
            Model model) throws Exception{
        News news = new News();
        news.setTitle(title);
        Category category = categoryService.findByCateName(cateName);
        news.setCategory(category);
        news.setContent(content);
        news.setAuthor(author);
        news.setStatus(status);
        if(!file.isEmpty()){
            try{
                //获取文件名
                String fileName = file.getOriginalFilename();
                //获取文件名的后缀
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                String filePath ="D:\\java\\IdeaProjects\\quwen\\src\\main\\resources\\static\\images\\";
                String dateName = new SimpleDateFormat("yyyyMMdd").format(new Date());
                String newName = dateName  + suffixName;
                String pathName = filePath + newName;
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(pathName)));
                out.write(file.getBytes());
                out.flush();
                out.close();
                String staticName = "/images/" + newName;
                file.transferTo(new File(pathName));
                news.setCover(staticName);
            }catch (FileNotFoundException e){
                e.printStackTrace();
                return "上传失败，"+ e.getMessage();
            }catch (IOException e){
                e.printStackTrace();
                return "上传失败，"+ e.getMessage();
            }
        }
        newsService.addNews(news);
        return "redirect:/news/toList";
    }

    @RequestMapping("delete")
    public String deleteNews(Long id){
        newsService.deleteNews(id);
        return "redirect:/news/toList";
    }

    @RequestMapping("search")
    public String searchForNews(@RequestParam("searchByTitle")String stitle, @RequestParam("searchByCate")String scategory, Model model){
        System.out.println("搜索");
//        String stitle = httpServletRequest.getParameter("searchByTitle");
//        String scategory = httpServletRequest.getParameter("searchByCate");
        System.out.println(stitle);
        System.out.println(scategory);
//        String stime = httpServletRequest.getParameter("searchByTime");
        Category category = categoryService.findByCateName(scategory);
        News newsModel = new News();
        newsModel.setTitle(stitle);
        newsModel.setCategory(category);
        List<News> news = newsService.findSearch(newsModel);
        model.addAttribute("news",news);
        return "news-list";
    }





}
