package com.kh.portfolio.member.vo;


import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;


 @Data
public class MemberVO {

	private String    id;
	private String    pw;
	private String    tel;
	private String    nickname;
	private String    gender;
	private String    region;
	private Date      birth;
	private Timestamp cdate;
	private Timestamp udate;
	
	//회원 이미지 처무용
	//PIC
	
}
