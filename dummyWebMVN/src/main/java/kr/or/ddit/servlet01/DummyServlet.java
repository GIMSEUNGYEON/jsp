package kr.or.ddit.servlet01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/01/dummy.do")
public class DummyServlet extends HttpServlet {
	BasicDataSource ds;
	ObjectMapper om;
}
