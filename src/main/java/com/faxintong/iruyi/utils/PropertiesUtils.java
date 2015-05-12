package com.faxintong.iruyi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * PropertiesUtils
 * 
 * @author Lynch 2014-09-15
 *
 */
public class PropertiesUtils {

	private static ResourceBundle prop; // conf.properties
	private static Map<String, ResourceBundle> props = new HashMap<String, ResourceBundle>(); // other properties files
	static {
		prop = ResourceBundle.getBundle("hx");
	}

	/**
	 * hx.properties中取得配置信息
	 * @param key
	 * @return
	 */
	public static String getHxValue(String key) {
		if (prop == null) {
			prop = ResourceBundle.getBundle("hx", Locale.getDefault());
			props.put("hx", prop);
		}
		return prop.getString(key);
	}

}
