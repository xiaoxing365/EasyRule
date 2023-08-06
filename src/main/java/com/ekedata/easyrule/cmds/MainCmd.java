package com.ekedata.easyrule.cmds;

import com.ekedata.easyrule.EasyRule;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class MainCmd implements CommandExecutor {

    Plugin main = EasyRule.getProvidingPlugin(EasyRule.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull Command command,@NotNull String label,@NotNull String[] args) {
        // 检查是否为控制台或是否拥有管理权限
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED+"此指令只能由玩家发送！");
            return true;
        }
        //这里如果担心被刷 OP 可以根据自身经验进行修改
        if (!sender.isOp()){
            sender.sendMessage(ChatColor.RED+"你没有权限执行该指令！");
        }

        // 检查指令是否为 /easyrule
        if (command.getName().equalsIgnoreCase("easyrule")) {
            /*检查参数数量
            if (args.length < 2) {
                //sender.sendMessage(ChatColor.YELLOW+"正确用法：/easyrule <规则名称> <true|false>");
                return true;
            }
            */

            // 获取玩家对象和要更改的规则名称和值
            Player player = (Player) sender;
            String rule = args[0].toLowerCase();
            boolean value;
            try {
                value = Boolean.parseBoolean(args[1]);
            } catch (IllegalArgumentException e) {
                sender.sendMessage("§c请输入有效值！");
                return true;
            }

            // 根据规则名称执行相应操作
            switch (rule) {
                case "爆炸保护":
                    player.getWorld().setGameRuleValue("mobGriefing", String.valueOf(value));
                    sender.sendMessage("§a已" + (value ? "§a启用" : "§a禁用") + "§a爆炸保护！");
                    break;
                case "死亡不掉落":
                    player.getWorld().setGameRuleValue("keepInventory", String.valueOf(value));
                    sender.sendMessage("§a已" + (value ? "§a启用" : "§a禁用") +"§a死亡不掉落！");
                    break;
                default:
                    sender.sendMessage("§c无效的规则！");
                    sender.sendMessage("§e可用的规则：爆炸保护、死亡不掉落");
                    break;
            }
        }
        return true;
    }
}
