package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOver  extends JFrame implements ActionListener{
	
	private String winner;
	private boolean thisPlayer = false;
	private JLabel winnerLb, winningText;
	private JButton beendenButton;
	
	public GameOver(String title, String winner, boolean thisPlayer) {
		super(title);
		
		this.winner = winner;
		this.thisPlayer = thisPlayer;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
		this.setSize(600, 200);
		showContent();
	}

	private void showContent() {
		winnerLb = new JLabel("");
		winnerLb.setBounds(200, 30, 600, 20);
		getContentPane().add(winnerLb);
		winnerLb.setText(this.winner + " hat das Spiel gewonnen!");
	
		winningText = new JLabel("");
		winningText.setBounds(100, 80, 600, 20);
		getContentPane().add(winningText);
		
		beendenButton = new JButton("Beenden");
		beendenButton.addActionListener(this);
		beendenButton.setBounds(238, 128, 89, 23);
		getContentPane().add(beendenButton);
		if(thisPlayer)winningText.setText("Herzlichen Glückwunsch, du konntest dich gegen die Konkurrenz durchsetzen!");
		else{
			winningText.setText("Leider hat es nicht zum Sieg gereicht. Streg dich nächstes mal mehr an!");
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == beendenButton){
			this.dispose();
		}
	}
}
