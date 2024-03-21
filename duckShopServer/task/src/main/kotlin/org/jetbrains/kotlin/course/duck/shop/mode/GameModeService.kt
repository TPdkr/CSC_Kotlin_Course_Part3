package org.jetbrains.kotlin.course.duck.shop.mode

import org.jetbrains.kotlin.course.duck.shop.duck.Duck
import org.jetbrains.kotlin.course.duck.shop.duck.generateRandomDuck
import org.jetbrains.kotlin.course.duck.shop.duck.getDescription
import org.jetbrains.kotlin.course.duck.shop.utils.MAX_NUMBER_OF_DUCKS
import org.springframework.stereotype.Service

@Service
class GameModeService {
    fun generateListOfDucks(): List<Duck> = List(MAX_NUMBER_OF_DUCKS){ generateRandomDuck() }

    fun generateSetOfDucks(): Set<Duck> = Duck.entries.shuffled().take(MAX_NUMBER_OF_DUCKS).toSet()

    fun generateMapOfDucks(): Map<Duck, String> = generateSetOfDucks().associateWith { it.getDescription() }
}
