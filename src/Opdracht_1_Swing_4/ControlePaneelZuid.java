package Opdracht_1_Swing_4;
import javax.swing.*;

import java.awt.event.*;


public class ControlePaneelZuid extends JPanel implements ActionListener
{
   private JButton animate;
   private JButton stop;

   private Bal bal;
   private BalView balview;
   private BalController controller;

   public ControlePaneelZuid (Bal bal, BalView balview, BalController controller) 
   {
      this.bal = bal;
      this.balview = balview;
      this.controller = controller;

      animate = new JButton ("animatie");
      animate.addActionListener(this);
      stop = new JButton ("stop");
      stop.addActionListener(this);
      
      add (animate);
      add (stop);
   }

   public void actionPerformed (ActionEvent ae)
   {
      if (ae.getSource() == stop)
         controller.pleaseStop();
      
      if (ae.getSource() == animate)
      {
         bal.reset();
         balview.repaint();
         controller.pleaseStart();
      }
   }

}
