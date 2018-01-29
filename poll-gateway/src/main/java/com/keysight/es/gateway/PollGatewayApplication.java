package com.keysight.es.gateway;


import com.keysight.es.gateway.entities.QuestionEntity;
import com.keysight.es.gateway.repositories.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties
public class PollGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PollGatewayApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(QuestionRepository questionRepository, StorageProperties storageProperties) {

        return new CommandLineRunner() {

            @Override
            public void run(String... strings) throws Exception {

                File file = new File(storageProperties.getQuestionFile());
                if (!file.exists()) {
                    return;
                }
                try(Scanner scanner = new Scanner(file);)
                {

                    String line;
                    QuestionEntity qe = new QuestionEntity();
                    boolean inMode = false;
                    scanner.nextLine();
                    while (scanner.hasNext()) {
                        line = scanner.nextLine();
                        if (line.equals("---")) {
                            if (!inMode) {
                                inMode = true;
                                line = scanner.nextLine();
                                qe.setQuestion(line);
                            } else {
                                questionRepository.save(qe);
                                qe = new QuestionEntity();
                                inMode = false;
                            }
                        /*
                        while (scanner.hasNext() && scanner.nextLine().equals("---")) {
                            qe.addAvailableAnswer(line);
                        }
                        */
                        } else {
                            qe.addAvailableAnswer(line);
                        }

                    }
                }



            }

        };
    }
}
