import java.util.concurrent.*;

class Bridge {
    private final Semaphore token = new Semaphore(1);
    private String direction = "B";

    public synchronized void cross(String person, String city) {
        try {
            while (!city.equals(direction)) {
                wait();
            }

            token.acquire();
            System.out.println(person + " from City " + city + " is crossing...");
            Thread.sleep(1000);
            System.out.println(person + " has crossed.");

            direction = city.equals("A") ? "B" : "A";
            token.release();
            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Person extends Thread {
    private final Bridge bridge;
    private final String name;
    private final String city;

    public Person(String name, String city, Bridge bridge) {
        this.name = name;
        this.city = city;
        this.bridge = bridge;
    }

    public void run() {
        bridge.cross(name, city);
    }
}

public class BridgeManagement {
    public static void main(String[] args) {
        Bridge bridge = new Bridge();

        new Person("Person1", "B", bridge).start();
        new Person("Person2", "B", bridge).start();

        new Person("Person3", "A", bridge).start();
        new Person("Person4", "A", bridge).start();
    }
}
