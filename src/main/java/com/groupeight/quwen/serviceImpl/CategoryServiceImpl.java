package com.groupeight.quwen.serviceImpl;

import com.groupeight.quwen.entity.Category;
import com.groupeight.quwen.repository.CategoryRepository;
import com.groupeight.quwen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findByCateName(String cateName){
        return categoryRepository.findByCateName(cateName);
    }

    @Override
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
}
