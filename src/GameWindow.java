import javax.swing.*;

class GameWindow extends JFrame {

    GameWindow() {
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(340, 360);
        setLocation(550, 284);
        add(new GameField());
        setVisible(true);
        setResizable(false);
    }
}
