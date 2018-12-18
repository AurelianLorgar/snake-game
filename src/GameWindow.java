import javax.swing.*;

class GameWindow extends JFrame {

    GameField field;

    GameWindow() {
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(340, 360);
        setLocation(550, 284);
        add(field = new GameField());
        setVisible(true);
        setResizable(false);
    }
}
