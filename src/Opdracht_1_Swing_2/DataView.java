package Opdracht_1_Swing_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 

public class DataView extends JPanel implements MouseMotionListener, MouseListener, MouseWheelListener
{

	private Bal bal;  
	private final int MINHOOGTE = 17; // minmale hoogte van dit view
	private int hoogte;               // actuele hoogte van dit view

	private int x, y;
	private boolean dragged = false;
	private int dragX, dragY;



	public DataView (Bal bal)
	{
		setLayout(null);
		this.bal = bal;
		// zet de achtergrondkleur van dit view op oranje
		setBackground(Color.ORANGE);
		// voeg verschillende MouseListeners toe aan dit view 
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);

		// Border titelrand = // view met een rand en titel "bal-data"
		// zie (bv in de API) de klasse BorderFactory en 
		// de methode createTitledBorder 
		//this.setBorder (titelrand);
		setBorder(new javax.swing.border.TitledBorder(null, "bal-data", javax.swing.border.TitledBorder.CENTER, 
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10), Color.black));
		hoogte = 100;
		setBounds (440, 55, 180, hoogte); // wat doet dit statement?
		
		
	}


	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		if ((x != 0) && (y != 0))
			setLocation (x, y);

		String st_t = String.format ("%.2f", Math.abs(bal.getT()) / 1000.0);
		// wat doet dit statement precies?
		// waarom wordt er door 1000.0 gedeeld?

		String st_y = String.format("%.2f", bal.getY());// idem, maar nu met de actuele, afgelegde afstand van de bal 
		String st_vy = String.format("%.2f", Math.abs(bal.getVy()));// idem, maar nu met de actuele snelheid van de bal 

		// zet de schrijfkleur op blauw       
		g.setColor(Color.BLUE);
		// druk tijd (in sec), afgelegde weg (in meter) en snelheid (in meter/sec) netjes
		// onder elkaar af in deze view
		g.drawString("tijd (s):" + st_t , 10, 30);
		g.drawString("afgeledge weg (m):" + st_y , 10, 50);
		g.drawString("snelheid (m/s):" + st_vy , 10, 70);

	}

	// MouseWheelListener-method
	public void mouseWheelMoved (MouseWheelEvent ev)
	{
		int ticks = ev.getWheelRotation();
		// pas de hoogte van deze view aan mbv de waarde 'ticks'
		// De minmale hoogte moet MINHOOGTE zijn
		if(hoogte >= MINHOOGTE)
		{
			hoogte = getHeight() + ticks;
			setSize(180, hoogte);
		}
		else
		{
			hoogte = getHeight() + Math.abs(ticks);
			setSize(180, hoogte);
		}

	}

	// MouseListener-methods
	public void mouseClicked (MouseEvent me)
	{}
	public void mouseEntered (MouseEvent me)
	{}  
	public void mouseExited (MouseEvent me)
	{}
	// waarom staan deze methoden hier? 
	// als ze niets doen dan kan je ze toch beter gewoon weglaten? 


	public void mouseReleased (MouseEvent me)
	{
		// zie ook mouseDragged 
		dragged = false;
	}

	public void mousePressed (MouseEvent me) // wat moet deze methode hier? 
	{}

	// MouseMotionListener-methods   
	public void mouseDragged (MouseEvent event)
	{
		// zie aan de hand van het Vierkanten-voorbeeld
		// hoe je de view kan verplaatsen (tweede werkcollege, week 1) 
		// maak gebruik van de eigenschappen 'dragX', 'dragY' en 'dragged' 
		if (!dragged)
		{
			dragged = true;
			dragX = event.getX();
			dragY = event.getY();
		}
		int x = getX() + event.getX() - dragX;
		int y = getY() + event.getY() - dragY;
		setLocation( x, y );


	}

	public void mouseMoved (MouseEvent me) // wat moet deze methode hier? 
	{}       

}


