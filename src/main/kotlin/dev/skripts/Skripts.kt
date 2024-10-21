package dev.skripts

import dev.skripts.failsafe.FailsafeManager
import net.minecraft.client.Minecraft
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(
    modid = "skripts",
    name = "Skripts",
    version = "1.0.0",
    acceptedMinecraftVersions = "[1.8.9]",
    modLanguageAdapter = "gg.essential.api.utils.KotlinAdapter",
    clientSideOnly = true
)
object Skripts {

    private val mc: Minecraft = Minecraft.getMinecraft()

    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {
        FailsafeManager.initialize()
        MinecraftForge.EVENT_BUS.register(this)
    }

}