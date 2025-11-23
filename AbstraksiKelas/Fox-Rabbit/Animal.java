import java.util.List;
import java.util.Random;

public abstract class Animal {
    private int age;
    private boolean alive;
    private Field field;
    private Location location;
    protected static final Random rand = new Random();


    public Animal(boolean randomAge, Field field, Location location) {
        if (randomAge) {
            this.age = rand.nextInt(getMaxAge());
        } else 
            this.age = 0;

        this.alive = true;
        this.field = field;
        
        setLocation(location);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setDead() {
        alive = false;
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    public void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setDead();
        }
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }

        location = newLocation;
        field.place(this, newLocation);
    }

    public abstract void act(List<Animal> newAnimals);
    protected abstract int getMaxAge();

    protected Field getField() {
        return field;
    }
}