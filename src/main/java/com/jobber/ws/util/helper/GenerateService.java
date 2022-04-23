package com.jobber.ws.util.helper;

import org.apache.commons.text.RandomStringGenerator;
import java.nio.file.AccessDeniedException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface GenerateService {
    default String generate(String context){
        return context;
    };

    default String generate(String role,String context) throws AccessDeniedException {
        return context;
    };

    default String generate(){
        RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder()
                .withinRange(33, 45)
                .build();
        return pwdGenerator.generate(100);
    };


    default Stream<Character> generateRandomSpecialChars(int count) {
        Random random = new SecureRandom();
        IntStream specialChars = random.ints(count, 33, 45);
        return specialChars.mapToObj(data -> (char) data);
    }
}
