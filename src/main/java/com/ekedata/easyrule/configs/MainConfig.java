package com.ekedata.easyrule.configs;

import com.ekedata.easyrule.EasyRule;
import org.bukkit.plugin.Plugin;


public class MainConfig {
    Plugin main = EasyRule.getProvidingPlugin(EasyRule.class);
    private boolean EnableGui;
    public boolean getEnableGui() {
        return main.getConfig().getBoolean("EnableGui");
    }
}
