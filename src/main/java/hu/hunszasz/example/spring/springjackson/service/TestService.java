package hu.hunszasz.example.spring.springjackson.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.hunszasz.example.spring.springjackson.domain.TestData;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    ObjectMapper objectMapper;

    public TestService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String getTestDataAsJson(TestData testData) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(testData);
    }
}
