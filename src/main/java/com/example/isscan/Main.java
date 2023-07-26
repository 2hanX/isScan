package com.example.isscan;

import com.example.isscan.controllers.CheckAV;
import com.example.isscan.controllers.PaneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;



public class Main extends Application {

    public Tab av;
    public TabPane tp;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("index.fxml"));
        Scene mainScene = new Scene(fxmlLoader.load());


        stage.setTitle("isScan");
        stage.setScene(mainScene);
        stage.show();
        stage.setMinWidth(600);
        stage.setMinHeight(500);
    }

    public static void main(String[] args) {
        launch(args);
    }



    public void About(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("这是一个练手项目");
        alert.show();
    }

    public void Good() throws IOException {
        Tab selectedTab = tp.getSelectionModel().getSelectedItem();
        if (Integer.parseInt(selectedTab.getId()) == 2) {
            FXMLLoader loader2 = new FXMLLoader(Main.class.getResource("avlist.fxml"));
            Stage stage2 = new Stage();
            stage2.setTitle("杀软进程识别");
            stage2.setScene(new Scene(loader2.load()));
            stage2.show();
        }else if (Integer.parseInt(selectedTab.getId()) == 3) {
            FXMLLoader loader3 = new FXMLLoader(Main.class.getResource("revshell.fxml"));
            Stage stage3 = new Stage();
            stage3.setTitle("revshell生成");
            stage3.setScene(new Scene(loader3.load()));
            stage3.show();
        }

    }


}
