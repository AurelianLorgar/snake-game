import javax.swing.*;

public class TypeWindow extends JFrame {

    public TypeField typeField;

    TypeWindow() {
        setTitle("Сложность");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(240, 130);
        setLocation(550, 284);
        add(typeField = new TypeField());
        setVisible(true);
        setResizable(false);
    }
}
