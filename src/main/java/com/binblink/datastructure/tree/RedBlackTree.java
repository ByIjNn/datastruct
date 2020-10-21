package com.binblink.datastructure.tree;

import java.util.HashMap;

/**
 * @author binblink
 * @version 1.0.0
 * @Date 2020/10/17 12:56
 * @Description 红黑树
 * 红黑树首先必须是二叉搜索树
 * 特征：1、节点只有两种颜色 红或黑
 * 2、根节点是黑色
 * 3、红色节点的子节点一定是黑色，即不能有两个连续的红节点
 * 4、任意一个节点到到空节点NULL（树尾端）的任何路径，所含之黑色节点数必须相同。（不会出现某一叶子节点大于任意叶子节点2度）
 * 5、默认空（null）位置的节点 为黑色，用于判断第四点和判断变色条件
 **/

public class RedBlackTree<T> {

    private static final int RED = 0;
    private static final int BLACK = 1;

    //红黑标志位 0红 1黑
    private int color = RED;


    private RedBlackTree<T> parent;
    private RedBlackTree<T> left;
    private RedBlackTree<T> right;
    private T data;

    public RedBlackTree() {

    }


    //从当前节点获取根节点
    public RedBlackTree<T> root() {
//        HashMap
        RedBlackTree<T> r = this;

        while (r.parent != null) {
            r = r.parent;
        }
        return r;
    }


    /**
     * 左旋
     *
     * @param currentTree
     */
    private void rotateleft(RedBlackTree<T> currentTree) {
        RedBlackTree<T> ri, sl, pa;
        ri = currentTree.right;
        sl = ri.left;

        if ((pa = currentTree.parent) != null) {
            if (pa.left == currentTree) {
                pa.left = ri;
            } else {
                pa.right = ri;
            }
        }

        ri.parent = pa;
        ri.left = currentTree;

        currentTree.right = sl;
        currentTree.parent = ri;
        if (sl != null) {
            sl.parent = currentTree;
        }

    }


    /**
     * @Description 右旋
     **/
    private void rotateright(RedBlackTree<T> currentTree) {

        RedBlackTree<T> le, sr, pa;

        le = currentTree.left;
        sr = le.right;

        if ((pa = currentTree.parent) != null) {
            if (pa.left == currentTree) {
                pa.left = le;
            } else {
                pa.right = le;
            }
        }

        le.parent = pa;
        le.right = currentTree;

        currentTree.parent = le;
        currentTree.left = sr;
        if (sr != null) {
            sr.parent = currentTree;
        }
    }


    /**
     * @author binblink
     * @Date 2020/10/19 19:22
     * @version 1.0.0
     * @Description 根据数据查找节点
     **/
    public RedBlackTree<T> find(T data) {
        RedBlackTree<T> rootNode = root();
        while (true) {
            if (rootNode == null) {
                break;
            }

            if (compare(data, rootNode.data) < 0) {
                rootNode = rootNode.left;
            } else if (compare(data, rootNode.data) > 0) {
                rootNode = rootNode.right;
            } else if (compare(data, rootNode.data) == 0) {
                break;
            }

        }
        return rootNode;
    }


    /**
     * 插入 和 二叉搜索树一样
     *
     * @param data 返回的是当前节点
     * @return
     */
    public RedBlackTree<T> insert(T data) {

        RedBlackTree<T> root = root();
        RedBlackTree<T> insertParent = root;
        RedBlackTree<T> insertNode = new RedBlackTree<>();

        insertNode.data = data;

        //插入第一个数据时
        if (root.data == null && root.parent == null) {
            root.color = BLACK;
            root.data = data;
            return root;
        }

        while (true) {

            if (compare(data, insertParent.data) <= 0) {

                if (insertParent.left == null) {
                    insertNode.parent = insertParent;
                    insertParent.left = insertNode;
                    break;
                } else {
                    insertParent = insertParent.left;
                }
            } else {
                if (insertParent.right == null) {
                    insertNode.parent = insertParent;
                    insertParent.right = insertNode;
                    break;
                } else {
                    insertParent = insertParent.right;
                }
            }
        }

        return insertfixUp(insertNode);
    }


