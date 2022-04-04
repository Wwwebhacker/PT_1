import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class PT_4 {
    public static void printAll(EntityManagerFactory factory){
        EntityManager em=factory.createEntityManager();
        List<Tower> listT = em.createQuery("select t from Tower t", Tower.class).getResultList();
        List<Mage> listM = em.createQuery("select m from Mage m", Mage.class).getResultList();
        System.out.println("Towers: "+listT);
        System.out.println("Mages: "+listM);
        em.close();

    }
    public static void delMag(EntityManagerFactory factory,String id){
        EntityManager em=factory.createEntityManager();

        Mage m=em.find(Mage.class,id);
        Tower t=m.getTower();

        t.getMages().remove(m);


        em.getTransaction().begin();
        em.persist(t);
        em.remove(em.merge(m));
        em.getTransaction().commit();
        em.close();
    }
    public static void delTower(EntityManagerFactory factory,String id){
        EntityManager em=factory.createEntityManager();

        Tower t=em.find(Tower.class,id);
        List<Mage> lst=t.getMages();
        em.getTransaction().begin();
        for(Mage m: lst){
            m.setTower(null);
            em.remove(em.merge(m));
        }

        em.remove(em.merge(t));

        em.getTransaction().commit();
        em.close();
    }
    public static void addTower(EntityManagerFactory factory,String id,int height){
        EntityManager em=factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(new Tower(id,height));
        em.getTransaction().commit();
        em.close();
    }
    public static void addMage(EntityManagerFactory factory,String id,int level,String towerId){
        EntityManager em=factory.createEntityManager();

        em.getTransaction().begin();
        Tower t=em.find(Tower.class,towerId);
        Mage m=new Mage(id,level,t);

        t.getMages().add(m);

        em.persist(m);
        em.merge(t);


        em.getTransaction().commit();
        em.close();
    }
    public static void mageL_g(EntityManagerFactory factory,int l){

        EntityManager em=factory.createEntityManager();
        String queryString = "SELECT m FROM Mage m WHERE m.level>"+l;
        Query query = em.createQuery(queryString, Mage.class);
        List<Mage> mages = query.getResultList();
        System.out.println(mages);

        em.close();
    }

    public static void towerH_l(EntityManagerFactory factory,int h){

        EntityManager em=factory.createEntityManager();
        String queryString = "SELECT t FROM Tower t WHERE t.height<"+h;
        Query query = em.createQuery(queryString, Tower.class);
        List<Tower> mages = query.getResultList();
        System.out.println(mages);

        em.close();
    }
    public static void mageL_gTower(EntityManagerFactory factory,int l,String towerId){

        EntityManager em=factory.createEntityManager();
        String queryString = "SELECT m FROM Mage m, Tower t WHERE m.tower=t AND t.name='"+towerId+"' AND m.level>"+l;
        Query query = em.createQuery(queryString, Mage.class);
        List<Mage> mages = query.getResultList();
        System.out.println(mages);

        em.close();
    }
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("rpgPu");
        Scanner scanner=new Scanner(System.in);

        addTower(factory,"T1",1);
        addTower(factory,"T2",1);
        addMage(factory,"M1",1,"T2");
        addMage(factory,"M2",4,"T1");
        addMage(factory,"M3",5,"T2");
        addMage(factory,"M4",6,"T1");

        boolean end=false;
        while (!end){
            String cmd= scanner.nextLine();
            int i;
            switch (cmd){
                case "z1":
                    mageL_g(factory,Integer.parseInt(scanner.nextLine()));
                    break;
                case "z2":
                    towerH_l(factory,Integer.parseInt(scanner.nextLine()));
                    break;
                case "z3":
                    i=Integer.parseInt(scanner.nextLine());
                    cmd=scanner.nextLine();
                    mageL_gTower(factory,i,cmd);
                    break;
                case "p":
                    printAll(factory);
                    break;
                case "t":
                    cmd=scanner.nextLine();
                    i=Integer.parseInt(scanner.nextLine());
                    addTower(factory,cmd,i);
                    break;
                case "m":
                    cmd=scanner.nextLine();
                    i=Integer.parseInt(scanner.nextLine());
                    String t=scanner.nextLine();
                    addMage(factory,cmd,i,t);
                    break;
                case "x":
                    end=true;
                    break;
                default:
                    System.out.println("Err");
            }
        }






    }
}
