import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Random;

public class GameField extends JPanel implements ActionListener, Serializable {

    private static final long serialVersionUID = 2931112021148620900L;
    private final transient int SIZE = 320;
    private final transient int SNEK_SIZE = 16;
    private final transient int ALL_SNEKS = 320;
    private transient Timer timer;
    private transient Image snek;
    private transient Image mouse;
    private int mouseX;
    private int mouseY;
    private int[] snekX = new int[ALL_SNEKS];
    private int[] snekY = new int[ALL_SNEKS];
    private int sneks;
    private int speed;
    private int type;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private transient boolean inGame = true;
    private boolean isPause;
    int count = 0;

    private GameField(int count) {
        this.count = count;
    }

    private void countSerialization() {
        int oldCount = 0;

        if (type == 0) {
            if (speed == 4) {

                try (ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("counts\\standard\\count_standard_slow.dat"))) {
                    GameField gameField = (GameField) ois.readObject();
                    oldCount = gameField.count;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                if (count > oldCount) {
                    try (ObjectOutputStream oos = new ObjectOutputStream(
                            new FileOutputStream("counts\\standard\\count_standard_slow.dat"))) {
                        GameField gameField = new GameField(count);
                        oos.writeObject(gameField);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } else if (speed == 8) {

                try (ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("counts\\standard\\count_standard_normal.dat"))) {
                    GameField gameField = (GameField) ois.readObject();
                    oldCount = gameField.count;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                if (count > oldCount) {
                    try (ObjectOutputStream oos = new ObjectOutputStream(
                            new FileOutputStream("counts\\standard\\count_standard_normal.dat"))) {
                        GameField gameField = new GameField(count);
                        oos.writeObject(gameField);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if (speed == 12) {

                try (ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("counts\\standard\\count_standard_fast.dat"))) {
                    GameField gameField = (GameField) ois.readObject();
                    oldCount = gameField.count;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                if (count > oldCount) {
                    try (ObjectOutputStream oos = new ObjectOutputStream(
                            new FileOutputStream("counts\\standard\\count_standard_fast.dat"))) {
                        GameField gameField = new GameField(count);
                        oos.writeObject(gameField);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else if (type == 1) {
            if (speed == 4) {

                try (ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("counts\\infinite\\count_infinite_slow.dat"))) {
                    GameField gameField = (GameField) ois.readObject();
                    oldCount = gameField.count;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                if (count > oldCount) {
                    try (ObjectOutputStream oos = new ObjectOutputStream(
                            new FileOutputStream("counts\\infinite\\count_infinite_slow.dat"))) {
                        GameField gameField = new GameField(count);
                        oos.writeObject(gameField);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if (speed == 8) {

                try (ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("counts\\infinite\\count_infinite_normal.dat"))) {
                    GameField gameField = (GameField) ois.readObject();
                    oldCount = gameField.count;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                if (count > oldCount) {
                    try (ObjectOutputStream oos = new ObjectOutputStream(
                            new FileOutputStream("counts\\infinite\\count_infinite_normal.dat"))) {
                        GameField gameField = new GameField(count);
                        oos.writeObject(gameField);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if (speed == 12) {

                try (ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("counts\\infinite\\count_infinite_fast.dat"))) {
                    GameField gameField = (GameField) ois.readObject();
                    oldCount = gameField.count;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                if (count > oldCount) {
                    try (ObjectOutputStream oos = new ObjectOutputStream(
                            new FileOutputStream("counts\\infinite\\count_infinite_fast.dat"))) {
                        GameField gameField = new GameField(count);
                        oos.writeObject(gameField);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    private void gameField(int mouseX, int mouseY, int sneks, int[] snekX, int[] snekY, int speed, int type, int count,
                           boolean up, boolean down, boolean right, boolean left, boolean isPause) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.sneks = sneks;
        this.snekX = snekX;
        this.snekY = snekY;
        this.speed = speed;
        this.type = type;
        this.count = count;
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
        this.isPause = isPause;
    }

    void saveSerialization() {
        if (inGame) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save\\save.dat"))) {
                gameField(mouseX, mouseY, sneks, snekX, snekY, speed, type, count, up, down, right, left, isPause);
                oos.writeObject(this);
                JOptionPane.showMessageDialog(null, "Игра сохранена");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Игра не запущена", "Warning",
                    JOptionPane.WARNING_MESSAGE);
    }

    void loadSerialization() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save\\save.dat"))) {
            GameField gameField = (GameField) ois.readObject();
            mouseX = gameField.mouseX;
            mouseY = gameField.mouseY;
            sneks = gameField.sneks;
            snekX = gameField.snekX;
            snekY = gameField.snekY;
            speed = gameField.speed;
            type = gameField.type;
            count = gameField.count;
            up = gameField.up;
            down = gameField.down;
            right = gameField.right;
            left = gameField.left;
            isPause = gameField.isPause;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void speedDeserialization() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("settings\\speed.dat"))) {
            SpeedField speedField = (SpeedField) ois.readObject();
            speed = speedField.gameSpeed;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void typeDeserialization() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("settings\\type.dat"))) {
            TypeField typeField = (TypeField) ois.readObject();
            type = typeField.gameType;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    GameField() {
        setBackground(Color.blue);
        loadImages();
        speedDeserialization();
        typeDeserialization();
        setTimer();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }

    private void initGame() {
        isPause = false;
        sneks = 3;
        count = 0;
        for (int i = 0; i < sneks; i++) {
            snekX[i] = 48 - i * SNEK_SIZE;
            snekY[i] = 48;
        }

        createMouse();
    }

    private void setTimer() {
        int SPEED = 1000;
        timer = new Timer(SPEED / speed, this);
        timer.start();
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
        ImageIcon mi = new ImageIcon("image\\mouse.png");
        mouse = mi.getImage();
        ImageIcon si = new ImageIcon("image\\snek.png");
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
            countSerialization();
            String gameOver = "Игра окончена";
            String count_str = ("Счет: " + String.valueOf(count));
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

    private void checkCollisions() {
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
            move();
            checkMouse();
            checkCollisions();
        }

        repaint();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();

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
