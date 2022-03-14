public class Result {
    public final int value;
    public final boolean isPrime;

    public Result(int value,boolean isPrime) {
        this.value=value;
        this.isPrime=isPrime;
    }

    @Override
    public String toString() {
        return "{" + value +
                ", isPrime=" + isPrime +
                '}';
    }
}
