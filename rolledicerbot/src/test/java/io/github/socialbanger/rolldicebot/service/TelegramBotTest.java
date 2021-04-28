package io.github.socialbanger.rolldicebot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.socialbanger.rolldicebot.RolledicerbotApplicationTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;

//@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class, RandomService.class})
class TelegramBotTest extends RolledicerbotApplicationTests {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    TelegramBot telegramBot;

//    @Test
    void onUpdateReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/update.json"), Update.class);
        telegramBot.onUpdateReceived(update);
    }

//    @Test
    void sendMessage() throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(691267727L);
        sendMessage.setText("Hello bot");
        telegramBot.execute(sendMessage);
    }
}