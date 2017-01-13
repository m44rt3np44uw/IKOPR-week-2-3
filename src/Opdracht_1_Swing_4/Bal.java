package Opdracht_1_Swing_4;

import java.awt.*;

public class Bal
{
   private double x;   // x, y wereld-coordinaten 
   private double y;   // van de puntmassa (een bal)
                       // de omzetting in screen-coordinaten gebeurt in BalView 
                       
   private double vy;  // snelheid van de bal in meter/sec
   private int t;      // verstreken tijd in msec
   
   private Color kleur;// kleur van de bal
   
   private final double VALVERSNELLING = 9.81; // natuurkundige constante 


   public Bal ()
   {
      this.kleur = Color.RED;
      reset();
   }

   public void adjust (int dt) // dt in msec
   {
      t = t + dt;
      
      // valbeweging formule over de afgelegde weg .. zie een basis natuurkunde boek. 
      y = (VALVERSNELLING / 2) * t * t / 1000000; // t in msec 
      vy = VALVERSNELLING * t / 1000;
      
      //x = 20 * t / 1000.0; bij bv een horizontale worp met een snelheid van 20 m/s
      
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
      return (x);
   }

   public double getY()
   {
      return (y);
   }

   public double getVy()
   {
      return (vy);
   }

   public int getT()
   {
      return (t);
   }
   
   public Color getKleur()
   {
      return (kleur);
   }

   // setters 
   public void setY (double y)
   {
      this.y = y;
   } 

   public void setX (double x)
   {
      this.x = x;
   }
} 
