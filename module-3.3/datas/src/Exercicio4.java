import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ZoneId idZonaLondon = ZoneId.of("Europe/London");

        LocalDate dataLocal = LocalDate.now(idZonaLondon);
        LocalDate mostrarData = LocalDate.of(2024, 9, 14);

        LocalTime horaLocal = LocalTime.now(idZonaLondon);
        LocalTime mostrarHora = LocalTime.of(18, 30);

        Period periodo = Period.between(dataLocal, mostrarData);
        int dias = periodo.getDays();
        int meses = periodo.getMonths();
        int anos = periodo.getYears();

        long horas = ChronoUnit.HOURS.between(horaLocal, mostrarHora);
        long minutos = ChronoUnit.MINUTES.between(horaLocal, mostrarHora) - (horas * 60);
        long segundos = ChronoUnit.SECONDS.between(horaLocal, mostrarHora) - ((horas * 60 * 60) + (minutos * 60));

        System.out.println("Tempo restante para o espetáculo de Wesley Safadão e Black Sabbath");
        System.out.println(anos + " ANOS, " +
                meses + " MESES, " +
                dias + " DIAS, " +
                horas + " HORAS, " +
                minutos + " MINUTOS, " +
                segundos + " SEGUNDOS.");
    }
}
