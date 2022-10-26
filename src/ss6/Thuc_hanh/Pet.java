package ss6.Thuc_hanh;

public class Pet extends  Animal{
    public int age;

    public Pet(String location, int name, int age) {
        super(location, name);
        this.age = age;
    }

    @Override
    public void eat(){
        System.out.println("Eat food");
        super.eat();
    }
    public void kind(){
        System.out.println("alaska");
    }
}
