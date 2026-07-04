class Load{
    public void show(int a){
        System.out.println(a);
    }
    public void show(String a){
        System.out.println(a);
    }

}

public class MethodOverloading{
    public static void main(String[] args) {
        String num="Hello";
        Load l1=new Load();
        l1.show(num);
    }
}