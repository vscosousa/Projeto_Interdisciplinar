/**
 * 
 */
package fontes_e_fontanarios;

/**
 * @author grupo4
 *
 */
public class Comentario {
	private int rating;
	private String texto;
	private String nomeUtilizador;
	/**
	 * @param rating
	 * @param texto
	 * @param nomeUtilizador
	 */
	public Comentario(int rating, String texto, String nomeUtilizador) {
		super();
		this.rating = rating;
		this.texto = texto;
		this.nomeUtilizador = nomeUtilizador;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}
	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	/**
	 * @return the nomeUtilizador
	 */
	public String getNomeUtilizador() {
		return nomeUtilizador;
	}
	/**
	 * @param nomeUtilizador the nomeUtilizador to set
	 */
	public void setNomeUtilizador(String nomeUtilizador) {
		this.nomeUtilizador = nomeUtilizador;
	}
}
