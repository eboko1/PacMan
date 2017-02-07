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
    JButton buttons[];
    JPanel panelMenu;
    JLabel fondoMenu;
    ImageIcon imageFondoMenu;

    //for panelLevelONE
    JPanel panelLevelONE;
    JLabel fondoLevelONE;
    ImageIcon imageFontLevelOne;
    int mat[][];
    JLabel matrix[][];
    String jugador;
    JLabel number;
    String puntos;
    JLabel records;

    /////////////////////////////////////////////////////////////////////////////////
    public Juego(){
        ventana = new JFrame("Created by Vika Frantsuh_PACMAN");
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



        ventana.add(panelPresentation);
        //menu
        buttons = new JButton[5];
        for(int i=0;i<buttons.length;i++){
            buttons[i]=new JButton();

        }

        iniciar.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                System.out.println(" button iniciar");
                menu();
                evenToMenu();

            }
        });
        panelPresentation.add(fondoPresentation,0);// down
        ventana.setVisible(true);
    }// finish constructor

    /////////////////////////////////////////////////////////////////////////////////
    // for level one
    public void levelOne(){
        
    }

    /////////////////////////////////////////////////////////////////////////////////
    public void menu(){
        panelPresentation.setVisible(false);

        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        panelMenu.setVisible(true);

        fondoMenu = new JLabel();
        fondoMenu.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        imageFondoMenu = new ImageIcon("images//fondoMenu.png");
        imageFondoMenu = new ImageIcon(imageFondoMenu.getImage().getScaledInstance(ventana.getWidth(),ventana.getHeight(),Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imageFondoMenu);
        fondoMenu.setVisible(true);
        panelMenu.add(fondoMenu,0);

        buttons[0].setText("One");
        buttons[1].setText("Two");
        buttons[2].setText("Three");
        buttons[3].setText("Four");
        buttons[4].setText("Вихід");

        for(int i=0;i<buttons.length;i++){
            buttons[i].setBounds(ventana.getWidth()-(200+50),(i+1)*50,200,40);
            buttons[i].setVisible(true);
            buttons[i].setBackground(Color.WHITE);
            panelMenu.add(buttons[i],0);
        }
        ventana.add(panelMenu);
    }



/////////////////////////////////////////////////////////////////////////////////
    //menu buttons


    public void evenToMenu(){
        //button ONE
        buttons[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
             System.out.println("Button ONE");
            }
        });
        //button Two
        buttons[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Button Two");

            }
        });
        //button three
        buttons[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Button TREE");

            }
        });
        //button four
        buttons[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Button Four");

            }
        });
        //button exit
        buttons[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Button EXIT");
                System.exit(0);
            }
        });
    }
    /////////////////////////////////////////////////////////////////////////////////
}