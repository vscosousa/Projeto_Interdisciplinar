/**
 * 
 */
package fontes_e_fontanarios;
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
	
	public void criarConta(String nomeUtilizador,String password,String username,boolean tipoUtilizador,String email){
		Conta novaConta = new Conta(nomeUtilizador,password,username,tipoUtilizador,email);
		contas.add(novaConta);
	}	
	public void adicionarFonte_Fontanario(boolean tipo, String nome, String localizacao, String anoConstrucao, String historia, ArrayList<Comentario>comentarios){
		Fontes_Fontanarios novaFonte_Fontanario = new Fontes_Fontanarios(tipo,nome,localizacao,anoConstrucao,historia,comentarios);
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
	public void listarFontes_Fontanarios(boolean tipo, String nome, String localizacao, String anoConstrucao, String historia, ArrayList<Comentario>comentarios) {
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
				if(infoFontes_Fontanarios.getComentarios() != null){
					for(int x = 0; x < infoFontes_Fontanarios.getComentarios().size();x++) {
						System.out.println(infoFontes_Fontanarios.getComentarios().get(i).getNomeUtilizador() + ": " + infoFontes_Fontanarios.getComentarios().get(i).getRating() + " - " + infoFontes_Fontanarios.getComentarios().get(i).getTexto());
					}
				}
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
				if(infoFontes_Fontanarios.getComentarios() != null){
					for(int x = 0; x < infoFontes_Fontanarios.getComentarios().size();x++) {
						System.out.println(infoFontes_Fontanarios.getComentarios().get(i).getNomeUtilizador() + ": " + infoFontes_Fontanarios.getComentarios().get(i).getRating() + " - " + infoFontes_Fontanarios.getComentarios().get(i).getTexto());
					}
				}
			}	
		}
	}
}
