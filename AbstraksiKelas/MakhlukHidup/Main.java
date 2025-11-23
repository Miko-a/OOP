public class Main {
    public static void main(String[] args) {
        // Humans
        Human programmer = new Programmer("Alice");
        Human doctor = new Doctor ("Bob");

        programmer.breathe();
        programmer.grow();
        programmer.speak();

        doctor.breathe();
        doctor.grow();
        doctor.speak();

        // Animal
        Animal dog = new Dog("Buddy");
        Animal bird = new Bird("Tweety");
        
        dog.breathe();
        dog.grow();
        dog.move();

        bird.breathe();
        bird.grow();
        bird.move();

        // Plant
        Plant rose = new FloweringPlant("Rose");
        Plant fern = new NonFloweringPlant("Fern");

        rose.breathe();
        rose.grow();
        rose.photosynthesize();

        fern.breathe();
        fern.grow();
        fern.photosynthesize();
    }
}