package binblink.stack;


/**
 * @Author binblink
 * @Create Time　2018/3/7 22:46
 * @Description:
 */
public interface Stack<T> {


    /**
     * @Author binblink
     * @Description:  出栈
     * @Date 2018/3/7 23:11
     * @Param []
     * @Return T
     */
    public abstract T pop();

    /**
     * @Author binblink
     * @Description:  入栈
     * @Date 2018/3/7 23:11
     * @Param []
     * @Return T
     */
    public abstract void push(T e);

    /**
     * @Author binblink
     * @Description:  判断是否为空
     * @Date 2018/3/7 23:11
     * @Param []
     * @Return boolean
     */
    public abstract boolean isEmpty();

    /**
     * @Author binblink
     * @Description:  返回栈顶元素
     * @Date 2018/3/7 23:12
     * @Param []
     * @Return T
     */
    public abstract T peek();

    /**
     * @Author binblink
     * @Description:  清空栈
     * @Date 2018/3/8 23:08
     * @Param []
     * @Return void
     */
    public abstract void clear();

    /**
     * @Author binblink
     * @Description:  按元素查找，不在栈中返回-1
     * @Date 2018/3/8 23:21
     * @Param [e]
     * @Return int  返回元素位置 起始位置为1
     */
    public abstract int find(T e);
}
