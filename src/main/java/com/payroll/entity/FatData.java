package com.payroll.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 这个类是用来将数据库的数据变成可以存在于员工界面表的
 */
public class FatData {
    private  final StringProperty workId;
    private  final StringProperty name;
    private  final StringProperty age;
    private  final StringProperty sex;
    private  final StringProperty nation;
    private  final StringProperty telephone;
    private  final StringProperty email;
    private  final StringProperty academic;
    private  final StringProperty create_time;

    public FatData(String workId, String name,String age,String sex, String nation, String telephone,String email, String academic, String create_time){
        this.workId = new SimpleStringProperty(workId);
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleStringProperty(age);
        this.sex = new SimpleStringProperty(sex);
        this.nation = new SimpleStringProperty(nation);
        this.telephone = new SimpleStringProperty(telephone);
        this.email = new SimpleStringProperty(email);
        this.academic = new SimpleStringProperty(academic);
        this.create_time = new SimpleStringProperty(create_time);

    }
    public String getWorkId() {
        return this.workId.get();
    }

    public void setWorkId(String fName) {
        this.workId.set(fName);
    }

    public String getName() {
        return this.name.get();
    }

    public void setName(String fName) {
        this.name.set(fName);
    }

    public String getAge() {
        return this.age.get();
    }

    public void setAge(String age) {
        this.name.set(age);
    }

    public String getSex() {
        return this.sex.get();
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public String getNation() {
        return this.nation.get();
    }

    public void setNation(String nation) {
        this.name.set(nation);
    }

    public String getTelephone() {
        return this.telephone.get();
    }

    public void setTelephone(String telephone) {
        this.name.set(telephone);
    }

    public String getEmail() {
        return this.email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getAcdemic() {
        return this.name.get();
    }

    public void setAcademic(String academic) {
        this.name.set(academic);
    }

    public String getCreate_time() {
        return this.create_time.get();
    }

    public void setCreate_time(String age) {
        this.create_time.set(age);
    }


    public StringProperty workIdProperty() {
        return this.workId;
    }
    public StringProperty nameProperty() { return this.name; }
    public StringProperty ageProperty() {
        return this.age;
    }
    public StringProperty sexProperty() {
        return this.sex;
    }
    public StringProperty nationProperty() {
        return this.nation;
    }
    public StringProperty telephoneProperty() {
        return this.telephone;
    }
    public StringProperty emailProperty() {
        return this.email;
    }
    public StringProperty academicProperty() {
        return this.academic;
    }
    public StringProperty create_timeProperty() {
        return this.create_time;
    }

    @Override
    public String toString() {
        return "FatData{" +
                "workId=" + workId +
                ", name=" + name +
                ", age=" + age +
                ", sex=" + sex +
                ", nation=" + nation +
                ", telephone=" + telephone +
                ", email=" + email +
                ", academic=" + academic +
                ", create_time=" + create_time +
                '}';
    }
}