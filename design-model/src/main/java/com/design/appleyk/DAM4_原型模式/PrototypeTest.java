package com.design.appleyk.DAM4_原型模式;

import com.design.appleyk.DAM4_原型模式.DM4.HomeWork;
import com.design.appleyk.DAM4_原型模式.DM4.PupilStudent;
import com.design.appleyk.DAM4_原型模式.DM4.SexEnum;
import com.design.appleyk.DAM4_原型模式.DM4.WorkTypeEnum;
import org.apache.commons.lang3.time.DateUtils;


import java.util.Date;

/**
 * @Description //TODO
 * @Date 2023/10/31 15:26
 * @Author hy
 **/
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        HomeWork homeWork = new HomeWork();
        // 设置作业信息
        homeWork.setType(WorkTypeEnum.WULI);
        homeWork.setPages(12);
        homeWork.setFinishTime(new Date());
        // 设置小学生信息 == 刘晓然
        PupilStudent pupilStudent = new PupilStudent();
        pupilStudent.setsNo(1001L);
        pupilStudent.setName("");
        pupilStudent.setAge(10);
        pupilStudent.setSex(SexEnum.FEMALE);
        pupilStudent.setsClass(4);
        homeWork.setPupilStudent(pupilStudent);
//        HomeWork ykHomeWork = shallowCopy(homeWork);


        HomeWork zhangHomeWork = deepCopy(homeWork);
        System.out.println("Appleyk的作业：\n"+homeWork);
        System.out.println("张聪明的作业：\n"+zhangHomeWork);

    }


    public static HomeWork shallowCopy(HomeWork homeWork) throws CloneNotSupportedException {
        HomeWork myHomeWork = homeWork.clone();
        // 开始改造  == 首先改完成时间
        myHomeWork.setFinishTime(new Date());
        // 然后改作业的完成者，就是我 == 【Appleyk】
        PupilStudent mySelf = myHomeWork.getPupilStudent();
        // 学号肯定不能一样吧，不然这还不被发现作业是抄的吗
        mySelf.setsNo(1002L);
        // 我去，还要改名字，这事我差点忘了
        mySelf.setName("Appleyk");
        // 性别，对，还有性别，这个不能粗心大意，忘改了
        mySelf.setSex(SexEnum.MALE);
        // OK，一切就绪，改的那叫一个相当顺利啊，哈哈哈哈！ == 满心欢喜交作业咯
        return myHomeWork;
    }

    public static HomeWork deepCopy(HomeWork homeWork) throws CloneNotSupportedException {
        HomeWork myHomeWork = homeWork.deepClone();
        // 开始改造  == 首先改完成时间
        myHomeWork.setFinishTime(new Date());
        // 然后改作业的完成者，就是我 == 【Appleyk】
        PupilStudent mySelf = myHomeWork.getPupilStudent();
        // 学号肯定不能一样吧，不然这还不被发现作业是抄的吗
        mySelf.setsNo(1002L);
        // 我去，还要改名字，这事我差点忘了
        mySelf.setName("Appleyk");
        // 性别，对，还有性别，这个不能粗心大意，忘改了
        mySelf.setSex(SexEnum.MALE);
        // OK，一切就绪，改的那叫一个相当顺利啊，哈哈哈哈！ == 满心欢喜交作业咯
        return myHomeWork;
    }
}
