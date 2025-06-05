
class OddEvenPrinter{
    private int number = 1;
    private final int max;

    public OddEvenPrinter(int max){
        this.max = max;
    }

    public synchronized void printOdd(){
        while (number <= max){
            if(number% 2 == 0){
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }else{
                System.out.println("Odd Numbers: " + number);
                number++;
                notify();
            }
        }
    }

    public synchronized void printEven(){
        while (number <= max){
            if(number % 2 != 0){
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }else{
                System.out.println("Even Numbers: " + number);
                number++;
                notify();
            }
        }
    }
}

class OddThread extends Thread{
    private final OddEvenPrinter printer;

    public OddThread(OddEvenPrinter printer){
        this.printer = printer;
    }
    public void run(){
        printer.printOdd();
    }
}

class EvenThread extends Thread{
    private final OddEvenPrinter printer;

    public EvenThread(OddEvenPrinter printer){
        this.printer = printer;
    }
    public void run(){
        printer.printEven();
    }
}

public class OddEven {
    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter(10);
        new OddThread(printer).start();
        new EvenThread(printer).start();
    }
}
