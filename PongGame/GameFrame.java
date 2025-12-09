package PongGame;
import javax.swing.*;

/**
 * JFrame yang menampung komponen game
 * Mengatur properti window seperti ukuran, title, dan behavior
 */
public class GameFrame extends JFrame {
    /**
     * Constructor yang menginisialisasi frame game
     * - Menambahkan GamePanel
     * - Mengatur title, size, dan behavior window
     * - Menampilkan window di tengah layar
     */
    public GameFrame() {
        this.add(new GamePanel());
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
