package com.ekedata.easyrule.cmds;

import com.ekedata.easyrule.EasyRule;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Tab implements TabCompleter {

    Plugin main = EasyRule.getProvidingPlugin(EasyRule.class);

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender,@NotNull Command command,@NotNull String alias,@NotNull String[] args) {
        // 提供Tab补全选项
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            completions.add("爆炸保护");
            completions.add("死亡不掉落");
            completions.add("在公告区显示玩家进度");
            completions.add("命令方块执行时显示");
            completions.add("让服务器停止检查使用鞘翅的玩家的移动速度");
            completions.add("是否禁用袭击");
            completions.add("是否进行日夜交替和月相变化");
            completions.add("非生物实体是否掉落物品");
            completions.add("火是否蔓延及自然熄灭");
            completions.add("幻翼是否在夜晚生成");
        }
        if (args.length == 2) {
            completions.add("true");
            completions.add("false");
        }
        return completions;
    }
}
