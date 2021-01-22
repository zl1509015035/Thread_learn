package zhul.syn;

//不安全的买票
//县城不安全，有负数
public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"苦逼的我").start();
        new Thread(buyTicket,"牛逼的你们").start();
        new Thread(buyTicket,"可恶的黄牛党").start();
    }
}

class BuyTicket implements Runnable{

    //票
    int ticketNums = 10;
    //外部停止方式
    boolean flag = true;

    @Override
    public void run() {
        //买票
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //synchronized 同步方法，锁this
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if (ticketNums<=0) {
            flag = false;
            return;
        }

        //模拟延时

        Thread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}
