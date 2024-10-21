package dev.skripts.failsafe.impl

import dev.skripts.failsafe.Failsafe
import dev.skripts.failsafe.Type

class EvacuateFailsafe : Failsafe(Type.EVACUATE) {

    companion object {
        val instance = EvacuateFailsafe()
    }

}