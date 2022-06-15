/**
 * 
 */
package fontes_e_fontanarios;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.net.URL;
import java.util.ArrayList;
/**
 * @author Grupo4
 *
 */
public class Interface {
	private JFrame frame = new JFrame("Hello Nature");
	public void menu(){
		
		frame.getContentPane().removeAll();
		frame.setSize(430,450);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JLabel contacto = new JLabel("Contactos:");
		contacto.setBounds(250,382,80,30);
		frame.add(contacto);
		ImageIcon iconInsta = new ImageIcon("insta.png");
		JButton insta = new JButton(iconInsta);
		insta.setBounds(320,385,24,24);
		insta.setBackground(new Color(227,241,172));
		insta.setBorder(BorderFactory.createEmptyBorder());
		insta.setFocusable(false);
		insta.addActionListener(e -> {try{Desktop.getDesktop().browse(new URL("https://www.instagram.com").toURI());} catch(Exception t) {}});
		frame.add(insta);
		ImageIcon iconFace = new ImageIcon("face.png");
		JButton face = new JButton(iconFace);
		face.setBounds(350,385,24,24);
		face.setFocusable(false);
		face.setBackground(new Color(227,241,172));
		face.setBorder(BorderFactory.createEmptyBorder());
		face.addActionListener(e -> {try{Desktop.getDesktop().browse(new URL("https://www.facebook.com").toURI());} catch(Exception t) {}});
		frame.add(face);
		ImageIcon iconTwit = new ImageIcon("twit.png");
		JButton twit = new JButton(iconTwit);
		twit.setBounds(380,385,24,24);
		twit.setFocusable(false);
		twit.setBackground(new Color(227,241,172));
		twit.setBorder(BorderFactory.createEmptyBorder());
		twit.addActionListener(e -> {try{Desktop.getDesktop().browse(new URL("https://twitter.com").toURI());} catch(Exception t) {}});
		frame.add(twit);
		
		
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
		
		continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nome.getText().length() == 0) {
					nome.setBorder(BorderFactory.createEtchedBorder());
					nome.setBackground(new Color(255,204,204));
					nomeErro.setText("Insira o Username");
					nomeErro.setForeground(new Color(255,0,0));
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
				}
				else {
					passErro.setText("");
					password.setBackground(Color.white);
				}
				menuAdmin();
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
		
		JPasswordField password = new JPasswordField("");
		password.setBounds(150,75,200,25);
		password.setBorder(BorderFactory.createEmptyBorder());
		password.setEchoChar('*');
		frame.add(password);
		
		JCheckBox showPass = new JCheckBox("Show");
		showPass.setBounds(352,78,120,20);
		showPass.setFocusable(false);
		showPass.setBackground(new Color(227,241,172));
		showPass.addActionListener(e -> {if(showPass.isSelected()) password.setEchoChar((char)0); else{password.setEchoChar('*');}});
		frame.add(showPass);
		
		JLabel userLabel = new JLabel("Username");
		userLabel.setBounds(60,110,60,30);
		frame.add(userLabel);
		
		JTextField username = new JTextField();
		username.setBounds(150,115,200,25);
		username.setBorder(BorderFactory.createEmptyBorder());
		frame.add(username);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(75,150,60,30);
		frame.add(emailLabel);
		
		JTextField email = new JTextField();
		email.setBounds(150,155,200,25);
		email.setBorder(BorderFactory.createEmptyBorder());
		frame.add(email);
		
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
		
		JButton criarconta = new JButton("Criar Conta");
		criarconta.setBounds(240,280,110,20);
		criarconta.setFocusable(false);
		criarconta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		admin.setBounds(130,70,130,30);
		admin.setForeground(new Color(30,75,63));
		admin.setFont(new Font("Mv Boli",Font.BOLD, 35));
		frame.add(admin);
		
		JButton adicionarFontesFonta= new JButton("Adicionar fontes e fontanários");
		adicionarFontesFonta.setBounds(100,160,230,30);
		adicionarFontesFonta.setFocusable(false);
		adicionarFontesFonta.addActionListener(e -> adicionarFontesFontanarios());
		frame.add(adicionarFontesFonta);
		
		JButton verficarComentarios= new JButton("Verificar comentários");
		verficarComentarios.setBounds(100,200,230,30);
		verficarComentarios.setFocusable(false);
		verficarComentarios.addActionListener(e -> verificarComentarios());
		frame.add(verficarComentarios);
		
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
		frame.setSize(430,450);
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
		
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(0,0,40,20);
		voltar.setHorizontalAlignment(SwingConstants.LEFT);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuAdmin());
		frame.add(voltar);
	}
	public void verificarComentarios() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(0,0,40,20);
		voltar.setHorizontalAlignment(SwingConstants.LEFT);
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
		previewturista.setBounds(130,70,200,30);
		previewturista.setForeground(new Color(30,75,63));
		previewturista.setFont(new Font("Mv Boli",Font.BOLD, 20));
		frame.add(previewturista);
		
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(0,0,40,20);
		voltar.setHorizontalAlignment(SwingConstants.LEFT);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuAdmin());
		frame.add(voltar);
	}
	public void menuTurista() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JButton listaFontesFonta = new JButton("Ver lista de Fontes e Fontanários");
		listaFontesFonta.setBounds(90,100,250,30);
		listaFontesFonta.setFocusable(false);
		listaFontesFonta.addActionListener(e -> verListaFontesFonta());
		frame.add(listaFontesFonta);
		
		JButton pesquisarFontesFonta = new JButton("Pesquisar Fontes e Fontanários");
		pesquisarFontesFonta.setBounds(90,145,250,30);
		pesquisarFontesFonta.setFocusable(false);
		pesquisarFontesFonta.addActionListener(e -> pesquisaFontesFonta());
		frame.add(pesquisarFontesFonta);
		
		JButton historicoFontesFonta = new JButton("Ver histórico de Fontes e Fontanários");
		historicoFontesFonta.setBounds(90,190,250,30);
		historicoFontesFonta.setFocusable(false);
		historicoFontesFonta.addActionListener(e -> verHistoricoFontesFonta());
		frame.add(historicoFontesFonta);
		
		JButton terminaSessao= new JButton("Terminar Sessão");
		terminaSessao.setBounds(90,235,250,30);
		terminaSessao.setFocusable(false);
		terminaSessao.addActionListener(e -> login());
		frame.add(terminaSessao);
	}
	public void verListaFontesFonta() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(0,0,40,20);
		voltar.setHorizontalAlignment(SwingConstants.LEFT);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuTurista());
		frame.add(voltar);
	}
	public void pesquisaFontesFonta() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(420,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(0,0,40,20);
		voltar.setHorizontalAlignment(SwingConstants.LEFT);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuTurista());
		frame.add(voltar);
	}
	public void verHistoricoFontesFonta() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(new Color(227,241,172));
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(0,0,40,20);
		voltar.setHorizontalAlignment(SwingConstants.LEFT);
		voltar.setFocusable(false);
		voltar.setBackground(new Color(227,241,172));
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuTurista());
		frame.add(voltar);
	}
	public static void main(String[] args) {
		Interface menu = new Interface();
		menu.menu();
	}
}
