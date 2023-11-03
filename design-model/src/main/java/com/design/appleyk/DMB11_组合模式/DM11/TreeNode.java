package com.design.appleyk.DMB11_组合模式.DM11;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description //TODO
 * @Date 2023/11/3 15:02
 * @Author hy
 **/
public class TreeNode {
    private String name;
    private TreeNode parent;

    private List<TreeNode> childrens = new ArrayList<>();

    public TreeNode() {
    }

    public TreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return parent;
    }


    public List<TreeNode> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<TreeNode> childrens) {
        this.childrens = childrens;
    }

    public void addChildren(TreeNode node) {
        node.setParent(this);
        this.childrens.add(node);
    }

    public TreeNode addChildren(String node) {
        TreeNode cNode = new TreeNode(node);
        cNode.setParent(this);
        this.childrens.add(cNode);
        return cNode;
    }

    public void removeChildren(TreeNode node) {
        this.childrens.remove(node);
    }

    public boolean isLeaf() {
        return !(this.childrens.size() > 0) && (this.parent != null);
    }

    public boolean hasParent() {
        return !(this.parent == null);
    }

    public boolean isRoot() {
        return this.parent == null;
    }
}
