package com.example.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.model.Student;
import com.example.config.AppConfig;

public class MainApp {

    public static void main(String[] args) {

        // XML Configuration
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student1 = (Student) context.getBean("student");

        System.out.println("----- XML Configuration Output -----");
        student1.display();

        // Annotation Configuration
        AnnotationConfigApplicationContext context2 =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Student student2 = context2.getBean(Student.class);

        System.out.println("\n----- Annotation Configuration Output -----");
        student2.display();

        context2.close();
    }
}