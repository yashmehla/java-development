public class Inheritance{
    public static void main(String[] args){
        //Advance Calculator Inheritance example.
        //Parent class is known as Super or base class and child class is known as Sub or derived class.
        AdvCalc obj = new AdvCalc();
        int r1 = obj.add(10, 20);
        int r2 = obj.sub(20, 10);
        System.out.println("Addition: " + r1);
        System.out.println("Subtraction: " + r2);
    }
}