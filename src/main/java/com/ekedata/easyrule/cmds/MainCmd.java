package com.ekedata.easyrule.cmds;

import com.ekedata.easyrule.EasyRule;
import com.ekedata.easyrule.utils.CustomColor;
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
            sender.sendMessage(CustomColor.RED()+"此指令只能由玩家发送！");
            return true;
        }
        //这里如果担心被刷 OP 可以根据自身经验进行修改
        if (!sender.isOp()){
            sender.sendMessage(CustomColor.RED()+"你没有权限执行该指令！");
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
                sender.sendMessage(CustomColor.RED()+"请输入有效值！");
                return true;
            }

            // 根据规则名称执行相应操作
            switch (rule) {
                case "爆炸保护":{
                    player.getWorld().setGameRuleValue("mobGriefing", String.valueOf(value));
                    sender.sendMessage(CustomColor.BLUE() +"已" + (value ? CustomColor.BLUE() +"启用" : CustomColor.BLUE() +"禁用") + CustomColor.BLUE() +"爆炸保护！");
                    break;
                }
                case "死亡不掉落":{
                    player.getWorld().setGameRuleValue("keepInventory", String.valueOf(value));
                    sender.sendMessage(CustomColor.BLUE() +"已" + (value ? CustomColor.BLUE() +"启用" : CustomColor.BLUE() +"禁用") +CustomColor.BLUE()+"死亡不掉落！");
                    break;
                }
                case "在公告区显示玩家进度":{
                    player.getWorld().setGameRuleValue("announceAdvancements", String.valueOf(value));
                    sender.sendMessage(CustomColor.BLUE() +"已" + (value ? CustomColor.BLUE() +"启用" : CustomColor.BLUE() +"禁用") +CustomColor.BLUE()+"在公告区显示玩家进度！");
                    break;
                }
                case "命令方块执行时显示":{
                    player.getWorld().setGameRuleValue("commandBlockOutput", String.valueOf(value));
                    sender.sendMessage(CustomColor.BLUE() +"已" + (value ? CustomColor.BLUE() +"启用" : CustomColor.BLUE() +"禁用") +CustomColor.BLUE()+"命令方块执行时显示！");
                    break;
                }
                case "让服务器停止检查使用鞘翅的玩家的移动速度":{
                    player.getWorld().setGameRuleValue("disableElytraMovementCheck", String.valueOf(value));
                    sender.sendMessage(CustomColor.BLUE() +"已" + (value ? CustomColor.BLUE() +"启用" : CustomColor.BLUE() +"禁用") +CustomColor.BLUE()+"让服务器停止检查使用鞘翅的玩家的移动速度！");
                    break;
                }
                case "是否禁用袭击":{
                    player.getWorld().setGameRuleValue("disableRaids", String.valueOf(value));
                    sender.sendMessage(CustomColor.BLUE() +"已" + (value ? CustomColor.BLUE() +"启用" : CustomColor.BLUE() +"禁用") +CustomColor.BLUE()+"是否禁用袭击！");
                    break;
                }
                case "是否进行日夜交替和月相变化":{
                    player.getWorld().setGameRuleValue("doDaylightCycle", String.valueOf(value));
                    sender.sendMessage(CustomColor.BLUE() +"已" + (value ? CustomColor.BLUE() +"启用" : CustomColor.BLUE() +"禁用") +CustomColor.BLUE()+"是否进行日夜交替和月相变化！");
                    break;
                }
                case "非生物实体是否掉落物品":{
                    player.getWorld().setGameRuleValue("doEntityDrops", String.valueOf(value));
                    sender.sendMessage(CustomColor.BLUE() +"已" + (value ? CustomColor.BLUE() +"启用" : CustomColor.BLUE() +"禁用") +CustomColor.BLUE()+"非生物实体是否掉落物品！");
                    break;
                }
                case "火是否蔓延及自然熄灭":{
                    player.getWorld().setGameRuleValue("doFireTick", String.valueOf(value));
                    sender.sendMessage(CustomColor.BLUE() +"已" + (value ? CustomColor.BLUE() +"启用" : CustomColor.BLUE() +"禁用") +CustomColor.BLUE()+"火是否蔓延及自然熄灭！");
                    break;
                }
                case "幻翼是否在夜晚生成":{
                    player.getWorld().setGameRuleValue("doInsomnia", String.valueOf(value));
                    sender.sendMessage(CustomColor.BLUE() +"已" + (value ? CustomColor.BLUE() +"启用" : CustomColor.BLUE() +"禁用") +CustomColor.BLUE()+"幻翼是否在夜晚生成！");
                    break;
                }
                default:{
                    sender.sendMessage(CustomColor.RED() +"无效的规则！");
                    sender.sendMessage(CustomColor.YELLOW() +"可用的规则：爆炸保护、死亡不掉落");
                    break;
                }
            }
        }
        return true;
    }
}
