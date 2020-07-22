package com.kh.portfolio.member.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kh.portfolio.member.VO.MemberVO;

@Repository("memberDAOImplXML")
public class MemberDAOImplXML implements MemberDAO{

	private static final Logger logger = 
			LoggerFactory.getLogger(MemberDAOImplXML.class);
@Inject
private SqlSession sqlSession;
	//회원등록
	@Override
	public int joinMember(MemberVO memberVO) {
		logger.info("MemberDAOImplXML.joinMember(MemberVO memberVO) 호출됨!  ");
		
		return sqlSession.insert("mappers.MemberDAO-mapper.joinMember",memberVO);
	}

	//회원수정
	@Override
	public int modifyMember(MemberVO memberVO) {
		logger.info("MemberDAOImplXML.modifyMember(MemberVO memberVO) 호출됨!  ");
		return sqlSession.update("mappers.MemberDAO-mapper.modifyMember",memberVO);
	}

	//회원전체조회
	@Override
	public List<MemberVO> listAllMember() {
		logger.info("MemberDAOImplXML.List<MemberVO> listAllMember() 호출됨!  ");
		return sqlSession.selectList("mappers.MemberDAO-mapper.listAllMember");
	}

	//회원개별조회
	@Override
	public MemberVO listOneMember(String id) {
		logger.info("MemberDAOImplXML. listOneMember 호출됨!  ");
		return sqlSession.selectOne("mappers.MemberDAO-mapper.listOneMember",id);
	}

	//회원삭제
	@Override
	public int outMember(String id, String pw) {
		logger.info("MemberDAOImplXML. outMember(String id, String pw) 호출됨!  ");
		Map<String,String> map = new HashMap<>();
		map.put("id",id);
		map.put("pw",pw);
		return sqlSession.delete("mappers.MemberDAO-mapper.outMember",map);
	}

	//로그인
	@Override
	public MemberVO login(String id, String pw) {
		Map<String,String> map = new HashMap<>();
		logger.info("MemberDAOImplXML.login(String id, String pw) 호출됨!  ");
		map.put("id",id);
		map.put("pw",pw);
		return sqlSession.selectOne("mappers.MemberDAO-mapper.login",map);
	}

	//아이디찾기
	@Override
	public String findId(String tel, String birth) {
		Map<String,String> map = new HashMap<>();
		logger.info("MemberDAOImplXML.findId(String tel, String birth) 호출됨!  ");
		map.put("tel",tel);
		map.put("birth",birth);
		return sqlSession.selectOne("mappers.MemberDAO-mapper.findId",map);
	}

	//비밀번호찾기
	@Override
	public String findPw(String id, String birth) {
		Map<String,String> map = new HashMap<>();
		logger.info("MemberDAOImplXML.findPw(String id, String birth) 호출됨!  ");
		map.put("id",id);
		map.put("birth",birth);
		return sqlSession.selectOne("mappers.MemberDAO-mapper.findPw",map);
	}

	//비밀번호변경
	@Override
	public int changePw(String id, String pw) {
		logger.info("MemberDAOImplXML.changePW(String id, String pw) 호출됨");
		Map<String,String> map = new HashMap<>();
		map.put("id",id);
		map.put("pw",pw);
		return sqlSession.update("mappers.MemberDAO-mapper.changePW", map);

	}

	@Override
	public byte[] findProfileImg(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
