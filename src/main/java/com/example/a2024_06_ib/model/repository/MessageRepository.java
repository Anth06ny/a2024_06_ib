package com.example.a2024_06_ib.model.repository;

import com.example.a2024_06_ib.model.MessageBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageBean, String> {

}


