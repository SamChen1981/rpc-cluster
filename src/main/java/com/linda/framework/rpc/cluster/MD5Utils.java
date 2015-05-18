package com.linda.framework.rpc.cluster;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class MD5Utils {
    private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7',
                                    '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String md5(String source) {
		try {
			byte[] bytes = md5(source.getBytes("utf-8"));
	        char str[] = new char[bytes.length * 2];
	        int k = 0;
	        for (int i = 0; i < bytes.length; i++) {
	            byte byte0 = bytes[i];
	            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	            str[k++] = hexDigits[byte0 & 0xf];
	        }
	        return new String(str);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
    }

    private static byte[] md5(byte[] source) {
        byte[] result = new byte[0];
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            result = md.digest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
