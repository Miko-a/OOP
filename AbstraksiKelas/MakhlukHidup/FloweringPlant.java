public class FloweringPlant extends Plant {
    public FloweringPlant(String name) {
        super(name);
    }

    @Override
    public void grow() {
        System.out.println(getName() + " is growing by producing flowers.");
    }
    
    @Override
    public void photosynthesize() {
        System.out.println(getName() + " is producing food through photosynthesize.");
    }
}