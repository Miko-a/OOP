public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void grow() {
        System.out.println(getName() + " is growing by eatings seeds.");
    }

    @Override 
    public void move() {
        System.out.println(getName() + " is flying in the sky.");
    }
}