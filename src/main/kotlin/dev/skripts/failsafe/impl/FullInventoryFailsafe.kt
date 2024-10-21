package dev.skripts.failsafe.impl

import dev.skripts.failsafe.Failsafe
import dev.skripts.failsafe.Type

class FullInventoryFailsafe : Failsafe(Type.FULL_INVENTORY) {

    companion object {
        val instance = FullInventoryFailsafe()
    }

}