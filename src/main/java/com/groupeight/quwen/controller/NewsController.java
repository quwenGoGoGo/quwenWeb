package com.groupeight.quwen.controller;

import com.groupeight.quwen.entity.Category;
import com.groupeight.quwen.entity.News;
import com.groupeight.quwen.entity.NewsForm;
import com.groupeight.quwen.service.CategoryService;
import com.groupeight.quwen.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.DateUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        return "news-add";
    }

    @PostMapping("add")
    public String addNews(NewsForm newsForm, @RequestParam("cover")MultipartFile file, HttpServletRequest request) throws Exception{
        News news = new News();
        System.out.println(newsForm.getCateName());
        System.out.println(newsForm.getStatus());
        if(!file.isEmpty()){
            //获取文件名
            String fileName = file.getOriginalFilename();
            //获取文件名的后缀
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String filePath ="D:\\java\\IdeaProjects\\quwen\\src\\main\\resources\\static\\images";
            String dateName = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            String newName = dateName +"." + suffixName;
            String pathName = filePath + newName;
            String staticName = "/images/" + newName;
            file.transferTo(new File(pathName));
            news.setCover(staticName);
        }
        news.setCover(null);
        news.setCtime(new Date());
        news.setCategory(categoryService.findByCateName(newsForm.getCateName()));
        news.setTitle(newsForm.getTitle());
        news.setAuthor(newsForm.getAuthor());

        return null;
    }





}
