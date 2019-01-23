package br.jus.jfce.projetos.util;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DatePrinter {

	public static Locale LOCALE = new Locale ("pt", "BR");

	/**
	 * Imprime uma linha do separador da tabela 
	 */
	public static void printSeparator() {
		System.out.println("+--------------------+------------+");
	}

	/**
	 * Imprime o HEADER da tabela 
	 */
	public static void printHeader(LocalDate date) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMMM", LOCALE);

		printSeparator();
		String header = "| %-9s %-11s %-9s | \n";
		System.out.format(header, "", date.format(fmt).toUpperCase(), "");
		printSeparator();
		String headerColumns = "| %-18s | %-10s | \n";
		System.out.format(headerColumns, "DIA", "SEMANA");
		printSeparator();
	}
	
	
	/**
	 * Imprime uma linha da tabela contendo o dia da semana e o número da semana 
	 */
	public static void print(LocalDate date, int semana) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy - EE", LOCALE);
		String dataStr = date.format(fmt);
		String semanaNoAno = semana + "ª";
		String texto = "| %-18s | %-10s | \n";
		System.out.format(texto, dataStr, semanaNoAno);
		printSeparator();
	}
}
