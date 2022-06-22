/**
 * 
 */
package fontes_e_fontanarios;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
/**
 * @author Grupo4
 *
 */
public class Interface {
	private JFrame frame = new JFrame("Hello Nature");
	static Gerir gerir = new Gerir(new ArrayList<>(), new ArrayList<>());
	private static String currentUser = "";
	
	public void menu(){
		
		frame.getContentPane().removeAll();
		frame.setSize(430,450);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JLabel contacto = new JLabel("Contactos:");
		contacto.setBounds(220,382,80,30);
		frame.add(contacto);
		ImageIcon iconInsta = new ImageIcon("insta.png");
		JButton insta = new JButton(iconInsta);
		insta.setBounds(290,385,24,24);
		insta.setBackground(new Color(227,241,172));
		insta.setBorder(BorderFactory.createEmptyBorder());
		insta.setFocusable(false);
		insta.addActionListener(e -> {try{Desktop.getDesktop().browse(new URL("https://www.instagram.com/hellonaturePT/").toURI());} catch(Exception t) {}});
		frame.add(insta);
		ImageIcon iconFace = new ImageIcon("face.png");
		JButton face = new JButton(iconFace);
		face.setBounds(320,385,24,24);
		face.setFocusable(false);
		face.setBackground(new Color(227,241,172));
		face.setBorder(BorderFactory.createEmptyBorder());
		face.addActionListener(e -> {try{Desktop.getDesktop().browse(new URL("https://www.facebook.com/Hello-Nature-101619722598759").toURI());} catch(Exception t) {}});
		frame.add(face);
		ImageIcon iconTwit = new ImageIcon("twit.png");
		JButton twit = new JButton(iconTwit);
		twit.setBounds(350,385,24,24);
		twit.setFocusable(false);
		twit.setBackground(new Color(227,241,172));
		twit.setBorder(BorderFactory.createEmptyBorder());	
		twit.addActionListener(e -> {try{Desktop.getDesktop().browse(new URL("https://twitter.com/HelloNaturePT").toURI());} catch(Exception t) {}});
		frame.add(twit);
		
		ImageIcon iconEmail = new ImageIcon("mail.png");
		JButton email = new JButton(iconEmail);
		email.setBounds(380,385,24,24);
		email.setFocusable(false);
		email.setBackground(new Color(227,241,172));
		email.setBorder(BorderFactory.createEmptyBorder());	
		email.addActionListener(e -> {try{Desktop.getDesktop().browse(new URL("mailto:hellonaturehelp@gmail.com?subject=Hello%20again").toURI());} catch(Exception t) {}});
		frame.add(email);
		
		
		JLabel hello = new JLabel("Hello");
		hello.setBounds(185,30,60,40);
		hello.setForeground(new Color(30,75,63));
		hello.setFont(new Font("Abadi",Font.PLAIN, 25));
		JLabel nature = new JLabel("Nature");
		nature.setBounds(150,70,130,30);
		nature.setForeground(new Color(30,75,63));
		nature.setFont(new Font("Mv Boli",Font.BOLD, 35));
		frame.add(hello);
		frame.add(nature);
		
		ImageIcon logo = new ImageIcon("Logo.png");
		frame.setIconImage(logo.getImage());
		frame.getContentPane().setBackground(new Color(227,241,172));
		
		JButton criar = new JButton("Criar conta");
		criar.setBounds(110,200,200,30);
		criar.setFocusable(false);
		criar.addActionListener(e -> criarConta());
		frame.add(criar);
		
		JButton login = new JButton("Login");
		login.setBounds(110,240,200,30);
		login.setFocusable(false);
		login.addActionListener(e -> login());
		frame.add(login);
		
		JButton sair = new JButton("Sair da Aplicação");
		sair.setBounds(110,280,200,30);
		sair.setFocusable(false);
		sair.addActionListener(e -> System.exit(0));
		frame.add(sair);
		
	}
	public void login() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(450,300);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JLabel nomeLabel = new JLabel("Username");
		nomeLabel.setBounds(60,30,60,30);
		frame.add(nomeLabel);
		
		JTextField nome = new JTextField("");
		nome.setBounds(150,35,200,25);
		nome.setBorder(BorderFactory.createEmptyBorder());
		frame.add(nome);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setBounds(60,70,60,30);
		frame.add(passLabel);
		
