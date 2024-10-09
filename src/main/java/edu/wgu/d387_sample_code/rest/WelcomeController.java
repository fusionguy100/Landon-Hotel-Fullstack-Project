package edu.wgu.d387_sample_code.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.wgu.d387_sample_code.ThreadClass;

@CrossOrigin
@RestController
public class WelcomeController {

    private final ThreadClass threadClass;


    public WelcomeController() {
        this.threadClass = new ThreadClass("");
    }


    @GetMapping("/api/welcomeMessages")
    public String[] getWelcomeMessages() {
        return threadClass.getMessages();
    }
}
