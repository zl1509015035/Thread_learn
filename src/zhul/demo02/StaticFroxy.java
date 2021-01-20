package zhul.demo02;

//静态代理模式总结：
//真实对象和代理对象都要实现同一个接口
//代理对象要代理真实角色

//好处
//代理对象可以做很多真实对象做不了的事情
//真是对象专注做自己的事情
public class StaticFroxy {
    public static void main(String[] args) {

        You you = new You();
//        WeddingCompany weddingCompany=new WeddingCompany(you);
//        weddingCompany.HappyMarry();

        new Thread(() -> System.out.println("我爱你")).start();
        new WeddingCompany(new You()).HappyMarry();
    }


}

interface Marry {
    void HappyMarry();
}

class You implements Marry {

    @Override
    public void HappyMarry() {
        System.out.println("秦老师要结婚了，超开心！");
    }
}

//代理角色,帮助处理结婚事宜
class WeddingCompany implements Marry {

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
}
