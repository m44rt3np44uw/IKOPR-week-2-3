package Opdracht_1_Swing_1;

import java.awt.Color;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 


public class Bal
{
   private double x;   // x, y wereld-coordinaten 
   private double y;   // van de puntmassa (een bal)
                       // de omzetting in screen-coordinaten gebeurt in BalView 
                       
   private double vy;  // snelheid van de bal in meter/sec
   private int t;      // verstreken tijd in msec
   
   private Color kleur;// kleur van de bal
   
   private final double VALVERSNELLING = 9.81; // natuurkundige constante 
                                               // nodig bij het bepalen van 
                                               // afgelegde weg en snelheid
                                               // van de puntmassa (bal)

   public Bal ()
   {
      this.kleur = Color.RED;
      reset();
   }

   public void adjust(int dt) // dt in msec
   {
      t = t + dt;
      
      // valbeweging formule over de afgelegde weg .. zie een basis natuurkunde boek.
      // y (afgelegde weg in meters) = 1/2 * VALVERSNELLING * tijd * tijd (tijd in seconden) 
       
      y = 1/2 * this.VALVERSNELLING * t * t;
      
      // vy is de snelheid (in meter/sec) van de puntmassa 
      // vy = VALVERSNELLING * tijd (tijd in seconden) 
      
      vy = this.VALVERSNELLING * t;
      
      // waarom verandert hier (bij deze animatie) de x-waarde niet? 
      
   }
   
   public void reset() // zet de startwaarden 
   {
      t = 0;
      x = 10; 
      y = 0;
      vy = 0; // snelheid op tijdstip t == 0.
   }
   
   // getters
   public double getX()
   {
      return this.x;
   }

   public double getY()
   {
	   return this.y;
   }

   public double getVy()
   {
	   return this.vy;
   }

   public int getT()
   {
      return this.t;
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
