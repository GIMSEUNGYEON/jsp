<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<a href="${pageContext.request.contextPath }/mbti/sync/mbtiInsert.do">새MBTI추가</a>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>순서</th>
			<th>유형</th>
			<th>타이틀</th>
		</tr>
	</thead>
	<tbody id="listBody">
	</tbody>
</table>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
		      <table>
				<tr>
					<th>순서</th>
					<td class="mtSort"></td>
				</tr>
				<tr>
					<th>유형</th>
					<td class="mtType"></td>
				</tr>
				<tr>
					<th>타이틀</th>
					<td class="mtTitle"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td class="mtContent"></td>
				</tr>
			</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<script src="${pageContext.request.contextPath }/resources/js/app/mbti/singleView.js"></script>










