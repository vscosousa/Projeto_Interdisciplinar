/**
 * 
 */
package fontes_e_fontanarios;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author grupo4
 *
 */
public class Gerir{
	private ArrayList<Fontes_Fontanarios>fontesFontanarios;
	private ArrayList<Conta>contas;
	
	
	/**
	 * @param fontesFontenarios
	 * @param contas
	 */
	public Gerir(ArrayList<Fontes_Fontanarios> fontesFontanarios, ArrayList<Conta> contas) {

		this.fontesFontanarios = fontesFontanarios;
		this.contas = contas;
	}
	
	public void loadDataBase() throws IOException {
		File baseDeDados = new File("src/fontes_e_fontanarios/BaseDeDados.txt");
		Scanner scr = new Scanner(baseDeDados);
		while(scr.hasNextLine()) {
			String[] conta = scr.nextLine().split(",");
			this.criarConta(conta[0], conta[1], conta[2], Boolean.parseBoolean(conta[3]), conta[4]);
		}
	}
	
	public void writeToDataBase(String nomeUtilizador,String password,String username,boolean tipoUtilizador,String email) throws IOException {
		String newAccount = nomeUtilizador + "," + password + "," + username + "," + tipoUtilizador + "," + email + "\n";
		FileWriter fW = new FileWriter("src/fontes_e_fontanarios/BaseDeDados.txt", true);
		fW.write(newAccount);
		fW.close();
		this.criarConta(nomeUtilizador, password, username, tipoUtilizador, email);
	}
	
	public void loadToFontes() throws IOException {
		File baseFontesFonta = new File("src/fontes_e_fontanarios/BaseFontesFonta.txt");
		Scanner scrFontesFonta = new Scanner(baseFontesFonta);
		while(scrFontesFonta.hasNextLine()) {
			String[] fonteFonta = scrFontesFonta.nextLine().split(",");
			this.adicionarFonte_Fontanario(Boolean.parseBoolean(fonteFonta[0]), fonteFonta[1], fonteFonta[2], fonteFonta[3], fonteFonta[4]);
		}
	}
	
	public void writeToFontes(boolean tipo, String nome, String localizacao, String anoConstrucao, String historia) throws IOException {
		String newFonteFonta = tipo + "," + nome + "," + localizacao + "," + anoConstrucao + "," + historia + "\n";
		FileWriter fW = new FileWriter("src/fontes_e_fontanarios/BaseFontesFonta.txt", true);
		fW.write(newFonteFonta);
		fW.close();
		this.adicionarFonte_Fontanario(tipo, nome, localizacao, anoConstrucao, historia);
	}
	
	public void criarConta(String nomeUtilizador,String password,String username,boolean tipoUtilizador,String email){
		Conta novaConta = new Conta(nomeUtilizador,password,username,tipoUtilizador,email);
		contas.add(novaConta);
	}	
	public void adicionarFonte_Fontanario(boolean tipo, String nome, String localizacao, String anoConstrucao, String historia){
		Fontes_Fontanarios novaFonte_Fontanario = new Fontes_Fontanarios(tipo,nome,localizacao,anoConstrucao,historia);
		fontesFontanarios.add(novaFonte_Fontanario);
	}
	public String procurarUtilizador(String username, String password) {
		for(int i = 0; i<contas.size();i++) {
			if(contas.get(i).getUsername().equals(username) && contas.get(i).getPassword().equals(password)){
				if(contas.get(i).isTipoUtilizador()) {
					return "Turista";
				}
				else {
					return "Administrador";
				}
			}
		}
		return "Inválido";
	}
	public void listarFontes_Fontanarios() {
		for(int i = 0; i<fontesFontanarios.size();i++) {
			System.out.println(i+1 + "." + fontesFontanarios.get(i).getNome());
		}
	}		
		
	public void procurarFontes_Fontanarios(String nome) {
		for(int i = 0; i<fontesFontanarios.size();i++) {
			Fontes_Fontanarios infoFontes_Fontanarios = fontesFontanarios.get(i);
			if( nome.equalsIgnoreCase(infoFontes_Fontanarios.getNome())) {
				System.out.println(infoFontes_Fontanarios.getNome() + ": ");
				if(infoFontes_Fontanarios.isTipo()) {
					System.out.println("Fonte");
				}
				else System.out.println("Fontanário");
				System.out.println("Localização: " + infoFontes_Fontanarios.getLocalizacao());
				System.out.println("Ano de construção: " + infoFontes_Fontanarios.getAnoConstrucao());
				System.out.println("História: " + infoFontes_Fontanarios.getHistoria());
			}
		}
	}
	
	public void selecionarFonte_Fontanario(int opcao) {
		for (int i = opcao; i<fontesFontanarios.size();i++) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("A que fonte pretende aceder?");
			opcao = scanner.nextInt();
			Fontes_Fontanarios infoFontes_Fontanarios = fontesFontanarios.get(i);
			if(i + 1 == opcao ) {
				System.out.println(infoFontes_Fontanarios.getNome() + ": ");
				if(infoFontes_Fontanarios.isTipo()) {
					System.out.println("Fonte");
				}
				else System.out.println("Fontanário");
				System.out.println("Localização: " + infoFontes_Fontanarios.getLocalizacao());
				System.out.println("Ano de construção: " + infoFontes_Fontanarios.getAnoConstrucao());
				System.out.println("História: " + infoFontes_Fontanarios.getHistoria());
			}	
		}
	}
}
