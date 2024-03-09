<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>


<style>
.name{
/* 	display: none; */
}


</style>



<div class="card">
<div class="card-header">
<h2>급여관리</h2>
</div>
<div class="card">
<div class="row-auto">
<div class="col-auto">
<br>
<h5 class="text-center">2월 급여 지급 현황</h5>
<table class="table table-bordered  fs--1 mb-0">
<tr>
<th>귀속연월</th>
<th>산정기간</th>
<th>지급일</th>
<th>지급총액</th>
<th>공제총액</th>
<th>실지급액</th>
<th>총 직원수</th>
</tr>
<tr>
<td>2024-02</td>
<td>2024/01/02 ~ 2024/01/31</td>
<td>2024/02/09</td>
<td>100,000,000</td>
<td>30,000,000</td>
<td>70,000,000</td>
<td>21명</td>
</tr>
<tr>

<button class="btn btn-secondary me-1" type="button" data-bs-toggle="modal" data-bs-target="#error-modal">급여자동계산</button>
<button class="btn btn-danger ">급여확정</button>
</tr>
</table>

</div>
</div>
</div>

<div class="card-body"> 
<div id="tableExample3" data-list>
  <div class="row justify-content-end g-0">
    <div class="col-auto col-sm-5 mb-3">
      <form>
      <div class="d-flex">
      <select id="myname" class="form-select form-select-sm" aria-label="Bulk actions" data-list-filter="data-list-filter">
                            <option  selected="" value="">전체</option>
                            <option value="2024">2024</option>
                            <option value="2023">2023</option>
                            <option value="2022">2022</option>
                            
                          </select>
      </div>
      <div class="d-flex">
      <select id="myage" class="form-select form-select-sm" aria-label="Bulk actions">
                            <option  selected="" value="">전체</option>
                            <option value="12월">12월</option>
                            <option value="1월">1월</option>
                         
                          </select>
      </div>
      
      
      <div class="input-group">
          <input class="form-control form-control-sm shadow-none search" type="search" placeholder="Search..." aria-label="search" />
          <div class="input-group-text bg-transparent"><span class="fa fa-search fs--1 text-600"></span></div>
        </div>
      
      </form>
    </div>
  </div>
  
  
<div class="modal fade" id="error-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document" style="max-width: 500px">
    <div class="modal-content position-relative">
      <div class="position-absolute top-0 end-0 mt-2 me-2 z-index-1">
        <button class="btn-close btn btn-sm btn-circle d-flex flex-center transition-base" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body p-0">
        <div class="rounded-top-lg py-3 ps-4 pe-6 bg-light">
          <h4 class="mb-1" id="modalExampleDemoLabel">Add a new illustration </h4>
        </div>
        <div class="p-4 pb-0">
          <form>
          <div className="modal"> 		// display: block;
    <div className="modal-header">
        새발자 테스트 모달
    </div>
    
    <div className="modal-content">    // height: 50vh; overflow-y: auto;  
       ...list items
    </div>
    
    <div className="modal-footer">
    	<button>닫기</button>
    </div>
</div>

          
          
            <div class="mb-3">
              <label class="col-form-label" for="recipient-name">Recipient:</label>
              <input class="form-control" id="recipient-name" type="text" />
            </div>
            <div class="mb-3">
              <label class="col-form-label" for="message-text">Message:</label>
              <textarea class="form-control" id="message-text"></textarea>
            </div>
          </form>
        </div>
      </div>
      <div class="modal-footer">
        <button class="btn btn-secondary" type="button" data-bs-dismiss="modal">Close</button>
        <button class="btn btn-primary" type="button">Understood </button>
      </div>
    </div>
  </div>
</div>
  
  
  
  
  
  
  
  
  <div class="table-responsive scrollbar">
    <table class="table table-bordered table-striped fs--1 mb-0">
      <thead class="bg-200 text-900">
        <tr>
          <th class="sort" data-sort="name">연도</th>
          <th class="sort" data-sort="email">Email</th>
          <th class="sort" data-sort="age">월</th>
        </tr>
      </thead>
      <tbody class="list">
        <tr>
          <td class="name">2022</td>
          <td class="email">anna@example.com</td>
          <td class="age">12월</td>
        </tr>
        <tr>
          <td class="name">2023</td>
          <td class="email">homer@example.com</td>
          <td class="age">1월</td>
        </tr>
        <tr>
          <td class="name">2024</td>
          <td class="email">oscar@example.com</td>
          <td class="age">1월</td>
        </tr>
        <tr>
          <td class="name">2022</td>
          <td class="email">emily@example.com</td>
          <td class="age">1월</td>
        </tr>
        <tr>
          <td class="name">2023</td>
          <td class="email">jara@example.com</td>
          <td class="age">12월</td>
        </tr>
        <tr>
          <td class="name">2024</td>
          <td class="email">clark@example.com</td>
          <td class="age">1월</td>
        </tr>
        <tr>
          <td class="name">2022</td>
          <td class="email">jennifer@example.com</td>
          <td class="age">12월</td>
        </tr>
        <tr>
          <td class="name">2023</td>
          <td class="email">tony@example.com</td>
          <td class="age">12월</td>
        </tr>
        <tr>
          <td class="name">2024</td>
          <td class="email">tom@example.com</td>
          <td class="age">12월</td>
        </tr>
        <tr>
          <td class="name">2022</td>
          <td class="email">michael@example.com</td>
          <td class="age">1월</td>
        </tr>
        <tr>
          <td class="name">2023</td>
          <td class="email">antony@example.com</td>
          <td class="age">12월</td>
        </tr>
        <tr>
          <td class="name">2024</td>
          <td class="email">raymond@example.com</td>
          <td class="age">12월</td>
        </tr>
        <tr>
          <td class="name">2022</td>
          <td class="email">marie@example.com</td>
          <td class="age">12월</td>
        </tr>
        <tr>
          <td class="name">2023</td>
          <td class="email">cohen@example.com</td>
          <td class="age">1월</td>
        </tr>
        <tr>
          <td class="name">2024</td>
          <td class="email">rowen@example.com</td>
          <td class="age">1월</td>
        </tr>
      </tbody>
    </table>
  </div>
  <div class="d-flex justify-content-center mt-3">
    <button class="btn btn-sm btn-falcon-default me-1" type="button" title="Previous" data-list-pagination="prev"><span class="fas fa-chevron-left"></span></button>
    <ul class="pagination mb-0"></ul>
    <button class="btn btn-sm btn-falcon-default ms-1" type="button" title="Next" data-list-pagination="next"><span class="fas fa-chevron-right"> </span></button>
  </div>
</div>

</div>
</div>

<script src="<c:url value='/resources/js/app/emp/hrm/pay/payList.js'/>"></script>
