package com.kh.portfolio.member.SVC;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.portfolio.member.DAO.MemberDAO;
import com.kh.portfolio.member.VO.MemberVO;

@Service
public class MemberSVCImpl implements MemberSVC {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberSVCImpl.class);

	@Inject
	@Qualifier("memberDAOImplXML")
	MemberDAO memberDAO;
	
	//회원등록
	@Override
	public int joinMember(MemberVO memberVO) {
		int result = 0;
		result = memberDAO.joinMember(memberVO);
		return result;
	}

//회원수정
	@Override
	public int modifyMember(MemberVO memberVO) {
		int result = 0;
		result = memberDAO.modifyMember(memberVO);
		return result;
	}

//회원전체조회
	@Override
	public List<MemberVO> listAllMember() {
		List<MemberVO> list;
		list = memberDAO.listAllMember();
		return list;
	}

//회원개별조회
	@Override
	public MemberVO listOneMember(String id) {
	
		return null;
	}

//회원삭제
	@Override
	public int outMember(String id, String pw) {
		
		return 0;
	}

	//로그인
	@Override
	public MemberVO login(String id, String pw) {
		
		return null;
	}

	//아이디찾기
	@Override
	public String findId(String tel, String birth) {
	
		return null;
	}

//	비밀번호찾기
	@Override
	public String findPw(String id, String birth) {
		
		return null;
	}

	@Override
	public int changePw(String id, String pw) {
		
		return 0;
	}

	@Override
	public byte[] findProfileImg(String id) {
	
		return null;
	}

}
