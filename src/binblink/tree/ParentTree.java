package binblink.tree;

/**
 * @Author binblink
 * @Create Time　2018/3/16 23:08
 * @Description: 树有四种存储结构 双亲表示法、 孩子表示、 双亲孩子、  孩子兄弟
 */
public class ParentTree<T> {

    private TreeNode[] treeArray;

    private TreeNode<T> rootnode;

    private class TreeNode<T>{
        int index;//parentNode index  the root index is -1
        T element;

        TreeNode(int pindex,T e){
            this.index = pindex;
            this.element = e;
        }
    }

    public ParentTree(int nodeNumber){
        this.treeArray = new TreeNode[nodeNumber];
        this.rootnode = new TreeNode(-1,null);
    }

    public void addNode(){

    }


}
