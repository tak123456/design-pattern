package org.tak.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式属于行为型模式
 * 当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）
 * 比如，当一个对象被修改时，则会自动通知依赖它的对象。
 */
public class ObservePattern {
    public static void main(String[] args) {
        Debit zhangsan=new Zhangsan();
        zhangsan.borrow(new ZhaoSi());
        zhangsan.borrow(new WangWu());
        //状态改变，开始还钱
        zhangsan.notifyCredits();

    }
}

interface Debit{
    void borrow(Credit credit);
    void notifyCredits();
}

interface Credit{
    void takeMoney();
}
class Zhangsan implements Debit{
    private List<Credit> creditList=new ArrayList();
    private Integer state=0;//1表示有钱了

    @Override
    public void borrow(Credit credit) {
        creditList.add(credit);
    }

    @Override
    public void notifyCredits() {
        creditList.forEach(credit -> credit.takeMoney());
    }
}
class ZhaoSi implements Credit{

    @Override
    public void takeMoney() {
        System.out.println("赵四取钱");
    }
}
class WangWu implements Credit{
    @Override
    public void takeMoney() {
        System.out.println("王五取钱");
    }
}