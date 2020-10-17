package com.binblink.javase.lambda;


import org.junit.jupiter.api.Test;

/**
 * @Author binblink
 * @Create Time　2019/10/29 22:31
 * @Description:
 */
public class LambdaTest {

    //lambda语法形式为 () -> {}，其中 () 用来描述参数列表，{} 用来描述方法体，-> 为 lambda运算符 ，读作(goes to)。
    @Test
    public void lambdaTest(){
        NotReturningNotParam notReturningNotParam = ()->{
            System.out.println("lambda expression no returning no param");
        };
        notReturningNotParam.method();
    }

    @Test
    public void lambdaTest1(){
        NotReturningMultiParam notReturningMultiParam = (int a ,int b)->{
            System.out.println("lambda expression no returning no param" + a+ b);

        };
        notReturningMultiParam.method(0 ,-1 );
    }

    @Test
    public void lamdaTest2(){
        NotReturningOneParam notReturningOneParam = (int a)->{

            System.out.println("lambda expression no returning One param:"+ a);
        };

        notReturningOneParam.method(66666);
    }

    @Test
    public void lambdaTest3(){
        ReturningNotParam returningNotParam = ()->{
            System.out.println("lamda expression returning");

            return 6;
        };

        System.out.println("get returning :" + returningNotParam.method());
    }

    @Test
    public void lambdaTest4(){
        ReturningOneParam returningOneParam = (int a)->{
            System.out.println("lamda expression returning one param" + a);
            return a;
        };
        System.out.println("get returning :" + returningOneParam.method(11));
    }

    @Test
    public void lambdaTest5(){
        ReturningParam returningParam = (int a,int b)->{
            System.out.println("lamda expression returning  param");
            return a + b;
        };
        System.out.println("get returning :" + returningParam.method(55,66));
    }


    //Lambda 语法简化 观察一下代码的简化

    @Test
    public void lambdaSimplify1(){
        //1.简化参数类型，可以不写参数类型，但是必须所有参数都不写
        NotReturningMultiParam notReturningMultiParam = (a,b)->{
            System.out.println("para1:"+a+"   para2:"+b);
        };
        notReturningMultiParam.method(1,34);
    }

    @Test
    public void lambdaSimplify2(){
        //2.简化参数小括号，如果只有一个参数则可以省略参数小括号
        NotReturningOneParam notReturningOneParam = a->{
            System.out.println("para1:"+a );
        };
        notReturningOneParam.method(4353453);
    }

    @Test
    public void lambdaSimplify3(){
        //简化方法体大括号，如果方法只有一条语句，则可以胜率方法体大括号
        NotReturningNotParam notReturningNotParam = ()-> System.out.println("lambdaSimplify3");

        notReturningNotParam.method();
    }

    @Test
    public void lambdaSimplify4(){
        //4.如果方法体只有一条语句，并且是 return 语句，则可以省略方法体大括号 和 return
        ReturningParam returningParam = (a,b) -> a+b;

        System.out.println(returningParam.method(32,3));
    }

}
