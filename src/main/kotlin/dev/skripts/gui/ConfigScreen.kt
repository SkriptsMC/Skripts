package dev.skripts.gui

import gg.essential.api.EssentialAPI
import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.WindowScreen
import gg.essential.elementa.components.*
import gg.essential.elementa.components.input.UITextInput
import gg.essential.elementa.constraints.*
import gg.essential.elementa.constraints.animation.Animations
import gg.essential.elementa.dsl.*
import gg.essential.elementa.effects.ScissorEffect
import java.awt.Color

fun openGui() {
    EssentialAPI.getGuiUtil().openScreen(ConfigScreen.instance)
}

class ConfigScreen: WindowScreen(ElementaVersion.V5) {

    companion object {
        val instance = ConfigScreen()
    }

    class StickyNote : UIBlock(Color.BLACK) {
        private var isDragging: Boolean = false
        private var dragOffset: Pair<Float, Float> = 0f to 0f

        private val textArea: UITextInput

        init {
            constrain {
                x = CenterConstraint()
                y = CenterConstraint()
                width = 150.pixels()
                height = 100.pixels()
            }

            onMouseClick {
                parent.removeChild(this)
                parent.addChild(this)
            }

            val topBar = UIBlock(Color.YELLOW).constrain {
                x = 1.pixel()
                y = 1.pixel()
                width = 100.percent() - 2.pixels()
                height = 24.pixels()
            }.onMouseClick { event ->
                isDragging = true
                dragOffset = event.absoluteX to event.absoluteY
            }.onMouseRelease {
                isDragging = false
            }.onMouseDrag { mouseX, mouseY, _ ->
                if (!isDragging) return@onMouseDrag
                val absoluteX = mouseX + getLeft()
                val absoluteY = mouseY + getTop()
                val deltaX = absoluteX - dragOffset.first
                val deltaY = absoluteY - dragOffset.second
                dragOffset = absoluteX to absoluteY
                val newX = this@StickyNote.getLeft() + deltaX
                val newY = this@StickyNote.getTop() + deltaY
                this@StickyNote.setX(newX.pixels())
                this@StickyNote.setY(newY.pixels())
            } childOf this
            UIText("X", shadow = false).constrain {
                x = 4.pixels(alignOpposite = true)
                y = CenterConstraint()
                color = Color.BLACK.toConstraint()
                textScale = 2.pixels()
            }.onMouseEnter {
                animate {
                    setColorAnimation(Animations.OUT_EXP, 0.5f, Color.RED.toConstraint())
                }
            }.onMouseLeave {
                animate {
                    setColorAnimation(Animations.OUT_EXP, 0.5f, Color.BLACK.toConstraint())
                }
            }.onMouseClick { event ->
                this@StickyNote.parent.removeChild(this@StickyNote)
                event.stopPropagation()
            } childOf topBar
            val textHolder = UIBlock(Color(80, 80, 80)).constrain {
                x = 1.pixel()
                y = SiblingConstraint()
                width = RelativeConstraint(1f) - 2.pixels()
                height = FillConstraint()
            } childOf this
            textHolder effect ScissorEffect()
            textArea = (UITextInput(placeholder = "Enter your note...").constrain {
                x = 2.pixels()
                y = 2.pixels()
                height = FillConstraint() - 2.pixels()
            }.onMouseClick {
                grabWindowFocus()
            } childOf textHolder) as UITextInput
        }
    }

}