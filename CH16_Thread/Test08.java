package CH16_Thread;

public class Test08 {
    
    public static void main(String[] args) {
        
        PrintThread t = new PrintThread();
        t.start();
        t.interrupt();
    }
}



class PrintThread extends Thread {

    @Override
    public void run(){
        try{

            for(int i=0; i < 10; i++){
                Thread.sleep(2000);
                System.out.println("PRINTING : " + i);
            }
        }catch (InterruptedException e){

            System.out.println("CAUSE BY INTERRUPT, STOP SLEEP STAT");
        }
    }
}