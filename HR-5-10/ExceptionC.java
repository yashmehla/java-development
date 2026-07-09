class A{
    public void show() throws ClassNotFoundException{
        Class.forName("Alexa");
    }
}
public class ExceptionC{
    static{
        System.out.println("Class Loaded");
    }
    public static void main(String args[]){
        A obj = new A();
        try {
            obj.show();
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found"+e);
        }
    }
}