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
        }
        if (args.length == 2) {
            completions.add("true");
            completions.add("false");
        }
        return completions;
    }
}
