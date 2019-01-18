package com.groupeight.quwen.service;

import com.groupeight.quwen.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    Category findByCateName(String cateName);

    List<Category> getAllCategory();

    Category addCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Long cateID);

    Category getCategoryByID(Long cateID);

}
