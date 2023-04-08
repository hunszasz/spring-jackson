package hu.hunszasz.example.spring.springjackson.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.hunszasz.example.spring.springjackson.domain.TestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;

@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/testData")
    public TestData getTestData() throws JsonProcessingException {
        TestData tst = TestData.builder().text("Ez egy teszt objektum").anInt(42).aBoolean(false).localDateTime(LocalDateTime.of(2023,
                Month.APRIL, 6, 19, 30, 40)).build();;

        if (logger.isDebugEnabled()) {
            logger.debug(objectMapper.writeValueAsString(tst));
        }
        return tst;
    }
}
