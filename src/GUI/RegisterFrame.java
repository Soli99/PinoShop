package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import datechooser.beans.DateChooserCombo;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textEmail;
	private JTextField textNome;
	private JPasswordField passwordField;	
	private JPasswordField passwordField_r;
	private int mouseX;
	private int mouseY;
	
	private Controller controller;
	private JTextField textCognome;
	private JTextField textUsername;

	private DateChooserCombo dateChooserCombo;

	private File fotoFile;
	
	public RegisterFrame(Controller ctrl) {
		//fotoFile = new File(RegisterFrame.class.getResource("/IconRegister/SfondRegister.png"));
		
		controller = ctrl;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 622);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 482, 622);
		contentPane.add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(69, 269, 143, 29);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Georgia", Font.BOLD, 25));
		panel.add(lblPassword);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setBounds(177, 11, 143, 39);
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Georgia", Font.BOLD, 33));
		panel.add(lblRegister);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(69, 94, 143, 29);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Georgia", Font.BOLD, 25));
		panel.add(lblNome);
		
		JLabel lblRepeatPassword = new JLabel("<html>\r\n <center>Conferma\r\n<br/>password \r\n</center>\r\n </html>\r\n\r\n");
		lblRepeatPassword.setBounds(298, 248, 143, 59);
		lblRepeatPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepeatPassword.setForeground(Color.BLACK);
		lblRepeatPassword.setFont(new Font("Georgia", Font.BOLD, 25));
		panel.add(lblRepeatPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(298, 177, 143, 29);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Georgia", Font.BOLD, 25));
		panel.add(lblEmail);
		
		JLabel lblDataDiNascita = new JLabel("Data di nascita\r\n");
		lblDataDiNascita.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDiNascita.setForeground(Color.BLACK);
		lblDataDiNascita.setFont(new Font("Georgia", Font.BOLD, 25));
		lblDataDiNascita.setBounds(145, 358, 206, 29);
		panel.add(lblDataDiNascita);
		
		JLabel lblGoToLogin = new JLabel("Hai gi\u00E0 un account? Clicca Qui!\r\n");
		lblGoToLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.GoToLoginFrame();
			}
		});
		lblGoToLogin.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblGoToLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		lblGoToLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoToLogin.setForeground(Color.WHITE);
		lblGoToLogin.setFont(new Font("Microsoft Tai Le", Font.BOLD, 15));
		lblGoToLogin.setBounds(8, 608, 464, 14);
		panel.add(lblGoToLogin);
		
		JLabel Sfondo = new JLabel("");
		Sfondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX= e.getX();
				mouseY = e.getY();
			}
		});
		Sfondo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX,y-mouseY);
			}
		});
		Sfondo.setIcon(new ImageIcon(RegisterFrame.class.getResource("/IconRegister/SfondRegister.png")));
		Sfondo.setBounds(0, 0, 482, 622);
		contentPane.add(Sfondo);
		

		textNome = new JTextField();
		textNome.setBounds(69, 134, 143, 20);
		textNome.setColumns(10);
		textNome.setBackground(new Color(191, 191, 191));
		panel.add(textNome);
		
		textEmail = new JTextField();
		textEmail.setBounds(298, 217, 143, 20);
		textEmail.setColumns(10);
		textEmail.setBackground(new Color(191, 191, 191));
		panel.add(textEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(69, 312, 143, 20);
		passwordField.setBackground(new Color(191, 191, 191));
		panel.add(passwordField);
		
		passwordField_r = new JPasswordField();
		passwordField_r.setBounds(298, 312, 143, 20);
		passwordField_r.setBackground(new Color(191, 191, 191));
		panel.add(passwordField_r);
		
		JButton btnlogin = new JButton("");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnlogin.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnlogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnlogin.setBounds(223, 539, 54, 48);
		btnlogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				try {
					controller.CreateAccount(textNome.getText(),textCognome.getText(),textUsername.getText()
								,passwordField.getPassword(),dateChooserCombo.getSelectedDate(), fotoFile,textEmail.getText());
					VerifyFields();
				} catch (FileNotFoundException e1) {
				
					e1.printStackTrace();
				}
				
			}
		});
		btnlogin.setIcon(new ImageIcon(RegisterFrame.class.getResource("/IconRegister/AddUserIcon.png")));
		btnlogin.setOpaque(false);
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnlogin.setContentAreaFilled(false);
		btnlogin.setBorderPainted(false);
		btnlogin.setBackground(SystemColor.menu);
		panel.add(btnlogin);
		
		JButton btnclose = new JButton("");
		btnclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
					@Override
			public void mouseEntered(MouseEvent e) {
				btnclose.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnclose.setBounds(453, 11, 19, 20);

		btnclose.setIcon(new ImageIcon(RegisterFrame.class.getResource("/IconLogin/LoginClose.png")));
		btnclose.setOpaque(false);
		btnclose.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnclose.setContentAreaFilled(false);
		btnclose.setBorderPainted(false);
		btnclose.setBackground(SystemColor.menu);
		panel.add(btnclose);
		
		textCognome = new JTextField();
		textCognome.setColumns(10);
		textCognome.setBackground(new Color(191, 191, 191));
		textCognome.setBounds(300, 134, 143, 20);
		panel.add(textCognome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setForeground(Color.BLACK);
		lblCognome.setFont(new Font("Georgia", Font.BOLD, 25));
		lblCognome.setBounds(300, 94, 143, 29);
		panel.add(lblCognome);
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		textUsername.setBackground(new Color(191, 191, 191));
		textUsername.setBounds(67, 217, 143, 20);
		panel.add(textUsername);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Georgia", Font.BOLD, 25));
		lblUsername.setBounds(67, 177, 143, 29);
		panel.add(lblUsername);
		
		dateChooserCombo = new DateChooserCombo();
		dateChooserCombo.setBounds(183, 398, 155, 20);
		dateChooserCombo.setSelectedDate(null);
		panel.add(dateChooserCombo);
		
		JLabel lblFoto = new JLabel("Foto");
		lblFoto.setHorizontalAlignment(SwingConstants.LEFT);
		lblFoto.setForeground(Color.BLACK);
		lblFoto.setFont(new Font("Georgia", Font.BOLD, 25));
		lblFoto.setBounds(194, 466, 66, 29);
		panel.add(lblFoto);
		
		JButton btnAddPhoto = new JButton("");
		btnAddPhoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CaricaFoto();
			}
		});
		btnAddPhoto.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnAddPhoto.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnAddPhoto.setIcon(new ImageIcon(RegisterFrame.class.getResource("/IconRegister/addFoto.png")));
		btnAddPhoto.setOpaque(false);
		btnAddPhoto.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAddPhoto.setContentAreaFilled(false);
		btnAddPhoto.setBorderPainted(false);
		btnAddPhoto.setBackground(SystemColor.menu);
		btnAddPhoto.setBounds(270, 451, 66, 59);
		panel.add(btnAddPhoto);
	}
	
	
	private boolean VerifyFields() {
		String nome = textNome.getText();
		String cognome = textCognome.getText();
		String username = textUsername.getText();
		String email = textEmail.getText();
		String password = String.valueOf(passwordField.getPassword());
		String confirmpass = String.valueOf(passwordField_r.getPassword());
		String dataNascita = " ";
		
		if(username.trim().equals("") || email.trim().equals("") || password.trim().equals("") || confirmpass.trim().equals("") 
				|| nome.trim().equals("") || cognome.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Uno o pi� campi sono vuoti", "Campi vuoti",2);
			return false;
		}
		else if(!password.equals(confirmpass)) {
			JOptionPane.showMessageDialog(null, "Password non corrisponde", "Conferma Password", 2);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Account creato");
			if(!dateChooserCombo.getText().equals("")) 
				dataNascita = dateChooserCombo.getText();
			return true;
		}
	}
	
	private void CaricaFoto() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter fileExtensionFilter = new FileNameExtensionFilter("jpg","png");
		fileChooser.setFileFilter(fileExtensionFilter);
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) 
					fotoFile = fileChooser.getSelectedFile();
			
		
	}
}
