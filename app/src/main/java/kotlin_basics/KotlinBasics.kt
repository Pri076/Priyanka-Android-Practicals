package kotlin_basics

fun main() {
//type conversion
    val firstValue = 11
    val secondValue: Long = firstValue.toLong()
    println(secondValue)
    //from larger data type to smaller data type
    val thirdValue: Long = 12
    val fourthValue: Int = thirdValue.toInt()
    println(fourthValue)

//operator
    println(firstValue + thirdValue)
    //relational
    val max = if (secondValue > fourthValue) {
        println("value2 is greater than value4.")
        secondValue
    } else {
        println("value4 is greater than value2.")
        fourthValue
    }
    println("max = $max")
    //assignment
    var firstNum = 20
    var secondNum = 5
    val thirdNum = 10
    firstNum += secondNum
    println("num1 += num2 : $firstNum")
    //Unary
    println("--num2 :"+ --secondNum)

//if
    if (firstNum == 20) {
        println("num1 is 20")
    }
//if-else
    val result = if (firstNum > secondNum) {
        "$firstNum is greater than $secondNum"
    } else {
        "$firstNum is smaller than $secondNum"
    }
    println(result)
//if-else if-else Ladder Expression
    val firstResult = if (firstNum > 0) {
        "$firstNum is positive"
    } else if (firstNum < 0) {
        "$firstNum is negative"
    } else {
        "$firstNum is zero"
    }
    println(firstResult)
//nested if
    val thirdResult = if (firstNum > secondNum) {
        val secondMax = if (firstNum > thirdNum) {
            firstNum
        } else {
            thirdNum
        }
        secondMax
    } else if (secondNum > thirdNum) {
        secondNum
    } else {
        thirdNum
    }
    println("$thirdResult")

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
    when (number) {
        in 1..10 -> println("Input is provided in the range 1 to 10")
        in 11..20 -> println("Input is provided in the range 11 to 20")
        else -> println("none of the above")
    }
//for loop
    for (secondNumber in 10..15) {
        println("$secondNumber")
    }
    val arrayOfDays = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday")
    for (day in arrayOfDays) {
        println(day)
    }
    for ((index, value) in arrayOfDays.withIndex()) {
        println("Day at Index $index is: $value")
    }
    for (thirdNumber in arrayOfDays.indices) {
        println("Days[$thirdNumber]: ${arrayOfDays[thirdNumber]}")
    }
//while
    while (number <= 15) {
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
    for (fourthNumber in 11..15) {
        if (number == 13) {
            break
        }
        println(fourthNumber)
//labelled break
        var firstNo = 4
        while (firstNo > 0) {
            var secondNo = 4
            innerMostLoop@while (secondNo > 0) {
                if (secondNo == 2)
                    break@innerMostLoop
                println("num1 = $firstNo, num2 = $secondNo")
                secondNo--
            }
            println(firstNo)
            firstNo--
        }
//continue
        for (fifthNumber in 11..15) {
            if (fifthNumber == 13) {
                continue
            }
            println(fifthNumber)
        }
        val secondResult = sum(5, 6)
        print(secondResult)

        displayCharacter()
        displayCharacter(5)
        displayCharacter(3,'a')
        displayCharacter(latter='a')

        sumOfTwoNumbers(sumOfNums)

//nullable
        var name: String?  // variable is declared as nullable
        name = null
        print(name)
//checking for null in condition
        var firstName: String? = "Hello"     // variable is declared as nullable
        var len = firstName?.length

        println("length is : $len")

        firstName = null
        println("string is : $firstName")
        len = firstName?.length ?: -1
        //elvis operator ?:
        //var len:  Int = name1 ?.length ?: -1
        println("length is : $len")

        //smart cast for null safe
        val secondName = "Hello!"
        // print (name2.length) // Compile error (try to access a nullable type of String without safe cast)
        // smart cast

       /* //unsafe cast
        val name3: Any? = null
        val string: String = name3 as String
        println(string)  //nullable string (String?) cannot be cast to non nullable string (String),
        // this throw an exception */

        // Source and target variable need to nullable for casting to work
        val fifthName: String? = "String unsafe cast"
        val firstString: String? = fifthName as String?
        println(firstString)

        //safe cast as?
        val fifthNm: Any = "Kotlin"
        val safeString: String? = fifthNm as? String
        val safeInt: Int? = fifthNm as? Int
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
        val firstPerson = Person()
        val ageAfterFiveYears: Int = with(firstPerson) {
            println(this.name)
            println(age)
            age + 5
        }
        println(ageAfterFiveYears)

        /* Scope Function: 'run'
        Property 1: Refer to context object by using 'this'
        Property 2: The return value is the 'lambda result'  */

        // If you want to operate on a Nullable object and avoid NullPointerException then use 'run'

        val secondPerson = Person()
        val newAgeAfterFiveYears = secondPerson.run {
            println(this.name)
            println(age)
            age + 5
        }
        println(newAgeAfterFiveYears)

        /*Scope Function: 'apply' ̐to initialize or configure an object)
        Property 1: Refer to context object by using 'this'
        Property 2: The return value is the 'context object'  */

        val person = Person().apply {
            this.name = "Priyanka Gondaliya"
            age = 20
        }
        with (person) {
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
        println("test.old = ${test.newNum}") // prints 2
        test.oldNum = 4
        println("test.new = ${test.newNum}") // prints 4

        val firstObject = Flower.Rose()
        val secondObject = Flower.Sunflower()
        val thirdObject = Lily()

        // Function called with different objects
        display(firstObject)
        display(secondObject)
        display(thirdObject)
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
    var oldNum: Int = 2
    val newNum
        get() = oldNum
}

/* function */
fun sum(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber + secondNumber
}
//default argument: passing no argument
fun displayCharacter(num: Int= 5, latter: Char ='x') {
    println("parameter in function definition $num and $latter")
}
//higher order function

// lambda expression
var sumOfNums = {nextNum: Int , sumOfNum: Int -> nextNum + sumOfNum }
// higher order function
fun sumOfTwoNumbers( nums: (Int, Int) -> Int) {      // accepting lambda as parameter
    val result = nums(2,4)
    println("The sum of two numbers is: $result")
}
//Inheritance
//base class
open class BaseClass {
    val name = "Priyanka"
    fun printBaseClass() {
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
sealed class Flower (val x: String) {
    class Rose: Flower("Rose")
    class Sunflower: Flower("Sunflower")
}
class Lily: Flower("Lily")
fun display(flower: Flower) {
    when (flower) {
        is Flower.Rose -> println("${flower.x} is Red")
        is Flower.Sunflower -> println("${flower.x} is Yellow")
        is Lily -> println("${flower.x} is White")
    }
}


