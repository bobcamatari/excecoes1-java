package aplicacap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reservas;

public class Programa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do quarto: ");
		int nQuarto = sc.nextInt();
		System.out.print("Data de checkIn (DD/MM/YYYY) : ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de checkOut (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Data de checkIn posterior a data de CheckOut");
		} else {
			Reservas reserva = new Reservas(nQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Entre com as datas atualizadas: ");
			System.out.print("Data CheckIn(DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data CheckOut (DD/MM?YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			String erro = reserva.atualizacaoDatas(checkIn, checkOut);
			if(erro != null) {
				System.out.println("Erro na reserva: "+erro);
			}else {
				System.out.println("Reserva: "+reserva);
			}
		}

		sc.close();

	}

}
