package com.design.appleyk.DAM4_原型模式.DM4;

import java.io.Serializable;

/**
 * @Description //TODO
 * @Date 2023/10/31 14:32
 * @Author hy
 **/
public class PupilStudent implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 学号
     */
    private Long sNo;

    /**
     * 年级
     */
    private Integer sClass;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */

    private SexEnum sex = SexEnum.MALE;

    public PupilStudent() {

    }

    public Long getsNo() {
        return sNo;
    }

    public void setsNo(Long sNo) {
        this.sNo = sNo;
    }

    public Integer getsClass() {
        return sClass;
    }

    public void setsClass(Integer sClass) {
        this.sClass = sClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
}
