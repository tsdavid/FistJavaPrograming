package CH16_Thread;

public class Test07 {

    public static void main(String[] args) {

        Phone calling = new Phone();
        calling.start();

        try {
            calling.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for(int i=1; i<= 1000; i++){
            System.out.println("EATING FOOD : " + i);
        }
    }
}
