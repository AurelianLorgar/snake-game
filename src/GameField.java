import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.Random;

public class GameField extends JPanel implements ActionListener, Serializable {

    private final int SIZE = 320;
    private final int SNEK_SIZE = 16;
    private final int ALL_SNEKS = 320;
    private final int SPEED = 1000;
    private Timer timer;
    private Image snek;
    private Image mouse;
    private int mouseX;
    private int mouseY;
    private int[] snekX = new int[ALL_SNEKS];
    private int[] snekY = new int[ALL_SNEKS];
    private int sneks;
    //private int gameType;
    //private int gameSpeed;
    private int speed;
    private int type;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;
    private boolean isPause;
    private int count = 0;
    private SpeedField gameSpeed;
    private TypeField gameType;

    GameField() {
        setBackground(Color.blue);
        loadImages();
        setTimer();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }

    private void setTimer() {
        System.out.println("Timer" + speed);
        timer = new Timer(SPEED / speed, this);
        timer.start();
    }

    private void initGame() {
        speed = gameSpeed.getGameSpeed();
       // gameType = new TypeField(gameType).getGameType();
       // gameSpeed = new SpeedField(gameSpeed).getGameSpeed();
        isPause = false;

        //System.out.println(gameType); //чисто для проверки
        sneks = 3;
        count = 0;
        for (int i = 0; i < sneks; i++) {
            snekX[i] = 48 - i * SNEK_SIZE;
            snekY[i] = 48;
        }

        createMouse();
    }

    private void createMouse() {
        mouseX = new Random().nextInt(20) * SNEK_SIZE;
        mouseY = new Random().nextInt(20) * SNEK_SIZE;

        for (int i = 0; i < sneks; i++) {
            if ((mouseX == snekX[i]) && (mouseY) == snekY[i]) {
                createMouse();
            }
        }
    }

    private void loadImages() {
        ImageIcon mi = new ImageIcon("mouse.png");
        mouse = mi.getImage();
        ImageIcon si = new ImageIcon("snek.png");
        snek = si.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (inGame) {
            g.drawImage(mouse, mouseX, mouseY, this);
            for (int i = 0; i < sneks; i++) {
                g.drawImage(snek, snekX[i], snekY[i], this);
            }
        } else {
            String gameOver = "Игра окончена";
            String count_str = ("Счет: " +  String.valueOf(count));
            g.setColor(Color.black);
            g.drawString(gameOver, 125, SIZE / 2);
            g.drawString(count_str, 125, (SIZE + 40) / 2);
        }
    }

    private void move() {
        for (int i = sneks; i > 0; i--) {
            snekX[i] = snekX[i - 1];
            snekY[i] = snekY[i - 1];
        }
        if (left) {
            snekX[0] -= SNEK_SIZE;
        }
        if (right) {
            snekX[0] += SNEK_SIZE;
        }
        if (up) {
            snekY[0] -= SNEK_SIZE;
        }
        if (down) {
            snekY[0] += SNEK_SIZE;
        }
    }

    private void checkMouse() {
        if (snekX[0] == mouseX && snekY[0] == mouseY) {
            sneks++;
            count++;
            createMouse();
        }
    }

    // FIXME: 15.12.2018 не работает бесконечный режим
    private void checkCollisions() {
        type = gameType.getGameType();
        for (int i = sneks; i > 0; i--) {
            if (snekX[0] == snekX[i] && snekY[0] == snekY[i]) {
                inGame = false;
            }
        }
        if (type == 0) {
            if (snekX[0] > SIZE) {
                inGame = false;
            }
            if (snekX[0] < 0) {
                inGame = false;
            }
            if (snekY[0] > SIZE) {
                inGame = false;
            }
            if (snekY[0] < 0) {
                inGame = false;
            }
        } else if (type == 1) {
            if (snekX[0] > SIZE) {
                snekX[0] = 0;
            }
            if (snekX[0] < 0) {
                snekX[0] = SIZE;
            }
            if (snekY[0] > SIZE) {
                snekY[0] = 0;
            }
            if (snekY[0] < 0) {
                snekY[0] = SIZE;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkMouse();
            move();
            checkCollisions();
        }

        repaint();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            // FIXME: 08.12.2018 При быстром нажатии змея жрет себя
            if (key == KeyEvent.VK_LEFT && !right) {
                left = true;
                up = false;
                down = false;
            }

            if (key == KeyEvent.VK_RIGHT && !left) {
                right = true;
                up = false;
                down = false;
            }

            if (key == KeyEvent.VK_UP && !down) {
                right = false;
                up = true;
                left = false;
            }

            if (key == KeyEvent.VK_DOWN && !up) {
                right = false;
                down = true;
                left = false;
            }

            if ((inGame) && (key == KeyEvent.VK_SPACE) && (!isPause)) {
                timer.stop();
                isPause = true;
            } else {
                timer.start();
                isPause = false;
            }

            if ((!inGame) && (key == KeyEvent.VK_SPACE)) {
                inGame = true;
                right = true;
                left = false;
                up = false;
                down = false;
                initGame();
            }
        }
    }
}

