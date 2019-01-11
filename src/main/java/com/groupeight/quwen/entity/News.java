package com.groupeight.quwen.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class News {
    @Id
    @GeneratedValue
    private Long newsID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cate_id")
    private Category category;

    private String title;
    private String cover;
    private String content;
    private String author;
    private Date ctime;
    private Integer view_count;
    private Integer collect_count;
    private Integer share_count;
    private Integer comment_count;

//    @OneToMany(mappedBy = "news",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Collect> collects;
//
//    public List<Collect> getCollects() {
//        return collects;
//    }
//
//    public void setCollects(List<Collect> collects) {
//        this.collects = collects;
//    }

    @OneToMany(mappedBy = "news",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getNewsID() {
        return newsID;
    }

    public void setNewsID(Long newsID) {
        this.newsID = newsID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getView_count() {
        return view_count;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public Integer getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(Integer collect_count) {
        this.collect_count = collect_count;
    }

    public Integer getShare_count() {
        return share_count;
    }

    public void setShare_count(Integer share_count) {
        this.share_count = share_count;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }
}
