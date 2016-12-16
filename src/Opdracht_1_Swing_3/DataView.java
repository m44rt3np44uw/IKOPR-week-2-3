package Opdracht_1_Swing_3;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class DataView extends JPanel implements MouseMotionListener, MouseListener, MouseWheelListener
{

   private Bal bal;  
   private final int MINHOOGTE = 17; // minmale hoogte van dit view
   private int hoogte;               // actuele hoogte van dit view
   
   private int x, y;
   private boolean dragged = false;
   private int dragX, dragY;
   
   

   public DataView (Bal bal)
   {
      this.setLayout(null);
      this.bal = bal;
      this.hoogte = 100;

      // zet de achtergrondkleur van dit view op oranje
      this.setBackground(Color.orange);

      // voeg verschillende MouseListeners toe aan dit view
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      this.addMouseWheelListener(this);
      
      Border titelrand = new TitledBorder(null, "ball-data", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 10), Color.black); // view met een rand en titel "bal-data"
                         // zie (bv in de API) de klasse BorderFactory en 
                         // de methode createTitledBorder 
      this.setBorder (titelrand);
      
      this.setBounds (250, 75, 180, hoogte); // wat doet dit statement?
   }


   
   public void paintComponent (Graphics g)
   {
      super.paintComponent(g);
      if ((x != 0) && (y != 0)) {
         setLocation (x, y);
      }

      String st_t = String.format ("%.2f", bal.getT() / 1000.0);
      // wat doet dit statement precies?
      // waarom wordt er door 1000.0 gedeeld?

      String st_y  = String.format("%.2f", this.bal.getY());   // idem, maar nu met de actuele, afgelegde afstand van de bal
      String st_vy = String.format("%.2f", this.bal.getVy());  // idem, maar nu met de actuele snelheid van de bal

      // zet de schrijfkleur op blauw
      g.setColor(Color.BLUE);

      // druk tijd (in sec), afgelegde weg (in meter) en snelheid (in meter/sec) netjes
      // onder elkaar af in deze view
      g.drawString("tijd = " + st_t + " sec", 10, 30);
      g.drawString("afgelegde weg = " + st_y + " m", 10, 50);
      g.drawString("snelheid = " + st_vy + " m/s", 10, 70);
   }
   
   // MouseWheelListener-method
   public void mouseWheelMoved (MouseWheelEvent ev)
   {
   	  int ticks = ev.getWheelRotation();
   	  // pas de hoogte van deze view aan mbv de waarde 'ticks'
   	  // De minmale hoogte moet MINHOOGTE zijn

      if(this.hoogte >= MINHOOGTE)
      {
         this.hoogte = this.getHeight() + ticks;
         this.setSize(180, this.hoogte);
      }

      else
      {
         this.hoogte = this.getHeight() + Math.abs(ticks);
         this.setSize(180, this.hoogte);
      }
   	  
   }
   
   // MouseListener-methods
   public void mouseClicked (MouseEvent me) {}
   public void mouseEntered (MouseEvent me) {}
   public void mouseExited  (MouseEvent me) {}
   // waarom staan deze methoden hier? 
   // als ze niets doen dan kan je ze toch beter gewoon weglaten? 
   
     
   public void mouseReleased (MouseEvent me)
   {
       this.dragged = false;  // zie ook mouseDragged
   }
   
   public void mousePressed (MouseEvent me) // wat moet deze methode hier? 
   {}
   
   // MouseMotionListener-methods   
   public void mouseDragged (MouseEvent me)
   {
      // zie aan de hand van het Vierkanten-voorbeeld
      // hoe je de view kan verplaatsen (tweede werkcollege, week 1) 
      // maak gebruik van de eigenschappen 'dragX', 'dragY' en 'dragged'

      if(this.dragged)
      {
         this.dragged = true;
         this.dragX = me.getX();
         this.dragY = me.getY();
      }

      this.x = getX() + me.getX() - this.dragX;
      this.y = getY() + me.getY() - this.dragY;

      this.setLocation(x, y);
         
   }
   
   public void mouseMoved (MouseEvent me) // wat moet deze methode hier? 
   {}       
   
}


