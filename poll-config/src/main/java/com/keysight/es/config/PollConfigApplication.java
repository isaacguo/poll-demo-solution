package com.keysight.es.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PollConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(PollConfigApplication.class, args);
    }
}
