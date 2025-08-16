package dev.baemgin.cmd

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta


class Menutest1 : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("플레이어만 사용할 수 있어요!")
            return true
        }

        if (command.name.equals("menutest1", ignoreCase = true)){
            val inv = Bukkit.createInventory(null,9, Component.text("\uEFFF\uE001", NamedTextColor.WHITE))

            val tp = ItemStack(Material.DIAMOND)
            val tpmat : ItemMeta = tp.itemMeta!!
            tpmat.displayName(Component.text("메인로비로 텔레포트", NamedTextColor.GREEN))
            tp.itemMeta = tpmat

            inv.setItem(1,tp)
            sender.openInventory(inv)
            return true
        }

        return false
    }
}