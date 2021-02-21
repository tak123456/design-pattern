package org.tak.Factory;

/**
 * 简单工厂模式,构建者模式
 *
 */
public class SimpleFactory {
    public static Product createProduct(String type){
        if(type.equals("a")){
            return new ProductA();
        }else{
            return new ProductB();
        }
    }

    public static void main(String[] args) {
        Product producta=SimpleFactory.createProduct("a");
        producta.print();
        Product productb=SimpleFactory.createProduct("b");
        productb.print();
    }
}

interface Product {
    void print();
}

class ProductA implements Product{

    @Override
    public void print() {
        System.out.println("产品a");
    }
}
class ProductB implements Product{

    @Override
    public void print() {
        System.out.println("产品b");
    }
}