package kr.or.ddit.common.preparer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerMapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Preparer("menuPreparer")
public class CommonMenuViewPreparer implements ViewPreparer{
	@Data
	@AllArgsConstructor
	@Builder
	public static class MenuVO{
		private String menuId;
		private int menuLevel;
		private String menuUrl;
		private String menuText;
	}
	private List<MenuVO> menuList;
	
	{
		menuList = new ArrayList<>();
		menuList.add(
			MenuVO.builder()
				.menuLevel(1)
				.menuUrl("/fullcalendar/case1")
				.menuText("FullCalendar")
				.build());
		menuList.add(
				MenuVO.builder()
				.menuLevel(2)
				.menuUrl("/fullcalendar/case1")
				.menuText("FullCalendar_case1(member)")
				.build());
		menuList.add(
				MenuVO.builder()
				.menuLevel(2)
				.menuUrl("/fullcalendar/case2")
				.menuText("FullCalendar_case2(prod)")
				.build());
		menuList.add(
				MenuVO.builder()
				.menuLevel(1)
				.menuUrl("/aggrid/case1")
				.menuText("Aggrid")
				.build());
		menuList.add(
				MenuVO.builder()
				.menuLevel(2)
				.menuUrl("/aggrid/case1")
				.menuText("aggrid_case1")
				.build());
		menuList.add(
				MenuVO.builder()
				.menuLevel(2)
				.menuUrl("/aggrid/case2")
				.menuText("aggrid_case2(paging+search)")
				.build());
		menuList.add(
				MenuVO.builder()
				.menuLevel(2)
				.menuUrl("/aggrid/case3")
				.menuText("aggrid_case3(edit)")
				.build());
		menuList.add(
				MenuVO.builder()
				.menuLevel(1)
				.menuUrl("/fancytree/case1")
				.menuText("Fancytree")
				.build());
		menuList.add(
				MenuVO.builder()
				.menuLevel(2)
				.menuUrl("/fancytree/case1")
				.menuText("Fancytree_case1")
				.build());
		menuList.add(
				MenuVO.builder()
				.menuLevel(2)
				.menuUrl("/fancytreerid/case2")
				.menuText("Fancytree_case2(lazy loading)")
				.build());
		menuList.add(
				MenuVO.builder()
				.menuLevel(1)
				.menuUrl("/file")
				.menuText("File")
				.build());
		menuList.add(
				MenuVO.builder()
				.menuLevel(2)
				.menuUrl("/file")
				.menuText("파일다운로드(Compress)")
				.build());
		menuList.add(
				MenuVO.builder()
				.menuLevel(2)
				.menuUrl("/file/ftp")
				.menuText("파일조회(FTP)")
				.build());
		menuList.add(
				MenuVO.builder()
				.menuLevel(1)
				.menuUrl("/paging/spa")
				.menuText("페이징(SPA)")
				.build());
	}

	@Override
	public void execute(Request req, AttributeContext ctx) {
		Map<String, Object> requestScope = req.getContext(Request.REQUEST_SCOPE);
		String requestUrl = (String) requestScope.get(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		AntPathMatcher pathMatcher = new AntPathMatcher();
		Map<String, String> templateVars = pathMatcher.extractUriTemplateVariables("/{topPath}/**", requestUrl);
		String topPath = templateVars.get("topPath");
		
		Attribute contentPage = ctx.getAttribute("contentPage");
		log.info("request url : {}", requestUrl);
		log.info("contentPage : {}", contentPage.getValue());
		List<MenuVO> topMenuList = menuList.stream()
											.filter(m->m.getMenuLevel()==1)
											.collect(Collectors.toList());
		requestScope.put("topMenuList", topMenuList);
		List<MenuVO> subMenuList = menuList.stream()
										.filter(m->m.getMenuLevel()==2)
										.filter(m->pathMatcher.match("/"+topPath+"/**", m.getMenuUrl()))
										.collect(Collectors.toList());
		requestScope.put("subMenuList", subMenuList);
	}
}









