package PongGame;

import java.awt.*;
import java.awt.event.*;

/**
 * Class yang merepresentasikan paddle pemain
 * 
 * Fitur:
 * - Dapat digerakkan vertikal dengan keyboard
 * - Support kontrol W/S untuk player 1
 * - Support kontrol UP/DOWN untuk player 2
 */
public class Paddle {
    /** Posisi X paddle (horizontal) */
    int x;
    
    /** Posisi Y paddle (vertical) */
    int y;
    
    /** Kecepatan vertikal paddle saat ini */
    int yVelocity = 0;
    
    /** Kecepatan maksimal paddle */
    int speed = 5;
    
    /** Lebar paddle dalam pixel */
    int width = 20;
    
    /** Tinggi paddle dalam pixel */
    int height = 100;

    /**
     * Constructor untuk membuat paddle di posisi tertentu
     * 
     * @param x Posisi horizontal paddle
     * @param y Posisi vertical paddle
     */
    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Menggambar paddle di layar
     * 
     * @param g Graphics context untuk drawing
     */
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    /**
     * Update posisi paddle berdasarkan velocity
     * Dipanggil setiap frame oleh GamePanel
     */
    public void move() {
        y += yVelocity;
    }
    
    /**
     * Handle input saat tombol ditekan
     * 
     * Kontrol:
     * - W/UP: Gerak ke atas
     * - S/DOWN: Gerak ke bawah
     * 
     * @param e KeyEvent yang berisi informasi tombol
     */
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W: yVelocity = -speed; break;
            case KeyEvent.VK_S: yVelocity = speed; break;
            case KeyEvent.VK_UP: yVelocity = -speed; break;
            case KeyEvent.VK_DOWN: yVelocity = speed; break;
        }
    }

    /**
     * Handle input saat tombol dilepas
     * Menghentikan gerakan paddle
     * 
     * @param e KeyEvent yang berisi informasi tombol
     */
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_S:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                yVelocity = 0;
            break;
        }
    }
}