import java.io.FileInputStream;
import java.io.ObjectInputStream;

class LoadButton {
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

    LoadButton() {
        loadSerialization();
        new GameWindow();
        GameField gameField = new GameField();
        gameField.gameField(mouseX, mouseY, sneks, snekX, snekY, speed, type, count, up, down, right, left, isPause);
    }

    private void loadSerialization() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save\\save.dat")))
        {
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
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    /*private void GameField() {
        new GameField();
    }*/
}
