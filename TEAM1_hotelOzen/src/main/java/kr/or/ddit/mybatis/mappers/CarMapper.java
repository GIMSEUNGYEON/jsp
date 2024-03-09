package kr.or.ddit.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.CarVO;
import kr.or.ddit.global.vo.ScrapVO;

@Mapper
public interface CarMapper extends AbstractCommonMapper<CarVO, String>{

	Map<String, String> selectCstmr(String cstNo);
	
	List<CarVO> selectCar(Map<String, Object> parameterMap);
	
	public int insertCarScrap(ScrapVO newScrap);
	
	public int deleteCarScrap(ScrapVO deleteScrap);

}