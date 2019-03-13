package com31.websiteecommerce.websiteecommerce.product.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com31.websiteecommerce.websiteecommerce.product.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ListenerToCategory {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "category-product")
    public void ListenerToCategory(String body) throws Exception {
        Category category = objectMapper.readValue(body, Category.class);
        log.info("Receive new category : {}", category.getName());
    }
}
