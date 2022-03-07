import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Mage implements Comparable<Mage>{
    private String name;
    private int level;
    private double power;
    private Set<Mage> apprentices;

    public Mage(String name, int level, double power,String sorting){
        this.name=name;
        this.level=level;
        this.power=power;
        if (sorting=="ns"){
            apprentices=new HashSet<>();
        }else
        if (sorting=="s"){
            apprentices=new TreeSet<>();
        }else
        if (sorting=="alts"){
            apprentices=new TreeSet<>(new MageComparator());
        }

    }

    public void addApprentice(Mage mage){
        apprentices.add(mage);
    }
    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public int getLevel() {
        return level;
    }
    public int apprenticeNumber(){
        int ret=0;
        for(Mage m:apprentices){
            ret+=m.apprenticeNumber()+1;
        }
        return ret;
    }
    public void print(int level){
        for (int i=0;i<level;i++){
            System.out.print("-");
        }
        System.out.println(this);
        for (Mage o: apprentices){
            o.print(level+1);
        }

    }

    @Override
    public int compareTo(Mage other) {
        int ret=name.compareTo(other.name);
        if (ret !=0) return ret;
        ret =Integer.compare(level,other.level);
        if (ret !=0) return ret;
        return Double.compare(power,other.power);
    }
    @Override
    public boolean equals(Object other){
        if (this == other) {
            return true; //very same object
        }
        if (other == null || getClass() != other.getClass()) {
            return false; //other is null or final classes are different
        }
        Mage mage = (Mage) other;
        if (!name.equals(mage.name)) {
            return false;
        }
        if (level!=mage.level) {
            return false;
        }
        if (power!=mage.power){
            return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = result+ 31 * level +Double.hashCode(power);
        return result;
    }
    @Override
    public String toString(){
        return "Mage{name='"+name+"', level="+level+", power="+power+"}";
    }


}
