package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut) {
		super();
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}	

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String atualizacaoDatas(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Data de reserva antes da data atual!";		
		}
		if (!checkOut.after(checkIn)) {
			return "Data de CheckIn posterior a data de CheckOut";
		} 		
			this.checkIn = checkIn;
			this.checkOut = checkOut;
			return null;
	}	
	
	@Override
	public String toString() {
		return "Numero do quarto "+ numeroQuarto +
				", CheckIn: "+ sdf.format(checkIn) +
				", CheckOut: "+ sdf.format(checkOut)+
				", Duração da estadia: "+ duracao()+ " noites";
				
	}
	
}
