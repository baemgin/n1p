package dev.baemgin.event

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class InPlayer : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        event.joinMessage(null)

        val player = event.player
        val url = "https://github.com/baemgin/n1p/releases/download/ResourcePack/CustomGUI.zip"
        val hash = ""
        player.setResourcePack(url,hash)

        player.sendMessage(Component.text("하이염", NamedTextColor.GREEN))

        val ping = player.ping
        val color = when {
            ping < 50 -> NamedTextColor.GREEN
            ping < 150 -> NamedTextColor.YELLOW
            else -> NamedTextColor.RED
        }
        val status = when {
            ping < 50 -> "좋음"
            ping < 150 -> "보통"
            else -> "나쁨"
        }

        player.sendMessage(Component.text("당신의 핑은 $status 입니다 (${ping}ms)", color))
        if (player.name == "baemgin"){
            player.displayName(Component.text("관리자", NamedTextColor.GOLD))
            player.playerListName(Component.text("관리자", NamedTextColor.GOLD))
            player.sendMessage(Component.text("관리자가 들어왔습니다!", NamedTextColor.GOLD))
        }
    }

}
