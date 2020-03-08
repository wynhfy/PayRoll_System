package com.payroll.view.page;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndexPage extends Application {

    @Autowired
    private LoginPage loginPage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane stackPane=new StackPane();
        Label label=new Label("This is a new page");
        label.setCursor(Cursor.HAND);
        stackPane.getChildren().add(label);

        Button btn=new Button("log out");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    loginPage.start(new Stage());
                    primaryStage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        HBox hbBtn=new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);

        stackPane.getChildren().add(hbBtn);

        Scene scene=new Scene(stackPane,300,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
