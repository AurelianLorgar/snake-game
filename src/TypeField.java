import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TypeField extends JPanel {

    private JButton ok = new JButton("Ok");
    private JPanel typePanel = new JPanel(new GridLayout(0, 1));
    private JRadioButton standardButton = new JRadioButton("Стандартный режим");
    private JRadioButton infiniteButton = new JRadioButton("Бесконечное поле");

    int gameType;

    TypeField() {
        add(typePanel, BorderLayout.LINE_START);
        add(ok);
        diffButtons();
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
                gameType = 0;
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("settings\\type.dat"))) {
                    oos.writeObject(this);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (infiniteButton.isSelected()) {
                gameType = 1;
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("settings\\type.dat"))) {
                    oos.writeObject(this);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
