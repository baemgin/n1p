package dev.baemgin.menu

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import dev.baemgin.menu.yseno

class Ce : Listener {
    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        val clickedInv = event.view.topInventory
        val player = event.whoClicked as Player
        val title = PlainTextComponentSerializer.plainText().serialize(event.view.title())

        // 인벤토리 이름(타이틀) 체크해서 내가 만든 UI인지 확인
        if (title == "\uEFFF\uE000") {
            event.isCancelled = true  // 아이템 못빼게 막기

            val clickedItem = event.currentItem ?: return
            if (clickedItem.type == Material.DIAMOND) {
                yseno().yesb?.invoke(true)
                player.closeInventory() // 클릭하면 UI 닫기
            }
        } else if (title =="\uEFFF\uE001"){
            event.isCancelled = true

            val item = event.currentItem ?: return
            if (item.type == Material.DIAMOND) {
                player.closeInventory() // 클릭하면 UI 닫기
                yseno().menu(player, Component.text("텔레포트"), listOf(Component.text("텔레포트")), {ysea: Boolean ->
                    player.sendMessage("동의했다")
                })
            }
        }
    }

}