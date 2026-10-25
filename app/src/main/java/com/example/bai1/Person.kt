package com.example.bai1

open class Person(val name: String, val age: Int){
    val isAdult: Int = 0
        get() {
            return if (age >= 18) 1 else 0
        }
}
data class Person1(val name: String, val age: Int)



fun main() {
    val person = Person("Alice", 25)
    println(person.isAdult)
//    val person1 = Person1("Alice", 25, quequan = "TN")

}

class Student(name: String, age: Int) : Person(name, age){

}