		JPasswordField password = new JPasswordField("");
		password.setBounds(150,75,200,25);
		password.setBorder(BorderFactory.createEmptyBorder());
		password.setEchoChar('*');
		frame.add(password);
		
		JButton continuar = new JButton("Continuar");
		continuar.setBounds(245,180,110,20);
		continuar.setFocusable(false);
		
		JLabel nomeErro = new JLabel();
		nomeErro.setBounds(150,15,200,25);
		frame.add(nomeErro);
		
		JLabel passErro = new JLabel();
		passErro.setBounds(150,55,200,25);
		frame.add(passErro);
		
		
		JLabel naoExiste = new JLabel();
		naoExiste.setBounds(148,135,170,30);
		frame.add(naoExiste);
		
		continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nome.getText().length() == 0 || password.getPassword().length == 0) {
					if(nome.getText().length() == 0) {
						nome.setBorder(BorderFactory.createEtchedBorder());
						nome.setBackground(new Color(255,204,204));
						nomeErro.setText("Insira o Username");
						nomeErro.setForeground(new Color(255,0,0));
						naoExiste.setText("");
					}
					else {
						nomeErro.setText("");
						nome.setBackground(Color.white);
						
					}
					if(password.getPassword().length == 0) {
						password.setBorder(BorderFactory.createEtchedBorder());
						password.setBackground(new Color(255,204,204));
						passErro.setText("Insira a Password");
						passErro.setForeground(new Color(255,0,0));
						naoExiste.setText("");
					}
					else {
						passErro.setText("");
						password.setBackground(Color.white);
					}
				}
				else {
					String passwordLogin = "";
					for (int i = 0; i < password.getPassword().length; i++) {
						passwordLogin += password.getPassword()[i];
					}
					String usernameLogin = nome.getText();
					currentUser = usernameLogin;
					
					if(gerir.procurarUtilizador(usernameLogin, passwordLogin).equals("Turista")) {
						menuTurista();
					}
					else if (gerir.procurarUtilizador(usernameLogin, passwordLogin).equals("Administrador")) {
						menuAdmin();
					}
					else {
						naoExiste.setForeground(new Color(255,0,0));
						naoExiste.setText("*Utilizador não encontrado*");
						nomeErro.setText("");
						passErro.setText("");
						nome.setBackground(Color.white);
						password.setBackground(Color.white);
						nome.setText("");
						password.setText("");
					}
				}
			}
		});
		frame.add(continuar);
		
		JButton voltar = new JButton("Voltar atrás");
		voltar.setBounds(130,180,110,20);
		voltar.setFocusable(false);
		frame.add(voltar);
		voltar.addActionListener(e -> menu());
		
		JCheckBox showPass = new JCheckBox("Show Password");
		showPass.setBounds(145,110,120,20);
		showPass.setFocusable(false);
		showPass.setBackground(new Color(227,241,172));
		showPass.addActionListener(e -> {if(showPass.isSelected()) password.setEchoChar((char)0); else{password.setEchoChar('*');}});
		frame.add(showPass);
	}
	public void criarConta() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setBounds(75,30,60,30);
		frame.add(nomeLabel);
		
		JTextField nome = new JTextField("");
		nome.setBounds(150,35,200,25);
		nome.setBorder(BorderFactory.createEmptyBorder());
		frame.add(nome);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setBounds(60,70,60,30);
		frame.add(passLabel);
		
		JPasswordField pass = new JPasswordField("");
		pass.setBounds(150,75,200,25);
		pass.setBorder(BorderFactory.createEmptyBorder());
		pass.setEchoChar('*');
		frame.add(pass);
		
		JCheckBox showPass = new JCheckBox("Show");
		showPass.setBounds(352,78,120,20);
		showPass.setFocusable(false);
		showPass.setBackground(new Color(227,241,172));
		showPass.addActionListener(e -> {if(showPass.isSelected()) pass.setEchoChar((char)0); else{pass.setEchoChar('*');}});
		frame.add(showPass);
		
		JLabel userLabel = new JLabel("Username");
		userLabel.setBounds(60,110,60,30);
		frame.add(userLabel);
		
		JTextField userName = new JTextField();
		userName.setBounds(150,115,200,25);
		userName.setBorder(BorderFactory.createEmptyBorder());
		frame.add(userName);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(75,150,60,30);
		frame.add(emailLabel);
		
		JTextField mail = new JTextField();
		mail.setBounds(150,155,200,25);
		mail.setBorder(BorderFactory.createEmptyBorder());
		frame.add(mail);
		
		JRadioButton t=new JRadioButton("Turista");    
		JRadioButton a=new JRadioButton("Admin");   
		t.setBounds(260,220,70,30);
		a.setBounds(160,220,70,30);
		t.setBackground(new Color(227,241,172));
		a.setBackground(new Color(227,241,172));
		t.setFocusable(false);
		a.setFocusable(false);
		
		ButtonGroup bg = new ButtonGroup();    
		bg.add(t);
		bg.add(a);
		
		frame.add(t);
		frame.add(a);
		
		JLabel nomeErro = new JLabel();
		nomeErro.setBounds(150,15,200,25);
		frame.add(nomeErro);
		
		JLabel passErro = new JLabel();
		passErro.setBounds(150,55,200,25);
		frame.add(passErro);
		
		JLabel userErro = new JLabel();
		userErro.setBounds(150,95,200,25);
		frame.add(userErro);
		
		JLabel emailErro = new JLabel();
		emailErro.setBounds(150,135,200,25);
		frame.add(emailErro);
		
		JLabel adminTuristaErro = new JLabel();
		adminTuristaErro.setBounds(170,195,200,30);
		frame.add(adminTuristaErro);
		
		JButton criarconta = new JButton("Criar Conta");
		criarconta.setBounds(240,280,110,20);
		criarconta.setFocusable(false);
		criarconta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(nome.getText().length() == 0 || pass.getPassword().length == 0 || userName.getText().length() == 0 || mail.getText().length() == 0 || t.isSelected() == false && a.isSelected() == false) {
					if(nome.getText().length() == 0) {
						nome.setBorder(BorderFactory.createEtchedBorder());
						nome.setBackground(new Color(255,204,204));
						nomeErro.setText("Insira o Nome");
						nomeErro.setForeground(new Color(255,0,0));
					}
					else {
						nomeErro.setText("");
						nome.setBackground(Color.white);
					}
					if(pass.getPassword().length == 0) {
						pass.setBorder(BorderFactory.createEtchedBorder());
						pass.setBackground(new Color(255,204,204));
						passErro.setText("Insira a Password");
						passErro.setForeground(new Color(255,0,0));
					}
					else {
						passErro.setText("");
						pass.setBackground(Color.white);
					}
					if(userName.getText().length() == 0) {
						userName.setBorder(BorderFactory.createEtchedBorder());
						userName.setBackground(new Color(255,204,204));
						userErro.setText("Insira o Username");
						userErro.setForeground(new Color(255,0,0));
					}
					else {
						userErro.setText("");
						userName.setBackground(Color.white);
					}
					if(mail.getText().length() == 0) {
						mail.setBorder(BorderFactory.createEtchedBorder());
						mail.setBackground(new Color(255,204,204));
						emailErro.setText("Insira o Email");
						emailErro.setForeground(new Color(255,0,0));
					}
					else {
						emailErro.setText("");
						mail.setBackground(Color.white);
					}
					if(t.isSelected() == false && a.isSelected() == false) {
						t.setForeground(new Color(255,0,0));
						a.setForeground(new Color(255,0,0));
						adminTuristaErro.setText("*Este campo é obrigatorio*");
						adminTuristaErro.setForeground(new Color(255,0,0));
					}
					else {
						adminTuristaErro.setText("");
						t.setForeground(Color.black);
						a.setForeground(Color.black);
					}
				}
				else {
					boolean tipoUtilizador;
					if(t.isSelected() == true) {
						tipoUtilizador = true;
					}
					else {
						tipoUtilizador = false;
					}
					String password = "";
					for (int i = 0; i < pass.getPassword().length; i++) {
						password += pass.getPassword()[i];
					
					}
					String nomeUtilizador = nome.getText();
					String username = userName.getText();
					String email = mail.getText();
					try {
						gerir.writeToDataBase(nomeUtilizador,password,username, tipoUtilizador,email);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					menu();
					sucessoMsg("Conta criada com sucesso");
					} 
				}
		});
		frame.add(criarconta);
		
		JButton voltar = new JButton("Voltar atrás");
		voltar.setBounds(125,280,110,20);
		voltar.setFocusable(false);
		frame.add(voltar);
		voltar.addActionListener(e -> menu());
	}
	public void menuAdmin() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JLabel admin = new JLabel("Admin");
		admin.setBounds(153,70,130,30);
		admin.setForeground(new Color(30,75,63));
		admin.setFont(new Font("Mv Boli",Font.BOLD, 35));
		frame.add(admin);
		
		JButton adicionarFontesFonta= new JButton("Adicionar fontes e fontanários");
		adicionarFontesFonta.setBounds(100,160,230,30);
		adicionarFontesFonta.setFocusable(false);
		adicionarFontesFonta.addActionListener(e -> adicionarFontesFontanarios());
		frame.add(adicionarFontesFonta);
		
		JButton editarFontesFonta= new JButton("Editar fontes e fontanários");
		editarFontesFonta.setBounds(100,200,230,30);
		editarFontesFonta.setFocusable(false);
		editarFontesFonta.addActionListener(e -> {
			try {
				editarFontesFonta();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		frame.add(editarFontesFonta);
		
		JButton previwTurista= new JButton("Preview Turista");
		previwTurista.setBounds(100,240,230,30);
		previwTurista.setFocusable(false);
		previwTurista.addActionListener(e -> previewTurista());
		frame.add(previwTurista);
		
		JButton terminaSessao= new JButton("Terminar Sessão");
		terminaSessao.setBounds(100,280,230,30);
		terminaSessao.setFocusable(false);
		terminaSessao.addActionListener(e -> login());
		frame.add(terminaSessao);
	}
	public void adicionarFontesFontanarios() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,540);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JRadioButton fonte=new JRadioButton("Fonte");    
		JRadioButton fonta=new JRadioButton("Fontanário");   
		fonte.setBounds(170,370,70,30);
		fonta.setBounds(270,370,100,30);
		fonte.setBackground(new Color(227,241,172));
		fonta.setBackground(new Color(227,241,172));
		fonte.setFocusable(false);
		fonta.setFocusable(false);
		
		ButtonGroup bg = new ButtonGroup();    
		bg.add(fonte);
		bg.add(fonta);
		
		frame.add(fonte);
		frame.add(fonta);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(85,30,60,30);
		frame.add(nomeLabel);
		
		JTextField nome = new JTextField("");
		nome.setBounds(160,35,200,25);
		nome.setBorder(BorderFactory.createEmptyBorder());
		frame.add(nome);
		
		JLabel localizacaoLabel = new JLabel("Localização:");
		localizacaoLabel.setBounds(70,70,80,30);
		frame.add(localizacaoLabel);
		
		JTextField localizacao = new JTextField("");
		localizacao.setBounds(160,75,200,25);
		localizacao.setBorder(BorderFactory.createEmptyBorder());
		frame.add(localizacao);
		
		JLabel anoContrucaoLabel = new JLabel("Ano de construção:");
		anoContrucaoLabel.setBounds(30,110,120,30);
		frame.add(anoContrucaoLabel);
		
		JTextField anoConstrucao = new JTextField("");
		anoConstrucao.setBounds(160,115,200,25);
		anoConstrucao.setBorder(BorderFactory.createEmptyBorder());
		frame.add(anoConstrucao);
		
		JLabel historiaLabel = new JLabel("História:");
		historiaLabel.setBounds(70,150,60,30);
		frame.add(historiaLabel);
		
		JTextField historia = new JTextField("");
		historia.setBounds(160,155,200,200);
		historia.setBorder(BorderFactory.createEmptyBorder());
		frame.add(historia);
		
		JLabel rateLabel = new JLabel("Rating dos admins:");
		rateLabel.setBounds(30,430,120,30);
		frame.add(rateLabel);
		
		JRadioButton rateOne = new JRadioButton("1");    
		JRadioButton rateTwo = new JRadioButton("2");
		JRadioButton rateThree = new JRadioButton("3");    
		JRadioButton rateFour = new JRadioButton("4"); 
		JRadioButton rateFive = new JRadioButton("5");    
		rateOne.setBounds(150,430,50,30);
		rateTwo.setBounds(200,430,50,30);
		rateThree.setBounds(250,430,50,30);
		rateFour.setBounds(300,430,50,30);
		rateFive.setBounds(350,430,50,30);
		rateOne.setBackground(new Color(227,241,172));
		rateTwo.setBackground(new Color(227,241,172));
		rateThree.setBackground(new Color(227,241,172));
		rateFour.setBackground(new Color(227,241,172));
		rateFive.setBackground(new Color(227,241,172));
		rateOne.setFocusable(false);
		rateTwo.setFocusable(false);
		rateThree.setFocusable(false);
		rateFour.setFocusable(false);
		rateFive.setFocusable(false);
		
		ButtonGroup rTG = new ButtonGroup();    
		rTG.add(rateOne);
		rTG.add(rateTwo);
		rTG.add(rateThree);
		rTG.add(rateFour);
		rTG.add(rateFive);
		
		frame.add(rateOne);
		frame.add(rateTwo);
		frame.add(rateThree);
		frame.add(rateFour);
		frame.add(rateFive);
		
		JButton submete = new JButton("Submeter");
		submete.setBounds(205,470,100,25);
		submete.setFocusable(false);
		
		JLabel nomeErro = new JLabel();
		nomeErro.setBounds(160,15,200,25);
		frame.add(nomeErro);
		
		JLabel locErro = new JLabel();
		locErro.setBounds(160,55,200,25);
		frame.add(locErro);
		
		JLabel anoErro = new JLabel();
		anoErro.setBounds(160,95,200,25);
		frame.add(anoErro);
		
		JLabel histErro = new JLabel();
		histErro.setBounds(160,135,200,25);
		frame.add(histErro);
		
		JLabel tipoErro = new JLabel();
		tipoErro.setBounds(190,350,200,30);
		frame.add(tipoErro);
		
		JLabel rateErro = new JLabel();
		rateErro.setBounds(190,400,200,30);
		frame.add(rateErro);
		
		submete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nome.getText().length() == 0 || localizacao.getText().length() == 0 || anoConstrucao.getText().length() == 0 || historia.getText().length() == 0 || fonte.isSelected() == false && fonta.isSelected() == false || rateOne.isSelected() == false && rateTwo.isSelected() == false && rateThree.isSelected() == false && rateFour.isSelected() == false && rateFive.isSelected() == false) {
					if(nome.getText().length() == 0) {
						nome.setBorder(BorderFactory.createEtchedBorder());
						nome.setBackground(new Color(255,204,204));
						nomeErro.setText("Insira o Nome");
						nomeErro.setForeground(new Color(255,0,0));
					}
					else {
						nomeErro.setText("");
						nome.setBackground(Color.white);
					}
					if(localizacao.getText().length() == 0) {
						localizacao.setBorder(BorderFactory.createEtchedBorder());
						localizacao.setBackground(new Color(255,204,204));
						locErro.setText("Insira a localização");
						locErro.setForeground(new Color(255,0,0));
					}
					else {
						locErro.setText("");
						localizacao.setBackground(Color.white);
					}
					if(anoConstrucao.getText().length() == 0) {
						anoConstrucao.setBorder(BorderFactory.createEtchedBorder());
						anoConstrucao.setBackground(new Color(255,204,204));
						anoErro.setText("Insira o ano");
						anoErro.setForeground(new Color(255,0,0));
					}
					else {
						anoErro.setText("");
						anoConstrucao.setBackground(Color.white);
					}
					if(historia.getText().length() == 0) {
						historia.setBorder(BorderFactory.createEtchedBorder());
						historia.setBackground(new Color(255,204,204));
						histErro.setText("Insira a história");
						histErro.setForeground(new Color(255,0,0));
					}
					else {
						histErro.setText("");
						historia.setBackground(Color.white);
					}
					if(fonte.isSelected() == false && fonta.isSelected() == false) {
						fonte.setForeground(new Color(255,0,0));
						fonta.setForeground(new Color(255,0,0));
						tipoErro.setText("*Este campo é obrigatorio*");
						tipoErro.setForeground(new Color(255,0,0));
					}
					else {
						tipoErro.setText("");
						fonte.setForeground(Color.black);
						fonta.setForeground(Color.black);
					}
					if(rateOne.isSelected() == false && rateTwo.isSelected() == false && rateThree.isSelected() == false && rateFour.isSelected() == false && rateFive.isSelected() == false) {
						rateOne.setForeground(new Color(255,0,0));
						rateTwo.setForeground(new Color(255,0,0));
						rateThree.setForeground(new Color(255,0,0));
						rateFour.setForeground(new Color(255,0,0));
						rateFive.setForeground(new Color(255,0,0));
						rateErro.setText("*Este campo é obrigatorio*");
						rateErro.setForeground(new Color(255,0,0));
					}
					else {
						rateErro.setText("");
						rateOne.setForeground(Color.black);
						rateTwo.setForeground(Color.black);
						rateThree.setForeground(Color.black);
						rateFour.setForeground(Color.black);
						rateFive.setForeground(Color.black);
					}
				}
				else {
					boolean tipo;
					if(fonte.isSelected() == true) {
						tipo = true;
					}
					else {
						tipo = false;
					}
					String rate = "";
					if(rateOne.isSelected() == true) {
						rate = "1";
					}
					if(rateTwo.isSelected() == true) {
						rate = "2";
					}
					if(rateThree.isSelected() == true) {
						rate = "3";
					}
					if(rateFour.isSelected() == true) {
						rate = "4";
					}
					if(rateFive.isSelected() == true) {
						rate = "5";
					}
					String nomeStr = nome.getText();
					String loc = localizacao.getText();
					String ano = anoConstrucao.getText();
					String hist = historia.getText();
					try {
						gerir.writeToFontes(tipo,nomeStr,loc,ano,hist, rate);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					menuAdmin();
					
					sucessoMsg("Fonte/Fontanário adicionada com sucesso");
				}
				
			}
		});
		
		frame.add(submete);
		
		ImageIcon voltarImage = new ImageIcon("arrow.png");
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuAdmin());
		frame.add(voltar);
	}
	public void editarFontesFonta() throws IOException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		System.out.print("Insira o nome da fonte/fontanário: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        gerir.editarFonte_Fontanario(nome);
		
		ImageIcon voltarImage = new ImageIcon("arrow.png");
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuAdmin());
		frame.add(voltar);
	}
	public void previewTurista() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JLabel previewturista = new JLabel("Preview Turista");
		previewturista.setBounds(130,50,200,30);
		previewturista.setForeground(new Color(30,75,63));
		previewturista.setFont(new Font("Mv Boli",Font.BOLD, 20));
		frame.add(previewturista);
		
		JButton listaFontesFonta = new JButton("Ver lista de Fontes e Fontanários");
		listaFontesFonta.setBounds(90,100,250,30);
		listaFontesFonta.setFocusable(false);
		listaFontesFonta.addActionListener(e -> {
			try {
				previewListaFontesFonta();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
		frame.add(listaFontesFonta);
		
		JButton pesquisarFontesFonta = new JButton("Pesquisar Fontes e Fontanários");
		pesquisarFontesFonta.setBounds(90,145,250,30);
		pesquisarFontesFonta.setFocusable(false);
		pesquisarFontesFonta.addActionListener(e -> {
			try {
				previewFontesFonta();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		frame.add(pesquisarFontesFonta);
		
		JButton historicoFontesFonta = new JButton("Ver histórico de Fontes e Fontanários");
		historicoFontesFonta.setBounds(90,190,250,30);
		historicoFontesFonta.setFocusable(false);
		historicoFontesFonta.addActionListener(e -> {
			try {
				previewHistoricoFontesFonta();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		frame.add(historicoFontesFonta);
		
		JButton voltaAdm= new JButton("Voltar ao modo admininistrador");
		voltaAdm.setBounds(90,235,250,30);
		voltaAdm.setFocusable(false);
		voltaAdm.addActionListener(e -> menuAdmin());
		frame.add(voltaAdm);
		
		JButton terminaSessao= new JButton("Terminar Sessão");
		terminaSessao.setBounds(90,280,250,30);
		terminaSessao.setFocusable(false);
		terminaSessao.addActionListener(e -> login());
		frame.add(terminaSessao);
		
		ImageIcon voltarImage = new ImageIcon("arrow.png");
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuAdmin());
		frame.add(voltar);
	}
	
	public void previewListaFontesFonta() throws IOException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		menuListaFontes_Fontanarios(gerir);
		
		ImageIcon voltarImage = new ImageIcon("arrow.png");
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> previewTurista());
		frame.add(voltar);
	}
	public void previewFontesFonta() throws IOException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(420,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		System.out.print("Insira o nome da fonte/fontanário: ");
		Scanner scanner = new Scanner(System.in);
		String nome = scanner.nextLine();
		gerir.procurarFontes_Fontanarios(nome, currentUser);
		
		ImageIcon voltarImage = new ImageIcon("arrow.png");
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> previewTurista());
		frame.add(voltar);
	}
	public void previewHistoricoFontesFonta() throws FileNotFoundException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		gerir.historico(currentUser);
		
		ImageIcon voltarImage = new ImageIcon("arrow.png");
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> previewTurista());
		frame.add(voltar);
	}
	public void menuTurista() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JLabel turistaLabel = new JLabel("Turista");
		turistaLabel.setBounds(150,45,130,30);
		turistaLabel.setForeground(new Color(30,75,63));
		turistaLabel.setFont(new Font("Mv Boli",Font.BOLD, 35));
		frame.add(turistaLabel);
		
		JButton listaFontesFonta = new JButton("Ver lista de Fontes e Fontanários");
		listaFontesFonta.setBounds(90,100,250,30);
		listaFontesFonta.setFocusable(false);
		listaFontesFonta.addActionListener(e -> {
			try {
				verListaFontesFonta();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
		frame.add(listaFontesFonta);
		
		JButton pesquisarFontesFonta = new JButton("Pesquisar Fontes e Fontanários");
		pesquisarFontesFonta.setBounds(90,145,250,30);
		pesquisarFontesFonta.setFocusable(false);
		pesquisarFontesFonta.addActionListener(e -> {
			try {
				pesquisaFontesFonta();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		frame.add(pesquisarFontesFonta);
		
		JButton historicoFontesFonta = new JButton("Ver histórico de Fontes e Fontanários");
		historicoFontesFonta.setBounds(90,190,250,30);
		historicoFontesFonta.setFocusable(false);
		historicoFontesFonta.addActionListener(e -> {
			try {
				verHistoricoFontesFonta();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		frame.add(historicoFontesFonta);
		
		JButton terminaSessao= new JButton("Terminar Sessão");
		terminaSessao.setBounds(90,235,250,30);
		terminaSessao.setFocusable(false);
		terminaSessao.addActionListener(e -> login());
		frame.add(terminaSessao);
	}
	public void verListaFontesFonta() throws IOException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		menuListaFontes_Fontanarios(gerir);
		
		ImageIcon voltarImage = new ImageIcon("arrow.png");
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuTurista());
		frame.add(voltar);
	}
	public void pesquisaFontesFonta() throws IOException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(420,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		System.out.print("Insira o nome da fonte/fontanário: ");
		Scanner scanner = new Scanner(System.in);
		String nome = scanner.nextLine();
		gerir.procurarFontes_Fontanarios(nome, currentUser);
		
		ImageIcon voltarImage = new ImageIcon("arrow.png");
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuTurista());
		frame.add(voltar);
	}
	public void verHistoricoFontesFonta() throws FileNotFoundException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		gerir.historico(currentUser);
		
		ImageIcon voltarImage = new ImageIcon("arrow.png");
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuTurista());
		frame.add(voltar);
	}
	public static void menuListaFontes_Fontanarios(Gerir gerir) throws IOException {
		gerir.listarFontes_Fontanarios();
		int opcao = 0;
		gerir.selecionarFonte_Fontanario(opcao, currentUser);
	}
	public void sucessoMsg(String sucesso) {
		JFrame sucessoFrame = new JFrame();
		sucessoFrame.setSize(300,100);
		sucessoFrame.setLayout(null);
		sucessoFrame.setResizable(false);
		sucessoFrame.setVisible(true);
		
		JLabel sucessoLabel = new JLabel(sucesso);
		sucessoLabel.setBounds(20,0,250,30);
		sucessoLabel.setHorizontalAlignment(JLabel.CENTER);
		sucessoFrame.add(sucessoLabel);
		
		JButton ok = new JButton("Ok");
		ok.setBounds(120,25,50,30);
		ok.addActionListener(e -> sucessoFrame.dispose());
		ok.setFocusable(false);
		sucessoFrame.add(ok);
	}
	public static void main(String[] args) throws IOException {
		gerir.loadDataBase();
		gerir.loadToFontes();
		Interface menu = new Interface();
		menu.menu();
	}
}