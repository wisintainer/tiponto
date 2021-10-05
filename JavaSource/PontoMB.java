import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("pontoMB")
@ViewScoped
public class PontoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Horario horario;
	private String horario_de_saida;

	@PostConstruct
	private void inicializar() {
		this.horario = new Horario();
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public String getHorario_de_saida() {
		return horario_de_saida;
	}

	public void setHorario_de_saida(String horario_de_saida) {
		this.horario_de_saida = horario_de_saida;
	}

	public void calcular() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		GregorianCalendar soma_intervalo = new GregorianCalendar(2021, 1, 1,0, 0, 0);
		GregorianCalendar hora_final = new GregorianCalendar(2021, 1, 1, 0, 0, 0);
		
		//Calculando Intervalo-----------------------------------------------------------------------------------
		soma_intervalo.add(Calendar.HOUR, Integer.parseInt(horario.getVolta_intervalo().substring(0, 2)));
		soma_intervalo.add(Calendar.MINUTE, Integer.parseInt(horario.getVolta_intervalo().substring(3, 5)));
		
		soma_intervalo.add(Calendar.HOUR, Integer.parseInt("-"+horario.getSaida_intervalo().substring(0, 2)));
		soma_intervalo.add(Calendar.MINUTE, Integer.parseInt("-"+horario.getSaida_intervalo().substring(3, 5)));
		//--------------------------------------------------------------------------------------------------------
		
		//Calculando horario--------------------------------------------------------------------------------------
		hora_final.add(Calendar.HOUR, Integer.parseInt(horario.getEntrada().substring(0, 2)));
		hora_final.add(Calendar.MINUTE, Integer.parseInt(horario.getEntrada().substring(3, 5)));
		hora_final.add(Calendar.HOUR, Integer.parseInt("9"));
		hora_final.add(Calendar.HOUR, soma_intervalo.getTime().getHours());
		hora_final.add(Calendar.MINUTE, soma_intervalo.getTime().getMinutes());
		//--------------------------------------------------------------------------------------------------------


		horario_de_saida = sdf.format(hora_final.getTime());

	}

}
