package com.ekedata.easyrule.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
// import org.jetbrains.annotations.NotNull;
// import org.jetbrains.annotations.Nullable;

public class SendUtil {
    public static void sendToPlayer( CustomColor color, Player player, String msg){
        player.sendMessage(color+msg);
    }

    public static void sendToConsole( CustomColor color, String msg){
        Bukkit.getConsoleSender().sendMessage(color+msg);
}
