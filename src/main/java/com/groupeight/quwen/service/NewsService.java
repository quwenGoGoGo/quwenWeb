package com.groupeight.quwen.service;

import com.groupeight.quwen.entity.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    List<News> getAllNews();
    void deleteNews(Long newsID);
    List<News> findSearch(News newsModel);
    void addNews(News news);
    News getNewsByID(Long newsID);
}
