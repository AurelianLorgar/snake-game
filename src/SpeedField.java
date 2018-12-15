import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class SpeedField extends JPanel {

    private JButton ok = new JButton("Ok");
    private JPanel typePanel = new JPanel(new GridLayout(0, 1));
    private JRadioButton slowButton = new JRadioButton("Легко");
    private JRadioButton normalButton = new JRadioButton("Нормально");
    private JRadioButton difficultButton = new JRadioButton("Сложно");

    private int gameSpeed;

    SpeedField() {
        add(typePanel, BorderLayout.LINE_START);
        add(ok);
        speedButtons();
    }

    private SpeedField(int gameSpeed) {
        this.gameSpeed = gameSpeed;
        SpeedField speedField = new SpeedField(gameSpeed);
    }

    int getGameSpeed() {
        return gameSpeed;
    }

    private void setGameSpeed(int gameSpeed){
        this.gameSpeed = gameSpeed;
    }

    private void speedButtons() {
        typePanel.add(slowButton);
        typePanel.add(normalButton);
        typePanel.add(difficultButton);

        normalButton.setSelected(true);

        ButtonGroup speedGroup = new ButtonGroup();
        speedGroup.add(slowButton);
        speedGroup.add(normalButton);
        speedGroup.add(difficultButton);

        ok.addActionListener(e -> {
            if (slowButton.isSelected()) {
                setGameSpeed(4);
            } else if (normalButton.isSelected()) {
                setGameSpeed(8);
            } else if (difficultButton.isSelected()) {
                setGameSpeed(12);
            }
       });

        ActionListener exitListener = e -> System.out.println(gameSpeed);
        ok.addActionListener(exitListener);
    }
}