public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void grow() {
        System.out.println(getName() + " is growing by eating and exercising.");
    }

    @Override 
    public void move() {
        System.out.println(getName() + " is running on four legs.");
    }
}