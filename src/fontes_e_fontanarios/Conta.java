/**
 * 
 */
package fontes_e_fontanarios;

/**
 * @author grupo4
 *
 */
public class Conta {
	private String nomeUtilizador;
	private String password;
	private String username;
	private boolean tipoUtilizador;
	private String email;
	/**
	 * @param nomeUtilizador
	 * @param password
	 * @param username
	 * @param tipoUtilizador
	 * @param email
	 */
	public Conta(String nomeUtilizador, String password, String username, boolean tipoUtilizador, String email) {
		super();
		this.nomeUtilizador = nomeUtilizador;
		this.password = password;
		this.username = username;
		this.tipoUtilizador = tipoUtilizador;
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the tipoUtilizador
	 */
	public boolean isTipoUtilizador() {
		return tipoUtilizador;
	}
}
