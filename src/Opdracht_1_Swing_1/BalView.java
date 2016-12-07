package Opdracht_1_Swing_1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 

public class BalView extends JPanel {
	private Bal bal;

	private ValBewegingPaneel valpaneel;
	private ControlePaneelNoord noordpaneel;
	private DataView dataview;

	public BalView(Bal bal, ValBewegingPaneel valpaneel, ControlePaneelNoord noordpaneel) {
		// zet de 'ondoorzichtbaarheid' van de view op false; zie 'setOpaque' in
		// de API; waarom?
		// geef deze view een size van 12 bij 12 pixels
		// creeer het object dataview (wat geef je als parameter mee?)
		// voeg de dataview toe aan het valpaneel
		this.setOpaque(false);
		this.setSize(12, 12);
		this.noordpaneel = noordpaneel;
		this.bal = bal;	
		this.valpaneel = valpaneel;
		this.dataview = new DataView(this.bal);
	
		this.valpaneel.add(this.dataview);
	}

public void paintComponent (Graphics g)
   {
      super.paintComponent(g);
      
      double schaalfactor_y = (valpaneel.getEindY() - valpaneel.getStartY()) / noordpaneel.getYbereik();
      double schaalfactor_x = (valpaneel.getEindX() - valpaneel.getStartX()) / noordpaneel.getXbereik();
      
      // wat stelt zo'n schaalfactor nou precies voor? 
      // waarom staan deze instructies in deze methode en niet (bv) eenmalig in de constructor? 
      
      
      
      int x = (int) (valpaneel.getStartX() + bal.getX() * schaalfactor_x); 
      int y = (int) (valpaneel.getStartY() + bal.getY() * schaalfactor_y); 
      // wat doen deze instructies?  
 
      // plaats deze view op locatie (x, y) 
      this.setLocation(x, y);

      // zet de tekenkleur op de kleur van de bal
      // teken de bal 
      // accentueer de rand van de bal
      g.setColor(this.bal.getKleur());
      g.fillOval(x, y, 12, 12);
      g.drawOval(x, y, 12, 12);
      // zorg dat de dataview opnieuw getekend wordt iedere keer dat de balview 
      // opnieuw getekend wordt .... waarom? 
      this.dataview.repaint();
   }

}
