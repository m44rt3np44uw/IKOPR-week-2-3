package Opdracht_1_Swing_4;
import javax.swing.*;

public class ControlePaneelNoord extends JPanel
{
   private JTextField bereikXveld;
   private JTextField bereikYveld;
   private JTextField dtVeld;
   

   public ControlePaneelNoord()
   {
      bereikXveld = new JTextField ("100", 4);
      bereikYveld = new JTextField ("100", 4);
      dtVeld = new JTextField ("20", 4); 

      add (new JLabel (" x "));
      add (bereikXveld);
      add (new JLabel (" y "));
      add (bereikYveld);
      add (new JLabel ("dt (ms)"));
      add (dtVeld);
   }

   public double getYbereik()
   {
     try
     {
        return (Double.parseDouble (bereikYveld.getText()));
     }
     catch (Exception ex)
     {
        bereikYveld.setText("100");
        return (100);
     }
   }

   public double getXbereik()
   {
     try
     {
        return (Double.parseDouble (bereikXveld.getText()));
     }
     catch (Exception ex)
     {
        bereikXveld.setText("100");
        return (100);
     }
   }


   public int getDt()
   {
     try
     {
        return (Integer.parseInt (dtVeld.getText()));
     }
     catch (Exception ex)
     {
        dtVeld.setText("20");
        return (20);
     }
   }
   
   public JTextField getXfield()
   {
      return (bereikXveld);
   }
   
   public JTextField getYfield()
   {
     return (bereikYveld);
   }

}
