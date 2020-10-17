package com.binblink.datastructure.tree;

import java.util.Comparator;
import java.util.HashMap;

/**
*
* @author binblink
* @Date 2020/10/17 12:56
* @version 1.0.0
* @Description 红黑树
 *  红黑树首先必须是二叉搜索树
 *  特征：1、节点只有两种颜色 红或黑
 *      2、根节点是黑色
 *      3、红色节点的子节点一定是黑色，即不能有两个连续的红节点
 *      4、每个节点到其任意子孙节点的黑色节点数量一样（不会出现某一叶子节点大于任意叶子节点2度）
 *      5、默认空（null）位置的节点 为黑色，用于判断第四点和判断变色条件
*
**/

public class RedBlackTree<T> {

    //红黑标志位 0红 1黑
    private int red = 0 ;


    private RedBlackTree<T> parent;
    private RedBlackTree<T> left;
    private RedBlackTree<T> right;
    private T data;

    public RedBlackTree(T data){
        this.data = data;
    }


    //从当前节点获取根节点
    public RedBlackTree<T> root(){
//            HashMap
        RedBlackTree<T> r = this;
        while(r.parent != null){
            r = r.parent;
        }
        return r;
    }



    /**
     *   左旋
     * @param currentTree
     */
    private void rotateleft(RedBlackTree<T> currentTree){
        RedBlackTree<T> ri,sl,pa;
        pa = currentTree.parent;
        ri = currentTree.right;
        sl = ri.left;

        if(pa.left == currentTree){
            pa.left = ri;
        }else{
            pa.right = ri;
        }

        ri.parent = pa;
        ri.left = currentTree;

        currentTree.right = sl;
        currentTree.parent = ri;

        sl.parent = currentTree;

    }



    /**
    *
    * @Date 2020/10/17 14:15
    * @version 1.0.0
    * @Description  右旋
    *
    **/
    private void totateright(RedBlackTree<T> currentTree){

        RedBlackTree<T> le,sr,pa;
        pa = currentTree.parent;
        le = currentTree.left;
        sr = le.right;

        if(pa.left == currentTree){
            pa.left = le;
        }else{
            pa.right = le;
        }

        le.parent = pa;
        le.right = currentTree;

        currentTree.parent =le;
        currentTree.left = sr;

        sr.parent = currentTree;
    }




    /**
     *  插入
     * @param data 返回的是当前节点
     * @return
     */
    public RedBlackTree<T> insert(T data,Comparator<T> comparator){
        RedBlackTree<T> root = root();
        RedBlackTree insertParent = root;
        RedBlackTree<T> insertNode = new RedBlackTree<>(data);

        if(root == null){
            return insertNode;
        }

        while(insertParent != null){

            if(comparator.compare(data, (T) insertParent.left.data)<=0){
                insertParent = insertNode.left;
            }
        }



        fixUp(insertNode);

        return null;
    }

    private RedBlackTree<T> fixUp(RedBlackTree<T> insertNode) {

        return  null;
    }


}
