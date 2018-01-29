package com.keysight.es.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class StorageProperties {
    public String getQuestionFile() {
        return questionFile;
    }

    public void setQuestionFile(String questionFile) {
        this.questionFile = questionFile;
    }

    @Value("${app.questionFile:/root/poll.txt}")
    private String questionFile;

}
