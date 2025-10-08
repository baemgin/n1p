package dev.baemgin

import dev.baemgin.cmd.MangCmd
import dev.baemgin.event.InPlayer
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.plugin.java.JavaPlugin
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import dev.baemgin.menu.Ce
import dev.baemgin.cmd.Menutest1
import dev.baemgin.menu.yseno


class ttt : JavaPlugin(), org.bukkit.command.CommandExecutor {

    companion object {
        lateinit var instance: ttt
            private set
    }

    override fun onEnable() {
        // Plugin startup logic

        instance = this
        getCommand("menu")?.setExecutor(this)
        getCommand("menutest1")?.setExecutor(Menutest1())
        getCommand("mang")?.setExecutor(MangCmd(this))
        server.pluginManager.registerEvents(Ce(), this)
        server.pluginManager.registerEvents(InPlayer(), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (sender !is Player) {
            sender.sendMessage("플레이어만 사용할 수 있어요!")
            return true
        }

        if (command.name.equals("menu", ignoreCase = true)) {
            sender.sendMessage("메뉴 커맨드 실행됨!")
            yseno().menu(sender, Component.text("산치핀치산치핀치산치핀치"), listOf(Component.text("테스트")), { yesa: Boolean ->
                    if (yesa){
                        sender.sendMessage(Component.text("라이센스에 동의하셨습니다.", NamedTextColor.GREEN))
                    }
                })
            sender.displayName(Component.text("바보멍청이"))
            sender.playerListName((Component.text("바보멍청이")))
            return true
        }

        return false
    }


}
