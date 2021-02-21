package org.tak.Facade;

/**
 *
 *外观模式（Facade Pattern）隐藏系统的复杂性，这种类型的设计模式属于结构型模式
 *并向客户端提供了一个客户端可以访问系统的接口。，它向现有的系统添加一个接口，来隐藏系统的复杂性
 */
public class FacadePattern {
    public static void main(String[] args) {
         Facade facade = new Facade();
        System.out.println("is a good man?"+facade.prove());
    }
}

class SubFlow1{
    boolean isTrue(){
        return true;
    }
}

class SubFlow2{
    boolean isOk(){
        return true;
    }
}

class SubFlow3{
    boolean isGoodMan(){
        return true;
    }
}

class Facade{
    SubFlow1 subFlow1=new SubFlow1();
    SubFlow2 subFlow2=new SubFlow2();
    SubFlow3 subFlow3=new SubFlow3();

    boolean prove(){
        return subFlow1.isTrue()&&subFlow2.isOk()&&subFlow3.isGoodMan();
    }
}