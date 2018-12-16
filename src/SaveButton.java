import javax.swing.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

class SaveButton {

    private int mouseX;
    private int mouseY;
    private int sneks;
    private int[] snekX;
    private int[] snekY;
    private int speed;
    private int type;
    private int count;
    private boolean up;
    private boolean down;
    private boolean right;
    private boolean left;
    private boolean isPause;
    private Timer timer;

    SaveButton()
    {
        saveSerialization();
        //JOptionPane.showMessageDialog(null, "Игра сохранена");
    }

    private GameField gameField = new GameField();

    private void gameField(int mouseX, int mouseY, int sneks, int[] snekX, int[] snekY, int speed, int type, int count,
                           boolean up, boolean down, boolean right, boolean left, boolean isPause) {
        gameField.mouseX = mouseX;
        gameField.mouseY = mouseY;
        gameField.sneks = sneks;
        gameField.snekX = snekX;
        gameField.snekY = snekY;
        gameField.speed = speed;
        gameField.type = type;
        gameField.count = count;
        gameField.up = up;
        gameField.down = down;
        gameField.right = right;
        gameField.left = left;
        gameField.isPause = isPause;
    }

    private void saveSerialization() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save\\save.dat"))) {
            GameField gameField = new GameField();
            gameField(mouseX, mouseY, sneks, snekX, snekY, speed, type, count, up, down, right, left, isPause);
            oos.writeObject(gameField);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
