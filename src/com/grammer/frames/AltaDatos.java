package com.grammer.frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.compress.utils.FileNameUtils;

import com.grammer.general.Dimenciones;
import com.grammer.general.Imagen;
import com.grammer.general.JPing;
import com.grammer.frames.LeerExcel;
import com.grammer.frames.LeerExcelCPU;
import com.grammer.frames.itConcluido;
import com.grammer.frames.itDenegado;

public class AltaDatos extends JFrame implements Runnable{
	
	Imagen imgCentral = null;
	boolean apagador;
	int x, y;
	boolean rompe = false;
	JPanel panelEstatus = new JPanel();
	Imagen imgEstatus;
	Imagen imagen = new Imagen();
	@SuppressWarnings("unused")
	private JPanel contentPane;
	private JLabel lblHora = new JLabel("00:00");
	String hora, minutos, segundos;
	Thread hilo;
	private final JLabel lblTurno = new JLabel("00:00");
	JPing ping;
	int jo;
	DefaultTableModel lista = new DefaultTableModel();
	private final JLabel lblFecha = new JLabel("0000/00/00");
	private final JLabel lblNotificacion = new JLabel("");
	String idCatalogoScarp = "";
	String nomCatalogoScarp = "";
	boolean validaReg;
	JPanel panelStatusImg = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final String errorMessage = "<html>No hay conexión a Red, favor de <br>revisar el cable de Red...</html>";

	Calendar calendario = new GregorianCalendar();
	Date horaActual = new Date();
	Date fecha = new Date();
	SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
	String horaAux = "";
	Thread current = Thread.currentThread();
	String strFecha = "";

	String e1[] = new String("").split("");
	private final JPanel panel_3 = new JPanel();   
	private final JPanel panel = new JPanel();
	private final JLabel lbll1 = new JLabel("Carga tu");
	private final JPanel panel_1 = new JPanel();
	private final JLabel label = new JLabel("Semana");
	private final JLabel label_1 = new JLabel("52");
	private final JLabel lbll2 = new JLabel("Excel de");
	private final JLabel lbll3 = new JLabel("Inventario");
	
