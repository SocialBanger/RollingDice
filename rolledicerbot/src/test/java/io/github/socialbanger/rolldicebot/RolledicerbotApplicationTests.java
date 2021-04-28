package io.github.socialbanger.rolldicebot;

import io.github.socialbanger.rolldicebot.config.Mapper;
import io.github.socialbanger.rolldicebot.service.MessageService;
import io.github.socialbanger.rolldicebot.service.RandomService;
import io.github.socialbanger.rolldicebot.service.TelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class, RandomService.class})
public class RolledicerbotApplicationTests {

	@Test
	void contextLoads() {
	}

}
