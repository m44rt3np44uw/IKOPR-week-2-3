package Opdracht_1_Swing_4;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BalController implements Runnable, MouseWheelListener
{
   private Bal bal;
   private BalView balview;
   private ControlePaneelNoord noordpaneel;
   
   private boolean doorgaan_thread;
   private boolean doorgaan_wheel;
   
   private int dt;  // steptime & sleeptime in msec
   private double valhoogte; // in meter 
   
   private Thread draad;
   
   

   public BalController (Bal bal, BalView balview, ValBewegingPaneel valpaneel, ControlePaneelNoord noordpaneel)
   {
      this.bal = bal;
      this.balview = balview;
      this.noordpaneel = noordpaneel;
      valpaneel.addMouseWheelListener(this);
      doorgaan_thread = false;
      doorgaan_wheel = false;
      
      this.dt = noordpaneel.getDt();
      this.valhoogte = noordpaneel.getYbereik();
   }

   public void run()
   {      
      while (doorgaan_thread)
      {      
         if (bal.getY() > valhoogte)
         {
            pleaseStop();
            return;
         }
         else
         {
            slaap (dt);            
            bal.adjust(dt);
         }
         balview.repaint();
      }
   }


   public void mouseWheelMoved (MouseWheelEvent event)
   {      
      if ((!doorgaan_thread) && doorgaan_wheel)
      {
        int ticks = event.getWheelRotation();
        
        if ((bal.getY() <  valhoogte) && (bal.getT() > 0) )
           bal.adjust (ticks * dt);
        else
          return;
           
        balview.repaint();
      }
   }

   public void pleaseStart()
   {
       if (draad != null)
          return;
          
       this.dt = noordpaneel.getDt();
       this.valhoogte = noordpaneel.getYbereik();
       
       doorgaan_thread = true;
       doorgaan_wheel = false;
           
       draad = new Thread (this);
       draad.start();
   }

   public void pleaseStop()
   {
      doorgaan_thread = false;
      doorgaan_wheel = true;      
      draad = null;
   }

   private void slaap (int msec)
   {
      try
      {
         Thread.sleep (msec);
      }
      catch (InterruptedException ex)
      {
      }
   }
   
}








