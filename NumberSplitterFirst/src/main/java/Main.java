import java.util.ArrayList;

public class Main extends NumberSplitter{


    public Main(int startIndex, int endIndex) {
        super(startIndex, endIndex);
    }

    public static void main(String[] args) {

        numbers = new ArrayList<>();
        evenNumbers = new ArrayList<>();
        oddNumbers = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }

        int chunkSize = numbers.size() / 4;
        int starIndex = 0;
        int endIndex = chunkSize;

        for (int i = 0; i < 4; i++) {
            NumberSplitter numberSplitter = new NumberSplitter(starIndex, endIndex);
            new Thread(numberSplitter).start();
            starIndex = endIndex;
            endIndex += chunkSize;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Even Numbers");
        for (int number : evenNumbers) {
            System.out.println(number);
        }

        System.out.println("Odd Numbers");
        for (int number : oddNumbers) {
            System.out.println(number);
        }

    }

}