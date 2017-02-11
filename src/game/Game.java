package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Vika on 03.02.2017.
 */
public class Game {
    JFrame windows; // ventana

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
    JPanel panelPlay;
    JLabel bgPlay;   //backgroundPlay
    ImageIcon imageBgPlay;  // Bg  -  background
    int mat[][];
    JLabel matrix[][];
    String player;//jugador
    JLabel number;
    String points;
    JLabel records;

    /////////////////////////////////////////////////////////////////////////////////
    public Game(){
        windows = new JFrame("Created by Vika Frantsuh_PACMAN");
        windows.setSize(700,700);
        windows.setLayout(null);
        windows.setLocationRelativeTo(null);
        windows.setResizable(false);
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelPresentation = new JPanel();
        panelPresentation.setLayout(null);
        panelPresentation.setBounds(0,0,windows.getWidth(),windows.getHeight());
        panelPresentation.setVisible(true);
        panelPresentation.setBackground(Color.RED);

        iniciar= new JButton("Menu");
        iniciar.setBounds(windows.getWidth()-120,20,100,30);
        iniciar.setVisible(true);
        iniciar.setBackground(Color.WHITE);
        panelPresentation.add(iniciar,0);

        fondoPresentation = new JLabel();
        fondoPresentation.setBounds(0,0,windows.getWidth(),windows.getHeight());
        imageFondoPres = new ImageIcon("images//backgroundPresentation.png");
        imageFondoPres = new ImageIcon(imageFondoPres.getImage().getScaledInstance(windows.getWidth(),windows.getHeight(),Image.SCALE_DEFAULT));
        fondoPresentation.setIcon(imageFondoPres);
        fondoPresentation.setVisible(true);



        windows.add(panelPresentation);
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
        windows.setVisible(true);
    }// finish constructor

    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    // for levelOne this ->jugar
    public void play(){
        panelMenu.setVisible(false);
        panelPlay = new JPanel();
        panelPlay.setLayout(null);
        panelPlay.setBounds(0,0,windows.getWidth(),windows.getHeight());
        panelPlay.setVisible(true);



    }

    /////////////////////////////////////////////////////////////////////////////////
    public void menu(){
        panelPresentation.setVisible(false);

        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0,0,windows.getWidth(),windows.getHeight());
        panelMenu.setVisible(true);

        fondoMenu = new JLabel();
        fondoMenu.setBounds(0,0,windows.getWidth(),windows.getHeight());
        imageFondoMenu = new ImageIcon("images//backgroundMenu.png");
        imageFondoMenu = new ImageIcon(imageFondoMenu.getImage().getScaledInstance(windows.getWidth(),windows.getHeight(),Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imageFondoMenu);
        fondoMenu.setVisible(true);
        panelMenu.add(fondoMenu,0);

        buttons[0].setText("Play");
        buttons[1].setText("Create table");
        buttons[2].setText("Records");
        buttons[3].setText("Four");
        buttons[4].setText("EXIT");

        for(int i=0;i<buttons.length;i++){
            buttons[i].setBounds(windows.getWidth()-(200+50),(i+1)*50,200,40);
            buttons[i].setVisible(true);
            buttons[i].setBackground(Color.WHITE);
            panelMenu.add(buttons[i],0);
        }
        windows.add(panelMenu);
    }



/////////////////////////////////////////////////////////////////////////////////
    //menu buttons


    public void evenToMenu(){
        //button ONE  jugador is player
        buttons[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button Play");
                player = JOptionPane.showInputDialog(windows,"Player name","Write here");
                while (player == null || player.compareTo("Write here") == 0 || player.compareTo("D") == 0) {
                    player = JOptionPane.showInputDialog(windows,"You must enter a username","Please write here ");
                }
                /////////////////////////////////////////////////////////////////////////////////

                play();//jugar()
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