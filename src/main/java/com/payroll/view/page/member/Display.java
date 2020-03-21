package com.payroll.view.page.member;

import com.payroll.dao.AddressDao;
import com.payroll.dao.EmployeeDao;
import com.payroll.entity.Address;
import com.payroll.entity.Employee;
import com.payroll.entity.FatData;
import com.payroll.global.GlobalConfig;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;

public class Display extends Application {

    private AddressDao addressDao=(AddressDao) GlobalConfig.ctx.getBean("addressDao");
    private EmployeeDao employeeDao=(EmployeeDao) GlobalConfig.ctx.getBean("employeeDao");
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

    String workId1;
    String name1;
    String sex1;
    String age1;
    String nation1;
    String telephone1;
    String email1;
    String acdemic1;
    String createTime1;
    String province1;
    String city1;
    String area1;
    String detail1;
    String deptName1;
    String deptAdress1;
    String memberAccount1;
    String employee1;
    String workType1;
    String grade1;
    String baseSalary1;


    Employee employee;
    ObservableList<FatData> data;

    public Display(String workId1, String name1, String sex1, String age1, String nation1, String telephone1, String email1, String acdemic1, String createTime1, String province1, String city1, String area1, String detail1,
                   String deptName1, String deptAdress1, String memberAccount1, String employee1, String workType1, String grade1, String baseSalary1, Employee employee,ObservableList<FatData> data){
     this.workId1=workId1;
     this.name1=name1;
     this.sex1= sex1;
     this.age1=age1;
     this.nation1=nation1;
     this.telephone1=telephone1;
     this.email1=email1;
     this.acdemic1=acdemic1;
     this.createTime1=createTime1;
     this.province1=province1;
     this.city1=city1;
     this.area1=area1;
     this.detail1=detail1;
     this.deptName1=deptName1;
     this.deptAdress1=deptAdress1;
     this.memberAccount1=memberAccount1;
     this.employee1=employee1;
     this.workType1=workType1;
     this.grade1=grade1;
     this.baseSalary1=baseSalary1;

     this.employee=employee;
     this.data=data;
    }

//    public Pane show(String workId1,String name1,String sex1,String age1, String nation1, String telephone1, String email1, String acdemic1, String createTime1,String province1, String city1, String area1, String detail1, String deptName1, String deptAdress1, String memberAccount1, String employee1, String workType1, String grade1, String baseSalary1){
        public void start(Stage primaryStage) throws Exception{
        Label workId = new Label("WorkID:");
        workId.setId("workId");
        TextField addWorkId = new TextField(workId1);
        addWorkId.setEditable(false);

        Label name = new Label("Name:(Edit)");
        name.setId("name");
        TextField addName = new TextField(name1);
        addName.setEditable(false);

        Label sex = new Label("Sex:");
        sex.setId("sex");
        TextField addSex = new TextField(sex1);
        addSex.setEditable(false);

        Label age = new Label("Age:(Edit)");
        age.setId("age");
        TextField addAge = new TextField(age1);
        addAge.setEditable(false);

        Label nation = new Label("Nation:(Edit)");
        nation.setId("nation");
        TextField addNation = new TextField(nation1);
        addNation.setEditable(false);

        Label telephone = new Label("Telephone:(Edit)");
        telephone.setId("telephone");
        TextField addTelephone = new TextField(telephone1);
        addTelephone.setEditable(false);

        Label email = new Label("Email:(Edit)");
        email.setId("email");
        TextField addEmail = new TextField(email1);
        addEmail.setEditable(false);

        Label acdemic = new Label("Acdemic:");
        acdemic.setId("acdemic");
        TextField addAcdemic = new TextField(acdemic1);
        addAcdemic.setEditable(false);

        Label createTime = new Label("CreateTime:");
        createTime.setId("createTime");
        TextField addCreateTime = new TextField(createTime1);
        addCreateTime.setEditable(false);

        Label province = new Label("Province:(Edit)");
        province.setId("province");
        TextField addProvince = new TextField(province1);
        addProvince.setEditable(false);

        Label city = new Label("City:(Edit)");
        city.setId("city");
        TextField addCity = new TextField(city1);
        addCity.setEditable(false);

        Label area = new Label("Area:(Edit)");
        area.setId("area");
        TextField addArea = new TextField(area1);
        addArea.setEditable(false);

        Label detail = new Label("Detail:(Edit)");
        detail.setId("detail");
        TextField addDetail = new TextField(detail1);
        addDetail.setEditable(false);

        Label deptName = new Label("deptName:");
        deptName.setId("deptName");
        TextField addDeptName = new TextField(deptName1);
        addDeptName.setEditable(false);

        Label deptAddress = new Label("deptAddress:");
        deptAddress.setId("deptAddress");
        TextField addDeptAddress = new TextField(deptAdress1);
        addDeptAddress.setEditable(false);

        Label memberAccount = new Label("memberAmount:");
        memberAccount.setId("memberAccount");
        TextField addMemberAccount = new TextField(memberAccount1);
        addMemberAccount.setEditable(false);

        Label employeeId = new Label("employeeId:");
        employeeId.setId("employeeId");
        TextField addEmployeeId = new TextField(employee1);
        addEmployeeId.setEditable(false);

        Label workType = new Label("workType:");
        workType.setId("workType");
        TextField addWorkType = new TextField(workType1);
        addWorkType.setEditable(false);

        Label grade = new Label("grade:");
        grade.setId("grade");
        TextField addGrade = new TextField(grade1);
        addGrade.setEditable(false);

        Label baseSalary = new Label("baseSalary:");
        baseSalary.setId("baseSalary");
        TextField addBaseSalary = new TextField(baseSalary1);
        addBaseSalary.setEditable(false);

        Button Edit = new Button("Edit");
        Edit.setId("Edit");
        Edit.setOnAction((ActionEvent e) -> {
            try {
                addName.setEditable(true);
                addAge.setEditable(true);
                addNation.setEditable(true);
                addEmail.setEditable(true);
                addTelephone.setEditable(true);
                addProvince.setEditable(true);
                addCity.setEditable(true);
                addArea.setEditable(true);
                addDetail.setEditable(true);
            } catch (Exception msg) {
                msg.printStackTrace();
            }
        });
        Button determine = new Button("determine");
        determine.setId("determine");
        determine.setOnAction((ActionEvent e) -> {
            try {

                //写回数据库
                employee.setName(addName.getText());
                employee.setAge(addAge.getText());
                employee.setNation(addNation.getText());
                employee.setTelephone(addTelephone.getText());
                employee.setEmail(addEmail.getText());
                Address address=employee.getAddress();
                address.setProvince(addProvince.getText());
                address.setCity(addCity.getText());
                address.setArea(addArea.getText());
                address.setDetail(addDetail.getText());
                employee.setAddress(address);
                addressDao.updateAddress(address);
                employeeDao.updateEmployee(employee);

                addName.setEditable(false);
                addAge.setEditable(false);
                addNation.setEditable(false);
                addEmail.setEditable(false);
                addTelephone.setEditable(false);
                addProvince.setEditable(false);
                addCity.setEditable(false);
                addArea.setEditable(false);
                addDetail.setEditable(false);

                for (int i=0;i<data.size();i++){
                    if(String.valueOf(employee.getEmployeeId()).equals(data.get(i).getWorkId())){
                        data.set(i,new FatData(String.valueOf(employee.getEmployeeId()),employee.getName(),employee.getAge(),employee.getSex(),employee.getNation()
                                ,employee.getTelephone(),employee.getEmail(),employee.getAcademic(),simpleDateFormat.format(employee.getCreateTime())));
                    }
                }
            } catch (Exception msg) {
                msg.printStackTrace();
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setId("displayPane");
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPrefWidth(700);
        gridPane.setPrefHeight(600);
        gridPane.setHgap(5.5);
        gridPane.setVgap(5.5);
            gridPane.add(workId,1,2);
            gridPane.add(addWorkId,2,2);
            gridPane.add(name,3,2);
            gridPane.add(addName,4,2);
            gridPane.add(sex,1,3);
            gridPane.add(addSex,2,3);
            gridPane.add(age,3,3);
            gridPane.add(addAge,4,3);
            gridPane.add(nation,1,4);
            gridPane.add(addNation,2,4);
            gridPane.add(telephone,3,4);
            gridPane.add(addTelephone,4,4);
            gridPane.add(email,1,5);
            gridPane.add(addEmail,2,5);
            gridPane.add(acdemic,3,5);
            gridPane.add(addAcdemic,4,5);
            gridPane.add(createTime,1,6);
            gridPane.add(addCreateTime,2,6);
            gridPane.add(province,3,6);
            gridPane.add(addProvince,4,6);
            gridPane.add(city,1,7);
            gridPane.add(addCity,2,7);
            gridPane.add(area,3,7);
            gridPane.add(addArea,4,7);
            gridPane.add(detail,1,8);
            gridPane.add(addDetail,2,8);
            gridPane.add(workType,3,8);
            gridPane.add(addWorkType,4,8);
            gridPane.add(grade,1,9);
            gridPane.add(addGrade,2,9);
            gridPane.add(baseSalary,3,9);
            gridPane.add(addBaseSalary,4,9);
            gridPane.add(deptName,1,10);
            gridPane.add(addDeptName,2,10);
            gridPane.add(deptAddress,3,10);
            gridPane.add(addDeptAddress,4,10);
            gridPane.add(memberAccount,1,11);
            gridPane.add(addMemberAccount,2,11);
            gridPane.add(employeeId,3,11);
            gridPane.add(addEmployeeId,4,11);
            gridPane.add(Edit,3,1);
            gridPane.add(determine,4,1);

            Scene scene = new Scene( gridPane, 900, 450);
            scene.getStylesheets().add(Display.class.getResource("/css/member.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
    }

}
