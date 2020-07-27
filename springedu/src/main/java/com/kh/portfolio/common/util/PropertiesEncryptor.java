package com.kh.portfolio.common.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class PropertiesEncryptor {

	public static void main(String[] args) {
		StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor();
		//암호키
		enc.setPassword("qwer");
		
		//db암호화
		System.out.println(enc.encrypt("oracle.jdbc.driver.OracleDriver"));
		System.out.println(enc.encrypt("jdbc:oracle:thin:@127.0.0.1:1521:XE"));
		System.out.println(enc.encrypt("portfolio"));
		System.out.println(enc.encrypt("portfolio1234"));
		
		//mail암호화
		System.out.println(enc.encrypt("ehowltmdduq@gmail.com"));
		System.out.println(enc.encrypt("@ehowl12280"));
		
		//복호화
		System.out.println(enc.decrypt(""));
	}

}