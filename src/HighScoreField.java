import javax.swing.*;
import java.io.*;

class HighScoreField extends JPanel implements Serializable {
    private static final long serialVersionUID = 2931112021148620900L;
    private JLabel standardSlow = new JLabel();
    private JLabel standardNormal = new JLabel();
    private JLabel standardFast = new JLabel();
    private JLabel infiniteSlow = new JLabel();
    private JLabel infiniteNormal = new JLabel();
    private JLabel infiniteFast = new JLabel();

    HighScoreField() {
        initialization();
        countOutput();
    }

    private void initialization() {
        add(standardSlow);
        add(standardNormal);
        add(standardFast);
        add(infiniteSlow);
        add(infiniteNormal);
        add(infiniteFast);
    }

    private void countOutput() {
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("counts\\standard\\count_standard_slow.dat"))) {
            GameField gameField = (GameField)ois.readObject();
            standardSlow.setText("Стандартный режим, медленно: " + String.valueOf(gameField.count));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("counts\\standard\\count_standard_normal.dat"))) {
            GameField gameField = (GameField)ois.readObject();
            standardNormal.setText("Стандартный режим, нормально: " + String.valueOf(gameField.count));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("counts\\standard\\count_standard_fast.dat"))) {
            GameField gameField = (GameField)ois.readObject();
            standardFast.setText("Стандартный режим, быстро: " + String.valueOf(gameField.count));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("counts\\infinite\\count_infinite_slow.dat"))) {
            GameField gameField = (GameField)ois.readObject();
            infiniteSlow.setText("Бесконечное поле, медленно: " + String.valueOf(gameField.count));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("counts\\infinite\\count_infinite_normal.dat"))) {
            GameField gameField = (GameField)ois.readObject();
            infiniteNormal.setText("Бесконечное поле, нормально: " + String.valueOf(gameField.count));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("counts\\infinite\\count_infinite_fast.dat"))) {
            GameField gameField = (GameField)ois.readObject();
            infiniteFast.setText("Бесконечное поле, быстро: " + String.valueOf(gameField.count));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
