package aplicacap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reservas;
import model.excecoes.DominanteExcecoes;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do quarto: ");
			int nQuarto = sc.nextInt();
			System.out.print("Data de checkIn (DD/MM/YYYY) : ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de checkOut (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservas reserva = new Reservas(nQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
	
			System.out.println();
			System.out.println("Entre com as datas atualizadas: ");
			System.out.print("Data CheckIn(DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data CheckOut (DD/MM?YYYY): ");
			checkOut = sdf.parse(sc.next());
			reserva.atualizacaoDatas(checkIn, checkOut);
			
		} catch(ParseException e){
			System.out.println("Formato de data invalido");
			
		}catch (DominanteExcecoes e) {
			System.out.println("Erro na reserva: "+ e.getMessage());			
		}catch (RuntimeException e) {
			System.out.println("Erro ineperado");
		}
		sc.close();
	}

}
