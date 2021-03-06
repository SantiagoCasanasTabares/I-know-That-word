package myProject;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * @autor Santiago Casañas Tabares 2025301 - Jesus Adrian Peña Güetio 2025513
 * santiago.casanas@correounivalle.edu.co - jesus.guetio@correounivalle.edu.co
 * @version v.1.0.0 date:18/02/2022
 */

public class VentanaDejuego extends JFrame {
    public static final String MENSAJE_AYUDA= "Se te presentará una secuencia de palabras, una detrás de otra"
            + "\ny tendrás que memorizar la mayor cantidad de estas posibles."
            + "\nTras la serie de palabras a memorizar, el juego te presentará"
            + "\nun listado con el doble de palabras y deberás marcar si esta "
            + "\no no en el listado inicial, debiendo acertar un determinado "
            + "\nnumero de palabras dependiendo el nivel.";


    private ImageIcon initOption, continueOption, yesOption, noOption;
    private JLabel iniciar, continuar, si, no;
    private JPanel palabraPanel, siPanel, noPanel, infoPanel;
    private JButton exit, nextLevel, ayuda;
    private Timer timer1, timer2;
    private JTextArea jugador, currentLevel;
    private Escucha escucha1, escucha2;
    private Jugadores jugadores;
    private Control control;
    String palabra = "";
    int i = 0;
    int j = 0;
    int nivel;
    String nombre;
    FileManager fileManager;

    /**
     * class constructor
     * @param level
     * @param namePlayer
     */
    public VentanaDejuego(int level, String namePlayer) {
        initGUI();
        this.nivel = level;
        this.nombre = namePlayer;
        this.setTitle("I know that word");
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        /**
         * Set up JFrame Container's Layout
         */
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        /**
         * set the color of the panel
         */
        this.getContentPane().setBackground(new Color(192,255,240));

        /**
         * Create Listener Object and Control Object
         */
        fileManager = new FileManager();
        jugadores = new Jugadores(nombre);
        escucha1 = new Escucha();
        escucha2 = new Escucha();
        timer1 = new Timer(5000, escucha1);
        timer2 = new Timer(7000, escucha1);
        control = new Control(nombre);
        jugadores.setLevel();
        control.setNivel();


        /**
         * set up components -------------------------------------------------------------------------------------------
         */

        /**
         * palabra Jpanel
         */
        palabraPanel = new JPanel();
        initOption = new ImageIcon(getClass().getResource("/Resources/iniciar.png"));
        iniciar = new JLabel(initOption);
        iniciar.addMouseListener(escucha2);
        iniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        palabraPanel.add(iniciar, BorderLayout.CENTER);
        palabraPanel.setPreferredSize(new Dimension(250, 130));
        TitledBorder titledBorderPalabra = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        palabraPanel.setBorder(titledBorderPalabra);
        titledBorderPalabra.setTitleColor(Color.black);
        palabraPanel.setOpaque(false);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        add(palabraPanel, constraints);

        /**
         * si Jpanel
         */
        siPanel = new JPanel();
        yesOption = new ImageIcon(getClass().getResource("/Resources/si.png"));
        si = new JLabel(yesOption);
        siPanel.add(si, BorderLayout.CENTER);
        siPanel.setPreferredSize(new Dimension(175, 100));
        TitledBorder titledBorderSi = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        siPanel.setBorder(titledBorderSi);
        titledBorderSi.setTitleColor(Color.black);
        siPanel.setOpaque(false);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        add(siPanel, constraints);

        /**
         * no Jpanel
         */
        noPanel = new JPanel();
        noOption = new ImageIcon(getClass().getResource("/Resources/no.png"));
        no = new JLabel(noOption);
        noPanel.add(no, BorderLayout.CENTER);
        noPanel.setPreferredSize(new Dimension(175, 100));
        TitledBorder titledBorderNo = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        noPanel.setBorder(titledBorderNo);
        titledBorderNo.setTitleColor(Color.black);
        noPanel.setOpaque(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        add(noPanel, constraints);

        /**
         * Buttons------------------------------------------------------------------------------------------------------
         */


        /**
         * exit button
         */
        exit = new JButton("Salir");
        exit.addActionListener(escucha1);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));


        /**
         * help button
         */
        ayuda = new JButton("Ayuda");
        ayuda.addActionListener(escucha1);
        ayuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //nextLevel
        nextLevel = new JButton("Siguiente nivel");
        nextLevel.addActionListener(escucha1);
        nextLevel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nextLevel.setEnabled(false);

        /**
         * JText Area --------------------------------------------------------------------------------------------------
         */

        /**
         * name player
         */
        jugador = new JTextArea();
        jugador.setPreferredSize(new Dimension(100, 20));
        jugador.setText("Player  id");
        jugador.setEditable(false);

        /**
         * users level
         */
        currentLevel = new JTextArea();
        currentLevel.setPreferredSize(new Dimension(100, 20));
        currentLevel.setText("Nivel actual");
        currentLevel.setEditable(false);

