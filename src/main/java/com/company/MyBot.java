package com.company;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyBot extends TelegramLongPollingBot {
    DBConnection db = new DBConnection();
    @Override
    public void onUpdateReceived(Update update) {


        if (update.getMessage().getChat().getId() == -1002499280744L){

        }else {

        }
    }






    @Override
    public String getBotUsername() {
        return "@move_film_bot";
    }
    @Override
    public String getBotToken() {
        return "7784686516:AAFuiRK6HDl_TZSiY2eycFnmMSMmrYfFxdc";
    }
}
