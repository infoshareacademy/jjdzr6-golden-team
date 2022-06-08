package com.infoshareacademy;

import com.infoshareacademy.database.MysqlConnector;
import com.infoshareacademy.service.FormServiceImpl;
import com.infoshareacademy.service.GameServiceImpl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * YourPlayground App allows you to easily find games you love to play in your city.
 */
public class App {
    public static void main(String[] args) throws IOException, ParseException {

        FormServiceImpl formService = new FormServiceImpl();
        GameServiceImpl gameService = new GameServiceImpl();

        formService.printGamesFromJson();

        /*formService.closeForm(formService.createForm());

        gameService.printFoundGames(gameService.prepareSearchGame());

        gameService.joinGame();*/

        MysqlConnector mysqlConnect = new MysqlConnector();

        String sql = "SELECT * FROM USERS_U";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);

            ResultSet resultSet =  statement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int colNum = rsmd.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= colNum; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }

    }
}