package com.sylpi.mountainguide.controller;

import com.sylpi.mountainguide.entity.Article;
import com.sylpi.mountainguide.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;


@Controller
@RequestMapping("admin")
public class ArticleController {


    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService theArticleService){
        articleService = theArticleService;
    }

//    @GetMapping("/admin")
//    public String admin(Model model) {
//
//        // get articles from DB with findAll from service
////        List<Article> allArticles = articleService.findAll();
////        model.addAttribute("articles", allArticles);
//
//        // return html page that displays articles
//        return "fancy-login";
//    }

    @GetMapping("list")
    public String allArticles(Model model) {

        // get articles from DB with findAll from service
        List<Article> allArticles = articleService.findAll();
        model.addAttribute("articles", allArticles);

        // return html page that displays articles
        return "admin/index";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        // create model attribute to bind form data
        Article theArticle = new Article();
        theModel.addAttribute("article", theArticle);

        return "admin/article-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("articleId") int theId, Model theModel){

        // get the article from service
        Article theArticle = articleService.findById(theId);
        // set article as a model to pre-populate the form
        theModel.addAttribute("article", theArticle);

        return "admin/article-form";
    }

    @PostMapping("/save")
    public String saveArticle(@ModelAttribute("article") Article theArticle){

//        String uploadDirectory =  System.getProperty("user.dir") + "/uploads";
//            StringBuilder fileNames = new StringBuilder();
//            for (MultipartFile file : files){
//                Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
//                fileNames.append(file.getOriginalFilename());
//                theArticle.setPicture(files);
//
//                try {
//                    Files.write(fileNameAndPath, file.getBytes());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            model.addAttribute("msg", "upload success : " + fileNames.toString().concat(", ") + ", " + uploadDirectory);


        // save the article
        articleService.save(theArticle);

        MultipartFile articleImage = theArticle.getPicture();
        try {
            byte[] bytes = articleImage.getBytes();
            String imageName = theArticle.getId()+".jpg";
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(
//                            new File("src/main/resources/static/photos/article/"+imageName)));
                            new File("images/"+imageName)));
            stream.write(bytes);
            stream.close();
        } catch (Exception e){
            e.printStackTrace();
        }


        // redirect to list
        return "redirect:/admin/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("articleId") int theId){

        // delete the employee
        articleService.deleteById(theId);

        // redirect to employees/list
        return "redirect:/admin/list";
    }

    @GetMapping("/articles/{theId}")
    public Article findById(@PathVariable int theId) {
        Article article = articleService.findById(theId);
        if (article == null){
            throw new RuntimeException("no result");
        }
        return article;
    }

//    @PostMapping("/")
//    public Article save(@RequestBody Article theArticle) {
//        theArticle.setId(0);
//
//        articleService.save(theArticle);
//        return theArticle;
//    }
//
//    @PutMapping("/")
//    public Article updateArticle(@RequestBody Article theArticle){
//        articleService.save(theArticle);
//        return theArticle;
//    }

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
