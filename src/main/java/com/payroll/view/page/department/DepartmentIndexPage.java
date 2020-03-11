package com.payroll.view.page.department;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.payroll.entity.Department;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class DepartmentIndexPage extends Application
{
    Stage primaryStage;// 主窗口
    MenuBar menuBar = new MenuBar();
    DepartmentPane departmentPane = new DepartmentPane();

    // 上下文菜单
    ContextMenu contextMenu = new ContextMenu();

    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            initMenuBar(); // 初始化菜单栏
            initContextMenu(); // 初始化右键菜单
            BorderPane root = new BorderPane();
            root.setTop(menuBar);
            root.setCenter(departmentPane);
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void initMenuBar()
    {
        Menu menu = new Menu("选项");
        Menu menuHelp = new Menu("帮助");
        menuBar.getMenus().addAll(menu);

        MenuItem menuItemBack = new MenuItem("返回");
        MenuItem menuItemHelp = new MenuItem("帮助");
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem menuItemExit = new MenuItem("退出程序");

        menu.getItems().addAll(menuItemBack, menuItemHelp, separator, menuItemExit);

        menuItemBack.setOnAction((ActionEvent e)->{
            System.out.println("back");
        });

        menuItemHelp.setOnAction((ActionEvent e)->{
            System.out.println("help");
        });

        menuItemExit.setOnAction((ActionEvent e)->{
            Platform.exit();
        });
    }


    // 打开一个文件
    private void onOpen()
    {
        System.out.println("onOpen");
    }

    // 保存到文件
    private void onSave()
    {
        System.out.println("onSave");
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
            Department s = dlg.getValue(); // getValue()是自己添加的方法
            departmentPane.add(s );
        }
    }

    // 点菜单项 '删除'
    private void removeItem()
    {
        int index = departmentPane.getSelectionModel().getSelectedIndex();
        if(index >= 0)
        {
            departmentPane.remove(index);
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}


