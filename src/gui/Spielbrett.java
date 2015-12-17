package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Spielbrett extends JFrame implements ActionListener {
	
	private JLabel brett;
	private JButton gelbesHausObenLinks, gruenesHausObenLinks, rotesHausObenLinks, schwarzesHausObenLinks;
	private JButton gelbesHausObenRechts, gruenesHausObenRechts, rotesHausObenRechts, schwarzesHausObenRechts;
	private JButton gelbesHausUntenLinks, gruenesHausUntenLinks, rotesHausUntenLinks, schwarzesHausUntenLinks;
	private JButton gelbesHausUntenRechts, gruenesHausUntenRechts, rotesHausUntenRechts, schwarzesHausUntenRechts;
	private JButton feld0, feld1, feld2, feld3, feld4, feld5, feld6, feld7, feld8, feld9;
	private JButton feld10, feld11, feld12, feld13, feld14, feld15, feld16, feld17, feld18, feld19;
	private JButton feld20, feld21, feld22, feld23, feld24, feld25, feld26, feld27, feld28, feld29;
	private JButton feld30, feld31, feld32, feld33, feld34, feld35, feld36, feld37, feld38, feld39;
	private JButton feld40, feld41, feld42, feld43, feld44, feld45, feld46, feld47, feld48, feld49, feld50, feld51, feld52, feld53, feld54, feld55;
	
	public Spielbrett(String titel)
	{
		
		super(titel);
		
		this.setSize(600, 600);
		this.setLayout(null);
		this.setVisible(true);
		
		try{
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./images/spielbrett.jpg")))));
			} catch(IOException e){
				System.out.println("Image can't find");
			}
			this.setResizable(false);
			
		gelbesHausObenLinks = new JButton();
		gelbesHausObenLinks.setBounds(30, 20, 32, 32);
		this.buttonInitialisieren(gelbesHausObenLinks);
		
		gelbesHausObenRechts = new JButton();
		gelbesHausObenRechts.setBounds(80, 20, 32, 32);
		this.buttonInitialisieren(gelbesHausObenRechts);
		
		gelbesHausUntenLinks = new JButton();
		gelbesHausUntenLinks.setBounds(30, 70, 32, 32);
		this.buttonInitialisieren(gelbesHausUntenLinks);
		
		gelbesHausUntenRechts = new JButton();
		gelbesHausUntenRechts.setBounds(80, 70, 32, 32);
		this.buttonInitialisieren(gelbesHausUntenRechts);
		
		gruenesHausObenLinks = new JButton();
		gruenesHausObenLinks.setBounds(480, 20, 32, 32);
		this.buttonInitialisieren(gruenesHausObenLinks);
		
		gruenesHausObenRechts = new JButton();
		gruenesHausObenRechts.setBounds(530, 20, 32, 32);
		this.buttonInitialisieren(gruenesHausObenRechts);
		
		gruenesHausUntenLinks = new JButton();
		gruenesHausUntenLinks.setBounds(480, 70, 32, 32);
		this.buttonInitialisieren(gruenesHausUntenLinks);
		
		gruenesHausUntenRechts = new JButton();
		gruenesHausUntenRechts.setBounds(530, 70, 32, 32);
		this.buttonInitialisieren(gruenesHausUntenRechts);
		
		rotesHausObenLinks = new JButton();
		rotesHausObenLinks.setBounds(480, 470, 32, 32);
		this.buttonInitialisieren(rotesHausObenLinks);
		
		rotesHausObenRechts = new JButton();
		rotesHausObenRechts.setBounds(530, 470, 32, 32);
		this.buttonInitialisieren(rotesHausObenRechts);
		
		rotesHausUntenLinks = new JButton();
		rotesHausUntenLinks.setBounds(480, 520, 32, 32);
		this.buttonInitialisieren(rotesHausUntenLinks);
		
		rotesHausUntenRechts = new JButton();
		rotesHausUntenRechts.setBounds(530, 520, 32, 32);
		this.buttonInitialisieren(rotesHausUntenRechts);
		
		schwarzesHausObenLinks = new JButton();
		schwarzesHausObenLinks.setBounds(30, 470, 32, 32);
		this.buttonInitialisieren(schwarzesHausObenLinks);
		
		schwarzesHausObenRechts = new JButton();
		schwarzesHausObenRechts.setBounds(80, 470, 32, 32);
		this.buttonInitialisieren(schwarzesHausObenRechts);
		
		schwarzesHausUntenLinks = new JButton();
		schwarzesHausUntenLinks.setBounds(30, 520, 32, 32);
		this.buttonInitialisieren(schwarzesHausUntenLinks);
		
		schwarzesHausUntenRechts = new JButton();
		schwarzesHausUntenRechts.setBounds(80, 520, 32, 32);
		this.buttonInitialisieren(schwarzesHausUntenRechts);
		
		// Es wird am Startpunkt vom gelben Haus angefangen zu zaehlen
		feld0 = new JButton();
		feld0.setBounds(30, 215, 35, 40);
		this.buttonInitialisieren(feld0);
		
		feld1 = new JButton();
		feld1.setBounds(80, 215, 35, 40);
		this.buttonInitialisieren(feld1);
		
		feld2 = new JButton();
		feld2.setBounds(130, 215, 35, 40);
		this.buttonInitialisieren(feld2);
		
		feld3 = new JButton();
		feld3.setBounds(180, 215, 35, 40);
		this.buttonInitialisieren(feld3);
		
		feld4 = new JButton();
		feld4.setBounds(230, 215, 35, 40);
		this.buttonInitialisieren(feld4);
		
		feld5 = new JButton();
		feld5.setBounds(230, 165, 35, 40);
		this.buttonInitialisieren(feld5);
		
		feld6 = new JButton();
		feld6.setBounds(230, 115, 35, 40);
		this.buttonInitialisieren(feld6);
		
		feld7 = new JButton();
		feld7.setBounds(230, 65, 35, 40);
		this.buttonInitialisieren(feld7);
		
		feld8 = new JButton();
		feld8.setBounds(230, 15, 35, 40);
		this.buttonInitialisieren(feld8);
		
		feld9 = new JButton();
		feld9.setBounds(280, 15, 35, 40);
		this.buttonInitialisieren(feld9);
		
		//Startpunkt gruenes Haus
		feld10 = new JButton();
		feld10.setBounds(330, 15, 35, 40);
		this.buttonInitialisieren(feld10);
		
		feld11 = new JButton();
		feld11.setBounds(330, 65, 35, 40);
		this.buttonInitialisieren(feld11);
		
		feld12 = new JButton();
		feld12.setBounds(330, 115, 35, 40);
		this.buttonInitialisieren(feld12);
		
		feld13 = new JButton();
		feld13.setBounds(330, 165, 35, 40);
		this.buttonInitialisieren(feld13);
		
		feld14 = new JButton();
		feld14.setBounds(330, 215, 35, 40);
		this.buttonInitialisieren(feld14);
		
		feld15 = new JButton();
		feld15.setBounds(380, 215, 35, 40);
		this.buttonInitialisieren(feld15);
		
		feld16 = new JButton();
		feld16.setBounds(430, 215, 35, 40);
		this.buttonInitialisieren(feld16);
		
		feld17 = new JButton();
		feld17.setBounds(480, 215, 35, 40);
		this.buttonInitialisieren(feld17);
		
		feld18 = new JButton();
		feld18.setBounds(530, 215, 35, 40);
		this.buttonInitialisieren(feld18);
		
		feld19 = new JButton();
		feld19.setBounds(530, 265, 35, 40);
		this.buttonInitialisieren(feld19);
		
		//Startpunkt rotes Haus
		feld20 = new JButton();
		feld20.setBounds(530, 315, 35, 40);
		this.buttonInitialisieren(feld20);
		
		feld21 = new JButton();
		feld21.setBounds(480, 315, 35, 40);
		this.buttonInitialisieren(feld21);
		
		feld22 = new JButton();
		feld22.setBounds(430, 315, 35, 40);
		this.buttonInitialisieren(feld22);
		
		feld23 = new JButton();
		feld23.setBounds(380, 315, 35, 40);
		this.buttonInitialisieren(feld23);
		
		feld24 = new JButton();
		feld24.setBounds(330, 315, 35, 40);
		this.buttonInitialisieren(feld24);
		
		feld25 = new JButton();
		feld25.setBounds(330, 365, 35, 40);
		this.buttonInitialisieren(feld25);
		
		feld26 = new JButton();
		feld26.setBounds(330, 415, 35, 40);
		this.buttonInitialisieren(feld26);
		
		feld27 = new JButton();
		feld27.setBounds(330, 465, 35, 40);
		this.buttonInitialisieren(feld27);
		
		feld28 = new JButton();
		feld28.setBounds(330, 515, 35, 40);
		this.buttonInitialisieren(feld28);
		
		feld29 = new JButton();
		feld29.setBounds(280, 515, 35, 40);
		this.buttonInitialisieren(feld29);
		
		//Startpunkt schwarzes Haus
		feld30 = new JButton();
		feld30.setBounds(230, 515, 35, 40);
		this.buttonInitialisieren(feld30);

		feld31 = new JButton();
		feld31.setBounds(230, 465, 35, 40);
		this.buttonInitialisieren(feld31);
		
		feld32 = new JButton();
		feld32.setBounds(230, 415, 35, 40);
		this.buttonInitialisieren(feld32);
		
		feld33 = new JButton();
		feld33.setBounds(230, 365, 35, 40);
		this.buttonInitialisieren(feld33);
		
		feld34= new JButton();
		feld34.setBounds(230, 315, 35, 40);
		this.buttonInitialisieren(feld34);
		
		feld35= new JButton();
		feld35.setBounds(180, 315, 35, 40);
		this.buttonInitialisieren(feld35);
		
		feld36 = new JButton();
		feld36.setBounds(130, 315, 35, 40);
		this.buttonInitialisieren(feld36);
		
		feld37 = new JButton();
		feld37.setBounds(80, 315, 35, 40);
		this.buttonInitialisieren(feld37);
	
		feld38 = new JButton();
		feld38.setBounds(30, 315, 35, 40);
		this.buttonInitialisieren(feld38);
		
		feld39 = new JButton();
		feld39.setBounds(30, 265, 35, 40);
		this.buttonInitialisieren(feld39);
		
		//Endhaus gelb
		feld40 = new JButton();
		feld40.setBounds(80, 265, 35, 40);
		this.buttonInitialisieren(feld40);
		
		feld41 = new JButton();
		feld41.setBounds(130, 265, 35, 40);
		this.buttonInitialisieren(feld41);
		
		feld42 = new JButton();
		feld42.setBounds(180, 265, 35, 40);
		this.buttonInitialisieren(feld42);
		
		feld43 = new JButton();
		feld43.setBounds(230, 265, 35, 40);
		this.buttonInitialisieren(feld43);
		
		//Endhaus gruen
		feld44 = new JButton();
		feld44.setBounds(280, 65, 35, 40);
		this.buttonInitialisieren(feld44);
		
		feld45 = new JButton();
		feld45.setBounds(280, 115, 35, 40);
		this.buttonInitialisieren(feld45);
		
		feld46 = new JButton();
		feld46.setBounds(280, 165, 35, 40);
		this.buttonInitialisieren(feld46);
		
		feld47 = new JButton();
		feld47.setBounds(280, 215, 35, 40);
		this.buttonInitialisieren(feld47);
		
		//Endhaus rot
		feld48 = new JButton();
		feld48.setBounds(480, 265, 35, 40);
		this.buttonInitialisieren(feld48);
		
		feld49 = new JButton();
		feld49.setBounds(430, 265, 35, 40);
		this.buttonInitialisieren(feld49);
		
		feld50 = new JButton();
		feld50.setBounds(380, 265, 35, 40);
		this.buttonInitialisieren(feld50);
		
		feld51 = new JButton();
		feld51.setBounds(330, 265, 35, 40);
		this.buttonInitialisieren(feld51);
		
		//Endhaus schwarz
		feld52 = new JButton();
		feld52.setBounds(280, 465, 35, 40);
		this.buttonInitialisieren(feld52);
		
		feld53 = new JButton();
		feld53.setBounds(280, 415, 35, 40);
		this.buttonInitialisieren(feld53);
		
		feld54 = new JButton();
		feld54.setBounds(280, 365, 35, 40);
		this.buttonInitialisieren(feld54);
		
		feld55 = new JButton();
		feld55.setBounds(280, 315, 35, 40);
		this.buttonInitialisieren(feld55);
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
	}
	
	public void buttonInitialisieren(JButton button)
	{
		button.addActionListener(this);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		this.add(button);
	}

}
