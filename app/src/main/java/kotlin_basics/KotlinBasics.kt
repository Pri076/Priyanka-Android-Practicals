package kotlin_basics

import java.util.*

fun main() {
//type conversion
    val value1 = 11
    val value2: Long = value1.toLong()
    println(value2)
    //from larger data type to smaller data type
    val value3: Long = 12
    val value4: Int = value3.toInt()
    println(value4)


//operator
    println(value1 + value3)
    //relational
    val max = if (value2 > value4) {
        println("value2 is greater than value4.")
        value2
    } else{
        println("value4 is greater than value2.")
        value4
    }
    println("max = $max")
    //assignment
    var num1 = 20
    var num2 = 5
    val num3 = 10
    num1 += num2
    println("num1 += num2 :$num1")
    //Unary
    println("--num2 :"+ --num2)

//if
    if (num1 == 20) {
        println("num1 is 20")
    }
//if-else
    val result = if (num1 > num2) {
        "$num1 is greater than $num2"
    } else {
        "$num1 is smaller than $num2"
    }
    println(result)
//if-else if-else Ladder Expression
    val result1 = if (num1 > 0) {
        "$num1 is positive"
    } else if (num1 < 0) {
        "$num1 is negative"
    } else {
        "$num1 is zero"
    }
    println(result1)
//nested if
    val result3 = if (num1 > num2) {
        val max2 = if (num1 > num3) {
            num1
        } else {
            num3
        }
        max2
    } else if (num2 > num3) {
        num2
    } else {
        num3
    }
    println("$result3")

//when
    var number = 11
    when (number) {
        1 -> println("One")
        2 -> println("Two")
        3 -> println("Three")
        4 -> println("Four")
        5 -> println("Five")
        else -> println("invalid number")
    }
//when in range
    when(number) {
        in 1..10 -> println("Input is provided in the range 1 to 10")
        in 11..20 -> println("Input is provided in the range 11 to 20")
        else -> println("none of the above")
    }
//for loop
    for(number2 in 10..15){
        println("$number2")
    }
    val arrayOfDays = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday")
    for (day in arrayOfDays){
        println(day)
    }
    for((index, value) in arrayOfDays.withIndex()){
        println("Day at Index $index is: $value")
    }
    for (number3 in arrayOfDays.indices){
        println("Days[$number3]: ${arrayOfDays[number3]}")
    }
//while
    while (number <= 15){
        println(number)
        number++
    }
//do-while
    do {
        println(number)
        number++
    }
    while (number <= 15)
//break
    for (number4 in 11..15) {
        if (number == 13) {
            break
        }
        println(number4)
//labelled break
        var no1 = 4
        while (no1 > 0) {
            var no2 = 4
            label@while (no2 > 0) {
                if (no2 == 2)
                    break@label
                println("num1 = $no1, num2 = $no2")
                no2--
            }
            println(no1)
            no1--
        }
//continue
        for (number5 in 11..15) {
            if (number5 == 13) {
                continue
            }
            println(number5)
        }
        val result2 = sum(5, 6)
        print(result2)

        defaultArgument()
        firstArgument(5)
        allArguments(3,'a')
        namedArgument(latter='a')

        higherfunc(lambda)

//nullable
        var name: String?  // variable is declared as nullable
        name = null
        print(name)
//checking for null in condition
        var name1: String? = "Hello"     // variable is declared as nullable
        var len = name1?.length

        println("length is : $len")

        name1 = null
        println("string is : $name1")
        len = name1?.length ?: -1
        //elvis operator ?:
        //var len:  Int = name1 ?.length ?: -1
        println("length is : $len")

        //smart cast for null safe
        val name2 = "Hello!"
        // print (name2.length) // Compile error (try to access a nullable type of String without safe cast)
        // smart cast

       /* //unsafe cast
        val name3: Any? = null
        val string: String = name3 as String
        println(string)  //nullable string (String?) cannot be cast to non nullable string (String),
        // this throw an exception */

        // Source and target variable need to nullable for casting to work
        val name4: String? = "String unsafe cast"
        val string1: String? = name4 as String?
        println(string1)

        //safe cast as?
        val name5: Any = "Kotlin"
        val safeString: String? = name5 as? String
        val safeInt: Int? = name5 as? Int
        println(safeString)
        println(safeInt)

        //datatype
        data class User(var name: String, var id: Int, var email: String)
        val u = User("Priyanka", 101, "mymail@mail.com")
        println(u)

        //inheritance
        val derived = DerivedClass()
        derived.printBaseClass()         // inheriting the  base class function
        derived.printDerivedClass()         // calling derived class function

        /* Scope Function: 'let'
        Property 1: Refer to context object by using 'it'
        Property 2: The return value is the 'lambda result'  */
        // Use let to avoid NullPointerException and execute lambda expr on nullable objects
        val myName: String = "Priyanka"
        // Execute only if the 'myName' variable is NOT NULL
        val stringLength = myName.let {
            println(it.reversed())
            it.length
        }
        println(stringLength)

        /* Scope Function: 'with' (if you want to operate on a non-null object)
        Property 1: Refer to context object by using 'this'
        Property 2: The return value is the 'lambda result'  */
        val person1 = Person()
        val ageAfterFiveYears1: Int = with(person1) {
            println(this.name)
            println(age)
            age + 5
        }
        println(ageAfterFiveYears1)

        /* Scope Function: 'run'
        Property 1: Refer to context object by using 'this'
        Property 2: The return value is the 'lambda result'  */

        // If you want to operate on a Nullable object and avoid NullPointerException then use 'run'

        val person2 = Person()
        val ageAfterFiveYears2 = person2.run {
            println(this.name)
            println(age)
            age + 5
        }
        println(ageAfterFiveYears2)

        /*Scope Function: 'apply' ̐to initialize or configure an object)
        Property 1: Refer to context object by using 'this'
        Property 2: The return value is the 'context object'  */

        val person = Person().apply {
            this.name = "Priyanka Gondaliya"
            age = 20
        }
        with(person) {
            println(this.name)
            println(age)
        }
        // Perform some other operations on 'person' object
        person.also {
            it.name = "Kotlin"
            println("New name: ${it.name}")
        }
        //filter function

        val finallResult = persons.filter(agePredicate)
        println(finallResult)

        val finalResult = persons.filter{ it.age >= 20 } // it is person object
        println(finalResult)

        //map function
        val preFinalResult = persons.map{ OtherPerson ->
            "${OtherPerson.name} is ${OtherPerson.age} years old"
        }
        println(preFinalResult)

        val test = Test()
        println("test.y = ${test.y}") // prints 2
        test.x = 4
        println("test.y = ${test.y}") // prints 4

        val obj = Flower.Rose()
        val obj1 = Flower.Sunflower()
        val obj2 = Lily()

        // Function called with different objects
        display(obj)
        display(obj1)
        display(obj2)
    }
}

