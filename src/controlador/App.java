package controlador;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vista.Ventana;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            e.getMessage();
        }
        new Ventana();
    }
}
