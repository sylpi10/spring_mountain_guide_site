package com.sylpi.crudapp;


import com.sylpi.crudapp.controller.ArticleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class CrudappApplication {

	public static void main(String[] args) {
//		new File(ArticleController.uploadDirectory).mkdir();
		SpringApplication.run(CrudappApplication.class, args);
	}

}

