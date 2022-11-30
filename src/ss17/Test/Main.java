package ss17.Test;

public class Main {
    public static void main(String[] args) {
        Animals a = new Dog();
        Animals b = new Cat();
        a.doSth();
        String d = "Dog";
        String c = a.getClass().getSimpleName();
        System.out.println(d.equals(c));

    }
}
