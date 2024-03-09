<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>



<div class="card mb-3">
            <div class="bg-holder d-none d-lg-block bg-card" style="background-image:url(../../assets/img/icons/spot-illustrations/corner-4.png);">
            </div>
            <!--/.bg-holder-->

            <div class="card-body position-relative">
              <div class="row">
                <div class="col-lg-8">
                  <h3>신규 계정 일괄 등록</h3>
                  <p>신입 직원 정보를 엑셀로 정리해서 등록해 보세요. 빠른 계정 생성이 가능합니다.</p>
                  
                  
                  <div class="mb-3">
						<input class="form-control" type="file" />
					</div>
                </div>
              </div>
              					<div class="d-flex mb-3 flex-row-reverse">
  <button class="btn btn-primary" type="submit">일괄 등록</button>
</div>
              
            </div>
          </div>
          
          
<!--           아코디언 -->
<div class="accordion" id="accordionExample">
  <div class="accordion-item">
    <h2 class="accordion-header" id="heading2">
    
    
      
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse2" aria-expanded="true" aria-controls="collapse2">
      
  
		<div class="row-auto">
			<div class="col-auto">
				<h3>신규 계정 개별 등록</h3>
				<p>신입 직원 정보를 개별적으로 작성해 보세요.</p>
			</div>
		</div>
      </button>
    </h2>
    <div class="accordion-collapse collapse" id="collapse2" aria-labelledby="heading2" data-bs-parent="#accordionExample">
      <div class="accordion-body">

      
      <div class="tab-pane preview-tab-pane active" role="tabpanel"
				aria-labelledby="tab-dom-160a4566-7e94-45a2-bf04-b36ef49d954f"
				id="dom-160a4566-7e94-45a2-bf04-b36ef49d954f">
				<form>
					<div class="mb-3">
						<label class="form-label" for="basic-form-name">사원명</label> <input
							class="form-control" id="basic-form-name" type="text"
							placeholder="Name" />
					</div>
					<div class="mb-3">
						<label class="form-label" for="basic-form-email">이메일</label> <input
							class="form-control" id="basic-form-email" type="email"
							placeholder="name@example.com" />
					</div>
					<div class="mb-3">
						<label class="form-label" for="basic-form-password">비밀번호<span >초기 비밀번호는 자동으로 사번이 부여됩니다.</span></label> <input
							class="form-control" id="basic-form-password" type="password"
							placeholder="Password" />
					</div>
					<div class="mb-3">
						<label class="form-label" for="basic-form-dob">생년월일</label> <input
							class="form-control" id="basic-form-dob" type="date" />
					</div>
					<div class="mb-3">
						<label class="form-label" for="basic-form-gender">부서</label> <select
							class="form-select" id="basic-form-gender"
							aria-label="Default select example">
							<option selected="selected">부서 선택</option>
							<option value="FTO">프론트오피스</option>
							<option value="HKP">하우스키핑</option>
							<option value="FMT">시설관리부</option>
							<option value="CRM">고객관리부</option>
							<option value="POS">재무부</option>
							<option value="HRM">인사부</option>
							<option value="other">신규</option>
						</select>
					</div>
					<div class="mb-3">
						<div class="form-check">
							<input class="form-check-input" id="flexRadioDefault1"
								type="radio" name="flexRadioDefault" /><label
								class="form-check-label mb-0" for="flexRadioDefault1">STF</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" id="flexRadioDefault2"
								type="radio" name="flexRadioDefault" checked="checked" /><label
								class="form-check-label mb-0" for="flexRadioDefault2">DPM</label>
						</div>
					</div>
					<div class="mb-3">
						<label class="form-label">프로필 사진 등록</label> <input
							class="form-control" type="file" />
					</div>
					<div class="mb-3">
						<label class="form-label" for="basic-form-textarea">기타사항</label>
						<textarea class="form-control" id="basic-form-textarea" rows="3"
							placeholder="Description"></textarea>
					</div>
					<button class="btn btn-primary" type="submit">제출</button>
				</form>
			</div>
      </div>
    </div>
  </div>
  
  
</div>




