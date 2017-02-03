package juego;

import javax.swing.*;

/**
 * Created by Vika on 03.02.2017.
 */
public class Juego {
    JFrame ventana;

    public Juego(){
        ventana = new JFrame("PACMAN");
        ventana.setSize(700,700);
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ventana.setVisible(true);
    }
}
