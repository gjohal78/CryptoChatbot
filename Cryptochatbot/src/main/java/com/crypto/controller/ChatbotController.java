package com.crypto.controller;

import com.crypto.dto.PromptBody;
import com.crypto.response.ApiResponse;
import com.crypto.service.ChatbotService;
import com.crypto.service.ChatbotserviceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai/chat")
public class ChatbotController {

    private final ChatbotService chatbotService;

    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }


    @PostMapping
    public ResponseEntity<ApiResponse> getCoinDetails(@RequestBody PromptBody prompt) throws Exception {



        ApiResponse response = chatbotService.getCoinDetails(prompt.getPrompt());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/simple")
    public ResponseEntity<String> simpleChatHandler(@RequestBody PromptBody prompt) throws Exception {

        String response = chatbotService.simpleChat(prompt.getPrompt());

//        ApiResponse response = new ApiResponse();
//        response.setMessage(prompt.getPrompt());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
