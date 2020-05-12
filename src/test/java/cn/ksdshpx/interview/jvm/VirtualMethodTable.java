package cn.ksdshpx.interview.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/1/31
 * Time: 17:42
 * Description:虚方法表的举例
 */
interface Friendly{
    void sayHello();
    void sayGoodBye();
}

class Dogg{
    public void sayHello(){

    }

    @Override
    public String toString() {
        return "Dog";
    }
}

class Catt implements Friendly{

    public void eat(){

    }

    @Override
    public void sayHello() {

    }

    @Override
    public void sayGoodBye() {

    }

    @Override
    protected void finalize(){

    }

    @Override
    public String toString() {
        return "Cat";
    }
}

class CockerSpaniel extends Dogg implements Friendly{

    public void sayHello() {
        super.sayHello();
    }

    @Override
    public void sayGoodBye() {

    }
}

public class VirtualMethodTable {
}
