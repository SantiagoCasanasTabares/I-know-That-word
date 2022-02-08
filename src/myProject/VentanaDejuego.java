package myProject;

import javax.swing.*;
import java.awt.event.*;

public class VentanaDejuego extends JFrame {
    private ImageIcon imageIcon;
    private JLabel imagen, fondo;
    private JPanel palabra, si, no;
    private JButton salir;
    private Timer timer;
    private Escucha escucha;

    public VentanaDejuego() {
        initGUI();

        //Default JFrame configuration
        this.setTitle("I know that word");
        this.setSize(500,350);
        //this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
    }

    private class Escucha extends MouseAdapter implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {


        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }
    }

}
