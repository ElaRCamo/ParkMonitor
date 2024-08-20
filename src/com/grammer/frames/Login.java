package com.grammer.frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.grammer.dao.InicioAuxiliarDaoImpl;
import com.grammer.dao.PersonalDaoImpl;
import com.grammer.entity.Usuarios;
import com.grammer.general.Imagen;
import com.grammer.general.JPing;

public class Login extends JFrame implements Runnable {
	
	//Declaracion de variables:
	private static final long serialVersionUID = 1L;
	ImageIcon normalIconE = new ImageIcon(Login.class.getResource("/com/grammer/imgs/normalE.png"));
	ImageIcon hoverIconE = new ImageIcon(Login.class.getResource("/com/grammer/imgs/onE.png"));
	ImageIcon pressedIconE = new ImageIcon(Login.class.getResource("/com/grammer/imgs/pressE.png"));

	Imagen imgEstatus;
	Date fecha = new Date();
	JLabel lblHora = new JLabel("00:00");
	JLabel lblNotificacion = new JLabel();
	JLabel lblValidar = new JLabel("");
	JLabel lblLeyendo = new JLabel();

	JPanel panelEstatus = new JPanel();
	Color color1 = new Color(38,76,114);
	Color color2 = new Color(154,179,204);
	Color color3 = new Color(77,153,191);

	JLabel logoGrammer, logoInicio, lblcontrasea;

	String hora, minutos, segundos;
	Thread hilo;

	Imagen lblImagen_1, lblImagen_2, lblImagen_3, lblImagen_4, lblImagen_6, lblImagen_7;
	JButton btnGuardar;

	String horaAux = "", tag = "", strFecha = "";
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm");
	Calendar calendar = Calendar.getInstance();

	JPing ping = new JPing(); //Verifica conexión a internet
	private final JPanel panelStatusImg = new JPanel();
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private final JLabel lblFecha = new JLabel("");
	private JLabel lblvhitman;
	private JLabel lblEstatusInfo;
	
	//Creación del Marco de la Interfaz Gráfica
	public static void main(String[] args) {
		//EventQueue.invokeLater: Se asegura de que la interfaz gráfica se cree y actualice en el hilo de eventos de Swing. 
		//Es una práctica estándar para evitar problemas de concurrencia.
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                UIManager.setLookAndFeel(new FlatIntelliJLaf()); //setLookAndFeel: Cambia el aspecto de la interfaz de usuario.
	                Login frame = new Login(); //Crea una nueva instancia de la clase 
	                frame.setResizable(false); //Impide que el usuario cambie el tamaño de la ventana.
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
	
	public Login() throws InterruptedException, MalformedURLException {
	    loading();
	    InicioAuxiliarDaoImpl inicio = new InicioAuxiliarDaoImpl(); //Qué devuelve InicioAuxiliarDaoImpl********************?????
	    inicio.getInicioAuxiliar();
	    setVisible(true);
	    setBounds(300, 300, 445, 590);
	    contentPane = new JPanel();
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    contentPane.setBackground(color1);
	    setTitle("Grammer Parking");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/grammer/imgs/Grammer_Logo.png")));
	    
	    lblLeyendo.setForeground(Color.WHITE);
	    lblLeyendo.setBounds(134, 228, 152, 54);
	    lblLeyendo.setHorizontalAlignment(SwingConstants.CENTER);
	    lblLeyendo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 19));
	    lblLeyendo.setText("<html><center>Usuario</center></html>");
	    contentPane.add(lblLeyendo);
	    
	    //Configuración del Panel de Estado
	    panelEstatus.setBounds(46, 511, 339, 40);
	    panelEstatus.setBackground(Color.WHITE);
	    panelStatusImg.setBackground(Color.WHITE);
	    lblLeyendo.setBackground(Color.GRAY);

	    imgEstatus = new Imagen("ampelmann-green2.png", 3, 750, 750);
	    
	    /*
	     * panelEstatus: Un panel al final de la ventana para mostrar el estado de la conexión.
		   GroupLayout: Un tipo de diseño que organiza componentes en grupos y alineaciones. Aquí se utiliza para posicionar imgEstatus dentro de panelStatusImg.
		   setHorizontalGroup y setVerticalGroup: Configuran cómo se deben agrupar y alinear los componentes dentro de panelStatusImg.
	     */

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
		lblNotificacion.setBackground(Color.WHITE);

		lblNotificacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotificacion.setForeground(Color.BLACK);
		lblNotificacion.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNotificacion.setAlignmentX(0.5f);
		GroupLayout gl_panelEstatus = new GroupLayout(panelEstatus);
		gl_panelEstatus.setHorizontalGroup(
			gl_panelEstatus.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelEstatus.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNotificacion, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(panelStatusImg, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelEstatus.setVerticalGroup(
			gl_panelEstatus.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelEstatus.createSequentialGroup()
					.addGroup(gl_panelEstatus.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNotificacion, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addComponent(panelStatusImg, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelEstatus.setLayout(gl_panelEstatus);
	    
	    //Botón Guardar
	    btnGuardar = new JButton(normalIconE);
	    btnGuardar.setRolloverIcon(hoverIconE);
	    btnGuardar.setPressedIcon(pressedIconE);
	    btnGuardar.setBorderPainted(false); // No mostrar el borde
	    btnGuardar.setContentAreaFilled(false); // No pintar el área de contenido
	    btnGuardar.setBounds(147, 401, 135, 30);//Establece la posición y tamaño del botón en el panel.
	    contentPane.add(btnGuardar);
	    
	    //Configuración de Etiquetas y Campos de Texto
	    lblValidar.setForeground(Color.RED);
	    lblValidar.setBounds(100, 228, 221, 30);
	    contentPane.add(lblValidar);

	    lblImagen_3 = new Imagen("estatus.png", 3, 750, 750);
	    lblImagen_3.setBounds(19, 490, 366, 61);
	    contentPane.add(lblImagen_3);

	    txtUsuario = new JTextField();
	    txtUsuario.setToolTipText("Ingresa tu numero de nomina ejemplo 1606 o 00001606");
	    txtUsuario.setBounds(75, 279, 278, 30);
	    contentPane.add(txtUsuario);
	    txtUsuario.setColumns(10);

	    lblcontrasea = new JLabel();
	    lblcontrasea.setText("<html><center>Contrase\u00F1a</center></html>");
	    lblcontrasea.setHorizontalAlignment(SwingConstants.CENTER);
	    lblcontrasea.setForeground(Color.WHITE);
	    lblcontrasea.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 19));
	    lblcontrasea.setBackground(Color.GRAY);
	    lblcontrasea.setBounds(134, 320, 152, 40);
	    contentPane.add(lblcontrasea);

	    txtPassword = new JPasswordField();
	    txtPassword.setBounds(75, 360, 278, 30);
	    contentPane.add(txtPassword);

	    lblFecha.setForeground(Color.WHITE);
	    lblFecha.setBounds(328, 11, 91, 27);
	    contentPane.add(lblFecha);
	    
	    //Otros Componentes
	    logoGrammer = new JLabel("");
	    logoGrammer.setIcon(new ImageIcon(Login.class.getResource("/com/grammer/imgs/logoGrammerBlanco.png")));
	    logoGrammer.setBounds(19, 11, 55, 61);
	    contentPane.add(logoGrammer);

	    logoInicio = new JLabel("");
	    logoInicio.setIcon(new ImageIcon(Login.class.getResource("/com/grammer/imgs/logoInicio.png")));
	    logoInicio.setBounds(75, 49, 278, 187);
	    contentPane.add(logoInicio);

	    lblvhitman = new JLabel("1.0vVoldemor");
	    lblvhitman.setHorizontalAlignment(SwingConstants.CENTER);
	    lblvhitman.setForeground(Color.WHITE);
	    lblvhitman.setBounds(46, 477, 330, 14);
	    contentPane.add(lblvhitman);

	    JProgressBar progressBar = new JProgressBar();
	    progressBar.setBounds(75, 456, 278, 14);
	    contentPane.add(progressBar);

	    lblEstatusInfo = new JLabel("");
	    lblEstatusInfo.setHorizontalAlignment(SwingConstants.CENTER);
	    lblEstatusInfo.setForeground(Color.WHITE);
	    lblEstatusInfo.setBounds(75, 440, 278, 14);
	    contentPane.add(lblEstatusInfo);
	    
	    //Eventos y Lógica de la Aplicación
	    
	    //Acciones de los Campos de Texto
	    
	    //Cuando el usuario presiona Enter en txtUsuario, el foco se mueve al campo de contraseña (txtPassword).
	    txtUsuario.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            txtPassword.requestFocusInWindow();
	        }
	    });
	    
