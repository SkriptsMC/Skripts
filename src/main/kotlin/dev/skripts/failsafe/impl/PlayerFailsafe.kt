package dev.skripts.failsafe.impl

import dev.skripts.failsafe.Failsafe
import dev.skripts.failsafe.Type

class PlayerFailsafe : Failsafe(Type.PLAYER) {

    companion object {
        val instance = PlayerFailsafe()
    }

}