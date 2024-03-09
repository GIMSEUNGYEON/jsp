package kr.or.ddit.mbti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.common.exception.CustomPersistenceException;
import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.MbtiDescVO;

public class MbtiDAOImpl implements MbtiDAO {

	@Override
	public List<MbtiDescVO> selectMbtiList() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT MT_SORT, MT_TYPE, MT_TITLE ");
		sql.append(" FROM TB_MBTIDESC ");
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
		){
			ResultSet rs = pstmt.executeQuery();
			List<MbtiDescVO> list = new ArrayList<>();
			while(rs.next()) {
				MbtiDescVO vo = new MbtiDescVO();
				list.add(vo);
				vo.setMtSort(rs.getInt("MT_SORT"));
				vo.setMtType(rs.getString("MT_TYPE"));
				vo.setMtTitle(rs.getString("MT_TITLE"));
			}
			return list;
		}catch (SQLException e) {
			throw new CustomPersistenceException(e);
		}
	}

	@Override
	public MbtiDescVO selectMbti(String mtType) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT MT_SORT, MT_TYPE, MT_TITLE, MT_CONTENT ");
		sql.append(" FROM TB_MBTIDESC ");
		sql.append(" WHERE MT_TYPE = ? ");
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
		){
			pstmt.setString(1, mtType);
			ResultSet rs = pstmt.executeQuery();
			MbtiDescVO vo = null;
			while(rs.next()) {
				vo = new MbtiDescVO();
				vo.setMtSort(rs.getInt("MT_SORT"));
				vo.setMtType(rs.getString("MT_TYPE"));
				vo.setMtTitle(rs.getString("MT_TITLE"));
				vo.setMtContent(rs.getString("MT_CONTENT"));
			}
			return vo;
		}catch (SQLException e) {
			throw new CustomPersistenceException(e);
		}
	}

	@Override
	public int insertMbti(MbtiDescVO mbti) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO TB_MBTIDESC         ");
		sql.append(" (                               ");
		sql.append(" 		MT_SORT                  ");
		sql.append(" 		, MT_TYPE                ");
		sql.append(" 		, MT_TITLE               ");
		sql.append(" 		, MT_CONTENT             ");
		sql.append(" )VALUES(                        ");
		sql.append(" 		SEQ_MBTI.NEXTVAL         ");
		sql.append(" 		, ?                    ");
		sql.append(" 		, ?                      ");
		sql.append(" 		, ?                      ");
		sql.append(" )                               ");
		
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
		){
			int index = 1;
			pstmt.setString(index++, mbti.getMtType());
			pstmt.setString(index++, mbti.getMtTitle());
			pstmt.setString(index++, mbti.getMtContent());
			
			return pstmt.executeUpdate();
			
		}catch (SQLException e) {
			throw new CustomPersistenceException(e);
		}
	}

}












