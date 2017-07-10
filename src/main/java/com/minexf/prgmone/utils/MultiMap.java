package com.minexf.prgmone.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiMap<K, V> {
	
	public MultiMap()
	{
		_map = new HashMap<K, ArrayList<V>>();
	}
	
	public void put(K k, V v)
	{
		if(!_map.containsKey(k)) _map.put(k, new ArrayList<V>());
		_map.get(k).add(v);
	}
	
	public void put(K k, ArrayList<V> v)
	{
		if(_map.containsKey(k)) _map.get(k).addAll(v);
		else _map.put(k, v);
	}
	
	public ArrayList<V> get(K k)
	{
		if(_map.containsKey(k))
			return _map.get(k);
		else
			return null;
	}
	
	public V getFirst(K k)
	{
		if(_map.containsKey(k))
			return _map.get(k).get(0);
		else
			return null;
	}
	
	private HashMap<K, ArrayList<V>> _map;
}
