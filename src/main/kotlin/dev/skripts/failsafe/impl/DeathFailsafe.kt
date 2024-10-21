package dev.skripts.failsafe.impl

import dev.skripts.failsafe.Failsafe
import dev.skripts.failsafe.Type

class DeathFailsafe : Failsafe(Type.DEATH) {

    companion object {
        val instance = DeathFailsafe()
    }

}