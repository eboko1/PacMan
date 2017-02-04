package juego;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vika on 03.02.2017.
 */
public class Juego {
    JFrame ventana;

    //presentation
    JPanel panelPresentation;
    JButton iniciar;
    JLabel  fondoPresenttion;

    public Juego(){
        ventana = new JFrame("Created by Vika PACMAN");
        ventana.setSize(700,700);
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelPresentation = new JPanel();
        panelPresentation.setLayout(null);
        panelPresentation.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        panelPresentation.setVisible(true);
        panelPresentation.setBackground(Color.RED);

        iniciar= new JButton("INICIAR");
        iniciar.setBounds(ventana.getWidth()-170,20,150,30);
        iniciar.setVisible(true);
        iniciar.setBackground(Color.WHITE);
        panelPresentation.add(iniciar,0);
        ventana.add(panelPresentation);



        ventana.setVisible(true);
    }
}
