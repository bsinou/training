package net.sinou.hackerrank.drafts.java;

import java.security.MessageDigest;
import java.util.Scanner;

public class CryptoHash {

	private static void md5(String s) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(s.getBytes());
		byte[] digest = md.digest();
		for (byte b : digest) {
			System.out.printf("%02x", b);
		}
		System.out.println();
	}

	private static void sha256(String s) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(s.getBytes());
		byte[] digest = md.digest();
		for (byte b : digest) {
			System.out.printf("%02x", b);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String str = sc.next().trim();
			md5(str);
			sha256(str);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
