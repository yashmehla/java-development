class Human{
    private int age=20;
    int hits = 0;
    static int totalHumans = 0;
    Human(){
        totalHumans++;
    }
    public static void printTotalHumans(){
        System.out.println("Total Humans: " + totalHumans);
    }
    
    public int getAge(){
        if(hits < 3){
            hits++;
            return age;
        } else {
            System.out.println("You have exceeded the number of attempts to access the age.");
            return 0; // or throw an exception
        }
    }
}
class Incapsulation{
    public static void main(String[] args) {
        Human h1 = new Human();
        System.out.println("Age: " + h1.getAge());
        System.out.println("Age: " + h1.getAge());
        System.out.println("Age: " + h1.getAge());
        if(h1.getAge() == 0) {
            System.out.println("Access denied.");
        }
        

    }
}