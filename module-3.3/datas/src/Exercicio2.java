import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int dias;
        int meses;
        int anos;

        System.out.println("Informe a primeira data (YYYY-MM-DD): ");
        LocalDate data1 = LocalDate.parse(sc.nextLine());
        System.out.println("Informe a segunda data (YYYY-MM-DD): ");
        LocalDate data2 = LocalDate.parse(sc.nextLine());

        if (data1.isBefore(data2)) {
            Period periodo = Period.between(data1, data2);
            dias = periodo.getDays();
            meses = periodo.getMonths();
            anos = periodo.getYears();
        } else {
            Period periodo = Period.between(data2, data1);
            dias = periodo.getDays();
            meses = periodo.getMonths();
            anos = periodo.getYears();
        }

        System.out.printf("\nA diferença de dias/meses/anos entre as datas são de: %d dias, %d meses e %d anos.", dias, meses, anos);
        sc.close();
    }
}
