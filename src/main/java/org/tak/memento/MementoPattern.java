package org.tak.memento;

import java.util.Stack;

/**
 * 备忘录模式（Memento Pattern）保存一个对象的某个状态，
 * 以便在适当的时候恢复对象。备忘录模式属于行为型模式
 * 允许在不暴露对象实现细节的情况下保存和恢复对象
 */
public class MementoPattern {
    public static void main(String[] args) {
        History history=new History();
        Document document=new Document();
        document.change("abc");
        history.add(document.save());
        document.change("def");
        history.add(document.save());
        document.change("ghi");
        history.add(document.save());
        document.change("lmn");

        document.resume(history.getLastVersion());
        document.print();
        document.resume(history.getLastVersion());
        document.print();
    }
}

interface Memento{

}

class BackUp implements Memento{
    String content;
    public BackUp(String content){
        this.content=content;
    }
}

/**
 * 备忘录栈
 */
class History{
    Stack<BackUp> backUpStack=new Stack<>();
    public void add(BackUp backUp){
        backUpStack.add(backUp);
    }
    public BackUp getLastVersion(){
        return backUpStack.pop();
    }
}

/**
 * 文档
 */
class Document{
    private String content;
    public BackUp save(){
        return new BackUp(content);
    }

    public void resume(BackUp backUp){
        this.content= backUp.content;
    }

    public void change(String content){
        this.content=content;
    }

    public void print(){
        System.out.println(content);
    }
}