    /**
     * @author binblink
     * @Date 2020/10/19 19:21
     * @version 1.0.0
     * @Description 删除 按二叉查找树先找出删除的节点
     * 1 被删除节点没有儿子，即为叶节点。那么，直接将该节点删除就OK了。
     * 2 被删除节点只有一个儿子。那么，直接删除该节点，并用该节点的唯一子节点顶替它的位置。
     * 3 被删除节点有两个儿子。那么，先找出它的后继节点；
     * 然后把“它的后继节点的内容”复制给“该节点的内容”；之后，删除“它的后继节点”
     **/
    public T delete(T data) {

        RedBlackTree<T> deleteTree = find(data);
        //未找到
        if (deleteTree == null) {
            return null;
        }
        //y 保存实际删除节点（后继节点） x保存替位节点
        RedBlackTree<T> y, x = null;
        //
        if (deleteTree.left == null || deleteTree.right == null) {
            y = deleteTree;
        } else {
            //删除节点具有双子节点 找后继节点
            y = findNext(deleteTree);
        }

        if (y.left != null) {
            x = y.left;
            x.parent = y.parent;
        }
        if (y.right != null) {
            x = y.right;
            x.parent = y.parent;
        }

        //删除的就是根节点
        if (y.parent == null) {
            //直接删除根节点
            T returndata = y.data;
            y.data = null;
            return returndata;
        } else{

            if (y == y.parent.left) {
                y.parent.left = x;
            }

            if (y == y.parent.right) {
                y.parent.right = x;
            }
        }


        //把后继节点的值给 要删除的节点
        if (y.data != deleteTree.data) {
            deleteTree.data = y.data;
        }

        //如果是黑色 违反了红黑树特性的第4条 因为少了一个黑色节点 就去fixup
        if (y.color == BLACK) {
            deleteFixUp(x);
        }

        return data;
    }


    /**
     * @author binblink
     * @Date 2020/10/20 21:15
     * @version 1.0.0
     * @Description查找后继节点 在delete()中已经判了 deleteTree 肯定有双子节点
     **/
    private RedBlackTree<T> findNext(RedBlackTree<T> deleteTree) {

        RedBlackTree<T> r = deleteTree.right;

        while (r.left != null) {
            r = r.left;
        }

        return r;
    }

    /**
     * 比较大小 排序
     *
     * @param data
     * @param data1
     * @return
     */
    private int compare(T data, Object data1) {

        if (data1 instanceof Comparable && data instanceof Comparable) {

            return ((Comparable) data).compareTo(data1);
        }

        if (System.identityHashCode(data) == System.identityHashCode(data1)) {
            return 0;
        }
        return System.identityHashCode(data) > System.identityHashCode(data1) ? 1 : -1;
    }


    /**
     * 插入完成后，将树校验为一个红黑树
     *
     * @param insertNode
     * @return
     */
    private RedBlackTree<T> insertfixUp(RedBlackTree<T> insertNode) {

        RedBlackTree<T> p, pp, uncle;
        p = insertNode.parent;
        if (p != null) {

            if (p.color == RED) {
                //走到这步 肯定存在祖父节点，pp不用判空了
                pp = insertNode.parent.parent;
                //记录父节点是祖父节点的左节点还是右节点
                int pposition = -1;
                int left = 0;
                int right = 1;

                if (p == pp.left) {
                    uncle = pp.right;
                    pposition = left;
                } else {
                    uncle = pp.left;
                    pposition = right;
                }

                //1、是否变色 如果父节点也是红色 并且叔叔节点(父节点的兄弟节点，如不存在默认为黑色)也是红色
                // 则变色----祖父变红、叔叔、父节点变黑,并设置祖父为当前节点
                if (uncle != null && uncle.color == RED) {
                    pp.color = RED;
                    p.color = BLACK;
                    uncle.color = BLACK;
                    return insertfixUp(pp);
                } else {
                    // 叔叔为空 或为黑色时
                    // 父节点为 祖父节点的左节点
                    if (pposition == left) {
                        if (insertNode == p.left) {
                            p.color = BLACK;
                            pp.color = RED;
                            rotateright(pp);
                            return insertfixUp(pp);
                        } else {
                            rotateleft(p);
                            return insertfixUp(p);
                        }
                        // 父节点为 祖父节点的右节点，和上面左右旋操作相反
                    } else if (pposition == right) {

                        if (insertNode == p.right) {
                            p.color = BLACK;
                            pp.color = RED;
                            rotateleft(pp);
                            return insertfixUp(pp);
                        } else {
                            rotateright(p);
                            return insertfixUp(p);
                        }
                    }
                }

            } else {
                //黑色 直接返回
                return insertNode;
            }
        }

        // insertNode 为根节点 变黑 返回
        insertNode.color = BLACK;
        return insertNode;
    }

