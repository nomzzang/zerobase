package tobyspring.helloboot;

import config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;


@MySpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {
        //컨테이너를 하는 작업 빈 초기화
        SpringApplication.run(HellobootApplication.class, args);
    }
}

