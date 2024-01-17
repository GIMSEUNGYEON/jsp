package kr.or.ddit.payment;

import java.lang.annotation.Annotation;

import org.springframework.context.annotation.ComponentScan;
//import static org.springframework.context.annotation.ComponentScan.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(value="kr.or.ddit.payment", excludeFilters= {
		@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, MVCView.class})
})
public class PaymentParentJavaConfiguration {
	
}
