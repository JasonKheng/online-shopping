package com.example.interview.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class LogicService {
    public long problem1() {
        long value = 1;
        var op = 1;

        for (int i = 2; i <= 1000; i++) {
            value = (i % 2 == 0) ? value + op : value * op;
            op++;
        }

        return value;
    }

    public String problem2() throws IOException {
        ClassPathResource resource = new ClassPathResource("input.txt");

        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                String transformation = transform(line);
                sb.append(transformation).append("<br/>");
            }

            return sb.toString();
        }
    }

    public String transform(String input) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();

        int i = 0;
        while (i < chars.length) {
            char c = chars[i];

            if (Character.toLowerCase(c) == 'a') {
                int count = 1;
                while (i + count < chars.length &&
                        Character.toLowerCase(chars[i + count]) == 'a') {
                    count++;
                }

                if (count == 1) {
                    sb.append('#');
                } else {
                    sb.append('a');
                    sb.append("$".repeat(count - 1));
                }
                i += count;
            } else {
                sb.append(c);
                i++;
            }
        }

        return sb.toString();
    }
}
