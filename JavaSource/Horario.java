import java.sql.Time;

public class Horario {
	private String entrada;
	private String saida_intervalo;
	private String volta_intervalo;

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSaida_intervalo() {
		return saida_intervalo;
	}

	public void setSaida_intervalo(String saida_intervalo) {
		this.saida_intervalo = saida_intervalo;
	}

	public String getVolta_intervalo() {
		return volta_intervalo;
	}

	public void setVolta_intervalo(String volta_intervalo) {
		this.volta_intervalo = volta_intervalo;
	}

}
