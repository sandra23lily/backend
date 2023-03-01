package singleton

import Singleton

fun main (){
    var singletonA: Singleton? = Singleton.getInstance()

    var singletonB: Singleton? = Singleton.getInstance()

    System.out.println(singletonA)

    System.out.println(singletonB)

    println("Misma referencia ==> " + (singletonA === singletonB))

    singletonA?.setAppName("Singleton Pattern")

    singletonB?.setAppVersion("1.0x")

    println("SingletonA ==> $singletonA")

    println("SingletonB ==> $singletonB")

    singletonA = null

    singletonB = null

    singletonA = Singleton.getInstance()

    println("SingletonA ==> $singletonA")
}

