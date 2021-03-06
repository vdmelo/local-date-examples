package br.jus.jfce.projetos.util;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;

/**
 * Demonstração de como pegar o número da semana em no ano
 * 
 * */
public class SemanaNoAno {

	/**
	 * Recebe um LocalDate e retorna a semana no ano.
	 * Neste caso, o primeiro dia da primeira semana de 2019 é 01/01/2019
	 * 
	 * Nesta versão do método, você pode decidir o dia que inicia a semana.
	 */
	public static int pegarSemanaDoAno(LocalDate date, DayOfWeek dow) {
		TemporalField woy = WeekFields.of(dow, 1).weekOfYear();
		return date.get(woy);

	}

	/**
	 * Recebe um LocalDate e retorna a semana no ano.
	 * Neste caso, o primeiro dia da primeira semana de 2019 é 01/01/2019
	 * 
	 * O padrão é iniciar a semana no Domingo e finalizar no sábado.
	 */
	public static int pegarSemanaDoAno(LocalDate date) {
		TemporalField woy = WeekFields.of(DatePrinter.LOCALE).weekOfYear();
		return date.get(woy);

	}

	public static void main(String[] args) {

		/**
		 * Imprime uma tabela com todos os dias de JANEIRO e sua respectiva semana no ano  
		 */
		LocalDate janeiro = LocalDate.of(2019, 1, 1);
		DatePrinter.printHeader(janeiro);
		for (int i = 0; i < 31; i++) {
			LocalDate date = janeiro.plusDays(i);
			DatePrinter.print(date, pegarSemanaDoAno(date));
		}

		
		/**
		 * Imprime uma tabela com todos os dias de JANEIRO e sua respectiva semana no ano
		 * Mas dessa vez, vamos colocar que a semana se inicia na segunda-feira e não no Domingo (padrão do Locale pt_BR)
		 */
		LocalDate janeiro2 = LocalDate.of(2019, 1, 1);
		DatePrinter.printHeader(janeiro2);
		for (int i = 0; i < 31; i++) {
			LocalDate date = janeiro2.plusDays(i);
			DatePrinter.print(date, pegarSemanaDoAno(date, DayOfWeek.MONDAY));
		}

		
		/**
		 * Imprime uma tabela com todos os dias de FEVEREIRO 
		 * e sua respectiva semana no ano 
		 * /
		LocalDate fevereiro = LocalDate.of(2019, 2, 1);
		DatePrinter.printHeader(fevereiro);
		for (int i = 0; i < 28; i++) {
			LocalDate date = fevereiro.plusDays(i);
			DatePrinter.print(date, pegarSemanaDoAno(date));
		}*/
	}
}
