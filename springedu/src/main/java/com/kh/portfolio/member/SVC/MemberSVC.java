package com.kh.portfolio.member.SVC;

import java.sql.Date;
import java.util.List;

import com.kh.portfolio.member.VO.MemberVO;

public interface MemberSVC {
	 //회원등록
		int joinMember(MemberVO memberVO);
		//회원 수정
		int modifyMember(MemberVO memberVO);
		//회원전체 조회
		List<MemberVO>listAllMember();
		//회원 개별 조회
		MemberVO listOneMember(String id);
		//회원탈퇴
		int outMember(String id, String pw);
		//로그인
		MemberVO login(String id, String pw);
		//아이디찾기
		String findId(String tel, Date birth);
		//비밀번호 찾기
		String findPw(String id, Date birth);
		//비밀번호 변경
		int changePw(String id, String prepw, String postpw);
		//프로파일 이미지 조회
		byte[] findProfileImg(String id);
	}

