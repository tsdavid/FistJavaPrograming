package CH16_Thread;



public class Test03 {

    public static void main(String[] args) {

        Worker1 w1 = new Worker1();
        Worker2 w2 = new Worker2();

        w1.start();
        w2.start();
    }

}

class Worker1 extends Thread {

    Worker1() {
        setName("SAVE FILE");
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {

            System.out.println(this.getName() + " WORKING...");
    
        }
    }
}

class Worker2 extends Thread{

    Worker2(){
        setName("CONNECTING SERVER");
    }

    @Override
    public void run(){

        for(int i=1; i <= 10; i++){

            System.out.println(this.getName() + " WORKING ...");
        }
    }
}