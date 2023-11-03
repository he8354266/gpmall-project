package com.design.appleyk.DMB11_组合模式.DM11;

/**
 * @Description //TODO
 * @Date 2023/11/3 15:02
 * @Author hy
 **/
public abstract class AbstractTree {
    private TreeNode root = null;

    public AbstractTree() {

    }

    public TreeNode getRoot() {
        return root;
    }

    public AbstractTree(String name) {
        root = new TreeNode(name);
    }

    public abstract void traverse(TreeNode node);
}
