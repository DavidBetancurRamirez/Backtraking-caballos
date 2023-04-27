package Caballo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	ContenidoAjedrez panel1 = new ContenidoAjedrez();
	PanelInicio panel2 = new PanelInicio();
	Caballo caballo = new Caballo(8);
	
	public Main() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
		setLocationByPlatform(true);
		setUndecorated(true);
		setTitle("Refugio patitas perdidas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(136, 218, 232));
		header.setBounds(0, 0, 1200, 80);
		header.setLayout(null);
		
		JLabel titulo = new JLabel("Refugio");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Verdana", Font.BOLD, 30));
		titulo.setBounds(0, 0, 1184, 80);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		panelHeader.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
			}
		});
		panelHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		panelHeader.setBounds(0, 0, 1200, 42);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);
		
		JPanel panelClose = new JPanel();
		panelClose.setBackground(new Color(136, 218, 232));
		panelClose.setBounds(0, 0, 42, 42);
		panelHeader.add(panelClose);
		panelClose.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 42, 42);
		panelClose.add(lblNewLabel);
		
		JPanel panelContenido = new JPanel();
		panelContenido.setBounds(0, 0, 10, 10);
		contentPane.add(panelContenido);
		
		panelClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panelClose.setBackground(new Color(255, 0, 0));
				lblNewLabel.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelClose.setBackground(new Color(136, 218, 232));
				lblNewLabel.setForeground(new Color(0, 0, 0));
			}
		});
		
		panel1.btnPrimeraSln.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = panel1.testFieldCantidad.getText();
				panel1.error.setText("");
				if(!validarString(text)) {
					panel1.error.setText("Ingrese la cantidad de soluciones");
					return;
				}
				
				int cantidacita = Integer.parseInt(panel1.testFieldCantidad.getText());
				if(cantidacita == 0) {					
					panel1.error.setText("Ingrese una cantidad de soluciones mayor a 0");
					return;
				}
				
				long timeInicio=System.currentTimeMillis();
				boolean isSolved = caballo.resolver(cantidacita);
				long timeFin=System.currentTimeMillis();
				if (!isSolved) {
					System.out.println("No se encontró una solución");
					panel1.error.setText("No hay una solucion para este caballo, con estas configuraciones");
				} else {
					panel1.lblTime.setText("Tiempo: "+(timeFin-timeInicio)+" ms");
					caballo.imprimir();
					fillTablero(caballo.getMovimientos());
				}
				
				
				
			}
		});
		
		panel1.btnClean.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cleanTablero();
				setPositions();
				
				
			}
		});
		
		
		panel2.logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelPrincipal(panel2);
			}
		});
		
		
		contentPane.add(panel2);
		
	}
	
	private void panelPrincipal(JPanel panelAnterior) {
		panel1.setVisible(true);
		panelAnterior.setVisible(false);
		contentPane.add(panel1);
		setPositions();
	}
	
	int counter = 0;
	JLabel lblPos1;
	int x = 20;
    int y = 22;
	
	public void fillTablero(int[][] movimientos) {
	    int delay = 700; // 700 milisegundos de delay
	    javax.swing.Timer timer = new javax.swing.Timer(delay, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if(counter < 64) { // Si aún no se han agregado todos los JLabels
	            	x = 20 + 56*movimientos[counter][1];
	            	y = 22 + 56*movimientos[counter][0];
	                lblPos1 = new JLabel("");
	                lblPos1.setHorizontalAlignment(SwingConstants.CENTER);
	                lblPos1.setBounds(x, y, 60, 60);
	                lblPos1.setIcon(new ImageIcon(ContenidoAjedrez.class.getResource("/Imagenes/caballo3.png")));
	                panel1.lblTablero.add(lblPos1);
	                panel1.lblTablero.repaint(); // Actualizamos el panel en cada iteración
	                counter++; // Incrementamos el contador
	            }
	            else { // Si ya se agregaron todos los JLabels
	                ((javax.swing.Timer)e.getSource()).stop(); // Detenemos el timer
	            }
	        }
	    });
	    timer.start(); // Iniciamos el timer
	    counter = 0;
	    x = 20;
	    y = 22;
	    
	}
	
	public void cleanTablero() {
		panel1.lblTablero.removeAll();
		panel1.lblTablero.repaint();
		caballo.setDefaultValues();
		panel1.error.setText("");
		panel1.lblTime.setText("");
	}
	
	public void setPositions() {
		JLabel lblPosFake;
		int x0 = 20;
	    int y0 = 22;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				lblPosFake = new JLabel("");
				lblPosFake.setHorizontalAlignment(SwingConstants.CENTER);
				lblPosFake.setBounds(x0, y0, 60, 60);
				lblPosFake.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
				int tempI = i;
				int tempJ = j;
				JLabel tempLabel = lblPosFake;
				lblPosFake.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						tempLabel.setIcon(new ImageIcon(ContenidoAjedrez.class.getResource("/Imagenes/caballo3.png")));
						caballo.setFila(tempI);
						caballo.setColumna(tempJ);
						panel1.lblTablero.removeAll();
						panel1.lblTablero.add(tempLabel);
					}
				});
	            panel1.lblTablero.add(lblPosFake);
	            x0 += 56;
			}
			x0 = 20;
            y0 += 56;
		}
	}
	
	private static boolean validarString(String str) {
	    return !(str == null || str.trim().isEmpty());
	}


	
}
