package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.UIManager;

public class TopPanel extends JPanel {
	private JButton btnUser;
	private JButton btnCarrello;
	private JButton btnLogo;
	private JButton btnClose;
	private JPanel munuPanel;
	private JMenuBar menuPino;
	private JMenu mnUomo;
	private JMenu mnDonna;
	private JMenuItem itemTshirtsUomo;
	private JMenuItem itemPantaloniUomo;
	private JMenuItem itemGiaccheUomo;
	private JMenuItem itemScarpeUomo;
	private JMenuItem itemAccessoriUomo;
	private JMenuItem iteamTshirtsDonna;

	private Controller controller;
	
	public TopPanel(int x, Controller ctrl,JFrame container) {
		controller = ctrl;
		setBorder(null);
		setToolTipText("");
		
		setSize(902, 133);
		setLayout(null);
		

		
		btnLogo = new JButton("");
		btnLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.GoToMainFrame(container);
			}
		});
		btnLogo.setOpaque(false);
		btnLogo.setContentAreaFilled(false);
		btnLogo.setBorderPainted(false);
		btnLogo.setBackground(new Color(240, 240, 240));
		btnLogo.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/logo.png")));
		btnLogo.setBounds(322, 11, 309, 62);
		add(btnLogo);
		
		btnUser = new JButton("");
		btnUser.setBorderPainted(false);
		btnUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUser.setSize(45,53);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnUser.setSize(30,38);
			}
		
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.GoToProfileFrame(container);
			}
		});
		btnUser.setOpaque(false);
		btnUser.setContentAreaFilled(false);
		btnUser.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/userIcon.png")));
		btnUser.setBounds(779, 84, 30, 38);
		add(btnUser);
		
		btnCarrello = new JButton("");
		btnCarrello.setOpaque(false);
		btnCarrello.setContentAreaFilled(false);
		btnCarrello.setBorderPainted(false);
		btnCarrello.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCarrello.setSize(45,53);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCarrello.setSize(30,38);
			}
		});
		btnCarrello.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/icons8_shopping_cart_30px.png")));
		btnCarrello.setBounds(859, 84, 37, 38);
		add(btnCarrello);
		
		btnClose = new JButton("");

		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnClose.setOpaque(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setBorderPainted(false);
		btnClose.setIcon(new ImageIcon(TopPanel.class.getResource("/IconMainFrame/closeIcon.png")));
		btnClose.setBounds(859, 11, 37, 23);
		add(btnClose);
		
		munuPanel = new JPanel();
		munuPanel.setForeground(UIManager.getColor("Button.background"));
		munuPanel.setBackground(UIManager.getColor("Button.background"));
		munuPanel.setBounds(10, 94, 210, 39);
		add(munuPanel);
		munuPanel.setLayout(null);
		munuPanel.setOpaque(false);
		menuPino = new JMenuBar();
		menuPino.setForeground(UIManager.getColor("Button.background"));
		menuPino.setBackground(UIManager.getColor("Button.background"));
		menuPino.setBounds(0, 0, 172, 39);
		munuPanel.add(menuPino);
		
		mnUomo = new JMenu("UOMO");
		mnUomo.setOpaque(true);
		mnUomo.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/pinoIcon.png")));
		mnUomo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		mnUomo.setBackground(UIManager.getColor("Button.background"));
		menuPino.add(mnUomo);
		
		itemTshirtsUomo = new JMenuItem("T-SHIRTS E FELPE");
		mnUomo.add(itemTshirtsUomo);
		
		itemPantaloniUomo = new JMenuItem("PANTALONI");
		mnUomo.add(itemPantaloniUomo);
		
		itemGiaccheUomo = new JMenuItem("GIACCHE");
		mnUomo.add(itemGiaccheUomo);
		
		itemScarpeUomo = new JMenuItem("SCARPE");
		mnUomo.add(itemScarpeUomo);
		
		itemAccessoriUomo = new JMenuItem("ACCESSORI");
		mnUomo.add(itemAccessoriUomo);
		
		mnDonna = new JMenu("DONNA");
		
		mnDonna.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuPino.add(mnDonna);
		mnDonna.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/icons8-donna-in-piedi-30.png")));
		mnDonna.setOpaque(true);
		mnDonna.setBackground(UIManager.getColor("Button.background"));
		
		iteamTshirtsDonna = new JMenuItem("T-SHIRTS E FELPE");
		mnDonna.add(iteamTshirtsDonna);
		
		JMenuItem itemPantaloniDonna = new JMenuItem("JEANS E GONNE");
		mnDonna.add(itemPantaloniDonna);
		
		JMenuItem itemGiaccheDonna = new JMenuItem("GIACCHE");
		mnDonna.add(itemGiaccheDonna);
		
		JMenuItem itemScarpeDonna = new JMenuItem("SCARPE");
		mnDonna.add(itemScarpeDonna);
		
		JMenuItem itemAccessoriDonna = new JMenuItem("ACCESSORI");
		mnDonna.add(itemAccessoriDonna);
		
		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnAdd.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/IconAdd.png")));
		btnAdd.setOpaque(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorderPainted(false);
		btnAdd.setBounds(819, 84, 30, 38);
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setSize(45,53);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setSize(30,38);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.GoToAddArticolo();
			}
		});
		add(btnAdd);
		
	}
}

