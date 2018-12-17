import javax.swing.*;
import java.awt.*;

public class TypeField extends JPanel {

    private JButton ok = new JButton("Ok");
    private JPanel typePanel = new JPanel(new GridLayout(0, 1));
    private JRadioButton standardButton = new JRadioButton("Стандартный режим");
    private JRadioButton infiniteButton = new JRadioButton("Бесконечное поле");

    private int gameType;

    TypeField() {
        add(typePanel, BorderLayout.LINE_START);
        add(ok);
        diffButtons();
    }

    int getGameType() {
        return gameType;
    }

    private void setGameType(int gameType) {
        this.gameType = gameType;
    }

    private void diffButtons() {
        typePanel.add(standardButton);
        typePanel.add(infiniteButton);

        standardButton.setSelected(true);

        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(standardButton);
        typeGroup.add(infiniteButton);

        ok.addActionListener(e -> {
            if (standardButton.isSelected()) {
                setGameType(0);
            } else if (infiniteButton.isSelected()) {
                setGameType(1);
            }
        });

    }
}
