import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelInicio extends JPanel {

	/**
	 * Create the panel.
	 */
	JLabel logo;
	
	public PanelInicio() {
		setBackground(new Color(242, 242, 242));
		setBounds(0, 0, 1200, 720);
		setLayout(null);
		
		JPanel panelsitoDecoration = new JPanel();
		panelsitoDecoration.setBackground(new Color(136, 218, 232));
		panelsitoDecoration.setBounds(0, 0, 1200, 720);
		add(panelsitoDecoration);
		panelsitoDecoration.setLayout(null);
		
		logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setBounds(525, 285, 150, 150);
		panelsitoDecoration.add(logo);
		logo.setForeground(new Color(255, 255, 255));
		logo.setBackground(new Color(255, 255, 255));
		logo.setIcon(new ImageIcon(PanelInicio.class.getResource("/Imagenes/start2.png")));
		
		JLabel titulo = new JLabel("Backtracking Caballo");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Verdana", Font.BOLD, 34));
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setBounds(0, 65, 1200, 64);
		panelsitoDecoration.add(titulo);
		
		JLabel infoAbajo = new JLabel("Samuel Bejarano, David Betancur, Pedro Henao, Simon Giraldo, Daniel Duque, David Jimenez");
		infoAbajo.setHorizontalAlignment(SwingConstants.CENTER);
		infoAbajo.setForeground(new Color(0, 0, 0));
		infoAbajo.setFont(new Font("Verdana", Font.BOLD, 18));
		infoAbajo.setBounds(0, 570, 1200, 100);
		panelsitoDecoration.add(infoAbajo);
		Date fechaActual = new Date();

	}

}
