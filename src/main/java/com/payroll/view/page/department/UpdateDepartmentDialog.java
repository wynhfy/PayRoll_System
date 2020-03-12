package com.payroll.view.page.department;

import com.payroll.entity.Department;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class UpdateDepartmentDialog extends Dialog<Boolean> {

    private Department department;

    TextField deptAddress=new TextField();
    TextField deptName=new TextField();
    TextField employeeId=new TextField();

    public UpdateDepartmentDialog(Department department){
        this.department=department;
        Text scenetitle=new Text("修改部门信息");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label name=new Label("部门名:");
        Label address=new Label("部门地址:");
        Label employeeid=new Label("负责人工号:");
        grid.add(name,0,1);
        grid.add(address,0,2);
        grid.add(employeeid,0,3);


        if(this.department!=null){
            deptAddress.setText(department.getDeptAddress());
            deptName.setText(department.getDeptName());
            employeeId.setText(String.valueOf(department.getEmployeeId()));
        }
        grid.add(deptName,1,1);
        grid.add(deptAddress,1,2);
        grid.add(employeeId,1,3);

        DialogPane dialogPane=new DialogPane();
        dialogPane.setContent(grid);
        ButtonType ok = new ButtonType("确定", ButtonBar.ButtonData.OK_DONE);
        dialogPane.getButtonTypes().add(ok);
        ButtonType cancel = new ButtonType("取消", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialogPane.getButtonTypes().add(cancel);

        this.setResultConverter(new Callback<ButtonType,Boolean>(){

            @Override
            public Boolean call(ButtonType b)
            {
                if(b.getButtonData() == ButtonBar.ButtonData.OK_DONE)
                    return true;
                return false;
            }
        });

        // 创建对话框
        this.setDialogPane(dialogPane);
        this.setTitle("修改部门信息");
    }

    public Department getValue(){
        department.setDeptAddress(deptAddress.getText());
        department.setDeptName(deptName.getText());
        if("null".equals(employeeId.getText())){
            department.setEmployeeId(null);
        }else{
            department.setEmployeeId(Integer.parseInt(employeeId.getText()));
        }
        return  department;
    }

}
