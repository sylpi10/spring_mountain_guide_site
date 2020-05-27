package com.sylpi.mountainguide.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "category")
    private String category;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "picture")
    @Transient
    private MultipartFile picture;
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "price")
    private int price;
    @Column(name = "level")
    private String level;
    @Column(name = "Duration")
    private String duration;

    public Article() {
    }

    public Article(int id, String category, String title, String content, MultipartFile picture) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.content = content;
        this.picture = picture;
    }

    public Article(int id, String category, String title, String content, MultipartFile picture, LocalDate date, int price, String level, String duration) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.content = content;
        this.picture = picture;
        this.date = date;
        this.price = price;
        this.level = level;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
