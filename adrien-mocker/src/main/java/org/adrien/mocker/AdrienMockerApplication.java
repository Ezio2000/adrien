package org.adrien.mocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(value = { "org.adrien.mocker", "org.adrien.sdk" })
@EnableScheduling
public class AdrienMockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdrienMockerApplication.class, args);
    }

}
