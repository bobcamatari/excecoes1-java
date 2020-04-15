package model.entidades;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
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
	
	public void atualizacaoDatas(Date checkIn, Date checkOut) {
		
	}
	
}
