package com.payroll.view.page.department;

import com.payroll.entity.Department;
import com.payroll.view.page.IndexPage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * 部门管理部分的首页
 */
@Component
public class DepartmentIndexPage extends Application {

    @Autowired
    private IndexPage indexPage;

    //Stage primaryStage;
    MenuBar menuBar=new MenuBar();
    ContextMenu contextMenu=new ContextMenu();
    DepartmentPane departmentPane=new DepartmentPane();


    @Override
    public void start(Stage primaryStage) throws Exception {
        initMenuBar(primaryStage);
        initContextMenu();
        BorderPane root=new BorderPane();
        root.setTop(menuBar);
        root.setCenter(departmentPane);
        Scene scene=new Scene(root,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initMenuBar(Stage primaryStage){
        //第一级
        Menu menuinsert=new Menu("增添部门");
        Menu menuback=new Menu("返回主页");
        menuBar.getMenus().addAll(menuinsert,menuback);
        menuinsert.setOnAction((ActionEvent e)->{
            addItem();
        });
        menuback.setOnAction((ActionEvent e)->{
            try {
                indexPage.start(new Stage());
                primaryStage.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

    private void initContextMenu(){
        MenuItem menuItemAdd=new MenuItem("修改");
        menuItemAdd.setOnAction((ActionEvent e)->{

        });

        MenuItem menuItemRemove=new MenuItem("删除");
        menuItemRemove.setOnAction((ActionEvent e)->{
            removeItem();
        });
        contextMenu.getItems().addAll(menuItemAdd,menuItemRemove);
        departmentPane.setContextMenu(contextMenu);
    }

    //点击添加
    private void addItem(){
       AddDepartmentDialog dlg=new AddDepartmentDialog();
        Optional<Boolean> result=dlg.showAndWait();
        if(result.isPresent()&&result.get()==true){
            Department department=dlg.getValue();
            departmentPane.add(department);
        }
    }

    //点击删除
    private void removeItem(){
        int index=departmentPane.getSelectionModel().getSelectedIndex();
        if(index>=0){
            departmentPane.remove(index);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
