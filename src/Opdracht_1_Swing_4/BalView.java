package Opdracht_1_Swing_4;
import javax.swing.*;

import java.awt.*;


public class BalView extends JPanel 
{
   private Bal bal;
   
   private ValBewegingPaneel valpaneel;
   private ControlePaneelNoord noordpaneel;
   private DataView dataview;


   public BalView (Bal bal, ValBewegingPaneel valpaneel, ControlePaneelNoord noordpaneel)
   {
      setOpaque(false); // zet de 'ondoorzichtbaarheid' van de view 
      this.bal = bal;
      
      this.valpaneel = valpaneel; // valpaneel heeft een null-layout
      this.noordpaneel = noordpaneel;
      
      setSize (12, 12); 
      dataview = new DataView (bal);
      valpaneel.add (dataview);
   }
  
 
   
   
   public void paintComponent (Graphics g)
   {
      super.paintComponent(g);
      
      double schaalfactor_y = (valpaneel.getEindY() - valpaneel.getStartY()) / noordpaneel.getYbereik();
      double schaalfactor_x = (valpaneel.getEindX() - valpaneel.getStartX()) / noordpaneel.getXbereik();
      
      // de schaalfactor is het # pixels per meter 
      
      
      int x = (int) (valpaneel.getStartX() + bal.getX() * schaalfactor_x); 
      int y = (int) (valpaneel.getStartY() + bal.getY() * schaalfactor_y); 
 
      setLocation (x, y);

      g.setColor(bal.getKleur());
      g.fillOval (0, 0, 12, 12); // tov huidige paneel
      g.setColor (Color.BLACK);
      g.drawOval (0, 0, 12, 12); // accentuering van de rand
      
      dataview.repaint();
   }

}

