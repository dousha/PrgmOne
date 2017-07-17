package com.minexf.prgmone.peripherals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;
import org.bukkit.inventory.ItemStack;

public class DiskPlayer implements Peripheral {
	
	public DiskPlayer(Block b, File root)
	{
		if(b.getType() != Material.JUKEBOX)
		{
			throw new IllegalArgumentException();
		}
		_box = (Jukebox) b;
		_root = root;
	}
	
	/**
	 * Get current disk volume.
	 * @return disk volume in KiB
	 */
	public int GetVolume()
	{
		Material disk = _box.getPlaying();
		
		switch(disk)
		{
		case AIR:
		case RECORD_11:
			return 0;
		case RECORD_3:
			return 2;
		case RECORD_4:
			return 4;
		case RECORD_5:
			return 8;
		case RECORD_6:
			return 16;
		case RECORD_7:
			return 32;
		case RECORD_8:
			return 64;
		case RECORD_9:
			return 128;
		case RECORD_10:
			return 256;
		case RECORD_12:
			return 512;
		case GREEN_RECORD:
			return 1024;
		case GOLD_RECORD:
			return 2048;
		default:
			return 0;
		}
	}
	
	@Override
	public String Talk(String say) {
		if(say.startsWith("print"))
		{
			
		}
		else if(say.startsWith("read"))
		{
			
		}
		else if(say.equals("fprobe"))
		{
			return String.valueOf(GetVolume());
		}
		else if(say.startsWith("fread"))
		{
			
		}
		else if(say.startsWith("fwrite"))
		{
			
		}
		return null;
	}
	
	@Override
	public int GetID()
	{
		return 1;
	}
	
	public void InsertDisk(ItemStack disk)
	{
		// i have to trust the disk is legit
		_disk = disk;
		_LoadFile();
	}
	
	public byte[] ReadBytes(long offset, int length)
	{
		if(_file != null)
		{
			byte[] result = new byte[length];
			try {
				RandomAccessFile rnd = new RandomAccessFile(_file, "r");
				rnd.seek(offset);
				rnd.read(result, 0, length);
				rnd.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
		else
		{
			return null;
		}
	}
	
	private void _LoadFile()
	{
		String filename = _disk.getItemMeta().getLore().get(0);
		_file = new File(_root, filename);
	}
	
	private Jukebox _box;
	private final File _root;
	private ItemStack _disk;
	private File _file;
	
}
