package io.github.socialbanger.rolldicebot.service;

import io.github.socialbanger.rolldicebot.dice.Dice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private RandomService randomService;

    public SendMessage onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        if (update != null) {
            Message message = update.getMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setReplyMarkup(getMainMenuKeyboard());
            if (message.hasText()) {
                String msgText = message.getText();
                int sumDiceRoll;
                switch (msgText) {
                    case "/start":
                        return sendMessage.setText("Hello, my Friend!");
                    case "\uD83D\uDD79":
                        return sendMessage.setText("Here will be a library for D&D mechanics.");
                    case "Drop dice \uD83C\uDFB2":
                        sendMessage.setReplyMarkup(getDiceMenuKeyboard());
                        return sendMessage.setText("Choose dice...");
                    case "Dice D4":
                        Dice diceD4 = new Dice(4);
                        sumDiceRoll = randomService.getRoll(diceD4.getDiceType());
                        return sendMessage.setText("" + sumDiceRoll);
                    case "Dice D6":
                        Dice diceD6 = new Dice(6);
                        sumDiceRoll = randomService.getRoll(diceD6.getDiceType());
                        return sendMessage.setText("" + sumDiceRoll);
                    case "Dice D8":
                        Dice diceD8 = new Dice(8);
                        sumDiceRoll = randomService.getRoll(diceD8.getDiceType());
                        return sendMessage.setText("" + sumDiceRoll);
                    case "Dice D10":
                        Dice diceD10 = new Dice(10);
                        sumDiceRoll = randomService.getRoll(diceD10.getDiceType());
                        return sendMessage.setText("" + sumDiceRoll);
                    case "Dice D12":
                        Dice diceD12 = new Dice(12);
                        sumDiceRoll = randomService.getRoll(diceD12.getDiceType());
                        return sendMessage.setText("" + sumDiceRoll);
                    case "Dice D20":
                        Dice diceD20 = new Dice(20);
                        sumDiceRoll = randomService.getRoll(diceD20.getDiceType());
                        return sendMessage.setText("" + sumDiceRoll);
                    case "BACK \uD83D\uDD19":
                        sendMessage.setReplyMarkup(getMainMenuKeyboard());
                        return sendMessage.setText("Choose action...");
                    case "/help":
                    case "Help️️⁉️":
                        String helpText = "С помощью меня вы можете сделать бросок нужной костяшкой. " +
                                "Используйте MENU для выбора команд!";
                        return sendMessage.setText(helpText);
                    case "About us \uD83E\uDDD0️️️️":
                        sendMessage.setReplyMarkup(getAboutInlineKeyboardMarkup());
                        return sendMessage.setText("Just click ⬇️");
                }
            }
        }
        return sendMessage.setText("I don't know this command!");
    }

    private ReplyKeyboardMarkup getMainMenuKeyboard() {
        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow diceRow = new KeyboardRow();
        KeyboardRow libRow = new KeyboardRow();
        KeyboardRow helpRow = new KeyboardRow();
        KeyboardRow aboutRow = new KeyboardRow();

        diceRow.add(new KeyboardButton("Drop dice \uD83C\uDFB2"));
        libRow.add(new KeyboardButton("\uD83D\uDD79"));
        helpRow.add(new KeyboardButton("Help️️⁉️"));
        aboutRow.add(new KeyboardButton("About us \uD83E\uDDD0️️️️"));
        keyboard.add(diceRow);
        keyboard.add(libRow);
        keyboard.add(helpRow);
        keyboard.add(aboutRow);
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup getDiceMenuKeyboard() {
        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow diceD4 = new KeyboardRow();
        KeyboardRow diceD6 = new KeyboardRow();
        KeyboardRow diceD8 = new KeyboardRow();
        KeyboardRow diceD10 = new KeyboardRow();
        KeyboardRow diceD12 = new KeyboardRow();
        KeyboardRow diceD20 = new KeyboardRow();
        KeyboardRow backButton = new KeyboardRow();

        diceD4.add(new KeyboardButton("Dice D4"));
        diceD6.add(new KeyboardButton("Dice D6"));
        diceD8.add(new KeyboardButton("Dice D8"));
        diceD10.add(new KeyboardButton("Dice D10"));
        diceD12.add(new KeyboardButton("Dice D12"));
        diceD20.add(new KeyboardButton("Dice D20"));
        backButton.add(new KeyboardButton("BACK \uD83D\uDD19"));

        keyboard.add(diceD4);
        keyboard.add(diceD6);
        keyboard.add(diceD8);
        keyboard.add(diceD10);
        keyboard.add(diceD12);
        keyboard.add(diceD20);
        keyboard.add(backButton);

        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }

    private InlineKeyboardMarkup getAboutInlineKeyboardMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(new InlineKeyboardButton()
                .setText("Open in browser")
                .setUrl("https://socialbanger.github.io/RollingDice/"));
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow);
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
