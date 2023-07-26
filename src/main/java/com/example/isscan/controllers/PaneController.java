package com.example.isscan.controllers;

import com.example.isscan.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PaneController {
    public TabPane tabPane = new TabPane();
    public TextField inputURL;
    public TextArea extractedURLs;

    @FXML
    public void AddTab() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("tabpane.fxml"));
        Tab tab = new Tab("test",root);
        tabPane.getTabs().add(tab);
    }

    public void Clear() {
        inputURL.setText("");
        extractedURLs.setText("");
    }

    public void Check() throws IOException {
        String baseUrl = inputURL.getText();
        boolean flag = verifyURL(baseUrl);
        System.out.println(flag);

    }

    public static boolean verifyURL(String url){
        String patternString = "(?<=//|)((\\w)+\\.)+\\w+";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        return matcher.find();
    }
}
