import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

class SpeedField extends JPanel {

    private JButton ok = new JButton("Ok");
    private JPanel typePanel = new JPanel(new GridLayout(0, 1));
    private JRadioButton slowButton = new JRadioButton("Легко");
    private JRadioButton normalButton = new JRadioButton("Нормально");
    private JRadioButton fastButton = new JRadioButton("Сложно");

    int gameSpeed = 8;

    SpeedField() {
        add(typePanel, BorderLayout.LINE_START);
        add(ok);
        speedButtons();
    }

    private void speedButtons() {
        typePanel.add(slowButton);
        typePanel.add(normalButton);
        typePanel.add(fastButton);

        normalButton.setSelected(true);

        ButtonGroup speedGroup = new ButtonGroup();
        speedGroup.add(slowButton);
        speedGroup.add(normalButton);
        speedGroup.add(fastButton);

        ok.addActionListener(e -> {
            if (slowButton.isSelected()) {
                gameSpeed = 4;
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("settings\\speed.dat"))) {
                    oos.writeObject(this);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (normalButton.isSelected()) {
                gameSpeed = 8;
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("settings\\speed.dat"))) {
                    oos.writeObject(this);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (fastButton.isSelected()) {
                gameSpeed = 12;
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("settings\\speed.dat"))) {
                    oos.writeObject(this);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
       });
    }
}
