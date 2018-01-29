package com.keysight.es.gateway;

import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StoragePropertiesTests {

    @Test
    public void givenStoragePropertiesThenItHasFieldQuestionFile() {
        StorageProperties storageProperties = getStorageProperties();
        assertThat(storageProperties, hasProperty("questionFile", is("Question.txt")));
    }

    private StorageProperties getStorageProperties() {
        StorageProperties sp=new StorageProperties();
        sp.setQuestionFile("Question.txt");

        return sp;
    }

}
