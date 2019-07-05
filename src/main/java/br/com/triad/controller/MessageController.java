package br.com.triad.controller;

import br.com.triad.dto.MessagesDTO;
import br.com.triad.service.DefaultMessagesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/messages")
@Api(value = "Messages", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {


    @Autowired
    private DefaultMessagesService defaultMessagesService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create and Send messages to insert in database")
    public void createMessages(@RequestBody MessagesDTO messagesDTO)
    {
        defaultMessagesService.sendMessages(messagesDTO);

    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    @ApiOperation("get specific messages for id")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "messages received with success"),
            @ApiResponse(code=404,message = "The id specific not exist")
    })
    public String getMessages(@PathVariable String id) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        MessagesDTO messagesDTO = defaultMessagesService.getMessageDTO(id);

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(messagesDTO);
    }

    @GetMapping
    @ResponseBody
    @ApiOperation("return all conversations  by conversationId")
    public String getConversation(@RequestParam(value = "conversationId",defaultValue = "false")String conversationId) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        List<MessagesDTO> conversation =defaultMessagesService.getConversations(conversationId);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(conversation);

    }

}
