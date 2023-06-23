package org.adrien.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(value = { "org.adrien.ai", "org.adrien.sdk" })
@EnableScheduling
public class AdrienAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdrienAiApplication.class, args);
    }

}
