package kr.or.ddit.property.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.PropertyVO;

public class PropertyDAOImpl implements PropertyDAO {
	
	@Override
	public int insertProperty(PropertyVO newProp) {
		
		return 0;
	}

	@Override
	public List<PropertyVO> selectProperties() {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION ");
		sql.append(" FROM TB_PROPERTIES ");
		
		List<PropertyVO> propList = new ArrayList<>();
		
		try(
			Connection conn = ConnectionFactory.getConnection();
			Statement stmt = conn.createStatement();	
		){
			ResultSet rs = stmt.executeQuery(sql.toString());
			
			while(rs.next()){
				PropertyVO propVO = new PropertyVO();
				propVO.setPropertyName(rs.getString("PROPERTY_NAME"));
				propVO.setPropertyValue(rs.getString("PROPERTY_VALUE"));
				propVO.setDescription(rs.getString("DESCRIPTION"));
				propList.add(propVO);
			}
			return propList;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public PropertyVO selectProperty(String propertyName) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION ");
		sql.append(" FROM TB_PROPERTIES ");
		sql.append(String.format(" WHERE PROPERTY_NAME = '%s' ", propertyName));
		
		PropertyVO propVO = null;
		try(
			Connection conn = ConnectionFactory.getConnection();
			Statement stmt = conn.createStatement();	
		){
			ResultSet rs = stmt.executeQuery(sql.toString());
			
			if(rs.next()) {
				propVO = new PropertyVO();
				propVO.setPropertyName(rs.getString("PROPERTY_NAME"));
				propVO.setPropertyValue(rs.getString("PROPERTY_VALUE"));
				propVO.setDescription(rs.getString("DESCRIPTION"));
			}
			return propVO;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateProperty(PropertyVO modifyProp) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE TB_PROPERTIES    ");
		sql.append(" Set                     ");
		sql.append(" 	PROPERTY_VALUE = '"+modifyProp.getPropertyValue()+"', ");
		sql.append(" 	DESCRIPTION = '"+modifyProp.getDescription()+"'     ");
		sql.append(" WHERE                   ");
		sql.append(" 	PROPERTY_NAME = '"+modifyProp.getPropertyName()+"'   ");;
			
		try (
			Connection conn = ConnectionFactory.getConnection(); 
			Statement stmt = conn.createStatement();
		) {
			
			return stmt.executeUpdate(sql.toString());

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteProperty(String propertyName) {
		
		return 0;
	}

}
