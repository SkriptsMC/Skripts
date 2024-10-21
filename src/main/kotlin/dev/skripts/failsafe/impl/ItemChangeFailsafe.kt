package dev.skripts.failsafe.impl

import dev.skripts.failsafe.Failsafe
import dev.skripts.failsafe.Type

class ItemChangeFailsafe : Failsafe(Type.ITEM_CHANGE) {

    companion object {
        val instance = ItemChangeFailsafe()
    }

}