<!--           아코디언 -->
          
 
<!-- <div class="card mb-3"> -->
<!-- 	<div class="card-header"> -->
<!-- 		<div class="row flex-between-end"> -->
<!-- 			<div class="col-lg-8"> -->
<!-- 				<h3>신규 계정 개별 등록</h3> -->
<!-- 				<p>신입 직원 정보를 개별적으로 작성해 보세요.</p> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<div class="card-body bg-light"> -->
<!-- 		<div class="tab-content"> -->
<!-- 			<div class="tab-pane preview-tab-pane active" role="tabpanel" -->
<!-- 				aria-labelledby="tab-dom-160a4566-7e94-45a2-bf04-b36ef49d954f" -->
<!-- 				id="dom-160a4566-7e94-45a2-bf04-b36ef49d954f"> -->
<%-- 				<form> --%>
<!-- 					<div class="mb-3"> -->
<!-- 						<label class="form-label" for="basic-form-name">사원명</label> <input -->
<!-- 							class="form-control" id="basic-form-name" type="text" -->
<!-- 							placeholder="Name" /> -->
<!-- 					</div> -->
<!-- 					<div class="mb-3"> -->
<!-- 						<label class="form-label" for="basic-form-email">이메일</label> <input -->
<!-- 							class="form-control" id="basic-form-email" type="email" -->
<!-- 							placeholder="name@example.com" /> -->
<!-- 					</div> -->
<!-- 					<div class="mb-3"> -->
<!-- 						<label class="form-label" for="basic-form-password">비밀번호<span >초기 비밀번호는 자동으로 사번이 부여됩니다.</span></label> <input -->
<!-- 							class="form-control" id="basic-form-password" type="password" -->
<!-- 							placeholder="Password" /> -->
<!-- 					</div> -->
<!-- 					<div class="mb-3"> -->
<!-- 						<label class="form-label" for="basic-form-dob">생년월일</label> <input -->
<!-- 							class="form-control" id="basic-form-dob" type="date" /> -->
<!-- 					</div> -->
<!-- 					<div class="mb-3"> -->
<!-- 						<label class="form-label" for="basic-form-gender">부서</label> <select -->
<!-- 							class="form-select" id="basic-form-gender" -->
<!-- 							aria-label="Default select example"> -->
<!-- 							<option selected="selected">부서 선택</option> -->
<!-- 							<option value="FTO">프론트오피스</option> -->
<!-- 							<option value="HKP">하우스키핑</option> -->
<!-- 							<option value="FMT">시설관리부</option> -->
<!-- 							<option value="CRM">고객관리부</option> -->
<!-- 							<option value="POS">재무부</option> -->
<!-- 							<option value="HRM">인사부</option> -->
<!-- 							<option value="other">신규</option> -->
<!-- 						</select> -->
<!-- 					</div> -->
<!-- 					<div class="mb-3"> -->
<!-- 						<div class="form-check"> -->
<!-- 							<input class="form-check-input" id="flexRadioDefault1" -->
<!-- 								type="radio" name="flexRadioDefault" /><label -->
<!-- 								class="form-check-label mb-0" for="flexRadioDefault1">STF</label> -->
<!-- 						</div> -->
<!-- 						<div class="form-check"> -->
<!-- 							<input class="form-check-input" id="flexRadioDefault2" -->
<!-- 								type="radio" name="flexRadioDefault" checked="checked" /><label -->
<!-- 								class="form-check-label mb-0" for="flexRadioDefault2">DPM</label> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="mb-3"> -->
<!-- 						<label class="form-label">프로필 사진 등록</label> <input -->
<!-- 							class="form-control" type="file" /> -->
<!-- 					</div> -->
<!-- 					<div class="mb-3"> -->
<!-- 						<label class="form-label" for="basic-form-textarea">기타사항</label> -->
<!-- 						<textarea class="form-control" id="basic-form-textarea" rows="3" -->
<!-- 							placeholder="Description"></textarea> -->
<!-- 					</div> -->
<!-- 					<button class="btn btn-primary" type="submit">제출</button> -->
<%-- 				</form> --%>
<!-- 			</div> -->