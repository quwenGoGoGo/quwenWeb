package com.groupeight.quwen.controller;

import com.groupeight.quwen.entity.Category;
import com.groupeight.quwen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("cate")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("index")
    public String index(){return "index";}

    @GetMapping("toList")
    public String geCategoryList(Model model){
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories",categories);
        return "cate_list";
    }

    @RequestMapping("edit/{id}")
    public String edit(Model model,@PathVariable("id")Long id){
        System.out.println(id);

        if(id>0){
            System.out.println(id);
            model.addAttribute("isAdd",false);
            model.addAttribute("category",categoryService.getCategoryByID(id));
        }else{
            model.addAttribute("isAdd",true);
            model.addAttribute("category",new Category());
        }
        return "cate_edit";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Category category){
        if(category == null){
            return "fail";
        }
        System.out.println(category.getCateID());
        if(category.getCateID()!=null && category.getCateID()>0){
            categoryService.updateCategory(category);

        }else {
            categoryService.addCategory(category);
        }
        return "redirect:/cate/toList";
    }

    @RequestMapping("list")
    public List<Category> getAllCategory(Model model){
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categoryList",categories);
        return null;
    }
}
