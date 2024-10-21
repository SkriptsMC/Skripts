package dev.skripts.failsafe.impl

import dev.skripts.failsafe.Failsafe
import dev.skripts.failsafe.Type

class WorldChangeFailsafe : Failsafe(Type.WORLD_CHANGE) {

    companion object {
        val instance = WorldChangeFailsafe()
    }

}