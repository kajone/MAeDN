package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.prefs.Preferences;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Einstellungen extends JFrame implements ActionListener{
	
	private JLabel spielFigur;
	private JLabel spielerName;
	private JTextField spielerNameEingabe;
	private JButton speichern;
	
	private String[] farben = {"gelb", "gruen", "rot", "schwarz"};
	private JComboBox<String> farbenAuswahl;

	public Einstellungen(String titel) {
		
		super(titel);

		
		this.setSize(400, 400);
		this.setLayout(null);
		this.setVisible(true);
		
		try{
		this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./images/EinstellungenBackground.jpg")))));
		} catch(IOException e){
			System.out.println("Image can't find");
		}
		this.setResizable(false);
		
		spielFigur = new JLabel();
		spielFigur.setBounds(40, 40, 100, 100);
		spielFigur.setText("Spielfigur: ");
		spielFigur.setFont(new Font("Arial",Font.BOLD, 18));
		this.add(spielFigur);
		
		farbenAuswahl = new JComboBox<String>(farben);
		farbenAuswahl.setBounds(250, 75, 100, 30);
		this.add(farbenAuswahl);
		
		spielerName = new JLabel();
		spielerName.setBounds(40, 270, 100, 40);
		spielerName.setText("Name: ");
		spielerName.setFont(new Font("Arial",Font.BOLD, 18));
		this.add(spielerName);
		
		//aktueller Spielername holen und als Standardwert ins Feld schreiben
		File file = new File("Einstellungen.txt");
		if(!file.exists()){
			// Wenn File nicht existiert, neu anlegen

			try {
				file.createNewFile();
				try {
					FileWriter fw = new FileWriter(file);
					fw.write("PlayerX\ngelb");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e) {
				System.out.println("Einstellungen.txt konnte nicht angelegt werden");;
			}
			
		}
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e1) {
			System.out.println("Es wurde noch keine Datei EInstellungen.txt angelegt");
		}
		int i = 0;
		String name = "";
			if(sc.hasNextLine()){
			name=sc.nextLine();
			}
		sc.close();

		
		spielerNameEingabe = new JTextField();
		spielerNameEingabe.setBounds(250, 280, 100, 20);
		spielerNameEingabe.setText(name);
		this.add(spielerNameEingabe);
		
		speichern = new JButton("Speichern");
		speichern.setBounds(150, 320, 100, 20);
		speichern.addActionListener(this);
		this.add(speichern);
		
			 	
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == speichern ){
			String spielername = spielerNameEingabe.getText();
			String farbe = (String) farbenAuswahl.getSelectedItem();
			System.out.println(farbe);
			System.out.println(spielername);
			
			Writer fw = null;

			try
			{
			  fw = new FileWriter( "Einstellungen.txt" );
			  fw.write(spielername + "\n" + farbe);
			}
			catch ( IOException e1 ) {
			  System.err.println( "Konnte Einstellungen.txt nicht überschreiben" );
			}
			finally {
			  if ( fw != null )
			    try { fw.close(); } catch ( IOException e1 ) { e1.printStackTrace(); }
			}
			
			this.dispose();
		}
	}
	

}
