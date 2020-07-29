package com.kh.portfolio.board.vo;

import java.sql.Clob;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardVO {

	private long bnum;//BNUM	NUMBER(10,0)	No		1	게시글 번호
	private BoardCategoryVO boardCategoryVO; //BCATEGORY	NUMBER(10,0)	Yes		2	분류
  private String btitle;//	BTITLE	VARCHAR2(150 BYTE)	Yes		3	제목
  private String bid;//	BID	VARCHAR2(40 BYTE)	Yes		4	작성자ID
  private String bnickname;//	BNICKNAME	VARCHAR2(30 BYTE)	Yes		5	작성자별칭
  private Timestamp bcdate;//	BCDATE	TIMESTAMP(6)	Yes	systimestamp 	6	작성일
  private Timestamp budate;//	BUDATE	TIMESTAMP(6)	Yes	systimestamp 	7	수정일
  private String bcontent;//	BCONTENT	CLOB	Yes		8	본문내용
  private int bgroup;//	BGROUP	NUMBER(5,0)	Yes		9	본문그룹
  private int bindent;//	BINDENT	NUMBER(5,0)	Yes		10	들여쓰기
  private int bhit;//	BHIT	NUMBER(5,0)	Yes	0 	11	조회수
//	COLUMN1	VARCHAR2(20 BYTE)	Yes		12	임시1
//	COLUMN2	VARCHAR2(20 BYTE)	Yes		13	임시2
//	COLUMN3	VARCHAR2(20 BYTE)	Yes		14	임시3
}
