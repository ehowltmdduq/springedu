package com.kh.portfolio.member.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.portfolio.member.VO.MemberVO;

@Repository
public class MemberDAOImplJdbc implements MemberDAO {

	private static Logger logger = LoggerFactory.getLogger(MemberDAOImplJdbc.class);

	@Inject
	JdbcTemplate JdbcTemplate;

	// 회원등록
	@Override
	public int joinMember(MemberVO memberVO) {
		logger.info("MemberDAOImpl.joinMember(MemberVO memberVO) 호출!!");
		logger.info(memberVO.toString());
		int result = 0;

		// sql문 작성
//	  StringBuffer sql = new StringBuffer();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into member(id,pw,tel,nickname,gender,region,birth) ");
		sql.append("values(?,?,?,?,?,?,?) ");

		// sql실행
		result = JdbcTemplate.update(sql.toString(), memberVO.getId(), memberVO.getPw(), memberVO.getTel(),
				memberVO.getNickname(), memberVO.getGender(), memberVO.getRegion(), memberVO.getBirth());
		return result;
//    return JdbcTemplate.update(
//           sql.toString(),
//           memberVO.getId(),
//           memberVO.getPw(),
//           memberVO.getTel(),
//           memberVO.getNickname(),
//           memberVO.getGender(),
//           memberVO.getRegion(),
//           memberVO.getBirth()
//           ); 
	}

	// 회원 수정
	@Override
	public int modifyMember(MemberVO memberVO) {
		logger.info("MemberDAOImplJdbc.modifyMember(MemberVO memberVO 호출됨!!");
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("update member ");
		sql.append("set tel=?,"
		          + "nickname=?," 
				      + "gender=?," 
		          + "region=?," 
				      + "birth=?," 
		          + "udate=systimestamp ");
		sql.append("where id=? ");

//		return JdbcTemplate.update(
//				sql.toString(),
//				memberVO.getTel(),
//				memberVO.getNickname(),
//				memberVO.getGender(),
//				memberVO.getRegion(),
//				memberVO.getBirth(),
//				memberVO.getId()
//				);
		result = JdbcTemplate.update(sql.toString(), memberVO.getTel(), memberVO.getNickname(), memberVO.getGender(),
				memberVO.getRegion(), memberVO.getBirth(), memberVO.getId());
		return result;
	}

	// 회원 전체 조회
	@Override
	public List<MemberVO> listAllMember() {
		logger.info("MemberDAOImplJdbc.List<MemberVO> listAllMember()호출됨!");
		List<MemberVO> list = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select id,pw,tel,nickname,gender,region,birth,cdate,udate "); 
		sql.append("from member ");
		
		list = JdbcTemplate.query(sql.toString(),
				               getRowMapper());
		return list;
	}

	private RowMapper<MemberVO> getRowMapper() {
	  RowMapper<MemberVO> rowMapper = new RowMapper<MemberVO>() {
	  	@Override
	  	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	  		MemberVO memberVO = new MemberVO();
	  		memberVO.setId(rs.getString("id"));
	  		memberVO.setPw(rs.getString("pw"));
	  		memberVO.setTel(rs.getString("tel"));
	  		memberVO.setNickname(rs.getString("nickname"));
	  		memberVO.setGender(rs.getString("gender"));
	  		memberVO.setBirth(rs.getDate("birth"));
	  		memberVO.setCdate(rs.getTimestamp("cdate"));
	  		memberVO.setUdate(rs.getTimestamp("udate"));
	  		return memberVO;
	  	}
	  	
	  };
		return rowMapper;
	}

	@Override
	public MemberVO listMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outMember(String id, String pw) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO login(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findId(String tel, String birth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findPw(String id, String birth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int changePw(String id, String pw) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] findProfileImg(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
