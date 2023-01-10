package com.behi.sec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecTestRestTemplate {
    @Autowired
    private TestRestTemplate template;

    @Test
    void contextLoads() throws Exception {
        ResponseEntity<String> result = template.withBasicAuth("behrooz", "123")
                .getForEntity("/user", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

}
