import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MenuField extends JPanel {

    private JButton newGame = new JButton("Новая игра");
    private JButton scores = new JButton("Доска почёта");
    private JButton difficulty = new JButton("Сложность");
    private JButton save = new JButton("Сохранить");
    private JButton load = new JButton("Загрузить");
    private JButton exit = new JButton("Выход");
    private JPanel typePanel = new JPanel(new GridLayout(0, 1));

    private int chooseType;
    int getChooseType() {
        return chooseType;
    }

    MenuField() {
        initialization();
        radioButtons();
        listeners();
    }

    private void initialization()
    {
        setLayout(new GridLayout(7, 1, 10, 10));
        add(newGame);
        add(scores);
        add(difficulty);
        add(typePanel, BorderLayout.LINE_START);
        add(save);
        add(load);
        add(exit);

    }

    private void radioButtons() {
        JRadioButton standardButton = new JRadioButton("Стандартный режим");
        typePanel.add(standardButton);
        JRadioButton infiniteButton = new JRadioButton("Бесконечное поле");
        typePanel.add(infiniteButton);

        if (standardButton.isSelected()) {
            chooseType = 0;
            infiniteButton.setSelected(false);
        } else if (infiniteButton.isSelected()) {
            chooseType = 1;
            standardButton.setSelected(false);
        }
    }

    private void listeners() {
        //Начало игры
        ActionListener startGameListener = e -> new GameWindow();
        newGame.addActionListener(startGameListener);

        //Таблица рекордов
        ActionListener scoresListener = e -> {

        };
        scores.addActionListener(scoresListener);


        //Скорость
        ActionListener difficultyListener = e -> {

        };
        difficulty.addActionListener(difficultyListener);


        //Режим игры
        /*ActionListener typeListener = e -> {

        };
        type.addActionListener(typeListener);*/

        //Сохранение
        ActionListener saveListener = e -> {

        };
        save.addActionListener(saveListener);


        //Загрузка
        ActionListener loadListener = e -> {

        };
        load.addActionListener(loadListener);


        //Выход
        ActionListener exitListener = e -> System.exit(0);
        exit.addActionListener(exitListener);
    }
}