	    //Cuando el usuario presiona Enter en txtPassword, el botón btnGuardar es "clickeado" programáticamente.
	    txtPassword.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            btnGuardar.doClick();
	        }
	    });
	    
	    hilo = new Thread(this);
		hilo.start();
	    
	    btnGuardar.addActionListener(new ActionListener() {
	        @SuppressWarnings("deprecation")
	        public void actionPerformed(ActionEvent e) {

	            progressBar.setIndeterminate(true);
	            
	            //SwingWorker: Se utiliza para realizar tareas en segundo plano sin bloquear la interfaz de usuario. En este caso, valida al usuario y muestra la interfaz adecuada.
	            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
	            	
	            	//doInBackground(): Método que se ejecuta en segundo plano. Aquí se verifica la validez del usuario y se maneja la sesión.
	                @Override
	                protected Void doInBackground() throws Exception {
	                    try {
	                        Usuarios usuarios = new Usuarios();
	                        PersonalDaoImpl daousuarios = new PersonalDaoImpl();
	                        usuarios = daousuarios.verificacionUsuario(txtUsuario.getText(), txtPassword.getText());
	                        lblEstatusInfo.setText("Validando usuario");

	                        if (usuarios != null) {
	                            lblEstatusInfo.setText("Validando contraseña");
	                            lblEstatusInfo.setText("Creando sesión");
	                            AltaDatosiT frame1 = new AltaDatosiT(usuarios.getNombre());
	                            frame1.setLocationRelativeTo(null);
	                            frame1.setVisible(true);
	                        } else {
	                            JOptionPane.showMessageDialog(null, "La cuenta no existe", "Message", JOptionPane.ERROR_MESSAGE);
	                        }
	                        lblEstatusInfo.setText("");
	                        btnGuardar.setVisible(false);

	                    } catch (Exception e1) {
	                        e1.printStackTrace();
	                    }
	                    btnGuardar.setVisible(true);
	                    return null;
	                }
	                //done(): Método que se llama cuando la tarea en segundo plano se completa. Se oculta la barra de progreso aquí.
	                @Override
	                protected void done() {
	                    progressBar.setIndeterminate(false);
	                }
	            };

	            worker.execute();
	        }
	    });
	}
	
	 //Método hora(): Actualiza las variables hora, minutos, y segundos con la hora actual, formateada con ceros a la izquierda si es necesario.
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
	
	//El método `loading` muestra una animación GIF en una ventana sin bordes y transparente durante 5 segundos antes de cerrarla.
	public void loading() throws MalformedURLException, InterruptedException {
	    Icon icon = new ImageIcon(Login.class.getResource("/com/grammer/imgs/carga-min.gif"));
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

	// Método run(): Método que se ejecuta en un hilo separado. 
	// Actualiza la hora, la fecha y verifica la conexión de red cada segundo. Llama a conexionValida() o errorConexion() basado en la validez de la conexión.
	public void run() {
	    Thread current = Thread.currentThread();
	    try {
	        while (current == hilo) {
	            hora();
	            horaAux = hora + ":" + minutos;
	            lblHora.setText(horaAux);

	            calendar.setTime(fecha);
	            fecha = calendar.getTime();
	            strFecha = formato.format(fecha);
	            lblFecha.setText(strFecha);

	            if (ping.validaPing("10.83.21.12")) {
	                conexionValida();
	            } else {
	                System.err.println("Error 123456789");
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
	// Método conexionValida(): actualizar la interfaz gráfica cuando la conexión de red es válida. Cambia el texto en lblNotificacion a 
	// "En linea ...", cambia el color del borde del panel y actualiza el estado de la imagen que indica el estado de la conexión.
	public void conexionValida() throws InterruptedException {
	    lblNotificacion.setText("En linea ...");
	    lblNotificacion.setForeground(Color.green);
	    getRootPane().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, hex2Rgb("#6e8cb8")));
	    Thread.sleep(1000);
	    panelStatusImg.remove(0);
	    imgEstatus = new Imagen("ampelmann-green2.png", 1, 750, 750);
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

	
	//Método errorConexion(): Actualiza la interfaz para mostrar que no hay conexión de red. Cambia la imagen de estado y el borde del panel principal a rojo.
	public void errorConexion() throws InterruptedException {
	    lblNotificacion.setText("No hay conexión a Red, favor de revisar el cable de Red...");
	    lblNotificacion.setForeground(Color.RED);
	    getRootPane().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.RED));
	    Thread.sleep(1000);
	    panelStatusImg.remove(0);
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
	
	//Método hex2Rgb(): Método sin implementar
	private Color hex2Rgbtest(String string) {
	    // TODO Auto-generated method stub
	    return null;
	}
	
	// Método hex2Rgb(): Este método es un lugar reservado para convertir un color en formato hexadecimal (como #RRGGBB) a un objeto Color en Java.
	private Color hex2Rgb(String hex) {
	    return new Color(
	        Integer.valueOf(hex.substring(1, 3), 16),
	        Integer.valueOf(hex.substring(3, 5), 16),
	        Integer.valueOf(hex.substring(5, 7), 16)
	    );
	}

}
