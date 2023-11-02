package com.design.appleyk.DMA7_装饰者模式.DM7;

/**
 * @Description //TODO
 * @Date 2023/11/2 10:58
 * @Author hy
 **/
public class FolderDecorator implements Folder {

    private Folder folder;

    public FolderDecorator(Folder folder) {
        this.folder = folder;
    }

    @Override
    public void mkDir() {
        System.out.println("-- 检查下，文件夹名称是否含有非法字符 --");
        this.folder.mkDir();
        System.out.println("-- 创建过程结束，提示用户文件夹是否创建成功 -- ");
    }

    @Override
    public void rmdir() {
        System.out.println("-- 检查下，文件夹是否为空，空的话直接删除，非空的话，提示下用户是否依然删除 --");
        this.folder.rmdir();
        System.out.println("-- 删除过程结束，提示用户文件夹是否删除成功 --");
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
