package juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Vika on 03.02.2017.
 */
public class Juego {
    JFrame ventana;

    //presentation
    JPanel panelPresentation;
    JButton iniciar;
    JLabel  fondoPresentation;
    ImageIcon imageFondoPres;

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
        iniciar.setBounds(ventana.getWidth()-120,20,100,30);
        iniciar.setVisible(true);
        iniciar.setBackground(Color.WHITE);
        panelPresentation.add(iniciar,0);

        fondoPresentation = new JLabel();
        fondoPresentation.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        imageFondoPres = new ImageIcon("images//fondoPresentation.png");
        imageFondoPres = new ImageIcon(imageFondoPres.getImage().getScaledInstance(ventana.getWidth(),ventana.getHeight(),Image.SCALE_DEFAULT));
        fondoPresentation.setIcon(imageFondoPres);
        fondoPresentation.setVisible(true);

        panelPresentation.add(fondoPresentation,0);

        ventana.add(panelPresentation);

        iniciar.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                System.out.println(" button iniciar");
                menu();

            }
        });

        ventana.setVisible(true);
    }
    public void menu(){
        
    }
}