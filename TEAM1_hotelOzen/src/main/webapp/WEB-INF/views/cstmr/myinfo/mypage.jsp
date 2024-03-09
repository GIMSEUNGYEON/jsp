<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/common/btn.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/cstmr/myinfo/mypage.css" rel="stylesheet">

<section>
	<div>
		<div class="clickwrap-header mx-10 mb-6">
			<h1 class="cstmr-title mx-5">My Page</h1>
		</div>
	</div>
	<div class="container">
		
		<div class="row flex-center ">
			<div class="col-md-3 mypage-side"> 
				<div class="myinfo">
					<p class="name">${mberUser.cst.cstNm } 님</p>
					<div class="info">
						<a href="/mypage/myPointForm.do">
						    <span class="tit">포인트</span>
						    <span class="txt"><abbr title="Point">Point</abbr></span>
						</a>
						<a href="/mypage/myCouponaForm.do">
						    <span class="tit">쿠폰</span>
					        <span id="couponCntDiv" class="txt"></span>
					    </a>
					</div>
				</div>
				<ul class="lnb">
					<li id="mbrshp1">멤버십확인
						<ul>
							<li><a href="/mypage/myGoodsForm.do">CLUB JOSUN VIP 내역</a></li>
						</ul>
						</li>
						<li>예약확인
						<ul>
						    <li><a href="/cnfirm/mber/room/reserveList.do">객실 · 패키지 예약 내역</a></li>
							<li><a href="/cnfirm/mber/dining/reserveList.do">다이닝 예약 내역</a></li>
							<li><a href="/cnfirm/mber/activity/reserveList.do">액티비티 예약 내역</a></li>
							<li id="mbrshp2"><a href="/cnfirm/mber/vouch/reserveList.do">멤버십 예약 내역</a></li>
					    </ul>
						</li>
						<li>관심 리스트
						<ul>
						    <li><a href="/mber/interest/roomList.do">객실 리스트</a></li>
							<li><a href="/mber/interest/packageList.do">패키지 리스트</a></li>
					    </ul>
						</li>
						<li>개인정보관리
						<ul>
							<li>
								<a href="/mypage/myInfoForm.do"> 회원 정보 수정 </a>  
							
							</li>
							<li><a href="/mypage/pwChngForm.do">비밀번호 변경</a></li>
							<li><a href="/mypage/withdraPwCfmForm.do">회원 탈퇴</a></li>
						</ul>
					</li>
				</ul>
			</div>
			
			<div class="col-md-9"> 
				test
			</div>
		</div>
	</div>
</section>