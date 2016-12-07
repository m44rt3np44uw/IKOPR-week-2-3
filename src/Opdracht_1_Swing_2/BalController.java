package Opdracht_1_Swing_2;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 

public class BalController implements Runnable, MouseWheelListener
{
	private Bal bal;
	private BalView bv;   // wat zou je hier private declareren?
	private ValBewegingPaneel vbp;  // denk aan MVC 
	private ControlePaneelNoord noordpaneel;

	private boolean doorgaan_thread; // thread aan/uit
	private boolean doorgaan_wheel;  // 'verplaatsen van de bal met het wieltje' aan/uit

	private int dt;  // steptime & sleeptime in msec
	// en wat betekent het als ze gelijk zijn? 
	private double valhoogte; // in meter 

	private Thread draad;



	public BalController (Bal bal, BalView bv, ValBewegingPaneel vbp, ControlePaneelNoord noordpaneel)
	{
		this.bal = bal;
		this.bv = bv;
		this.vbp = vbp;
		this.noordpaneel = noordpaneel;
		// geef valpaneel een MouseWheelListener en laat het
		// BalController (dit) object de events afhandelen 
		vbp.addMouseWheelListener(this);
		// zet de thread uit en zet 'het verplaatsen van de bal
		// mbv het wieltje' uit
		doorgaan_thread = false; //de bal begint pas met vallen als er op de "Start" knop wordt gedrukt
		doorgaan_wheel = false; //je mag aan het begin nog niet de bal bewegen
		// initialiseer this.dt .. welk object gebruik je daarvoor?
		this.dt = noordpaneel.getDt();
		// initialiseer this.valhoogte .. welk object gebruik je daarvoor?
		//this.valhoogte = vbp.getEindY();
	}

	public void run() // waar komt deze methode vandaan hoe en waar wordt hij aangeroepen? 
	{      
		while (doorgaan_thread)
		{      
			if (bal.viewAdjust(dt) >= noordpaneel.getYbereik())// laat de thread stoppen als de bal de bodem bereikt
			{
				System.out.println(bal.viewAdjust(dt));
				pleaseStop();
				return;
			}
			else
			{
				// las een pauze in van 'dt'msec
				slaap(dt);
				// pas de eigenschap 'dt' van de bal aan
				bal.adjust(dt);
			}
			bv.repaint();// niet vergeten opnieuw ... ? 

		}
	}


	public void mouseWheelMoved (MouseWheelEvent event)
	{      
		if(doorgaan_wheel == true && doorgaan_thread == false)      // deze methode alleen uitvoeren als de thread uitstaat EN
		{      		
			// 'het verplaatsen mbv het wieltje' aan
			int ticks = event.getWheelRotation(); // wat levert dit op? 
			this.dt = noordpaneel.getDt();
			
			if ((bv.getY()-25 <  vbp.getEindY()) && bal.getT() > 0) // waarom deze conditie?
			{
				if(ticks > 0)
				{
					bal.adjust(dt);
				}
				else
				{
					bal.adjust(-dt);
				}
			}
			else
			{
				return;
			}

			bv.repaint(); // niet vergeten opnieuw ... ? 
		}
	}

	public void pleaseStart()
	{
	if (draad != null)
	{
	return;
	}
	// initialiseer 'dt'en 'valhoogte'
	this.valhoogte = vbp.getEindY();
	this.dt = noordpaneel.getDt();
	// zet de thread aan en de 'verplaatsing mbv
	// van het wieltje' uit
	doorgaan_thread = true;
	doorgaan_wheel = false;
	draad = new Thread(this);// creeer een nieuw Thread-object
	// start de thread .. welke methode wordt daarna dus aangeroepen?
	noordpaneel.knopInactief();
	draad.start();
	}


	public void pleaseStop()
	{
	// thread uit en 'verplaatsing mbv het wieltje' aan
	doorgaan_thread = false;
	draad = null; // waarom?
	noordpaneel.knopActief();
	doorgaan_wheel = true;
	}

	private void slaap (int msec)
	{
		try
		{
			Thread.sleep (msec);
		}
		catch (InterruptedException ex)
		{
			System.err.println("InterruptedException");
		}
	}

}