import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mage {
    @Id
    private String name;

    private int level;

    @ManyToOne
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Tower tower;


    public Mage(String name, int level, Tower tower){
        this.name=name;
        this.level=level;
        this.tower=tower;
    }
    public Mage(String name, int level){
        this.name=name;
        this.level=level;

    }
    public Mage() {

    }

    public Tower getTower() {
        return tower;
    }

    public String getName() {
        return name;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }

    @Override
    public String toString() {
        return "Mage{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", tower=" + tower +
                '}';
    }
}