        /**
         * info Jpanel
         */
        infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(130, 230));
        infoPanel.add(jugador);
        infoPanel.add(currentLevel);
        infoPanel.add(nextLevel);
        infoPanel.add(ayuda);
        infoPanel.add(exit);
        TitledBorder titledBorderInfoPanel = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Info", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        infoPanel.setBorder(titledBorderInfoPanel);
        titledBorderInfoPanel.setTitleColor(Color.black);
        infoPanel.setOpaque(false);
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        add(infoPanel, constraints);


        /**
         * continue Option
         */
        continueOption = new ImageIcon(getClass().getResource("/Resources/continuar.png"));
        continuar = new JLabel(continueOption);

    }


    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha extends MouseAdapter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == timer1) {
                if (i < control.getWords().size()) {
                    iniciar.setIcon(null);
                    palabra = control.getWords().get(i);
                    iniciar.setText(palabra);
                    iniciar.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
                    i++;
                } else {
                    i = 0;
                    timer1.stop();

                    iniciar.setVisible(false);

                    continuar.setVisible(true);
                    continuar.addMouseListener(escucha2);
                    continuar.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    palabraPanel.remove(iniciar);
                    palabraPanel.repaint();
                    palabraPanel.revalidate();
                    palabraPanel.add(continuar, BorderLayout.CENTER);


                }

            } else if (e.getSource() == timer2) {

                si.setEnabled(true);
                no.setEnabled(true);

                if (i < control.getTotalWords().size()) {
                    palabra = control.getTotalWords().get(i);
                    continuar.setText(palabra);
                    continuar.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
                    i++;
                    j++;

                } else {
                    timer2.stop();
                    si.removeMouseListener(escucha2);
                    si.setCursor(null);
                    no.removeMouseListener(escucha2);

                    siPanel.repaint();
                    siPanel.revalidate();
                    noPanel.repaint();
                    noPanel.revalidate();

                    no.setCursor(null);
                    j=0;
                    i=0;


                    control.siguienteNivel(control.getPuntos());
                    if (control.isNextLevel()) {
                        JOptionPane.showMessageDialog(null, """
                                PASASTE AL SIGUIENTE NIVEL!!
                                Presiona siguiente nivel para continuar o
                                salir para guardar tu progreso y salir del juego""");
                        nextLevel.setEnabled(true);
                        fileManager.actualizarNivel(control.getNivel(), jugadores.buscarUsuario());
                    }else{
                        JOptionPane.showMessageDialog(null, "Perdiste, pero puedes volverlo a intentar :)");
                        fileManager.actualizarNivel(control.getNivel(), jugadores.buscarUsuario());
                        System.exit(0);

                    }
                }
            }else if (e.getSource() == ayuda) {

                IconNiveles iconNiveles;
                iconNiveles = new IconNiveles();

                JOptionPane.showMessageDialog(null, MENSAJE_AYUDA, "Como jugar", JOptionPane.PLAIN_MESSAGE, iconNiveles);

            }else if (e.getSource() == exit) {

                fileManager.actualizarNivel(control.getNivel(), jugadores.buscarUsuario());
                JOptionPane.showMessageDialog(null, "Tu progreso fue guardado.");
                System.exit(0);

            }else if (e.getSource() == nextLevel) {
                nextLevel.setEnabled(false);
                control.setNextLevel(false);
                continuar.setVisible(false);
                palabraPanel.remove(continuar);

                palabraPanel.repaint();
                palabraPanel.revalidate();

                palabraPanel.add(iniciar);
                iniciar.setText(null);
                iniciar.setIcon(initOption);
                iniciar.setVisible(true);
                iniciar.addMouseListener(escucha2);
                iniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));


            }
        }



        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == iniciar) {

                jugadores.setName(nombre);
                control.aumentarPalabras();
                control.setPalabrasInicial();
                control.setPalabrasTotales();
                timer1.start();
                iniciar.setCursor(null);
                jugador.setText(jugadores.getName());
                currentLevel.setText(String.valueOf(control.getNivel()));

            } else if (e.getSource() == continuar) {
                timer2.start();
                si.addMouseListener(escucha2);
                no.addMouseListener(escucha2);


                si.setCursor(new Cursor(Cursor.HAND_CURSOR));
                no.setCursor(new Cursor(Cursor.HAND_CURSOR));
                continuar.setIcon(null);
                continuar.setCursor(null);

            } else if (e.getSource() == si) {
                if (control.validarPalabra().get(j-1)) {
                    control.sumarPuntos(true);
                } else {
                    control.sumarPuntos(false);
                }
                si.setEnabled(false);
                no.setEnabled(false);

            } else if (e.getSource() == no) {
                if (!control.validarPalabra().get(j-1)) {
                    control.sumarPuntos(true);
                } else {
                    control.sumarPuntos(false);
                }
                si.setEnabled(false);
                no.setEnabled(false);

            }
        }
    }
}

