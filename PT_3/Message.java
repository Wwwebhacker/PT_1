import java.io.Serializable;

public class Message implements Serializable {
    private int number;
    private String content;
    static final long serialVersionUID=1;

    public void setContent(String content) {
        this.content = content;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }
}
