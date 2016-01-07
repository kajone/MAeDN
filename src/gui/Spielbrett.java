package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import server.Client;

public class Spielbrett extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel player1, player2, player3, player4;
	private JLabel feld;
	private JButton wuerfel;
	private JLabel rollResultLabel;
	private JButton gelbesHausObenLinks, gruenesHausObenLinks, rotesHausObenLinks, schwarzesHausObenLinks;
	private JButton gelbesHausObenRechts, gruenesHausObenRechts, rotesHausObenRechts, schwarzesHausObenRechts;
	private JButton gelbesHausUntenLinks, gruenesHausUntenLinks, rotesHausUntenLinks, schwarzesHausUntenLinks;
	private JButton gelbesHausUntenRechts, gruenesHausUntenRechts, rotesHausUntenRechts, schwarzesHausUntenRechts;
	private JButton feld0, feld1, feld2, feld3, feld4, feld5, feld6, feld7, feld8, feld9;
	private JButton feld10, feld11, feld12, feld13, feld14, feld15, feld16, feld17, feld18, feld19;
	private JButton feld20, feld21, feld22, feld23, feld24, feld25, feld26, feld27, feld28, feld29;
	private JButton feld30, feld31, feld32, feld33, feld34, feld35, feld36, feld37, feld38, feld39;
	private JButton feld40, feld41, feld42, feld43, feld44, feld45, feld46, feld47, feld48, feld49, feld50, feld51, feld52, feld53, feld54, feld55;
	
	
	
	private int rollResult = 0;
	private HashMap<Integer, Integer> positions = new HashMap<Integer, Integer>();
	
	private int whoIsPlaying = 0;
	
	private HashMap<String, JButton> jButtonMap = new HashMap<String, JButton>();
	
	private int[] realPossibilities;
	
	private Client client = null;
	private JLabel turnPlayer1;
	private JLabel turnPlayer2;
	private JLabel turnPlayer3;
	private JLabel turnPlayer4;
	
	public Spielbrett(String titel)
	{
		super(titel);
		
		
		this.setSize(1000, 650);
		getContentPane().setLayout(null);
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
		getContentPane().add(feld);
		
		player1 = new JLabel();
		player1.setBounds(20, 50, 100, 20);
		player1.setText("Player1"); 						
		player1.setFont(new Font("Arial",Font.BOLD, 22));
		player1.setForeground(Color.YELLOW);
		getContentPane().add(player1);
		
		player2 = new JLabel();
		player2.setBounds(20, 100, 100, 20);
		player2.setText("Player2");							
		player2.setFont(new Font("Arial",Font.BOLD, 22));
		player2.setForeground(Color.GREEN);
		getContentPane().add(player2);
		
		player3 = new JLabel();
		player3.setBounds(20, 150, 100, 20);
		player3.setText("Player3");									
		player3.setFont(new Font("Arial",Font.BOLD, 22));
		player3.setForeground(Color.RED);
		getContentPane().add(player3);
		
		player4 = new JLabel();
		player4.setBounds(20, 200, 100, 20);
		player4.setText("Player4");							
		player4.setFont(new Font("Arial",Font.BOLD, 22));
		getContentPane().add(player4);
		
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
		getContentPane().add(wuerfel);
		
			
		gelbesHausObenLinks = new JButton();
		gelbesHausObenLinks.setBounds(235, 35, 32, 32);
		this.buttonInitialisieren(gelbesHausObenLinks);
		
		this.rollResultLabel = new JLabel("Result:  ");
		rollResultLabel.setBounds(20, 555, 79, 27);
		getContentPane().add(rollResultLabel);
		
		turnPlayer1 = new JLabel("<--");
		turnPlayer1.setBounds(116, 50, 46, 14);
		turnPlayer1.setVisible(false);
		getContentPane().add(turnPlayer1);
		
		turnPlayer2 = new JLabel("<--");
		turnPlayer2.setBounds(116, 100, 46, 14);
		turnPlayer2.setVisible(false);
		getContentPane().add(turnPlayer2);
		
		turnPlayer3 = new JLabel("<--");
		turnPlayer3.setBounds(116, 150, 46, 14);
		turnPlayer3.setVisible(false);
		getContentPane().add(turnPlayer3);
		
		turnPlayer4 = new JLabel("<--");
		turnPlayer4.setBounds(116, 200, 46, 14);
		turnPlayer4.setVisible(false);
		getContentPane().add(turnPlayer4);
		
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
		jButtonMap.put("feld0", feld0);
		
		feld1 = new JButton();
		feld1.setBounds(280, 230, 40, 40);
		this.buttonInitialisieren(feld1);
		jButtonMap.put("feld1", feld1);
		
		feld2 = new JButton();
		feld2.setBounds(330, 230, 40, 40);
		this.buttonInitialisieren(feld2);
		jButtonMap.put("feld2", feld2);
		
		feld3 = new JButton();
		feld3.setBounds(380, 230, 40, 40);
		this.buttonInitialisieren(feld3);
		jButtonMap.put("feld3", feld3);
		
		feld4 = new JButton();
		feld4.setBounds(430, 230, 40, 40);
		this.buttonInitialisieren(feld4);
		jButtonMap.put("feld4", feld4);
		
		feld5 = new JButton();
		feld5.setBounds(430, 180, 40, 40);
		this.buttonInitialisieren(feld5);
		jButtonMap.put("feld5", feld5);
		
		feld6 = new JButton();
		feld6.setBounds(430, 130, 40, 40);
		this.buttonInitialisieren(feld6);
		jButtonMap.put("feld6", feld6);
		
		feld7 = new JButton();
		feld7.setBounds(430, 80, 40, 40);
		this.buttonInitialisieren(feld7);
		jButtonMap.put("feld7", feld7);
		
		feld8 = new JButton();
		feld8.setBounds(430, 30, 40, 40);
		this.buttonInitialisieren(feld8);
		jButtonMap.put("feld8", feld8);
		
		feld9 = new JButton();
		feld9.setBounds(480, 30, 40, 40);
		this.buttonInitialisieren(feld9);
		jButtonMap.put("feld9", feld9);
		
		//Startpunkt gruenes Haus
		feld10 = new JButton();
		feld10.setBounds(530, 30, 40, 40);
		this.buttonInitialisieren(feld10);
		jButtonMap.put("feld10", feld10);
		
		feld11 = new JButton();
		feld11.setBounds(530, 80, 40, 40);
		this.buttonInitialisieren(feld11);
		jButtonMap.put("feld11", feld11);
		
		feld12 = new JButton();
		feld12.setBounds(530, 130, 40, 40);
		this.buttonInitialisieren(feld12);
		jButtonMap.put("feld12", feld12);
		
		feld13 = new JButton();
		feld13.setBounds(530, 180, 40, 40);
		this.buttonInitialisieren(feld13);
		jButtonMap.put("feld13", feld13);
		
		feld14 = new JButton();
		feld14.setBounds(530, 230, 40, 40);
		this.buttonInitialisieren(feld14);
		jButtonMap.put("feld14", feld14);
		
		feld15 = new JButton();
		feld15.setBounds(580, 230, 40, 40);
		this.buttonInitialisieren(feld15);
		jButtonMap.put("feld15", feld15);
		
		feld16 = new JButton();
		feld16.setBounds(630, 230, 40, 40);
		this.buttonInitialisieren(feld16);
		jButtonMap.put("feld16", feld16);
		
		feld17 = new JButton();
		feld17.setBounds(680, 230, 40, 40);
		this.buttonInitialisieren(feld17);
		jButtonMap.put("feld17", feld17);
		
		feld18 = new JButton();
		feld18.setBounds(730, 230, 40, 40);
		this.buttonInitialisieren(feld18);
		jButtonMap.put("feld18", feld18);
		
		feld19 = new JButton();
		feld19.setBounds(730, 280, 40, 40);
		this.buttonInitialisieren(feld19);
		jButtonMap.put("feld19", feld19);
		
		//Startpunkt rotes Haus
		feld20 = new JButton();
		feld20.setBounds(730, 330, 40, 40);
		this.buttonInitialisieren(feld20);
		jButtonMap.put("feld20", feld20);
		
		feld21 = new JButton();
		feld21.setBounds(680, 330, 40, 40);
		this.buttonInitialisieren(feld21);
		jButtonMap.put("feld21", feld21);
		
		feld22 = new JButton();
		feld22.setBounds(630, 330, 40, 40);
		this.buttonInitialisieren(feld22);
		jButtonMap.put("feld22", feld22);
		
		feld23 = new JButton();
		feld23.setBounds(580, 330, 40, 40);
		this.buttonInitialisieren(feld23);
		jButtonMap.put("feld23", feld23);
		
		feld24 = new JButton();
		feld24.setBounds(530, 330, 40, 40);
		this.buttonInitialisieren(feld24);
		jButtonMap.put("feld24", feld24);
		
		feld25 = new JButton();
		feld25.setBounds(530, 380, 40, 40);
		this.buttonInitialisieren(feld25);
		jButtonMap.put("feld25", feld25);
		
		feld26 = new JButton();
		feld26.setBounds(530, 430, 40, 40);
		this.buttonInitialisieren(feld26);
		jButtonMap.put("feld26", feld26);
		
		feld27 = new JButton();
		feld27.setBounds(530, 480, 40, 40);
		this.buttonInitialisieren(feld27);
		jButtonMap.put("feld27", feld27);
		
		feld28 = new JButton();
		feld28.setBounds(530, 530, 40, 40);
		this.buttonInitialisieren(feld28);
		jButtonMap.put("feld28", feld28);
		
		feld29 = new JButton();
		feld29.setBounds(480, 530, 40, 40);
		this.buttonInitialisieren(feld29);
		jButtonMap.put("feld29", feld29);
		
		//Startpunkt schwarzes Haus
		feld30 = new JButton();
		feld30.setBounds(430, 530, 40, 40);
		this.buttonInitialisieren(feld30);
		jButtonMap.put("feld30", feld30);
		
		feld31 = new JButton();
		feld31.setBounds(430, 480, 40, 40);
		this.buttonInitialisieren(feld31);
		jButtonMap.put("feld31", feld31);
		
		feld32 = new JButton();
		feld32.setBounds(430, 430, 40, 40);
		this.buttonInitialisieren(feld32);
		jButtonMap.put("feld32", feld32);
		
		feld33 = new JButton();
		feld33.setBounds(430, 380, 40, 40);
		this.buttonInitialisieren(feld33);
		jButtonMap.put("feld33", feld33);
		
		feld34= new JButton();
		feld34.setBounds(430, 330, 40, 40);
		this.buttonInitialisieren(feld34);
		jButtonMap.put("feld34", feld34);
		
		feld35= new JButton();
		feld35.setBounds(380, 330, 40, 40);
		this.buttonInitialisieren(feld35);
		jButtonMap.put("feld35", feld35);
		
		feld36 = new JButton();
		feld36.setBounds(330, 330, 40, 40);
		this.buttonInitialisieren(feld36);
		jButtonMap.put("feld36", feld36);
		
		feld37 = new JButton();
		feld37.setBounds(280, 330, 40, 40);
		this.buttonInitialisieren(feld37);
		jButtonMap.put("feld37", feld37);
		
		feld38 = new JButton();
		feld38.setBounds(230, 330, 40, 40);
		this.buttonInitialisieren(feld38);
		jButtonMap.put("feld38", feld38);
		
		feld39 = new JButton();
		feld39.setBounds(230, 280, 40, 40);
		this.buttonInitialisieren(feld39);
		jButtonMap.put("feld39", feld39);
		
		//Endhaus gelb
		feld40 = new JButton();
		feld40.setBounds(285, 285, 32, 32);
		this.buttonInitialisieren(feld40);
		jButtonMap.put("feld40", feld40);
		
		feld41 = new JButton();
		feld41.setBounds(335, 285, 32, 32);
		this.buttonInitialisieren(feld41);
		jButtonMap.put("feld41", feld41);
		
		feld42 = new JButton();
		feld42.setBounds(385, 285, 32, 32);
		this.buttonInitialisieren(feld42);
		jButtonMap.put("feld42", feld42);
		
		feld43 = new JButton();
		feld43.setBounds(435, 285, 32, 32);
		this.buttonInitialisieren(feld43);
		jButtonMap.put("feld43", feld43);
		
		//Endhaus gruen
		feld44 = new JButton();
		feld44.setBounds(485, 85, 32, 32);
		this.buttonInitialisieren(feld44);
		jButtonMap.put("feld44", feld44);
		
		feld45 = new JButton();
		feld45.setBounds(485, 135, 32, 32);
		this.buttonInitialisieren(feld45);
		jButtonMap.put("feld45", feld45);
		
		feld46 = new JButton();
		feld46.setBounds(485, 185, 32, 32);
		this.buttonInitialisieren(feld46);
		jButtonMap.put("feld46", feld46);
		
		feld47 = new JButton();
		feld47.setBounds(485, 235, 32, 32);
		this.buttonInitialisieren(feld47);
		jButtonMap.put("feld47", feld47);
		
		//Endhaus rot
		feld48 = new JButton();
		feld48.setBounds(685, 285, 32, 32);
		this.buttonInitialisieren(feld48);
		jButtonMap.put("feld48", feld48);
		
		feld49 = new JButton();
		feld49.setBounds(635, 285, 32, 32);
		this.buttonInitialisieren(feld49);
		jButtonMap.put("feld49", feld49);
		
		feld50 = new JButton();
		feld50.setBounds(585, 285, 32, 32);
		this.buttonInitialisieren(feld50);
		jButtonMap.put("feld50", feld50);
		
		feld51 = new JButton();
		feld51.setBounds(535, 285, 32, 32);
		this.buttonInitialisieren(feld51);
		jButtonMap.put("feld51", feld51);
		
		//Endhaus schwarz
		feld52 = new JButton();
		feld52.setBounds(485, 485, 32, 32);
		this.buttonInitialisieren(feld52);
		jButtonMap.put("feld52", feld52);
		
		feld53 = new JButton();
		feld53.setBounds(485, 435, 32, 32);
		this.buttonInitialisieren(feld53);
		jButtonMap.put("feld53", feld53);
		
		feld54 = new JButton();
		feld54.setBounds(485, 385, 32, 32);
		this.buttonInitialisieren(feld54);
		jButtonMap.put("feld54", feld54);
		
		feld55 = new JButton();
		feld55.setBounds(485, 335, 32, 32);
		this.buttonInitialisieren(feld55);
		jButtonMap.put("feld55", feld55);		
		
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

	public void actionPerformed(ActionEvent e) {
		
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
			checkClickedField(0);
		}
		
		if(e.getSource() == feld1) {
			checkClickedField(1);
		}
		
		if(e.getSource() == feld2) {
			checkClickedField(2);
		}
		
		if(e.getSource() == feld3) {
			checkClickedField(3);
		}
		
		if(e.getSource() == feld4) {
			checkClickedField(4);
		}
		
		if(e.getSource() == feld5) {
			checkClickedField(5);
		}
		
		if(e.getSource() == feld6) {
			checkClickedField(6);
		}
		
		if(e.getSource() == feld7) {
			checkClickedField(7);
		}
		
		if(e.getSource() == feld8) {
			checkClickedField(8);
		}
		
		if(e.getSource() == feld9) {
			checkClickedField(9);
		}
		
		if(e.getSource() == feld10) {
			checkClickedField(10);
		}
		
		if(e.getSource() == feld11) {
			checkClickedField(11);
		}
		
		if(e.getSource() == feld12) {
			checkClickedField(12);
		}
		
		if(e.getSource() == feld13) {
			checkClickedField(13);
		}
		
		if(e.getSource() == feld14) {
			checkClickedField(14);
		}
		
		if(e.getSource() == feld15) {
			checkClickedField(15);
		}
		
		if(e.getSource() == feld16) {
			checkClickedField(16);
		}
		
		if(e.getSource() == feld17) {
			checkClickedField(17);
		}
		
		if(e.getSource() == feld18) {
			checkClickedField(18);
		}
		
		if(e.getSource() == feld19) {
			checkClickedField(19);
		}
		
		if(e.getSource() == feld20) {
			checkClickedField(20);
		}
		
		if(e.getSource() == feld21) {
			checkClickedField(21);
		}
		
		if(e.getSource() == feld22) {
			checkClickedField(22);
		}
		
		if(e.getSource() == feld23) {
			checkClickedField(23);
		}
		
		if(e.getSource() == feld24) {
			checkClickedField(24);
		}
		
		if(e.getSource() == feld25) {
			checkClickedField(25);
		}
		
		if(e.getSource() == feld26) {
			checkClickedField(26);
		}
		
		if(e.getSource() == feld27) {
			checkClickedField(27);
		}
		
		if(e.getSource() == feld28) {
			checkClickedField(28);
		}
		
		if(e.getSource() == feld29) {
			checkClickedField(29);
		}
		
		if(e.getSource() == feld30) {
			checkClickedField(30);
		}
		
		if(e.getSource() == feld31) {
			checkClickedField(31);
		}
		
		if(e.getSource() == feld32) {
			checkClickedField(32);
		}
		
		if(e.getSource() == feld33) {
			checkClickedField(33);
		}
		
		if(e.getSource() == feld34) {
			checkClickedField(34);
		}
		
		if(e.getSource() == feld35) {
			checkClickedField(35);
		}
		
		if(e.getSource() == feld36) {
			checkClickedField(36);
		}
		
		if(e.getSource() == feld37) {
			checkClickedField(37);
		}
		
		if(e.getSource() == feld38) {
			checkClickedField(38);
		}
		
		if(e.getSource() == feld39) {
			checkClickedField(39);
		}
		
		if(e.getSource() == feld40) {
			checkClickedField(40);
		}
		
		if(e.getSource() == feld41) {
			checkClickedField(41);
		}
		
		if(e.getSource() == feld42) {
			checkClickedField(42);
		}
		
		if(e.getSource() == feld43) {
			checkClickedField(43);
		}
		
		if(e.getSource() == feld44) {
			checkClickedField(44);
		}
		
		if(e.getSource() == feld45) {
			checkClickedField(45);
		}
		
		if(e.getSource() == feld46) {
			checkClickedField(46);
		}
		
		if(e.getSource() == feld47) {
			checkClickedField(47);
		}
		
		if(e.getSource() == feld48) {
			checkClickedField(48);
		}
		
		if(e.getSource() == feld49) {
			checkClickedField(49);
		}
		
		if(e.getSource() == feld50) {
			checkClickedField(50);
		}
		
		if(e.getSource() == feld51) {
			checkClickedField(51);
		}
		
		if(e.getSource() == feld52) {
			checkClickedField(52);
		}
		
		if(e.getSource() == feld53) {
			checkClickedField(53);
		}
		
		if(e.getSource() == feld54) {
			checkClickedField(54);
		}
		
		if(e.getSource() == feld55) {
			checkClickedField(55);
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
		getContentPane().add(button);
	}

	public void update(String board) {
		clearBoard();
		System.out.println("BOARD:" + board);
		
		String[] token = board.split(",");
		int tokenID = 0;
		String tokenColor = "";
		int tokenPosition = 0;
		
		for(int i = 0; i< token.length; i++){
			tokenID = Integer.parseInt(token[i].split(";")[0]);
			tokenColor = token[i].split(";")[1];
			tokenPosition = Integer.parseInt(token[i].split(";")[2]);
			if((tokenID/10)==this.whoIsPlaying)this.positions.put(tokenID,tokenPosition);
			if(tokenPosition >= 0){
				setToken(jButtonMap.get("feld" + tokenPosition), tokenColor);
				
			}	
		}
	}
	
	private void clearBoard() {
		positions.clear();
		Set<String> keys = jButtonMap.keySet();
		for (String singleKey : keys) {
			jButtonMap.get(singleKey).setIcon(null);
			jButtonMap.get(singleKey).setOpaque(false);
		}
	}
	private void setToken(JButton feldx, String color){
		String location = "";
		switch(color){
			case "gelb": location = "./images/Spielfigur-gelb.jpg"; break;
			case "schwarz": location = "./images/Spielfigur-schwarz.jpg"; break;
			case "rot": location = "./images/Spielfigur-rot.jpg"; break;
			case "gruen": location = "./images/Spielfigur-gruen.jpg"; break;
			default: System.out.println("Farbe hat keinen Spielstein"); break;
		}
		
		feldx.setHorizontalTextPosition(SwingConstants.CENTER);
		feldx.setOpaque(true);
		ImageIcon icon = new ImageIcon(location); //"./images/Spielfigur-gelb.jpg"
		icon.setImage(icon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		feldx.setIcon(icon);
	}

	public void playerUpdate(String update) {
		player1.setText(update.split(";")[0]);
		player2.setText(update.split(";")[1]);
		player3.setText(update.split(";")[2]);
		player4.setText(update.split(";")[3]);
	}




	public void setPossibilities(String possibilities) {
		// rechnet direkt die möglichen drückbaren felder aus und packt sie in das Array possibilities 
		//this.possibilities = possibilities;
		if(possibilities == null){ this.realPossibilities = null; return;}
		String[] possibilityArray = possibilities.split(";");
		
		this.realPossibilities = new int[possibilityArray.length];
		for(int i = 0; i < possibilityArray.length; i++){
			int tmp = 0;
			if(positions.get(Integer.parseInt(possibilityArray[i])) == -1){ //Startposition
				realPossibilities[i] = whoIsPlaying*10-10;		
			}
			else if(positions.get(Integer.parseInt(possibilityArray[i])) <= 39 && positions.get(Integer.parseInt(possibilityArray[i]))  + rollResult >= 40){
				//realPossibilities[i] = positions.get(Integer.parseInt(possibilityArray[i]))+rollResult + (whoIsPlaying-1)*4;
				realPossibilities[i] = positions.get(Integer.parseInt(possibilityArray[i]))+rollResult-40;
				
			}else{
				realPossibilities[i]=positions.get(Integer.parseInt(possibilityArray[i]))+rollResult; // TODO if not haus  // TODO Startposition
			}
			
		}
		for(int i = 0; i< realPossibilities.length;i++){
			System.out.println(realPossibilities[i]);
		}
		//realPossibilities.add();
		
	}
	
	public void gotRollResult(String rollResult) {
		this.rollResult = Integer.parseInt(rollResult);
		rollResultLabel.setText("Result: " + rollResult);
		getContentPane().add(rollResultLabel);
	}
	
	private void checkClickedField(int j){
		if(realPossibilities==null)return;
		for(int i = 0; i < realPossibilities.length; i++){
			if(realPossibilities[i] == j){
				client.choose(i);
				realPossibilities = null;
				break;
			}
		}
	}




	public void playerTurn(String playerID) {
		// Der hier ist gerade dran
		this.whoIsPlaying = Integer.parseInt(playerID);
		turnPlayer1.setVisible(false); 
		turnPlayer2.setVisible(false); 
		turnPlayer3.setVisible(false); 
		turnPlayer4.setVisible(false); 
		switch(Integer.parseInt(playerID)){
		case 1: turnPlayer1.setVisible(true); break;
		case 2: turnPlayer2.setVisible(true); break;
		case 3: turnPlayer3.setVisible(true); break;
		case 4: turnPlayer4.setVisible(true); break;
		default: break;
		}
		
	}
	
}
