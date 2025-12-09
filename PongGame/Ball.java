package PongGame;

import java.awt.*;

/**
 * Class yang merepresentasikan bola dalam permainan
 * 
 * Fitur:
 * - Bergerak dengan kecepatan konstan
 * - Memantul saat menabrak batas atas/bawah
 * - Velocity dapat diubah saat collision dengan paddle
 */
public class Ball {
    /** Posisi X bola (horizontal) */
    int x;
    
    /** Posisi Y bola (vertical) */
    int y;
    
    /** Kecepatan horizontal bola (+ = kanan, - = kiri) */
    int xVelocity = 3;
    
    /** Kecepatan vertical bola (+ = bawah, - = atas) */
    int yVelocity = 3;
    
    /** Diameter bola dalam pixel */
    int diameter = 30;

    /**
     * Constructor untuk membuat bola di posisi tertentu
     * 
     * @param x Posisi horizontal awal bola
     * @param y Posisi vertical awal bola
     */
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Menggambar bola di layar sebagai oval putih
     * 
     * @param g Graphics context untuk drawing
     */
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter);
    }

    /**
     * Update posisi bola berdasarkan velocity
     * Dan handle pantulan dengan batas atas/bawah layar
     * 
     * Dipanggil setiap frame oleh GamePanel
     */
    public void move() {
        x += xVelocity;
        y += yVelocity;
        
        // pantulan atas/bawah
        if (y <= 0 || y >= GamePanel.GAME_HEIGHT - diameter)
            yVelocity = -yVelocity;
    }
}