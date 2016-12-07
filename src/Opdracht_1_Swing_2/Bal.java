package Opdracht_1_Swing_2;

import java.awt.Color;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 

public class Bal
{
	private double x;   // x, y wereld-coordinaten 
	private double y;   // van de puntmassa (een bal)
	// de omzetting in screen-coordinaten gebeurt in BalView 

	private double vy;  // snelheid van de bal in meter/sec
	private float t;      // verstreken tijd in msec

	private Color kleur;// kleur van de bal

	private final double VALVERSNELLING = 9.81; // natuurkundige constante 
	// nodig bij het bepalen van 
	// afgelegde weg en snelheid
	// van de puntmassa (bal)
	public Bal()
	{
		this.kleur = Color.BLACK;
		
	}

	public void adjust (int dt) // dt in msec
	{
		t += dt;
		// valbeweging formule over de afgelegde weg .. zie een basis natuurkunde boek.
		// y (afgelegde weg in meters) = 1/2 * VALVERSNELLING * tijd * tijd (tijd in seconden) 
		float tijdInSeconden = t / 1000;
		float tijdKwadraat = tijdInSeconden * tijdInSeconden;
		y = 0.5 * VALVERSNELLING * tijdKwadraat;
		
		// vy is de snelheid (in meter/sec) van de puntmassa 
		// vy = VALVERSNELLING * tijd (tijd in seconden) 

		vy = VALVERSNELLING * tijdInSeconden;

		// waarom verandert hier (bij deze animatie) de x-waarde niet? 

	}
	
	public float viewAdjust(int dt)
	{
		float t2 = t + dt;
		
		float tijdInSeconden = t2 / 1000;
		float tijdKwadraat = tijdInSeconden * tijdInSeconden;
		
		return (float) (0.5 * VALVERSNELLING * tijdKwadraat);
	}



	// getters
	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public double getVy()
	{
		return vy;
	}

	public float getT()
	{
		return t;
	}

	public Color getKleur()
	{
		return this.kleur;
	}

	// setters ... zo nodig bij toekomstige uitbreidingen 
	public void setY (double y)
	{
		this.y = y;
	} 

	public void setX (double x)
	{
		this.x = x;
	}
} 
