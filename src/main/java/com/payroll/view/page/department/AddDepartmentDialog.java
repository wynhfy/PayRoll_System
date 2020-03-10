package com.payroll.view.page.department;


import com.payroll.entity.Department;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 * 添加部门信息的页面
 */
public class AddDepartmentDialog extends Dialog<Boolean> {

    TextField deptName=new TextField();
    TextField deptAddress=new TextField();
    //TextField deptMemberAmount=new TextField();
    TextField employeeId=new TextField();

    public AddDepartmentDialog(){
        // 对话框内容
        VBox content = new VBox();

        deptName.setPromptText("部门名");
        deptAddress.setPromptText("部门地址");
        employeeId.setPromptText("部门负责人");
        content.setSpacing(10);
        content.getChildren().addAll(deptName,deptAddress,employeeId);

        // Dialog -> DialogPane -> Root Node
        DialogPane dialogPane = new DialogPane();
        dialogPane.setContent(content);

        // 添加按钮
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
        this.setTitle("添加部门信息");

    }

    // 获取用户输入的值,返回一个department对象
    public Department getValue()
    {
        try {
            Department department = new Department();
            department.setDeptName(deptName.getText());
            department.setDeptAddress(deptAddress.getText());
            department.setEmployeeId(Integer.valueOf(employeeId.getText()));
            return department;

        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 数据校验
     * @return
     */
//    private boolean checkValid()
//    {
//        int n = 0;
//        try {
//            n = Integer.valueOf( id.getText().trim() );
//        }catch(Exception e)
//        {
//        }
//        if(n <=0)
//        {
//            Alert warning = new Alert(AlertType.WARNING);
//            warning.setHeaderText(null);
//            warning.setContentText("学号输入错误！请输入整数!");
//            warning.showAndWait();
//            return false;
//        }
//        return true;
//    }


}
