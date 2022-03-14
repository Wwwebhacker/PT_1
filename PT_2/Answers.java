import java.util.ArrayList;

public class Answers {
    private ArrayList<Result> answers=new ArrayList<>();

    public ArrayList<Result> getAnswers() {
        return answers;
    }

    public synchronized void put(Result result) {
        answers.add(result);

    }
}
