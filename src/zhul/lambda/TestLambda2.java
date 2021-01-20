package zhul.lambda;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class TestLambda2 {
    public static void main(String[] args) {


/*        ILove love = new ILove() {
            @Override
            public void love(int a) {
                System.out.println("i love you ------>" + a);
            }
        };

        love.love(2);*/

        //1.lambda表示简化
        ILove love = (int a) -> {
            System.out.println("i love you ---->" + a);
        };

        //简化1.参数类型
        love = (a) -> {
            System.out.println("i love you ---->" + a);
        };

        //简化2.简化括号
        love = a -> {
            System.out.println("i love you ---->" + a);
        };

        //简化3.简化花括号 (代码只有一行)
        love = a -> System.out.println("i love you ---->" + a);;

        //总结：
            //lambda表达式只能有一行代码的情况下，才能简化为一行
            //如果有多行，需要用花括号代码块包裹
            //多个参数也可以去掉参数类型，要去掉就去掉

        love.love(521);
    }
}

interface ILove {
    void love(int a);
}

