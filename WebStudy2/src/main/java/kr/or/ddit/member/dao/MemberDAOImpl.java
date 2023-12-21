package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import kr.or.ddit.common.exception.CustomPersistenceException;
import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.mapper.SampleDataMapper;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private SampleDataMapper mapper = new SampleDataMapper();
		
	@Override
	public MemberVO selectMemberForAuth(String memId) {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT MEM_ID, MEM_PASS, MEM_NAME, MEM_MAIL, MEM_HP ");
		sql.append(" FROM MEMBER 										 ");
		sql.append(" WHERE MEM_ID = ? AND MEM_DELETE IS NULL			 ");
		
		return mapper.selectOne(sql.toString(), MemberVO.class, new String[] {memId});
	}
//	template method pattern으로 해결 예정
	@Override
	public int insertMember(MemberVO member) {
		StringBuffer sql = new StringBuffer();    
		
		sql.append(" INSERT INTO MEMBER (MEM_ID, MEM_PASS, MEM_NAME,                  		  ");
		sql.append(" 		MEM_REGNO1, MEM_REGNO2, MEM_BIR,                           	      ");
		sql.append(" 		MEM_ZIP, MEM_ADD1, MEM_ADD2,                               		  ");
		sql.append(" 		MEM_HOMETEL,MEM_COMTEL,MEM_HP,                           		  ");
		sql.append(" 		MEM_MAIL,MEM_JOB,MEM_LIKE,                               		  ");
		sql.append(" 		MEM_MEMORIAL,MEM_MEMORIALDAY,MEM_MILEAGE)    		  			  ");
		sql.append(" 		VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1000)  ");
		                                                                            
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			int idx = 1;
			pstmt.setString(idx++, member.getMemId());
			pstmt.setString(idx++, member.getMemPass());
			pstmt.setString(idx++, member.getMemName());
			pstmt.setString(idx++, member.getMemRegno1());
			pstmt.setString(idx++, member.getMemRegno2());
			
			Timestamp memBir = null;
			if(member.getMemBir() != null) {
				memBir = Timestamp.valueOf(member.getMemBir());					
			}
			
			pstmt.setTimestamp(idx++,  memBir);
			pstmt.setString(idx++,  member.getMemZip());
			pstmt.setString(idx++,  member.getMemAdd1());
			pstmt.setString(idx++,  member.getMemAdd2());
			pstmt.setString(idx++, member.getMemHometel());
			pstmt.setString(idx++, member.getMemComtel());
			pstmt.setString(idx++, member.getMemHp());
			pstmt.setString(idx++, member.getMemMail());
			pstmt.setString(idx++, member.getMemJob());
			pstmt.setString(idx++, member.getMemLike());
			pstmt.setString(idx++, member.getMemMemorial());
			
			Date memorialday = null;
			if(member.getMemMemorialday() != null) {
				memorialday = Date.valueOf(member.getMemMemorialday());					
			}
			pstmt.setDate(idx++, memorialday);
			
			int rowcnt = pstmt.executeUpdate();
			
			return rowcnt;
		}catch (SQLException e) {
			throw new CustomPersistenceException(e);
		}
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
		
		return mapper.selectOne(sql.toString(), MemberVO.class, new String[] {memId});
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
