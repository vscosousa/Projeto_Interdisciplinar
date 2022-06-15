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
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Gerir gerir = new Gerir(new ArrayList<>(), new ArrayList<>());
		while(true) {
			System.out.println("1.Criar Conta");
			System.out.println("2.Login");
			System.out.println("3.Sair da Aplicação");
			int opcao = scanner.nextInt();
			scanner.nextLine();
			switch(opcao){
			case 1:
				System.out.print("Escreva o seu nome: ");
				String nomeUtilizador = scanner.nextLine();
				System.out.print("Insira a password: ");
				String password = scanner.nextLine();
				System.out.print("Insira o seu username: ");
				String username = scanner.nextLine();
				System.out.print("É administrador ou turista?");
				String tipoUtilizador = scanner.nextLine();
				if(!(tipoUtilizador.equalsIgnoreCase("ADMINISTRADOR") || tipoUtilizador.equalsIgnoreCase("TURISTA"))){
					System.out.println("Tipo de utilizador não aceite");
					break;
				}
				System.out.print("Insira o seu e-mail: ");
				String email = scanner.nextLine();
				gerir.criarConta(nomeUtilizador,password,username, tipoUtilizador.equalsIgnoreCase("ADMINISTRADOR"),email);
				break;
			case 2:
				System.out.print("Username: ");
				String usernameLogin = scanner.nextLine();
				System.out.print("Password: ");
				String passwordLogin = scanner.nextLine();
				if(gerir.procurarUtilizador(usernameLogin, passwordLogin).equals("Turista")) {
					menuTurista(gerir);
				}
				else if(gerir.procurarUtilizador(usernameLogin, passwordLogin).equals("Administrador")) {
					menuAdministrador(gerir);
				}
				else System.out.println("Utilizador inválido");
				break;
			case 3:
				System.exit(0);;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
	}
	
	public static void menuTurista(Gerir gerir) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1.Lista de fontes e fontanários");
			System.out.println("2.Pesquisar fontes e fontanários");
			System.out.println("3.Ver histórico de fontes e fontanários");
			System.out.println("4.Terminar Sessão");
			int opcao = scanner.nextInt();
			scanner.nextLine();
			switch(opcao){
			case 1:
				menuListaFontes_Fontanarios(gerir);
				break;
			case 2:
				System.out.print("Insira o nome da fonte/fontanário: ");
				String nome = scanner.nextLine();
				gerir.procurarFontes_Fontanarios(nome);
				break;
			case 3:
				break;
			case 4:
				main(null);
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
	}
	public static void menuAdministrador(Gerir gerir) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1.Adicionar Fontes e Fontanários");
			System.out.println("2.Verificar comentários");
			System.out.println("3.Terminar Sessão");
			System.out.println("4.Preview Turista");
			int opcao = scanner.nextInt();
			scanner.nextLine();
			switch(opcao){
			case 1:
				System.out.println("Fonte ou fontanário? ");
				String tipo = scanner.nextLine();
				if(!(tipo.equalsIgnoreCase("FONTE") || tipo.equalsIgnoreCase("FONTANARIO"))){
					System.out.println("Tipo de monumento não aceite");
					break;
				}
				System.out.println("Qual o nome? ");
				String nome = scanner.nextLine();
				System.out.println("Qual a localização? ");
				String localizacao = scanner.nextLine();
				System.out.println("Em que ano foi construído? ");
				int anoConstrucao = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Conta-nos um pouco mais sobre este/a " + tipo);
				String historia = scanner.nextLine();
				ArrayList<Comentario>comentarios = null;
				gerir.adicionarFonte_Fontanario(tipo.equalsIgnoreCase("FONTE"),nome,localizacao,anoConstrucao,historia,comentarios);
				break;
			case 2:
				break;
			case 3:
				main(null);
				break;
			case 4:
				menuPreviewTurista(gerir);
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
	}
	
	public static void menuPreviewTurista(Gerir gerir) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1.Lista de fontes e fontanários");
			System.out.println("2.Pesquisar fontes e fontanários");
			System.out.println("3.Ver histórico de fontes e fontanários");
			System.out.println("4.Terminar Sessão");
			System.out.println("5.Voltar para o modo administrador");
			int opcao = scanner.nextInt();
			scanner.nextLine();
			switch(opcao){
			case 1:
				menuListaFontes_Fontanarios(gerir);
				break;
			case 2:
				System.out.print("Insira o nome da fonte/fontanário:");
				String nome = scanner.nextLine();
				gerir.procurarFontes_Fontanarios(nome);
				break;
			case 3:
				break;
			case 4:
				main(null);
				break;
			case 5:
				menuAdministrador(gerir);
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
	}
	public static void menuListaFontes_Fontanarios(Gerir gerir) {
		boolean tipo = false;
		String nome = "";
		String localizacao = "";
		int anoConstrucao = 0;
		String historia = "";
		ArrayList<Comentario>comentarios = null;
		gerir.listarFontes_Fontanarios(tipo,nome,localizacao,anoConstrucao,historia,comentarios);
		int opcao = 0;
		gerir.selecionarFonte_Fontanario(opcao);
	}
}//fim da classe
