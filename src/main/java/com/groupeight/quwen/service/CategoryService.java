package com.groupeight.quwen.service;

import com.groupeight.quwen.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategory();
}
