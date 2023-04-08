package hu.hunszasz.example.spring.springjackson.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TestData {
    int anInt;
    String text;
    boolean aBoolean;
    LocalDateTime localDateTime;
}
