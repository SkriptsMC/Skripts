package dev.skripts.failsafe.impl

import dev.skripts.failsafe.Failsafe
import dev.skripts.failsafe.Type

class BedrockFailsafe : Failsafe(Type.BEDROCK) {

    companion object {
        val instance = BedrockFailsafe()
    }

}