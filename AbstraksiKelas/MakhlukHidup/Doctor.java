public class Doctor extends Human {
    public Doctor(String name) {
        super(name);
    }

    @Override
    public void grow() {
        System.out.println(getName() + " is gaining experience through practice.");
    }

    @Override 
    public void speak() {
        System.out.println(getName() + " is consulting with patients.");
    }
}