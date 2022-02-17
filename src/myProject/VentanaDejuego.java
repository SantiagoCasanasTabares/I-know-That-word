package myProject;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;



public class VentanaDejuego extends JFrame {
    private ImageIcon initOption, continueOption, yesOption, noOption;
    private JLabel iniciar, continuar, si, no;
    private JPanel palabraPanel, siPanel, noPanel, infoPanel;
    private JButton exit, nextLevel, ayuda;
    private Timer timer1, timer2;
    private JTextArea jugador, currentLevel;
    private Escucha escucha1, escucha2;
    private Jugadores jugadores;
    private Control control;

    int nivel;
    String nombre;
    FileManager fileManager;

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
        //Set up JFrame Container's Layout
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //color jframe
        this.getContentPane().setBackground(new Color(192,255,240));

        //escucha and control class
        fileManager = new FileManager();
        jugadores = new Jugadores(nombre);
        escucha1 = new Escucha();
        escucha2 = new Escucha();
        timer1 = new Timer(500, escucha1);
        timer2 = new Timer(800, escucha1);
        control = new Control(nombre);

        //configuracion de elementos

        //panel palabra
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

        //panel si
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

        //panel no
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

        //botones
        //exit
        exit = new JButton("Salir");
        exit.addActionListener(escucha1);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //ayuda
        ayuda = new JButton("Ayuda");
        ayuda.addActionListener(escucha1);
        ayuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //nextLevel
        nextLevel = new JButton("Siguiente nivel");
        nextLevel.addActionListener(escucha1);
        nextLevel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nextLevel.setEnabled(false);

        //JTextArea
        //nombre del jugador
        jugador = new JTextArea();
        jugador.setPreferredSize(new Dimension(100, 20));
        jugador.setText("Player  id");
        jugador.setEditable(false);
        //nivel del jugador
        currentLevel = new JTextArea();
        currentLevel.setPreferredSize(new Dimension(100, 20));
        currentLevel.setText("Nivel actual");
        currentLevel.setEditable(false);

        //infoPanel
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





        //continue Option
        continueOption = new ImageIcon(getClass().getResource("/Resources/continuar.png"));
        continuar = new JLabel(continueOption);

    }

    private class Escucha extends MouseAdapter implements ActionListener {
        String palabra = "";
        int i = 0;
        int j = 0;


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
                    timer1.stop();
                    i = 0;
                    iniciar.setVisible(false);
                    palabraPanel.remove(iniciar);
                    continuar.addMouseListener(escucha2);
                    continuar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    palabraPanel.add(continuar, BorderLayout.CENTER);

                }

            } else if (e.getSource() == timer2) {


                if (i < control.getTotalWords().size()) {

                    si.addMouseListener(escucha2);
                    si.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    no.addMouseListener(escucha2);
                    no.setCursor(new Cursor(Cursor.HAND_CURSOR));


                    palabra = control.getTotalWords().get(i);
                    continuar.setText(palabra);
                    continuar.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
                    control.sumarPuntos(false);
                    i++;
                    j++;
                } else {
                    timer2.stop();
                    si.removeMouseListener(escucha2);
                    si.setCursor(null);
                    no.removeMouseListener(escucha2);
                    no.setCursor(null);
                }
            }
        }




        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == iniciar) {

                jugadores.setName(nombre);
                jugadores.setLevel();
                control.setNivel();

                control.aumentarPalabras();
                control.setPalabrasInicial();
                control.setPalabrasTotales();
                timer1.start();
                iniciar.setCursor(null);
                jugador.setText(jugadores.getName());
                currentLevel.setText(String.valueOf(jugadores.getLevel()));

            } else if (e.getSource() == continuar) {
                timer2.start();
                continuar.setIcon(null);
                continuar.setCursor(null);

                System.out.println(control.validarPalabra());

            } else if (e.getSource() == si) {
                if (control.validarPalabra().get(j)) {
                    control.sumarPuntos(true);
                    System.out.println("k pro , puntos = " + control.getPuntos());
                } else {
                    control.sumarPuntos(false);
                    System.out.println("k noob, puntos = " + control.getPuntos());
                }

                si.removeMouseListener(escucha2);
                si.setCursor(null);
                no.removeMouseListener(escucha2);
                no.setCursor(null);

            } else if (e.getSource() == no) {
                if (!control.validarPalabra().get(j)) {
                    System.out.println(j);
                    control.sumarPuntos(true);
                    System.out.println("k pro , puntos = " + control.getPuntos());
                } else {
                    control.sumarPuntos(false);
                    System.out.println("k noob, puntos = " + control.getPuntos());
                }
                si.removeMouseListener(escucha2);
                si.setCursor(null);
                no.removeMouseListener(escucha2);
                no.setCursor(null);

            }
        }

    }

}

