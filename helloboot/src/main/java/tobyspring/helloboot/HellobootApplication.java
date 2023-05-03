package tobyspring.helloboot;

import config.MySpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;


@MySpringBootApplication
public class HellobootApplication {

    private  final JdbcTemplate jdbcTemplate;

    public HellobootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init(){
        jdbcTemplate.execute("CREATE table if not exists hello(name varchar(50) primary key, count int)");
    }

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

