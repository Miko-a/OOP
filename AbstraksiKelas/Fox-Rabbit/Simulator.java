import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;

public class Simulator {
    private Field field;
    private List<Animal> animals;
    private int step;  
    private SimulatorView view;
    private static final int DEFAULT_ROW = 30;  
    private static final int DEFAULT_COL = 30;

    
    public Simulator(int depth, int width) {
        if(width <= 0 || depth <= 0){
            System.out.println("The dimensions must be greater than zero."); 
            System.out.println( "Using default values."); 
            depth = DEFAULT_ROW;
            width = DEFAULT_COL;
        }

        animals = new ArrayList<Animal>();
        field = new Field(depth, width);

        view = new SimulatorView(depth, width, field);
        view.setSymbol(Rabbit.class, 'R');
        view.setSymbol(Fox.class, 'F');
                
        reset(); 
    }

    public void simulate(int steps){
        for(int i = 0; i < steps; i++){
            simulateOneStep();
        }
    }

    public void reset(){
        step = 0;
        animals.clear();
        field.clearAll();
        populate();
        view.show(step, field);
    }

    public void simulateOneStep(){
        step++;

        List<Animal> newAnimals = new ArrayList<>();

        // Iterasi aman dengan Iterator agar bisa remove saat berjalan
        for (Iterator<Animal> it = animals.iterator(); it.hasNext(); ) {
            Animal animal = it.next();
            animal.act(newAnimals);
            if (!animal.isAlive()) {
                it.remove();
            }
        }

        // Tambahkan hewan baru (jika nanti ada reproduksi)
        animals.addAll(newAnimals);

        // Tampilkan status grid
        view.show(step, field);
    }

    private void populate(){
        // Probabilitas populasi awal (sesuaikan jika perlu)
        final double FOX_CREATION_PROBABILITY = 0.20;
        final double RABBIT_CREATION_PROBABILITY = 0.30;

        // Asumsikan Field menyediakan ukuran melalui getter
        int rows = field.getRow();
        int cols = field.getCol();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Location loc = new Location(r, c);

                // Pastikan sel kosong sebelum menempatkan
                if (field.getObjectAt(loc) != null) continue;

                double roll = Animal.rand.nextDouble();

                if (roll <= FOX_CREATION_PROBABILITY) {
                    Fox fox = new Fox(true, field, loc);
                    animals.add(fox);
                    field.place(fox, loc);
                }
                // else-if memastikan hanya satu spesies per sel
                else if (roll <= FOX_CREATION_PROBABILITY + RABBIT_CREATION_PROBABILITY) {
                    Rabbit rabbit = new Rabbit(true, field, loc);
                    animals.add(rabbit);
                    field.place(rabbit, loc);
                }
            }
        }
    }   
}
