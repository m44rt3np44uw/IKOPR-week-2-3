package Opdracht_1_Swing_3;


import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code.



public class BalController implements Runnable, MouseWheelListener
{
   private Bal bal;
   private BalView balView;                         // wat zou je hier private declareren?
   private ValBewegingPaneel valBewegingPaneel;     // denk aan MVC
   private ControlePaneelNoord controlePaneelNoord;
   
   private boolean doorgaan_thread;                 // thread aan/uit
   private boolean doorgaan_wheel;                  // 'verplaatsen van de bal met het wieltje' aan/uit
   
   private int dt;                                  // steptime & sleeptime in msec
                                                    // en wat betekent het als ze gelijk zijn?
   private double valhoogte;                        // in meter
   
   private Thread draad;
   
   

   public BalController (Bal bal, BalView balView, ValBewegingPaneel valBewegingPaneel, ControlePaneelNoord controlePaneelNoord)
   {
      this.bal                 = bal;
      this.balView             = balView;
      this.valBewegingPaneel   = valBewegingPaneel;
      this.controlePaneelNoord = controlePaneelNoord;

      // geef valpaneel een MouseWheelListener en laat het
      // BalController (dit) object de events afhandelen
      this.valBewegingPaneel.addMouseWheelListener(this);


      // zet de thread uit en zet 'het verplaatsen van de bal
      // mbv het wieltje' uit
      this.doorgaan_thread = false;
      this.doorgaan_wheel  = false;

      // initialiseer this.dt .. welk object gebruik je daarvoor?
      this.dt = this.controlePaneelNoord.getDt();

      // initialiseer this.valhoogte .. welk object gebruik je daarvoor?
      this.valhoogte = valBewegingPaneel.getEindY();
   }

   public void run() // waar komt deze methode vandaan hoe en waar wordt hij aangeroepen? 
   {      
      while (this.doorgaan_thread)
      {
         if (this.bal.viewAdjust(this.dt) >= this.controlePaneelNoord.getYbereik()) // laat de thread stoppen als de bal de bodem bereikt
         {
            this.pleaseStop();
            return;
         }

         this.slaap(this.dt);        // las een pauze in van 'dt'msec
         this.bal.adjust(this.dt);   // pas de eigenschap 'dt' van de bal aan

         this.balView.repaint();        // niet vergeten opnieuw ... ?
      }
   }


   public void mouseWheelMoved (MouseWheelEvent event)
   {      
      if (this.doorgaan_wheel && !this.doorgaan_thread)      // deze methode alleen uitvoeren als de thread uitstaat EN
      {
         // 'het verplaatsen mbv het wieltje' aan
         int ticks = event.getWheelRotation();               // wat levert dit op?

         this.dt = this.controlePaneelNoord.getDt();

        if ((bal.getY() <  valhoogte) && (bal.getT() > 0) )  // waarom deze conditie?
        {
           if(ticks > 0)
           {
              this.bal.adjust(this.dt);                      // pas de bal aan en gebruik 'ticks' en 'dt'
           }

           else
           {
              this.bal.adjust(-this.dt);
           }
        }
        else
        {
          return;
        }

        this.balView.repaint();                              // niet vergeten opnieuw ... ?
      }
   }

   public void pleaseStart()
   {
      if (draad != null) {
         return;
      }

      // initialiseer 'dt'en 'valhoogte'
      this.valhoogte = this.valBewegingPaneel.getEindY();
      this.dt        = this.controlePaneelNoord.getDt();
       
      // zet de thread aan en de 'verplaatsing mbv
      this.doorgaan_thread = true;

      // van het wieltje' uit
      this.doorgaan_wheel = false;
           
       draad = new Thread(this);                     // creeer een nieuw Thread-object

      // start de thread .. welke methode wordt daarna dus aangeroepen?
      this.controlePaneelNoord.inactief();

      draad.start();
   }


   public void pleaseStop()
   {
      // thread uit en 'verplaatsing mbv het wieltje' aan
      this.doorgaan_thread = false;
      draad                = null;                                         // waarom?
      this.controlePaneelNoord.actief();
      this.doorgaan_wheel  = true;
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








