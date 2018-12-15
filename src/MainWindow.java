import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow() {

        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(340, 360);
        setLocation(400, 400);
        add(new MenuField());
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
