package hu.hunszasz.example.spring.springjackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import hu.hunszasz.example.spring.springjackson.controller.TestController;
import hu.hunszasz.example.spring.springjackson.domain.TestData;
import hu.hunszasz.example.spring.springjackson.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
class SpringJacksonDemoConfigApplicationTests {

    @Autowired
    TestService testService;

    @Autowired
    MockMvc mockMvc;

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

    @Test
    void doTestWithRest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/testData").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.text").doesNotExist())
                .andExpect(MockMvcResultMatchers.jsonPath("$.anInt").value(42))
                .andExpect(MockMvcResultMatchers.jsonPath("$.aboolean").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.localDateTime").value("2023.04.06 19:30"));
    }

}
