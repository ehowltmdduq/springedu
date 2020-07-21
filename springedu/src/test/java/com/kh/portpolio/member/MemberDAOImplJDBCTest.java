package com.kh.portpolio.member;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.portfolio.member.DAO.MemberDAO;
import com.kh.portfolio.member.VO.MemberVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOImplJDBCTest {

	private static Logger logger = 
			LoggerFactory.getLogger(MemberDAOImplJDBCTest.class);
	
	@Inject
	MemberDAO memberDAO;
	
	@Test  //테스트대상에서 포함할때
	@DisplayName("회원등록")
	@Disabled //테스트대상에서 제외할때
	void test1() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test2@test.com");
		memberVO.setPw("test");
		memberVO.setTel("010-0000-0000");
		memberVO.setNickname("test");
		memberVO.setGender("남");
		memberVO.setRegion("울산");
		memberVO.setBirth(java.sql.Date.valueOf("2000-01-02"));

		int cnt = memberDAO.joinMember(memberVO);
		
		logger.info("cnt:" + cnt);
	}
	@Test
	@DisplayName("회원수정")
	@Disabled
	void modifyMember() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test2@test.com");
		memberVO.setPw("3333");
		memberVO.setTel("010-1230-0000");
		memberVO.setNickname("test2");
		memberVO.setGender("남");
		memberVO.setRegion("부산");
		memberVO.setBirth(java.sql.Date.valueOf("2020-03-05"));
		
		int cnt = memberDAO.modifyMember(memberVO);
		
		//예상값과 결과값을 출력 예상값이 결과값과 다르면 오류메세지가 뜨면서 작동이 안된다
		Assertions.assertEquals(1,cnt);
		logger.info("cnt:" + cnt);
	}
	@Test
	@DisplayName("회원전체조회")
	void listAllMember() {
		List<MemberVO> list = memberDAO.listAllMember();
		
		for(MemberVO memberVO : list) {
			logger.info(memberVO.toString());
		}
	}
}
