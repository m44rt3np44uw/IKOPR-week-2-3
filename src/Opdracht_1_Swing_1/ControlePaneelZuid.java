package Opdracht_1_Swing_1;

import java.awt.FlowLayout;
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
   
   // bij het drukken op de stop-button wordt de controller 
   // verzocht de animatie te stoppen (bevriezen) 
   // bij het drukken op de animate-button wordt de bal gereset en dus ook ? 
   // verder wordt dan de controller verzocht de animatie opnieuw op te starten 

   public ControlePaneelZuid (Bal bal, BalView balview, BalController controller) 
   {
	   this.bal = bal;
	   this.balview = balview;
	   this.controller = controller;
	   this.animate = new JButton("animate");
	   this.stop = new JButton("Stop");
	   
	   this.setLayout(new FlowLayout());
	   
	   this.add(animate);
	   this.add(stop);
   }

   public void actionPerformed(ActionEvent ae)
   {
      if (ae.getSource() == this.stop){
    	  
      } else if (ae.getSource() == this.animate){
    	  
      }
   }

}
