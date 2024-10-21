package dev.skripts.failsafe.impl

import dev.skripts.failsafe.Failsafe
import dev.skripts.failsafe.Type

class KnockbackFailsafe : Failsafe(Type.KNOCKBACK) {

    companion object {
        val instance = KnockbackFailsafe()
    }

}