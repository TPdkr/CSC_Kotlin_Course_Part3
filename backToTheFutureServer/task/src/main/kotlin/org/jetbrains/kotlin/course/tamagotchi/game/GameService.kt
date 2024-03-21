package org.jetbrains.kotlin.course.tamagotchi.game

import org.jetbrains.kotlin.course.tamagotchi.models.Command
import org.jetbrains.kotlin.course.tamagotchi.models.Mode
import org.springframework.stereotype.Service

@Service
class GameService {
    companion object {
        private const val MAX_CAPACITY = 16
    }
    val commands= ArrayDeque<Command>()

    fun addCommand(command: Command): Boolean {
        if(commands.size< MAX_CAPACITY){
            commands.add(command)
            return true
        }
        return false
    }

    fun getCommand(mode: Mode): Command? {
        if(commands.isEmpty()){
            return null
        }
        val newCommand: Command
        if(mode==Mode.Queue){
            newCommand=commands.first()
            commands.removeFirst()
        } else{
            newCommand=commands.last()
            commands.removeLast()
        }
        return newCommand
    }
}
