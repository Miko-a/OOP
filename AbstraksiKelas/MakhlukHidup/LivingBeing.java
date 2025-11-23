public abstract class LivingBeing
{
    // instance variables - replace the example below with your own
    private String name;

    /**
     * Constructor for objects of class LivingBeing
     */
    public LivingBeing(String name)
    {
        // initialise instance variables
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void breathe() {
        System.out.println(name + " is breathing.");
    }

    // Abstract method
    public abstract void grow();
}