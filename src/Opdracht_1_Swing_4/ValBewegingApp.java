package Opdracht_1_Swing_4;
import javax.swing.*;
import java.awt.*;

public class ValBewegingApp extends JFrame
{

   public ValBewegingApp()  // constructor
   {
      setSize (500, 600);
      setTitle ("valbeweging");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      ControlePaneelNoord noordpaneel = new ControlePaneelNoord();
      ValBewegingPaneel valpaneel = new ValBewegingPaneel (this, noordpaneel);

      add (noordpaneel, BorderLayout.NORTH);
      add (valpaneel, BorderLayout.CENTER);
      setLocationRelativeTo(null);
      setVisible(true);
   }

   public static void main (String [] args)
   {
      new ValBewegingApp();
   }

}
