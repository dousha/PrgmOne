package com.minexf.prgmone;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The entry of the plugin.
 * This class also registers every event listener.
 * @author dousha
 * @since 0.1-alpha
 */
public class PrgmOne extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable()
	{
		
	}
}
