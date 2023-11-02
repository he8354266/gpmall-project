package com.design.appleyk.DMA7_装饰者模式.DM7;

/**
 * @Description //TODO
 * @Date 2023/11/2 10:55
 * @Author hy
 **/
public class FolderA implements Folder{
    @Override
    public void mkDir() {
        System.out.println("在Windows系统中创建文件夹A");
    }

    @Override
    public void rmdir() {
        System.out.println("在Windows系统中删除文件夹A");
    }
}
