class Student{
    String name;
    int marks;
}

class Hello{
    public static void main(String[] args){
        Student s1 = new Student();
        s1.name = "John";
        s1.marks = 85;

        Student s2 = new Student();
        s2.name = "Alice";
        s2.marks = 92;

        System.out.println("Student 1: " + s1.name + ", Marks: " + s1.marks);
        System.out.println("Student 2: " + s2.name + ", Marks: " + s2.marks);
        Student[] students = new Student[2];
        students[0] = s1;
        students[1] = s2;
        for(int i=0;i<2;i++){
            System.out.println("Student :"+ students[i].name + ", Marks: " + students[i].marks);
        }
    }
}