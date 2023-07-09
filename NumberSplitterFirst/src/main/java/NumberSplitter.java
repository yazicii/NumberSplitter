import lombok.Data;

import java.util.List;

@Data
public class NumberSplitter implements Runnable {

    protected static List<Integer> numbers;
    protected static List<Integer> evenNumbers;
    protected static List<Integer> oddNumbers;
    private static final Object LOCK = new Object();
    private int startIndex;
    private int endIndex;

    public NumberSplitter(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }


    @Override
    public void run() {
        for (int i = startIndex; i<endIndex;i++){
            int number = numbers.get(i);
            if (number % 2 ==0){
                synchronized (LOCK) {
                    oddNumbers.add(i);
                }
            }else {
                synchronized (LOCK) {
                    evenNumbers.add(i);
                }
            }
        }

    }
}
