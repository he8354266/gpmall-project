package com.design.appleyk.DMA7_装饰者模式;

import com.design.appleyk.DMA7_装饰者模式.DM7.FolderA;
import com.design.appleyk.DMA7_装饰者模式.DM7.FolderB;
import com.design.appleyk.DMA7_装饰者模式.DM7.FolderDecorator;

/**
 * @Description //TODO
 * @Date 2023/11/2 11:09
 * @Author hy
 **/
public class DecoratorTest {
    public static void main(String[] args) {
        FolderA folderA = new FolderA();
        FolderDecorator folderDecorator = new FolderDecorator(folderA);
        folderDecorator.mkDir();
        folderDecorator.rmdir();


        FolderB folderB = new FolderB();
        FolderDecorator folderDecorator2 = new FolderDecorator(folderB);
        folderDecorator2.mkDir();
        folderDecorator2.rmdir();
    }
}
