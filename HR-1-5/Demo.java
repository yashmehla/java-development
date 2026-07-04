class Calculator{
    //Normal method
    public int add(int a, int b){
        return a + b;
    }
    //Static method
    public static int staticAdd(int a, int b){
        return a + b;
    }
}

class Demo{
    public static void main(String[] args){
        int a = 10;
        int b = 20;
        //Normal Method Calling
        Calculator calc = new Calculator();
        int normalResult = calc.add(a, b);
        System.out.println("Normal Method Result: " + normalResult);
        //Static Method Calling
        int staticResult = Calculator.staticAdd(a,b);
        System.out.println("Static Method Result: " + staticResult);
    }
}