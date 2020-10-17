package com.binblink.javase.lambda;

/**
 * @Author binblink
 * @Create Time　2019/10/29 21:58
 * @Description: @FunctionalInterface 函数式接口声明 即接口只声明一个抽象方法
 */
@FunctionalInterface
public interface NotReturningMultiParam {

    void method(int a, int b);
}

