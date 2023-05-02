package tobyspring.helloboot;

import config.MySpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;


@MySpringBootApplication
public class HellobootApplication {



//    @Bean
//    ApplicationRunner applicationRunner(Environment env){
//        return args -> {
//            String name = env.getProperty("my.name");
//            System.out.println("my.name:" + name);
//
//        };
//    }
    public static void main(String[] args) {
        //컨테이너를 하는 작업 빈 초기화
        SpringApplication.run(HellobootApplication.class, args);
    }

}

