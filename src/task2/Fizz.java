package task2;

import java.util.StringJoiner;

public class Fizz {
    private volatile int numbers = 1;
    private int numberFinish;
    StringJoiner joiner = new StringJoiner(", ", "", ".");

    public Fizz(int numberFinish) {
        this.numberFinish = numberFinish;
    }


    public synchronized void fizz() {
        while (numbers <= numberFinish) {
            if (numbers % 3 == 0 && numbers % 5 != 0) {
                joiner.add("fizz");
                numbers++;
                notifyAll();
            }else{
                isWait();}

        }
    }

    public synchronized void buzz() {
        while (numbers <= numberFinish) {
            if (numbers % 5 == 0 && numbers % 3 != 0) {
                joiner.add("buzz");
                numbers++;
                notifyAll();
            }else{
                isWait();}

        }
    }

    public synchronized void fizzbuzz() {
        while (numbers <= numberFinish) {
            if (numbers % 15 == 0) {
                joiner.add("fizzbuzz");
                numbers++;
                notifyAll();

            }else {
                isWait();}

        }
        System.out.println(joiner.toString());
    }

    public synchronized void number() {
        while (numbers <= numberFinish) {
            if (numbers % 3 == 0 || numbers % 5 == 0) {
                isWait();
            }else{
                joiner.add(String.valueOf(numbers));
                numbers++;
                notifyAll();}

        }

    }

    private void isWait() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

