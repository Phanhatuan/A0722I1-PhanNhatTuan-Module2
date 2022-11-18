package ss15.Bai_tap;

import java.util.Scanner;

public class UseIllegalTriangleException {
    public UseIllegalTriangleException(double side1, double side2, double side3) throws IllegalTriangleException{
        if(side1+side2<side3 || side1+side3<side2 || side2+side3<side1)
            throw new IllegalTriangleException("Triangle violet the rule.");
        else
            System.out.println("Triangle follows the rule.");
    }
    public static void main(String args[]){
        try{
            UseIllegalTriangleException obj = new UseIllegalTriangleException(0,1,3);
        }catch(Exception m){System.out.println("Exception occured: "+m);
        }
    }
}
class IllegalTriangleException extends Exception{
    IllegalTriangleException(String s){
        super(s);
    }
}
