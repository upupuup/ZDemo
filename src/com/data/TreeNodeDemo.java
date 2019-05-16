package com.data;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author:upupupuup
 * @Date:2019/5/16 9:18 PM
 * @Version 1.0
 * @Description:二叉树
 */
public class TreeNodeDemo {

    /**
     * 二叉树节点
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 创建二叉树
     * @param inputList 链表对象
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();

        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }

        return node;
    }

    /**
     * 二叉树前序遍历
     * @param node 二叉树对象
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 中序遍历
     * @param node 二叉树对象
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 后序遍历
     * @param node 二叉树对象
     */
    public static void postOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderTravel(node.leftChild);
        postOrderTravel(node.rightChild);
        System.out.println(node.data);
    }


    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;

        while(treeNode != null || !stack.isEmpty()) {
            // 迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }

            // 如果没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }

            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }

    /**
     * main方法
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[] {
                1, 2, 4, null, null, 5, null, null, 3, null, 6, null, null
        }));

        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历：");
        preOrderTraveral(treeNode);
        System.out.println("中序遍历：");
        inOrderTraveral(treeNode);
        System.out.println("后序遍历：");
        postOrderTravel(treeNode);
        System.out.println("非递归前序遍历：");
        preOrderTraveralWithStack(treeNode);
        System.out.println("层序遍历：");
        levelOrderTraversal(treeNode);
    }

}
