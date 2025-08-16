package dev.baemgin.menu

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

class yseno {
    var yesb: ((Boolean) -> Unit)? = null

    fun menu(player: Player , name: Component , lore: List<Component>, yes: ((Boolean) -> Unit)){
        yesb = yes

        val inv = Bukkit.createInventory(null, 54, Component.text( "\uEFFF\uE000", NamedTextColor.WHITE))

        val maintp = ItemStack(Material.DIAMOND)
        val maintpme : ItemMeta = maintp.itemMeta!!
        maintpme.displayName(name)

        maintpme.lore(lore)  // <- 이렇게 컴포넌트 리스트로 넣기
        maintp.itemMeta = maintpme

        val slots = listOf(10,11,12,19,20,21,28,29,30)

        for (slot in slots) {
            inv.setItem(slot, maintp)
        }
        player.openInventory(inv)
    }
}