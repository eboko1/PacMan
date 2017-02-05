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

    //menu
    Button buttons[];
    JPanel panelMenu;
    JLabel fontoMenu;
    ImageIcon imageFondoMenu;


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

        iniciar= new JButton("Menu");
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
        panelPresentation.setVisible(false);
        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        panelMenu.setVisible(true);

        fontoMenu = new JLabel();
        fontoMenu.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        imageFondoMenu = new ImageIcon("images//fondoMenu.png");
        imageFondoMenu = new ImageIcon(imageFondoMenu.getImage().getScaledInstance(ventana.getWidth(),ventana.getHeight(),Image.SCALE_DEFAULT));
        fontoMenu.setIcon(imageFondoMenu);
        fontoMenu.setVisible(true);
        panelMenu.add(fontoMenu,0);

        for(int i=0;i<buttons.length;i++){
            buttons[i].setBounds(ventana.getWidth()-200,(i+1)*50,200,40);
            buttons[i]=new Button();
            buttons[i].setVisible(true);
            panelMenu.add(buttons[i]);
        }
    }
}