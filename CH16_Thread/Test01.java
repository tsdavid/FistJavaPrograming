package CH16_Thread;

public class Test01 {
    

    public static void main(String[] args) {
        
        Food worker1 = new Food();
        Phone worker2 = new Phone();

        worker1.start();
        worker2.start();


        for(int i=1; i<=1000; i++){
            System.out.println("WATCHING TV : "+ i);
        }
    }
}


class Food extends Thread{
    
    public void run(){

        for(int i=1; i <= 1000; i++){
            System.out.println("EATING FOOD : " + i);
        }
    }
}

class Phone extends Thread{

    public void run(){
        
        for(int i=1; i <= 1000; i++){
            System.out.println("INCOMING CALL : " + i);
        }
    }
}