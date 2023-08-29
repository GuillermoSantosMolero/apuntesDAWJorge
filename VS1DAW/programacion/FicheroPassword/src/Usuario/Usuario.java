package Usuario;
import java.io.Serializable;
/**
 * @author Guillermo Santos Molero
 *
 */
public class Usuario implements Serializable {
	private String mail;
	private String contra;
	private boolean activo;
	
	public Usuario(String mail,String contra) {
		this.mail=mail;
		this.contra=contra;
		this.activo=true;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
