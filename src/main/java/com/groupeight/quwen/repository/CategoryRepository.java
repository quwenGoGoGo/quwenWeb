package com.groupeight.quwen.repository;


import com.groupeight.quwen.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCateName(String cateName);
}
