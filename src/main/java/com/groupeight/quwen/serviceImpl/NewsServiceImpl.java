package com.groupeight.quwen.serviceImpl;

import com.groupeight.quwen.entity.Category;
import com.groupeight.quwen.entity.News;
import com.groupeight.quwen.repository.NewsRepository;
import com.groupeight.quwen.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getAllNews(){
        return newsRepository.findAll();
    }

    @Override
    public void deleteNews(Long newsID){
        newsRepository.deleteById(newsID);
    }

    @Override
    public List<News> findSearch(News newsModel){
        Assert.notNull(newsModel);

        List<News> result = newsRepository.findAll(new Specification<News>() {
            @Override
            public Predicate toPredicate(Root<News> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();

                if(!StringUtils.isEmpty(newsModel.getTitle())){
                    list.add(criteriaBuilder.like(root.get("title").as(String.class),"%" + newsModel.getTitle() + "%"));
                }
                if(newsModel.getCategory()!=null&&newsModel.getCategory().getCateID()!=null){
                    list.add(criteriaBuilder.equal(root.get("category").as(Category.class), newsModel.getCategory()));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        });
        return result;
    }

    @Override
    public void addNews(News news){
        newsRepository.save(news);
    }
}
