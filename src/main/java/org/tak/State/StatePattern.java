package org.tak.State;

/**
 * 在状态模式（State Pattern）中，类的行为是基于它的状态改变的。这种类型的设计模式属于行为型模式。
 * 在状态模式中，我们创建表示各种状态的对象和一个行为随着状态对象改变而改变的 context 对象。
 */
public class StatePattern {
    public static void main(String[] args) {
        Context zs=new Context();
        zs.setState(new Happy());
        zs.dosome();
        zs.setState(new Angry());
        zs.dosome();
    }
}

interface State{
    void work();
}
class Happy implements State{
    @Override
    public void work() {
        System.out.println("开心的工作");
    }
}

class Sad implements State{
    @Override
    public void work() {
        System.out.println("悲伤的离开");
    }
}

class Angry implements State{
    @Override
    public void work() {
        System.out.println("开始生气");
    }
}

class Context{
    private State state;

    public void setState(State state) {
        this.state = state;
    }
    public void dosome(){
        state.work();
    }
}