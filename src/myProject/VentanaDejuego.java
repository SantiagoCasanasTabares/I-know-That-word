package myProject;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;



public class VentanaDejuego extends JFrame {
    private ImageIcon initOption, continueOption, yesOption, noOption;
    private JLabel iniciar, continuar, si, no;
    private JPanel palabraPanel, siPanel, noPanel;
    private JButton salir;
    private Timer timer1, timer2;
    private Escucha escucha;
    private Jugadores jugadores;
    private Control control;
    int nivel;
    String nombre;
    FileManager fileManager;

    public VentanaDejuego(int level, String namePlayer) {
        initGUI();
        this.nivel = level;
        this.nombre = namePlayer;
        //Default JFrame configuration
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
        escucha = new Escucha();
        timer1 = new Timer(500, escucha);
        timer2 = new Timer(800, escucha);
        control = new Control(nombre);

        //configuracion de elementos

        //panel palabra
        palabraPanel = new JPanel();
        initOption = new ImageIcon(getClass().getResource("/Resources/iniciar.png"));
        iniciar = new JLabel(initOption);
        iniciar.addMouseListener(escucha);
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
        add(noPanel, constraints);


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
                System.out.println("cy");
                if (i <control.getWords().size()) {
                    iniciar.setIcon(null);
                    palabra = control.getWords().get(i);
                    iniciar.setText(palabra);
                    iniciar.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
                    i++;
                }else{
                    timer1.stop();
                    i=0;
                    iniciar.setVisible(false);
                    palabraPanel.remove(iniciar);
                    continuar.addMouseListener(escucha);
                    continuar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    palabraPanel.add(continuar, BorderLayout.CENTER);

                }

            }else if (e.getSource() == timer2) {

                if (i < control.getTotalWords().size()) {
                    continuar.setIcon(null);
                    palabra = control.getTotalWords().get(i);
                    continuar.setText(palabra);
                    continuar.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
                    i++;
                }else{
                    timer2.stop();
                }
            }

        }


        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == iniciar) {
                control.setNivel();
                control.aumentarPalabras();
                control.setPalabrasInicial();
                control.setPalabrasTotales();
                timer1.start();
                iniciar.setCursor(null);

            }else if (e.getSource()==continuar){
                timer2.start();
                continuar.setCursor(null);
                si.addMouseListener(escucha);
                si.setCursor(new Cursor(Cursor.HAND_CURSOR));
                no.addMouseListener(escucha);
                no.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }else if (e.getSource()==si) {
                if(control.validarPalabra().get(j)==true){
                    control.sumarPuntos(true);
                    System.out.println("k pro , puntos = "+control.getPuntos());
                }else {
                    control.sumarPuntos(false);
                    System.out.println("k noob, puntos = "+control.getPuntos());
                }
                j++;
            }else if (e.getSource()==no) {
                if(control.validarPalabra().get(j)==false){
                    control.sumarPuntos(true);
                    System.out.println("k pro , puntos = "+control.getPuntos());
                }else{
                    control.sumarPuntos(false);
                    System.out.println("k noob, puntos = "+control.getPuntos());
                }
                j++;
            }
        }

    }

}
