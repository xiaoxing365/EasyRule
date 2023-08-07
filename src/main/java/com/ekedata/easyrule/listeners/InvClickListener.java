package com.ekedata.easyrule.listeners;

import com.ekedata.easyrule.cmds.GameRuleGui;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClickListener implements Listener {
    @EventHandler
    public void InvClickEvent(InventoryClickEvent event){
            if (event.getView().getTitle().equalsIgnoreCase("§bEasyRule服务器规则配置界面")){
                event.setCancelled(true);
                if (event.getCurrentItem().getType().equals(Material.BLACK_WOOL)){
                    Player player = (Player) event.getWhoClicked();
                    //GameRuleGui
                }
            }
    }
}
