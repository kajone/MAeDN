package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import server.Client;

public class Spielbrett extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel player1, player2, player3, player4;
	private JLabel feld;
	private JButton wuerfel;
	private JButton gelbesHausObenLinks, gruenesHausObenLinks, rotesHausObenLinks, schwarzesHausObenLinks;
	private JButton gelbesHausObenRechts, gruenesHausObenRechts, rotesHausObenRechts, schwarzesHausObenRechts;
	private JButton gelbesHausUntenLinks, gruenesHausUntenLinks, rotesHausUntenLinks, schwarzesHausUntenLinks;
	private JButton gelbesHausUntenRechts, gruenesHausUntenRechts, rotesHausUntenRechts, schwarzesHausUntenRechts;
	private JButton feld0, feld1, feld2, feld3, feld4, feld5, feld6, feld7, feld8, feld9;
	private JButton feld10, feld11, feld12, feld13, feld14, feld15, feld16, feld17, feld18, feld19;
	private JButton feld20, feld21, feld22, feld23, feld24, feld25, feld26, feld27, feld28, feld29;
	private JButton feld30, feld31, feld32, feld33, feld34, feld35, feld36, feld37, feld38, feld39;
	private JButton feld40, feld41, feld42, feld43, feld44, feld45, feld46, feld47, feld48, feld49, feld50, feld51, feld52, feld53, feld54, feld55;
	
	private Client client = null;
	
	public Spielbrett(String titel)
	{
		super(titel);
		
		
		this.setSize(1000, 650);
		this.setLayout(null);
		this.setVisible(true);
		
//		try{
//			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./images/spielbrett.jpg")))));
//			} catch(IOException e){
//				System.out.println("Image can't find");
//			}
			this.setResizable(false);
			
		try{
			feld = new JLabel();
			Image image = ImageIO.read(new File("./images/spielbrett.jpg"));
			feld.setIcon(new ImageIcon(image));
		}catch (IOException e){
			e.printStackTrace();
		}
		
		feld.setBounds(200, 0, 600, 600);
		this.add(feld);
		
		player1 = new JLabel();
		player1.setBounds(20, 50, 100, 20);
		player1.setText("Player1"); 						//TODO: Spielername vom Server holen 
		player1.setFont(new Font("Arial",Font.BOLD, 22));
		player1.setForeground(Color.YELLOW);
		this.add(player1);
		
		player2 = new JLabel();
		player2.setBounds(20, 100, 100, 20);
		player2.setText("Player2");							//TODO: Spielername vom Server holen
		player2.setFont(new Font("Arial",Font.BOLD, 22));
		player2.setForeground(Color.GREEN);
		this.add(player2);
		
		player3 = new JLabel();
		player3.setBounds(20, 150, 100, 20);
		player3.setText("Player3");							//TODO: Spielername vom Server holen			
		player3.setFont(new Font("Arial",Font.BOLD, 22));
		player3.setForeground(Color.RED);
		this.add(player3);
		
		player4 = new JLabel();
		player4.setBounds(20, 200, 100, 20);
		player4.setText("Player4");							//TODO: Spielername vom Server holen
		player4.setFont(new Font("Arial",Font.BOLD, 22));
		this.add(player4);
		
		wuerfel = new JButton();
		wuerfel.setBounds(20, 450, 100, 100);
		
		try{
			Image image = ImageIO.read(new File("./images/wuerfel.jpg"));
			wuerfel.setIcon(new ImageIcon(image));
		} catch(IOException e)
		{
			e.printStackTrace();
		}
		
		wuerfel.setVisible(true);
		wuerfel.addActionListener(this);
		this.add(wuerfel);
		
			
		gelbesHausObenLinks = new JButton();
		gelbesHausObenLinks.setBounds(235, 35, 32, 32);
		this.buttonInitialisieren(gelbesHausObenLinks);
		
		gelbesHausObenRechts = new JButton();
		gelbesHausObenRechts.setBounds(285, 35, 32, 32);
		this.buttonInitialisieren(gelbesHausObenRechts);
		
		gelbesHausUntenLinks = new JButton();
		gelbesHausUntenLinks.setBounds(235, 85, 32, 32);
		this.buttonInitialisieren(gelbesHausUntenLinks);
		
		gelbesHausUntenRechts = new JButton();
		gelbesHausUntenRechts.setBounds(285, 85, 32, 32);
		this.buttonInitialisieren(gelbesHausUntenRechts);
		
		gruenesHausObenLinks = new JButton();
		gruenesHausObenLinks.setBounds(685, 35, 32, 32);
		this.buttonInitialisieren(gruenesHausObenLinks);
		
		gruenesHausObenRechts = new JButton();
		gruenesHausObenRechts.setBounds(735, 35, 32, 32);
		this.buttonInitialisieren(gruenesHausObenRechts);
		
		gruenesHausUntenLinks = new JButton();
		gruenesHausUntenLinks.setBounds(685, 85, 32, 32);
		this.buttonInitialisieren(gruenesHausUntenLinks);
		
		gruenesHausUntenRechts = new JButton();
		gruenesHausUntenRechts.setBounds(735, 85, 32, 32);
		this.buttonInitialisieren(gruenesHausUntenRechts);
		
		rotesHausObenLinks = new JButton();
		rotesHausObenLinks.setBounds(685, 485, 32, 32);
		this.buttonInitialisieren(rotesHausObenLinks);
		
		rotesHausObenRechts = new JButton();
		rotesHausObenRechts.setBounds(735, 485, 32, 32);
		this.buttonInitialisieren(rotesHausObenRechts);
		
		rotesHausUntenLinks = new JButton();
		rotesHausUntenLinks.setBounds(685, 535, 32, 32);
		this.buttonInitialisieren(rotesHausUntenLinks);
		
		rotesHausUntenRechts = new JButton();
		rotesHausUntenRechts.setBounds(735, 535, 32, 32);
		this.buttonInitialisieren(rotesHausUntenRechts);
		
		schwarzesHausObenLinks = new JButton();
		schwarzesHausObenLinks.setBounds(235, 485, 32, 32);
		this.buttonInitialisieren(schwarzesHausObenLinks);
		
		schwarzesHausObenRechts = new JButton();
		schwarzesHausObenRechts.setBounds(285, 485, 32, 32);
		this.buttonInitialisieren(schwarzesHausObenRechts);
		
		schwarzesHausUntenLinks = new JButton();
		schwarzesHausUntenLinks.setBounds(235, 535, 32, 32);
		this.buttonInitialisieren(schwarzesHausUntenLinks);
		
		schwarzesHausUntenRechts = new JButton();
		schwarzesHausUntenRechts.setBounds(285, 535, 32, 32);
		this.buttonInitialisieren(schwarzesHausUntenRechts);
		
		// Es wird am Startpunkt vom gelben Haus angefangen zu zaehlen
		feld0 = new JButton();
		feld0.setBounds(230, 230, 40, 40);
		this.buttonInitialisieren(feld0);
		
		feld1 = new JButton();
		feld1.setBounds(280, 230, 40, 40);
		this.buttonInitialisieren(feld1);
		
		feld2 = new JButton();
		feld2.setBounds(330, 230, 40, 40);
		this.buttonInitialisieren(feld2);
		
		feld3 = new JButton();
		feld3.setBounds(380, 230, 40, 40);
		this.buttonInitialisieren(feld3);
		
		feld4 = new JButton();
		feld4.setBounds(430, 230, 40, 40);
		this.buttonInitialisieren(feld4);
		
		feld5 = new JButton();
		feld5.setBounds(430, 180, 40, 40);
		this.buttonInitialisieren(feld5);
		
		feld6 = new JButton();
		feld6.setBounds(430, 130, 40, 40);
		this.buttonInitialisieren(feld6);
		
		feld7 = new JButton();
		feld7.setBounds(430, 80, 40, 40);
		this.buttonInitialisieren(feld7);
		
		feld8 = new JButton();
		feld8.setBounds(430, 30, 40, 40);
		this.buttonInitialisieren(feld8);
		
		feld9 = new JButton();
		feld9.setBounds(480, 30, 40, 40);
		this.buttonInitialisieren(feld9);
		
		//Startpunkt gruenes Haus
		feld10 = new JButton();
		feld10.setBounds(530, 30, 40, 40);
		this.buttonInitialisieren(feld10);
		
		feld11 = new JButton();
		feld11.setBounds(530, 80, 40, 40);
		this.buttonInitialisieren(feld11);
		
		feld12 = new JButton();
		feld12.setBounds(530, 130, 40, 40);
		this.buttonInitialisieren(feld12);
		
		feld13 = new JButton();
		feld13.setBounds(530, 180, 40, 40);
		this.buttonInitialisieren(feld13);
		
		feld14 = new JButton();
		feld14.setBounds(530, 230, 40, 40);
		this.buttonInitialisieren(feld14);
		
		feld15 = new JButton();
		feld15.setBounds(580, 230, 40, 40);
		this.buttonInitialisieren(feld15);
		
		feld16 = new JButton();
		feld16.setBounds(630, 230, 40, 40);
		this.buttonInitialisieren(feld16);
		
		feld17 = new JButton();
		feld17.setBounds(680, 230, 40, 40);
		this.buttonInitialisieren(feld17);
		
		feld18 = new JButton();
		feld18.setBounds(730, 230, 40, 40);
		this.buttonInitialisieren(feld18);
		
		feld19 = new JButton();
		feld19.setBounds(730, 280, 40, 40);
		this.buttonInitialisieren(feld19);
		
		//Startpunkt rotes Haus
		feld20 = new JButton();
		feld20.setBounds(730, 330, 40, 40);
		this.buttonInitialisieren(feld20);
		
		feld21 = new JButton();
		feld21.setBounds(680, 330, 40, 40);
		this.buttonInitialisieren(feld21);
		
		feld22 = new JButton();
		feld22.setBounds(630, 330, 40, 40);
		this.buttonInitialisieren(feld22);
		
		feld23 = new JButton();
		feld23.setBounds(580, 330, 40, 40);
		this.buttonInitialisieren(feld23);
		
		feld24 = new JButton();
		feld24.setBounds(530, 330, 40, 40);
		this.buttonInitialisieren(feld24);
		
		feld25 = new JButton();
		feld25.setBounds(530, 380, 40, 40);
		this.buttonInitialisieren(feld25);
		
		feld26 = new JButton();
		feld26.setBounds(530, 430, 40, 40);
		this.buttonInitialisieren(feld26);
		
		feld27 = new JButton();
		feld27.setBounds(530, 480, 40, 40);
		this.buttonInitialisieren(feld27);
		
		feld28 = new JButton();
		feld28.setBounds(530, 530, 40, 40);
		this.buttonInitialisieren(feld28);
		
		feld29 = new JButton();
		feld29.setBounds(480, 530, 40, 40);
		this.buttonInitialisieren(feld29);
		
		//Startpunkt schwarzes Haus
		feld30 = new JButton();
		feld30.setBounds(430, 530, 40, 40);
		this.buttonInitialisieren(feld30);

		feld31 = new JButton();
		feld31.setBounds(430, 480, 40, 40);
		this.buttonInitialisieren(feld31);
		
		feld32 = new JButton();
		feld32.setBounds(430, 430, 40, 40);
		this.buttonInitialisieren(feld32);
		
		feld33 = new JButton();
		feld33.setBounds(430, 380, 40, 40);
		this.buttonInitialisieren(feld33);
		
		feld34= new JButton();
		feld34.setBounds(430, 330, 40, 40);
		this.buttonInitialisieren(feld34);
		
		feld35= new JButton();
		feld35.setBounds(380, 330, 40, 40);
		this.buttonInitialisieren(feld35);
		
		feld36 = new JButton();
		feld36.setBounds(330, 330, 40, 40);
		this.buttonInitialisieren(feld36);
		
		feld37 = new JButton();
		feld37.setBounds(280, 330, 40, 40);
		this.buttonInitialisieren(feld37);
	
		feld38 = new JButton();
		feld38.setBounds(230, 330, 40, 40);
		this.buttonInitialisieren(feld38);
		
		feld39 = new JButton();
		feld39.setBounds(230, 280, 40, 40);
		this.buttonInitialisieren(feld39);
		
		//Endhaus gelb
		feld40 = new JButton();
		feld40.setBounds(285, 285, 32, 32);
		this.buttonInitialisieren(feld40);
		
		feld41 = new JButton();
		feld41.setBounds(335, 285, 32, 32);
		this.buttonInitialisieren(feld41);
		
		feld42 = new JButton();
		feld42.setBounds(385, 285, 32, 32);
		this.buttonInitialisieren(feld42);
		
		feld43 = new JButton();
		feld43.setBounds(435, 285, 32, 32);
		this.buttonInitialisieren(feld43);
		
		//Endhaus gruen
		feld44 = new JButton();
		feld44.setBounds(485, 85, 32, 32);
		this.buttonInitialisieren(feld44);
		
		feld45 = new JButton();
		feld45.setBounds(485, 135, 32, 32);
		this.buttonInitialisieren(feld45);
		
		feld46 = new JButton();
		feld46.setBounds(485, 185, 32, 32);
		this.buttonInitialisieren(feld46);
		
		feld47 = new JButton();
		feld47.setBounds(485, 235, 32, 32);
		this.buttonInitialisieren(feld47);
		
		//Endhaus rot
		feld48 = new JButton();
		feld48.setBounds(685, 285, 32, 32);
		this.buttonInitialisieren(feld48);
		
		feld49 = new JButton();
		feld49.setBounds(635, 285, 32, 32);
		this.buttonInitialisieren(feld49);
		
		feld50 = new JButton();
		feld50.setBounds(585, 285, 32, 32);
		this.buttonInitialisieren(feld50);
		
		feld51 = new JButton();
		feld51.setBounds(535, 285, 32, 32);
		this.buttonInitialisieren(feld51);
		
		//Endhaus schwarz
		feld52 = new JButton();
		feld52.setBounds(485, 485, 32, 32);
		this.buttonInitialisieren(feld52);
		
		feld53 = new JButton();
		feld53.setBounds(485, 435, 32, 32);
		this.buttonInitialisieren(feld53);
		
		feld54 = new JButton();
		feld54.setBounds(485, 385, 32, 32);
		this.buttonInitialisieren(feld54);
		
		feld55 = new JButton();
		feld55.setBounds(485, 335, 32, 32);
		this.buttonInitialisieren(feld55);
				
		
		try {
			client = new Client(5000, "127.0.0.1", this);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		client.connect();
		
		File file = new File("Einstellungen.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		int i = 0;
		String name = "";
		String color = "";
		while(sc.hasNextLine()){
			if(i==0) name=sc.nextLine();
			if(i==1) color=sc.nextLine();
			i++;
		}
		sc.close();
		String toServer = "[INIT],"+name+","+color;
		client.writeToServer(toServer); 

		
	}
	
	
	
	
	public void gameUpdate(String board){
		player1.setText(board);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == gelbesHausObenLinks) {
			System.out.println("gelbesHausObenLinks");
		}
		
		if(e.getSource() == gelbesHausObenRechts) {
			System.out.println("gelbesHausObenRechts");
		}
		
		if(e.getSource() == gelbesHausUntenLinks) {
			System.out.println("gelbesHausUntenLinks");
		}
		
		if(e.getSource() == gelbesHausUntenRechts) {
			System.out.println("gelbesHausUntenRechts");
		}
		
		if(e.getSource() == gruenesHausObenLinks) {
			System.out.println("gruenesHausObenLinks");
		}
		
		if(e.getSource() == gruenesHausObenRechts  ) {
			System.out.println("gruenesHausObenRechts");
		}
		
		if(e.getSource() == gruenesHausUntenLinks  ) {
			System.out.println("gruenesHausUntenLinks ");
		}
		
		if(e.getSource() == gruenesHausUntenRechts ) {
			System.out.println("gruenesHausUntenRechts ");
		}
		
		if(e.getSource() == rotesHausObenLinks ) {
			System.out.println("rotesHausObenLinks ");
		}
		
		if(e.getSource() == rotesHausObenRechts ) {
			System.out.println("rotesHausObenRechts ");
		}
		
		if(e.getSource() == rotesHausUntenLinks ) {
			System.out.println("rotesHausUntenLinks ");
		}
		
		if(e.getSource() == rotesHausUntenRechts ) {
			System.out.println("rotesHausUntenRechts ");
		}
		
		if(e.getSource() == schwarzesHausObenLinks ) {
			System.out.println("schwarzesHausObenLinks ");
		}
		
		if(e.getSource() == schwarzesHausObenRechts ) {
			System.out.println("schwarzesHausObenRechts ");
		}
		
		if(e.getSource() == schwarzesHausUntenLinks ) {
			System.out.println("schwarzesHausUntenLinks ");
		}
		
		if(e.getSource() == schwarzesHausUntenRechts ) {
			System.out.println("schwarzesHausUntenRechts ");
		}
		
		if(e.getSource() == feld0) {
			System.out.println("0");
		}
		
		if(e.getSource() == feld1) {
			System.out.println("1");
		}
		
		if(e.getSource() == feld2) {
			System.out.println("2");
		}
		
		if(e.getSource() == feld3) {
			System.out.println("3");
		}
		
		if(e.getSource() == feld4) {
			System.out.println("4");
		}
		
		if(e.getSource() == feld5) {
			System.out.println("5");
		}
		
		if(e.getSource() == feld6) {
			System.out.println("6");
		}
		
		if(e.getSource() == feld7) {
			System.out.println("7");
		}
		
		if(e.getSource() == feld8) {
			System.out.println("8");
		}
		
		if(e.getSource() == feld9) {
			System.out.println("9");
		}
		
		if(e.getSource() == feld10) {
			System.out.println("10");
		}
		
		if(e.getSource() == feld11) {
			System.out.println("11");
		}
		
		if(e.getSource() == feld12) {
			System.out.println("12");
		}
		
		if(e.getSource() == feld13) {
			System.out.println("13");
		}
		
		if(e.getSource() == feld14) {
			System.out.println("14");
		}
		
		if(e.getSource() == feld15) {
			System.out.println("15");
		}
		
		if(e.getSource() == feld16) {
			System.out.println("16");
		}
		
		if(e.getSource() == feld17) {
			System.out.println("17");
		}
		
		if(e.getSource() == feld18) {
			System.out.println("18");
		}
		
		if(e.getSource() == feld19) {
			System.out.println("19");
		}
		
		if(e.getSource() == feld20) {
			System.out.println("20");
		}
		
		if(e.getSource() == feld21) {
			System.out.println("21");
		}
		
		if(e.getSource() == feld22) {
			System.out.println("22");
		}
		
		if(e.getSource() == feld23) {
			System.out.println("23");
		}
		
		if(e.getSource() == feld24) {
			System.out.println("24");
		}
		
		if(e.getSource() == feld25) {
			System.out.println("25");
		}
		
		if(e.getSource() == feld26) {
			System.out.println("26");
		}
		
		if(e.getSource() == feld27) {
			System.out.println("27");
		}
		
		if(e.getSource() == feld28) {
			System.out.println("28");
		}
		
		if(e.getSource() == feld29) {
			System.out.println("29");
		}
		
		if(e.getSource() == feld30) {
			System.out.println("30");
		}
		
		if(e.getSource() == feld31) {
			System.out.println("31");
		}
		
		if(e.getSource() == feld32) {
			System.out.println("32");
		}
		
		if(e.getSource() == feld33) {
			System.out.println("33");
		}
		
		if(e.getSource() == feld34) {
			System.out.println("34");
		}
		
		if(e.getSource() == feld35) {
			System.out.println("35");
		}
		
		if(e.getSource() == feld36) {
			System.out.println("36");
		}
		
		if(e.getSource() == feld37) {
			System.out.println("37");
		}
		
		if(e.getSource() == feld38) {
			System.out.println("38");
		}
		
		if(e.getSource() == feld39) {
			System.out.println("39");
		}
		
		if(e.getSource() == feld40) {
			System.out.println("40");
		}
		
		if(e.getSource() == feld41) {
			System.out.println("41");
		}
		
		if(e.getSource() == feld42) {
			System.out.println("42");
		}
		
		if(e.getSource() == feld43) {
			System.out.println("43");
		}
		
		if(e.getSource() == feld44) {
			System.out.println("44");
		}
		
		if(e.getSource() == feld45) {
			System.out.println("45");
		}
		
		if(e.getSource() == feld46) {
			System.out.println("46");
		}
		
		if(e.getSource() == feld47) {
			System.out.println("47");
		}
		
		if(e.getSource() == feld48) {
			System.out.println("48");
		}
		
		if(e.getSource() == feld49) {
			System.out.println("49");
		}
		
		if(e.getSource() == feld50) {
			System.out.println("50");
		}
		
		if(e.getSource() == feld51) {
			System.out.println("51");
		}
		
		if(e.getSource() == feld52) {
			System.out.println("52");
		}
		
		if(e.getSource() == feld53) {
			System.out.println("53");
		}
		
		if(e.getSource() == feld54) {
			System.out.println("54");
		}
		
		if(e.getSource() == feld55) {
			System.out.println("55");
		}
		
		if(e.getSource() == wuerfel) {
			//TODO: Hier mit der wuerfelfunktion der Logik verbunden
			
			client.roll();
			
			
		}
	}
	
	public void buttonInitialisieren(JButton button)
	{
		button.addActionListener(this);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		this.add(button);
	}




	public void update(String board) {
		player1.setText(board);
		
	}

}
