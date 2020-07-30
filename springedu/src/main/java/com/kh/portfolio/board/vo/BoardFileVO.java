package com.kh.portfolio.board.vo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardFileVO {
	private long fid;
	private long bnum;
	private String fname;
	private long fsize;
	private String ftype;
	private byte[] fdata;
	private Timestamp cdate;
	private Timestamp udate;
	
	//첨부파일
	private List<MultipartFile> files;
}
