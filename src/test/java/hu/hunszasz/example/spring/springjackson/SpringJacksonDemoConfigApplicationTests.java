package hu.hunszasz.example.spring.springjackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import hu.hunszasz.example.spring.springjackson.domain.TestData;
import hu.hunszasz.example.spring.springjackson.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringJacksonDemoConfigApplicationTests {

    @Autowired
    TestService testService;

    @Test
    void contextLoads() {
        assertNotNull(testService);
    }

    @Test
    void doTestWithService() throws JsonProcessingException {
        TestData testData = TestData.builder().text("Ez egy teszt objektum")
                .anInt(42)
                .aBoolean(false)
                .localDateTime(LocalDateTime.of(2023, Month.APRIL, 6, 19, 30, 40))
                .build();
        String jsonString = testService.getTestDataAsJson(testData);
        assertEquals("""
                {
                  "anInt" : 42,
                  "aboolean" : false,
                  "localDateTime" : "2023.04.06 19:30"
                }""", jsonString);
    }


}
