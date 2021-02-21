package org.tak.singleton;

/**构建者模式
 * 单列模式确保一个类只有一个实例，而且自动实例化并向系统提供这个实例
 * 所以构造方法为private，并且有有个static的实例
 * 饿汉式和懒汉式，线程是否安全，枚举类实现（推荐）
 * 这里使用双重锁懒汉式实现
 * volatile：new singleton()可以分为三部，1分配内存，2初始化对象，3指向分配的内存空间
 * 若发生重排序线程a执行了1和3还没有2，b线程来到了判断null会直接返回没有初始化的instance。volatile可以避免这个情况
 */
public class SingletonPattern {
    public static void main(String[] args) {
        Singleton singletonA=Singleton.getInstance();
        Singleton singletonB=Singleton.getInstance();
        System.out.println(singletonA);
        System.out.println(singletonB);
    }
}

class Singleton{
    private volatile static Singleton singleton;
    private Singleton(){

    }
    public static Singleton getInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}