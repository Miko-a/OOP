package PongGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Panel utama game yang mengatur semua logic permainan
 * Implements Runnable untuk game loop di thread terpisah
 * 
 * Fitur:
 * - Game loop 60 FPS
 * - Collision detection
 * - Score tracking
 * - Input handling untuk 2 pemain
 */
public class GamePanel extends JPanel implements Runnable {
    /** Lebar area permainan dalam pixel */
    static final int GAME_WIDTH = 800;
    
    /** Tinggi area permainan dalam pixel */
    static final int GAME_HEIGHT = 600;
    
    /** Thread untuk menjalankan game loop */
    Thread gameThread;
    
    /** Buffer image untuk double buffering (tidak digunakan saat ini) */
    Image image;
    
    /** Graphics context untuk drawing (tidak digunakan saat ini) */
    Graphics graphics;
    
    /** Paddle pemain 1 (kiri) */
    Paddle player1;
    
    /** Paddle pemain 2 (kanan) */
    Paddle player2;
    
    /** Bola permainan */
    Ball ball;
    
    /** Skor pemain 1 */
    int player1Score = 0;
    
    /** Skor pemain 2 */
    int player2Score = 0;
    
    /** Status game (true = berjalan, false = berhenti) */
    boolean gameRunning = true;

    /**
     * Constructor yang menginisialisasi semua komponen game
     * - Membuat paddle untuk kedua pemain
     * - Membuat bola di tengah layar
     * - Mengatur panel properties
     * - Memulai game thread
     */
    public GamePanel() {
        player1 = new Paddle(0, (GAME_HEIGHT/2)-50);
        player2 = new Paddle(GAME_WIDTH-20, (GAME_HEIGHT/2)-50);
        ball = new Ball((GAME_WIDTH/2)-15, (GAME_HEIGHT/2)-15);
        
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new AL());

        gameThread = new Thread(this);
        gameThread.start();
    }
    
    /**
     * Override method untuk custom painting
     * Dipanggil otomatis oleh Swing saat panel perlu dirender ulang
     * 
     * @param g Graphics context untuk drawing
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    /**
     * Menggambar semua komponen game
     * - Paddle pemain 1 & 2
     * - Bola
     * - Skor kedua pemain
     * 
     * @param g Graphics context untuk drawing
     */
    public void draw(Graphics g) {
        player1.draw(g);
        player2.draw(g);
        ball.draw(g);
        
        // Draw score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("P1: " + player1Score, 50, 50);
        g.drawString("P2: " + player2Score, GAME_WIDTH - 150, 50);
    }

    /**
     * Update posisi semua objek game
     * - Menggerakkan paddle dan bola
     * - Melakukan boundary checking
     * - Deteksi collision
     * - Update skor jika bola keluar layar
     */
    public void move() {
        if (gameRunning) {
            player1.move();
            player2.move();
            ball.move();
            
            // Boundary check untuk paddle
            if (player1.y < 0) player1.y = 0;
            if (player1.y + player1.height > GAME_HEIGHT) player1.y = GAME_HEIGHT - player1.height;
            if (player2.y < 0) player2.y = 0;
            if (player2.y + player2.height > GAME_HEIGHT) player2.y = GAME_HEIGHT - player2.height;
            
            // Collision detection
            checkCollision();
            
            // Reset ball jika keluar layar
            if (ball.x < 0) {
                player2Score++;
                resetBall();
            }
            if (ball.x > GAME_WIDTH) {
                player1Score++;
                resetBall();
            }
        }
    }
    
    /**
     * Deteksi tabrakan antara bola dan paddle
     * Membalik arah horizontal bola saat menabrak paddle
     * 
     * Algoritma:
     * - Cek apakah bola overlap dengan paddle
     * - Jika ya, balik arah xVelocity bola
     */
    public void checkCollision() {
        // Player 1 collision
        if (ball.x <= player1.x + player1.width && 
            ball.y + ball.diameter >= player1.y && 
            ball.y <= player1.y + player1.height) {
            ball.xVelocity = Math.abs(ball.xVelocity);
        }
        
        // Player 2 collision
        if (ball.x + ball.diameter >= player2.x && 
            ball.y + ball.diameter >= player2.y && 
            ball.y <= player2.y + player2.height) {
            ball.xVelocity = -Math.abs(ball.xVelocity);
        }
    }
    
    /**
     * Reset posisi bola ke tengah layar
     * Dipanggil saat salah satu pemain mencetak skor
     * Arah horizontal bola di-randomize
     */
    public void resetBall() {
        ball.x = (GAME_WIDTH/2) - 15;
        ball.y = (GAME_HEIGHT/2) - 15;
        ball.xVelocity = (Math.random() > 0.5) ? 3 : -3;
        ball.yVelocity = 3;
    }

    /**
     * Game loop utama yang berjalan di thread terpisah
     * Menggunakan delta time untuk maintain 60 FPS
     * 
     * Loop ini akan:
     * 1. Hitung delta time
     * 2. Update game state
     * 3. Render ulang panel
     */
    public void run() {
        // game loop 60 fps
        double nsPerFrame = 1000000000 / 60.0;
        long lastTime = System.nanoTime();
        double delta = 0;
        while (gameRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerFrame;
            lastTime = now;
            while (delta >= 1) {
                move();
                repaint();
                delta--;
            }
        }
    }
    
    /**
     * Inner class untuk handle keyboard input
     * Meneruskan event keyboard ke kedua paddle
     */
    public class AL extends KeyAdapter {
        /**
         * Handle key press event
         * 
         * @param e KeyEvent yang berisi informasi tombol yang ditekan
         */
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
            player2.keyPressed(e);
        }

        /**
         * Handle key release event
         * 
         * @param e KeyEvent yang berisi informasi tombol yang dilepas
         */
        public void keyReleased(KeyEvent e) {
            player1.keyReleased(e);
            player2.keyReleased(e);
        }
    }
}