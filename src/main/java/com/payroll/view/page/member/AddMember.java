package com.payroll.view.page.member;

import com.payroll.dao.AddressDao;
import com.payroll.dao.DepartmentDao;
import com.payroll.dao.EmployeeDao;
import com.payroll.dao.WorkTypeDao;
import com.payroll.entity.*;
import com.payroll.global.GlobalConfig;
import com.payroll.service.DepartmentService;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;

public class AddMember extends Application{

    private ObservableList<FatData> data;
    private EmployeeDao employeeDao=(EmployeeDao) GlobalConfig.ctx.getBean("employeeDao");
    private AddressDao addressDao=(AddressDao) GlobalConfig.ctx.getBean("addressDao");
    private WorkTypeDao workTypeDao=(WorkTypeDao)GlobalConfig.ctx.getBean("workTypeDao");
    private DepartmentService departmentService=(DepartmentService)GlobalConfig.ctx.getBean("departmentServiceImpl");
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

    public AddMember(ObservableList<FatData> data){
        this.data=data;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Label workId = new Label("WorkID:");
        workId.setId("workId");

        Label name = new Label("Name:");
        name.setId("name");
        TextField addName = new TextField();

        Label sex = new Label("Sex:");
        sex.setId("sex");
        TextField addSex = new TextField();

        Label age = new Label("Age:");
        age.setId("age");
        TextField addAge = new TextField();

        Label nation = new Label("Nation:");
        nation.setId("nation");
        TextField addNation = new TextField();

        Label telephone = new Label("Telephone:");
        telephone.setId("telephone");
        TextField addTelephone = new TextField();

        Label email = new Label("Email:");
        email.setId("email");
        TextField addEmail = new TextField();

        Label acdemic = new Label("Acdemic:");
        acdemic.setId("acdemic");
        TextField addAcdemic = new TextField();

        Label createTime = new Label("CreateTime:");
        createTime.setId("createTime");
        TextField addCreateTime = new TextField();

        Label province = new Label("Province:");
        province.setId("province");
        TextField addProvince = new TextField();

        Label city = new Label("City:");
        city.setId("city");
        TextField addCity = new TextField();

        Label area = new Label("Area:");
        area.setId("area");
        TextField addArea = new TextField();

        Label detail = new Label("Detail:");
        detail.setId("detail");
        TextField addDetail = new TextField();

        Label deptName=new Label("deptName");
        deptName.setId("deptName");
        TextField addDeptName=new TextField();

        Label workTypeId = new Label("workTypeId:");
        workTypeId.setId("workTypeId");
        TextField addWorkTypeId = new TextField();

        Button determine = new Button("determine");
        determine.setId("determine");
        determine.setOnAction((ActionEvent e) -> {
            try {
                //写回数据库
                Employee employee=new Employee();
                employee.setName(addName.getText());
                employee.setSex(addSex.getText());
                employee.setAge(addAge.getText());
                employee.setNation(addNation.getText());
                employee.setTelephone(addTelephone.getText());
                employee.setEmail(addEmail.getText());
                employee.setAcademic(addAcdemic.getText());
                employee.setCreateTime(simpleDateFormat.parse(addCreateTime.getText()));

                Address address=new Address();
                address.setProvince(addProvince.getText());
                address.setCity(addCity.getText());
                address.setArea(addArea.getText());
                address.setDetail(addDetail.getText());
                addressDao.insertAddress(address);

                employee.setAddress(address);

                Department department=departmentService.getDepartmentByName(addDeptName.getText());
                if(department!=null){
                    employee.setDepartment(department);
                }else{
                    System.out.println("部门名字有错误");
                }

                WorkType workType=workTypeDao.queryWorkTypeById(Integer.parseInt(addWorkTypeId.getText()));
                if(workType!=null){
                    employee.setWorkType(workType);
                    int effectedNum=employeeDao.insertEmployee(employee);
                    if(effectedNum==1){
                        data.add(new FatData(String.valueOf(employee.getEmployeeId()),employee.getName(),employee.getAge(),employee.getSex(),employee.getNation()
                                ,employee.getTelephone(),employee.getEmail(),employee.getAcademic(),simpleDateFormat.format(employee.getCreateTime())));
                    }
                }else{
                    System.out.println("该工种不存在");
                }

                //System.out.println(110);

            } catch (Exception msg) {
                msg.printStackTrace();
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setId("gridPane");
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(name,1,2);
        gridPane.add(addName,2,2);
        gridPane.add(sex,3,2);
        gridPane.add(addSex,4,2);
        gridPane.add(age,1,3);
        gridPane.add(addAge,2,3);
        gridPane.add(nation,3,3);
        gridPane.add(addNation,4,3);
        gridPane.add(telephone,1,4);
        gridPane.add(addTelephone,2,4);
        gridPane.add(email,3,4);
        gridPane.add(addEmail,4,4);
        gridPane.add(acdemic,1,5);
        gridPane.add(addAcdemic,2,5);
        gridPane.add(createTime,3,5);
        gridPane.add(addCreateTime,4,5);
        gridPane.add(province,1,6);
        gridPane.add(addProvince,2,6);
        gridPane.add(city,3,6);
        gridPane.add(addCity,4,6);
        gridPane.add(area,1,7);
        gridPane.add(addArea,2,7);
        gridPane.add(detail,3,7);
        gridPane.add(addDetail,4,7);
        gridPane.add(workTypeId,1,8);
        gridPane.add(addWorkTypeId,2,8);
        gridPane.add(deptName,3,8);
        gridPane.add(addDeptName,4,8);
        gridPane.add(determine,4,1);
        Scene scene = new Scene( gridPane, 700, 450);
        scene.getStylesheets().add(AddMember.class.getResource("/css/member.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
