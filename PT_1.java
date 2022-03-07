
import java.util.*;

public class PT_1 {
    public static Map getstats(String sorting,Mage m1,Mage m2){
        Map stats=null;
        if (sorting=="ns"){
            stats=new HashMap<>();
        }else
        if (sorting=="s"){
            stats=new TreeMap<>();
        }
        stats.put(m1,m1.apprenticeNumber());
        stats.put(m2,m2.apprenticeNumber());
        return stats;
    }
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //String sorting=scanner.nextLine();

        //String sorting=args[0];

        String sorting="ns";


        Mage m1=new Mage("A1",10,3,sorting);
        Mage m2=new Mage("B2",15,4,sorting);
        Mage m3=new Mage("C3",14,5,sorting);
        Mage m4=new Mage("D4",13,6,sorting);
        Mage m5=new Mage("E5",12,7,sorting);
        Mage m6=new Mage("F6",11,8,sorting);
        Mage m7=new Mage("G7",10,9,sorting);
        Mage m8=new Mage("H8",9,10,sorting);
        Mage m9=new Mage("I9",8,11,sorting);
        Mage m10=new Mage("J10",7,12,sorting);
        m1.addApprentice(m2);
        m2.addApprentice(m3);
        m3.addApprentice(m4);
        m4.addApprentice(m5);
        m1.addApprentice(m6);
        m6.addApprentice(m7);
        m1.addApprentice(m8);
        m1.addApprentice(m9);
        m1.addApprentice(m10);

        m1.print(1);
        System.out.println(m9.apprenticeNumber());
        System.out.println(getstats(sorting,m1,m2));

    }
}