import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow() {
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(340, 360);
        setLocation(400, 400);
        add(new GameField());
        setVisible(true);
        setResizable(false);
    }
}
