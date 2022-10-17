package ss3.Thuc_hanh;

import java.util.ArrayList;
import java.util.List;

public class test {
    public int method1(){
        return 1;
    }
    public static void main(String[] args) {
        test a = new sub_test();
        a.method1();

        test b= new test();
        b.method1();

        sub_test c = new sub_test();
        c.method1();
        c.method2();
        c.method3();


        /*sub1_test e = (sub1_test) new test();
        e.method4();*/
    }
}


