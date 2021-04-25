package io.github.socialbanger.rolldicebot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
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

    public SendMessage onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        if (update != null) {
            Message message = update.getMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setReplyMarkup(getMainMenuKeyboard());
            if (message.hasText()) {
                String msgText = message.getText();
                if (msgText.equals("/start")) {
                    //sendMessage.setReplyMarkup(getMainMenuKeyboard());
                    return sendMessage.setText("Hello!");
                } else if (msgText.equals("/settings")) {
                    return sendMessage.setText("Settings!");
                } else if (msgText.equals("/help")) {
                    return sendMessage.setText("Help!");
                } else if (msgText.equals("Drop dice \uD83C\uDFB2")) {
                    /**
                     Generate inline keyboard
                     */

                    sendMessage.setReplyMarkup(getDiceMenuKeyboard());
                    return sendMessage.setText("Choose dice:");
                } else if (msgText.equals("About us \uD83E\uDDD0️️️️")) {
                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
                    keyboardButtonsRow.add(new InlineKeyboardButton()
                            .setText("Open in browser")
                            .setUrl("https://socialbanger.github.io/RollingDice/"));
                    List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
                    rowList.add(keyboardButtonsRow);
                    inlineKeyboardMarkup.setKeyboard(rowList);
                    sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                    return sendMessage.setText("Just click ⬇️");
                }
            }
        }
        return sendMessage.setText("Do no!");
    }

    private InlineKeyboardMarkup getDiceMenuKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

                    /*InlineKeyboardButton dFourButton = new InlineKeyboardButton().setText("d4");
                    InlineKeyboardButton dSixButton = new InlineKeyboardButton().setText("d6");
                    InlineKeyboardButton dEightButton = new InlineKeyboardButton().setText("d8");*/
                    /*InlineKeyboardButton dTenButton = new InlineKeyboardButton().setText("d10");
                    InlineKeyboardButton dTwelveButton = new InlineKeyboardButton().setText("d12");
                    InlineKeyboardButton dTwentyButton = new InlineKeyboardButton().setText("d20");*/

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("d4"));
        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("d6"));
        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("d8"));

                    /*List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
                    keyboardButtonsRow1.add(dTenButton);
                    keyboardButtonsRow1.add(dTwelveButton);
                    keyboardButtonsRow1.add(dTwentyButton);*/

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        //rowList.add(keyboardButtonsRow2);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
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
}
