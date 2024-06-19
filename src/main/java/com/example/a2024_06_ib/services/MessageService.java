package com.example.a2024_06_ib.services;

import com.example.a2024_06_ib.model.MessageBean;
import com.example.a2024_06_ib.model.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;


    public List<MessageBean> getAllMessage() {
        return  messageRepository.findAll();
    }

    public MessageBean saveMessage(MessageBean message) {
        return messageRepository.save(message);
    }
}
