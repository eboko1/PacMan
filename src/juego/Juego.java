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
    /////////////////////////////////////////////////////////////////////////////////
    //for jugar is play
    /////////////////////////////////////////////////////////////////////////////////
    JPanel play;
    JLabel fondoPlay;
    ImageIcon imageFontPlay;
    int mat[][];
    JLabel matrix[][];
    String player;//jugador
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
        imageFondoPres = new ImageIcon("images//backgroundPresentation.png");
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
                System.out.println(" button menu");
                menu();
                evenToMenu();

            }
        });
        panelPresentation.add(fondoPresentation,0);// down
        ventana.setVisible(true);
    }// finish constructor

    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    // for levelOne this ->jugar
    public void levelONE(){

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
        imageFondoMenu = new ImageIcon("images//backgroundMenu.png");
        imageFondoMenu = new ImageIcon(imageFondoMenu.getImage().getScaledInstance(ventana.getWidth(),ventana.getHeight(),Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imageFondoMenu);
        fondoMenu.setVisible(true);
        panelMenu.add(fondoMenu,0);

        buttons[0].setText("Play");
        buttons[1].setText("Create table");
        buttons[2].setText("Records");
        buttons[3].setText("Four");
        buttons[4].setText("EXIT");

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
        //button ONE  jugador is player
        buttons[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
             System.out.println("Button Play");
             player = JOptionPane.showInputDialog(ventana,"Player name","Write here");
                while (player == null || player.compareTo("Write here") == 0 || player.compareTo("D") == 0) {
                    player = JOptionPane.showInputDialog(ventana,"You must enter a username","Please write here ");
                }
                levelONE();//jugar()
            }
        });

        //button Two
        buttons[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button Create table");

            }
        });
        //button three
        buttons[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button Records");

            }
        });
        //button four
        buttons[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button Four");

            }
        });
        //button exit
        buttons[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button EXIT");
                System.exit(0);
            }
        });
    }
    /////////////////////////////////////////////////////////////////////////////////
}