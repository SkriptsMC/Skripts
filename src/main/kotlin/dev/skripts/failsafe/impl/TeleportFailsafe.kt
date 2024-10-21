package dev.skripts.failsafe.impl

import dev.skripts.failsafe.Failsafe
import dev.skripts.failsafe.Type

class TeleportFailsafe : Failsafe(Type.TELEPORT) {

    companion object {
        val instance = TeleportFailsafe()
    }

}