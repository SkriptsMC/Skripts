package dev.skripts.command;

import dev.skripts.gui.openGui
import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler
import gg.essential.api.commands.SubCommand

object SkriptsCommand : Command("skripts") {

    override val commandAliases = setOf(Alias("sk"))

    @DefaultHandler
    fun handle() {
        openGui()
    }

}
