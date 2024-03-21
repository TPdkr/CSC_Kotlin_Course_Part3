package org.jetbrains.kotlin.course.duck.shop.functions.action

import org.jetbrains.kotlin.course.duck.shop.duck.Duck
import org.springframework.stereotype.Service

@Service
class GameActionFunctionsService {

    fun List<Duck>.shuffleDucks(): List<Duck> = toMutableList().shuffled()

    fun List<Duck>.sortDucks(): List<Duck> =toMutableList().sortedBy{if (it.hasKotlinAttribute)  it.accessories.sumOf{it.price}*100 else it.accessories.sumOf{it.price}} .reversed()

    fun Collection<Duck>.deleteDucksWithoutKotlinStuff(): Collection<Duck> = filter { it.hasKotlinAttribute }

    fun Map<Duck, String>.deleteDucksWithoutKotlinStuff(): Map<Duck, String> = filter{(key, value)-> key.hasKotlinAttribute}

    fun Collection<Duck>.divideDucksIntoKotlinAndNonKotlin(): Pair<Collection<Duck>, Collection<Duck>> = partition{it.hasKotlinAttribute}
}
