package org.tak.proxy;

/**
 *在代理模式（Proxy Pattern）中，一个类代表另一个类的功能。这种类型的设计模式属于结构型模式。
 * 在代理模式中，我们创建具有现有对象的对象，以便向外界提供功能接口。
 */
public class ProxyPattern {
    public static void main(String[] args) {
        new RealSubjectProxy().doWork();
    }


}

interface Subject{
    void doWork();
}
class RealSubject implements Subject{
    @Override
    public void doWork() {
        System.out.println("我要开始工作了");
    }
}

class RealSubjectProxy implements Subject{
    private RealSubject realSubject;

    //动态代理
    public RealSubjectProxy()  {
        try {
            this.realSubject= (RealSubject) this.getClass().getClassLoader().loadClass("org.tak.proxy.RealSubject").newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void connect(){
        System.out.println("链接建立");
    }
    public void log(){
        System.out.println("日志记录");
    }

    @Override
    public void doWork() {
        connect();
        realSubject.doWork();
        log();
    }
}