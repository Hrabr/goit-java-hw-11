package task2;

public class Main {
    public static void main(String[] args) {
        Fizz fizz = new Fizz(90);
        new Thread(fizz::fizz).start();
        new Thread(fizz::buzz).start();
        new Thread(fizz::fizzbuzz).start();
        new Thread(fizz::number).start();

    }
}