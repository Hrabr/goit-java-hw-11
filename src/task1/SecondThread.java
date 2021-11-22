package task1;

public class SecondThread extends Thread {
  final   FirstThread first;

    public SecondThread(FirstThread first) {
        this.first = first;
    }

    @Override
    public void run() {
        synchronized (first) {
            while (first.isAlive()) {
                try {
                    first.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (first.getCounter() % 5 == 0) {
                    System.out.println("Прошло 5 секунд.");

                }
            }
        }
    }
}

