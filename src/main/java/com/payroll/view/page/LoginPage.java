package com.payroll.view.page;

import com.payroll.service.LocalAccountService;
import com.payroll.global.GlobalConfig;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static javafx.geometry.HPos.RIGHT;

@Component
public class LoginPage extends Application {

    @Autowired
    private IndexPage indexPage;
    @Autowired LocalAccountService localAccountService;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Welcome PayRollSystem");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setId("welcome-text");
        //scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Employee ID:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 6);
        actiontarget.setId("actiontarget");
        grid.setColumnSpan(actiontarget, 2);
        grid.setHalignment(actiontarget, RIGHT);
        actiontarget.setId("actiontarget");


        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                String employeeId=userTextField.getText();
//                String password=pwBox.getText();
//                int account=Integer.valueOf(employeeId);
////                int flag=localAccountService.loginCheck(account,password);
//                actiontarget.setFill(Color.FIREBRICK);
                int flag = 1;
                if(flag==1){
                    actiontarget.setText("Sign in success");
                    try {
                        indexPage.start(new Stage());
                        primaryStage.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    actiontarget.setText("Sign in fail");
                }
            }
        });
        Scene scene=new Scene(grid,300,275);
        scene.getStylesheets().add(LoginPage.class.getResource("/css/Login.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
