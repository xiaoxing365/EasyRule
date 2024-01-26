package com.ekedata.easyrule.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SendUtil {
    public static void sendToPlayer(@Nullable CustomColor color,@Nullable Player player,@NotNull String msg){
        player.sendMessage(color+msg);
    }

    public static void sendToConsole(@Nullable CustomColor color,@NotNull String msg){
        Bukkit.getConsoleSender().sendMessage(color+msg);
    }
    public static void sendPlayer(@Nullable Player player,@NotNull String msg){
        player.sendMessage(msg);
    }

    public static void sendConsole(@NotNull String msg){
        Bukkit.getConsoleSender().sendMessage(msg);
    }
}
