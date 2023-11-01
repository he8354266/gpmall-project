package com.design.appleyk.DAM4_原型模式.DM4;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.http.impl.cookie.DateUtils;

import java.io.ByteArrayOutputStream;
import java.io.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description //TODO
 * @Date 2023/10/31 14:36
 * @Author hy
 **/
public class HomeWork implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 作业类型
     */
    private WorkTypeEnum type = WorkTypeEnum.YUWEN;

    /**
     * 完成时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;

    /**
     * 作业页码数【作业量】
     */
    private Integer pages = 0;


    /**
     * 完成者
     */
    private PupilStudent pupilStudent;

    public HomeWork() {

    }

    public WorkTypeEnum getType() {
        return type;
    }

    public void setType(WorkTypeEnum type) {
        this.type = type;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public PupilStudent getPupilStudent() {
        return pupilStudent;
    }

    public void setPupilStudent(PupilStudent pupilStudent) {
        this.pupilStudent = pupilStudent;
    }

    //浅拷贝
    @Override
    public HomeWork clone() throws CloneNotSupportedException {
        return (HomeWork) super.clone();
    }

    //深度拷贝
    public HomeWork deepClone() {
        HomeWork homeWork = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oss = new ObjectOutputStream(baos);
            oss.writeObject(this);


            byte[] bytes = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            //创建对象输入流
            ObjectInputStream ois = new ObjectInputStream(bais);
            homeWork = (HomeWork) ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getClass() + ":" + e.getMessage());
        }
        return homeWork;
    }

    @Override
    public String toString() {
        return  String.format("类型：%s,页数：%s,完成时间：%s," +
                        "完成者：%s,学号：%d,年级：%d,年龄:%d,性别：%s",this.type.getName()
                ,this.pages, this.finishTime,this.pupilStudent.getName(),
                this.pupilStudent.getsNo(),this.pupilStudent.getsClass(),
                this.pupilStudent.getAge(),this.pupilStudent.getSex().getName());
    }

}
