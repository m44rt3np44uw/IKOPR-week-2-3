package Opdracht_1_Swing_1;

import javax.swing.JPanel;
import javax.swing.JTextField;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 


public class ControlePaneelNoord extends JPanel
{
   private JTextField bereikXveld;
   private JTextField bereikYveld;
   private JTextField dtVeld;

   // geef de velden bereikXveld en bereikYveld default 
   // de waarden 100 (meter)
   
   // geeft het dtVeld (steptime) default de waarde 20 (msec) 
   // geef bij verkeerde invoer van de gebruiker de default-waarden
   // weer en gebruk daartoe een try-catch-clause 
   

   public ControlePaneelNoord()
   {
	   this.bereikXveld = new JTextField("100", 5);
	   this.bereikYveld = new JTextField("100", 5);
	   this.dtVeld = new JTextField("20", 5);
	   this.add(bereikXveld);
	   this.add(bereikYveld);
	   this.add(dtVeld);
   }

   public double getYbereik()
   {
	   try{
		   return Integer.parseInt(this.bereikYveld.getText());
	   } catch (NumberFormatException e) {
		   return 100;
	   }
    		  
   }

   public double getXbereik()
   {
	   try{
		   return Integer.parseInt(this.bereikXveld.getText());
	   } catch (NumberFormatException e){
		   return 100;
	   }  
   }


   public int getDt()
   {
	   try{
		   return Integer.parseInt(this.dtVeld.getText());
	   } catch (NumberFormatException e){
		   return 20;
	   }
   }
   
   // wat zou je kunnen doen om tijdens de animatie het gebruik van 
   // de invoervelden onmogelijk te maken? 

}
