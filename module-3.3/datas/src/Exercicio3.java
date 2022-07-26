import java.time.LocalDateTime;
public class Exercicio3 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.plusDays(5).plusHours(5));
    }
}
