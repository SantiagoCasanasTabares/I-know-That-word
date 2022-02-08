package myProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class VentanaInicial extends JFrame {

    //private Header headerProject;
    private ImageIcon titulo;
    private JLabel imagentitulo;
    private FileManager fileManager;
    private JButton salir, nuevoJuego, continuarjuego, comoJugar;
    private Escucha escucha;
    //private JComboBox comboBox;
    //private VentanaDejuego ventanaDejuego = new VentanaDejuego();
    private VentanaInicial ventanaInicial=this;
    private Jugadores jugador;


    /**
     * Constructor of GUI class
     */
    public VentanaInicial(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("I know that word");
        //this.setSize(500,350);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Create Listener Object and Control Object
        escucha= new Escucha();
        fileManager = new FileManager();




        //color Jframe
        this.getContentPane().setBackground(new Color(192,255,240));
        //Set up JComponents

        //titulo
        titulo = new ImageIcon(getClass().getResource("/Resources/tittle.png"));
        imagentitulo = new JLabel(titulo);
        imagentitulo.setBorder(new EmptyBorder(0, 20, 20, 0));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        this.add(imagentitulo, constraints);


        //boton nuevo juego
        nuevoJuego = new JButton("Nuevo juego");
        nuevoJuego.addActionListener(escucha);
        nuevoJuego.setPreferredSize(new Dimension(110, 30));
        nuevoJuego.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nuevoJuego.setBorder(new EmptyBorder(100, 0, 100, 0));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        add(nuevoJuego, constraints);


        //boton continuar
        /*comboBox = new JComboBox<String>();
        comboBox.addItemListener(escucha);
        comboBox.setPreferredSize(new Dimension(110, 30));
        comboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //comboBox.setBorder(new EmptyBorder(100, 0, 100, 0));
        for (int i=0; i < fileManager.jugadoreslecturaFile().size(); i++) {
            comboBox.addItem(fileManager.jugadoreslecturaFile().get(i));
        }
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        add(comboBox, constraints);*/
        continuarjuego = new JButton("Continuar");
        continuarjuego.addActionListener(escucha);
        continuarjuego.setPreferredSize(new Dimension(110, 30));
        continuarjuego.setBorder(new EmptyBorder(100, 0, 100, 0));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        if (fileManager.jugadoreslecturaFile().isEmpty()){
            continuarjuego.setEnabled(false);
        }else{
            continuarjuego.setEnabled(true);
            continuarjuego.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        add(continuarjuego, constraints);


        //boton como jugar
        comoJugar = new JButton("Como jugar");
        comoJugar.addActionListener(escucha);
        comoJugar.setPreferredSize(new Dimension(110, 30));
        comoJugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        comoJugar.setBorder(new EmptyBorder(100, 0, 100, 0));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        add(comoJugar, constraints);



        //boton salir
        salir = new JButton("salir");
        salir.addActionListener(escucha);
        salir.setPreferredSize(new Dimension(110, 30));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setBorder(new EmptyBorder(100, 0, 100, 0));
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        add(salir, constraints);



    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            VentanaInicial miProjectGUI = new VentanaInicial();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener, ItemListener{




        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==nuevoJuego) {
                String name = JOptionPane.showInputDialog("Escribe tu nickname: ");
                if (name != null ) {
                    fileManager.escribirTexto(name);

                    VentanaDejuego ventanaDejuego = new VentanaDejuego();
                    ventanaDejuego.setVisible(true);
                    ventanaInicial.dispose();
                }else{
                    String confirmarNombre = JOptionPane.showInputDialog("Necesitas un nombre: ");
                    fileManager.escribirTexto(confirmarNombre);

                    VentanaDejuego ventanaDejuego = new VentanaDejuego();
                    ventanaDejuego.setVisible(true);
                    ventanaInicial.dispose();
                }
            }else if (e.getSource()==continuarjuego) {
                jugador = new Jugadores();

                String nombres = (String) JOptionPane.showInputDialog(null, "Selecciona tu nombre", "Iniciar",
                        JOptionPane.QUESTION_MESSAGE, null,
                        fileManager.jugadoreslecturaFile().toArray(), fileManager.jugadoreslecturaFile().toArray()[0]);



                VentanaDejuego ventanaDejuego = new VentanaDejuego();
                ventanaDejuego.setVisible(true);
                ventanaInicial.dispose();

            }else if (e.getSource()==comoJugar) {

            }else{
                System.exit(0);
            }

        }



        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }
}