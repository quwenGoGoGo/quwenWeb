package com.groupeight.quwen.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long cateID;
    private String title;
    private Integer sort;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,orphanRemoval = true)
    //cascade级联保存、更新、删除、刷新;延迟加载。当删除分类时，会级联删除该分类的所有新闻
    //拥有mappedBy注解的实体类为关系被维护端
    private List<News> news;

    public Long getCateID() {
        return cateID;
    }

    public void setCateID(Long cateID) {
        this.cateID = cateID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
