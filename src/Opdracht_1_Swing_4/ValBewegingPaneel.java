package Opdracht_1_Swing_4;
import javax.swing.*;

import java.awt.*;

public class ValBewegingPaneel extends JPanel 
{
   

   private int startX, startY;
   private int eindX, eindY;
   private final int PARTS = 12; 
   // verdeel het paneel in 12 delen (inclusief rand-delen)
   
   private Stroke s_new;

   public ValBewegingPaneel(ValBewegingApp frame, ControlePaneelNoord noordpaneel)
   {
     setLayout (null);

     float [] dashes = {3.0f,7.0f}; 
     s_new = new BasicStroke(0.5f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1.0f,dashes,0);
     Bal bal = new Bal ();
     BalView balview = new BalView (bal, this, noordpaneel);
     BalController controller = new BalController (bal, balview, this, noordpaneel);
     add (balview);  
     ControlePaneelZuid zuidpaneel = new ControlePaneelZuid (bal, balview, controller);
     frame.add (zuidpaneel, BorderLayout.SOUTH); 
   }


   public void paintComponent (Graphics gr)
   {
      super.paintComponent(gr);
      Graphics2D g = (Graphics2D) gr;
      
      startX = getWidth() / PARTS;   // in pixels 
      startY = getHeight() / PARTS;  //
      eindX = (PARTS - 1) * startX;  //
      eindY = (PARTS - 1) * startY;  //
      
      
      g.setColor (Color.BLACK);
      g.drawLine (startX, startY, eindX, startY);
 
      g.setStroke(s_new);
      for (int te = 2; te <= (PARTS - 2); te++)
      {
         g.drawLine (startX, te * startY, eindX, te * startY);
         g.drawLine (te * startX, startY, te * startX, eindY);         
      } 
      g.setStroke(new BasicStroke());      
      g.drawLine (startX, eindY, eindX, eindY);

      
      g.setColor (Color.BLUE);     
      g.drawString ("0", startX - 10, startY + 10);
      
   }

   // start getters
   
     
   public int getStartX()
   {
     return (startX);
   }
   
   public int getStartY()
   {
      return (startY);
   }
   
   public int getEindX()
   {
      return (eindX);
   }
   
   public int getEindY()
   {
      return (eindY);
   }
   
   public int getPARTS()
   {
     return (PARTS);
   }    
   // end getters 
   
}










