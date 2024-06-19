package com.example.a2024_06_ib;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempRest {

    //http://localhost:8080/testPublic
    @GetMapping("/testPublic")
    public String testPublic() {
        System.out.println("/testPublic");
        return "Hello public";
    }

    //http://localhost:8080/testPrivate
    @GetMapping("/testPrivate")
    public String testPrivate() {
        System.out.println("/testPrivate");
        return "Hello private";
    }

    //http://localhost:8080/testPrivateAdmin
    @GetMapping("/testPrivateAdmin")
    public String testPrivateAdmin() {
        System.out.println("/testPrivateAdmin");
        return "Hello private Admin";
    }
}
