
class A{
    public A(){
        System.out.println("Object Created");
    }
    public void show(){
        System.out.println("Hello");
    }

}
class Hello{
    public static void main(String[] args){
        new A().show(); 
    }
}