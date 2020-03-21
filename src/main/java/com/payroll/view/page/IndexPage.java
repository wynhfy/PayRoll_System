package com.payroll.view.page;

import com.payroll.view.page.department.DepartmentIndexPage;
import com.payroll.view.page.member.MemberIndex;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndexPage extends Application {


    @Autowired
    private LoginPage loginPage;
    private MenuBar menuBar = new MenuBar();

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        borderPane.setId("borderPane");

        Button btn = new Button("Switch Account");
        btn.setId("btn");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    loginPage.start(new Stage());
                    primaryStage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button btnLeave = new Button("exit");
        btnLeave.setId("btnLeave");
        btnLeave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    primaryStage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button btndeptment = new Button("Depart Management        ");
        btndeptment.setId("btndepartment");
        btndeptment.setOnAction((ActionEvent e) -> {
            try {
                DepartmentIndexPage departmentIndexPage = new DepartmentIndexPage();
                  borderPane.setCenter(departmentIndexPage.start());
            } catch (Exception msg) {
                msg.printStackTrace();
            }
        });

        Button btnmember = new Button("Staff Management           ");
        btnmember.setId("btnmember");
        btnmember.setOnAction((ActionEvent e) -> {
            try {
                MemberIndex memberIndex = new MemberIndex();
               borderPane.setCenter(memberIndex.start());
            } catch (Exception msg) {
                msg.printStackTrace();
            }
        });


        Button btnSalary = new Button("Salary management         ");
        btnSalary.setId("btnSalary");
        btnSalary.setOnAction((ActionEvent e) -> {
            try {
                DepartmentIndexPage departmentIndexPage = new DepartmentIndexPage();
            } catch (Exception msg) {
                msg.printStackTrace();
            }
        });




        Scene scene = new Scene(initIndexPage(borderPane,btnmember,btndeptment,btnSalary,btn, btnLeave), 1167, 600);
        scene.getStylesheets().add(IndexPage.class.getResource("/css/IndexPage.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    private BorderPane initIndexPage(BorderPane borderPane,Button btnmember,Button btndeptment,Button btnSalary,Button btn,Button btnLeave){
        FlowPane flowPane = new FlowPane();
        flowPane.setId("flowPane");
        String id = "id：" + "xxx";
        Label labelId = new Label(id);
        labelId.setId("labelId");
        String name = "name：" + "YYY";
        Label labelName = new Label(name);
        labelName.setId("labelName");
        flowPane.getChildren().addAll(new Label("                                                                                                                                                                                                                        "), labelId, labelName, btn, btnLeave);
        borderPane.setTop(flowPane);
        VBox vbox = new VBox();
        vbox.setId("vbox");
        vbox.getChildren().addAll(btnmember, btndeptment, btnSalary);
        borderPane.setLeft(vbox);
        Image imageCenter = new Image("file:C:\\Users\\12276\\Desktop\\Pay_Roll_System\\src\\main\\java\\com\\payroll\\imageCenter.jpg");
        ImageView imageView = new ImageView(imageCenter);
        imageView.setFitWidth(900);
        imageView.setFitHeight(710);
        borderPane.setCenter(imageView);
        return borderPane;
    }
}
