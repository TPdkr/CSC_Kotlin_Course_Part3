package org.jetbrains.kotlin.course.duck.shop.functions.change

import org.jetbrains.kotlin.course.duck.shop.duck.Duck
import org.jetbrains.kotlin.course.duck.shop.duck.generateRandomDuck
import org.jetbrains.kotlin.course.duck.shop.duck.getDescription
import org.springframework.stereotype.Service

@Service
class GameChangeFunctionsService  {
    fun MutableList<Duck>.addRandomDuck(): Duck = generateRandomDuck().also{add(it)}

    fun MutableSet<Duck>.addRandomDuck(): Duck = Duck.entries.minus(this.toList()).random().also{add(it)}

    fun MutableMap<Duck, String>.addRandomDuck(): Pair<Duck, String> = Duck.entries.minus(keys).random().let{
        it to it.getDescription()
    }.also{plus(it)}

    fun List<Duck>.removeRandomDuck(): List<Duck> = this.toMutableList().apply{this.removeAt((indices).random())}

    fun Set<Duck>.removeRandomDuck(): Set<Duck> = this.toMutableSet().apply{this.remove(this.random())}

    fun Map<Duck, String>.removeRandomDuck(): Map<Duck, String> = this.toMutableMap().apply{this.remove(this.keys.random())}
}
