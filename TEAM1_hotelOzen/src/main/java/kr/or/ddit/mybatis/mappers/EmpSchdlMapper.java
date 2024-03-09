package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.EmpSchdlVO;

@Mapper
public interface EmpSchdlMapper {
	
	/**
	 * 직원사번으로 일정 조회
	 * @param empNo
	 * @return
	 */
	public List<EmpSchdlVO> empSchdlList(String empNo);
	
	public int insertEmpSchdl(EmpSchdlVO newschdl);
}