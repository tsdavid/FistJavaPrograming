package CH16_Thread;

public class Test05 {

    public static void main(String[] args) {

        Account account = new Account();
        DrawThread t1 = new DrawThread(account);
        DrawThread t2 = new DrawThread(account);

        t1.start();
        t2.start();
    }

}

class Account {
    private long balance = 1000;

    public synchronized void draw(long amount) {

        balance -= amount;
    }

    public long getRebalance() {
        return balance;
    }
}

class DrawThread extends Thread {

    Account account;

    DrawThread(Account account) {

        this.account = account;
    }

    @Override
    public void run() {

        // // Block Sync
        // synchronized (account) {

        // for(int i=0; 1 < 10;i++){
        // account.draw(10);
        // System.out.println(this.getName() + " Rebalance : " +
        // account.getRebalance());
        // }
        // }

        for (int i = 0; i < 5; i++) {

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            account.draw(10);
            System.out.println(this.getName() + " Rebalance : " + account.getRebalance() + " Operating Time : " + System.currentTimeMillis() );
        }
    }
}

