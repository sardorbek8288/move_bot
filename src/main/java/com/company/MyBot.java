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
            saveMovie(update.getMessage());
        }else {

        }
    }




    private void saveMovie(Message message) {
        String fileId = message.getVideo().getFileId();
        String caption = message.getCaption();

        String sql = "INSERT INTO movie (movie_id , name) VALUES (?, ?);";

        try(Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, fileId);

            if (caption != null){
                preparedStatement.setString(2,caption);
            }


            preparedStatement.executeUpdate();

            System.out.println( " created");
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChat().getId());
            sendMessage.setText("saqlandi");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
