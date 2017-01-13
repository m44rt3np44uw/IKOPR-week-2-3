package Opdracht_1_Swing_4;


import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class DataView extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener
{

   private Bal bal;  
   private final int MINHOOGTE = 125;
   private int hoogte;
   
   private int x, y;
   private boolean dragged = false;
   private int dragX, dragY;
   
   

   public DataView (Bal bal)
   {
      setBackground (Color.ORANGE);
      this.bal = bal;
      this.hoogte = MINHOOGTE;
          
      addMouseListener(this);
      addMouseMotionListener(this);
      addMouseWheelListener(this);
      
      Border titelrand = BorderFactory.createTitledBorder("bal-data");
      this.setBorder (titelrand);
      
      setBounds (300, 50, 180, hoogte);
   }


   
   public void paintComponent (Graphics g)
   {
      super.paintComponent(g);
      if ((x != 0) && (y != 0))
         setLocation (x, y);
                      
      String st_t = String.format ("%.2f", bal.getT() / 1000.0); 
      String st_y = String.format ("%.2f", bal.getY()); 
      String st_vy = String.format ("%.2f", bal.getVy()); 

      g.setColor(Color.BLUE);      
      g.drawString (" tijd = " + st_t + " sec", 12, 3 * 12);
      g.drawString (" afgelegde weg = " + st_y + " m", 12, 5 * 12);
      g.drawString (" snelheid = " + st_vy + " m/s", 12, 7 * 12);
      
   }
   
   // MouseWheelListener-method
   public void mouseWheelMoved (MouseWheelEvent ev)
   {
   	  int ticks = ev.getWheelRotation();
   	  hoogte +=  5 * ticks;
   	  if (hoogte < MINHOOGTE)
   	    hoogte = MINHOOGTE;
   	  setSize (getWidth(), hoogte); 
   	  
   }
   
   // MouseListener-methods
   public void mouseClicked (MouseEvent me)
   {}
   public void mouseEntered (MouseEvent me)
   {
       //setOpaque (false);
       //repaint();
   }
   
   public void mouseExited (MouseEvent me)
   {
       //setOpaque (true);
       //repaint();
   }
   
   public void mouseReleased (MouseEvent me)
   {
       dragged = false;
   }
   
   public void mousePressed (MouseEvent me)
   {}
   
   // MouseMotionListener-methods   
   public void mouseDragged (MouseEvent me)
   {
      if (!dragged)
      {
         dragged = true;
         dragX = me.getX();
         dragY = me.getY();
      }
      x += me.getX() - dragX;
      y += me.getY() - dragY;
      
      repaint();
         
   }
   
   public void mouseMoved (MouseEvent me)
   {}       
   
}


