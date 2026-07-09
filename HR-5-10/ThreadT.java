class A extends Thread{
    public void run(){
    for(int i=0;i<10;i++){
        System.out.println("Hi");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    }
}
class B extends Thread{
    public void run(){
    for(int i=0;i<10;i++){
        System.out.println("Hello");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    }
}
public class ThreadT {
    public static void main(String args[]){
        A obj1 = new A();
        B obj2 = new B();
        obj1.setPriority(Thread.MAX_PRIORITY);
        obj2.setPriority(Thread.MAX_PRIORITY);
        obj1.start();
        obj2.start();
    }
}
