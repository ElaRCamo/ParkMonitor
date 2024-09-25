package com.grammer.frames;

import java.awt.Color;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.commons.compress.utils.FileNameUtils;
import com.grammer.frames.LeerExcel;
import com.grammer.general.Imagen;
import com.grammer.general.JPing;
import com.grammer.dao.PersonalDaoImpl;
import com.grammer.dto.BitacoraDto;
import com.grammer.entity.Areas;
import com.grammer.entity.Bitacora;
import com.grammer.entity.BitacoraCambios;
import com.grammer.entity.Configuraciones;
import com.grammer.entity.Corbatines;
import com.grammer.entity.Estatus;
import com.grammer.entity.Laptop;
import com.grammer.entity.Lugares;
import com.grammer.entity.Modelos;
import com.grammer.entity.Otros;
import com.grammer.entity.Telefono;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

public class AltaDatosiT extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	Imagen imgCentral = null;
	boolean apagador;
	int x, y;
	boolean rompe = false;
	JPanel panelEstatus = new JPanel();
	Imagen imgEstatus;
	Imagen imagen = new Imagen();
	@SuppressWarnings("unused")
	private JPanel contentPane;
	String hora, minutos, segundos;
	Thread hilo;
	JPing ping;
	int jo;
	DefaultTableModel lista = new DefaultTableModel();
	String idCatalogoScarp = "";
	String nomCatalogoScarp = "";
	boolean validaReg;
	JPanel panelStatusImg = new JPanel();
	JComboBox<String> cbEstatus,cbArea,cbLugar;
	Calendar calendario = new GregorianCalendar();
	Date horaActual = new Date();
	Date fecha = new Date();
	SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
	String horaAux = "";
	Thread current = Thread.currentThread();
	String strFecha = "";
	JComboBox<String> cbEstatusTelefono;
	String e1[] = new String("").split("");
	JButton btnGuardarImpresionConf;
	Imagen lblImagen_5 = new Imagen();
	File f = null;
	String ext = null;
	itConcluido ventana = null;
	itDenegado ventanaDenegado = null;
	LeerExcel obj = null;
	Calendar calendar = Calendar.getInstance();
	private JTextField txtUsuario;
	private JTextField txtCorbatin;
	private JTextField txtNombreEquipo;
	private JTextField txtEquipoAdicional;
	private JTable tableGeneralIt;
	JComboBox<String> comboBox;
	JComboBox<String> cbTipoBase;
	DefaultTableModel model,modelT,modelB,modelA,modelM,modelL,modelO;
    final Object[] row,rowT,rowB,rowA,rowL,rowM,rowO;
    private JTextField textField_8;
    private JTextField txtSerial;
    private JTextField txtUsuarioOtros;
    private JTextField txtAreaOtros;
    private JTextField txtNombreEquipoOtros;
    private JTextField txtDescripcionOtros;
    private JTextField txtCantidadOtros;
    private JTextField txtUsuarioTelefono;
    private JTextField txtNumeroTelefono;
    private JTextField txtIME;
    JComboBox<String> cbAreaTelefono,cbModeloTelefono;
    private JLabel lblId, lblIdTelefono,lblEstatusTelefono,lblIdAreaBase,lblIdLugares,lblIdModelos;
    private JTable tablaTelefonos;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTable tablaBitacora;
    private JTextField txtOdservaciones;
    private JTextField txtObservacionesTelefono;
    private JTextField txtPasswordUsuarioConf;
    private JTextField txtAreaBase;
    private JTextField txtModeloBase;
    private JTextField txtLugarBase;
    private JTable tablaAreasBase;
    private JTable tablaModelosBase;
    private JTable tablaLugarBase;
    private JTable tablaOtros;
    JLabel lblIdOtrosT;
    JRadioButton rbtnEtiquetaOtros;
    private JTextField txtRegistro;
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private TableColumn colIdRegistro;
    private TableColumn colPlacas;
    private TableColumn colModelo;
    private TableColumn colDescripcion;
    private TableColumn colColor;
    private TableColumn colTel;
    
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaDatosiT frame = new AltaDatosiT("");
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
	public AltaDatosiT(String usuarioNombreF) throws MalformedURLException, InterruptedException {
		
		getContentPane().setForeground(Color.WHITE);
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

		panelEstatus.setBounds(905, 63, 73, 40);
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
		btnSalir.setBounds(939, 11, 51, 29);
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

		JLabel lblImpresoras = new JLabel("Grammer Parking");
		lblImpresoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblImpresoras.setForeground(new Color(38, 75, 102));
		lblImpresoras.setFont(new Font("Consolas", Font.BOLD, 24));
		lblImpresoras.setAlignmentX(0.5f);
		lblImpresoras.setBounds(305, 11, 385, 40);
		getContentPane().add(lblImpresoras);
		
		model = new DefaultTableModel();
        Object[] columnD = {
        	"ID",
        	"Corbatin",
            "Nómina",
            "Usuario",
            "Telefóno",
            "Vehiculo",
            "Placas",
            "Modelo",
            "Color",
            "Fecha de entrada",
            "Hora de entrada",
            "Fecha de salida",
            "Hora de salida"
        };
        row = new Object[13];
        model.setColumnIdentifiers(columnD);
       
        PersonalDaoImpl registrosBitacora = new PersonalDaoImpl();
 

     // Define un formato para las fechas y horas
     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

     for (BitacoraDto a : registrosBitacora.consultar()) {
         row[0] = a.getIdRegistro();
         row[1] = a.getIdCorbatin();
         row[2] = a.getUsuarioNomina();
         row[3] = a.getUsuarioNombre();
         row[4] = a.getTelefono();
         
         
         row[5] = a.getTipoDescripcion();
         row[6] = a.getVehiculoPlacas();
         row[7] = a.getVehiculoModelo();
         row[8] = a.getVehiculoColor();

         // Convertir LocalDate y LocalTime a String usando los formatos definidos
         row[9] = a.getFechaEntrada() != null ? a.getFechaEntrada().format(dateFormatter) : "";
         row[10] = a.getHoraEntrada() != null ? a.getHoraEntrada().format(timeFormatter) : "";
         row[11] = a.getFechaSalida() != null ? a.getFechaSalida().format(dateFormatter) : "";
         row[12] = a.getHoraSalida() != null ? a.getHoraSalida().format(timeFormatter) : "";

         model.addRow(row);
     }
        
        /*********************************/
        
        
        modelT = new DefaultTableModel();
        Object[] columnT = {
            "Id",
            "Usuario",
            "Area",
            "Numero",
            "Modelo",
            "IME",
            "Estatus",
            "Observaciones"
        };
        rowT = new Object[8];
        modelT.setColumnIdentifiers(columnT);
        
        
        /*for (Telefono a: daoPersonal.consultarTelefono()) {

        	rowT[0] = a.getIdTelefono();
        	rowT[1] = a.getUsuario();
        	rowT[2] = a.getArea();
        	rowT[3] = a.getNumero();
        	rowT[4] = a.getModelo();
        	rowT[5] = a.getIme();
        	rowT[6] = a.getEstatus();
        	rowT[7] = a.getObservaciones();

        	modelT.addRow(rowT);
        }*/
        
        modelB = new DefaultTableModel();
        Object[] columnB = {
            "Cuenta",
            "Tipo cambio",
            "Antes",
            "Despues",
            "Fecha Cambio"
        };
        rowB = new Object[5];
        modelB.setColumnIdentifiers(columnB);
        
        
        /*for (BitacoraCambios a: daoPersonal.consultarBitacora()) {

        	rowB[0] = a.getCuenta();
        	rowB[1] = a.getTipoCambio();
        	rowB[2] = a.getAntes();
        	rowB[3] = a.getDespues();
        	rowB[4] = a.getFechaCambio();

        	modelB.addRow(rowB);
        }
        */
        
        modelA = new DefaultTableModel();
        Object[] columnA = {
            "id",
            "Area"
        };
        rowA = new Object[2];
        modelA.setColumnIdentifiers(columnA);
        
        
        /*for (Areas a: daoPersonal.consultarAreasBase()) {

        	rowA[0] = a.getIdArea();
        	rowA[1] = a.getNombreArea();

        	modelA.addRow(rowA);
        }
        */
        modelM = new DefaultTableModel();
        Object[] columnM = {
            "Id",
            "Nombre Modelo",
            "Tipo Modelo"
        };
        rowM = new Object[3];
        modelM.setColumnIdentifiers(columnM);
        
        
        /*for (Modelos a: daoPersonal.consultarModelosBase()) {

        	rowM[0] = a.getIdModelo();
        	rowM[1] = a.getNombreModelo();
        	rowM[2] = a.getTipoModelo();

        	modelM.addRow(rowM);
        }*/
        
        modelL = new DefaultTableModel();
        Object[] columnL = {
            "Id",
            "Lugar"
        };
        rowL = new Object[2];
        modelL.setColumnIdentifiers(columnL);
        
        
        /*for (Lugares a: daoPersonal.consultarLugarBase()) {

        	rowL[0] = a.getIdLugar();
        	rowL[1] = a.getNombreLugar();

        	modelL.addRow(rowL);
        }
        */
        //Otros tabla
        
        
        modelO = new DefaultTableModel();
        Object[] columnO = {
            "Id",
            "Usuario",
            "Area",
            "Nombre Equipo",
            "Descripcion",
            "Cantidad",
            "Estado"
        };
        rowO = new Object[7];
        modelO.setColumnIdentifiers(columnO);
        
        
       /* for (Otros a: daoPersonal.consultarOtros()) {

        	rowO[0] = a.getIdOtros();
        	rowO[1] = a.getUsuario();
        	rowO[2] = a.getArea();
        	rowO[3] = a.getNombreEquipo();
        	rowO[4] = a.getDescripcion();
        	rowO[5] = a.getCantidad();
        	rowO[6] = a.getEstatus();

        	modelO.addRow(rowO);
        }*/
        
        
        //Pestaña de Bitacora
						
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 77, 980, 610);
		getContentPane().add(tabbedPane_1);

		ImageIcon iconParking = new ImageIcon(AltaDatosiT.class.getResource("/com/grammer/imgs/parking.png"));
		ImageIcon iconCar = new ImageIcon(AltaDatosiT.class.getResource("/com/grammer/imgs/car.png"));
		ImageIcon iconCorbatines = new ImageIcon(AltaDatosiT.class.getResource("/com/grammer/imgs/carnet.png"));

		JPanel panelBitacoraParking = new JPanel();
		panelBitacoraParking.setLayout(null);
		panelBitacoraParking.setBackground(new Color(38, 75, 102));
		tabbedPane_1.addTab("Bitácora", iconParking, panelBitacoraParking);

		JPanel panelFondoParking = new JPanel();
		panelFondoParking.setLayout(null);
		panelFondoParking.setBackground(Color.WHITE);
		panelFondoParking.setBounds(10, 11, 955, 553);
		panelBitacoraParking.add(panelFondoParking);

		JScrollPane scrollBitacora = new JScrollPane();
		scrollBitacora.setBounds(10, 202, 935, 345);
		panelFondoParking.add(scrollBitacora);

		tableGeneralIt = new JTable();
		scrollBitacora.setViewportView(tableGeneralIt);
		tableGeneralIt.setModel(model);

		colTel = tableGeneralIt.getColumnModel().getColumn(4);
		colTel.setMinWidth(0);
		colTel.setMaxWidth(0);
		colTel.setPreferredWidth(0);

		colIdRegistro = tableGeneralIt.getColumnModel().getColumn(0);
		colIdRegistro.setMinWidth(0);
		colIdRegistro.setMaxWidth(0);
		colIdRegistro.setPreferredWidth(0);

		colPlacas = tableGeneralIt.getColumnModel().getColumn(5);
		colPlacas.setMinWidth(0);
		colPlacas.setMaxWidth(0);
		colPlacas.setPreferredWidth(0);

		colModelo = tableGeneralIt.getColumnModel().getColumn(6);
		colModelo.setMinWidth(0);
		colModelo.setMaxWidth(0);
		colModelo.setPreferredWidth(0);

		colDescripcion = tableGeneralIt.getColumnModel().getColumn(7);
		colDescripcion.setMinWidth(0);
		colDescripcion.setMaxWidth(0);
		colDescripcion.setPreferredWidth(0);

		colColor = tableGeneralIt.getColumnModel().getColumn(8);
		colColor.setMinWidth(0);
		colColor.setMaxWidth(0);
		colColor.setPreferredWidth(0);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(43, 436, 6, 20);
		panelFondoParking.add(textPane);

		JLabel lblIdCorbatin = new JLabel("Núm. Corbatin:");
		lblIdCorbatin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdCorbatin.setForeground(new Color(38, 75, 102));
		lblIdCorbatin.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblIdCorbatin.setAlignmentX(0.5f);
		lblIdCorbatin.setBounds(10, 41, 130, 26);
		panelFondoParking.add(lblIdCorbatin);

		txtCorbatin = new JTextField();
		txtCorbatin.setColumns(10);
		txtCorbatin.setBounds(150, 40, 186, 26);
		panelFondoParking.add(txtCorbatin);

		JLabel lblEstatus = new JLabel("En espera");
		lblEstatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstatus.setForeground(Color.ORANGE);
		lblEstatus.setFont(new Font("Consolas", Font.PLAIN, 35));
		lblEstatus.setAlignmentX(0.5f);
		lblEstatus.setBounds(713, 68, 209, 53);
		panelFondoParking.add(lblEstatus);

		JLabel label_2 = new JLabel("Estatus");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(38, 75, 102));
		label_2.setFont(new Font("Consolas", Font.PLAIN, 35));
		label_2.setAlignmentX(0.5f);
		label_2.setBounds(713, 45, 209, 41);
		panelFondoParking.add(label_2);

		JLabel lblUsuario = new JLabel("N\u00F3mina:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(new Color(38, 75, 102));
		lblUsuario.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblUsuario.setAlignmentX(0.5f);
		lblUsuario.setBounds(364, 10, 80, 26);
		panelFondoParking.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(456, 9, 186, 26);
		panelFondoParking.add(txtUsuario);

		// Etiqueta y campo de texto para idTipoVehiculo
		JLabel lblTipoVehiculo = new JLabel("Vehiculo:");
		lblTipoVehiculo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoVehiculo.setForeground(new Color(38, 75, 102));
		lblTipoVehiculo.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblTipoVehiculo.setAlignmentX(0.5f);
		lblTipoVehiculo.setBounds(10, 73, 130, 26);
		panelFondoParking.add(lblTipoVehiculo);

		JTextField txtIdTipoVehiculo = new JTextField();
		txtIdTipoVehiculo.setEditable(false);
		txtIdTipoVehiculo.setColumns(10);
		txtIdTipoVehiculo.setBounds(150, 72, 186, 26);
		panelFondoParking.add(txtIdTipoVehiculo);

		// Etiqueta y campo de texto para placasVehiculo
		JLabel lblPlacasVehiculo = new JLabel("Placas:");
		lblPlacasVehiculo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlacasVehiculo.setForeground(new Color(38, 75, 102));
		lblPlacasVehiculo.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblPlacasVehiculo.setAlignmentX(0.5f);
		lblPlacasVehiculo.setBounds(10, 139, 130, 26);
		panelFondoParking.add(lblPlacasVehiculo);

		JTextField txtPlacasVehiculo = new JTextField();
		txtPlacasVehiculo.setEditable(false);
		txtPlacasVehiculo.setColumns(10);
		txtPlacasVehiculo.setBounds(150, 138, 186, 26);
		panelFondoParking.add(txtPlacasVehiculo);

		// Etiqueta y campo de texto para modeloVehiculo
		JLabel lblModeloVehiculo = new JLabel("Modelo:");
		lblModeloVehiculo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModeloVehiculo.setForeground(new Color(38, 75, 102));
		lblModeloVehiculo.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblModeloVehiculo.setAlignmentX(0.5f);
		lblModeloVehiculo.setBounds(11, 106, 130, 26);
		panelFondoParking.add(lblModeloVehiculo);

		JTextField txtModeloVehiculo = new JTextField();
		txtModeloVehiculo.setEditable(false);
		txtModeloVehiculo.setColumns(10);
		txtModeloVehiculo.setBounds(150, 105, 186, 26);
		panelFondoParking.add(txtModeloVehiculo);

		// Etiqueta y campo de texto para colorVehiculo
		JLabel lblColorVehiculo = new JLabel("Color:");
		lblColorVehiculo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColorVehiculo.setForeground(new Color(38, 75, 102));
		lblColorVehiculo.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblColorVehiculo.setAlignmentX(0.5f);
		lblColorVehiculo.setBounds(10, 170, 130, 26);
		panelFondoParking.add(lblColorVehiculo);

		JTextField txtColorVehiculo = new JTextField();
		txtColorVehiculo.setEditable(false);
		txtColorVehiculo.setColumns(10);
		txtColorVehiculo.setBounds(150, 169, 186, 26);
		panelFondoParking.add(txtColorVehiculo);

		JButton btnAgregar = new JButton("Registrar entrada");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bitacora registroBitacora = new Bitacora();
				Corbatines corbatin = new Corbatines();

				BitacoraCambios bitacora = new BitacoraCambios();
				PersonalDaoImpl personalDao = new PersonalDaoImpl();
				int AuxEntero = 0;

				if (txtCorbatin.getText() != null && !txtCorbatin.getText().equals("")) {

					// Convierte el texto a un entero
					int numCorbatin = Integer.parseInt(txtCorbatin.getText());

					// System.out.println("Corbatin ID: " + txtCorbatin.getText());

					// Con el personalDao(metodo getCorbatinById) se manda a traer el corbatin con
					// el numCorbatin ingresado
					// todos los datos se guardan en corbatin
					corbatin = personalDao.getCorbatinById(numCorbatin);

					// corbatin ahora contiene los datos de ese corbatin y ya se puede hacer
					// consultas
					Estatus estatusCorbatin = corbatin.getEstatus();

					// System.out.println("Corbatin Estatus: " + estatusCorbatin.getDescripcion());
					// System.out.println("Corbatin string: " + corbatin.toString());

					if (estatusCorbatin.getIdEstatus() != 1) {
						JOptionPane.showMessageDialog(null, "El estatus del corbatín no es válido.", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					} else {

						// Asignar el valor de idCorbatin
						registroBitacora.setCorbatin(corbatin);

						System.out.println("Corbatin asignado: " + registroBitacora.getCorbatin());

						// Obtener la fecha y hora actual
						LocalDate fechaActual = LocalDate.now();
						LocalTime horaActual = LocalTime.now();

						// Asignar la fecha y hora actual a los campos correspondientes
						registroBitacora.setFechaEntrada(fechaActual);
						registroBitacora.setHoraEntrada(horaActual);

						System.out.println("Corbatin asignado: " + registroBitacora);

						// Finalmente, insertar en la base de datos
						if (personalDao.crearBitacora(registroBitacora)) {
							bitacora.setIdBitacoraCambio(new Date().getTime() + "");
							bitacora.setCuenta(usuarioNombreF);
							bitacora.setTipoCambio("REGISTRO DE ENTRADA");
							bitacora.setFechaCambio(new Date());
							bitacora.setAntes("NA");
							bitacora.setDespues(registroBitacora.toString());

							if (personalDao.crearBitacora(bitacora)) {
								refrescar();
							}
							JOptionPane.showMessageDialog(null, "Se subió el registro", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null, "Error al crear el registro", "Aviso",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});

		btnAgregar.setBounds(360, 128, 140, 37);
		panelFondoParking.add(btnAgregar);

		JButton btnActualizar = new JButton("Registrar salida");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonalDaoImpl personalDao = new PersonalDaoImpl();
				BitacoraCambios bitacora = new BitacoraCambios();

				Bitacora registroBitacora = new Bitacora();
				Corbatines corbatin = new Corbatines();

				try {

					int idRegistro = Integer.parseInt(txtRegistro.getText());
					System.out.println("Registro ID: " + txtRegistro.getText());

					registroBitacora.setIdRegistro(idRegistro);

					// Obtener la fecha y hora actual
					LocalDate fechaActual = LocalDate.now();
					LocalTime horaActual = LocalTime.now();

					// Asignar la fecha y hora actual a los campos correspondientes
					registroBitacora.setFechaEntrada(fechaActual);
					registroBitacora.setHoraEntrada(horaActual);

					if (personalDao.updateRegistroBitacora(registroBitacora)) {
						String idCorbatin, nomina, fechaEntrada, horaEntrada, fechaSalida, horaSalida;

						int selectedRow = tableGeneralIt.getSelectedRow();
						idCorbatin = getCellValue(tableGeneralIt, selectedRow, 0);
						nomina = getCellValue(tableGeneralIt, selectedRow, 1);
						fechaEntrada = getCellValue(tableGeneralIt, selectedRow, 9);
						horaEntrada = getCellValue(tableGeneralIt, selectedRow, 10);
						fechaSalida = getCellValue(tableGeneralIt, selectedRow, 11);
						horaSalida = getCellValue(tableGeneralIt, selectedRow, 12);

						bitacora.setIdBitacoraCambio(new Date().getTime() + "");
						bitacora.setCuenta(usuarioNombreF);
						bitacora.setTipoCambio("REGISTRO SALIDA");
						bitacora.setFechaCambio(new Date());
						bitacora.setAntes("idCorbatin : " + idCorbatin + " | nomina : " + nomina + " | fechaEntrada : "
								+ fechaEntrada + " | horaEntrada : " + horaEntrada + " | fechaSalida : " + fechaSalida
								+ " | horaSalida : " + horaSalida);
						bitacora.setDespues(registroBitacora.toString());

						if (personalDao.crearBitacora(bitacora)) {
							refrescar();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		btnActualizar.setBounds(502, 128, 140, 37);
		panelFondoParking.add(btnActualizar);

		JButton btnReimprimir = new JButton("Reimprimir");
		btnReimprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int estatusAux = 1;
				int selectedRow = tableGeneralIt.getSelectedRow();
				String estatus = getCellValue(tableGeneralIt, selectedRow, 9);

				imprimir(txtNombreEquipo.getText(), txtUsuario.getText(), txtSerial.getText(),
						cbArea.getSelectedItem().toString(), estatusAux, usuarioNombreF);
			}
		});
		btnReimprimir.setBounds(502, 169, 140, 26);
		panelFondoParking.add(btnReimprimir);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUsuario.setText("");
				txtNombreEquipo.setText("");
				txtEquipoAdicional.setText("");
				txtSerial.setText("");
				txtOdservaciones.setText("");
				// cbModelo.setSelectedIndex(0);;
				cbArea.setSelectedIndex(0);
				cbLugar.setSelectedIndex(0);
			}
		});
		btnReset.setBounds(855, 11, 90, 23);
		panelFondoParking.add(btnReset);

		// buscador
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
		tableGeneralIt.setRowSorter(sorter);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(795, 139, 150, 26);
		panelFondoParking.add(textField_3);

		textField_3.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search(textField_3.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				search(textField_3.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				search(textField_3.getText());
			}

			public void search(String str) {
				if (str.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter(str));
				}
			}
		});

		JLabel lblBuscar = new JLabel("Buscar :");
		lblBuscar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscar.setForeground(new Color(38, 75, 102));
		lblBuscar.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblBuscar.setAlignmentX(0.5f);
		lblBuscar.setBounds(693, 139, 92, 26);
		panelFondoParking.add(lblBuscar);

		txtRegistro = new JTextField();
		txtRegistro.setEditable(false);
		txtRegistro.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtRegistro.setBounds(150, 9, 186, 26);
		panelFondoParking.add(txtRegistro);
		txtRegistro.setColumns(5);

		JButton btnActualizarC = new JButton("Actualizar");
		btnActualizarC.setBounds(360, 170, 140, 26);
		panelFondoParking.add(btnActualizarC);

		JLabel lblNmRegistro = new JLabel("N\u00FAm. Registro:");
		lblNmRegistro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmRegistro.setForeground(new Color(38, 75, 102));
		lblNmRegistro.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNmRegistro.setAlignmentX(0.5f);
		lblNmRegistro.setBounds(10, 10, 130, 26);
		panelFondoParking.add(lblNmRegistro);

		JLabel lblNombre = new JLabel("Usuario:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setForeground(new Color(38, 75, 102));
		lblNombre.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNombre.setAlignmentX(0.5f);
		lblNombre.setBounds(364, 41, 80, 26);
		panelFondoParking.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(456, 40, 186, 26);
		panelFondoParking.add(txtNombre);

		JLabel lblTelefno = new JLabel("Telef\u00F3no:");
		lblTelefno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefno.setForeground(new Color(38, 75, 102));
		lblTelefno.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblTelefno.setAlignmentX(0.5f);
		lblTelefno.setBounds(364, 73, 80, 26);
		panelFondoParking.add(lblTelefno);

		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(456, 71, 186, 26);
		panelFondoParking.add(txtTelefono);

		// Se agrega un ListSelectionListener a la tabla tableGeneralIt,
		// lo que permite realizar acciones cuando el usuario selecciona una fila en la
		// tabla
		tableGeneralIt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					int selectedRow;
					String idRegistro, corbatin, nomina, telefono, usuario, vehiculo, modelo, placas, color;

					selectedRow = tableGeneralIt.getSelectedRow();
					if (selectedRow >= 0) {
						idRegistro = getCellValue(tableGeneralIt, selectedRow, 0);
						corbatin = getCellValue(tableGeneralIt, selectedRow, 1);
						nomina = getCellValue(tableGeneralIt, selectedRow, 2);
						usuario = getCellValue(tableGeneralIt, selectedRow, 3);
						telefono = getCellValue(tableGeneralIt, selectedRow, 4);

						vehiculo = getCellValue(tableGeneralIt, selectedRow, 5);
						placas = getCellValue(tableGeneralIt, selectedRow, 6);
						modelo = getCellValue(tableGeneralIt, selectedRow, 7);
						color = getCellValue(tableGeneralIt, selectedRow, 8);

						txtCorbatin.setText(corbatin);
						txtUsuario.setText(nomina);
						txtTelefono.setText(telefono);
						txtNombre.setText(usuario);
						txtIdTipoVehiculo.setText(vehiculo);
						txtPlacasVehiculo.setText(placas);
						txtModeloVehiculo.setText(modelo);
						txtColorVehiculo.setText(color);
						txtRegistro.setText(idRegistro);

						// Convertir LocalDate y LocalTime a String usando los formatos definidos
						/*
						 * row[9] = a.getFechaEntrada() != null ?
						 * a.getFechaEntrada().format(dateFormatter) : ""; row[10] = a.getHoraEntrada()
						 * != null ? a.getHoraEntrada().format(timeFormatter) : ""; row[11] =
						 * a.getFechaSalida() != null ? a.getFechaSalida().format(dateFormatter) : "";
						 * row[12] = a.getHoraSalida() != null ? a.getHoraSalida().format(timeFormatter)
						 * : "";
						 */

					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		JPanel panelTelefono = new JPanel();
		panelTelefono.setLayout(null);
		panelTelefono.setBackground(new Color(38, 75, 102));
		tabbedPane_1.addTab("Vehículos", iconCar, panelTelefono);

		JPanel panelFondoTelefono = new JPanel();
		panelFondoTelefono.setLayout(null);
		panelFondoTelefono.setBackground(Color.WHITE);
		panelFondoTelefono.setBounds(10, 11, 955, 553);
		panelTelefono.add(panelFondoTelefono);

		JScrollPane scrollTelefono = new JScrollPane();
		scrollTelefono.setBounds(10, 176, 935, 366);
		panelFondoTelefono.add(scrollTelefono);

		tablaTelefonos = new JTable();
		tablaTelefonos.setModel(modelT);
		scrollTelefono.setViewportView(tablaTelefonos);

		tablaTelefonos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					int selectedRow;
					String id, usuario, area, numero, modelo, ime, estatus, observaciones;

					selectedRow = tablaTelefonos.getSelectedRow();
					if (selectedRow >= 0) {
						id = getCellValue(tablaTelefonos, selectedRow, 0);
						usuario = getCellValue(tablaTelefonos, selectedRow, 1);
						area = getCellValue(tablaTelefonos, selectedRow, 2);
						numero = getCellValue(tablaTelefonos, selectedRow, 3);
						modelo = getCellValue(tablaTelefonos, selectedRow, 4);
						ime = getCellValue(tablaTelefonos, selectedRow, 5);
						estatus = getCellValue(tablaTelefonos, selectedRow, 6);
						observaciones = getCellValue(tablaTelefonos, selectedRow, 7);

						if (estatus.equals("0")) {
							cbEstatusTelefono.setSelectedItem("Almacen");
							lblEstatusTelefono.setText("en Almacen");
						}

						if (estatus.equals("1")) {
							cbEstatusTelefono.setSelectedItem("Asignar");
							lblEstatusTelefono.setText("Asignada");
						}

						if (estatus.equals("2")) {
							cbEstatusTelefono.setSelectedItem("Mantenimiento");
							lblEstatusTelefono.setText("en Mantenimiento");
						}

						txtObservacionesTelefono.setText(observaciones);
						lblIdTelefono.setText(id);
						txtUsuarioTelefono.setText(usuario);
						cbAreaTelefono.setSelectedItem(area);
						cbModeloTelefono.setSelectedItem(modelo);
						txtNumeroTelefono.setText(numero);
						txtIME.setText(ime);

					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		JTextPane textPane_2_1 = new JTextPane();
		textPane_2_1.setBounds(43, 436, 6, 20);
		panelFondoTelefono.add(textPane_2_1);

		JLabel lblRegistroP_2_1 = new JLabel("");
		lblRegistroP_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistroP_2_1.setForeground(new Color(38, 75, 102));
		lblRegistroP_2_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblRegistroP_2_1.setAlignmentX(0.5f);
		lblRegistroP_2_1.setBounds(136, 527, 244, 26);
		panelFondoTelefono.add(lblRegistroP_2_1);

		JLabel lblSolicitanteP_2_1 = new JLabel("");
		lblSolicitanteP_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSolicitanteP_2_1.setForeground(new Color(38, 75, 102));
		lblSolicitanteP_2_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblSolicitanteP_2_1.setAlignmentX(0.5f);
		lblSolicitanteP_2_1.setBounds(136, 449, 244, 26);
		panelFondoTelefono.add(lblSolicitanteP_2_1);

		JLabel lblSQAP_2_1 = new JLabel("");
		lblSQAP_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSQAP_2_1.setForeground(new Color(38, 75, 102));
		lblSQAP_2_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblSQAP_2_1.setAlignmentX(0.5f);
		lblSQAP_2_1.setBounds(136, 422, 244, 26);
		panelFondoTelefono.add(lblSQAP_2_1);

		JLabel lblUsuarioTelefono = new JLabel("Usuario :");
		lblUsuarioTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuarioTelefono.setForeground(new Color(38, 75, 102));
		lblUsuarioTelefono.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblUsuarioTelefono.setAlignmentX(0.5f);
		lblUsuarioTelefono.setBounds(0, 23, 98, 26);
		panelFondoTelefono.add(lblUsuarioTelefono);

		txtUsuarioTelefono = new JTextField();
		txtUsuarioTelefono.setColumns(10);
		txtUsuarioTelefono.setBounds(108, 23, 225, 26);
		panelFondoTelefono.add(txtUsuarioTelefono);

		JLabel lblAreaTelefono = new JLabel("\u00C1rea :");
		lblAreaTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAreaTelefono.setForeground(new Color(38, 75, 102));
		lblAreaTelefono.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblAreaTelefono.setAlignmentX(0.5f);
		lblAreaTelefono.setBounds(0, 52, 97, 26);
		panelFondoTelefono.add(lblAreaTelefono);

		txtNumeroTelefono = new JTextField();
		txtNumeroTelefono.setColumns(10);
		txtNumeroTelefono.setBounds(108, 81, 225, 26);
		panelFondoTelefono.add(txtNumeroTelefono);

		JLabel lblNumeroTelefono = new JLabel("Numero :");
		lblNumeroTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTelefono.setForeground(new Color(38, 75, 102));
		lblNumeroTelefono.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNumeroTelefono.setAlignmentX(0.5f);
		lblNumeroTelefono.setBounds(0, 81, 98, 26);
		panelFondoTelefono.add(lblNumeroTelefono);

		JLabel lblModeloTelefono = new JLabel("Modelo :");
		lblModeloTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModeloTelefono.setForeground(new Color(38, 75, 102));
		lblModeloTelefono.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblModeloTelefono.setAlignmentX(0.5f);
		lblModeloTelefono.setBounds(0, 110, 98, 26);
		panelFondoTelefono.add(lblModeloTelefono);

		lblEstatusTelefono = new JLabel("En espera");
		lblEstatusTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstatusTelefono.setForeground(Color.ORANGE);
		lblEstatusTelefono.setFont(new Font("Consolas", Font.PLAIN, 35));
		lblEstatusTelefono.setAlignmentX(0.5f);
		lblEstatusTelefono.setBounds(711, 68, 209, 53);
		panelFondoTelefono.add(lblEstatusTelefono);

		JLabel lblEstatusTitleTelefonos = new JLabel("Estatus");
		lblEstatusTitleTelefonos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstatusTitleTelefonos.setForeground(new Color(38, 75, 102));
		lblEstatusTitleTelefonos.setFont(new Font("Consolas", Font.PLAIN, 35));
		lblEstatusTitleTelefonos.setAlignmentX(0.5f);
		lblEstatusTitleTelefonos.setBounds(711, 45, 209, 41);
		panelFondoTelefono.add(lblEstatusTitleTelefonos);

		JLabel lblImeTelefonos = new JLabel("IME :");
		lblImeTelefonos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImeTelefonos.setForeground(new Color(38, 75, 102));
		lblImeTelefonos.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblImeTelefonos.setAlignmentX(0.5f);
		lblImeTelefonos.setBounds(393, 23, 64, 26);
		panelFondoTelefono.add(lblImeTelefonos);

		txtIME = new JTextField();
		txtIME.setColumns(10);
		txtIME.setBounds(467, 23, 208, 26);
		panelFondoTelefono.add(txtIME);

		JButton btnAgregarTelefono = new JButton("Agregar");
		btnAgregarTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Telefono telefono = new Telefono();
				Telefono telefonoAux = new Telefono();
				PersonalDaoImpl personalDao = new PersonalDaoImpl();

				if (txtUsuario.getText() != null && txtUsuario.getText() != "") {
					if (cbArea.getSelectedItem().toString() != null && cbArea.getSelectedItem().toString() != "") {
						if (txtNombreEquipo.getText() != null && txtNombreEquipo.getText() != "") {
							if (txtSerial.getText() != null && txtSerial.getText() != "") {
								if (cbModeloTelefono.getSelectedItem().toString() != null
										&& cbModeloTelefono.getSelectedItem().toString() != "") {

									telefonoAux = personalDao.verificacionTelefono(txtIME.getText());

									if (telefonoAux == null) {

										telefono.setIdTelefono(new Date().getTime() + "");
										telefono.setUsuario(txtUsuarioTelefono.getText());
										telefono.setArea(cbAreaTelefono.getSelectedItem().toString());
										telefono.setNumero(txtNumeroTelefono.getText());
										telefono.setIme(txtIME.getText());
										telefono.setModelo(cbModeloTelefono.getSelectedItem().toString());
										telefono.setObservaciones(txtObservacionesTelefono.getText());

										if (cbEstatusTelefono.getSelectedItem().toString().equals("Asignar")) {
											telefono.setEstatus(1);
										}
										if (cbEstatusTelefono.getSelectedItem().toString().equals("Almacen")) {
											telefono.setEstatus(0);
										}
										if (cbEstatusTelefono.getSelectedItem().toString().equals("Mantenimiento")) {
											telefono.setEstatus(2);
										}

										if (personalDao.crearTelefono(telefono)) {

											if (!cbEstatusTelefono.getSelectedItem().toString()
													.equals("Mantenimiento")) {
												imprimirTelefono(txtNumeroTelefono.getText(),
														txtUsuarioTelefono.getText(), txtIME.getText(),
														cbAreaTelefono.getSelectedItem().toString(),
														telefono.getEstatus(), usuarioNombreF);
											}
											refrescarTelefono();
											txtUsuarioTelefono.setText("");
											cbAreaTelefono.setSelectedIndex(0);
											;
											txtNumeroTelefono.setText("");
											txtIME.setText("");
											txtEquipoAdicional.setText("");
											cbModeloTelefono.setSelectedIndex(0);
											cbEstatusTelefono.setSelectedIndex(0);
											cbAreaTelefono.setSelectedIndex(0);
											JOptionPane.showMessageDialog(null, "Se subio el registro", "Aviso",
													JOptionPane.INFORMATION_MESSAGE);
										} else {
											JOptionPane.showMessageDialog(null, "Error al crear el registro", "Aviso",
													JOptionPane.ERROR_MESSAGE);
										}
									} else {
										JOptionPane.showMessageDialog(null,
												"No se pudo subir ya existe un registro con ese numero de serie : "
														+ telefonoAux.getIdTelefono() + " con el usuario "
														+ telefonoAux.getIme() + " "
														+ "elimine el actual o actualice el numero de serie.",
												"Aviso", JOptionPane.ERROR_MESSAGE);

									}
								}
							}
						}
					}
				}
			}
		});
		btnAgregarTelefono.setBounds(353, 90, 322, 37);
		panelFondoTelefono.add(btnAgregarTelefono);

		JButton btnActualizarTelefono = new JButton("Actualizar");
		btnActualizarTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonalDaoImpl personalDao = new PersonalDaoImpl();
				Telefono telefono = new Telefono();

				try {
					telefono.setIdTelefono(lblIdTelefono.getText());
					telefono.setUsuario(txtUsuarioTelefono.getText());
					telefono.setArea(cbAreaTelefono.getSelectedItem().toString());
					telefono.setNumero(txtNumeroTelefono.getText());
					telefono.setIme(txtIME.getText());
					telefono.setModelo(cbModeloTelefono.getSelectedItem().toString());

					if (cbEstatusTelefono.getSelectedItem().toString().equals("Asignar")) {
						telefono.setEstatus(1);
					}
					if (cbEstatusTelefono.getSelectedItem().toString().equals("Almacen")) {
						telefono.setEstatus(0);
					}
					if (cbEstatusTelefono.getSelectedItem().toString().equals("Mantenimiento")) {
						telefono.setEstatus(2);
					}

					telefono.setObservaciones(txtObservacionesTelefono.getText());

					if (personalDao.actualizarTelefono(telefono)) {
						refrescarTelefono();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnActualizarTelefono.setBounds(353, 132, 150, 33);
		panelFondoTelefono.add(btnActualizarTelefono);

		JButton btnEliminarTelefono = new JButton("Eliminar");
		btnEliminarTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (lblIdTelefono.getText() == null && lblIdTelefono.getText() == "") {

				} else {
					PersonalDaoImpl personalDao = new PersonalDaoImpl();
					if (personalDao.bajaEstatusTelefonos(lblIdTelefono.getText())) {
						int i = tablaTelefonos.getSelectedRow();
						modelT.removeRow(i);
						txtUsuarioTelefono.setText("");
						cbAreaTelefono.setSelectedIndex(0);
						;
						txtNumeroTelefono.setText("");
						txtIME.setText("");
						txtEquipoAdicional.setText("");
						cbModeloTelefono.setSelectedIndex(0);
						;
						JOptionPane.showMessageDialog(null, "Registro removida");
					} else {
						JOptionPane.showMessageDialog(null, "Error");
					}
				}

			}
		});
		btnEliminarTelefono.setBounds(525, 132, 150, 33);
		panelFondoTelefono.add(btnEliminarTelefono);

		JButton btnReimprimirTelefono = new JButton("Reimprimir");
		btnReimprimirTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = tablaTelefonos.getSelectedRow();
				String estatus = getCellValue(tablaTelefonos, selectedRow, 6);

				if (!cbEstatusTelefono.getSelectedItem().toString().equals("Mantenimiento")) {
					imprimirTelefono(txtNumeroTelefono.getText(), txtUsuarioTelefono.getText(), txtIME.getText(),
							cbAreaTelefono.getSelectedItem().toString(), Integer.parseInt(estatus), usuarioNombreF);
				}

			}
		});
		btnReimprimirTelefono.setBounds(711, 11, 134, 23);
		panelFondoTelefono.add(btnReimprimirTelefono);

		JButton btnResetTelefonos = new JButton("Reset");
		btnResetTelefonos.setBounds(855, 11, 90, 23);
		panelFondoTelefono.add(btnResetTelefonos);

		TableRowSorter<TableModel> sorterT = new TableRowSorter<>(modelT);
		tablaTelefonos.setRowSorter(sorterT);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(795, 129, 150, 26);
		panelFondoTelefono.add(textField_4);

		textField_4.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search(textField_4.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				search(textField_4.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				search(textField_4.getText());
			}

			public void search(String str) {
				if (str.length() == 0) {
					sorterT.setRowFilter(null);
				} else {
					sorterT.setRowFilter(RowFilter.regexFilter(str));
				}
			}
		});

		JLabel lblBuscarTelefono = new JLabel("Buscar :");
		lblBuscarTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscarTelefono.setForeground(new Color(38, 75, 102));
		lblBuscarTelefono.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblBuscarTelefono.setAlignmentX(0.5f);
		lblBuscarTelefono.setBounds(685, 129, 100, 26);
		panelFondoTelefono.add(lblBuscarTelefono);

		cbAreaTelefono = new JComboBox<String>();
		/*
		 * for (Areas a: daoPersonal.consultarAreas()) {
		 * cbAreaTelefono.addItem(a.getNombreArea()); }
		 */
		cbAreaTelefono.setBounds(108, 52, 225, 26);
		panelFondoTelefono.add(cbAreaTelefono);

		cbModeloTelefono = new JComboBox<String>();
		/*
		 * for (Modelos a: daoPersonal.consultarModelos()) { if
		 * (a.getTipoModelo().equals("TELEFONO")) {
		 * cbModeloTelefono.addItem(a.getNombreModelo()); } }
		 */
		cbModeloTelefono.setBounds(108, 110, 225, 26);
		panelFondoTelefono.add(cbModeloTelefono);

		JLabel lblObservacionesTelefonos = new JLabel("Observaciones:");
		lblObservacionesTelefonos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObservacionesTelefonos.setForeground(new Color(38, 75, 102));
		lblObservacionesTelefonos.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblObservacionesTelefonos.setAlignmentX(0.5f);
		lblObservacionesTelefonos.setBounds(343, 52, 114, 26);
		panelFondoTelefono.add(lblObservacionesTelefonos);

		txtObservacionesTelefono = new JTextField();
		txtObservacionesTelefono.setColumns(10);
		txtObservacionesTelefono.setBounds(467, 52, 208, 26);
		panelFondoTelefono.add(txtObservacionesTelefono);

		JLabel lblEstatusTel = new JLabel("Estatus :");
		lblEstatusTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstatusTel.setForeground(new Color(38, 75, 102));
		lblEstatusTel.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblEstatusTel.setAlignmentX(0.5f);
		lblEstatusTel.setBounds(0, 139, 98, 26);
		panelFondoTelefono.add(lblEstatusTel);

		cbEstatusTelefono = new JComboBox<String>();
		cbEstatusTelefono.addItem("Asignar");
		cbEstatusTelefono.addItem("Almacen");
		cbEstatusTelefono.addItem("Mantenimiento");
		cbEstatusTelefono.setBounds(108, 139, 225, 26);
		panelFondoTelefono.add(cbEstatusTelefono);

		JPanel panelOtros = new JPanel();
		panelOtros.setLayout(null);
		panelOtros.setBackground(new Color(38, 75, 102));
		tabbedPane_1.addTab("Corbatines", iconCorbatines, panelOtros);

		JPanel panelFondoOtros = new JPanel();
		panelFondoOtros.setLayout(null);
		panelFondoOtros.setBackground(Color.WHITE);
		panelFondoOtros.setBounds(10, 11, 955, 553);
		panelOtros.add(panelFondoOtros);

		JScrollPane scrollOtros = new JScrollPane();
		scrollOtros.setBounds(10, 147, 935, 395);
		panelFondoOtros.add(scrollOtros);

		tablaOtros = new JTable();
		tablaOtros.setModel(modelO);
		scrollOtros.setViewportView(tablaOtros);

		tablaOtros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					int selectedRow;
					String id, usuario, area, nombre, descripcion, cantidad, estado;

					selectedRow = tablaOtros.getSelectedRow();
					if (selectedRow >= 0) {

						id = getCellValue(tablaOtros, selectedRow, 0);
						usuario = getCellValue(tablaOtros, selectedRow, 1);
						area = getCellValue(tablaOtros, selectedRow, 2);
						nombre = getCellValue(tablaOtros, selectedRow, 3);
						descripcion = getCellValue(tablaOtros, selectedRow, 4);
						cantidad = getCellValue(tablaOtros, selectedRow, 5);
						estado = getCellValue(tablaOtros, selectedRow, 6);

						lblIdOtrosT.setText(id);
						txtUsuarioOtros.setText(usuario);
						txtAreaOtros.setText(area);
						txtNombreEquipoOtros.setText(nombre);
						txtDescripcionOtros.setText(descripcion);
						txtCantidadOtros.setText(cantidad);

					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(43, 436, 6, 20);
		panelFondoOtros.add(textPane_2);

		JLabel lblRegistroP_2 = new JLabel("");
		lblRegistroP_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistroP_2.setForeground(new Color(38, 75, 102));
		lblRegistroP_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblRegistroP_2.setAlignmentX(0.5f);
		lblRegistroP_2.setBounds(136, 527, 244, 26);
		panelFondoOtros.add(lblRegistroP_2);

		JLabel lblSolicitanteP_2 = new JLabel("");
		lblSolicitanteP_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblSolicitanteP_2.setForeground(new Color(38, 75, 102));
		lblSolicitanteP_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblSolicitanteP_2.setAlignmentX(0.5f);
		lblSolicitanteP_2.setBounds(136, 449, 244, 26);
		panelFondoOtros.add(lblSolicitanteP_2);

		JLabel lblSQAP_2 = new JLabel("");
		lblSQAP_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblSQAP_2.setForeground(new Color(38, 75, 102));
		lblSQAP_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblSQAP_2.setAlignmentX(0.5f);
		lblSQAP_2.setBounds(136, 422, 244, 26);
		panelFondoOtros.add(lblSQAP_2);

		JLabel lblUsuarioOtros = new JLabel("Usuario :");
		lblUsuarioOtros.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuarioOtros.setForeground(new Color(38, 75, 102));
		lblUsuarioOtros.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblUsuarioOtros.setAlignmentX(0.5f);
		lblUsuarioOtros.setBounds(10, 23, 132, 26);
		panelFondoOtros.add(lblUsuarioOtros);

		txtUsuarioOtros = new JTextField();
		txtUsuarioOtros.setColumns(10);
		txtUsuarioOtros.setBounds(152, 23, 225, 26);
		panelFondoOtros.add(txtUsuarioOtros);

		JLabel lblAreaOtros = new JLabel("\u00C1rea :");
		lblAreaOtros.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAreaOtros.setForeground(new Color(38, 75, 102));
		lblAreaOtros.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblAreaOtros.setAlignmentX(0.5f);
		lblAreaOtros.setBounds(10, 52, 131, 26);
		panelFondoOtros.add(lblAreaOtros);

		txtAreaOtros = new JTextField();
		txtAreaOtros.setColumns(10);
		txtAreaOtros.setBounds(152, 52, 225, 26);
		panelFondoOtros.add(txtAreaOtros);

		txtNombreEquipoOtros = new JTextField();
		txtNombreEquipoOtros.setColumns(10);
		txtNombreEquipoOtros.setBounds(152, 81, 225, 26);
		panelFondoOtros.add(txtNombreEquipoOtros);

		JLabel lblLugarOtros = new JLabel("Nombre equipo :");
		lblLugarOtros.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLugarOtros.setForeground(new Color(38, 75, 102));
		lblLugarOtros.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblLugarOtros.setAlignmentX(0.5f);
		lblLugarOtros.setBounds(10, 81, 132, 26);
		panelFondoOtros.add(lblLugarOtros);

		JLabel lblDescripcionOtros = new JLabel("Descripcion o Serial :");
		lblDescripcionOtros.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcionOtros.setForeground(new Color(38, 75, 102));
		lblDescripcionOtros.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblDescripcionOtros.setAlignmentX(0.5f);
		lblDescripcionOtros.setBounds(387, 23, 183, 26);
		panelFondoOtros.add(lblDescripcionOtros);

		txtDescripcionOtros = new JTextField();
		txtDescripcionOtros.setColumns(10);
		txtDescripcionOtros.setBounds(580, 23, 239, 26);
		panelFondoOtros.add(txtDescripcionOtros);

		JLabel lblCantidadOtros = new JLabel("Cantidad :");
		lblCantidadOtros.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadOtros.setForeground(new Color(38, 75, 102));
		lblCantidadOtros.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblCantidadOtros.setAlignmentX(0.5f);
		lblCantidadOtros.setBounds(405, 52, 165, 26);
		panelFondoOtros.add(lblCantidadOtros);

		txtCantidadOtros = new JTextField();
		txtCantidadOtros.setColumns(10);
		txtCantidadOtros.setBounds(580, 52, 97, 26);
		panelFondoOtros.add(txtCantidadOtros);

		JButton btnActualizarOtros = new JButton("Actualizar");
		btnActualizarOtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonalDaoImpl personalDao = new PersonalDaoImpl();
				Otros otros = new Otros();

				try {

					otros.setIdOtros(lblIdOtrosT.getText());
					otros.setUsuario(txtUsuarioOtros.getText());
					otros.setArea(txtAreaOtros.getText());
					otros.setNombreEquipo(txtNombreEquipoOtros.getText());
					otros.setDescripcion(txtDescripcionOtros.getText());
					otros.setCantidad(Integer.parseInt(txtCantidadOtros.getText()));
					otros.setEstatus(1);

					if (personalDao.actualizarOtros(otros)) {
						refrescarOtros();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnActualizarOtros.setBounds(580, 113, 90, 23);
		panelFondoOtros.add(btnActualizarOtros);

		JButton btnEliminarOtros = new JButton("Eliminar");
		btnEliminarOtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonalDaoImpl personalDao = new PersonalDaoImpl();
				Otros otros = new Otros();

				try {

					otros.setIdOtros(lblIdOtrosT.getText());
					otros.setUsuario(txtUsuarioOtros.getText());
					otros.setArea(txtAreaOtros.getText());
					otros.setNombreEquipo(txtNombreEquipoOtros.getText());
					otros.setDescripcion(txtDescripcionOtros.getText());
					otros.setCantidad(Integer.parseInt(txtCantidadOtros.getText()));
					otros.setEstatus(0);

					if (personalDao.actualizarOtros(otros)) {
						refrescarOtros();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnEliminarOtros.setBounds(682, 113, 90, 23);
		panelFondoOtros.add(btnEliminarOtros);

		JButton btnReimprimirOtros = new JButton("Reimprimir");
		btnReimprimirOtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimir(txtNombreEquipoOtros.getText(), txtUsuarioOtros.getText(), txtDescripcionOtros.getText(),
						txtAreaOtros.getText().toString(), 1, usuarioNombreF);
			}
		});
		btnReimprimirOtros.setBounds(848, 45, 97, 23);
		panelFondoOtros.add(btnReimprimirOtros);

		JButton btnResetOtros = new JButton("Reset");
		btnResetOtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refrescarOtros();
			}
		});
		btnResetOtros.setBounds(848, 11, 97, 23);
		panelFondoOtros.add(btnResetOtros);

		JLabel lblEquipoAdicional_1_2 = new JLabel("PC");
		lblEquipoAdicional_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEquipoAdicional_1_2.setForeground(new Color(38, 75, 102));
		lblEquipoAdicional_1_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblEquipoAdicional_1_2.setAlignmentX(0.5f);
		lblEquipoAdicional_1_2.setBounds(687, 52, 52, 26);
		panelFondoOtros.add(lblEquipoAdicional_1_2);

		JButton btnAgregarOtros = new JButton("Agregar");
		btnAgregarOtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Otros telefono = new Otros();
				Otros telefonoAux = new Otros();
				PersonalDaoImpl personalDao = new PersonalDaoImpl();

				if (txtUsuarioOtros.getText() != null && txtUsuarioOtros.getText() != "") {
					if (txtAreaOtros.getText().toString() != null && txtAreaOtros.getText().toString() != "") {
						if (txtNombreEquipoOtros.getText() != null && txtNombreEquipoOtros.getText() != "") {
							if (txtDescripcionOtros.getText() != null && txtDescripcionOtros.getText() != "") {
								if (txtDescripcionOtros.getText().toString() != null
										&& txtDescripcionOtros.getText().toString() != "") {

									telefono.setIdOtros(new Date().getTime() + "");
									telefono.setUsuario(txtUsuarioOtros.getText());
									telefono.setArea(txtAreaOtros.getText());
									telefono.setNombreEquipo(txtNombreEquipoOtros.getText());
									telefono.setDescripcion(txtDescripcionOtros.getText());
									telefono.setCantidad(Integer.parseInt(txtCantidadOtros.getText()));
									telefono.setEstatus(1);

									if (personalDao.crearOtros(telefono)) {

										if (!cbEstatusTelefono.getSelectedItem().toString().equals("Mantenimiento")) {
											if (rbtnEtiquetaOtros.isSelected()) {
												imprimir(txtNombreEquipoOtros.getText(), txtUsuarioOtros.getText(),
														txtDescripcionOtros.getText(),
														txtAreaOtros.getText().toString(), 1, usuarioNombreF);
											}
										}
										refrescarOtros();
										txtUsuarioTelefono.setText("");
										cbAreaTelefono.setSelectedIndex(0);
										;
										txtNumeroTelefono.setText("");
										txtIME.setText("");
										txtEquipoAdicional.setText("");
										cbModeloTelefono.setSelectedIndex(0);
										cbEstatusTelefono.setSelectedIndex(0);
										cbAreaTelefono.setSelectedIndex(0);
										JOptionPane.showMessageDialog(null, "Se subio el registro", "Aviso",
												JOptionPane.INFORMATION_MESSAGE);
									} else {
										JOptionPane.showMessageDialog(null, "Error al crear el registro", "Aviso",
												JOptionPane.ERROR_MESSAGE);
									}
								}
							}
						}
					}
				}
			}
		});
		btnAgregarOtros.setBounds(480, 113, 90, 23);
		panelFondoOtros.add(btnAgregarOtros);

		lblIdOtrosT = new JLabel("");
		lblIdOtrosT.setBounds(0, 0, 46, 14);
		panelFondoOtros.add(lblIdOtrosT);

		rbtnEtiquetaOtros = new JRadioButton("Selecciona si quieres imprimir etiqueta");
		rbtnEtiquetaOtros.setBounds(580, 84, 227, 20);
		panelFondoOtros.add(rbtnEtiquetaOtros);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(38, 75, 102));
		ImageIcon icon1 = new ImageIcon(AltaDatosiT.class.getResource("/com/grammer/imgs/peticion.png"));
		tabbedPane_1.addTab("Historico", icon1, panel);

		JPanel panelPeticiones_1 = new JPanel();
		panelPeticiones_1.setLayout(null);
		panelPeticiones_1.setBackground(Color.WHITE);
		panelPeticiones_1.setBounds(10, 11, 955, 553);
		panel.add(panelPeticiones_1);

		JScrollPane scrollPeticion_1 = new JScrollPane();
		scrollPeticion_1.setBounds(10, 98, 935, 444);
		panelPeticiones_1.add(scrollPeticion_1);

		tablaBitacora = new JTable();
		tablaBitacora.setModel(modelB);
		scrollPeticion_1.setViewportView(tablaBitacora);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(43, 436, 6, 20);
		panelPeticiones_1.add(textPane_1);

		JLabel lblRegistroP_1 = new JLabel("");
		lblRegistroP_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistroP_1.setForeground(new Color(38, 75, 102));
		lblRegistroP_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblRegistroP_1.setAlignmentX(0.5f);
		lblRegistroP_1.setBounds(136, 527, 244, 26);
		panelPeticiones_1.add(lblRegistroP_1);

		JLabel lblSolicitanteP_1 = new JLabel("");
		lblSolicitanteP_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSolicitanteP_1.setForeground(new Color(38, 75, 102));
		lblSolicitanteP_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblSolicitanteP_1.setAlignmentX(0.5f);
		lblSolicitanteP_1.setBounds(136, 449, 244, 26);
		panelPeticiones_1.add(lblSolicitanteP_1);

		JLabel lblSQAP_1 = new JLabel("");
		lblSQAP_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSQAP_1.setForeground(new Color(38, 75, 102));
		lblSQAP_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblSQAP_1.setAlignmentX(0.5f);
		lblSQAP_1.setBounds(136, 422, 244, 26);
		panelPeticiones_1.add(lblSQAP_1);

		JLabel lbll1_1_3_2 = new JLabel("Buscar :");
		lbll1_1_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbll1_1_3_2.setForeground(new Color(38, 75, 102));
		lbll1_1_3_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbll1_1_3_2.setAlignmentX(0.5f);
		lbll1_1_3_2.setBounds(552, 61, 150, 26);
		panelPeticiones_1.add(lbll1_1_3_2);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(710, 61, 235, 26);
		panelPeticiones_1.add(textField_8);

		JLabel lblHistorico = new JLabel("Historico de cambios");
		lblHistorico.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistorico.setForeground(new Color(38, 75, 102));
		lblHistorico.setFont(new Font("Consolas", Font.BOLD, 24));
		lblHistorico.setAlignmentX(0.5f);
		lblHistorico.setBounds(172, 10, 553, 40);
		panelPeticiones_1.add(lblHistorico);

		JButton btnAgregar_1_1 = new JButton("Exportar a excel");
		btnAgregar_1_1.setBounds(10, 10, 120, 23);
		panelPeticiones_1.add(btnAgregar_1_1);

		JButton btnAgregar_1_1_1 = new JButton("Refrescar");
		btnAgregar_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refrescarBitacora();
			}
		});
		btnAgregar_1_1_1.setBounds(10, 63, 120, 23);
		panelPeticiones_1.add(btnAgregar_1_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(38, 75, 102));
		tabbedPane_1.addTab("Configuraciones", null, panel_1, null);

		JPanel panelPeticiones_1_1 = new JPanel();
		panelPeticiones_1_1.setLayout(null);
		panelPeticiones_1_1.setBackground(Color.WHITE);
		panelPeticiones_1_1.setBounds(10, 11, 955, 553);
		panel_1.add(panelPeticiones_1_1);

		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(43, 436, 6, 20);
		panelPeticiones_1_1.add(textPane_1_1);

		JLabel lblRegistroP_1_1 = new JLabel("");
		lblRegistroP_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistroP_1_1.setForeground(new Color(38, 75, 102));
		lblRegistroP_1_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblRegistroP_1_1.setAlignmentX(0.5f);
		lblRegistroP_1_1.setBounds(136, 527, 244, 26);
		panelPeticiones_1_1.add(lblRegistroP_1_1);

		JLabel lblSolicitanteP_1_1 = new JLabel("");
		lblSolicitanteP_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSolicitanteP_1_1.setForeground(new Color(38, 75, 102));
		lblSolicitanteP_1_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblSolicitanteP_1_1.setAlignmentX(0.5f);
		lblSolicitanteP_1_1.setBounds(136, 449, 244, 26);
		panelPeticiones_1_1.add(lblSolicitanteP_1_1);

		JLabel lblSQAP_1_1 = new JLabel("");
		lblSQAP_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSQAP_1_1.setForeground(new Color(38, 75, 102));
		lblSQAP_1_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblSQAP_1_1.setAlignmentX(0.5f);
		lblSQAP_1_1.setBounds(136, 422, 244, 26);
		panelPeticiones_1_1.add(lblSQAP_1_1);

		JLabel lblConfiguraciones = new JLabel("Configuraciones");
		lblConfiguraciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfiguraciones.setForeground(new Color(38, 75, 102));
		lblConfiguraciones.setFont(new Font("Consolas", Font.BOLD, 24));
		lblConfiguraciones.setAlignmentX(0.5f);
		lblConfiguraciones.setBounds(279, 22, 385, 40);
		panelPeticiones_1_1.add(lblConfiguraciones);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Impresi\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 73, 935, 93);
		panel_2.setBackground(Color.WHITE);
		panelPeticiones_1_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lbll1_1_4_1 = new JLabel("Impresora :");
		lbll1_1_4_1.setBounds(10, 32, 127, 26);
		panel_2.add(lbll1_1_4_1);
		lbll1_1_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbll1_1_4_1.setForeground(new Color(38, 75, 102));
		lbll1_1_4_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbll1_1_4_1.setAlignmentX(0.5f);
		comboBox = new JComboBox<String>();
		comboBox.setBounds(151, 32, 172, 26);
		panel_2.add(comboBox);

		List<String> printerNames = getPrinterNames();
		for (String printerName : printerNames) {
			comboBox.addItem(printerName);
		}

		JCheckBox chImpresionConf = new JCheckBox("Establecer como favorita");
		chImpresionConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chImpresionConf.isSelected()) {
					btnGuardarImpresionConf.setEnabled(true);
				} else {
					btnGuardarImpresionConf.setEnabled(false);
				}
			}
		});
		chImpresionConf.setBounds(343, 34, 172, 23);
		panel_2.add(chImpresionConf);

		btnGuardarImpresionConf = new JButton("Guardar");
		btnGuardarImpresionConf.setEnabled(false);
		btnGuardarImpresionConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Configuraciones configuraciones = new Configuraciones();
				Configuraciones configuracionesAux = new Configuraciones();
				PersonalDaoImpl personalDao = new PersonalDaoImpl();

				configuraciones = personalDao.verificacionImpresora(usuarioNombreF);

				if (configuraciones != null) {
					configuraciones.setImpresora(comboBox.getSelectedItem().toString());
					if (personalDao.actualizarConfiguracion(configuraciones)) {
						JOptionPane.showMessageDialog(null, "Se actualizo tu configuración", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar tu info", "Aviso",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					configuracionesAux.setIdConfiguracion(new Date().getTime() + "");
					configuracionesAux.setCuenta(usuarioNombreF);
					configuracionesAux.setImpresora(comboBox.getSelectedItem().toString());
					if (personalDao.crearConfiguracion(configuracionesAux)) {
						JOptionPane.showMessageDialog(null, "Se agrego tu configuración", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Ocurrio un error al agregar tu info", "Aviso",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnGuardarImpresionConf.setBounds(521, 34, 89, 23);
		panel_2.add(btnGuardarImpresionConf);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cuenta", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1.setBounds(10, 177, 935, 85);
		panelPeticiones_1_1.add(panel_2_1);

		JLabel lbll1_1_4_1_1 = new JLabel("Contrase\u00F1a :");
		lbll1_1_4_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbll1_1_4_1_1.setForeground(new Color(38, 75, 102));
		lbll1_1_4_1_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbll1_1_4_1_1.setAlignmentX(0.5f);
		lbll1_1_4_1_1.setBounds(481, 31, 127, 26);
		panel_2_1.add(lbll1_1_4_1_1);

		JButton btnCambiarContraConf = new JButton("Cambiar");
		btnCambiarContraConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonalDaoImpl personalDao = new PersonalDaoImpl();
				personalDao.actualizacionContraseña(usuarioNombreF, txtPasswordUsuarioConf.getText());
			}
		});
		btnCambiarContraConf.setBounds(810, 33, 89, 23);
		panel_2_1.add(btnCambiarContraConf);

		txtPasswordUsuarioConf = new JTextField();
		txtPasswordUsuarioConf.setColumns(10);
		txtPasswordUsuarioConf.setBounds(618, 31, 172, 26);
		panel_2_1.add(txtPasswordUsuarioConf);

		JLabel lbll1_1_4_1_1_1 = new JLabel("Nombre :");
		lbll1_1_4_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbll1_1_4_1_1_1.setForeground(new Color(38, 75, 102));
		lbll1_1_4_1_1_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbll1_1_4_1_1_1.setAlignmentX(0.5f);
		lbll1_1_4_1_1_1.setBounds(10, 31, 127, 26);
		panel_2_1.add(lbll1_1_4_1_1_1);

		JLabel lblNombreUsuarioConf = new JLabel(usuarioNombreF);
		lblNombreUsuarioConf.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuarioConf.setForeground(new Color(38, 75, 102));
		lblNombreUsuarioConf.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNombreUsuarioConf.setAlignmentX(0.5f);
		lblNombreUsuarioConf.setBounds(147, 31, 127, 26);
		panel_2_1.add(lblNombreUsuarioConf);

		JLabel lbll1_1_4_1_1_1_2 = new JLabel("Rol :");
		lbll1_1_4_1_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbll1_1_4_1_1_1_2.setForeground(new Color(38, 75, 102));
		lbll1_1_4_1_1_1_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbll1_1_4_1_1_1_2.setAlignmentX(0.5f);
		lbll1_1_4_1_1_1_2.setBounds(284, 31, 74, 26);
		panel_2_1.add(lbll1_1_4_1_1_1_2);

		JLabel lblRolUsuarioConf = new JLabel("Administrador");
		lblRolUsuarioConf.setHorizontalAlignment(SwingConstants.CENTER);
		lblRolUsuarioConf.setForeground(new Color(38, 75, 102));
		lblRolUsuarioConf.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblRolUsuarioConf.setAlignmentX(0.5f);
		lblRolUsuarioConf.setBounds(368, 31, 123, 26);
		panel_2_1.add(lblRolUsuarioConf);

		JPanel panelOtros_1 = new JPanel();
		panelOtros_1.setLayout(null);
		panelOtros_1.setBackground(new Color(38, 75, 102));
		tabbedPane_1.addTab("Base de conocimiento", null, panelOtros_1, null);

		JPanel panelFondoOtros_1 = new JPanel();
		panelFondoOtros_1.setLayout(null);
		panelFondoOtros_1.setBackground(Color.WHITE);
		panelFondoOtros_1.setBounds(10, 11, 955, 553);
		panelOtros_1.add(panelFondoOtros_1);

		JScrollPane scrollOtros_1 = new JScrollPane();
		scrollOtros_1.setBounds(17, 123, 278, 419);
		panelFondoOtros_1.add(scrollOtros_1);

		tablaAreasBase = new JTable();
		tablaAreasBase.setModel(modelA);
		scrollOtros_1.setViewportView(tablaAreasBase);

		tablaAreasBase.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					int selectedRow;
					String id, area;

					selectedRow = tablaAreasBase.getSelectedRow();

					if (selectedRow >= 0) {
						id = getCellValue(tablaAreasBase, selectedRow, 0);
						area = getCellValue(tablaAreasBase, selectedRow, 1);

						txtAreaBase.setText(area);
						lblIdAreaBase.setText(id);

					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		JTextPane textPane_2_2 = new JTextPane();
		textPane_2_2.setBounds(43, 436, 6, 20);
		panelFondoOtros_1.add(textPane_2_2);

		JLabel lblRegistroP_2_2 = new JLabel("");
		lblRegistroP_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistroP_2_2.setForeground(new Color(38, 75, 102));
		lblRegistroP_2_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblRegistroP_2_2.setAlignmentX(0.5f);
		lblRegistroP_2_2.setBounds(136, 527, 244, 26);
		panelFondoOtros_1.add(lblRegistroP_2_2);

		JLabel lblSolicitanteP_2_2 = new JLabel("");
		lblSolicitanteP_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblSolicitanteP_2_2.setForeground(new Color(38, 75, 102));
		lblSolicitanteP_2_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblSolicitanteP_2_2.setAlignmentX(0.5f);
		lblSolicitanteP_2_2.setBounds(136, 449, 244, 26);
		panelFondoOtros_1.add(lblSolicitanteP_2_2);

		JLabel lblSQAP_2_2 = new JLabel("");
		lblSQAP_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblSQAP_2_2.setForeground(new Color(38, 75, 102));
		lblSQAP_2_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblSQAP_2_2.setAlignmentX(0.5f);
		lblSQAP_2_2.setBounds(136, 422, 244, 26);
		panelFondoOtros_1.add(lblSQAP_2_2);

		JLabel lblArea_1_2 = new JLabel("\u00C1rea :");
		lblArea_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArea_1_2.setForeground(new Color(38, 75, 102));
		lblArea_1_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblArea_1_2.setAlignmentX(0.5f);
		lblArea_1_2.setBounds(17, 52, 69, 26);
		panelFondoOtros_1.add(lblArea_1_2);

		txtAreaBase = new JTextField();
		txtAreaBase.setColumns(10);
		txtAreaBase.setBounds(96, 52, 165, 26);
		panelFondoOtros_1.add(txtAreaBase);

		JButton btnActualizarBaseArea = new JButton("Actualizar");
		btnActualizarBaseArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Areas area = new Areas();
				PersonalDaoImpl personalDao = new PersonalDaoImpl();

				area.setIdArea(lblIdAreaBase.getText());
				area.setNombreArea(txtAreaBase.getText());

				if (personalDao.actualizarAreas(area)) {
					// refrescarAreas();
					JOptionPane.showMessageDialog(null, "Se actualizo el registro", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Ocurrio un error", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnActualizarBaseArea.setBounds(120, 89, 79, 23);
		panelFondoOtros_1.add(btnActualizarBaseArea);

		JButton btnEliminarBaseArea = new JButton("Eliminar");
		btnEliminarBaseArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Areas area = new Areas();
				PersonalDaoImpl personalDao = new PersonalDaoImpl();

				area.setIdArea(lblIdAreaBase.getText());
				area.setNombreArea(txtAreaBase.getText());

				/*
				 * if (personalDao.eliminarAreas(area)) { refrescarAreas();
				 * JOptionPane.showMessageDialog(null, "Se elimino el registro", "Aviso",
				 * JOptionPane.INFORMATION_MESSAGE); } else {
				 * JOptionPane.showMessageDialog(null, "Ocurrio un error", "Aviso",
				 * JOptionPane.ERROR_MESSAGE); }
				 */

			}
		});
		btnEliminarBaseArea.setBounds(209, 89, 69, 23);
		panelFondoOtros_1.add(btnEliminarBaseArea);

		JButton btnAgregarBaseArea = new JButton("Agregar");
		btnAgregarBaseArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Areas area = new Areas();
				PersonalDaoImpl personalDao = new PersonalDaoImpl();

				area.setIdArea(new Date().getTime() + "");
				area.setNombreArea(txtAreaBase.getText());

				if (personalDao.crearAreas(area)) {
					refrescarAreas();
					JOptionPane.showMessageDialog(null, "Se subio el registro", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Ocurrio un error", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAgregarBaseArea.setBounds(27, 89, 79, 23);
		panelFondoOtros_1.add(btnAgregarBaseArea);

		lblIdAreaBase = new JLabel("Usuario :");
		lblIdAreaBase.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdAreaBase.setForeground(Color.WHITE);
		lblIdAreaBase.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblIdAreaBase.setAlignmentX(0.5f);
		lblIdAreaBase.setBounds(16, 0, 69, 26);
		panelFondoOtros_1.add(lblIdAreaBase);

		lblIdModelos = new JLabel("Usuario :");
		lblIdModelos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdModelos.setForeground(Color.WHITE);
		lblIdModelos.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblIdModelos.setAlignmentX(0.5f);
		lblIdModelos.setBounds(90, 0, 69, 26);
		panelFondoOtros_1.add(lblIdModelos);

		lblIdLugares = new JLabel("Usuario :");
		lblIdLugares.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdLugares.setForeground(Color.WHITE);
		lblIdLugares.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblIdLugares.setAlignmentX(0.5f);
		lblIdLugares.setBounds(166, 0, 69, 26);
		panelFondoOtros_1.add(lblIdLugares);

		JScrollPane scrollOtros_1_1 = new JScrollPane();
		scrollOtros_1_1.setBounds(318, 123, 328, 419);
		panelFondoOtros_1.add(scrollOtros_1_1);

		tablaModelosBase = new JTable();
		tablaModelosBase.setModel(modelM);
		scrollOtros_1_1.setViewportView(tablaModelosBase);

		tablaModelosBase.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					int selectedRow;
					String id, modelo, tipo;

					selectedRow = tablaModelosBase.getSelectedRow();

					if (selectedRow >= 0) {
						id = getCellValue(tablaModelosBase, selectedRow, 0);
						modelo = getCellValue(tablaModelosBase, selectedRow, 1);
						tipo = getCellValue(tablaModelosBase, selectedRow, 2);

						lblIdModelos.setText(id);
						txtModeloBase.setText(modelo);
						cbTipoBase.setSelectedItem(tipo);

					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		JButton btnEliminarBaseModelo = new JButton("Eliminar");
		btnEliminarBaseModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modelos modelo = new Modelos();
				PersonalDaoImpl personalDao = new PersonalDaoImpl();

				modelo.setIdModelo(lblIdModelos.getText());
				modelo.setNombreModelo(txtModeloBase.getText());
				modelo.setTipoModelo(cbTipoBase.getSelectedItem().toString());

				if (personalDao.eliminarModelos(modelo)) {
					refrescarModelos();
					JOptionPane.showMessageDialog(null, "Se elimino el registro", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Ocurrio un error", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminarBaseModelo.setBounds(534, 89, 69, 23);
		panelFondoOtros_1.add(btnEliminarBaseModelo);

		JButton btnActualizarBaseModelo = new JButton("Actualizar");
		btnActualizarBaseModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modelos modelo = new Modelos();
				PersonalDaoImpl personalDao = new PersonalDaoImpl();

				modelo.setIdModelo(lblIdModelos.getText());
				modelo.setNombreModelo(txtModeloBase.getText());
				modelo.setTipoModelo(cbTipoBase.getSelectedItem().toString());

				if (personalDao.actualizarModelos(modelo)) {
					refrescarModelos();
					JOptionPane.showMessageDialog(null, "Se actualizo el registro", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Ocurrio un error", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnActualizarBaseModelo.setBounds(445, 89, 79, 23);
		panelFondoOtros_1.add(btnActualizarBaseModelo);

		JButton btnAgregarBaseModelo = new JButton("Agregar");
		btnAgregarBaseModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modelos modelo = new Modelos();
				PersonalDaoImpl personalDao = new PersonalDaoImpl();

				modelo.setIdModelo(new Date().getTime() + "");
				modelo.setNombreModelo(txtModeloBase.getText());
				modelo.setTipoModelo(cbTipoBase.getSelectedItem().toString());

				if (personalDao.crearModelos(modelo)) {
					refrescarModelos();
					JOptionPane.showMessageDialog(null, "Se creo el registro", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Ocurrio un error", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAgregarBaseModelo.setBounds(352, 89, 79, 23);
		panelFondoOtros_1.add(btnAgregarBaseModelo);

		JLabel lblArea_1_2_1 = new JLabel("Tipo :");
		lblArea_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArea_1_2_1.setForeground(new Color(38, 75, 102));
		lblArea_1_2_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblArea_1_2_1.setAlignmentX(0.5f);
		lblArea_1_2_1.setBounds(318, 52, 69, 26);
		panelFondoOtros_1.add(lblArea_1_2_1);

		JLabel lblArea_1_2_1_1 = new JLabel("Modelo :");
		lblArea_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArea_1_2_1_1.setForeground(new Color(38, 75, 102));
		lblArea_1_2_1_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblArea_1_2_1_1.setAlignmentX(0.5f);
		lblArea_1_2_1_1.setBounds(318, 15, 69, 26);
		panelFondoOtros_1.add(lblArea_1_2_1_1);

		txtModeloBase = new JTextField();
		txtModeloBase.setColumns(10);
		txtModeloBase.setBounds(397, 15, 225, 26);
		panelFondoOtros_1.add(txtModeloBase);

		JScrollPane scrollOtros_1_2 = new JScrollPane();
		scrollOtros_1_2.setBounds(667, 123, 278, 419);
		panelFondoOtros_1.add(scrollOtros_1_2);

		tablaLugarBase = new JTable();
		tablaLugarBase.setModel(modelL);
		scrollOtros_1_2.setViewportView(tablaLugarBase);

		tablaLugarBase.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					int selectedRow;
					String id, lugar;

					selectedRow = tablaLugarBase.getSelectedRow();

					if (selectedRow >= 0) {
						id = getCellValue(tablaLugarBase, selectedRow, 0);
						lugar = getCellValue(tablaLugarBase, selectedRow, 1);

						lblIdLugares.setText(id);
						txtLugarBase.setText(lugar);

					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		JButton btnAgregarBaseLugar = new JButton("Agregar");
		btnAgregarBaseLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lugares lugares = new Lugares();
				PersonalDaoImpl personalDao = new PersonalDaoImpl();

				lugares.setIdLugar(new Date().getTime() + "");
				lugares.setNombreLugar(txtLugarBase.getText());

				if (personalDao.crearLugares(lugares)) {
					refrescarLugares();
					JOptionPane.showMessageDialog(null, "Se creo el registro", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Ocurrio un error", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAgregarBaseLugar.setBounds(677, 89, 79, 23);
		panelFondoOtros_1.add(btnAgregarBaseLugar);

		JButton btnActualizarBaseLugar = new JButton("Actualizar");
		btnActualizarBaseLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lugares lugares = new Lugares();
				PersonalDaoImpl personalDao = new PersonalDaoImpl();

				lugares.setIdLugar(lblIdLugares.getText());
				lugares.setNombreLugar(txtLugarBase.getText());

				if (personalDao.actualizarLugares(lugares)) {
					refrescarLugares();
					JOptionPane.showMessageDialog(null, "Se actualizo el registro", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Ocurrio un error", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnActualizarBaseLugar.setBounds(770, 89, 79, 23);
		panelFondoOtros_1.add(btnActualizarBaseLugar);

		JButton btnEliminarBaseLugar = new JButton("Eliminar");
		btnEliminarBaseLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lugares lugares = new Lugares();
				PersonalDaoImpl personalDao = new PersonalDaoImpl();

				lugares.setIdLugar(lblIdLugares.getText());
				lugares.setNombreLugar(txtLugarBase.getText());

				if (personalDao.eliminarLugares(lugares)) {
					refrescarLugares();
					JOptionPane.showMessageDialog(null, "Se elimino el registro", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Ocurrio un error", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminarBaseLugar.setBounds(859, 89, 69, 23);
		panelFondoOtros_1.add(btnEliminarBaseLugar);

		txtLugarBase = new JTextField();
		txtLugarBase.setColumns(10);
		txtLugarBase.setBounds(746, 52, 165, 26);
		panelFondoOtros_1.add(txtLugarBase);

		JLabel lblArea_1_2_2 = new JLabel("Lugar :");
		lblArea_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArea_1_2_2.setForeground(new Color(38, 75, 102));
		lblArea_1_2_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblArea_1_2_2.setAlignmentX(0.5f);
		lblArea_1_2_2.setBounds(667, 52, 69, 26);
		panelFondoOtros_1.add(lblArea_1_2_2);

		cbTipoBase = new JComboBox<String>();
		cbTipoBase.addItem("COMPUTADORA");
		cbTipoBase.addItem("TELEFONO");
		cbTipoBase.setBounds(397, 52, 225, 26);
		panelFondoOtros_1.add(cbTipoBase);

		lblId = new JLabel("id");
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(10, 52, 0, 14);
		getContentPane().add(lblId);

		lblIdTelefono = new JLabel("id");
		lblIdTelefono.setForeground(Color.WHITE);
		lblIdTelefono.setBounds(66, 52, 0, 14);
		getContentPane().add(lblIdTelefono);

		JLabel lblIdOtros = new JLabel("id");
		lblIdOtros.setForeground(Color.WHITE);
		lblIdOtros.setBounds(122, 52, 0, 14);
		getContentPane().add(lblIdOtros);

		JLabel lblNewLabel = new JLabel("Usuario : " + usuarioNombreF);
		lblNewLabel.setBounds(10, 11, 196, 14);
		getContentPane().add(lblNewLabel);

		TableColumn columnC = tablaTelefonos.getColumnModel().getColumn(0);
		columnC.setMinWidth(0);
		columnC.setMaxWidth(0);
		columnC.setPreferredWidth(0);

		hilo = new Thread(this);
		hilo.start();
		setSize(1000, 695);
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		TableColumn columnE = tableGeneralIt.getColumnModel().getColumn(9);
		columnE.setMinWidth(0);
		columnE.setMaxWidth(0);
		columnE.setPreferredWidth(0);

		TableColumn columnt = tablaTelefonos.getColumnModel().getColumn(6);
		columnt.setMinWidth(0);
		columnt.setMaxWidth(0);
		columnt.setPreferredWidth(0);
		
		TableColumn columna = tablaAreasBase.getColumnModel().getColumn(0);
		columna.setMinWidth(0);
		columna.setMaxWidth(0);
		columna.setPreferredWidth(0);
		
		TableColumn columnl = tablaLugarBase.getColumnModel().getColumn(0);
		columnl.setMinWidth(0);
		columnl.setMaxWidth(0);
		columnl.setPreferredWidth(0);
		
		TableColumn columnm = tablaModelosBase.getColumnModel().getColumn(0);
		columnm.setMinWidth(0);
		columnm.setMaxWidth(0);
		columnm.setPreferredWidth(0);
		
		Configuraciones configuracionese = new Configuraciones();
		PersonalDaoImpl personalDaoe = new PersonalDaoImpl();
		
		configuracionese = personalDaoe.verificacionImpresora(usuarioNombreF);
		if (configuracionese!=null) {
			comboBox.setSelectedItem(configuracionese.getImpresora());
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
				
				calendar.setTime(fecha); 
				fecha = calendar.getTime();
				strFecha = formato.format(fecha);
				
				
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
	
	private void refrescar() {
	    // Suponiendo que tienes un método consultar en otra clase DAO
	    PersonalDaoImpl daoDatosBitacora = new PersonalDaoImpl();
	    model.setRowCount(0);

	    for (BitacoraDto a : daoDatosBitacora.consultar()) {
	        Object[] row = new Object[13]; // Ajustar tamaño si es necesario

	        row[0] = a.getIdCorbatin();
	        row[1] = a.getUsuarioNomina();
	        row[2] = a.getUsuarioNombre();
	        row[3] = a.getTelefono();
	        row[4] = a.getTipoDescripcion();
	        row[5] = a.getVehiculoPlacas();
	        row[6] = a.getVehiculoModelo();
	        row[7] = a.getVehiculoColor();
	        row[8] = a.getFechaEntrada();
	        row[9] = a.getHoraEntrada();
	        row[10] = a.getFechaSalida();
	        row[11] = a.getHoraSalida();

	        model.addRow(row);
	    }
	}

	
	private void refrescarBitacora() {
		// TODO Auto-generated method stub
		PersonalDaoImpl daoPersonal = new PersonalDaoImpl();
		modelB.setRowCount(0);
        
		for (BitacoraCambios a: daoPersonal.consultarBitacora()) {

	    	rowB[0] = a.getCuenta();
	    	rowB[1] = a.getTipoCambio();
	    	rowB[2] = a.getAntes();
	    	rowB[3] = a.getDespues();
	    	rowB[4] = a.getFechaCambio();

	    	modelB.addRow(rowB);
	    }
	}
	
	private void refrescarTelefono() {
		// TODO Auto-generated method stub
		PersonalDaoImpl daoPersonal = new PersonalDaoImpl();
		modelT.setRowCount(0);
        
		for (Telefono a: daoPersonal.consultarTelefono()) {

        	rowT[0] = a.getIdTelefono();
        	rowT[1] = a.getUsuario();
        	rowT[2] = a.getArea();
        	rowT[3] = a.getNumero();
        	rowT[4] = a.getModelo();
        	rowT[5] = a.getIme();
        	rowT[6] = a.getEstatus();
        	rowT[7] = a.getObservaciones();

        	modelT.addRow(rowT);
        }
	}
	
	private void refrescarOtros() {
		// TODO Auto-generated method stub
		PersonalDaoImpl daoPersonal = new PersonalDaoImpl();
		modelO.setRowCount(0);
        
		for (Otros a: daoPersonal.consultarOtros()) {

	    	rowO[0] = a.getIdOtros();
	    	rowO[1] = a.getUsuario();
	    	rowO[2] = a.getArea();
	    	rowO[3] = a.getNombreEquipo();
	    	rowO[4] = a.getDescripcion();
	    	rowO[5] = a.getCantidad();
	    	rowO[6] = a.getEstatus();

	    	modelO.addRow(rowO);
	    }
	}
	
	
	
	private void refrescarAreas() {
		// TODO Auto-generated method stub
		PersonalDaoImpl daoPersonal = new PersonalDaoImpl();
		modelA.setRowCount(0);
        
		 for (Areas a: daoPersonal.consultarAreasBase()) {

	        	rowA[0] = a.getIdArea();
	        	rowA[1] = a.getNombreArea();

	        	modelA.addRow(rowA);
	        }
	}
	
	private void refrescarModelos() {
		// TODO Auto-generated method stub
		PersonalDaoImpl daoPersonal = new PersonalDaoImpl();
		modelM.setRowCount(0);
        
		for (Modelos a: daoPersonal.consultarModelosBase()) {

        	rowM[0] = a.getIdModelo();
        	rowM[1] = a.getNombreModelo();
        	rowM[2] = a.getTipoModelo();

        	modelM.addRow(rowM);
        }
	}
	
	private void refrescarLugares() {
		// TODO Auto-generated method stub
		PersonalDaoImpl daoPersonal = new PersonalDaoImpl();
		modelL.setRowCount(0);
        
		for (Lugares a: daoPersonal.consultarLugarBase()) {

        	rowL[0] = a.getIdLugar();
        	rowL[1] = a.getNombreLugar();

        	modelL.addRow(rowL);
        }
	}
	
	
	
	private String getCellValue(JTable table, int row, int column) {
	    Object value = table.getValueAt(row, column);
	    return (value != null) ? value.toString() : "";
	}
	
	public void imprimir(String nombreEquipo, String nombreUsuario, String nombreSerial, String nombreDepartamento,int estatus,String usuarioNombreF) {
	    String zplCommand;
	    PrintService printService = null;
	    PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);

	    for (PrintService printer : printServices) {
	        if (printer.getName().equals(comboBox.getSelectedItem().toString())) {
	            printService = printer;
	            break;
	        }
	    }

	    if (printService == null) {
	        System.err.println("No se encontró la impresora especificada.");
	        return;
	    }
	    
	    if (estatus == 1) {
	    	zplCommand = "^^XA\r\n" + 
	        		"^MMT\r\n" + 
	        		"^PW324\r\n" + 
	        		"^LL0258\r\n" + 
	        		"^LS0\r\n" + 
	        		"^FO0,0^GFA,01152,01152,00012,:Z64:\r\n" + 
	        		"eJxjYBgFBAH/AQS7/gecyfj/H5zN/v9/A1z5//8HsLGR1Sj//y8AYxf8/2MBY9vU//gAY/PJP4Trbe4/zgJjPzzeJwNjVxRbVMDYcsaGD+B2zU6H2/XwhB9c/Y+MiBoY+59G4B8Y+79GMFZ2vUbwD2xse43gD9jY8hrBcDfwawTD3c+uEQx3D7NGMAMcaAQg2BwODGQB/ucfLCwK2+XPA62TcyuosCg8Ln8G6AwJNosKm4/HJXgSGBgs2CRybD66Q9kWZ2w+5sv3gNjpH86Yb8yX738AYj/4Z75ZWwIU3xZpif+MjS0leIBsmbTCNiB7Bogt/8ywzcCYcf4ZoF72Z9LNYHYBee4eBQwASttkmw==:9924\r\n" + 
	        		"^FT123,164^A0N,28,28^FH\\^FD"+nombreDepartamento+"^FS\r\n" + 
	        		"^FT97,59^A0N,28,28^FH\\^FDIT Queretaro^FS\r\n" + 
	        		"^FT123,126^A0N,28,28^FH\\^FD"+nombreUsuario+"^FS\r\n" + 
	        		"^FT8,247^A0N,28,28^FH\\^FD"+nombreEquipo+"^FS\r\n" + 
	        		"^FT124,203^A0N,28,28^FH\\^FD"+nombreSerial+"^FS\r\n" + 
	        		"^FO6,78^GB313,0,2^FS\r\n" + 
	        		"^FT9,224^BQN,2,5\r\n" + 
	        		"^FH\\^FDMA,"+nombreSerial+"^FS\r\n" + 
	        		"^PQ1,0,1,Y^XZ";
		}else {
			zplCommand = "^XA\r\n" + 
					"^MMT\r\n" + 
					"^PW324\r\n" + 
					"^LL0258\r\n" + 
					"^LS0\r\n" + 
					"^FO0,0^GFA,01152,01152,00012,:Z64:\r\n" + 
					"eJxjYBgFNAX8BxDs+h9wJuP/f3A2+///DXDl//8fwMZGVqP8/78AjF3w/48FjG1T/+MDjM0n/xCut7n/OAuM/fB4nwyMXVFsUQFjyxkbPoDbNTsdbtfDE35w9T8yImpg7H8agX9g7P8awVjZ9RrBP7Cx7TWCP2Bjy2sEw93ArxEMdz+7RjDcPcwawQxwoBGAYHM4MJAF+J9/sLAobJc/D7ROzq2gwqLwuPwZoDMk2CwqbD4el+BJYGCwYJPIsfnoDmVbnLH5mC/fA2KnfzhjvjFfvv8BiP3gn/lmbQlQfFukJf4zNraU4AGyZdIK24DsGSC2/DPDNgNjxvlngHrZn0k3g9kF5Ll7mAAAtVtkmw==:5C86\r\n" + 
					"^FT123,215^A0N,20,19^FH\\^FDRecibio:^FS\r\n" + 
					"^FT191,215^A0N,20,19^FH\\^FD"+usuarioNombreF+"^FS\r\n" + 
					"^FT124,139^A0N,25,24^FH\\^FD"+getCurrentDate()+"^FS\r\n" + 
					"^FT124,110^A0N,20,19^FH\\^FDFecha de entrega :^FS\r\n" + 
					"^FT105,60^A0N,28,28^FH\\^FDALMACEN^FS\r\n" + 
					"^FT123,165^A0N,20,19^FH\\^FD"+nombreUsuario+"^FS\r\n" + 
					"^FT8,252^A0N,28,28^FH\\^FD"+nombreEquipo+"^FS\r\n" + 
					"^FT123,190^A0N,20,19^FH\\^FD"+nombreSerial+"^FS\r\n" + 
					"^FO6,84^GB313,0,1^FS\r\n" + 
					"^FT10,219^BQN,2,5\r\n" + 
					"^FH\\^FDMA,"+nombreSerial+"^FS\r\n" + 
					"^LRY^FO99,23^GB126,0,51^FS^LRN\r\n" + 
					"^PQ1,0,1,Y^XZ";
		}

        
        
        byte[] by = zplCommand.getBytes();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(by, flavor, null);
        DocPrintJob job = printService.createPrintJob();

        try {
            job.print(doc, null);
        } catch (PrintException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
	
	public String getCurrentDate() {
	    // Obtiene la fecha actual
	    LocalDate currentDate = LocalDate.now();

	    // Crea un formateador con el formato deseado
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    // Formatea la fecha actual y la devuelve como un String
	    return currentDate.format(formatter);
	}
	
	public List<String> getPrinterNames() {
	    List<String> printerNames = new ArrayList<>();
	    
	    // Obtiene los servicios de impresión disponibles en la máquina
	    PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);

	    // Agrega el nombre de cada servicio de impresión a la lista
	    for (PrintService printService : printServices) {
	        printerNames.add(printService.getName());
	    }

	    return printerNames;
	}
	
	public void imprimirTelefono(String telefono, String nombreUsuario, String ime, String nombreDepartamento, int estatus,String usuarioNombreF) {
	    String zplCommand;
	    PrintService printService = null;
	    PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);

	    for (PrintService printer : printServices) {
	        if (printer.getName().equals(comboBox.getSelectedItem().toString())) {
	            printService = printer;
	            break;
	        }
	    }

	    if (printService == null) {
	        System.err.println("No se encontró la impresora especificada.");
	        return;
	    }
	    
	    System.out.println(estatus);
	    
	    if (estatus == 0) {
			zplCommand = "^XA\r\n" + 
					"^MMT\r\n" + 
					"^PW324\r\n" + 
					"^LL0258\r\n" + 
					"^LS0\r\n" + 
					"^FO0,64^GFA,03840,03840,00020,:Z64:\r\n" + 
					"eJzt1jtuwzAMBmAJHjTqBvU1uulozE16lPooydS1QIcmiGtWjwI1xd+NhiRIAXEx8MGSKEIQZUyPHjcJy8z7ykK0RdLArH502Y7CPHMcPgsbsy21qUWQhU3ji/ZcMur2v+wJGDUaa7N3MLRuc84B2Nj436PXoLUurTXwW2PtpNdw8hrKuThxN5V9eHFx/NoO2ARs/6eZViNgoeQsbNyyAcxnwbqGgI16H2lCZfGrzTWa1+vGheuc021+wQKwn/NCa/O5Lyxivw7YEO3AszD7Go9AZeYlGn1JS/2NTtrCWVrqjVSZS/N9rM9VLvuOK4tbPfCnNJsOwdv6nEY7Wp6cNJNGUW0lhNFmY0UNWDV5ZR48EMqj4V3YAMyCB0dJepJGKmX4gMkJzje2AHJB+ZEqfbuhGlzZbKP16HGX+AbJVL2q:6845\r\n" + 
					"^FO0,0^GFA,01152,01152,00012,:Z64:\r\n" + 
					"eJxjYBjhgP0Bgm3/B8H+/x/OZP7//wBc+f//D7CxkdUI/v/fAWNb1P+TgbHl7P9UwPXyf4DrdTz+uAnGLnh8nA/GtrGcYwNj80vO+AC36+xmuF0FT9Th6mtMdOxg7HoRjX9w9hRNrGz7KZp/sLHlp2j+wMbmn6IJdwP7FE24+5mnaMLdwzhFswHGZhDRgDMZWBQYyALsn3/IyFgc7n8OtI5f2cJGxuJx/7MCBgYeZhkbuYrHPWwGDAwyzDxmchWLoWyZNLmK7f3HQGzjH2nSN7b3H/8AYn+ol745tYf9AYht8F9y5pwetgQGBj5ji8NA9hkQm/+zxGEJyYbzz4B6mT/zHpwBYluQ5+5RQBQAAFZ6ZRs=:3F89\r\n" + 
					"^FT115,55^A0N,28,28^FH\\^FDAlmacen^FS\r\n" + 
					"^FT109,122^A0N,28,28^FH\\^FD"+nombreUsuario+"^FS\r\n" + 
					"^FT60,253^A0N,28,28^FH\\^FD"+ime+"^FS\r\n" + 
					"^FT182,208^A0N,23,24^FH\\^FD"+getCurrentDate()+"^FS\r\n" + 
					"^FT109,208^A0N,23,24^FH\\^FDFecha :^FS\r\n" + 
					"^FT197,179^A0N,23,24^FH\\^FD"+usuarioNombreF+"^FS\r\n" + 
					"^FT109,179^A0N,23,24^FH\\^FDRecibio :^FS\r\n" + 
					"^FT109,151^A0N,23,24^FH\\^FD"+telefono+"^FS\r\n" + 
					"^FO6,76^GB313,0,2^FS\r\n" + 
					"^LRY^FO107,20^GB117,0,48^FS^LRN\r\n" + 
					"^PQ1,0,1,Y^XZ";
		}else {
			zplCommand = "^XA\r\n" + 
	        		"^MMT\r\n" + 
	        		"^PW324\r\n" + 
	        		"^LL0258\r\n" + 
	        		"^LS0\r\n" + 
	        		"^FO0,64^GFA,03840,03840,00020,:Z64:\r\n" + 
	        		"eJzt1sttAyEQBmAQB26mBI4pA6Uip4KwFbiluAK7BZewx7XkLOHhRDvMvzYHK7Il5viJhWEWMQjRo8eN8CFMFZkQY6CWqBoos83EVAj7+DkxXWyojC2CzKzb/p5tSkbdXsv0jps9tJkD5v/B0LqtORtgunHcs9egtS6tNVCr337wNSS9hlwxgnkfil4cf3YCNgKbbptrNAvMXHNeml4zAearrvfyPywwzfeRJuQmPDcJxiFTfN24MMs53uZ3zAC7nhe7NHXMbeFraRKYiDb54Iht4xFwlb1Fs8ETS/3NztzMTDumyuOoyTTfhZyrVPaTqy1u1X9X9h63cSbnVIhP4UdZmRvzP6dWGiYxu95YB2BL+m3exBR4IJRHw4WYQOb5g6MkPVKzLGX8gNEsvcebAbmg/CwrfbuhGjzafKP16PHk8QPXKOSA:C67F\r\n" + 
	        		"^FO0,0^GFA,00768,00768,00012,:Z64:\r\n" + 
	        		"eJxjYBjGgP0Bgm3/B8H+/x/OZP7//wBc+f//D7CxkdUI/v/fAWNb1P+TgbHl7P9UwPXyf4DrdTz+uAnGLnh8nA/GtrGcYwNj80vO+AC36+xmuF0FT9Th6mtMdOxg7HoRjX9w9hRNrGz7KZp/sLHlp2j+wMbmn6IJdwP7FE24+5mnaMLdwzhFswHGZhDRgDMZWBQYyALsn3/IyFgc7n8OtI5f2cJGxuJx/7MCBgYeZhkbuYrHPWwGDAwyzDxmchWLoWyZNLmK7f3HQGzjH2nSN7b3H/8AYn+ol745tYf9AYht8F9y5pwetgQGBj5ji8NA9hkQm/+zxGEJyYbzz4B6mT/zHpwBYlswAADdjGUb:C1F4\r\n" + 
	        		"^FT119,161^A0N,28,28^FH\\^FD"+nombreDepartamento+"^FS\r\n" + 
	        		"^FT98,53^A0N,28,28^FH\\^FDIT Queretaro^FS\r\n" + 
	        		"^FT119,123^A0N,28,28^FH\\^FD"+nombreUsuario+"^FS\r\n" + 
	        		"^FT60,252^A0N,28,28^FH\\^FD"+ime+"^FS\r\n" + 
	        		"^FT120,201^A0N,28,28^FH\\^FD"+telefono+"^FS\r\n" + 
	        		"^FO6,73^GB313,0,2^FS\r\n" + 
	        		"^PQ1,0,1,Y^XZ";
		}

        
        
        byte[] by = zplCommand.getBytes();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(by, flavor, null);
        DocPrintJob job = printService.createPrintJob();

        try {
            job.print(doc, null);
        } catch (PrintException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
	
	private Color hex2Rgb(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
