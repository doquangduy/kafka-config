package com.kafka.kafkademo.controller;

import com.kafka.kafkademo.model.User;
import com.kafka.kafkademo.service.KafKaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
  @Autowired private KafKaProducerService kafKaProducerService;

  @PostMapping(path = "/send/user")
  public void sendFoo() {
    User user = new User();
    user.setId("1");
    user.setDetail("Duy");
    kafKaProducerService.saveCreateUserLog(user);
  }
}
