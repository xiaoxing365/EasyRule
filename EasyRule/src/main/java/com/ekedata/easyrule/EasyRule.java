package com.ekedata.easyrule;
/**
 * Description: Manage game rules easily
 * Author: EkeData
 * Date: 2023/7/26
 * 免费开源插件请严格遵守Apache协议
 * 该插件由ChatGPT合作完成，无任何借鉴
 */

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EasyRule extends JavaPlugin implements CommandExecutor, TabCompleter {

    @Override
    public void onEnable() {
        // 注册指令执行器和补全器
        getCommand("easyrule").setExecutor(this);
        getCommand("easyrule").setTabCompleter(this);

        // 插件成功加载提示信息
        getLogger().info("§a插件加载成功！");
    }

    @Override
    //关闭服务器时输出的内容或者命令
    public void onDisable() {

        // 发送卸载的提示消息（红色）
        getLogger().info("§c插件已卸载！");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // 检查是否为控制台或是否拥有管理权限
        //这里如果担心被刷OP可以根据自身经验进行修改
        if (!(sender instanceof Player) || !sender.isOp()) {
            sender.sendMessage("§c你没有权限执行该指令！");
            return true;
        }

        // 检查指令是否为 /easyrule
        if (command.getName().equalsIgnoreCase("easyrule")) {
            // 检查参数数量
            if (args.length < 2) {
                sender.sendMessage("§e正确用法：/easyrule <规则名称> <true|false>");
                return true;
            }

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
                    sender.sendMessage("§a已" + (value ? "启用" : "禁用") + "苦力怕爆炸！");
                    break;
                case "死亡不掉落":
                    player.getWorld().setGameRuleValue("keepInventory", String.valueOf(value));
                    sender.sendMessage("§a已" + (value ? "启用" : "禁用") + "死亡不掉落！");
                    break;
                default:
                    sender.sendMessage("§c无效的规则！");
                    sender.sendMessage("§e可用的规则：苦力怕爆炸、凋灵爆炸、死亡不掉落");
                    break;
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
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
