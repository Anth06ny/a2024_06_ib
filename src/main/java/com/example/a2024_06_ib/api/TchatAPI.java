package com.example.a2024_06_ib.api;

import com.example.a2024_06_ib.model.MessageBean;
import com.example.a2024_06_ib.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tchat")
public class TchatAPI {

    //private ArrayList<MessageBean> messages = new ArrayList<>();

    @Autowired
    private MessageService messageService;

    //http://localhost:8080/tchat/saveMessage
//Json Attendu : {"pseudo": "toto", "message": 12}
    @PostMapping("/saveMessage")
    public void saveMessage(@RequestBody MessageBean message) {
        System.out.println("/saveMessage : " + message);
        messageService.saveMessage(message);
    }

    //http://localhost:8080/tchat/allMessages
    @GetMapping("/allMessages")
    public List<MessageBean> allMessages() {
        System.out.println("/allMessages");


        return messageService.getAllMessage();
    }
}
