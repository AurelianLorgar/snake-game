import javax.swing.*;
import java.awt.*;

class HighScoreWindow extends JFrame {

    HighScoreWindow() {
        setTitle("Таблица рекордов");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(340, 360);
        setLocation(550, 284);
        add(new HighScoreField());
        setVisible(true);
        setResizable(false);
        setPreferredSize(new Dimension(340, 360));
    }
}
