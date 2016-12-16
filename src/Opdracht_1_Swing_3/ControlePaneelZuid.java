package Opdracht_1_Swing_3;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlePaneelZuid extends JPanel implements ActionListener {
    private JButton animate;
    private JButton stop;

    private Bal bal;
    private BalView balview;
    private BalController controller;
    private ValBewegingPaneel valBewegingPaneel;

    // bij het drukken op de stop-button wordt de controller
    // verzocht de animatie te stoppen (bevriezen)
    // bij het drukken op de animate-button wordt de bal gereset en dus ook ?
    // verder wordt dan de controller verzocht de animatie opnieuw op te starten

    public ControlePaneelZuid(Bal bal, BalView balView, BalController balController, ValBewegingPaneel valBewegingPaneel) {
        this.bal = bal;
        this.balview = balView;
        this.controller = balController;
        this.valBewegingPaneel = valBewegingPaneel;

        this.animate = new JButton("Start");
        this.stop = new JButton("Stop");

        this.animate.addActionListener(this);
        this.stop.addActionListener(this);

        this.add(this.animate);
        this.add(this.stop);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.animate) {
            this.controller.pleaseStart();
        }

        if (ae.getSource() == this.stop) {
            this.controller.pleaseStop();
        }

        this.valBewegingPaneel.repaint();
        this.balview.repaint();
    }

}
