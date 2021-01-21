package zhul.state;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时
public class TestSleep2 {

    public static void main(String[] args) {
        /*try {
            tenDow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //打印当前系统时间
        //获取系统当前时间
        Date startTime = new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                //更新时间
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //模拟倒计时
    public static void tenDow() throws InterruptedException {
        int num = 10;

        while (true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<=0){
                break;
            }
        }
    }
}