data class OtherPerson(val name : String, val age: Int)
val persons = listOf(OtherPerson("Priyanka", 20), OtherPerson("Dev", 21), OtherPerson("Harsh", 18))
val agePredicate: (OtherPerson) -> Boolean = { person: OtherPerson -> person.age >= 20 }

class Person {
    var name: String = "Priyanka Gondaliya"
    var age: Int = 20
}

class Test {
    var x: Int = 2
    val y
        get() = x
}

/* function */
fun sum(number1: Int, number2: Int): Int {
    return number1 + number2
}
//default argument: passing no argument
fun defaultArgument(num:Int= 5, latter: Char ='x') {
    println("parameter in function definition $num and $latter")
}
//passing one argument
fun firstArgument(num:Int= 5, latter: Char ='x') {
    println("parameter in function definition $num and $latter")
}
//passing all arguments
fun allArguments(num:Int= 5, latter: Char ='x') {
    println("parameter in function definition $num and $latter")
}
//named argument
fun namedArgument(num:Int= 5, latter: Char ='x') {
    println("parameter in function definition $num and $latter")
}
//higher order function

// lambda expression
var lambda = {number6: Int , number7: Int -> number6 + number7 }
// higher order function
fun higherfunc( lmbd: (Int, Int) -> Int) {      // accepting lambda as parameter
    val result = lmbd(2,4)
    println("The sum of two numbers is: $result")
}
//Inheritance
//base class
open class BaseClass{
    val name = "Priyanka"
    fun printBaseClass(){
        println("Base Class")
    }
}
//derived class
class DerivedClass: BaseClass() {
    fun printDerivedClass() {
        println(name)           //inherit name
        println("Derived class")
    }
}

//sealed class
sealed class Flower
    (val x: String)
{
    class Rose : Flower("Rose")
    class Sunflower : Flower("Sunflower")
}
class Lily: Flower("Lily")
fun display(flower: Flower){
    when(flower)
    {
        is Flower.Rose -> println("${flower.x} is Red")
        is Flower.Sunflower -> println("${flower.x} is Yellow")
        is Lily -> println("${flower.x} is White")
    }
}


