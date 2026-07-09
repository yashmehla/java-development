class A{
    public void show(){
        System.out.println("In Show");
    }

}
class B extends A{
    public void show(){
        System.out.println("In Test");
    }
}


public class Demo {
    public static void main(String a[]){
        A obj = new B();
        obj.show();

    }
}
