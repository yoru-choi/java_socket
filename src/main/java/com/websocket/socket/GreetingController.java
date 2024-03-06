package com.websocket.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/hello")
    public void greeting(String message) throws Exception {
        System.out.println("ctrl");
        Thread.sleep(1000); // simulated delay
          simpMessagingTemplate.convertAndSend("/topic/hello", message );
//        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }


}