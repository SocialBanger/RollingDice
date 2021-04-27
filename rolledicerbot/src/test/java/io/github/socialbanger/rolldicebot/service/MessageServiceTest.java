package io.github.socialbanger.rolldicebot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.socialbanger.rolldicebot.RolledicerbotApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.io.File;
import java.io.IOException;

//@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class})
class MessageServiceTest extends RolledicerbotApplicationTests {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    TelegramBot telegramBot;
    @Autowired
    MessageService messageService;

    @Test
    void onUnknownReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/update.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("I don't know this command!");
      //  assertEquals(expectedResult, actualResult);
    }

    @Test
    void onStartReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/start.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Hello!");
     //   assertEquals(expectedResult, actualResult);
    }

    @Test
    void onSettingsReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/settings.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Settings!");
      //  assertEquals(expectedResult, actualResult);
    }

    @Test
    void onHelpReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/help.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Help!");
    //    assertEquals(expectedResult, actualResult);
    }

    private SendMessage makeMessage(String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(691267727L);
        sendMessage.setText(text);
        return sendMessage;
    }
}