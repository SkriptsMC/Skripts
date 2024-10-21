package dev.skripts.failsafe.impl

import dev.skripts.failsafe.Failsafe
import dev.skripts.failsafe.Type

class RotationFailsafe : Failsafe(Type.ROTATION) {

    companion object {
        val instance = RotationFailsafe()
    }

}