    /**
     * 删除完成后，将树校验为一个红黑树
     *
     * @param x 替位的x节点
     * @return 假设x有一个额外的黑色，那x为黑+黑 或黑+红
     * 核心思想：将x所包含的额外的黑色不断沿树上移(向根方向移动)，直到出现下面的姿态：
     * a) x指向一个"红+黑"节点。此时，将x设为一个"黑"节点即可。
     * b) x指向根。此时，将x设为一个"黑"节点即可。
     * c) 非前面两种姿态,即 x为黑+黑 并不为根节点 分为四种情况：
     * <p>
     * 若 “x”是“它父节点的左孩子” ：
     * <p>
     * 1 x是"黑+黑"节点，x的兄弟节点是红色。(此时x的父节点和x的兄弟节点的子节点都是黑节点)。
     * (01) 将x的兄弟节点设为“黑色”。
     * (02) 将x的父节点设为“红色”。
     * (03) 对x的父节点进行左旋。
     * (04) 左旋后，重新设置x的兄弟节点。
     * 2 x是“黑+黑”节点，x的兄弟节点是黑色，x的兄弟节点的两个孩子都是黑色。
     * (01) 将x的兄弟节点设为“红色”。
     * (02) 设置“x的父节点”为“新的x节点”。
     * 3 x是“黑+黑”节点，x的兄弟节点是黑色；x的兄弟节点的左孩子是红色，右孩子是黑色的
     * (01) 将x兄弟节点的左孩子设为“黑色”。
     * (02) 将x兄弟节点设为“红色”。
     * (03) 对x的兄弟节点进行右旋。
     * (04) 右旋后，重新设置x的兄弟节点。
     * <p>
     * 4 x是“黑+黑”节点，x的兄弟节点是黑色；x的兄弟节点的右孩子是红色的，x的兄弟节点的左孩子任意颜色。
     * (01) 将x父节点颜色 赋值给 x的兄弟节点。
     * (02) 将x父节点设为“黑色”。
     * (03) 将x兄弟节点的右子节设为“黑色”。
     * (04) 对x的父节点进行左旋。
     * (05) 设置“x”为“根节点”。
     * <p>
     * 若 “x”是“它父节点的右孩子” ：上面所有左右操作互换
     */
    private RedBlackTree<T> deleteFixUp(RedBlackTree<T> x) {

        if(x == null){
            return x;
        }

        RedBlackTree<T> p, xbro;
        if (x.color == RED) {
            x.color = BLACK;
            return x;
        }

        if ((p = x.parent) == null) {
            x.color = BLACK;
            return x;
        }

        if (p.left == x) {
            xbro = p.right;

            if (xbro.color == RED) {
                xbro.color = BLACK;
                p.color = RED;
                rotateleft(p);
                return deleteFixUp(x);
            }

            if (xbro.color == BLACK) {

                if ((xbro.left == null || xbro.left.color == BLACK) &&
                        (xbro.right == null || xbro.right.color == BLACK)) {
                    xbro.color = RED;
                    return deleteFixUp(p);
                }

                if (xbro.left != null && xbro.left.color == RED &&
                        (xbro.right == null || xbro.right.color == BLACK)) {

                    xbro.left.color = BLACK;
                    xbro.color = RED;
                    rotateright(xbro);
                    return deleteFixUp(x);
                }

                if (xbro.right != null && xbro.right.color == RED) {
                    xbro.color = p.color;
                    p.color = BLACK;
                    xbro.right.color = BLACK;
                    rotateleft(p);
                    x.parent = null;
                }
            }
        }

        //与上面左右颠倒
        if (p.right == x) {

            xbro = p.left;

            if (xbro.color == RED) {
                xbro.color = BLACK;
                p.color = RED;
                rotateright(p);
                return deleteFixUp(x);
            }

            if (xbro.color == BLACK) {

                if ((xbro.right == null || xbro.right.color == BLACK) &&
                        (xbro.left == null || xbro.left.color == BLACK)) {
                    xbro.color = RED;
                    return deleteFixUp(p);
                }

                if (xbro.right != null && xbro.right.color == RED &&
                        (xbro.left == null || xbro.left.color == BLACK)) {

                    xbro.right.color = BLACK;
                    xbro.color = RED;
                    rotateleft(xbro);
                    return deleteFixUp(x);
                }

                if (xbro.left != null && xbro.left.color == RED) {
                    xbro.color = p.color;
                    p.color = BLACK;
                    xbro.left.color = BLACK;
                    rotateright(p);
                    x.parent = null;
                    return deleteFixUp(x);
                }
            }
        }
        return x;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer("RedBlackTree{" +
                "color=" + color +
                ", data=" + data);

        if (parent != null) {
            sb.append(", parent.color=" + parent.color +
                    ", parent.data=" + parent.data);

        } else {
            sb.append(", parent=null");
        }

        if (left != null) {
            sb.append(
                    ", left.color=" + left.color +
                            ", left.data=" + left.data);
        } else {
            sb.append(", left=null");
        }

        if (right != null) {
            sb.append(", right.color=" + right.color +
                    ", right.data=" + right.data + ')');
        } else {
            sb.append(", right=null}");
        }

        return sb.toString();
    }

}
