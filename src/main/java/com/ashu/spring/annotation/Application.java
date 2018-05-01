package com.ashu.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {
    @Bean
    HelloService mockMessageService() {
        return new HelloService() {
            @Override
            public String Hello() {
                return "Hello World";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = ctx.getBean(MessagePrinter.class);
        printer.printMessage();


    }
}
