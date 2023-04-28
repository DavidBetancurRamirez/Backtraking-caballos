import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class BackgroundPanel extends JLabel {
    private Image backgroundImage;

    public BackgroundPanel(String image) {
        this.setIcon(new ImageIcon(ContenidoAjedrez.class.getResource(image)));
        setLayout(new BorderLayout());
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
    }
}


public class ContenidoAjedrez extends JPanel {
	private static final long serialVersionUID = -1507725910040779619L;
	
	/**
	 * Create the panel.
	 */
	JButton btnPrimeraSln;
	JButton btnClean;
	JLabel error;
	JLabel lblTablero;
	JTextField testFieldCantidad;
	JLabel lblTime;
	
	
	public ContenidoAjedrez() {
		setBackground(new Color(242, 242, 242));
		setBounds(0, 0, 1200, 720);
		setLayout(null);
		
		btnPrimeraSln = new JButton("Solucionar");
		btnPrimeraSln.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPrimeraSln.setBackground(new Color(60, 60, 60));
				btnPrimeraSln.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPrimeraSln.setBackground(new Color(255, 255, 255));
				btnPrimeraSln.setForeground(new Color(0, 0, 0));
			}
		});
		btnPrimeraSln.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPrimeraSln.setFont(new Font("Verdana", Font.ITALIC, 16));
		btnPrimeraSln.setForeground(new Color(0, 0, 0));
		btnPrimeraSln.setBackground(new Color(255, 255, 255));
		btnPrimeraSln.setBounds(900, 200, 200, 35);
		add(btnPrimeraSln);
		
		btnClean = new JButton("Clean");
		btnClean.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClean.setBackground(new Color(60, 60, 60));
				btnClean.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClean.setBackground(new Color(255, 255, 255));
				btnClean.setForeground(new Color(0, 0, 0));
			}
		});
		btnClean.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClean.setFont(new Font("Verdana", Font.ITALIC, 16));
		btnClean.setForeground(new Color(0, 0, 0));
		btnClean.setBackground(new Color(255, 255, 255));
		btnClean.setBounds(900, 400, 200, 35);
		add(btnClean);
		
		testFieldCantidad = new JTextField();
		testFieldCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numero = key >= 48 && key <= 57;
				if(!numero)
					e.consume();
			}
		});
		testFieldCantidad.setFont(new Font("Tahoma", Font.BOLD, 16));
		testFieldCantidad.setBounds(975, 300, 50, 35);
		add(testFieldCantidad);
		testFieldCantidad.setColumns(10);
		
		lblTime = new JLabel("");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(800, 600, 400, 35);
		add(lblTime);
		
		
		
		JPanel panelsitoDecoration = new JPanel();
		panelsitoDecoration.setBackground(new Color(136, 218, 232));
		panelsitoDecoration.setBounds(800, 0, 400, 720);
		add(panelsitoDecoration);
		panelsitoDecoration.setLayout(null);
		
		JLabel titulo = new JLabel("Backtracking Caballo");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Verdana", Font.BOLD, 30));
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setBounds(0, 62, 400, 64);
		panelsitoDecoration.add(titulo);
		
		error = new JLabel("");
		error.setFont(new Font("Verdana", Font.BOLD, 12));
		error.setForeground(new Color(255, 0, 0));
		error.setBounds(150, 660, 500, 20);
		add(error);
		
//		JPanel panelTablero = new JPanel();
//		panelTablero.setBackground(new Color(255, 255, 255));
//		panelTablero.setBounds(150, 120, 500, 500);
//		add(panelTablero);
//		panelTablero.setLayout(null);
//		
//		JLabel lblPos1 = new JLabel("Caballo1");
//		lblPos1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblPos1.setBounds(0, 0, 62, 62);
//		panelTablero.add(lblPos1);
//		lblPos1.setIcon(new ImageIcon(ContenidoAjedrez.class.getResource("/Imagenes/Caballo.png")));
		
//		JLabel lblPos1;
//		int x = 170;
//		int y = 142;
//		for(int i = 0; i < 8; i++) {
//			for(int j = 0; j < 8; j++) {
//				lblPos1 = new JLabel("");
//				lblPos1.setHorizontalAlignment(SwingConstants.CENTER);
//				lblPos1.setBounds(x, y, 60, 60);
//				lblPos1.setIcon(new ImageIcon(ContenidoAjedrez.class.getResource("/Imagenes/caballo3.png")));
//				add(lblPos1);
//				y += 56;
//			}
//			x +=56;
//			y = 142;
//		}
	
//		
//		
		lblTablero = new JLabel("");
		lblTablero.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablero.setBounds(150, 120, 500, 500);
		add(lblTablero);
		lblTablero.setIcon(new ImageIcon(ContenidoAjedrez.class.getResource("/imagenes/Tablero.png")));
		
//		
//		JLabel lblPos1;
//		lblPos1 = new JLabel("");
//		lblPos1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblPos1.setBounds(20+56, 22+56, 60, 60);
//		lblPos1.setIcon(new ImageIcon(ContenidoAjedrez.class.getResource("/Imagenes/caballo3.png")));
//		lblTablero.add(lblPos1);

	}
	
	public void fillTablero(int[][] tablero) {
		JLabel lblPos1;
		int x = 20;
		int y = 22;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				lblPos1 = new JLabel("");
				lblPos1.setHorizontalAlignment(SwingConstants.CENTER);
				lblPos1.setBounds(x, y, 60, 60);
				lblPos1.setIcon(new ImageIcon(ContenidoAjedrez.class.getResource("/Imagenes/caballo3.png")));
				lblTablero.add(lblPos1);
				
				y += 56;
				System.out.println("Iteración " + i);
				
//				try {
//					TimeUnit.SECONDS.sleep(1);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			    
//			    try {
//			        Thread.sleep(1000); // Pausa de 1 segundo (1000 milisegundos)
//			    } catch (InterruptedException e) {
//			        e.printStackTrace();
//			    }
		        
			}
			x +=56;
			y = 22;
		}
	}
	
}
