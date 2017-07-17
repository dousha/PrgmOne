package com.minexf.prgmone.vm;

import java.io.File;
import java.io.IOException;

public class StorageManager {
	
	public StorageManager(File file)
	{
		_base = file;
	}
	
	public File GetBase()
	{
		return _base;
	}
	
	public File GetDisk(String id)
	{
		// id should be like <creator>-<diskid>.bin
		File f = new File(_base, "disks/" + id + ".bin");
		if(f.exists()) return f;
		else return null;
	}
	
	public File NewDisk(String player)
	{
		File f = new File(_base, "disks/" + java.util.UUID.randomUUID().toString() + ".bin");
		if(f.exists()) return NewDisk(player);
		try 
		{
			f.createNewFile();
		}
		catch (IOException ex)
		{
			ex.printStackTrace(); // this shouldn't happen
		}
		return f;
	}
	
	private final File _base;
}
