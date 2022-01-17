package kotlin_basics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MainJavaPractical {
    public enum Day {Sun, Mon, Tue, Wed, Thu}
    public static void main(String[] args) {
        //Explicit type casting
        double doubleNum = 166.66;
        //converting double data type into long data type
        long longNum = (long) doubleNum;
        //converting long data type into int data type
        int intNum = (int) longNum;
        System.out.println(doubleNum);
        System.out.println(longNum);
        System.out.println(intNum);

        //if-else
        int age = 25;
        int weight = 48;
        //applying condition on age and weight
        if (age >= 18) {
            if (weight > 50) {
                System.out.println("You are eligible to donate blood");
            } else {
                System.out.println("You are not eligible to donate blood");
            }
        } else {
            System.out.println("Age must be greater than 18");
        }

        //for loop
        String arrayOfDays[] = {"Sunday", "Monday", "Tuesday", "Wednesday"};
        for (String day : arrayOfDays) {
            System.out.println(day);
        }
        for (int index = 10; index <= 15; index++)
            System.out.println(index);

        //use of Enum in switch statement (enum declared before main method)
        Day[] DayNow = Day.values();
        for (Day Now : DayNow) {
            switch (Now) {
                case Sun:
                    System.out.println("Sunday");
                    break;
                case Mon:
                    System.out.println("Monday");
                    break;
                case Tue:
                    System.out.println("Tuesday");
                    break;
                case Wed:
                    System.out.println("Wednesday");
                    break;
            }
        }
        //while loop with continue
        int number = 1;
        while (number <= 5) {
            if(number == 3){
                number++;
                continue;//it will skip 3
            }
            System.out.println(number);
            number++;
        }
        //do-while loop with break
        do {
            if (number == 10) {
                break;//it will break the loop and print 6 to 9
            }
            System.out.println(number);
            number++;
        } while (number <= 15);

        //ArrayList
        List<String> nameList = new ArrayList<>();
        nameList.add("Priyanka");
        nameList.add("Gondaliya");
        nameList.forEach(System.out::println);

        //HashMap
        Map<String, String> map = new HashMap<>();
        map.put("one", "JAVA");
        map.put("two", "Kotlin");
        // convert keys to array
        String[] keys = map.keySet().toArray(new String[map.keySet().size()]);
        for (String string : keys) {
            System.out.println(string);
        }
        // convert keys to list
        List<String> list = new ArrayList<String>(map.keySet());
        for (String string : list) {
            System.out.println(string);
        }

        //Exception Handling using try-catch or by Declaring Exception in main method
        try{
            ExceptionHandling exception = new ExceptionHandling();
            exception.handles();
        } catch (Exception e) {
            System.out.println("exception handled");
        }
        System.out.println("normal flow...");

        //interface
        Cylinder cylinder = new Cylinder();
        cylinder.calculateArea(10, 20);

        Shape1 shape = new Circle();//In a real scenario, object is provided through method, e.g., getShape() method
        shape.draw();

    }
}
class ExceptionHandling{
    void handles() throws IOException {
        throw new IOException("device error");
    }
}

//interface declaration
interface Shape {
    void calculateArea(int radius, int height);
}
//implement the interface
class Cylinder implements Shape {
    //implement the interface method
    public void calculateArea (int radius, int height) {
        System.out.println("The area of the Cylinder is " + (3.14 * radius * radius * height));
    }
}

//abstract class and inheritance
abstract class Shape1{
    abstract void draw();
}
class Rectangle extends Shape1{
    void draw(){System.out.println("drawing rectangle");}
}
class Circle extends Shape1{
    void draw(){System.out.println("drawing circle");}
}

