package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.common.exception.CustomPersistenceException;
import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public MemberVO selectMemberForAuth(String memId) {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT MEM_ID, MEM_PASS, MEM_NAME, MEM_MAIL, MEM_HP ");
		sql.append(" FROM MEMBER 										 ");
		sql.append(" WHERE MEM_ID = ? 									 ");
		
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, memId);
			ResultSet rs = pstmt.executeQuery();
			MemberVO saved = null;
			if(rs.next()) {
				saved = new MemberVO();
				saved.setMemId(rs.getString("MEM_ID"));
				saved.setMemPass(rs.getString("MEM_PASS"));
				saved.setMemName(rs.getString("MEM_NAME"));
				saved.setMemMail(rs.getString("MEM_MAIL"));
				saved.setMemHp(rs.getString("MEM_HP"));
			}
			
			return saved;
		}catch(SQLException e) {
			throw new CustomPersistenceException(e);
		}
	}

	@Override
	public int insertMember(MemberVO member) {

		return 0;
	}

	@Override
	public MemberVO selectMember(String memId) {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT                                                          ");
	    sql.append(" MEM_ID,    MEM_PASS,    MEM_NAME,                               ");
	    sql.append(" MEM_REGNO1,    MEM_REGNO2,    MEM_BIR,                          ");
	    sql.append(" MEM_ZIP,    MEM_ADD1,    MEM_ADD2,                              ");
	    sql.append(" MEM_HOMETEL,    MEM_COMTEL,    MEM_HP,                          ");
	    sql.append(" MEM_MAIL,    MEM_JOB,    MEM_LIKE,                              ");
	    sql.append(" MEM_MEMORIAL,    MEM_MEMORIALDAY,    MEM_MILEAGE,    MEM_DELETE ");
	    sql.append(" FROM                                                            ");
	    sql.append(" 	MEMBER                                                      ");
	    sql.append(" 	WHERE                                                       ");
	    sql.append(" MEM_ID = ?                                                      ");
		
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, memId);
			ResultSet rs = pstmt.executeQuery();
			MemberVO member = null;
			if(rs.next()) {
				member = new MemberVO();
				member.setMemId(rs.getString("MEM_ID"));
				member.setMemPass(rs.getString("MEM_PASS"));
				member.setMemName(rs.getString("MEM_NAME"));
				member.setMemRegno1(rs.getString("MEM_REGNO1"));
				member.setMemRegno2(rs.getString("MEM_REGNO2"));
				Date memBir = rs.getDate("MEM_BIR");
				if(memBir != null) {
					member.setMemBir(memBir.toLocalDate());					
				}
				member.setMemZip(rs.getString("MEM_ZIP"));
				member.setMemAdd1(rs.getString("MEM_ADD1"));
				member.setMemAdd2(rs.getString("MEM_ADD2"));
				member.setMemHometel(rs.getString("MEM_HOMETEL"));
				member.setMemComtel(rs.getString("MEM_COMTEL"));
				member.setMemHp(rs.getString("MEM_HP"));
				member.setMemMail(rs.getString("MEM_MAIL"));
				member.setMemJob(rs.getString("MEM_JOB"));
				member.setMemLike(rs.getString("MEM_LIKE"));				
//				Date memorialDay = rs.getDate("MEM_MEMORIAL");
//				if(memorialDay != null) {
//					member.setMemMemorialday(memorialDay.toLocalDate());					
//				}
				member.setMemMemorial(rs.getString("MEM_MEMORIAL"));
				member.setMemMileage(rs.getInt("MEM_MILEAGE"));
				member.setMemDelete(rs.getBoolean("MEM_DELETE"));
			}
			
			return member;
		}catch(SQLException e) {
			throw new CustomPersistenceException(e);
		}
	}

	@Override
	public List<MemberVO> selectMemberList() {
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT * FROM MEMBER");
		
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public int updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
