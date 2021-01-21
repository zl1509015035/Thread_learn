package zhul.state;

//守护线程
//线程分为 用户线程 和 守护线程
//虚拟机必须确保用户线程执行完毕
//虚拟机不用等待守护线程执行完毕
//如：后台记录操作日志，监控内存，垃圾回收等待
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        //默认是false表示为用户线程，正常的线程都是用户线程
        thread.setDaemon(true);
        //上帝守护线程启动
        thread.start();

        //用户线程启动
        new Thread(you).start();
    }
}


//上帝  守护你
class God implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你");
        }
    }
}

//你
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("========good bye ! world !");
    }
}
