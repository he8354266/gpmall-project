package com.design.appleyk.DMB11_组合模式.DM11.login;

import com.design.appleyk.DMB11_组合模式.DM11.AbstractTree;
import com.design.appleyk.DMB11_组合模式.DM11.TreeNode;

import java.util.List;

/**
 * @Description //TODO
 * @Date 2023/11/3 16:03
 * @Author hy
 **/
public class LoginDiagram extends AbstractTree {

    public LoginDiagram(String name) {
        super(name);
    }

    @Override
    public void traverse(TreeNode node) {
        if (node.isRoot()) {
            System.out.println("根：" + node.getName() + ",父节点：" + node.getParent());
        } else if (node.isLeaf()) {
            System.out.println("叶子：" + node.getName() + ",父节点：" + node.getParent().getName());
        } else {
            System.out.println("枝：" + node.getName() + ",父节点：" + node.getParent().getName());
        }
        List<TreeNode> childrens = node.getChildrens();
        for (TreeNode cNode : childrens) {
            traverse(cNode);
        }
    }


}
