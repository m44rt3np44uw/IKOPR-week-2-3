package Opdracht_1_Swing_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 


public class ControlePaneelZuid extends JPanel implements ActionListener
{
	private JButton animate;
	private JButton stop;
	

	private Bal bal;
	private BalView balview;
	private BalController controller;
	private ValBewegingPaneel vbp;

	// bij het drukken op de stop-button wordt de controller 
	// verzocht de animatie te stoppen (bevriezen) 
	// bij het drukken op de animate-button wordt de bal gereset en dus ook ? 
	// verder wordt dan de controller verzocht de animatie opnieuw op te starten 

	public ControlePaneelZuid (Bal bal, BalView bv, BalController bc, ValBewegingPaneel vbp) 
	{
		this.bal = bal;
		this.balview = bv;
		this.controller = bc;
		this.vbp = vbp;
		animate = new JButton("Start");
		stop = new JButton("Stop");
		
		animate.addActionListener(this);
		stop.addActionListener(this);
		
		add(animate);
		add(stop);
		
	}

	public void actionPerformed (ActionEvent e)
	{
		if(e.getSource() == animate)
		{
			controller.pleaseStart();
			vbp.repaint();

		}
		if(e.getSource() == stop)
		{
			controller.pleaseStop();
			vbp.repaint();
			balview.repaint();
		}

		
	}

}
