package Opdracht_1_Swing_3;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 


import javax.swing.*;

public class ControlePaneelNoord extends JPanel
{
   private JTextField bereikXveld;
   private JTextField bereikYveld;
   private JTextField dtVeld;

   private JLabel x;
   private JLabel y;
   private JLabel dt;
   
   private static final int x_standaard  = 100;
   private static final int y_standaard  = 100;
   private static final int dt_standaard = 20;

   // geef de velden bereikXveld en bereikYveld default 
   // de waarden 100 (meter)
   // geeft het dtVeld (steptime) default de waarde 20 (msec) 
   // geef bij verkeerde invoer van de gebruiker de default-waarden
   // weer en gebruk daartoe een try-catch-clause 
   

   public ControlePaneelNoord()
   {
      this.bereikXveld = new JTextField(Integer.toString(x_standaard),  5);
      this.bereikYveld = new JTextField(Integer.toString(y_standaard),  5);
      this.dtVeld      = new JTextField(Integer.toString(dt_standaard), 5);

      this.x  = new JLabel("x");
      this.y  = new JLabel("y");
      this.dt = new JLabel("dt");

      this.add(this.x);
      this.add(this.bereikXveld);

      this.add(y);
      this.add(this.bereikYveld);

      this.add(dt);
      this.add(this.dtVeld);
   }

   public double getYbereik()
   {
      try {
         return Math.abs(Integer.parseInt(this.bereikYveld.getText()));
      } catch (Exception e) {
         return y_standaard;
      }
   }

   public double getXbereik()
   {
      try {
         return Math.abs(Integer.parseInt(this.bereikXveld.getText()));
      } catch (Exception e) {
         return x_standaard;
      }
   }


   public int getDt()
   {
      try {
         return Math.abs(Integer.parseInt(this.dtVeld.getText()));
      } catch (Exception e) {
         return dt_standaard;
      }
   }

    // wat zou je kunnen doen om tijdens de animatie het gebruik van
   // de invoervelden onmogelijk te maken?
   public void inactief()
   {
      this.bereikXveld.setEditable(false);
      this.bereikYveld.setEditable(false);
      this.dtVeld.setEditable(false);
   }

   public void actief()
   {
      this.bereikXveld.setEditable(true);
      this.bereikYveld.setEditable(true);
      this.dtVeld.setEditable(true);
   }

}
