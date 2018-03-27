package binblink.tree;

/**
 * @Author binblink
 * @Create Time　2018/3/26 23:51
 * @Description: 孩子双亲  二叉树
 */
public class BinaryTree<T> {

    private Object[] arrayTree;

    private class TreeNode<T>{

//        public int index;

        public int parentIndex;

        public int leftChildIndex;

        public int rightChildIndex;

        public T element;


        public TreeNode(T ele){
            this.element = ele;
            this.parentIndex = 0;
            this.leftChildIndex = 0;
            this.rightChildIndex = 0;
        }

    }
}
