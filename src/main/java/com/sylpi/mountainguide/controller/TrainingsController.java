package com.sylpi.mountainguide.controller;

import com.sylpi.mountainguide.entity.Article;
import com.sylpi.mountainguide.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("")
public class TrainingsController {

    private ArticleService articleService;

    @Autowired
    public TrainingsController(ArticleService theArticleService){
        articleService = theArticleService;
    }

    @GetMapping("stages")
    public String stages(Model model){
      List<Article> allArticles = articleService.findAll();
       model.addAttribute("articles", allArticles);

        return "trainings/stages";
    }

//    get the detail of one activity
    @GetMapping("detail")
    public String detail(@RequestParam("id") int id, Model model){
        Article article = articleService.findById(id);
        if (article == null){
            throw new RuntimeException("no result");
        }

        model.addAttribute("article", article);
        return "trainings/details/detail";
    }


    // all these should be deleted in the end
//    @GetMapping("alpinisme")
//    public String alpi(Model model){
//        List<Article> allArticles = articleService.findAll();
//        model.addAttribute("articles", allArticles);
//        return "trainings/details/alpinisme";
//    }
//
//    @GetMapping("escalade")
//    public String escalade(Model model){
//        List<Article> allArticles = articleService.findAll();
//        model.addAttribute("articles", allArticles);
//        return "trainings/details/escalade";
//    }
//
//    @GetMapping("hors-piste")
//    public String horspiste(Model model){
////        List<Article> allArticles = articleService.findAll();
////        model.addAttribute("articles", allArticles);
//        return "trainings/details/horspiste";
//    }
//
//    @GetMapping("ski-rando")
//    public String rando(Model model){
////        List<Article> allArticles = articleService.findAll();
////        model.addAttribute("articles", allArticles);
//        return "trainings/details/skirando";
//    }
//
//
//    @GetMapping("trek")
//    public String trek(Model model){
////        List<Article> allArticles = articleService.findAll();
////        model.addAttribute("articles", allArticles);
//        return "trainings/details/trek";
//    }

}
