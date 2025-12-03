import br.com.dio.persistence.FilePersistence;
import br.com.dio.persistence.IOFilePersistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new IOFilePersistence("user.csv");
        System.out.println("===========================================");
        System.out.println(persistence.write("Lucas;lucas@bol.com;15/01/1990"));
        System.out.println("===========================================");
        System.out.println(persistence.write("Caio;caio@bol.com;22/03/1994"));
        System.out.println("===========================================");
        System.out.println(persistence.write("Amanda;amanda@bol.com;14/07/1995"));
        System.out.println("===========================================");
        System.out.println(persistence.findAll());
        System.out.println("===========================================");

    }
}