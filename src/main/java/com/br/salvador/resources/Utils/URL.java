package com.br.salvador.resources.Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */
public class URL {
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
}
