import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MenuField extends JPanel {

    private static final long serialVersionUID = 2931112021148620900L;
    private JButton newGame = new JButton("Новая игра");
    private JButton scores = new JButton("Таблица рекордов");
    private JButton speed = new JButton("Сложность");
    private JButton type = new JButton("Режим");
    private JButton save = new JButton("Сохранить");
    private JButton load = new JButton("Загрузить");
    private JButton exit = new JButton("Выход");
    private JPanel typePanel = new JPanel(new GridLayout(0, 2));
    private GameWindow game;

    MenuField() {
        initialization();
        listeners();
    }

    private void initialization()
    {
        add(typePanel, BorderLayout.LINE_START);
        setLayout(new GridLayout(7, 1, 10, 10));
        add(newGame);
        add(scores);
        add(speed);
        add(type);
        add(save);
        add(load);
        add(exit);
    }

    private void gameWindow() {
        game = new GameWindow();
    }

    private void speedButtons() {
        new SpeedWindow().setVisible(true);
    }

    private void typeButtons() {
        new TypeWindow().setVisible(true);
    }

    private void recordButton() {
        new HighScoreWindow().setVisible(true);
    }

    private void saveButton() {
        try {
            game.field.saveSerialization();
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Игра не запущена",
                    "Error",  JOptionPane.WARNING_MESSAGE);
        }
    }

    private void loadButton() {
        game = new GameWindow();
        game.field.loadSerialization();
    }

    private void listeners() {
        ActionListener startGameListener = e -> gameWindow();
        newGame.addActionListener(startGameListener);

        //Таблица рекордов
        ActionListener scoresListener = e -> recordButton();
        scores.addActionListener(scoresListener);

        //Скорость
        ActionListener speedListener = e -> speedButtons();
        speed.addActionListener(speedListener);

        //Режим
        ActionListener typeListener = e -> typeButtons();
        type.addActionListener(typeListener);

        //Сохранение
        ActionListener saveListener = e -> saveButton();
        save.addActionListener(saveListener);

        //Загрузка
        ActionListener loadListener = e -> loadButton();
        load.addActionListener(loadListener);

        //Выход
        ActionListener exitListener = e -> System.exit(0);
        exit.addActionListener(exitListener);
    }
}
