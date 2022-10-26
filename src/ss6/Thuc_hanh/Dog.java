package ss6.Thuc_hanh;

public class Dog extends  Pet{

    public Dog(String location, int name, int age) {
        super(location, name, age);
    }
    @Override
    public void eat() {
        System.out.println("Eat meat");
    }
    @Override
    public void kind(){
        System.out.println("Cho canh");
    }
}
