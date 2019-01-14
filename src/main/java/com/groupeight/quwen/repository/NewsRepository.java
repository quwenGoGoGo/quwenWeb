package com.groupeight.quwen.repository;


import com.groupeight.quwen.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Long> {
}
