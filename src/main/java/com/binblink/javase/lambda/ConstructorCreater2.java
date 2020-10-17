package com.binblink.javase.lambda;

/**
 * @Author binblink
 * @Create Time　2019/11/1 22:13
 * @Description: 默认方法  覆盖Object方法 静态方法不影响  函数式接口
 *
 * 函数式接口只有一个规定就是 有且仅有一个抽象方法
 */
public interface ConstructorCreater2 {

    String getString(String param);

     default String test() {
        return "";
    }


    public boolean equals(Object val1);
}
