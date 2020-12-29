package com.project.demo.config;

import java.math.BigInteger;
import java.security.MessageDigest;

// CLASS UNTUK GENERATOR HASH PASSWORD MENGGUNAKAN MD5

public class MD5Generator {
	public static String generate(String plain) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md.digest(plain.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hash = no.toString(16);
		while (hash.length() < 32) {
			hash = "0" + hash;
		}
		return hash;
	}
}
