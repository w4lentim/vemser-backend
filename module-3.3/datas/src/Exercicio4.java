import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Exercicio4 {

    public static void main(String[] args) {

        ZoneId idZonaLondres = ZoneId.of("Europe/London");

        LocalDate dataLondres = LocalDate.now(idZonaLondres);
        LocalDate mostrarDataLondres = LocalDate.of(2024, 9, 14);

        LocalTime horaLocalLondres = LocalTime.now(idZonaLondres);
        LocalTime mostrarHora = LocalTime.of(18, 30);

        Period periodo = Period.between(dataLondres, mostrarDataLondres);
        int dias = periodo.getDays();
        int meses = periodo.getMonths();
        int anos = periodo.getYears();

        long horas = ChronoUnit.HOURS.between(horaLocalLondres, mostrarHora);
        long minutos = ChronoUnit.MINUTES.between(horaLocalLondres, mostrarHora) - (horas * 60);
        long segundos = ChronoUnit.SECONDS.between(horaLocalLondres, mostrarHora) - ((horas * 60 * 60) + (minutos * 60));

        System.out.println("Tempo restante para o espetáculo de Wesley Safadão e Black Sabbath");
        System.out.println(anos + " ANOS, " +
                meses + " MESES, " +
                dias + " DIAS, " +
                horas + " HORAS, " +
                minutos + " MINUTOS, " +
                segundos + " SEGUNDOS.");
    }
}
