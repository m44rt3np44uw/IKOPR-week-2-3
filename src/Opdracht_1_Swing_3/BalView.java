package Opdracht_1_Swing_3;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 


import javax.swing.*;
import java.awt.*;

public class BalView extends JPanel
{
   private Bal bal;
   
   private ValBewegingPaneel valpaneel;
   private ControlePaneelNoord noordpaneel;
   private DataView dataview;


   public BalView (Bal bal, ValBewegingPaneel valBewegingPaneel, ControlePaneelNoord controlePaneelNoord)
   {
      this.bal         = bal;
      this.valpaneel   = valBewegingPaneel;
      this.noordpaneel = controlePaneelNoord;

      // creeer het object dataview (wat geef je als parameter mee?)
      this.dataview    = new DataView(this.bal);

      // zet de 'ondoorzichtbaarheid' van de view op false; zie 'setOpaque' in de API; waarom?
      this.setOpaque(false);
      this.setLayout(null);

      // geef deze view een size van 12 bij 12 pixels
      this.setBounds(0, 0, 12, 12);

      // voeg de dataview toe aan het valpaneel
      this.valpaneel.add(this.dataview);
   }

   
   public void paintComponent (Graphics g)
   {
      super.paintComponent(g);
      
      double schaalfactor_y = (valpaneel.getEindY() - valpaneel.getStartY()) / noordpaneel.getYbereik();
      double schaalfactor_x = (valpaneel.getEindX() - valpaneel.getStartX()) / noordpaneel.getXbereik();
      
      // wat stelt zo'n schaalfactor nou precies voor? 
      // waarom staan deze instructies in deze methode en niet (bv) eenmalig in de constructor?
      // wat doen deze instructies?
      int x = (int) (valpaneel.getStartX() + bal.getX() * schaalfactor_x);
      int y = (int) (valpaneel.getStartY() + bal.getY() * schaalfactor_y);

      // plaats deze view op lokatie (x, y)
      this.setLocation(x, y);

      // zet de tekenkleur op de kleur van de bal
      g.setColor(this.bal.getKleur());

      // teken de bal
      g.fillOval(0, 0, 12, 12);

      // accentueer de rand van de bal
      g.drawOval(0,0, 12, 12);
      
      // zorg dat de dataview opnieuw getekend wordt iedere keer dat de balview 
      // opnieuw getekend wordt .... waarom?
      this.dataview.repaint();
   }

}

