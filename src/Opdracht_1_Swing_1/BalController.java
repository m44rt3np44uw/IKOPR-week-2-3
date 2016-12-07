package Opdracht_1_Swing_1;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 


public class BalController implements Runnable, MouseWheelListener
{
   private Bal bal;
   private BalView balview;   // wat zou je hier private declareren?
   private ValBewegingPaneel valpaneel;  // denk aan MVC 
   private ControlePaneelNoord noordpaneel;
   
   private boolean doorgaan_thread; // thread aan/uit
   private boolean doorgaan_wheel;  // 'verplaatsen van de bal met het wieltje' aan/uit
   
   private int dt;  // steptime & sleeptime in msec
                    // en wat betekent het als ze gelijk zijn? 
   private double valhoogte; // in meter 
   
   private Thread draad;
   
   

   public BalController(Bal bal, BalView balview, ValBewegingPaneel valpaneel, ControlePaneelNoord noordpaneel)
   {
	   this.bal = bal;
	   this.balview = balview;
	   this.valpaneel = valpaneel;
	   this.noordpaneel = noordpaneel;
      // geef valpaneel een MouseWheelListener en laat het
      // BalController (dit) object de events afhandelen 
	   this.valpaneel.addMouseWheelListener(this);
      // zet de thread uit en zet 'het verplaatsen van de bal
      // mbv het wieltje' uit
	   this.doorgaan_thread = false;
	   this.doorgaan_wheel = false;
      // initialiseer this.dt .. welk object gebruik je daarvoor?
      // initialiseer this.valhoogte .. welk object gebruik je daarvoor?
	   this.dt = this.noordpaneel.getDt();
	   this.valhoogte = this.noordpaneel.getYbereik();
   }


public void run() // waar komt deze methode vandaan hoe en waar wordt hij aangeroepen? 
   {      
      while (doorgaan_thread)
      {      
         if(this.bal.getY() <= 0) // laat de thread stoppen als de bal de bodem bereikt
         {
            pleaseStop();
            return;
         }
         else
         {
            // las een pauze in van 'dt'msec
            // pas de eigenschap 'dt' van de bal aan
        	 this.slaap(this.dt);
        	 this.bal.adjust(this.dt);
         }
         this.balview.repaint(); // niet vergeten opnieuw ... ? 
      }
   }


   public void mouseWheelMoved (MouseWheelEvent event)
   {      
      if (this.doorgaan_thread == false && this.doorgaan_wheel == true)     
    	  		// deze methode alleen uitvoeren als de thread uitstaat EN
      {         // 'het verplaatsen mbv het wieltje' aan
      
        int ticks = event.getWheelRotation(); // wat levert dit op? 
        
        if ((bal.getY() <  valhoogte) && (bal.getT() > 0) ) {// waarom deze conditie?
           // pas de bal aan en gebruik 'ticks' en 'dt'

        } else {
          return;
        }
        this.balview.repaint(); // niet vergeten opnieuw ... ? 
      }
   }

   public void pleaseStart()
   {
       if (draad != null) return;
          
       // initialiseer 'dt'en 'valhoogte'
       this.dt = this.noordpaneel.getDt();
       this.valhoogte = this.noordpaneel.getYbereik();
       
       this.doorgaan_thread = true;
       this.doorgaan_wheel = false;
       // zet de thread aan en de 'verplaatsing mbv
       // van het wieltje' uit
           
       draad = new Thread();// creeer een nieuw Thread-object 
       // start de thread .. welke methode wordt daarna dus aangeroepen? 
       draad.start();
   }


   public void pleaseStop()
   {
      // thread uit en 'verplaatsing mbv het wieltje' aan  
	   this.doorgaan_thread = false;
	   this.doorgaan_wheel = true;
      draad = null; // waarom? 
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








