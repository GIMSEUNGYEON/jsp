package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import lombok.extern.slf4j.Slf4j;

/**
 * 이벤트 처리 단계 
 * 1. 이벤트의 타겟 결정 : let $btn = $("button");
 * 2. 이벤트의 종류 결정 : $btn.on("click", handler);
 * 3. 이벤트 핸들러(리스너) 구현 : let handler = (event)=>{ event.target };
 * 4. 이벤트 타겟에게 핸들러를 부착.(WebListener 어노테이션을 사용하거나 web.xml에 등록하기)
 */
@Slf4j
public class CustomServletContextHttpSessionListener implements ServletContextListener, HttpSessionListener {

    public CustomServletContextHttpSessionListener() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	ServletContext application = se.getSession().getServletContext();
    	int userCount = (Integer) application.getAttribute("userCount");
    	userCount++;
    	application.setAttribute("userCount", userCount);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	int userCount = 0;
    	sce.getServletContext().setAttribute("userCount", userCount);
    	log.info("{} 어플리케이션 시작", sce.getServletContext().getContextPath());
    }
	
}
