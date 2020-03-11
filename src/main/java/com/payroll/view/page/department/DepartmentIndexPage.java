package com.payroll.view.page.department;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.payroll.dao.DepartmentDao;
import com.payroll.dao.EmployeeDao;
import com.payroll.entity.Department;
import com.payroll.global.GlobalConfig;
import com.payroll.service.DepartmentService;
import com.payroll.view.page.IndexPage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class DepartmentIndexPage extends Application
{
    private IndexPage indexPage= (IndexPage) GlobalConfig.ctx.getBean("indexPage");
    private DepartmentService departmentService=(DepartmentService)GlobalConfig.ctx.getBean("departmentServiceImpl");

    MenuBar menuBar = new MenuBar();
    TextField search=new TextField();
    DepartmentPane departmentPane = new DepartmentPane();

    // 上下文菜单
    ContextMenu contextMenu = new ContextMenu();

    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            initMenuBar(primaryStage); // 初始化菜单栏
            initContextMenu(); // 初始化右键菜单
            initData();  //初始化数据
            BorderPane root = new BorderPane();
            search.setPromptText("搜索");
            search.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if(search.getText()==null||"".equals(search.getText())){
                        departmentPane.clear();
                        initData();
                    }
                }
            });
            search.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if(event.getCode()== KeyCode.ENTER){
                        updatePane();
                    }
                }
            });
            root.setTop(menuBar);
            root.setCenter(search);
            root.setBottom(departmentPane);
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void updatePane(){
        String name=search.getText();
        if(name!=null||!"".equals(name)){
            Department department=departmentService.getDepartmentByName(name);
            if(department!=null){
                departmentPane.clear();
                departmentPane.add(department);
            }
        }
    }

    /**
     * 显示初始化数据
     */
    private void initData(){
        List<Department> departmentList=departmentService.getDepartmentList();
        departmentPane.add(departmentList);
    }

    private void initMenuBar(Stage primaryStage)
    {
        Menu menu = new Menu("选项");
        menuBar.getMenus().addAll(menu);

        MenuItem menuItemBack = new MenuItem("返回");
        MenuItem menuItemHelp = new MenuItem("帮助");
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem menuItemExit = new MenuItem("退出程序");

        menu.getItems().addAll(menuItemBack, menuItemHelp, separator, menuItemExit);

        menuItemBack.setOnAction((ActionEvent e)->{
            try{
                indexPage.start(new Stage());
                primaryStage.close();
            }catch (Exception msg){
                msg.printStackTrace();
            }
            //System.out.println("back");
        });

        menuItemHelp.setOnAction((ActionEvent e)->{
            System.out.println("help");
        });

        menuItemExit.setOnAction((ActionEvent e)->{
            Platform.exit();
        });
    }

    // 初始化上下文菜单
    private void initContextMenu()
    {
        MenuItem menuItemAdd = new MenuItem("添加");
        menuItemAdd.setOnAction((ActionEvent e) -> {
            addItem();
        });

        MenuItem menuItemRemove = new MenuItem("删除");
        menuItemRemove.setOnAction((ActionEvent e) -> {
            removeItem();
        });

        // 添加菜单项
        contextMenu.getItems().addAll(menuItemAdd, menuItemRemove);

        // 给ListView设置上下文菜单
        departmentPane.setContextMenu(contextMenu);
    }

    // 点菜单项 '添加'
    private void addItem()
    {
        AddDepartmentDialog dlg = new AddDepartmentDialog();
        Optional<Boolean> result = dlg.showAndWait();
        if( result.isPresent() && result.get() == true)
        {
            Department department = dlg.getValue(); // getValue()是自己添加的方法
            if(departmentService.checkDepartmentExist(department.getDeptName())){
                System.out.println("插入失败");
            }else{
                if(departmentService.insertDepartment(department)){

                    departmentPane.add(department);
                }else{
                    System.out.println("插入失败");
                }
            }
        }
    }

    // 点菜单项 '删除'
    private void removeItem()
    {
        int index = departmentPane.getSelectionModel().getSelectedIndex();
        if(index >= 0)
        {
            TreeItem<Department> item=(TreeItem<Department>) departmentPane.getRootItem().getChildren().get(index);
            Department department=item.getValue();
            if(departmentService.deleteDepartment(department)){
                departmentPane.remove(index);
            }else{
                System.out.println("删除失败");
            }
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}


