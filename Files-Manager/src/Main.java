import br.com.dio.persistence.FilePersistence;
import br.com.dio.persistence.IOFilePersistence;
import br.com.dio.persistence.NIO2FilePersistence;
import br.com.dio.persistence.NIOFilePersistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*FilePersistence persistence = new IOFilePersistence("user.csv");
        System.out.println("===========================================");
        System.out.println(persistence.write("Lucas;lucas@bol.com;15/01/1990"));
        System.out.println("===========================================");
        System.out.println(persistence.write("Caio;caio@bol.com;22/03/1994"));
        System.out.println("===========================================");
        System.out.println(persistence.write("Amanda;amanda@bol.com;14/07/1995"));
        System.out.println("===========================================");
        System.out.print(persistence.findAll());
        System.out.println("===========================================");
        System.out.println(persistence.remove("Caio"));
        System.out.println("===========================================");
        System.out.println(persistence.remove("24"));
        System.out.println("===========================================");
        System.out.println(persistence.findBy("Lucas"));
        System.out.println("===========================================");
        System.out.println(persistence.findBy("1994"));
        System.out.println("===========================================");
        System.out.println(persistence.findBy("amanda@"));
        System.out.println("===========================================");
        System.out.println(persistence.replace("Amanda", "Amandinha"));
        System.out.println("===========================================");
        System.out.println(persistence.replace("max", "21"));
        System.out.println("===========================================");
        System.out.println(persistence.findAll());
        */

        /*FilePersistence persistence = new NIOFilePersistence("user.csv");
        System.out.println("===========================================");
        System.out.println(persistence.write("Bernardo;bernardo@bol.com;15/01/1990"));
        System.out.println("===========================================");
        System.out.println(persistence.write("Tiago;tiago@bol.com;22/03/1994"));
        System.out.println("===========================================");
        System.out.println(persistence.write("Luiza;luiza@bol.com;14/07/1995"));
        System.out.println("===========================================");
        System.out.print(persistence.findAll());
        System.out.println("===========================================");
        System.out.println(persistence.remove("bernardo@"));
        System.out.println("===========================================");
        System.out.println(persistence.remove("eduarda@"));
        System.out.println("===========================================");
        System.out.println(persistence.findBy("luiza@"));
        System.out.println("===========================================");
        System.out.println(persistence.findBy("bernardo@"));
        System.out.println("===========================================");
        System.out.println(persistence.replace("Tiago", "Thiago;thiaguinho@bol.com;30/12/1992"));
        System.out.println("===========================================");
        System.out.println(persistence.replace("Joaquim", "Kayo;kayo@bol.com;31/10/1997"));
        System.out.println("===========================================");
         */

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