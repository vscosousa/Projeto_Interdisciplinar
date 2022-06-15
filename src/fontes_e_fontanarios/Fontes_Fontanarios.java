/**
 * 
 */
package fontes_e_fontanarios;
import java.util.ArrayList;
/**
 * @author grupo4
 *
 */
public class Fontes_Fontanarios {
	private boolean tipo;
	private String nome;
	private String localizacao;
	private int anoConstrucao;
	private String historia;
	private ArrayList<Comentario> comentarios;
	/**
	 * @param tipo
	 * @param nome
	 * @param localizacao
	 * @param anoConstrucao
	 * @param historia
	 * @param comentarios
	 */
	public Fontes_Fontanarios(boolean tipo, String nome, String localizacao, int anoConstrucao, String historia, ArrayList<Comentario> comentarios) {
		this.tipo = tipo;
		this.nome = nome;
		this.localizacao = localizacao;
		this.anoConstrucao = anoConstrucao;
		this.historia = historia;
		this.comentarios = comentarios;
	}
	/**
	 * @return the tipo
	 */
	public boolean isTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the localizacao
	 */
	public String getLocalizacao() {
		return localizacao;
	}
	/**
	 * @param localizacao the localizacao to set
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	/**
	 * @return the anoConstrucao
	 */
	public int getAnoConstrucao() {
		return anoConstrucao;
	}
	/**
	 * @param anoConstrucao the anoConstrucao to set
	 */
	public void setAnoConstrucao(int anoConstrucao) {
		this.anoConstrucao = anoConstrucao;
	}
	/**
	 * @return the historia
	 */
	public String getHistoria() {
		return historia;
	}
	/**
	 * @param historia the historia to set
	 */
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	/**
	 * @return the comentarios
	 */
	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}
	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
}
