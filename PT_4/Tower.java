import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tower {
    @Id
    private String name;

    private int height;

    ///@OneToMany(mappedBy = "tower")
    @OneToMany
    private List<Mage> mages;

    public Tower(String name, int height){
        this.name=name;
        this.height=height;
        mages=new ArrayList<>();
    }

    public Tower() {

    }

    public List<Mage> getMages() {
        return mages;
    }

    public void setMages(List<Mage> mages) {
        this.mages = mages;
    }

    @Override
    public String toString() {

        String ans="Tower{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", mages=[";

        for (Mage m: mages){
            ans=ans+m.getName()+", ";
        }

        StringBuilder s= new StringBuilder(ans);
        if (mages.size()>0){
            s.delete(ans.length()-2,ans.length());
        }

        s.append("]}") ;
        return s.toString();
    }
}
