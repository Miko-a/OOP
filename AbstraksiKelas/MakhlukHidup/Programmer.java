public class Programmer extends Human {
    public Programmer(String name) {
        super(name);
    }

    @Override
    public void grow() {
        System.out.println(getName() + " is learning new programming languages to grow intellectually.");
    }

    @Override
    public void speak() {
        System.out.println(getName() + " is explaining coding concepts.");
    }
}