package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String index() {
        try{
            createError();
        }catch(Exception e){
            logger.error("has error",e);
        }
        return "Greetings from Spring Boot! ";
    }

    public static void createError(){
        if(System.currentTimeMillis() % 2 == 0){
            throw  new RuntimeException("Random exception", new Throwable("you have a bad luck.Bye..."));
        }
    }

}