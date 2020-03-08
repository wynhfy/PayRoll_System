package com.payroll;

import com.payroll.global.GlobalConfig;
import com.payroll.view.page.LoginPage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main extends Application {

    @Override
    public void init() throws Exception {
        GlobalConfig.ctx=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Loginpage loginpage=new Loginpage();
//        loginpage.start(primaryStage);
        LoginPage loginPage=(LoginPage) GlobalConfig.ctx.getBean("loginPage");
        loginPage.start(primaryStage);
    }

    @Override
    public void stop() throws Exception {
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
