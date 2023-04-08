package hu.hunszasz.example.spring.springjackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonIgnoreProperties("text")
@JsonPropertyOrder({"anInt", "aboolean", "localDateTime"})
public class TestData {
    int anInt;
    String text;
    boolean aBoolean;
    LocalDateTime localDateTime;
}
