package com.keysight.es.gateway.repositories;

import com.keysight.es.gateway.entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

}
