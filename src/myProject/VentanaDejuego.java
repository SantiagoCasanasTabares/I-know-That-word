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

    public VentanaDejuego() {
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

    private void initGUI() {
        //Set up JFrame Container's Layout
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //color jframe
        this.getContentPane().setBackground(new Color(192,255,240));

        //escucha and control class
        escucha = new Escucha();
        timer1 = new Timer(1000, escucha);
        timer2 = new Timer(7000, escucha);
        control = new Control();

        //configuracion de elementos

        //panel palabra
        palabraPanel = new JPanel();
        initOption = new ImageIcon(getClass().getResource("/Resources/iniciar.png"));
        iniciar = new JLabel(initOption);
        palabraPanel.add(iniciar, BorderLayout.CENTER);
        iniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        palabraPanel.setPreferredSize(new Dimension(250, 130));
        TitledBorder titledBorderPalabra = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        palabraPanel.setBorder(titledBorderPalabra);
        titledBorderPalabra.setTitleColor(Color.black);
        iniciar.addMouseListener(escucha);
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
        siPanel.addMouseListener(escucha);
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
        noPanel.addMouseListener(escucha);
        noPanel.setOpaque(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        add(noPanel, constraints);

    }

    private class Escucha extends MouseAdapter implements ActionListener {
        String palabra = "";
        int i=0;


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == timer1) {
                if(i<control.getWords().size()){
                    //System.out.println(control.palabraArecordar());
                    iniciar.setIcon(null);
                    palabra = control.getWords().get(i);
                    iniciar.setText(palabra);
                    System.out.println(palabra);
                    i++;
                }else{
                    timer1.stop();
                    System.out.println("ñ");
                }
            }

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()==iniciar) {
                control.aumentarPalabras();
                control.setPalabrasInicial();
                control.setPalabrasTotales();
                timer1.start();
            }

        }
    }

}
