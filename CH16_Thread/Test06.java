package CH16_Thread;

import java.util.ArrayList;
import java.util.List;

public class Test06 {

    public static void main(String[] args) {
        
        Pool pool = new Pool();
        Thread productGet = new Thread(new ProductGet(pool));
        Thread productAdd = new Thread(new ProductAdd(pool));

        productGet.start();
        productAdd.start();
    }
    
}


class Pool{

    List<String> products = new ArrayList<>();

    public synchronized void get() throws InterruptedException{

        if(products.size() == 0){
            wait();
        }

        products.remove(0);
        System.out.println(" 소비 / 재고 =" + products.size());
    }

    public synchronized void add(String value) {

        products.add(value);
        System.out.println("생산 / 재고 =" + products.size());
        notifyAll();
    }
}


class  ProductGet implements Runnable {
    Pool pool;

    ProductGet(Pool pool){
        this.pool = pool;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try{
            for(int i=1; i<= 10; i++){
                pool.get();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}


class ProductAdd implements Runnable{
    Pool pool;

    ProductAdd(Pool pool){
        this.pool = pool;
    }

    @Override
    public void run(){
        for(int i=1; i<=10; i++){
            pool.add("상품" + i);
        }
    }
}
