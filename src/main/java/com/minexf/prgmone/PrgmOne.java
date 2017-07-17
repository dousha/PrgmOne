package com.minexf.prgmone;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.minexf.prgmone.peripherals.DiskPlayer;
import com.minexf.prgmone.peripherals.PeripheralManager;
import com.minexf.prgmone.vm.StorageManager;
import com.minexf.prgmone.vm.VirtualMachine;
import com.minexf.prgmone.vm.opcodes.OpcodeIndexer;

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
		_ins = new OpcodeIndexer();
		_store = new StorageManager(getDataFolder());
		_mgr = new VMManager(_ins);
		_pmgr = new PeripheralManager(this, _store);
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable()
	{
		
	}
	
	@EventHandler
	public void onDiskInsert(PlayerInteractEvent e)
	{
		if(!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
		if(!e.getClickedBlock().getType().equals(Material.JUKEBOX)) return;
		if(!e.getItem().getItemMeta().hasLore()) return;
		// i don't care if it's a disc
		// because there's too much!
		// if the lore matches, i don't care if it's a disc or a dead bush!
		// there should be 3 lines of lore....
		List<String> lore = e.getItem().getItemMeta().getLore();
		if(lore.size() != 3) return;
		DiskPlayer p = new DiskPlayer(e.getClickedBlock(), _store.GetBase());
		p.InsertDisk(e.getItem());
		_pmgr.Register(e.getClickedBlock(), p);
	}
	
	@EventHandler
	public void onBookSmashingOnTable(BlockDamageEvent e)
	{
		if(e.getInstaBreak()) return;
		ItemStack book = e.getItemInHand();
		Block table = e.getBlock();
		if(!(book.getType().equals(Material.BOOK))
				|| (book.getType().equals(Material.BOOK_AND_QUILL)))
				return;
		if(!table.getType().equals(Material.ENCHANTMENT_TABLE))
			return;
		Player p = e.getPlayer();
		if(!p.hasPermission("prgmone.use")) return;
		p.sendMessage("Now creating VM...");
		VirtualMachine vm = _mgr.Create(table);
		vm.LoadCodeFromBook(book);
		p.sendMessage("Now starting code...");
		vm.run();
	}
	
	private StorageManager _store;
	private VMManager _mgr;
	private PeripheralManager _pmgr;
	private OpcodeIndexer _ins;
}
