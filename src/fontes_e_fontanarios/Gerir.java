/**
 * 
 */
package fontes_e_fontanarios;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author grupo4
 *
 */
public class Gerir{
	ArrayList<Fontes_Fontanarios>fontesFontanarios;
	ArrayList<Conta>contas;
	ArrayList<Fontes_Fontanarios>sugestoes;
	ArrayList<Mapa>coordenadas;
	String[] historico;
	private String currentUser;
	
	/**
	 * @param fontesFontenarios
	 * @param contas
	 */
	public Gerir(ArrayList<Fontes_Fontanarios> fontesFontanarios, ArrayList<Conta> contas, ArrayList<Fontes_Fontanarios> sugestoes, ArrayList<Mapa> coordenadas) {

		this.fontesFontanarios = fontesFontanarios;
		this.contas = contas;
		this.sugestoes = sugestoes;
		this.coordenadas = coordenadas;
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
			String[] fonteFonta = scrFontesFonta.nextLine().split("~");
			this.adicionarFonte_Fontanario(Boolean.parseBoolean(fonteFonta[0]), fonteFonta[1], fonteFonta[2], fonteFonta[3], fonteFonta[4], fonteFonta[5]);
		}
	}
	
	public void writeToFontes(boolean tipo, String nome, String localizacao, String anoConstrucao, String historia, String rating) throws IOException {
		String newFonteFonta = tipo + "~" + nome + "~" + localizacao + "~" + anoConstrucao + "~" + historia + "~" + rating + "\n";
		FileWriter fW = new FileWriter("src/fontes_e_fontanarios/BaseFontesFonta.txt", true);
		fW.write(newFonteFonta);
		fW.close();
		this.adicionarFonte_Fontanario(tipo, nome, localizacao, anoConstrucao, historia, rating);
	}
	
	public void writeToSugestoes(boolean tipo, String nome, String localizacao, String anoConstrucao, String historia, String rating) throws IOException {
		String novaSugestao = tipo + "~" + nome + "~" + localizacao + "~" + anoConstrucao + "~" + historia + "~" + rating + "\n";
		FileWriter fW = new FileWriter("src/fontes_e_fontanarios/Sugestoes.txt", true);
		fW.write(novaSugestao);
		fW.close();
		this.adicionarSugestao(tipo, nome, localizacao, anoConstrucao, historia, rating);
	}
	
	public void sugestoesUtilizador() throws IOException {
		File baseSugestoes = new File("src/fontes_e_fontanarios/Sugestoes.txt");
		Scanner scrSugestoes = new Scanner(baseSugestoes);
		while(scrSugestoes.hasNextLine()) {
			String[] listaSugestoes = scrSugestoes.nextLine().split("~");
			this.adicionarSugestao(Boolean.parseBoolean(listaSugestoes[0]), listaSugestoes[1], listaSugestoes[2], listaSugestoes[3], listaSugestoes[4], listaSugestoes[5]);
		}
	}
	
	public void writeCoordenadas(String coordenada) throws IOException {
        String novaSugestao = coordenada + "\n";
        FileWriter fW = new FileWriter("src/fontes_e_fontanarios/Coordenadas.txt", true);
        fW.write(novaSugestao);
        fW.close();
        this.novaCoordenada(coordenada);
    }
    
    public void loadCoordenadas() throws IOException {
    	File baseCoordenadas = new File("src/fontes_e_fontanarios/Coordenadas.txt");
		Scanner scrCoordenadas = new Scanner(baseCoordenadas);
		while(scrCoordenadas.hasNextLine()) {
			String[] listaSugestoes = scrCoordenadas.nextLine().split("~");
			this.novaCoordenada(listaSugestoes[0]);
		}
    }
    
    public void novaCoordenada(String coordenada) {
    	Mapa novaCoordenada = new Mapa(coordenada);
		coordenadas.add(novaCoordenada);
    }
	
	public void criarConta(String nomeUtilizador,String password,String username,boolean tipoUtilizador,String email) throws IOException{
		Conta novaConta = new Conta(nomeUtilizador,password,username,tipoUtilizador,email);
		contas.add(novaConta);
		File ficheiro = new File("src/fontes_e_fontanarios/Historico/" + username);
		if(!(ficheiro.exists())) {
			ficheiro.createNewFile();
		}
	}
	
	public void adicionarSugestao(boolean tipo, String nome, String localizacao, String anoConstrucao, String historia, String rating){
		Fontes_Fontanarios novaSugestao = new Fontes_Fontanarios(tipo, nome, localizacao, anoConstrucao, historia, rating);
		sugestoes.add(novaSugestao);
	}
	
	public void adicionarFonte_Fontanario(boolean tipo, String nome, String localizacao, String anoConstrucao, String historia, String rating){
		Fontes_Fontanarios novaFonte_Fontanario = new Fontes_Fontanarios(tipo,nome,localizacao,anoConstrucao,historia, rating);
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
		
	public void procurarFontes_Fontanarios(String nome, String username) throws IOException {
		for(int i = 0; i<fontesFontanarios.size();i++) {
			Fontes_Fontanarios infoFontes_Fontanarios = fontesFontanarios.get(i);
			if( nome.equalsIgnoreCase(infoFontes_Fontanarios.getNome())) {
				Path path = Paths.get("src/fontes_e_fontanarios/Historico/" + username);
				List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
				lines.add(0, infoFontes_Fontanarios.getNome());
				Files.write(path, lines, StandardCharsets.UTF_8);
				return;
			}
		}
	}
	
	public void selecionarFonte_Fontanario(String nome, String username) throws IOException {
		Path path = Paths.get("src/fontes_e_fontanarios/Historico/" + username);
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		lines.add(0, nome);
		Files.write(path, lines, StandardCharsets.UTF_8);
	}
	public void editarFonte_Fontanario(String novoNome, boolean novoTipoUtil, String novaLocalizacao, String novoAnoConstrucao, String novaHistoria, String novoRating, int x, String coordenada) throws IOException {
           Fontes_Fontanarios infoFontes_Fontanarios = fontesFontanarios.get(x);
           Mapa infoCoordenadas = coordenadas.get(x);
           infoFontes_Fontanarios.setTipo(novoTipoUtil);
           infoFontes_Fontanarios.setNome(novoNome);
           infoFontes_Fontanarios.setLocalizacao(novaLocalizacao);
           infoFontes_Fontanarios.setAnoConstrucao(novoAnoConstrucao);
           infoFontes_Fontanarios.setHistoria(novaHistoria);
           infoFontes_Fontanarios.setRating(novoRating);
           infoCoordenadas.setCoordenada(coordenada);
           Path path = Paths.get("src/fontes_e_fontanarios/BaseFontesFonta.txt");
           List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
           lines.set(x, novoTipoUtil + "~" + novoNome + "~" + novaLocalizacao + "~" + novoAnoConstrucao + "~" + novaHistoria + "~" + novoRating);
           Files.write(path, lines, StandardCharsets.UTF_8);
           
           Path caminho = Paths.get("src/fontes_e_fontanarios/Coordenadas.txt");
           List<String> linha = Files.readAllLines(caminho, StandardCharsets.UTF_8);
           linha.set(x, coordenada);
           Files.write(caminho, linha, StandardCharsets.UTF_8);
	}
	public void historicoUtilizador(String username) throws IOException {
		Path path = Paths.get("src/fontes_e_fontanarios/Historico/" + username);
		Scanner scr = new Scanner(path);
		historico = new String[(int) Files.lines(path).count()];
		while(scr.hasNextLine()) {
			for(int i = 0; i < Files.lines(path).count(); i++) {
				historico[i] = scr.nextLine();
			}
		}
	}
}
