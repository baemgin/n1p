package dev.baemgin.menu

import dev.baemgin.ttt
import io.github.monun.invfx.InvFX.frame
import io.github.monun.invfx.frame.InvFrame
import io.github.monun.invfx.openFrame
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import org.bukkit.scheduler.BukkitRunnable

class Mang: Listener {
    fun generateInventory(player: Player) {
        var invFrame: InvFrame? = null  // 👉 nullable로 선언

        invFrame = frame(1, Component.text("SAMPLE_INVENTORY")) {
            var clicked = false

            onOpen { openEvent ->
                openEvent.player.sendMessage("You opened the inventory")
            }

            onClose { closeEvent ->
                if (!clicked) {
                    closeEvent.player.sendMessage("Please click the diamond")
                    object : BukkitRunnable() {
                        override fun run() {
                            // invFrame이 null 아닐 때만 열기
                            invFrame?.let { player.openFrame(it) }
                        }
                    }.runTaskLater(ttt.instance,1)
                }
            }

            slot(0, 0) {
                item = ItemStack(Material.DIAMOND)
                onClick { clickEvent ->
                    clicked = true
                    clickEvent.whoClicked.closeInventory()
                }
            }
        }

        player.openFrame(invFrame!!)
    }
}