package dev.skripts.failsafe

import dev.skripts.failsafe.impl.*
import net.minecraft.client.Minecraft
import net.minecraftforge.client.event.ClientChatReceivedEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientDisconnectionFromServerEvent

object FailsafeManager {

    private var failsafes: List<Failsafe>? = null;
    private var mc = Minecraft.getMinecraft()

    fun initialize() {
        failsafes = listOf(
            BedrockFailsafe.instance,
            DeathFailsafe.instance,
            DisconnectFailsafe.instance,
            EvacuateFailsafe.instance,
            FullInventoryFailsafe.instance,
            ItemChangeFailsafe.instance,
            KnockbackFailsafe.instance,
            PlayerFailsafe.instance,
            RotationFailsafe.instance,
            TeleportFailsafe.instance,
            WorldChangeFailsafe.instance
        )

        MinecraftForge.EVENT_BUS.register(this)
        failsafes!!.forEach { MinecraftForge.EVENT_BUS.register(it) }
    }

    @SubscribeEvent
    fun onTick(event: ClientTickEvent) {
        if (mc.theWorld == null || mc.thePlayer == null) return
        failsafes!!.forEach { it.onTick(event) }
    }

    @SubscribeEvent
    fun onDisconnect(event: ClientDisconnectionFromServerEvent) {
        failsafes!!.forEach { it.onDisconnect(event) }
    }

    @SubscribeEvent
    fun onChat(event: ClientChatReceivedEvent) {
        failsafes!!.forEach { it.onChat(event) }
    }


}

enum class Type constructor(val priority: Int) {
    TELEPORT(5),
    ROTATION(4),
    WORLD_CHANGE(2),
    KNOCKBACK(4),
    BEDROCK(1),
    DISCONNECT(1),
    ITEM_CHANGE(3),
    PLAYER(2),
    FULL_INVENTORY(3),
    DEATH(3),
    EVACUATE(1)
}

abstract class Failsafe constructor(val type: Type) {

    fun onTick(event: ClientTickEvent) {}
    fun onChat(event: ClientChatReceivedEvent) {}
    fun onDisconnect(event: ClientDisconnectionFromServerEvent) {}

    fun name(): String {
        return type.name.lowercase().replace("_", " ").split(" ").joinToString(" ") { it.capitalize() }
    }

    fun priority(): Int {
        return type.priority
    }

}