package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    int px,py;
    int enemyX,enemyY;
    String player;//jugador
    JLabel number;
    String points;
    JLabel records;
    int up;
    int down;
    int left;
    int right;
    Timer timer;

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
// play
        mat = new int [15][15];
        matrix = new JLabel[15][15];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                matrix[i][j] = new JLabel();
            }
        }
        mat = tablero(1);
        // image player
        px =1;
        py =1;
        mat[px][py]=3;
        // image enemy
        enemyX=12;
        enemyY=12;
        mat[enemyX][enemyY]=7;


        panelPresentation.add(fondoPresentation,0);// down
        windows.setVisible(true);
    }// finish constructor

    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    // for PLay at ->jugar
    public void play(){
        panelMenu.setVisible(false);
        panelPlay = new JPanel();
        panelPlay.setLayout(null);
        panelPlay.setBounds(0,0,windows.getWidth(),windows.getHeight());
        panelPlay.setVisible(true);

        bgPlay = new JLabel();
        bgPlay.setBounds(0,0,windows.getWidth(),windows.getHeight());
        imageBgPlay = new ImageIcon("images//bgPlay.png");
        imageBgPlay= new ImageIcon(imageBgPlay.getImage().getScaledInstance(windows.getWidth(),windows.getHeight(),Image.SCALE_DEFAULT));
        bgPlay.setIcon(imageBgPlay);
        bgPlay.setVisible(true);
        panelPlay.add(bgPlay,0);

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                matrix[i][j].setIcon(new ImageIcon("images/"+mat[i][j]+".png"));
                matrix[i][j].setBounds(120+i*30,120+j*30,30,30);
                matrix[i][j].setVisible(true);
                panelPlay.add(matrix[i][j],0);
            }
        }


        number = new JLabel("PLAYER: " + player);
        number.setBounds(20,20,150,30);
        number.setForeground(Color.white);
        number.setVisible(true);
        panelPlay.add(number,0);

        move();

        windows.add(panelPlay);
    }
    // pintarmatez on enemy
    public void enemy(){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                matrix[i][j].setIcon(new ImageIcon("images/"+mat[i][j]+".png"));
                matrix[i][j].setBounds(120+i*30,120+j*30,30,30);
                matrix[i][j].setVisible(true);
                panelPlay.add(matrix[i][j],0);
            }
        }

    }
    public void move (){
        timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(up == 1 && (mat[px][py-1]==1 || mat[px][py-1]==0) ){
                    mat[px][py] = 0;
                    py = py - 1;
                    mat[px][py] = 3;
                    enemy();
                }
                if(down == 1 && (mat[px][py+1]==1 || mat[px][py+1]==0) ){
                    mat[px][py] = 0;
                    py = py + 1;
                    mat[px][py] = 3;
                    enemy();
                }
                if(left == 1 && (mat[px-1][py]==1 || mat[px-1][py]==0) ){
                    mat[px][py] = 0;
                    px = px - 1;
                    mat[px][py] = 3;
                    enemy();
                }
                if(right == 1 && (mat[px+1][py]==1 || mat[px+1][py]==0) ){
                    mat[px][py] = 0;
                    px = px + 1;
                    mat[px][py] = 3;
                    enemy();
                }

            }
        });
        timer.start();
        windows.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_UP){
                System.out.println("UP");
                if (mat[px][py-1]==1 || mat[px][py-1]==0) {
                    up = 1;
                    down = 0;
                    left = 0;
                    right = 0;
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                System.out.println("DOwN");
                if (mat[px][py+1]==1 || mat[px][py+1]==0) {
                    up = 0;
                    down = 1;
                    left = 0;
                    right = 0;
                }
            }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                System.out.println("right");
                    if (mat[px+1][py]==1 || mat[px+1][py]==0) {
                        up = 0;
                        down = 0;
                        left = 0;
                        right = 1;
                    }
               // mat[px][py] = 0;
                //px=px + 1;
               // mat[px][py]=3;
                //enemy();
            }
            if(e.getKeyCode()==KeyEvent.VK_LEFT){
                System.out.println("Left");
                if (mat[px-1][py]==1 || mat[px-1][py]==0) {
                    up = 0;
                    down = 0;
                    left = 1;
                    right = 0;
                }

               // mat[px][py] = 0;
               // px=px-1;
              //  mat[px][py]=3;
              //  enemy();
            }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }
    public int [][] tablero (int option){
        int [][]aux1 = new int [15][15];
        if (option == 1 ){
            int aux[][] = {
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,1,1,2,1,1,1,2,1,1,1,1,1,2},
                    {2,1,2,1,2,1,1,1,1,1,1,2,1,2},
                    {2,1,1,1,1,1,1,2,1,1,2,2,1,2},
                    {2,1,2,1,1,1,2,1,1,2,1,2,1,2},

                    {2,1,2,2,1,2,2,2,1,2,1,2,1,2},
                    {2,1,1,1,1,1,2,1,1,1,1,2,1,2},
                    {2,2,2,1,2,2,2,2,2,2,2,2,1,2},
                    {2,1,1,1,2,1,1,1,1,1,1,1,1,2},
                    {2,1,2,1,1,1,2,2,2,1,1,2,1,2},

                    {2,1,1,1,2,1,2,1,1,2,2,2,1,2},
                    {2,1,2,1,2,1,2,1,2,1,2,1,1,2},
                    {2,1,1,1,2,1,1,1,1,1,1,1,1,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},

            };
            return aux;
        }
        if (option == 2 ){
            int aux[][] = {
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,1,1,1,1,1,1,2,1,1,1,1,1,2},
                    {2,1,2,1,2,1,2,1,2,2,1,2,1,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},

            };
            return aux;
        }
        if (option == 3 ){
            int aux[][] = {
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,1,1,1,1,1,1,2,1,1,1,1,1,2},
                    {2,1,2,1,2,1,2,1,2,2,1,2,1,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,2,2,1,2,1,2,2,1,2,2,2,2,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,1,2,1,1,1,1,2,2,2,1,1,1,2},
                    {2,1,2,1,1,1,1,2,2,2,1,1,1,2},
                    {2,1,2,1,1,1,1,2,2,2,1,1,1,2},
                    {2,1,2,1,1,1,1,2,2,2,1,1,1,2},
                    {2,1,2,1,1,1,1,2,2,2,1,1,1,2},
                    {2,1,2,1,1,1,1,2,2,2,1,1,1,2},
                    {2,1,2,1,1,1,1,2,2,2,1,1,1,2},
                    {2,1,2,1,1,1,1,2,2,2,1,1,1,2},

            };
            return aux;
        }
        return aux1;
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