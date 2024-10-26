package dev.skripts.command;

import dev.skripts.gui.ConfigScreen
import gg.essential.api.EssentialAPI
import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler

object SkriptsCommand : Command("skripts") {

    override val commandAliases = setOf(Alias("sk"))

    @DefaultHandler
    fun handle() {
        EssentialAPI.getGuiUtil().openScreen(ConfigScreen())
    }

}
