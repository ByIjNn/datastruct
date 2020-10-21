import com.binblink.datastructure.tree.RedBlackTree;
import org.junit.jupiter.api.Test;

/**
*
* @author binblink
* @Date 2020/10/19 18:24
* @version 1.0.0
* @Description
 * 测试红黑树
 * https://www.cs.usfca.edu/~galles/visualization/RedBlack.html 可以去和这个对比
*
**/
public class RedBlackTreeTest {


    @Test
    public void test1(){

        RedBlackTree<Integer> root = new RedBlackTree();

        root.insert(30);
        root.insert(10);
        root.insert(9);
        root.insert(16);
        root.insert(12);
        root.insert(70);
        root.insert(1);
        root.insert(6);

        RedBlackTree<Integer> node = root.find(30);

        System.out.println(node);
    }


}
