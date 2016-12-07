package Opdracht_1_Swing_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 



public class DataView extends JPanel implements MouseListener, MouseWheelListener
{

   private Bal bal;  
   private final int MINHOOGTE = 17; // minmale hoogte van dit view
   private int hoogte;               // actuele hoogte van dit view
   
   private int x, y;
   private boolean dragged = false;
   private int dragX, dragY;
   
   

   public DataView (Bal bal)
   {
      // zet de achtergrondkleur van dit view op oranje
      // voeg verschillende MouseListeners toe aan dit view 
	   this.setBackground(Color.ORANGE);
	   this.addMouseListener(this);
	   this.addMouseWheelListener(this);
      
      Border titelrand = BorderFactory.createTitledBorder("bal-data");
    		  			 // view met een rand en titel "bal-data"
                         // zie (bv in de API) de klasse BorderFactory en 
                         // de methode createTitledBorder 
      this.setBorder(titelrand);
      
      setBounds (0, 0, 180, hoogte); // wat doet dit statement? 
   }


   
   public void paintComponent (Graphics g)
   {
      super.paintComponent(g);
      if ((x != 0) && (y != 0))
         setLocation (x, y);
                      
      String st_t = String.format ("%.2f", bal.getT() / 1000.0);
      // wat doet dit statement precies?
      // waarom wordt er door 1000.0 gedeeld?
       
      String st_y = String.format("%.2f", bal.getY() / 1000.0);// idem, maar nu met de actuele, afgelegde afstand van de bal 
      String st_vy = String.format("%.2f", bal.getVy() / 1000.0);// idem, maar nu met de actuele snelheid van de bal 

      // zet de schrijfkleur op blauw       
      // druk tijd (in sec), afgelegde weg (in meter) en snelheid (in meter/sec) netjes
      // onder elkaar af in deze view
      g.setColor(Color.BLUE);
      g.drawString(st_t, x, y);
      g.drawString(st_y, x, y);
      g.drawString(st_vy, x, x);
      
   }
   
   // MouseWheelListener-method
   public void mouseWheelMoved (MouseWheelEvent ev)
   {
   	  int ticks = ev.getWheelRotation();
   	  // pas de hoogte van deze view aan mbv de waarde 'ticks'
   	  // De minmale hoogte moet MINHOOGTE zijn
   	  if(this.getHeight() > this.MINHOOGTE){
   		  this.setSize(this.getWidth(), this.getHeight() + ticks);
   	  } else {
   		  System.out.println("eh G niet schalen");
   	  }
   }
   
   // MouseListener-methods
   public void mouseClicked (MouseEvent me)
   {}
   public void mouseEntered (MouseEvent me)
   {}  
   public void mouseExited (MouseEvent me)
   {}
   // waarom staan deze methoden hier? 
   // als ze niets doen dan kan je ze toch beter gewoon weglaten? 
   
     
   public void mouseReleased (MouseEvent me)
   {
       this.dragged = false;  // zie ook mouseDragged 
   }
   
   public void mousePressed (MouseEvent me) // wat moet deze methode hier? 
   {}
   
   // MouseMotionListener-methods   
   public void mouseDragged(MouseEvent me)
   {
	   if(!this.dragged){
		   dragged = true;
		   this.dragX = me.getX();
		   this.dragY = me.getY();
	   }
	   this.setLocation(this.dragX, this.dragY);
      // zie aan de hand van het Vierkanten-voorbeeld
      // hoe je de view kan verplaatsen (tweede werkcollege, week 1) 
      // maak gebruik van de eigenschappen 'dragX', 'dragY' en 'dragged' 
	   /*
	    if (!dragged)
	    {
	      dragged = true;
	      dragAnkerX = event.getX();
	      dragAnkerY = event.getY();
	    }
	    int x = view.getX() + event.getX() - dragAnkerX;
	    int y = view.getY() + event.getY() - dragAnkerY;
	    view.setLocation( x, y );
         */
   }
   
   public void mouseMoved (MouseEvent me) // wat moet deze methode hier? 
   {}       
   
}


