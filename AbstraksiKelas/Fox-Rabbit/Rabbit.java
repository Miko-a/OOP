import java.util.List;

public class Rabbit extends Animal {
    private static final int MAX_AGE = 5;

    public Rabbit(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);
    }

    @Override
    public void act(List<Animal> newAnimals) {
        if (!isAlive()) return;
        
        incrementAge();
        if (!isAlive()) return; // died of old age
        
        Location newLocation = getField().freeAdjacentLocation(getLocation());
        if (newLocation != null) {
            setLocation(newLocation);
        } else {
            setDead();
        }
    }

    @Override
    protected int getMaxAge() {
        return MAX_AGE;
    }
}