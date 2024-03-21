package org.jetbrains.kotlin.course.old.school.functions

import org.jetbrains.kotlin.course.old.school.photo.Accessory
import org.jetbrains.kotlin.course.old.school.photo.Color
import org.jetbrains.kotlin.course.old.school.photo.PhotoCharacter
import org.springframework.stereotype.Service

@Service
class GameFunctionsService {
    fun getAllPossibleColors() = Color.entries.map { it.name.lowercase() }

    private fun String.capitalize() = replaceFirstChar { it.titlecase() }

    private fun String.toColor() = Color.valueOf(capitalize())

    private fun Iterable<String>.toPhotoCharacters() =
        map { name -> PhotoCharacter.valueOf(name.capitalize()) }

    fun Iterable<String>.findPhoto(colorStr: String) = with(colorStr.toColor()) {
        toPhotoCharacters().find { it.backgroundColor == this }
    }
    fun Iterable<String>.groupPhotosByColor(): List<PhotoCharacter> = toPhotoCharacters().groupBy { it.backgroundColor }.map{it.value.toList()}.flatten()

    fun Iterable<String>.groupPhotosByHairAndHat(): List<PhotoCharacter> = toPhotoCharacters().groupBy { it.hairType }.map{it.value.groupBy { if (it.accessories.isNullOrEmpty())  false else it.accessories.contains(Accessory.Hat)}.map{it.value.toList()}.flatten()}.map{it.toList()}.flatten()
}
