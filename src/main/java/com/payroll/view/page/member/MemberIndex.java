package com.payroll.view.page.member;

import java.text.SimpleDateFormat;
import java.util.*;

import com.payroll.entity.Department;
import com.payroll.entity.FatData;
import com.payroll.service.DepartmentService;
import com.payroll.service.EmployeeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import com.payroll.entity.Employee;
import com.payroll.global.GlobalConfig;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *  员工管理信息主页
 */
public class MemberIndex {

    private EmployeeService employeeService=(EmployeeService)GlobalConfig.ctx.getBean("employeeServiceImpl");
    private DepartmentService departmentService=(DepartmentService)GlobalConfig.ctx.getBean("departmentServiceImpl");
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

    private Pane myFlowpane;
    private TableView<FatData> table = new TableView<FatData>();
    private ObservableList<FatData> data;
    private List<FatData> oneTime;
    private HashMap<Label, String> orderMap = new HashMap<>();
    TableColumn firstNameCol = new TableColumn("id");
    TableColumn lastNameCol = new TableColumn("Name");
    TableColumn thirdNameCol = new TableColumn("age");
    TableColumn fourNameCol = new TableColumn("sex");
    TableColumn fiveNameCol = new TableColumn("nation");
    TableColumn sixNameCol = new TableColumn("telephone");
    TableColumn sevenNameCol = new TableColumn("email");
    TableColumn eightNameCol = new TableColumn("acdemic");
    TableColumn nineNameCol = new TableColumn("create_time");
    Label labelAge = new Label();
    BorderPane borderPane = new BorderPane();
    HBox hbox = new HBox();
    Pane pane = new Pane();

    public MemberIndex() {

    }

    public BorderPane start() throws Exception {
        this.initPane();
//        this.AddMember();
        this.addMemberTwo();
        this.search();
        //this.modify();
//        this.sort();
        this.sortTwo();
        this.deleteTableColumn();

        borderPane.setId("borderPane");
        hbox.setId("hbox");
        pane.setId("pane");
        borderPane.setTop(hbox);
//        borderPane.setTop(sortTwo());
        borderPane.setCenter(pane);
        return borderPane;
    }


    public void initPane() {
        labelAge.setMinWidth(thirdNameCol.getMinWidth());
        labelAge.setMaxWidth(thirdNameCol.getMaxWidth());
        labelAge.setPrefWidth(thirdNameCol.getPrefWidth());
        table.setEditable(true);
        table.setId("table");
        table.setPrefWidth(897);
        table.setPrefHeight(550);
        firstNameCol.impl_setWidth(110); //设置列项的大小
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("workId"));
        firstNameCol.setSortable(false); //关闭排序功能

        lastNameCol.impl_setWidth(110);
        lastNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        lastNameCol.setSortable(false); //关闭排序功能

        thirdNameCol.impl_setWidth(110);
        thirdNameCol.setCellValueFactory(new PropertyValueFactory("age"));
        thirdNameCol.setSortable(false); //关闭排序功能

        fourNameCol.impl_setWidth(110);
        fourNameCol.setCellValueFactory(new PropertyValueFactory("sex"));
        fourNameCol.setSortable(false); //关闭排序功能

        fiveNameCol.impl_setWidth(110);
        fiveNameCol.setCellValueFactory(new PropertyValueFactory("nation"));
        fiveNameCol.setSortable(false); //关闭排序功能

        sixNameCol.impl_setWidth(110);
        sixNameCol.setCellValueFactory(new PropertyValueFactory("telephone"));
        sixNameCol.setSortable(false); //关闭排序功能

        sevenNameCol.impl_setWidth(110);
        sevenNameCol.setCellValueFactory(new PropertyValueFactory("email"));
        sevenNameCol.setSortable(false); //关闭排序功能

        eightNameCol.impl_setWidth(110);
        eightNameCol.setCellValueFactory(new PropertyValueFactory("academic"));
        eightNameCol.setSortable(false); //关闭排序功能

        nineNameCol.impl_setWidth(110);
        nineNameCol.setCellValueFactory(new PropertyValueFactory("create_time"));
        nineNameCol.setSortable(false); //关闭排序功能

        table.getColumns().addAll(firstNameCol, lastNameCol, thirdNameCol, fourNameCol, fiveNameCol, sixNameCol, sevenNameCol, eightNameCol, nineNameCol);
        this.pane.getChildren().add(table);
        this.data = FXCollections.observableArrayList();

