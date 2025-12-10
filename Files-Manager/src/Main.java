import br.com.dio.persistence.FilePersistence;
import br.com.dio.persistence.IOFilePersistence;
import br.com.dio.persistence.NIO2FilePersistence;
import br.com.dio.persistence.NIOFilePersistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new NIO2FilePersistence("user.csv");
        System.out.println("===========================================");
        System.out.println(persistence.write("Carlos;carlos@bol.com;15/01/1990"));
        System.out.println("===========================================");
        System.out.println(persistence.write("Neo;neo@bol.com;22/03/1994"));
        System.out.println("===========================================");
        System.out.println(persistence.write("Trinity;trinity@bol.com;14/07/1995"));
        System.out.println("===========================================");
        System.out.print(persistence.findAll());
        System.out.println("===========================================");
        System.out.println(persistence.remove("carlos@"));
        System.out.println("===========================================");
        System.out.println(persistence.remove("erika@"));
        System.out.println("===========================================");
        System.out.println(persistence.findBy("trinity@"));
        System.out.println("===========================================");
        System.out.println(persistence.findBy("15/01"));
        System.out.println("===========================================");
        System.out.println(persistence.replace("Neo", "Arthur;arthur@bol.com;30/12/1992"));
        System.out.println("===========================================");
        System.out.println(persistence.replace("Patrick", "Kayo;kayo@bol.com;31/10/1997"));
        System.out.println("===========================================");
    }
}