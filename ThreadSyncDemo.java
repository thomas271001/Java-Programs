class SharedResource {
    private boolean available = false;
    private int data;

    public synchronized void setData(int value) throws InterruptedException {
        while (available) {
            wait();
        }
        data = value;
        System.out.println("Data set: " + data);
        available = true;
        notify();
    }

    public synchronized int getData() throws InterruptedException {
        while (!available) {
            wait();
        }
        System.out.println("Data retrieved: " + data);
        available = false;
        notify();
        return data;
    }
}

class Writer extends Thread {
    private final SharedResource resource;

    public Writer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                resource.setData(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Writer interrupted.");
            }
        }
    }
}

class Reader extends Thread {
    private final SharedResource resource;

    public Reader(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                resource.getData();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Reader interrupted.");
            }
        }
    }
}

public class ThreadSyncDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Writer writer = new Writer(resource);
        Reader reader = new Reader(resource);

        writer.start();
        reader.start();
    }
}
