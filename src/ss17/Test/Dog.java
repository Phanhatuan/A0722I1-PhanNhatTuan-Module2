package ss17.Test;

import java.sql.SQLOutput;

public class Dog implements Cat {
    @Override
    public void doSth1() {

    }

    public void keu() {
        System.out.println("gau gau");
    }
    public void catEat(){

    }
    public static void main(String[] args) {
        Animals a = new Dog();
        a.doSth1();

    }
}
