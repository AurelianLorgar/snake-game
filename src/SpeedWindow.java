import javax.swing.*;

class SpeedWindow extends JFrame {

    SpeedWindow()  {
        setTitle("Сложность");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(240, 130);
        setLocation(550, 284);
        add(new SpeedField());
        setVisible(true);
        setResizable(false);
    }
}
