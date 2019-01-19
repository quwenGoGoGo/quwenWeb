package com.groupeight.quwen.repository;


import com.groupeight.quwen.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NewsRepository extends JpaRepository<News,Long> , JpaSpecificationExecutor<News> {
}
