package io.github.sergey_ivanenko.rolldicebot;

import io.github.sergey_ivanenko.rolldicebot.config.Mapper;
import io.github.sergey_ivanenko.rolldicebot.service.MessageService;
import io.github.sergey_ivanenko.rolldicebot.service.RollingDiceTelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {RollingDiceTelegramBot.class, Mapper.class, MessageService.class})
public class RolldicebotApplicationTests {

	@Test
	void contextLoads() {
	}

}
