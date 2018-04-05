package com.libo.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Util {
	public static final long pageSize=2;
	//map<byte> ---  map<String>
	public static Map<String, String> mapToMap(Map<byte[], byte[]> maps){
		Iterator<Entry<byte[], byte[]>> i=maps.entrySet().iterator();
		Map<String, String> map=new HashMap<String, String>();
		while(i.hasNext()){
			Entry<byte[], byte[]> en=i.next();
			map.put(new String(en.getKey()), new String(en.getValue()));
		}
		return map;
	}
}
