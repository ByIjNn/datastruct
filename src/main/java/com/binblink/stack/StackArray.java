package com.binblink.stack;

import java.util.EmptyStackException;

/**
 * @Author binblink
 * @Create Time　2018/3/8 23:37
 * @Description:
 */
public class StackArray<T> implements Stack<T> {

    private int size;
    private int modindex;
    private Object[] stack;


    public StackArray(int capacity) {

        this.stack = new Object[capacity];
        this.size = capacity;
        this.modindex = -1;
    }

    ;

    public int size() {

        return (modindex + 1);
    }


    @Override
    public T pop() {

        if (modindex == -1) {
            throw new EmptyStackException();
        }
        T element = (T) stack[modindex];
        stack[modindex] = null;
        modindex--;
        return element;
    }

    @Override
    public void push(T e) {

        if ((modindex + 1) == size) {
            extendArray();
        }

        modindex++;

        this.stack[modindex] = e;

        System.out.println(this.size);


    }

    @Override
    public boolean isEmpty() {


        return (modindex == -1);
    }

    @Override
    public T peek() {
        if (modindex == -1) {
            throw new EmptyStackException();
        }
        return (T) stack[(modindex)];
    }

    @Override
    public void clear() {

        for (int i = 0, j = this.stack.length; i < j; i++) {
            this.stack[i] = null;
        }

        size = 0;
    }

    @Override
    public int find(T e) {
        return 0;
    }

    /**
     * @Author binblink
     * @Description: 数组扩容，前期翻倍 超过50 按50增加
     * @Date 2018/3/12 21:17
     * @Param []
     * @Return void
     */
    private void extendArray() {

        Object[] newArray = null;
        if (size < 50) {
            size = size * 2;
            newArray = new Object[size];
        } else {
            size = size + 50;
            newArray = new Object[size];
        }

        System.arraycopy(stack, 0, newArray, 0, stack.length);

        this.stack = newArray;
    }


}
