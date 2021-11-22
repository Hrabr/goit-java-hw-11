package task1;

class FirstThread extends Thread {

    private  int counter = 0;

    public int getCounter() {
        return counter;
    }

    synchronized void setCounter() {
        counter++;

        System.out.println("От начала запуска программы прошло: " + "минут: " + counter / 60 + ", секунд: " + counter % 60);
        notify();

    }

    @Override
    public void run() {


        while (!Thread.interrupted()) {


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setCounter();
        }
    }
}
