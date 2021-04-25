package io.github.socialbanger.rolldicebot;

import io.github.socialbanger.rolldicebot.config.Mapper;
import io.github.socialbanger.rolldicebot.service.MessageService;
import io.github.socialbanger.rolldicebot.service.RollingDiceTelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {RollingDiceTelegramBot.class, Mapper.class, MessageService.class})
public class RolldicebotApplicationTests {

	@Test
	void contextLoads() {
	}

}
