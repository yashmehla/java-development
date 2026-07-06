public class Inheritance{
    public static void main(String[] args){
        //Advance Calculator Inheritance example.
        //Parent class is known as Super or base class and child class is known as Sub or derived class.
        //Multi-Level Inheritance
        VeryAdvCalc obj = new VeryAdvCalc();
        int r1 = obj.add(10, 20);
        int r2 = obj.sub(20, 10);
        System.out.println("Addition: " + r1);
        System.out.println("Subtraction: " + r2);

        int r3 = obj.multi(10, 20);
        int r4 = obj.div(20, 10);
        System.out.println("Multiplication: " + r3);
        System.out.println("Division: " + r4);

        int r5 = obj.pow(2, 3);
        System.out.println("Power: " + r5);
    }
}