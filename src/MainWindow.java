import javax.swing.*;

public class MainWindow extends JFrame {

    private MainWindow() {
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(340, 360);
        setLocation(550, 284);
        add(new MenuField());
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
