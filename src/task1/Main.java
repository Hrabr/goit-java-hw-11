package task1;

public class Main {
    public static void main(String[] args) {
        FirstThread first = new FirstThread();
        SecondThread second = new SecondThread(first);
        first.start();
        second.start();
    }
}