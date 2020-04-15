package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excecoes.DominanteExcecoes;

public class Reservas {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut) throws DominanteExcecoes {
		if (!checkOut.after(checkIn)) {
			throw new DominanteExcecoes("Data de CheckIn posterior a data de CheckOut");
		} 			
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
	
	public void atualizacaoDatas(Date checkIn, Date checkOut) throws DominanteExcecoes{
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DominanteExcecoes("Data de reserva antes da data atual!");		
		}
		if (!checkOut.after(checkIn)) {
			throw new DominanteExcecoes("Data de CheckIn posterior a data de CheckOut");
		} 		
			this.checkIn = checkIn;
			this.checkOut = checkOut;			
	}		
	@Override
	public String toString() {
		return "Numero do quarto "+ numeroQuarto +
				", CheckIn: "+ sdf.format(checkIn) +
				", CheckOut: "+ sdf.format(checkOut)+
				", Duração da estadia: "+ duracao()+ " noites";
				
	}
	
}
