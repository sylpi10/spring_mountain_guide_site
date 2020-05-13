package com.sylpi.crudapp.controller;

import com.sylpi.crudapp.entity.Article;
import com.sylpi.crudapp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService theArticleService){
        articleService = theArticleService;
    }

    @GetMapping("/list")
    public String allArticles(Model model) {

        // get articles from DB with findAll from service
        List<Article> allArticles = articleService.findAll();
        model.addAttribute("articles", allArticles);

        // return html page that displays articles
        return "articles/list-articles";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/stages")
    public String stages(){
        return "stages";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/photos")
    public String photos(){
        return "photos";
    }

    @GetMapping("/summer")
    public String summer(Model model){

        return "trainings/summer";
    }

    @GetMapping("/actus")
    public String news(Model model) {

        // get articles from DB with findAll from service
        List<Article> allArticles = articleService.findAll();
        model.addAttribute("articles", allArticles);

        // return html page that displays articles
        return "actus";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        // create model attribute to bind form data
        Article theArticle = new Article();
        theModel.addAttribute("article", theArticle);

        return "articles/article-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("articleId") int theId, Model theModel){

        // get the article from service
        Article theArticle = articleService.findById(theId);
        // set article as a model to pre-populate the form
        theModel.addAttribute("article", theArticle);

        return "articles/article-form";
    }

    @PostMapping("/save")
    public String saveArticle(@ModelAttribute("article") Article theArticle){
        // save the article
        articleService.save(theArticle);

        // redirect to list
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("articleId") int theId){

        // delete the employee
        articleService.deleteById(theId);

        // redirect to employees/list
        return "redirect:/list";
    }

    @GetMapping("/articles/{theId}")
    public Article findById(@PathVariable int theId) {
        Article article = articleService.findById(theId);
        if (article == null){
            throw new RuntimeException("no result");
        }
            return article;
    }


    @PostMapping("/")
    public Article save(@RequestBody Article theArticle) {
        theArticle.setId(0);

        articleService.save(theArticle);
        return theArticle;
    }

    @PutMapping("/")
    public Article updateArticle(@RequestBody Article theArticle){
        articleService.save(theArticle);
        return theArticle;
    }

    @DeleteMapping("/{id}")

    public String deleteEmployee(@PathVariable int id){
        Article tempArticle = articleService.findById(id);

       // throw exception if null
        if (tempArticle == null){
            throw new RuntimeException("no result");
        }
        articleService.deleteById(id);
        return "Deleted article with id " + id;
    }

}
