import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int dias;
        int meses;
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataAniversario;

        System.out.println("Informe a data que você faz aniversário (YYYY-MM-DD): ");
        dataAniversario = LocalDate.parse(sc.nextLine());

        if (dataAniversario.withYear(dataAtual.getYear()).isBefore(dataAtual)) {
            Period periodo = Period.between(dataAtual, dataAniversario.withYear(dataAtual.plusYears(1).getYear()));
            dias = periodo.getDays();
            meses = periodo.getMonths();
        } else {
            Period periodo = Period.between(dataAtual, dataAniversario.withYear(dataAtual.getYear()));
            dias = periodo.getDays();
            meses = periodo.getMonths();
        }

        System.out.printf("\nResta %d meses e %d dias para o seu aniversário!", meses, dias);
        sc.close();
    }
}
