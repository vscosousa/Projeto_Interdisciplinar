/**
 * 
 */
package fontes_e_fontanarios;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
/**
 * @author Grupo4
 *
 */
public class Interface {
	private JFrame frame = new JFrame("Hello Nature");
	static Gerir gerir = new Gerir(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
	private static String currentUser = "";
	private JLabel contacto = new JLabel();
	private JButton insta = new JButton();
	private JButton face = new JButton();
	private JButton email = new JButton();
	private JButton twit = new JButton();
	private Color color;
	private Color whiteBlack;
	private String image;
	private static String coordenadas = "";
	private static int x = 0;
	
	public void menu(){
		
		frame.getContentPane().removeAll();
		frame.setSize(430,450);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		
		contactos();
		contacto.setVisible(true);
		insta.setVisible(true);
		face.setVisible(true);
		twit.setVisible(true);
		email.setVisible(true);
		
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
		
		ImageIcon logo = new ImageIcon("src/Imagens/Logo.png");
		frame.setIconImage(logo.getImage());
		
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
		
		ImageIcon fonteIcon = new ImageIcon("src/Imagens/fonte.png"); 
		JLabel fonte = new JLabel();
		fonte.setIcon(fonteIcon);
		fonte.setBounds(-70,163,256,256);
		frame.add(fonte);
		
		ImageIcon torneiraIcon = new ImageIcon("src/Imagens/torneira.png"); 
		JLabel torneira = new JLabel();
		torneira.setIcon(torneiraIcon);
		torneira.setBounds(290,10,128,128);
		frame.add(torneira);
		
		ImageIcon folhasIcon = new ImageIcon("src/Imagens/folhas.png"); 
		JLabel folhas = new JLabel();
		folhas.setIcon(folhasIcon);
		folhas.setBounds(-25,-25,128,128);
		frame.add(folhas);
		
		frame.getContentPane().setBackground(new Color(227,241,172));
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
						nomeErro.setForeground(Color.red);
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
						passErro.setForeground(Color.red);
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
						image = "src/Imagens/arrow.png";
						menuTurista();
					}
					else if (gerir.procurarUtilizador(usernameLogin, passwordLogin).equals("Administrador")) {
						image = "src/Imagens/warrow.png";
						menuAdmin();
					}
					else {
						naoExiste.setForeground(Color.red);
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
						nomeErro.setForeground(Color.red);
					}
					else {
						nomeErro.setText("");
						nome.setBackground(Color.white);
					}
					if(pass.getPassword().length == 0) {
						pass.setBorder(BorderFactory.createEtchedBorder());
						pass.setBackground(new Color(255,204,204));
						passErro.setText("Insira a Password");
						passErro.setForeground(Color.red);
					}
					else {
						passErro.setText("");
						pass.setBackground(Color.white);
					}
					if(userName.getText().length() == 0) {
						userName.setBorder(BorderFactory.createEtchedBorder());
						userName.setBackground(new Color(255,204,204));
						userErro.setText("Insira o Username");
						userErro.setForeground(Color.red);
					}
					else {
						userErro.setText("");
						userName.setBackground(Color.white);
					}
					if(mail.getText().length() == 0) {
						mail.setBorder(BorderFactory.createEtchedBorder());
						mail.setBackground(new Color(255,204,204));
						emailErro.setText("Insira o Email");
						emailErro.setForeground(Color.red);
					}
					else {
						emailErro.setText("");
						mail.setBackground(Color.white);
					}
					if(t.isSelected() == false && a.isSelected() == false) {
						t.setForeground(Color.red);
						a.setForeground(Color.red);
						adminTuristaErro.setText("*Este campo é obrigatorio*");
						adminTuristaErro.setForeground(Color.red);
					}
					else {
						adminTuristaErro.setText("");
						t.setForeground(Color.black);
						a.setForeground(Color.black);
					}
				}
				else {
					nomeErro.setText("");
					nome.setBackground(Color.white);
					passErro.setText("");
					pass.setBackground(Color.white);
					userErro.setText("");
					userName.setBackground(Color.white);
					emailErro.setText("");
					mail.setBackground(Color.white);
					adminTuristaErro.setText("");
					t.setForeground(Color.black);
					a.setForeground(Color.black);
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
					String pass = password;
					String nomeUtilizador = nome.getText();
					String username = userName.getText();
					String email = mail.getText();
					for(int i = 0; i < gerir.contas.size(); i++) {
						for(int j = i; j < gerir.contas.size(); j++) {
							if(gerir.contas.get(i).getUsername().equalsIgnoreCase(username) && gerir.contas.get(j).getEmail().equalsIgnoreCase(email) || gerir.contas.get(j).getUsername().equalsIgnoreCase(username) && gerir.contas.get(i).getEmail().equalsIgnoreCase(email)) {
								userErro.setText("Username em uso");
								userErro.setForeground(Color.red);
								userName.setBackground(new Color(255,204,204));
								emailErro.setText("Email já registado");
								emailErro.setForeground(Color.red);
								mail.setBackground(new Color(255,204,204));
								return;
							}
							else {
								userErro.setText("");
								emailErro.setText("");
							}
						}
						
						if(gerir.contas.get(i).getUsername().equalsIgnoreCase(username)) {
							userErro.setText("Username em uso");
							userErro.setForeground(Color.red);
							userName.setBackground(new Color(255,204,204));
							return;
						}
						else {
							userErro.setText("");
						}
						if(gerir.contas.get(i).getEmail().equalsIgnoreCase(email)) {
							emailErro.setText("Email já registado");
							emailErro.setForeground(Color.red);
							mail.setBackground(new Color(255,204,204));
							return;
						}
						else {
							emailErro.setText("");
						}
					}
					if(tipoUtilizador == false) {
						JFrame codeFrame = new JFrame("Validação");
						codeFrame.setSize(300,140);
						codeFrame.setResizable(false);
						codeFrame.getContentPane().setBackground(new Color(227,241,172));
						codeFrame.setLocationRelativeTo(null);
						ImageIcon logo = new ImageIcon("src/Imagens/Logo.png");
						codeFrame.setIconImage(logo.getImage());
						codeFrame.setLayout(null);
						codeFrame.setVisible(true);
						
						JLabel codeLabel = new JLabel("Código:");
						codeLabel.setBounds(20,26,60,30);
						codeFrame.add(codeLabel);
						
						JLabel codeErro = new JLabel();
						codeErro.setBounds(100,3,150,30);
						codeFrame.add(codeErro);
						
						JTextField code = new JTextField();
						code.setBounds(80,30,150,25);
						codeFrame.add(code);
						
						JButton ok = new JButton("OK");
						ok.setBounds(120,70,60,25);
						ok.setFocusable(false);
						codeFrame.add(ok);
						
						ok.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e){
								if(!(code.getText().equals("POOSITU"))) {
									codeErro.setText("*Código Invalido*");
									code.setBackground(new Color(255,204,204));
									codeErro.setForeground(Color.red);
								}
								else {
									try {
										gerir.writeToDataBase(nomeUtilizador, pass, username, tipoUtilizador, email);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									sucessoMsg("Conta criada com sucesso");
									menu();
									codeFrame.dispose();
								}
							}
						});
					}
					else {
						try {
							gerir.writeToDataBase(nomeUtilizador, password, username, tipoUtilizador, email);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						sucessoMsg("Conta criada com sucesso");
						menu();
					}
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
		frame.getContentPane().setBackground(color);
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JLabel admin = new JLabel("Admin");
		admin.setBounds(153,70,130,30);
		admin.setForeground(new Color(30,75,63));
		admin.setFont(new Font("Mv Boli",Font.BOLD, 35));
		frame.add(admin);
		
		JButton adicionarFontesFonta = new JButton("Adicionar fontes e fontanários");
		adicionarFontesFonta.setBounds(100,160,230,30);
		adicionarFontesFonta.setFocusable(false);
		adicionarFontesFonta.addActionListener(e -> adicionarFontesFontanarios());
		frame.add(adicionarFontesFonta);
		
		JButton editarFontesFonta = new JButton("Editar fontes e fontanários");
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
		
		JButton previwTurista = new JButton("Preview Turista");
		previwTurista.setBounds(100,280,230,30);
		previwTurista.setFocusable(false);
		previwTurista.addActionListener(e -> previewTurista());
		frame.add(previwTurista);
		
		JButton verSugestoes = new JButton("Ver Sugestões");
		verSugestoes.setBounds(100,240,230,30);
		verSugestoes.setFocusable(false);
		verSugestoes.addActionListener(e -> verSugestoes());
		frame.add(verSugestoes);
		
		JButton terminaSessao = new JButton("Terminar Sessão");
		terminaSessao.setBounds(100,320,230,30);
		terminaSessao.setFocusable(false);
		terminaSessao.addActionListener(e -> login());
		frame.add(terminaSessao);
		
		if (image == "src/Imagens/warrow.png") {
			imagensLua();
		}
		else imagensSol();
		
		
		contacto.setVisible(false);
		insta.setVisible(false);
		face.setVisible(false);
		twit.setVisible(false);
		email.setVisible(false);
	}
	public void adicionarFontesFontanarios() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(color);
		frame.setSize(430,540);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JRadioButton fonte=new JRadioButton("Fonte");    
		JRadioButton fonta=new JRadioButton("Fontanário");   
		fonte.setBounds(170,375,70,30);
		fonta.setBounds(270,375,100,30);
		fonte.setBackground(color);
		fonta.setBackground(color);
		fonte.setForeground(whiteBlack);
		fonta.setForeground(whiteBlack);
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
		nomeLabel.setForeground(whiteBlack);
		
		JTextField nome = new JTextField("");
		nome.setBounds(160,35,200,25);
		nome.setBorder(BorderFactory.createEmptyBorder());
		frame.add(nome);
		
		JLabel localizacaoLabel = new JLabel("Localização:");
		localizacaoLabel.setBounds(70,70,80,30);
		frame.add(localizacaoLabel);
		localizacaoLabel.setForeground(whiteBlack);
		
		JTextField localizacao = new JTextField("");
		localizacao.setBounds(160,75,200,25);
		localizacao.setBorder(BorderFactory.createEmptyBorder());
		frame.add(localizacao);
		
		JLabel anoContrucaoLabel = new JLabel("Ano de construção:");
		anoContrucaoLabel.setBounds(30,110,120,30);
		frame.add(anoContrucaoLabel);
		anoContrucaoLabel.setForeground(whiteBlack);
		
		JTextField anoConstrucao = new JTextField("");
		anoConstrucao.setBounds(160,115,200,25);
		anoConstrucao.setBorder(BorderFactory.createEmptyBorder());
		frame.add(anoConstrucao);
		
		JLabel historiaLabel = new JLabel("História:");
		historiaLabel.setBounds(70,150,60,30);
		frame.add(historiaLabel);
		historiaLabel.setForeground(whiteBlack);
		
		JTextField historia = new JTextField("");
		historia.setBounds(160,155,200,200);
		historia.setBorder(BorderFactory.createEmptyBorder());
		frame.add(historia);
		
		JLabel rateLabel = new JLabel("Rating dos admins:");
		rateLabel.setBounds(30,430,120,30);
		frame.add(rateLabel);
		rateLabel.setForeground(whiteBlack);
		
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
		rateOne.setBackground(color);
		rateTwo.setBackground(color);
		rateThree.setBackground(color);
		rateFour.setBackground(color);
		rateFive.setBackground(color);
		rateOne.setForeground(whiteBlack);
		rateTwo.setForeground(whiteBlack);
		rateThree.setForeground(whiteBlack);
		rateFour.setForeground(whiteBlack);
		rateFive.setForeground(whiteBlack);
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
		
		JLabel linkErro = new JLabel();
		linkErro.setBounds(380,55,20,30);
		frame.add(linkErro);
		
		ImageIcon iconMundo = new ImageIcon("src/Imagens/mundo.png");
		JButton mundo = new JButton();
		mundo.setIcon(iconMundo);
		mundo.setBackground(color);
		mundo.setFocusable(false);
		mundo.setBorder(null);
        mundo.setBounds(370,75,24,24);
        frame.add(mundo);
        
        mundo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame linkFrame = new JFrame("Coordenadas");
                linkFrame.setSize(300,140);
                linkFrame.setResizable(false);
                linkFrame.getContentPane().setBackground(color);
                linkFrame.setLocationRelativeTo(null);
                ImageIcon logo = new ImageIcon("src/Imagens/Logo.png");
                linkFrame.setIconImage(logo.getImage());
                linkFrame.setLayout(null);
                linkFrame.setVisible(true);
                
                JLabel linkLabel = new JLabel("Link:");
                linkLabel.setForeground(whiteBlack);
                linkLabel .setBounds(25,26,50,30);
                linkFrame.add(linkLabel );
                
                JLabel linkErro = new JLabel();
				linkErro.setBounds(80,3,170,30);
				linkFrame.add(linkErro);
                
                JTextField link = new JTextField();
                link.setBounds(80,30,150,25);
                linkFrame.add(link);
                
                JButton ok = new JButton("OK");
                ok.setBounds(120,70,60,25);
                ok.setFocusable(false);
                linkFrame.add(ok);
                
                ok.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                    	if(link.getText().length() == 0) {
                    		linkErro.setText("*Este campo é obrigatorio*");
                    		link.setBackground(new Color(255,204,204));
							linkErro.setForeground(Color.red);
                    	}
                    	else {
                    		coordenadas = link.getText();
                    		linkFrame.dispose();
                    	}
                    }
                });
            }
        });
        
		submete.addActionListener(e -> {
				if(nome.getText().length() == 0 || localizacao.getText().length() == 0 || anoConstrucao.getText().length() == 0 || historia.getText().length() == 0 || fonte.isSelected() == false && fonta.isSelected() == false || rateOne.isSelected() == false && rateTwo.isSelected() == false && rateThree.isSelected() == false && rateFour.isSelected() == false && rateFive.isSelected() == false || coordenadas.length() == 0) {
					if(nome.getText().length() == 0) {
						nome.setBorder(BorderFactory.createEtchedBorder());
						nome.setBackground(new Color(255,204,204));
						nomeErro.setText("Insira o Nome");
						nomeErro.setForeground(Color.red);
					}
					else {
						nomeErro.setText("");
						nome.setBackground(Color.white);
					}
					if(localizacao.getText().length() == 0) {
						localizacao.setBorder(BorderFactory.createEtchedBorder());
						localizacao.setBackground(new Color(255,204,204));
						locErro.setText("Insira a localização");
						locErro.setForeground(Color.red);
					}
					else {
						locErro.setText("");
						localizacao.setBackground(Color.white);
					}
					if(anoConstrucao.getText().length() == 0) {
						anoConstrucao.setBorder(BorderFactory.createEtchedBorder());
						anoConstrucao.setBackground(new Color(255,204,204));
						anoErro.setText("Insira o ano");
						anoErro.setForeground(Color.red);
					}
					else {
						anoErro.setText("");
						anoConstrucao.setBackground(Color.white);
					}
					if(historia.getText().length() == 0) {
						historia.setBorder(BorderFactory.createEtchedBorder());
						historia.setBackground(new Color(255,204,204));
						histErro.setText("Insira a história");
						histErro.setForeground(Color.red);
					}
					else {
						histErro.setText("");
						historia.setBackground(Color.white);
					}
					if(fonte.isSelected() == false && fonta.isSelected() == false) {
						fonte.setForeground(Color.red);
						fonta.setForeground(Color.red);
						tipoErro.setText("*Este campo é obrigatorio*");
						tipoErro.setForeground(Color.red);
					}
					else {
						tipoErro.setText("");
						fonte.setForeground(Color.black);
						fonta.setForeground(Color.black);
					}
					if(rateOne.isSelected() == false && rateTwo.isSelected() == false && rateThree.isSelected() == false && rateFour.isSelected() == false && rateFive.isSelected() == false) {
						rateOne.setForeground(Color.red);
						rateTwo.setForeground(Color.red);
						rateThree.setForeground(Color.red);
						rateFour.setForeground(Color.red);
						rateFive.setForeground(Color.red);
						rateErro.setText("*Este campo é obrigatorio*");
						rateErro.setForeground(Color.red);
					}
					else {
						rateErro.setText("");
						rateOne.setForeground(Color.black);
						rateTwo.setForeground(Color.black);
						rateThree.setForeground(Color.black);
						rateFour.setForeground(Color.black);
						rateFive.setForeground(Color.black);
					}
					if(coordenadas.length() == 0) {	
						linkErro.setText("*");
						linkErro.setForeground(Color.red);
					}
					else {
						linkErro.setText("");
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
					try {
                        gerir.writeCoordenadas(coordenadas);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
					menuAdmin();
					
					sucessoMsg("Fonte/Fontanário adicionada com sucesso");
				}
		});
		
		frame.add(submete);
		ImageIcon voltarImage = new ImageIcon(image);
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(color);
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuAdmin());
		frame.add(voltar);
	}
	public void editarFontesFonta() throws IOException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(color);
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JTextField name = new JTextField();
		name.setBounds(80,40,200,30);
		frame.add(name);
		
		JLabel nomeErro = new JLabel();
		nomeErro.setBounds(80,10,200,30);
		frame.add(nomeErro);
		
		JTextField nome = new JTextField();
		nome.setBounds(10,100,300,30);
	
		String[] tiposUtil = {"Fonte", "Fontanário"};
		JList tipo = new JList(tiposUtil);
		tipo.setBounds(10,140,100,36);
		
		JTextField loc = new JTextField();
		loc.setBounds(10,190,300,30);
		
		JTextField anoConst = new JTextField();
		anoConst.setBounds(10,230,40,30);
		
		JTextField hist = new JTextField();
		hist.setBounds(10,270,500,30);
		
		JRadioButton rateOne = new JRadioButton("1");    
		JRadioButton rateTwo = new JRadioButton("2");
		JRadioButton rateThree = new JRadioButton("3");    
		JRadioButton rateFour = new JRadioButton("4"); 
		JRadioButton rateFive = new JRadioButton("5");    
		rateOne.setBounds(10,320,50,30);
		rateTwo.setBounds(60,320,50,30);
		rateThree.setBounds(110,320,50,30);
		rateFour.setBounds(160,320,50,30);
		rateFive.setBounds(210,320,50,30);
		rateOne.setBackground(color);
		rateTwo.setBackground(color);
		rateThree.setBackground(color);
		rateFour.setBackground(color);
		rateFive.setBackground(color);
		rateOne.setForeground(whiteBlack);
		rateTwo.setForeground(whiteBlack);
		rateThree.setForeground(whiteBlack);
		rateFour.setForeground(whiteBlack);
		rateFive.setForeground(whiteBlack);
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
		
		JButton edit = new JButton("Editar");
		edit.setBounds(160,370,100,30);
		edit.setFocusable(false);
		edit.setVisible(false);
		frame.add(edit);
		
		ImageIcon erroIcon = new ImageIcon("src/Imagens/erro.png"); 
		JLabel erro = new JLabel();
		erro.setBounds(75,120,256,256);
		frame.add(erro);
		
		ImageIcon iconEnviar = new ImageIcon("src/Imagens/enviar.png");
		JButton ir = new JButton();
		ir.setBounds(10,350,24,24);
		ir.setIcon(iconEnviar);
		ir.setBackground(color);
		ir.setFocusable(false);
		ir.setBorder(null);
		frame.add(ir);
		ir.setVisible(false);

		JButton ok = new JButton("ok");
		ok.setBounds(290,40,50,30);
		ok.setFocusable(false);
		frame.add(ok);
		ok.addActionListener(e -> {
		if(name.getText().length() == 0) {
			nomeErro.setText("Insira o nome");
			nomeErro.setForeground(Color.red);
			name.setBackground(new Color(255,204,204));
			nome.setVisible(false);
			tipo.setVisible(false);
			loc.setVisible(false);
			anoConst.setVisible(false);
			hist.setVisible(false);
			rateOne.setVisible(false);
			rateTwo.setVisible(false);
			rateThree.setVisible(false);
			rateFour.setVisible(false);
			rateFive.setVisible(false);
			edit.setVisible(false);
			erro.setVisible(false);
			ir.setVisible(false);
		}
		else {
			for(int i = 0; i<gerir.fontesFontanarios.size();i++) {
				Fontes_Fontanarios infoFontes_Fontanarios = gerir.fontesFontanarios.get(i);
				if(!(name.getText().equalsIgnoreCase(infoFontes_Fontanarios.getNome()))) {
					nomeErro.setText("Fonte/Fontanário não encontrado");
					nomeErro.setForeground(whiteBlack);
					name.setBackground(Color.white);
					nome.setVisible(false);
					tipo.setVisible(false);
					loc.setVisible(false);
					anoConst.setVisible(false);
					hist.setVisible(false);
					rateOne.setVisible(false);
					rateTwo.setVisible(false);
					rateThree.setVisible(false);
					rateFour.setVisible(false);
					rateFive.setVisible(false);
					edit.setVisible(false);
					erro.setIcon(erroIcon);
					erro.setVisible(true);
					ir.setVisible(false);
				}
			}
			for(int i = 0; i<gerir.fontesFontanarios.size();i++) {
				Fontes_Fontanarios infoFontes_Fontanarios = gerir.fontesFontanarios.get(i);
				Mapa infoCoordenadas = gerir.coordenadas.get(i);
				if((name.getText().equalsIgnoreCase(infoFontes_Fontanarios.getNome()))){
					nome.setText(infoFontes_Fontanarios.getNome());
					nomeErro.setText("");
					name.setBackground(Color.white);
					nome.setVisible(true);
					tipo.setVisible(true);
					loc.setVisible(true);
					anoConst.setVisible(true);
					hist.setVisible(true);
					rateOne.setVisible(true);
					rateTwo.setVisible(true);
					rateThree.setVisible(true);
					rateFour.setVisible(true);
					rateFive.setVisible(true);
					ir.setVisible(true);
					if(infoFontes_Fontanarios.isTipo()) {
						tipo.setSelectedIndex(0);
					}
					else tipo.setSelectedIndex(1);
					if(infoFontes_Fontanarios.getRating().equals("1")) {
						rateOne.setSelected(true);
					}
					if(infoFontes_Fontanarios.getRating().equals("2")) {
						rateTwo.setSelected(true);
					}
					if(infoFontes_Fontanarios.getRating().equals("3")) {
						rateThree.setSelected(true);
					}
					if(infoFontes_Fontanarios.getRating().equals("4")) {
						rateFour.setSelected(true);
					}
					if(infoFontes_Fontanarios.getRating().equals("5")) {
						rateFive.setSelected(true);
					}
					
					coordenadas = infoCoordenadas.getCoordenada();
					
					ir.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e){
			                JFrame linkFrame = new JFrame("Coordenadas");
			                linkFrame.setSize(300,140);
			                linkFrame.setResizable(false);
			                linkFrame.getContentPane().setBackground(color);
			                linkFrame.setLocationRelativeTo(null);
			                ImageIcon logo = new ImageIcon("src/Imagens/Logo.png");
			                linkFrame.setIconImage(logo.getImage());
			                linkFrame.setLayout(null);
			                linkFrame.setVisible(true);
			                
			                JLabel linkLabel = new JLabel("Link:");
			                linkLabel.setForeground(whiteBlack);
			                linkLabel .setBounds(25,26,50,30);
			                linkFrame.add(linkLabel );
			                
			                JTextField link = new JTextField();
			                link.setBounds(80,30,150,25);
			                linkFrame.add(link);
			                
			                JButton ok = new JButton("OK");
			                ok.setBounds(120,70,60,25);
			                ok.setFocusable(false);
			                linkFrame.add(ok);
			                
			                ok.addActionListener(new ActionListener() {
			                    public void actionPerformed(ActionEvent e){
			                    	if(link.getText().equals("Sem Coordenadas")) {
			                    		coordenadas = "Sem Coordenadas";
			                    	}
			                    	else coordenadas = link.getText();
			                        linkFrame.dispose();
			                    }
			                });
			            }
			        });
					
					x = i;
					
					loc.setText(infoFontes_Fontanarios.getLocalizacao());
					anoConst.setText(infoFontes_Fontanarios.getAnoConstrucao());
					hist.setText(infoFontes_Fontanarios.getHistoria());
					erro.setVisible(false);
					edit.setVisible(true);
					edit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
							boolean novoTipoUtil = false;
							if(tipo.getSelectedIndex() == 0) {
								novoTipoUtil = true;
							}
							if(tipo.getSelectedIndex() == 1) {
								novoTipoUtil = false;
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
						try {
							gerir.editarFonte_Fontanario(nome.getText(), novoTipoUtil, loc.getText(), anoConst.getText(), hist.getText(), rate, x, coordenadas);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						sucessoMsg("Fonte/Fontanário editado com sucesso");
						menuAdmin();
						}
					});
				
					frame.add(nome);
					frame.add(tipo);
					frame.add(loc);
					frame.add(anoConst);
					frame.add(hist);
					frame.add(rateOne);
					frame.add(rateTwo);
					frame.add(rateThree);
					frame.add(rateFour);
					frame.add(rateFive);
				}
			}
		}
	});
		
		ImageIcon voltarImage = new ImageIcon(image);
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(color);
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuAdmin());
		frame.add(voltar);
	}
	public void verSugestoes() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(color);
		frame.setSize(450,300);
		frame.setResizable(false);
		frame.setLayout(null);
		
		String[] listaSugestoes = new String[gerir.sugestoes.size()];
		for(int i = 0; i<gerir.sugestoes.size();i++) {
			Fontes_Fontanarios infoSugestoes = gerir.sugestoes.get(i);
			listaSugestoes[i] = infoSugestoes.getNome();
		}
		
		JLabel nome = new JLabel();
		nome.setBounds(10,40,300,30);
		
		JLabel tipo = new JLabel();
		tipo.setBounds(10,80,300,30);
		
		JLabel loc = new JLabel();
		loc.setBounds(10,120,400,30);
		
		JLabel ano = new JLabel();
		ano.setBounds(10,160,300,30);
		
		nome.setForeground(whiteBlack);
		tipo.setForeground(whiteBlack);
		loc.setForeground(whiteBlack);
		ano.setForeground(whiteBlack);
		
		JList lista = new JList(listaSugestoes);
		lista.setFixedCellHeight(32);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50,50,330,150);
		scrollPane.setViewportView(lista);
		frame.add(scrollPane);
		
		JButton continuar = new JButton("Continuar");
		continuar.setBounds(160,220,100,30);
		continuar.setFocusable(false);
		frame.add(continuar);
		continuar.addActionListener(e -> {
			if(lista.isSelectionEmpty() == false) {
				scrollPane.setVisible(false);
				continuar.setVisible(false);
				frame.add(nome);
				frame.add(tipo);
				frame.add(loc);
				frame.add(ano);
				for(int i = 0; i<listaSugestoes.length;i++) {
					  if(lista.getSelectedIndex() == i) {
						  Fontes_Fontanarios infoFontes_Fontanarios = gerir.sugestoes.get(i);
						  if(infoFontes_Fontanarios.isTipo()) {
								tipo.setText("Fonte");
							}
							else tipo.setText("Fontanário");
						  nome.setText(infoFontes_Fontanarios.getNome());
						  loc.setText("Localização: " + infoFontes_Fontanarios.getLocalizacao());
						  ano.setText("Ano de construção: " + infoFontes_Fontanarios.getAnoConstrucao());
					  }
					} 
			}
		});
		ImageIcon voltarImage = new ImageIcon(image);
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(color);
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuAdmin());
		frame.add(voltar);
	}
	public void previewTurista() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(color);
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
			} catch (IOException e1) {
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
		
		ImageIcon camaraIcon = new ImageIcon("src/Imagens/camara.png"); 
		JLabel camara = new JLabel();
		camara.setIcon(camaraIcon);
		camara.setBounds(292,48,32,32);
		frame.add(camara);
		
		if (image == "src/Imagens/warrow.png") {
			imagensLua();
		}
		else imagensSol();
	}
	
	public void previewListaFontesFonta() throws IOException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(color);
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
			
		menuListaFontesFonta();
		
		ImageIcon voltarImage = new ImageIcon(image);
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(color);
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> previewTurista());
		frame.add(voltar);
	}
	public void previewFontesFonta() throws IOException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(color);
		frame.setSize(420,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		menuPesquisaFontesFonta();
		
		ImageIcon voltarImage = new ImageIcon(image);
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(color);
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> previewTurista());
		frame.add(voltar);
	}
	public void previewHistoricoFontesFonta() throws IOException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(color);
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		menuHistorico();
		
		ImageIcon voltarImage = new ImageIcon(image);
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(color);
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> previewTurista());
		frame.add(voltar);
	}
	public void menuTurista() {
		frame.getContentPane().removeAll();
		frame.setSize(430,450);
		frame.getContentPane().setBackground(color);
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
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		frame.add(historicoFontesFonta);
		
		JButton sugerir = new JButton("Sugerir Fonte/Fontanário");
		sugerir.setBounds(90,235,250,30);
		sugerir.setFocusable(false);
		sugerir.addActionListener(e -> sugerir());
		frame.add(sugerir);
		
		JButton terminaSessao = new JButton("Terminar Sessão");
		terminaSessao.setBounds(90,280,250,30);
		terminaSessao.setFocusable(false);
		terminaSessao.addActionListener(e -> login());
		frame.add(terminaSessao);
		
		ImageIcon camaraIcon = new ImageIcon("src/Imagens/camara.png"); 
		JLabel camara = new JLabel();
		camara.setIcon(camaraIcon);
		camara.setBounds(275,45,32,32);
		frame.add(camara);
		
		if (image == "src/Imagens/warrow.png") {
			imagensLua();
		}
		else imagensSol();
			
		
		contacto.setVisible(true);
		insta.setVisible(true);
		face.setVisible(true);
		twit.setVisible(true);
		email.setVisible(true);
	}
	public void verListaFontesFonta() throws IOException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(color);
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		menuListaFontesFonta();
		
		ImageIcon voltarImage = new ImageIcon(image);
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(color);
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuTurista());
		frame.add(voltar);
	}
	public void pesquisaFontesFonta() throws IOException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(color);
		frame.setSize(420,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		menuPesquisaFontesFonta();
		
		ImageIcon voltarImage = new ImageIcon(image);
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(color);
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuTurista());
		frame.add(voltar);
	}
	public void verHistoricoFontesFonta() throws IOException {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(color);
		frame.setSize(430,450);
		frame.setResizable(false);
		frame.setLayout(null);
		
		menuHistorico();
		
		ImageIcon voltarImage = new ImageIcon(image);
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(color);
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuTurista());
		frame.add(voltar);
	}
	public void sugerir() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(color);
		frame.setSize(450,300);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JRadioButton fonte=new JRadioButton("Fonte");    
		JRadioButton fonta=new JRadioButton("Fontanário");   
		fonte.setBounds(170,165,70,30);
		fonta.setBounds(270,165,100,30);
		fonte.setBackground(color);
		fonta.setBackground(color);
		fonte.setForeground(whiteBlack);
		fonta.setForeground(whiteBlack);
		fonte.setFocusable(false);
		fonta.setFocusable(false);
		
		ButtonGroup bg = new ButtonGroup();    
		bg.add(fonte);
		bg.add(fonta);
		
		frame.add(fonte);
		frame.add(fonta);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(105,25,60,30);
		frame.add(nomeLabel);
		
		JTextField nome = new JTextField("");
		nome.setBounds(160,30,200,25);
		nome.setBorder(BorderFactory.createEmptyBorder());
		frame.add(nome);
		
		JLabel localizacaoLabel = new JLabel("Localização:");
		localizacaoLabel.setBounds(70,65,80,30);
		frame.add(localizacaoLabel);
		
		JTextField localizacao = new JTextField("");
		localizacao.setBounds(160,70,200,25);
		localizacao.setBorder(BorderFactory.createEmptyBorder());
		frame.add(localizacao);
		
		JLabel anoContrucaoLabel = new JLabel("Ano de construção:");
		anoContrucaoLabel.setBounds(30,105,120,30);
		frame.add(anoContrucaoLabel);
		
		nomeLabel.setForeground(whiteBlack);
		localizacaoLabel.setForeground(whiteBlack);
		anoContrucaoLabel.setForeground(whiteBlack);
		
		JTextField anoConstrucao = new JTextField("");
		anoConstrucao.setBounds(160,110,200,25);
		anoConstrucao.setBorder(BorderFactory.createEmptyBorder());
		frame.add(anoConstrucao);
		
		JButton submete = new JButton("Sugerir");
		submete.setBounds(205,210,100,25);
		submete.setFocusable(false);
		
		JLabel nomeErro = new JLabel();
		nomeErro.setBounds(160,10,200,25);
		frame.add(nomeErro);
		
		JLabel locErro = new JLabel();
		locErro.setBounds(160,50,200,25);
		frame.add(locErro);
		
		JLabel anoErro = new JLabel();
		anoErro.setBounds(160,90,200,25);
		frame.add(anoErro);
		
		JLabel tipoErro = new JLabel();
		tipoErro.setBounds(190,140,200,30);
		frame.add(tipoErro);
		
		submete.addActionListener(e -> {
				if(nome.getText().length() == 0 || localizacao.getText().length() == 0 || anoConstrucao.getText().length() == 0 || fonte.isSelected() == false && fonta.isSelected() == false) {
					if(nome.getText().length() == 0) {
						nome.setBorder(BorderFactory.createEtchedBorder());
						nome.setBackground(new Color(255,204,204));
						nomeErro.setText("Insira o Nome");
						nomeErro.setForeground(Color.red);
					}
					else {
						nomeErro.setText("");
						nome.setBackground(Color.white);
					}
					if(localizacao.getText().length() == 0) {
						localizacao.setBorder(BorderFactory.createEtchedBorder());
						localizacao.setBackground(new Color(255,204,204));
						locErro.setText("Insira a localização");
						locErro.setForeground(Color.red);
					}
					else {
						locErro.setText("");
						localizacao.setBackground(Color.white);
					}
					if(anoConstrucao.getText().length() == 0) {
						anoConstrucao.setBorder(BorderFactory.createEtchedBorder());
						anoConstrucao.setBackground(new Color(255,204,204));
						anoErro.setText("Insira o ano");
						anoErro.setForeground(Color.red);
					}
					else {
						anoErro.setText("");
						anoConstrucao.setBackground(Color.white);
					}
					if(fonte.isSelected() == false && fonta.isSelected() == false) {
						fonte.setForeground(Color.red);
						fonta.setForeground(Color.red);
						tipoErro.setText("*Este campo é obrigatorio*");
						tipoErro.setForeground(Color.red);
					}
					else {
						tipoErro.setText("");
						fonte.setForeground(Color.black);
						fonta.setForeground(Color.black);
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
					String nomeStr = nome.getText();
					String loc = localizacao.getText();
					String ano = anoConstrucao.getText();
					String hist = "0";
					String rate = "0";
					try {
						gerir.writeToSugestoes(tipo,nomeStr,loc,ano, hist, rate);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					menuTurista();
					
					sucessoMsg("Obrigado pela sugestão");
				}
		});
		
		frame.add(submete);
		
		ImageIcon voltarImage = new ImageIcon(image);
		JButton voltar = new JButton(voltarImage);
		voltar.setBounds(4,4,16,16);
		voltar.setFocusable(false);
		voltar.setBackground(color);
		voltar.setBorder(BorderFactory.createEmptyBorder());
		voltar.addActionListener(e -> menuTurista());
		frame.add(voltar);
	}
	public void menuListaFontesFonta() {
		String[] listaFontesFonta = new String[gerir.fontesFontanarios.size()];
		for(int i = 0; i<gerir.fontesFontanarios.size();i++) {
			Fontes_Fontanarios infoFontes_Fontanarios = gerir.fontesFontanarios.get(i);
			listaFontesFonta[i] = infoFontes_Fontanarios.getNome();
		}
		JLabel nome = new JLabel();
		nome.setBounds(10,50,300,30);
		
		JLabel tipo = new JLabel();
		tipo.setBounds(10,90,300,30);
		
		JLabel loc = new JLabel();
		loc.setBounds(10,130,400,30);
		
		JLabel ano = new JLabel();
		ano.setBounds(10,170,300,30);
		
		JLabel hist = new JLabel();
		hist.setBounds(10,210,400,30);
		
		JLabel rate = new JLabel();
		rate.setBounds(10,250,300,30);
		
		ImageIcon iconEnviar = new ImageIcon("src/Imagens/enviar.png");
		JButton ir = new JButton();
		ir.setBounds(10,300,24,24);
		ir.setIcon(iconEnviar);
		ir.setBackground(color);
		ir.setFocusable(false);
		ir.setBorder(null);
		
		nome.setForeground(whiteBlack);
		tipo.setForeground(whiteBlack);
		loc.setForeground(whiteBlack);
		ano.setForeground(whiteBlack);
		hist.setForeground(whiteBlack);
		rate.setForeground(whiteBlack);
		
		JList lista = new JList(listaFontesFonta);
		lista.setFixedCellHeight(32);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50,50,320,300);
		scrollPane.setViewportView(lista);
		frame.add(scrollPane);
		
		JButton continuar = new JButton("Continuar");
		continuar.setBounds(160,365,100,30);
		continuar.setFocusable(false);
		frame.add(continuar);
		continuar.addActionListener(e -> {
			if(lista.isSelectionEmpty() == false) {
				scrollPane.setVisible(false);
				continuar.setVisible(false);
				frame.add(nome);
				frame.add(tipo);
				frame.add(loc);
				frame.add(ano);
				frame.add(hist);
				frame.add(rate);
				frame.add(ir);
				for(int i = 0; i<listaFontesFonta.length;i++) {
					  if(lista.getSelectedIndex() == i) {
						  Fontes_Fontanarios infoFontes_Fontanarios = gerir.fontesFontanarios.get(i);
						  if(infoFontes_Fontanarios.isTipo()) {
								tipo.setText("Fonte");
							}
							else tipo.setText("Fontanário");
						  nome.setText(infoFontes_Fontanarios.getNome());
						  loc.setText("Localização: " + infoFontes_Fontanarios.getLocalizacao());
						  ano.setText("Ano de construção: " + infoFontes_Fontanarios.getAnoConstrucao());
						  hist.setText("História: " + infoFontes_Fontanarios.getHistoria());
						  rate.setText("Rating: " + infoFontes_Fontanarios.getRating());
						  Mapa infoCoordenadas = gerir.coordenadas.get(i);
						  ir.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									try{Desktop.getDesktop().browse(new URL(infoCoordenadas.getCoordenada()).toURI());} catch(Exception t) {};
								}
							});
						  try {
							gerir.selecionarFonte_Fontanario(infoFontes_Fontanarios.getNome(), currentUser);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					  }
					} 
			}
		});
	}
	public void menuPesquisaFontesFonta() {
		JTextField name = new JTextField();
		name .setBounds(80,40,200,30);
		frame.add(name);
		
		JLabel nomeErro = new JLabel();
		nomeErro.setBounds(80,10,200,30);
		frame.add(nomeErro);
		
		JLabel nome = new JLabel();
		nome.setBounds(10,100,300,30);
		frame.add(nome);
		
		JLabel tipo = new JLabel();
		tipo.setBounds(10,140,150,30);
		frame.add(tipo);
		
		JLabel loc = new JLabel();
		loc.setBounds(10,180,400,30);
		frame.add(loc);
		
		JLabel anoConst = new JLabel();
		anoConst.setBounds(10,220,300,30);
		frame.add(anoConst);
		
		JLabel hist = new JLabel();
		hist.setBounds(10,260,500,30);
		frame.add(hist);
		
		JLabel rate = new JLabel();
		rate.setBounds(10,300,150,30);
		frame.add(rate);
		
		ImageIcon iconEnviar = new ImageIcon("src/Imagens/enviar.png");
		JButton ir = new JButton();
		ir.setBounds(10,340,24,24);
		ir.setIcon(iconEnviar);
		ir.setBackground(color);
		ir.setFocusable(false);
		ir.setBorder(null);
		frame.add(ir);
		ir.setVisible(false);
		
		ImageIcon erroIcon = new ImageIcon("src/Imagens/erro.png"); 
		JLabel erro = new JLabel();
		erro.setBounds(75,120,256,256);
		frame.add(erro);
		
		nome.setForeground(whiteBlack);
		tipo.setForeground(whiteBlack);
		loc.setForeground(whiteBlack);
		anoConst.setForeground(whiteBlack);
		hist.setForeground(whiteBlack);
		rate.setForeground(whiteBlack);

		JButton ok = new JButton("ok");
		ok.setBounds(290,40,50,30);
		ok.setFocusable(false);
		frame.add(ok);

		ok.addActionListener(e -> {
			if(name.getText().length() == 0) {
				nomeErro.setText("Insira o nome");
				nomeErro.setForeground(Color.red);
				name.setBackground(new Color(255,204,204));
				nome.setText("");
				tipo.setText("");
				loc.setText("");
				anoConst.setText("");
				hist.setText("");
				rate.setText("");
				erro.setVisible(false);
				ir.setVisible(false);
			}
			else {
				for(int i = 0; i<gerir.fontesFontanarios.size();i++) {
					Fontes_Fontanarios infoFontes_Fontanarios = gerir.fontesFontanarios.get(i);
					if(!(name.getText().equalsIgnoreCase(infoFontes_Fontanarios.getNome()))) {
						nomeErro.setText("Fonte/Fontanário não encontrado");
						nomeErro.setForeground(whiteBlack);
						name.setBackground(Color.white);
						nome.setText("");
						tipo.setText("");
						loc.setText("");
						anoConst.setText("");
						hist.setText("");
						rate.setText("");
						erro.setIcon(erroIcon);
						erro.setVisible(true);
						ir.setVisible(false);
					}
				}
				for(int i = 0; i<gerir.fontesFontanarios.size();i++) {
					Fontes_Fontanarios infoFontes_Fontanarios = gerir.fontesFontanarios.get(i);
					if((name.getText().equalsIgnoreCase(infoFontes_Fontanarios.getNome()))){
						nome.setText(infoFontes_Fontanarios.getNome());
						nomeErro.setText("");
						name.setBackground(Color.white);
						ir.setVisible(true);
						if(infoFontes_Fontanarios.isTipo()) {
							tipo.setText("Fonte");
						}
						else tipo.setText("Fontanário");
						
						loc.setText("Localização: " + infoFontes_Fontanarios.getLocalizacao());
						anoConst.setText("Ano de construção: " + infoFontes_Fontanarios.getAnoConstrucao());
						hist.setText("História: " + infoFontes_Fontanarios.getHistoria());
						rate.setText("Rating: " + infoFontes_Fontanarios.getRating());
						erro.setVisible(false);
						
						Mapa infoCoordenadas = gerir.coordenadas.get(i);
						ir.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(infoCoordenadas.getCoordenada().equals("Sem Coordenadas")) {
									sucessoMsg("Sem direções disponiveis");
								}
								else try{Desktop.getDesktop().browse(new URL(infoCoordenadas.getCoordenada()).toURI());} catch(Exception t) {};
							}
						});
					
						try {
							gerir.procurarFontes_Fontanarios(name.getText(), currentUser);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}
	public void menuHistorico() throws IOException {
		gerir.historicoUtilizador(currentUser);
		JList lista = new JList(gerir.historico);
		lista.setFixedCellHeight(32);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50,50,320,300);
		scrollPane.setViewportView(lista);
		frame.add(scrollPane);
	}
	
	public void contactos() {
		contacto.setBounds(220,382,80,30);
		contacto.setText("Contactos:");
		frame.add(contacto);
		
		ImageIcon iconInsta = new ImageIcon("src/Imagens/insta.png");
		insta.setIcon(iconInsta);
		insta.setBounds(290,385,24,24);
		insta.setBackground(new Color(227,241,172));
		insta.setBorder(BorderFactory.createEmptyBorder());
		insta.setFocusable(false);
		insta.addActionListener(e -> {try{Desktop.getDesktop().browse(new URL("https://www.instagram.com/hellonaturePT/").toURI());} catch(Exception t) {}});
		frame.add(insta);
		
		ImageIcon iconFace = new ImageIcon("src/Imagens/face.png");
		face.setIcon(iconFace);
		face.setBounds(320,385,24,24);
		face.setFocusable(false);
		face.setBackground(new Color(227,241,172));
		face.setBorder(BorderFactory.createEmptyBorder());
		face.addActionListener(e -> {try{Desktop.getDesktop().browse(new URL("https://www.facebook.com/Hello-Nature-101619722598759").toURI());} catch(Exception t) {}});
		frame.add(face);
		
		ImageIcon iconTwit = new ImageIcon("src/Imagens/twit.png");
		twit.setIcon(iconTwit);
		twit.setBounds(350,385,24,24);
		twit.setFocusable(false);
		twit.setBackground(new Color(227,241,172));
		twit.setBorder(BorderFactory.createEmptyBorder());	
		twit.addActionListener(e -> {try{Desktop.getDesktop().browse(new URL("https://twitter.com/HelloNaturePT").toURI());} catch(Exception t) {}});
		frame.add(twit);
		
		ImageIcon iconEmail = new ImageIcon("src/Imagens/mail.png");
		email.setIcon(iconEmail);
		email.setBounds(380,385,24,24);
		email.setFocusable(false);
		email.setBackground(new Color(227,241,172));
		email.setBorder(BorderFactory.createEmptyBorder());	
		email.addActionListener(e -> {try{Desktop.getDesktop().browse(new URL("mailto:hellonaturehelp@gmail.com?subject=Hello%20again").toURI());} catch(Exception t) {}});
		frame.add(email);
	}
	public void sucessoMsg(String sucesso) {
		JFrame sucessoFrame = new JFrame();
		sucessoFrame.setSize(300,100);
		sucessoFrame.setLayout(null);
		sucessoFrame.setLocationRelativeTo(null);
		ImageIcon logo = new ImageIcon("src/Imagens/Logo.png");
		sucessoFrame.setIconImage(logo.getImage());
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
	public void imagensSol() {
		image = ("src/Imagens/arrow.png");
		contactos();
		color = new Color(227,241,172);
		whiteBlack = Color.black;
		frame.getContentPane().setBackground(color);
		ImageIcon palmeiraIcon = new ImageIcon("src/Imagens/palmeira.png"); 
		JLabel palmeira = new JLabel();
		palmeira.setIcon(palmeiraIcon);
		palmeira.setBounds(-50,160,256,256);
		frame.add(palmeira);
		
		ImageIcon folhasIcon = new ImageIcon("src/Imagens/folhas.png"); 
		JLabel folhas = new JLabel();
		folhas.setIcon(folhasIcon);
		folhas.setBounds(-25,-30,128,128);
		frame.add(folhas);
		
		ImageIcon solIcon = new ImageIcon("src/Imagens/sol.png");
		JButton sol = new JButton();
		sol.setIcon(solIcon);
		sol.setBounds(347,5,64,64);
		sol.setFocusable(false);
		sol.setBackground(new Color(227,241,172));
		sol.setBorder(null);
		frame.add(sol);
		sol.setFocusable(false);
		sol.addActionListener(e ->{
			palmeira.setVisible(false);
			folhas.setVisible(false);
			sol.setVisible(false);
			imagensLua();
		});
	}
	public void imagensLua() {
		image = ("src/Imagens/warrow.png");
		color = new Color(40,40,40);
		contactos();
		contacto.setText("");
		insta.setBounds(390,80,24,24);
		insta.setBackground(new Color(40,40,40));
		face.setBounds(390,120,24,24);
		face.setBackground(new Color(40,40,40));
		twit.setBounds(390,160,24,24);
		twit.setBackground(new Color(40,40,40));
		email.setBounds(390,200,24,24);
		email.setBackground(new Color(40,40,40));
		whiteBlack = Color.white;
		frame.getContentPane().setBackground(color);
		ImageIcon cadenteIcon = new ImageIcon("src/Imagens/cadente.png"); 
		JLabel cadente = new JLabel();
		cadente.setIcon(cadenteIcon);
		cadente.setBounds(10,10,64,64);
		frame.add(cadente);
		
		ImageIcon forestIcon = new ImageIcon("src/Imagens/forest.png"); 
		JLabel forest = new JLabel();
		forest.setIcon(forestIcon);
		forest.setBounds(-20,185,256,256);
		frame.add(forest);
		
		JLabel forest2 = new JLabel();
		forest2.setIcon(forestIcon);
		forest2.setBounds(200,185,256,256);
		frame.add(forest2);
		
		ImageIcon luaIcon = new ImageIcon("src/Imagens/lua.png"); 
		JButton lua = new JButton();
		lua.setIcon(luaIcon);
		lua.setBounds(347,5,64,64);
		frame.add(lua);
		lua.setFocusable(false);
		lua.setBackground(new Color(40,40,40));
		lua.setBorder(null);
		lua.addActionListener(e ->{
			cadente.setVisible(false);
			forest.setVisible(false);
			forest2.setVisible(false);
			lua.setVisible(false);
			imagensSol();
			contactos();
		});
	}
	public static void main(String[] args) throws IOException {
		gerir.loadDataBase();
		gerir.loadToFontes();
		gerir.sugestoesUtilizador();
		gerir.loadCoordenadas();
		Interface menu = new Interface();
		menu.menu();
	}
}