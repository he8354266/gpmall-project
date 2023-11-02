package com.design.appleyk.DMA7_装饰者模式.DM7;

/**
 * @Description //TODO
 * @Date 2023/11/2 10:56
 * @Author hy
 **/
public class FolderB implements Folder{
    @Override
    public void mkDir() {
        System.out.println("在Linux系统中创建文件夹B");
    }

    @Override
    public void rmdir() {
        System.out.println("在Linux系统中删除文件夹B");
    }
}
