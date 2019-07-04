package br.com.triad.controller;

import br.com.triad.dto.MessagesDTO;
import br.com.triad.service.DefaultMessagesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {


    @Autowired
    private DefaultMessagesService defaultMessagesService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMessages(@RequestBody MessagesDTO messagesDTO)
    {
        defaultMessagesService.sendMessages(messagesDTO);

    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public String getMessages(@PathVariable String id) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        MessagesDTO messagesDTO = defaultMessagesService.getMessageDTO(id);

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(messagesDTO);
    }

    @GetMapping
    @ResponseBody
    public String getConversation(@RequestParam(value = "conversationId",defaultValue = "false")String conversationId) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        List<MessagesDTO> conversation =defaultMessagesService.getConversations(conversationId);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(conversation);

    }

}
