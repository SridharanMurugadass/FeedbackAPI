package com.weeroda.feedback.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(HashingService.class);

	public static String encodeValue(String value) {

		StringBuffer sb = null;

		try {

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(value.getBytes());

			byte byteData[] = md.digest();

			sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

		} catch (NoSuchAlgorithmException e) {

			LOGGER.error("NoSuchAlgorithmException with message : " + e.getMessage());
		}

		return sb.toString();
	}

}