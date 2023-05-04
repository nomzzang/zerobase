package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloApiTest {
    @Test
    void helloApi(){
        //http local:8080/hello?name=Spring
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res =
                rest.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "Spring");
        // status code 200
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header(content-type) text/plain
        Assertions.assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello Spring
        Assertions.assertThat(res.getBody()).isEqualTo("*sayHelloSpring*");
    }

    @Test
    void falseHelloApi(){
        //http local:8080/hello?name=Spring
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res =
                rest.getForEntity("http://localhost:9090/app/hello?name=", String.class);
        // status code 200
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        // header(content-type) text/plain
        // body Hello Spring
    }
}
