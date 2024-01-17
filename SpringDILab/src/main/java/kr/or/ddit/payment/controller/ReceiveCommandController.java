package kr.or.ddit.payment.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import kr.or.ddit.payment.service.PaymentService;
import kr.or.ddit.payment.view.PayMonthlyView;

@Controller
public class ReceiveCommandController {
	private PaymentService service;
	private PayMonthlyView view;
	
	public ReceiveCommandController(PaymentService service, PayMonthlyView view) {
		super();
		this.service = service;
		this.view = view;
	}

	public String receiveCommand(String empCode) {
		StringBuffer model = service.payMonthly(empCode);
		return view.generateContent(model);
		
	}
}
