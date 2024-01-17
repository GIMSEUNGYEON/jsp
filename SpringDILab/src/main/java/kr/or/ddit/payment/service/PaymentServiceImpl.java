package kr.or.ddit.payment.service;

import javax.annotation.Resource;
import javax.inject.Inject;

import javax.inject.Named;

import org.springframework.stereotype.Service;

import kr.or.ddit.payment.dao.EmployeeDAO;
import kr.or.ddit.payment.dao.EmployeeDAOFactory;
import kr.or.ddit.payment.dao.EmployeeDAOImpl_Maria;
import kr.or.ddit.payment.dao.EmployeeDAOImpl_Oracle;
import kr.or.ddit.payment.dao.SalaryDAO;
import kr.or.ddit.payment.dao.SalaryDAOImpl;

@Service
public class PaymentServiceImpl implements PaymentService {
	// 1. new 로 인스턴스 직접 생성(결합력 죄상)
//	private EmployeeDAO empDAO = new EmployeeDAOImpl_Oracle();
	// 2. Factory Object Pattern(공장 객체가 결합력을 떠안음, 서비스와 공장 사이 결합력 발생) 
//	private EmployeeDAO empDAO = EmployeeDAOFactory.getEmployeeDAO();
	// 3. Strategy Pattern(DI) : 전략의 주입자가 모든 결합력을 떠안게 됨.
	private EmployeeDAO empDAO;
	private SalaryDAO salDAO;
	
	@Resource(name="oracle")
	public void setEmpDAO(EmployeeDAO empDAO) {
		this.empDAO = empDAO; 
	}
	@Inject
	public void setSalDAO(SalaryDAO salDAO) {
		this.salDAO = salDAO; 
	}
	
	public StringBuffer payMonthly(String empCode) {
		StringBuffer model = empDAO.selectEmployee(empCode);
		long salary = salDAO.selectSalary(empCode);
		long monthly = salary /12;
	
		model.append(", 이번달 급여 : "+monthly);
	
		return model;
	}
}
