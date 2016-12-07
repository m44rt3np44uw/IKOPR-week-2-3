package Opdracht_1_Swing_2;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Bestudeer de code. Raadpleeg daar waar nodig is de API.
// Beantwoord de vragen .. zie commentaar bij de code. 

public class ControlePaneelNoord extends JPanel {
	private JTextField bereikXveld;
	private JTextField bereikYveld;
	private JTextField dtVeld;
	private JLabel xVeldLabel, yVeldLabel, dtVeldLabel;

	// geef de velden bereikXveld en bereikYveld default
	// de waarden 100 (meter)
	// geeft het dtVeld (steptime) default de waarde 20 (msec)
	// geef bij verkeerde invoer van de gebruiker de default-waarden
	// weer en gebruk daartoe een try-catch-clause

	public ControlePaneelNoord() {

		bereikXveld = new JTextField("100", 5);
		bereikYveld = new JTextField("100", 5);
		dtVeld = new JTextField("20", 5);

		xVeldLabel = new JLabel("bereik x (m): ");
		yVeldLabel = new JLabel("bereik y (m): ");
		dtVeldLabel = new JLabel("dt (ms)");

		add(xVeldLabel);
		add(bereikXveld);
		add(yVeldLabel);
		add(bereikYveld);
		add(dtVeldLabel);
		add(dtVeld);
	}

	public double getYbereik() {
		try {
			return Math.abs(Double.parseDouble(bereikYveld.getText()));
		} catch (Exception e) {
			return 100;
		}
	}

	public double getXbereik() {
		try {
			return Math.abs(Double.parseDouble(bereikXveld.getText()));
		} catch (Exception e) {
			return 100;
		}
	}

	public int getDt() {
		try {
			return Math.abs(Integer.parseInt(dtVeld.getText()));
		} catch (Exception e) {
			return 20;
		}
	}

	// wat zou je kunnen doen om tijdens de animatie het gebruik van
	// de invoervelden onmogelijk te maken?

	public void knopActief() {
		bereikXveld.setEditable(true);
		bereikYveld.setEditable(true);
		dtVeld.setEditable(true);
	}

	public void knopInactief() {
		bereikXveld.setEditable(false);
		bereikYveld.setEditable(false);
		dtVeld.setEditable(false);
	}
}
