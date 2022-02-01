package com.gaurang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ws.config.annotation.EnableWs;

@EnableWs
@SpringBootApplication(scanBasePackages = {"com.gaurang"})
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyApplication.class);
        app.setBanner((environment, sourceClass, out) -> {
            out.println("My Application");
        });
        app.run(args);
    }

}
