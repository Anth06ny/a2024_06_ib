package org.example.gatewayservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempRest {

    //http://localhost:9090/testPublic
    @GetMapping("/testPublic")
    public String testPublic() {
        System.out.println("/testPublic");
        return "Hello public";
    }

    //http://localhost:9090/testPrivate
    @GetMapping("/testPrivate")
    public String testPrivate() {
        System.out.println("/testPrivate");
        return "Hello private";
    }

    //http://localhost:9090/testPrivateAdmin
    @GetMapping("/testPrivateAdmin")
    public String testPrivateAdmin() {
        System.out.println("/testPrivateAdmin");
        return "Hello private Admin";
    }
}
