package br.jus.jfce.projetos.util;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;

/**
 * Demonstração de como pegar o número da semana no mês
 * 
 * */
public class SemanaNoMes {
	/**
	 * Recebe um LocalDate e retorna a semana no ano.
	 * Neste caso, o primeiro dia da primeira semana de 2019 é 01/01/2019
	 * 
	 * O padrão é iniciar a semana no Domingo e finalizar no sábado.
	 */
	public static int pegarSemanaDoMes(LocalDate date) {
		TemporalField wom = WeekFields.of(DatePrinter.LOCALE).weekOfMonth();
		return date.get(wom);
	}

	public static void main(String[] args) {

		/**
		 * Imprime uma tabela com todos os dias de JANEIRO 
		 * e sua respectiva semana no ano 
		 */
		LocalDate janeiro = LocalDate.of(2019, 1, 1);
		DatePrinter.printHeader(janeiro);
		for (int i = 0; i < 31; i++) {
			LocalDate date = janeiro.plusDays(i);
			DatePrinter.print(date, pegarSemanaDoMes(date));
		}

		/**
		 * Imprime uma tabela com todos os dias de FEVEREIRO 
		 * e sua respectiva semana no ano 
		 */
		LocalDate fevereiro = LocalDate.of(2019, 2, 1);
		DatePrinter.printHeader(fevereiro);
		for (int i = 0; i < 28; i++) {
			LocalDate date = fevereiro.plusDays(i);
			DatePrinter.print(date, pegarSemanaDoMes(date));
		}
	}
}
