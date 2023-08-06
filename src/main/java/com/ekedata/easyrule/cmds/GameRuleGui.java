package com.ekedata.easyrule.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GameRuleGui implements CommandExecutor {
    private Player player;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§c此指令只能由管理员发送！");
            return true;
        }
        Player player = (Player) sender;
        //这里如果担心被刷 OP 可以根据自身经验进行修改
        if (!sender.isOp()){
            sender.sendMessage("§c你没有权限执行该指令！");
        }



        if (args.length == 0){
            sender.sendMessage("§e/---------EasyRule--------");
            sender.sendMessage("§e/er gui         打开GUI界面");
            sender.sendMessage("§e或使用指令:/er <规则名称> <true|false>");

            return true;
        }
        if (args.length == 1){
            if (args[0].equalsIgnoreCase("gui")){
                CreateGui();
            }
        }


        return false;
    }

    public void CreateGui(){
        Inventory inv = Bukkit.createInventory(null,54,"§bEasyRule服务器规则配置界面");

        ItemStack disable = new ItemStack(Material.BLACK_WOOL);
        ItemStack enable = new ItemStack(Material.WHITE_WOOL);

        ItemMeta disableMeta = disable.getItemMeta();
        ItemMeta enableMeta = enable.getItemMeta();

        List<String> isenable = new ArrayList<>();
        List<String> isdisable = new ArrayList<>();

        isenable.add(ChatColor.GREEN+"此规则已开启！");
        enableMeta.setLore(isenable);

        isdisable.add(ChatColor.RED+"此规则已关闭！");
        disableMeta.setLore(isdisable);

        for (String gameRule : player.getWorld().getGameRules()) {
            //gameRule.
        }
    }

}
