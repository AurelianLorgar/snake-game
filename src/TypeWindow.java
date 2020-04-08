import javax.swing.*;

class TypeWindow extends JFrame {


    TypeWindow() {
        setTitle("Режим");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(240, 130);
        setLocation(550, 284);
        add(new TypeField());
        setVisible(true);
        setResizable(false);
    }
}
