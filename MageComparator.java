import java.util.Comparator;

public  class MageComparator implements Comparator<Mage> {

    @Override
    public int compare(Mage o1, Mage o2) {
        int ret=Integer.compare(o1.getLevel(),o2.getLevel());
        if (ret !=0) return ret;
        ret =o1.getName().compareTo(o2.getName());
        if (ret !=0) return ret;
        return Double.compare(o1.getLevel(),o2.getPower());

    }
}
