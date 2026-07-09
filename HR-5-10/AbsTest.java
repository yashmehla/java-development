abstract class Car{
    public abstract void Drive();
    public abstract void fly();
    public void PlayMusic(){
        System.out.println("Playing Music");
    }
}
abstract class BMW extends Car{
    public void Drive(){
        System.out.println("BMW is Driving");
    }
}
class UpdatedBMW extends BMW{ // Concrete class
    public void fly(){
        System.out.println("BMW is flying");
    }
}

public class AbsTest {
    public static void main(String[] args){

        // Car Object with BMW reference.
        Car obj = new UpdatedBMW();
        obj.Drive();
        obj.PlayMusic();
        obj.fly();

    }
}
