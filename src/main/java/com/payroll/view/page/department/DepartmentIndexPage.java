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

/**
 *  部门管理主页
 */
public class DepartmentIndexPage
{
    private IndexPage indexPage= (IndexPage) GlobalConfig.ctx.getBean("indexPage");
    private DepartmentService departmentService=(DepartmentService)GlobalConfig.ctx.getBean("departmentServiceImpl");

    MenuBar menuBar = new MenuBar();
    TextField search=new TextField();
    DepartmentPane departmentPane = new DepartmentPane();

    // 上下文菜单
    ContextMenu contextMenu = new ContextMenu();

    //    @Override
    public BorderPane start()
    {
        try
        {
            initMenuBar(); // 初始化菜单栏
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
            root.setPrefWidth(700);
//            Scene scene = new Scene(root, 800, 400);
//            primaryStage.setScene(scene);
//            primaryStage.show();
            return root;
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }

    private void updatePane(){
        String name=search.getText();
        if(name!=null||!"".equals(name)){
            Department department=departmentService.getDepartmentByName(name);
            if(department!=null){
                departmentPane.clear();
                departmentPane.add(department);
            }else{
                departmentPane.clear();
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

    private void initMenuBar()
    {
        Menu menu = new Menu("选项");
        menuBar.getMenus().addAll(menu);

        MenuItem menuItemBack = new MenuItem("返回");
        MenuItem menuItemHelp = new MenuItem("帮助");
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem menuItemExit = new MenuItem("退出程序");

        menu.getItems().addAll(menuItemBack, menuItemHelp, separator, menuItemExit);

//        menuItemBack.setOnAction((ActionEvent e)->{
//            try{
//                indexPage.start(new Stage());
//
//            }catch (Exception msg){
//                msg.printStackTrace();
//            }
//            //System.out.println("back");
//        });

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

        MenuItem menuItemQuery=new MenuItem("查看");
        menuItemQuery.setOnAction((ActionEvent e)->{

        });

        MenuItem menuItemUpdate=new MenuItem("修改");
        menuItemUpdate.setOnAction((ActionEvent e)->{
            updateItem();
        });

        MenuItem menuItemRemove = new MenuItem("删除");
        menuItemRemove.setOnAction((ActionEvent e) -> {
            removeItem();
        });

        // 添加菜单项
        contextMenu.getItems().addAll(menuItemAdd,menuItemQuery,menuItemUpdate, menuItemRemove);

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

    private  void  updateItem(){
        int index=departmentPane.getSelectionModel().getSelectedIndex();
        if(index>=0){
            TreeItem<Department> item=(TreeItem<Department>)departmentPane.getRootItem().getChildren().get(index);
            Department department=item.getValue();
            UpdateDepartmentDialog updateDepartmentDialog=new UpdateDepartmentDialog(department);
            Optional<Boolean> result=updateDepartmentDialog.showAndWait();
            if(result.isPresent() && result.get()==true){
                department=updateDepartmentDialog.getValue();
//               System.out.println(department);
                if(departmentService.updateDepartment(department)){
                    departmentPane.clear();
                    initData();
                }else{
                    System.out.println("更新失败");
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
            if(department.getMemberAmount()!=null||department.getMemberAmount()!=0){
                if(departmentService.deleteDepartment(department)){
                    departmentPane.remove(index);
                }else{
                    System.out.println("删除失败");
                }
            }else{
                System.out.println("人数不为0，不能删除");
            }
        }
    }

//    public static void main(String[] args)
//    {
//        launch(args);
//    }
}


