package tobyspring.helloboot;

import org.springframework.stereotype.Component;

@Mycomponent
public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name){
        return "sayHello" + name;
    }
}