package dev.skripts.failsafe.impl

import dev.skripts.failsafe.Failsafe
import dev.skripts.failsafe.Type

class DisconnectFailsafe : Failsafe(Type.DISCONNECT) {

    companion object {
        val instance = DisconnectFailsafe()
    }

}