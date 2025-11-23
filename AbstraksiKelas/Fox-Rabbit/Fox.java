import java.util.List;

public class Fox extends Animal {
    private static final int MAX_AGE = 10;
    private static final int RABBIT_FOOD_VALUE = 5;
    private int foodLevel;

    public Fox(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);
        this.foodLevel = RABBIT_FOOD_VALUE;
    }

    @Override
    public void act(List<Animal> newAnimals) {
        if (!isAlive()) return;

        incrementAge();
        if (!isAlive()) return; // died of old age
        
        incrementHunger();
        if (!isAlive()) return; // died of hunger
        Location newLocation = findFood();
        if (newLocation == null) {
            newLocation = getField().freeAdjacentLocation(getLocation());
        }
        if (newLocation != null) {
            setLocation(newLocation);
        } else {
            setDead();
        }
    }

    private Location findFood() {
        List<Location> adjacent = getField().adjacentLocations(getLocation());
        for(Location loc : adjacent) {
            Object animal = getField().getObjectAt(loc);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                rabbit.setDead();
                // restore hunger after eating
                foodLevel = RABBIT_FOOD_VALUE;
                return loc;
            }
        }
        return null;
    }

    private void incrementHunger() {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }

    @Override
    protected int getMaxAge() {
        return MAX_AGE;
    }

}