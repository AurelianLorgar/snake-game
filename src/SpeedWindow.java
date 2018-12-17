import javax.swing.*;

public class SpeedWindow extends JFrame {

    public SpeedField speedField;

    SpeedWindow()  {
        setTitle("Скорость");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(240, 130);
        setLocation(550, 284);
        add(speedField = new SpeedField());
        setVisible(true);
        setResizable(false);
        speedField.getGameSpeed();
    }
}