        /**
         * 初始化数据
         */
        List<Employee> employeeList=employeeService.getEmployeeList();
        if(employeeList!=null&&employeeList.size()!=0){
            for(Employee employee:employeeList){
                this.data.add(new FatData(String.valueOf(employee.getEmployeeId()),employee.getName(),employee.getAge(),employee.getSex(),employee.getNation()
                        ,employee.getTelephone(),employee.getEmail(),employee.getAcademic(),simpleDateFormat.format(employee.getCreateTime())));

            }
        }
        table.setItems(data);
    }

    /*
    排序功能
   */
    private void order(Comparator<FatData> comparator) {
        Collections.sort((List) data, comparator);
    }

    /*
     小到大排序
     */
    Comparator<FatData> asc = new Comparator<FatData>() {

        @Override
        public int compare(FatData p1, FatData p2) {
            return Integer.compare(Integer.parseInt(p1.getAge()), Integer.parseInt(p2.getAge()));
        }
    };

    /*
     大到小排序
     */
    Comparator<FatData> desc = (p1, p2) -> Integer.compare(Integer.parseInt(p2.getAge()), Integer.parseInt(p1.getAge()));

    /*
     添加新的员工信息
     */

    public void addMemberTwo(){
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
                try {
               AddMember member = new AddMember(data);
               member.start(new Stage());

            } catch (Exception msg) {
                msg.printStackTrace();
            }
            });
         hbox.getChildren().add(addButton);

    }

    /*
     对表进行检索,只能按工号进行搜索
     */
    public void search() {
        final TextField search = new TextField();
        search.setMaxWidth(firstNameCol.getPrefWidth());
        search.setPromptText("search");

        final Button searchButton = new Button("search");
        search.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()== KeyCode.ENTER){
                    if (search.getText() == null||"".equals(search.getText())) {
                        //从数据库中取出数据放到data数组中
                        List<Employee> employeeList=employeeService.getEmployeeList();
                        data.clear();
                        if(employeeList!=null&&employeeList.size()!=0){
                            for(Employee employee:employeeList){
                                data.add(new FatData(String.valueOf(employee.getEmployeeId()),employee.getName(),employee.getAge(),employee.getSex(),employee.getNation()
                                        ,employee.getTelephone(),employee.getEmail(),employee.getAcademic(),simpleDateFormat.format(employee.getCreateTime())));
                                //System.out.println(employee);
                            }
                        }
                    }
                    for (int i = 0; i < data.size(); i++) {
                        if (search.getText().compareTo(data.get(i).getWorkId()) == 0) {
                            FatData fat = new FatData(data.get(i).getWorkId(), data.get(i).getName(), data.get(i).getAge(), data.get(i).getSex(), data.get(i).getNation(), data.get(i).getTelephone(), data.get(i).getEmail(), data.get(i).getAcdemic(), data.get(i).getCreate_time());
                            data.clear();
                            data.add(fat);
                        }
                    }
                }
            }
        });
        searchButton.setOnAction((ActionEvent e) -> {
            if (search.getText() == null||"".equals(search.getText())) {
                //从数据库中取出数据放到data数组中
                List<Employee> employeeList=employeeService.getEmployeeList();
                data.clear();
                if(employeeList!=null&&employeeList.size()!=0){
                    for(Employee employee:employeeList){
                        this.data.add(new FatData(String.valueOf(employee.getEmployeeId()),employee.getName(),employee.getAge(),employee.getSex(),employee.getNation()
                                ,employee.getTelephone(),employee.getEmail(),employee.getAcademic(),simpleDateFormat.format(employee.getCreateTime())));
                        //System.out.println(employee);
                    }
                }
            }
            for (int i = 0; i < data.size(); i++) {
                if (search.getText().compareTo(data.get(i).getWorkId()) == 0) {
                    FatData fat = new FatData(data.get(i).getWorkId(), data.get(i).getName(), data.get(i).getAge(), data.get(i).getSex(), data.get(i).getNation(), data.get(i).getTelephone(), data.get(i).getEmail(), data.get(i).getAcdemic(), data.get(i).getCreate_time());
                    data.clear();
                    data.add(fat);
                }
            }

        });

        hbox.getChildren().add(search);
        hbox.getChildren().add(searchButton);
    }

    /*
     修改表信息
     */

    /*
     修改表信息之二
     */

    /*
    对表重新排序
     */
    public void sort() {
        orderMap.put(labelAge, "NO");
        thirdNameCol.setSortable(false);
        thirdNameCol.setGraphic(labelAge);
        labelAge.setOnMouseClicked(mouseEvent -> {
            switch (orderMap.get(labelAge)) {
                case "NO":
                    orderMap.replace(labelAge, "ASC");//你把这里改成原来的排序
                    order(asc);
                    break;
                case "ASC":
                    orderMap.put(labelAge, "DESC");//大到小
                    order(desc);
                    break;
                case "DESC":
                    orderMap.put(labelAge, "ASC");//小到大
                    order(asc);
                    break;
            }
        });

        Label labelSalary = new Label();
        labelSalary.setMinWidth(eightNameCol.getMinWidth());
        labelSalary.setMaxWidth(eightNameCol.getMaxWidth());
        labelSalary.setPrefWidth(eightNameCol.getPrefWidth()/4*3);
        orderMap.put(labelSalary, "NO");
        eightNameCol.setSortable(false);
        eightNameCol.setGraphic(labelSalary);
        labelSalary.setOnMouseClicked(mouseEvent -> {
            switch (orderMap.get(labelSalary)) {
                case "NO":
                    orderMap.replace(labelSalary, "ASC");
                    order(asc);
                    break;
                case "ASC":
                    orderMap.put(labelSalary, "DESC");
                    order(desc);
                    break;
                case "DESC":
                    orderMap.put(labelSalary, "ASC");
                    order(asc);
                    break;
            }
        });

    }

    /*
    删除和修改
    删除表的某一行或显示某一行的具体信息
     */
    public void deleteTableColumn() {

        table.setRowFactory( tv -> {
        TableRow<FatData> row = new TableRow<FatData>();
        row.setOnMouseClicked(event -> {
        if (event.getButton()==MouseButton.SECONDARY && (! row.isEmpty()) ) {
              FatData fatData = row.getItem();
              System.out.println(fatData.getWorkId());
            ContextMenu contextMenu = new ContextMenu();
            // 菜单项
            MenuItem redBg = new MenuItem("删除");
            MenuItem show = new MenuItem("显示或修改具体信息");
            redBg.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    for (int i = 0; i < data.size(); i++) {
                        if (fatData.getWorkId().equals(data.get(i).getWorkId())) {
                            Employee employee=employeeService.getEmployeeById(Integer.parseInt(fatData.getWorkId()));
                            Department department=employee.getDepartment();
                            department.setMemberAmount(department.getMemberAmount()-1);
                            if(departmentService.updateDepartment(department)){
                                if(employeeService.deleteEmployee(Integer.parseInt(fatData.getWorkId()))==1){
                                    data.remove(i);

                                }else{
                                    System.out.println("删除失败");
                                }
                            }
                        }
                    }
                }
            });
            show.setOnAction(new EventHandler<ActionEvent>() {
                Display dis=null;
                public void handle(ActionEvent event) {
                    for(int i=0;i<data.size();i++){
                        if(fatData.getWorkId().equals(data.get(i).getWorkId())){
                            Employee employee=employeeService.getEmployeeById(Integer.parseInt(data.get(i).getWorkId()));
//                            System.out.println(employee);
                            if(employee!=null){
                                dis=new Display(String.valueOf(employee.getEmployeeId()),employee.getName(),employee.getSex(),employee.getAge(),employee.getNation(),employee.getTelephone(), employee.getEmail(),employee.getAcademic(),simpleDateFormat.format(employee.getCreateTime()),
                                        employee.getAddress().getProvince(),employee.getAddress().getCity(),employee.getAddress().getArea(),employee.getAddress().getDetail(),
                                        employee.getDepartment().getDeptName(),employee.getDepartment().getDeptAddress(),String.valueOf(employee.getDepartment().getMemberAmount()),String.valueOf(employee.getDepartment().getEmployeeId()),
                                        String.valueOf(employee.getWorkType().getWorkType()),String.valueOf(employee.getWorkType().getGrade()),String.valueOf(employee.getWorkType().getBaseSalary()),employee,data);
                            }
                            break;
                        }
                    }
                    try {
                        dis.start(new Stage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                }
            );
            contextMenu.getItems().addAll(show,redBg);
            row.setContextMenu(contextMenu);

          }
       });
     return row ;
});
 }

   public Pane sortTwo(){

       labelAge.setText("come on");
       orderMap.put(labelAge, "NO");
       thirdNameCol.setSortable(false);
       final ComboBox comboBox = new ComboBox( FXCollections.observableArrayList(
                       "AgeSort_asc",
               "AgeSort_desc"
       ));
       comboBox.getSelectionModel().selectedIndexProperty().addListener((ov,oldv,newv)->{
                 System.out.println(oldv);
                 System.out.println(newv);
           switch (orderMap.get(labelAge)) {
               case "NO":
                   orderMap.replace(labelAge, "ASC");//你把这里改成原来的排序
                   order(asc);
                   break;
               case "ASC":
                   orderMap.put(labelAge, "DESC");//大到小
                   order(desc);
                   break;
               case "DESC":
                   orderMap.put(labelAge, "ASC");//小到大
                   order(asc);
                   break;
           }

       });

       hbox.getChildren().add(comboBox);
       return hbox;
   }

}


