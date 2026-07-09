class A{
    int age;
    public void show(){
        System.out.println("In Show");
    }
    static class B{
        public void test(){
            System.out.println("In Test");
        }
    }
}


public class Inner {
    public static void main(String a[]){
        A obj = new A();
        obj.show();
        A.B obj1 = new A.B();
        obj1.test();
    }   
}