	Imagen lblImagen_5 = new Imagen();
	File f = null;
	String ext = null;
	itConcluido ventana = null;
	itDenegado ventanaDenegado = null;
	LeerExcel obj = null;
	Calendar calendar = Calendar.getInstance();
	private JTextField txtNombreUsuario;
	private JTextField txtNombreEquipo;
	private JTextField txtSerie;
	private JTextField txtDepartamento;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaDatos frame = new AltaDatos();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 * @throws MalformedURLException 
	 * 
	 * @throws IOException
	 */
	public AltaDatos() throws MalformedURLException, InterruptedException {
		loading();
		lblImagen_5 = new Imagen("iconoarriba.png", 3, 750, 750);
		lblImagen_5.setBounds(55, 71, 133, 158);
		apagador = true;
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x + e.getX() - x, getLocation().y + e.getY() - y);
			}
		});

		getContentPane().setBackground(SystemColor.control);
		ping = new JPing();

		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
		modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
		String[] columns = { "Nómina", "Nombre", "Foto" };
		lista.setColumnIdentifiers(columns);

		panelEstatus.setBounds(481, 237, 73, 40);
		panelEstatus.setOpaque(false);

		imgEstatus = new Imagen("ampelmann-green2.png", 3, 750, 750);
		GroupLayout gl_panelStatusImg = new GroupLayout(panelStatusImg);
		gl_panelStatusImg.setHorizontalGroup(
				gl_panelStatusImg.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_panelStatusImg.createSequentialGroup().addContainerGap()
								.addComponent(imgEstatus, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panelStatusImg
				.setVerticalGroup(gl_panelStatusImg.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_panelStatusImg.createSequentialGroup()
								.addComponent(imgEstatus, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelStatusImg.setBackground(new Color(0, 0, 0, 0));
		panelStatusImg.setLayout(gl_panelStatusImg);
		GroupLayout gl_panelEstatus = new GroupLayout(panelEstatus);
		gl_panelEstatus.setHorizontalGroup(gl_panelEstatus.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING, gl_panelEstatus.createSequentialGroup().addContainerGap(283, Short.MAX_VALUE)
						.addComponent(panelStatusImg, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)));
		gl_panelEstatus.setVerticalGroup(gl_panelEstatus.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelEstatus.createSequentialGroup()
						.addComponent(panelStatusImg, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
						.addContainerGap()));
		panelEstatus.setBackground(new Color(0, 0, 0, 0));
		panelEstatus.setLayout(gl_panelEstatus);

		JButton btnSalir = new JButton("X");
		btnSalir.setBounds(514, 11, 51, 29);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Consolas", Font.BOLD, 16));
		btnSalir.setBackground(new Color(77, 29, 29));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnSalir.setFocusable(false);
		DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
		listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

		getContentPane().setLayout(null);
		getContentPane().add(panelEstatus);
		getContentPane().add(btnSalir);

		JLabel lblImpresoras = new JLabel("Inventario IT");
		lblImpresoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblImpresoras.setForeground(new Color(38, 75, 102));
		lblImpresoras.setFont(new Font("Consolas", Font.BOLD, 24));
		lblImpresoras.setAlignmentX(0.5f);
		lblImpresoras.setBounds(97, 11, 385, 40);
		getContentPane().add(lblImpresoras);

		lblNotificacion.setBounds(111, 341, 371, 29);
		getContentPane().add(lblNotificacion);

		lblNotificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotificacion.setFont(new Font("Consolas", Font.BOLD, 12));
		lblNotificacion.setAlignmentX(0.5f);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(38, 75, 102));
		panel_2.setBounds(27, 50, 547, 212);

		getContentPane().add(panel_2);
		lblTurno.setBounds(21, 10, 161, 20);
		panel_2.add(lblTurno);
		lblTurno.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurno.setForeground(Color.WHITE);
		lblTurno.setFont(new Font("Consolas", Font.BOLD, 16));
		lblTurno.setAlignmentX(0.5f);
		lblFecha.setBounds(364, 10, 96, 20);
		panel_2.add(lblFecha);
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Consolas", Font.BOLD, 16));
		lblFecha.setAlignmentX(0.5f);
		lblHora.setBounds(456, 10, 69, 20);
		panel_2.add(lblHora);

		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setForeground(Color.WHITE);
		lblHora.setFont(new Font("Consolas", Font.BOLD, 16));
		lblHora.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelCentral = new JPanel();
		panelCentral.setBounds(21, 30, 504, 145);
		panelCentral.setBackground(Color.WHITE);

		panelCentral.setLayout(null);
		panel_2.add(panelCentral);
		panel_3.setBounds(10, 10, 245, 124);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, hex2Rgb("#6e8cb8")));

		panelCentral.add(panel_3);
		panel_3.setLayout(null);
		lbll3.setBounds(26, 83, 209, 37);
		panel_3.add(lbll3);
		lbll3.setHorizontalAlignment(SwingConstants.CENTER);
		lbll3.setForeground(new Color(38, 75, 102));
		lbll3.setFont(new Font("Consolas", Font.PLAIN, 30));
		lbll3.setAlignmentX(0.5f);
				lbll2.setBounds(26, 46, 209, 37);
				panel_3.add(lbll2);
				lbll2.setHorizontalAlignment(SwingConstants.CENTER);
				lbll2.setForeground(new Color(38, 75, 102));
				lbll2.setFont(new Font("Consolas", Font.PLAIN, 30));
				lbll2.setAlignmentX(0.5f);
				lbll1.setBounds(26, 11, 209, 37);
				panel_3.add(lbll1);
				lbll1.setHorizontalAlignment(SwingConstants.CENTER);
				lbll1.setForeground(new Color(38, 75, 102));
				lbll1.setFont(new Font("Consolas", Font.PLAIN, 30));
				lbll1.setAlignmentX(0.5f);
		panel.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(135, 206, 250)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(265, 10, 229, 130);

		panelCentral.add(panel);
		panel.setLayout(null);

		JButton btnCargar = new JButton("Cargar");
		btnCargar.setBounds(10, 11, 209, 55);
		panel.add(btnCargar);
		btnCargar.setForeground(Color.WHITE);
		btnCargar.setFont(new Font("Consolas", Font.BOLD, 25));
		btnCargar.setFocusable(false);
		btnCargar.setBackground(new Color(33, 77, 29));
		panel_1.setBounds(10, 77, 229, 56);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(135, 206, 250)));
		panel_1.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(38, 75, 102));
		label.setFont(new Font("Consolas", Font.PLAIN, 35));
		label.setAlignmentX(0.5f);
		label.setBounds(10, 10, 131, 38);
		
				panel_1.add(label);
				label_1.setHorizontalAlignment(SwingConstants.LEFT);
				label_1.setForeground(new Color(38, 75, 102));
				label_1.setFont(new Font("Consolas", Font.BOLD, 45));
				label_1.setAlignmentX(0.5f);
				label_1.setBounds(151, 10, 66, 47);
				label_1.setText((calendar.get(Calendar.WEEK_OF_YEAR) -1) + "");
				
						panel_1.add(label_1);
						
						JPanel panel_2_1 = new JPanel();
						panel_2_1.setLayout(null);
						panel_2_1.setBackground(new Color(38, 75, 102));
						panel_2_1.setBounds(27, 311, 547, 389);
						getContentPane().add(panel_2_1);
						
						JPanel panelCentral_1 = new JPanel();
						panelCentral_1.setLayout(null);
						panelCentral_1.setBackground(Color.WHITE);
						panelCentral_1.setBounds(21, 30, 504, 339);
						panel_2_1.add(panelCentral_1);
						
						JPanel panel_3_1 = new JPanel();
						panel_3_1.setLayout(null);
						panel_3_1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, hex2Rgb("#6e8cb8")));
						panel_3_1.setBackground(Color.WHITE);
						panel_3_1.setBounds(10, 10, 245, 374);
						panelCentral_1.add(panel_3_1);
						
						JLabel lbll1_1 = new JLabel("Nombre de equipo:");
						lbll1_1.setHorizontalAlignment(SwingConstants.CENTER);
						lbll1_1.setForeground(new Color(38, 75, 102));
						lbll1_1.setFont(new Font("Consolas", Font.PLAIN, 20));
						lbll1_1.setAlignmentX(0.5f);
						lbll1_1.setBounds(10, 11, 225, 37);
						panel_3_1.add(lbll1_1);
						
						txtNombreUsuario = new JTextField();
						txtNombreUsuario.setBounds(10, 46, 225, 26);
						panel_3_1.add(txtNombreUsuario);
						txtNombreUsuario.setColumns(10);
						
						JLabel lbll1_1_1 = new JLabel("Nombre usuario :");
						lbll1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
						lbll1_1_1.setForeground(new Color(38, 75, 102));
						lbll1_1_1.setFont(new Font("Consolas", Font.PLAIN, 20));
						lbll1_1_1.setAlignmentX(0.5f);
						lbll1_1_1.setBounds(10, 81, 225, 37);
						panel_3_1.add(lbll1_1_1);
						
						txtNombreEquipo = new JTextField();
						txtNombreEquipo.setColumns(10);
						txtNombreEquipo.setBounds(10, 116, 225, 26);
						panel_3_1.add(txtNombreEquipo);
						
						JLabel lbll1_1_2 = new JLabel("Ingresa serial:");
						lbll1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
						lbll1_1_2.setForeground(new Color(38, 75, 102));
						lbll1_1_2.setFont(new Font("Consolas", Font.PLAIN, 20));
						lbll1_1_2.setAlignmentX(0.5f);
						lbll1_1_2.setBounds(10, 158, 225, 37);
						panel_3_1.add(lbll1_1_2);
						
						txtSerie = new JTextField();
						txtSerie.setColumns(10);
						txtSerie.setBounds(10, 193, 225, 26);
						panel_3_1.add(txtSerie);
						
						JLabel lbll1_1_3 = new JLabel("Departamento :");
						lbll1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
						lbll1_1_3.setForeground(new Color(38, 75, 102));
						lbll1_1_3.setFont(new Font("Consolas", Font.PLAIN, 20));
						lbll1_1_3.setAlignmentX(0.5f);
						lbll1_1_3.setBounds(10, 233, 225, 37);
						panel_3_1.add(lbll1_1_3);
						
						txtDepartamento = new JTextField();
						txtDepartamento.setColumns(10);
						txtDepartamento.setBounds(10, 268, 225, 26);
						panel_3_1.add(txtDepartamento);
						
						JPanel panel_4 = new JPanel();
						panel_4.setLayout(null);
						panel_4.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(135, 206, 250)));
						panel_4.setBackground(Color.WHITE);
						panel_4.setBounds(265, 10, 229, 319);
						panelCentral_1.add(panel_4);
						
						JButton btnCargar_1 = new JButton("Imprimir");
						btnCargar_1.setForeground(Color.WHITE);
						btnCargar_1.setFont(new Font("Consolas", Font.BOLD, 25));
						btnCargar_1.setFocusable(false);
						btnCargar_1.setBackground(new Color(33, 77, 29));
						btnCargar_1.setBounds(10, 11, 209, 55);
						panel_4.add(btnCargar_1);
						
						JPanel panel_1_1 = new JPanel();
						panel_1_1.setLayout(null);
						panel_1_1.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(135, 206, 250)));
						panel_1_1.setBackground(Color.WHITE);
						panel_1_1.setBounds(10, 77, 229, 56);
						panel_4.add(panel_1_1);
						
						JLabel label_2 = new JLabel("Estatus");
						label_2.setHorizontalAlignment(SwingConstants.CENTER);
						label_2.setForeground(new Color(38, 75, 102));
						label_2.setFont(new Font("Consolas", Font.PLAIN, 35));
						label_2.setAlignmentX(0.5f);
						label_2.setBounds(10, 10, 209, 38);
						panel_1_1.add(label_2);
						
						JLabel label_2_1 = new JLabel("Impresora : IT");
						label_2_1.setHorizontalAlignment(SwingConstants.CENTER);
						label_2_1.setForeground(new Color(38, 75, 102));
						label_2_1.setFont(new Font("Consolas", Font.PLAIN, 20));
						label_2_1.setAlignmentX(0.5f);
						label_2_1.setBounds(20, 270, 209, 38);
						panel_4.add(label_2_1);
						
						JLabel lblNotificacion2 = new JLabel("En espera");
						lblNotificacion2.setHorizontalAlignment(SwingConstants.CENTER);
						lblNotificacion2.setForeground(Color.ORANGE);
						lblNotificacion2.setFont(new Font("Consolas", Font.PLAIN, 35));
						lblNotificacion2.setAlignmentX(0.5f);
						lblNotificacion2.setBounds(20, 144, 209, 115);
						panel_4.add(lblNotificacion2);
						
						JLabel lblImpresionDeEtiquetas = new JLabel("Impresi\u00F3n de etiquetas");
						lblImpresionDeEtiquetas.setHorizontalAlignment(SwingConstants.CENTER);
						lblImpresionDeEtiquetas.setForeground(new Color(38, 75, 102));
						lblImpresionDeEtiquetas.setFont(new Font("Consolas", Font.BOLD, 24));
						lblImpresionDeEtiquetas.setAlignmentX(0.5f);
						lblImpresionDeEtiquetas.setBounds(97, 273, 385, 40);
						getContentPane().add(lblImpresionDeEtiquetas);
						
						
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lbll1.setText("<html><center>Espere</center></html>");
					lbll2.setText("<html><center>un</center></html>");
					lbll3.setText("<html><center>momento</center></html>");
					btnCargar.setVisible(false);;
					guardarArchivo();
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lbll1.setText("Carga tu");
				lbll2.setText("Excel de");
				lbll3.setText("Inventario");
				btnCargar.setVisible(true);
			}
		});
		
		btnCargar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				//int opcion = JOptionPane.showConfirmDialog(lblImagen_4,"¿Estas seguro de realizar la peticion?", "Aviso", JOptionPane.YES_NO_OPTION);

				try {
					imprimir(txtNombreEquipo.getText(),txtNombreUsuario.getText(),txtSerie.getText(),txtDepartamento.getText());
	
					//JOptionPane.showMessageDialog(lblImagen_4, "Se ha cancelado la peticion", "Cancelado", JOptionPane.ERROR_MESSAGE);
				
				} catch (Exception e2) {
					e2.printStackTrace();
					lblNotificacion2.setText("<html>Error revisar consola</html>");
				}
				lblNotificacion2.setText("<html>Realizado</html>");
			}
		});

		hilo = new Thread(this);
		hilo.start();
		setSize(600, 730);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setLocationRelativeTo(null);

		setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		getRootPane().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, hex2Rgb("#6e8cb8")));
		setResizable(false);
		GraphicsConfiguration config = getGraphicsConfiguration();
		Rectangle bounds = config.getBounds();
		Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);
		int x = bounds.x + bounds.width - insets.right - getWidth() - 10;
		int y = bounds.y + insets.top + 10;
		setLocation(x, y);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void guardarArchivo() throws InterruptedException {
			
			
		String nombre="";
		JFileChooser file=new JFileChooser();
		file.showSaveDialog(this);
		File guarda =file.getSelectedFile();
		int opcion=0;
		
		
		if (guarda!=null) {
			if (guarda.getName().equals("LAPTOP.xlsx") || guarda.getName().equals("CPU.xlsx")) {
				if(guarda !=null && file.accept(guarda))
					{
					 opcion = JOptionPane.showConfirmDialog(lblImagen_5,"¿Estas muy muy seguro de realizar la actualizacion o no?", "Aviso", JOptionPane.YES_NO_OPTION);
						if (opcion == 0) {
							if (guarda.getName().equals("LAPTOP.xlsx")) {
								nombre=file.getSelectedFile().getPath();
								System.out.println(nombre);
								validarDocumento(nombre);
							}
							if (guarda.getName().equals("CPU.xlsx")) {
								nombre=file.getSelectedFile().getPath();
								System.out.println(nombre);
								validarDocumentoCpu(nombre);
							}
						}else {
							JOptionPane.showMessageDialog(lblImagen_5, "Se ha cancelado la actualizacion", "Cancelado", JOptionPane.ERROR_MESSAGE);
							file.cancelSelection();
						}
					}else {
						JOptionPane.showMessageDialog(lblImagen_5, "Se ha cancelado la actualizacion", "Cancelado", JOptionPane.ERROR_MESSAGE);
						file.cancelSelection();
					}
				}else {
					JOptionPane.showMessageDialog(lblImagen_5, "Las bases de datos tendran que tener el nombre de 'Laptop' y 'CPU'", "Cancelado", JOptionPane.ERROR_MESSAGE);
					file.cancelSelection();
				}
			} else {
				JOptionPane.showMessageDialog(lblImagen_5, "Esta seguro que el archivo es un tipo xlsx o si corresponde con la base.", " ", JOptionPane.ERROR_MESSAGE);
				file.cancelSelection();
			}
		
		}
	
	
	public void hora() {
		Calendar calendario = new GregorianCalendar();
		Date horaActual = new Date();
		calendario.setTime(horaActual);
		hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
				: "0" + calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
				: "0" + calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
				: "0" + calendario.get(Calendar.SECOND);
	}
	
	public void run() {
		
		Thread current = Thread.currentThread();
		
		
		try {
			
			while (current == hilo) {
				
				hora();
				horaAux = hora+":"+minutos;	
				lblHora.setText(horaAux);
				
				calendar.setTime(fecha); 
				fecha = calendar.getTime();
				strFecha = formato.format(fecha);
				lblFecha.setText(strFecha);
				
				
				if (ping.validaPing("10.83.21.12")) {
					conexionValida(); 
				} else {
					System.out.println("Error 123456789");
					errorConexion();
				}
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			try {
				errorConexion();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void errorConexion() throws InterruptedException {

		lblNotificacion.setText(errorMessage);
		lblNotificacion.setForeground(Color.RED);
		getRootPane().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.RED));
		Thread.sleep(1000);
		panelStatusImg.setBackground(new Color(0, 0, 0, 0));
		panelStatusImg.remove(0);
		panelStatusImg.setOpaque(false);
		imgEstatus = new Imagen("ampelmann-red2.png", 3, 750, 750);
		GroupLayout gl_panelStatusImg = new GroupLayout(panelStatusImg);
		gl_panelStatusImg.setHorizontalGroup(
				gl_panelStatusImg.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_panelStatusImg.createSequentialGroup().addContainerGap()
								.addComponent(imgEstatus, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panelStatusImg
				.setVerticalGroup(gl_panelStatusImg.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_panelStatusImg.createSequentialGroup()
								.addComponent(imgEstatus, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelStatusImg.setLayout(gl_panelStatusImg);
	}

	public void conexionValida() throws InterruptedException {
		lblNotificacion.setForeground(Color.RED);
		lblNotificacion.setText("");
		getRootPane().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, hex2Rgb("#6e8cb8")));
		Thread.sleep(1000);
		panelStatusImg.setBackground(new Color(0, 0, 0, 0));
		panelStatusImg.remove(0);
		panelStatusImg.setOpaque(false);
		imgEstatus = new Imagen("ampelmann-green2.png", 3, 750, 750);
		GroupLayout gl_panelStatusImg = new GroupLayout(panelStatusImg);
		gl_panelStatusImg.setHorizontalGroup(
				gl_panelStatusImg.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_panelStatusImg.createSequentialGroup().addContainerGap()
								.addComponent(imgEstatus, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panelStatusImg
				.setVerticalGroup(gl_panelStatusImg.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_panelStatusImg.createSequentialGroup()
								.addComponent(imgEstatus, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelStatusImg.setLayout(gl_panelStatusImg);
	}
	
	
	@SuppressWarnings("unused")
	public void validarDocumento(String nombre) throws InterruptedException {
		File f=new File(nombre);
		String ext = null;
		 //PuntosConcluido ventana = new PuntosConcluido("");
		 //PuntosDenegado ventanaDenegado = new PuntosDenegado("");
		try {
			ext = FileNameUtils.getExtension(nombre);
			if (ext.equals("xlsx")) {
				if (f.exists()) {
					
					LeerExcel obj = new LeerExcel(f);
					if(null!=obj) {			
						itConcluido ventana = new itConcluido();
					}else {
						itDenegado ventanaDenegado = new itDenegado("<html><center>Error de insercion de datos</center></html>");
					}
				}else {
					itDenegado ventanaDenegado = new itDenegado("<html><center>Archivo no encontrado o no compatible</center></html>");
				}
			}else {
				itDenegado ventanaDenegado = new itDenegado("<html><center>Error la extencion no es valida</center></html>");
			}
		} catch (Exception e) {
			System.out.println(e);
			itDenegado ventanaDenegado = new itDenegado("<html><center>Error 100</center></html>");
		}
	}
	
	@SuppressWarnings("unused")
	public void validarDocumentoCpu(String nombre) throws InterruptedException {
		File f=new File(nombre);
		String ext = null;
		 //PuntosConcluido ventana = new PuntosConcluido("");
		 //PuntosDenegado ventanaDenegado = new PuntosDenegado("");
		try {
			ext = FileNameUtils.getExtension(nombre);
			if (ext.equals("xlsx")) {
				if (f.exists()) {
					
					LeerExcelCPU obj = new LeerExcelCPU(f);
					if(null!=obj) {			
						itConcluido ventana = new itConcluido();
					}else {
						itDenegado ventanaDenegado = new itDenegado("<html><center>Error de insercion de datos</center></html>");
					}
				}else {
					itDenegado ventanaDenegado = new itDenegado("<html><center>Archivo no encontrado o no compatible</center></html>");
				}
			}else {
				itDenegado ventanaDenegado = new itDenegado("<html><center>Error la extencion no es valida</center></html>");
			}
		} catch (Exception e) {
			System.out.println(e);
			itDenegado ventanaDenegado = new itDenegado("<html><center>Error 100</center></html>");
		}
	}
	
	public void loading() throws MalformedURLException, InterruptedException {
		URL url = new URL("file:///\\\\quesdat5\\Groups\\IT\\Software\\APU\\Fotos\\grammerit.png");
	    Icon icon = new ImageIcon(url);
	    JLabel label = new JLabel(icon);

	    JFrame f = new JFrame("Animation");
	    f.setUndecorated(true);
	    f.getContentPane().add(label);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.pack();
	    f.setResizable(false);
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);
	    f.setBackground(new Color(0,0,0,0));
	    
	    Thread.sleep(5000);
	    f.dispose();
	}
	
public void imprimir(String nombreEquipo,String nombreUsuario,String nombreSerial,String nombreDepartamento) {
		
		String zplCommand;
		
		Dimenciones dimXY  = new Dimenciones();
		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
	    System.out.println("Number of print services: " + printServices.length);
	    PrintService printService = null;
	    
	    for (PrintService printer : printServices) {
	    	System.out.println("Printer: " + printer.getName()); 
	    	
	    	if (printer.getName().contentEquals("IT")) {
	    		System.out.println("Printer: " + printer.getName()); 
	    		printService = printer;
	    	}
	    	
	    }
	    	
	    	zplCommand = "^XA\r\n" + 
	    			"~TA000\r\n" + 
	    			"~JSN\r\n" + 
	    			"^LT0\r\n" + 
	    			"^MNW\r\n" + 
	    			"^MTT\r\n" + 
	    			"^PON\r\n" + 
	    			"^PMN\r\n" + 
	    			"^LH0,0\r\n" + 
	    			"^JMA\r\n" + 
	    			"^PR2,2\r\n" + 
	    			"~SD22\r\n" + 
	    			"^JUS\r\n" + 
	    			"^LRN\r\n" + 
	    			"^CI27\r\n" + 
	    			"^PA0,1,1,0\r\n" + 
	    			"^XZ\r\n" + 
	    			"^XA\r\n" + 
	    			"^MMT\r\n" + 
	    			"^PW320\r\n" + 
	    			"^LL240\r\n" + 
	    			"^LS0\r\n" + 
	    			"^FO168,9^GFA,425,756,14,:Z64:eJydkbtKA0EUhmcvg7KI7EIGxCeQCLGwTLMWp5+BnXfII4jVoOBKil3wCRbTiAoWdhnQpNAyvkO2MERI2mCxOGMzx0sa/1N9/PufyywhVsqUkycRkEBXiKhMEXUWK0RSckRdfYOIYS8omqkb6D1LQF/Wuo8ozmIH0c5db+RyYTJ2ywSDQ5xLYpTburicuRwN+RHKTUmJenLOnOfP1T3ak2cM3TAkWn3Loenz0aPzCM9ayDshQ0QxR3uSXXWNiGQYfPK3FKqfakdV2z81urJ9GU1bFACosP+iKVadjWUxKd8bQwI4sx54dmgV7e3nt6YC86YeAE+MJ6mw3uJ19pA/vSzPa5sbQyopAwGe7an71Ueuz7r5wN4oKReQQPKV2zzYPq7fdKnLemK8cM0162RuU7/v+58+AXypXwM=:D799\r\n" + 
	    			"^BY2,3,67^FT4,184^BCN,,Y,N\r\n" + 
	    			"^FH\\^FD>:"+nombreSerial+"^FS\r\n" + 
	    			"^FT66,113^A0N,25,25^FH\\^CI28^FD"+nombreUsuario+"^FS^CI27\r\n" + 
	    			"^FT20,86^A0N,28,28^FH\\^CI28^FD"+nombreEquipo+"^FS^CI27\r\n" + 
	    			"^FT76,232^A0N,28,28^FH\\^CI28^FD"+nombreDepartamento+"^FS^CI27\r\n" + 
	    			"^PQ1,0,1,Y\r\n" + 
	    			"^XZ";
        
        byte[] by = zplCommand.getBytes();  
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;  
        Doc doc = new SimpleDoc(by, flavor, null);  
        DocPrintJob job = printService.createPrintJob();  
        
       try {           
            job.print(doc, null);
        } catch (PrintException ex) {
            System.err.println("Error: "+ex.getMessage());
        }
	}
	
	private Color hex2Rgb(String string) {
		// TODO Auto-generated method stub
		return null;
	}


}
