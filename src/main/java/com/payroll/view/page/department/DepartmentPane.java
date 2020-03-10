package com.payroll.view.page.department;

import com.payroll.entity.Department;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.util.Callback;
import java.util.List;
import java.util.ArrayList;

/**
 * 显示部门信息的表格
 */
public class DepartmentPane extends TreeTableView<Department> {

    //根节点
    TreeItem rootItem=new TreeItem(new Department());

    //列
    TreeTableColumn<Department,Department> columns[]=new TreeTableColumn[5];

    public DepartmentPane(){
        initColumns();
        this.setRoot(rootItem);
        this.setShowRoot(false);
    }

    private void initColumns(){
        //添加列
        columns[0]=new TreeTableColumn("部门ID");
        columns[1]=new TreeTableColumn("部门名");
        columns[2]=new TreeTableColumn("部门地址");
        columns[3]=new TreeTableColumn("部门人数");
        columns[4]=new TreeTableColumn("部门负责人");
        this.getColumns().addAll(columns);

        //设置CellValueFactory
        Callback cellValueFactory=new Callback() {
            @Override
            public Object call(Object param) {
                CellDataFeatures p=(CellDataFeatures) param;
                return p.getValue().valueProperty();
            }
        };

        for(int i=0;i<columns.length;i++){
            columns[i].setCellValueFactory(cellValueFactory);
        }

        // 设置CellFactory，定义每一列的单元格的显示
        // 这里使用了lambda表达式，否则写起来太长了！
        columns[0].setCellFactory((param) -> {
            return new MyTreeTableCell("c0");
        });
        columns[1].setCellFactory((param) -> {
            return new MyTreeTableCell("c1");
        });
        columns[2].setCellFactory((param) -> {
            return new MyTreeTableCell("c2");
        });
        columns[3].setCellFactory((param) -> {
            return new MyTreeTableCell("c3");
        });
        columns[4].setCellFactory((param) -> {
            return new MyTreeTableCell("c4");
        });

    }

    // 单元格的显示
    static class MyTreeTableCell extends TreeTableCell<Department, Department>
    {
        String columnID;

        public MyTreeTableCell(String columnID)
        {
            this.columnID = columnID;
        }

        @Override
        protected void updateItem(Department item, boolean empty)
        {
            super.updateItem(item, empty);

            if (empty || item == null)
            {
                setText(null);
                setGraphic(null);
            } else
            {
                setGraphic(null);
                if (columnID.equals("c0"))
                {
                    setText(String.valueOf(item.getDeptId()));
                } else if (columnID.equals("c1"))
                {
                    setText(String.valueOf(item.getDeptName()));
                } else if (columnID.equals("c2"))
                {
                    setText(String.valueOf(item.getDeptAddress()));
                } else if (columnID.equals("c3"))
                {
                    setText(String.valueOf(item.getMemberAmount()));
                } else if (columnID.equals("c4"))
                {
                    setText(String.valueOf(item.getEmployeeId()));
                }
            }
        }

    }


    public List<Department> get()
    {
        ArrayList<Department> results = new ArrayList<Department>();

        ObservableList<TreeItem<Department>> items = rootItem.getChildren();
        for (int i = 0; i < items.size(); i++)
        {
            TreeItem<Department> item = items.get(i);
            Department value = item.getValue();
            results.add(value);
        }

        return results;
    }

    @Override
    protected void layoutChildren()
    {
        super.layoutChildren();

        // 动态设置列宽
        double w = this.getWidth();
        double w0 = w * 0.3;
        double w1 = w * 0.4;
        double w2 = w - w0 - w1 - 20;
        columns[0].setPrefWidth(w0);
        columns[1].setPrefWidth(w1);
        columns[2].setPrefWidth(w2);
    }

    // 清空
    public void clear()
    {
        rootItem.getChildren().clear();
    }

    // 添加
    public void add(List<Department> datalist)
    {
        for (Department fi : datalist)
        {
            TreeItem item = new TreeItem(fi);
            rootItem.getChildren().add(item);
        }
    }

    public void add(Department data)
    {
        TreeItem item = new TreeItem(data);
        rootItem.getChildren().add(item);
    }

    public void remove(int index)
    {
        rootItem.getChildren().remove(index);
    }


}
