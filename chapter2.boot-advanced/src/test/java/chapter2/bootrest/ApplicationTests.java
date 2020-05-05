package chapter2.bootrest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@SpringBootTest
class ApplicationTests {

    @Test
    public void testSecureService() {
        String plainCreds = "guest:guest123";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization",
                "Basic " + new String(Base64.getEncoder().encode(plainCreds.getBytes())));
        HttpEntity<String> request = new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Greet> response = restTemplate.exchange("http://localhost:8080",
                HttpMethod.GET,
                request,
                Greet.class);

        Assertions.assertEquals("Hello World!", response.getBody().getMessage());

    }

}
