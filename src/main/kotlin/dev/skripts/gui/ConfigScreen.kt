package dev.skripts.gui

import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.WindowScreen
import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.components.UIContainer
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.dsl.*
import gg.essential.elementa.effects.ScissorEffect
import java.awt.Color

class ConfigScreen : WindowScreen(
    version = ElementaVersion.V5,
    drawDefaultBackground = false,
) {
    private val container by UIContainer().constrain {
        x = CenterConstraint()
        y = CenterConstraint()
        width = 85.percent
        height = 75.percent
        radius = 5.percent
    } childOf window effect ScissorEffect()

    private val topbar by UIBlock().constrain {
        x = CenterConstraint()
        width = 100.percent
        height = 10.percent
    }.setColor(Color(176, 69, 214)) childOf container

    private val background by UIBlock().constrain {
        x = CenterConstraint()
        y = 10.percent
        width = 100.percent
        height = 90.percent
    }.setColor(Color(69, 69, 69)) childOf container
}