package com.geekbrains.geekmarketwinter.rabbit;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @RabbitListener(queues = "shop")
    public void receiveMessage(String message) {
        System.out.println("Received Message:" + message);
        System.out.println();
    }
}
