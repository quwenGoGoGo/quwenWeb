package com.groupeight.quwen.controller;

import com.groupeight.quwen.entity.Category;
import com.groupeight.quwen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("cate")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("index")
    public String index(){return "index";}

    @GetMapping("toList")
    public String getCategoryList(Model model){
        List<Category> category=categoryService.getAllCategories();
        model.addAttribute("category",category);
        return "cate_list";
    }
}
