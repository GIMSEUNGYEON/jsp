<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>calendar</title>

    <style>
	    h1{
			text-align:center;
		}
		
		div{
			contents-align:center;
		}
        table {
            border: 1px solid;
        }
        th {
            height: 50px;
            width: 70px;
            border: 1px solid;
            background-color:  Lightblue;
        }
        td {
            text-align: center;
            border: 1px solid;
            height: 50px;
            width: 70px;
            background-color: white;  
        }
        input.btn {
            height: 50px;
            width: 70px;
            background-color:  white;
            font-size: 30px;
        }
        .year_mon{
            font-size: 25px;
        }
        .Today{
            background-color: Yellowgreen;
        }
        th.son{
           color: red;
        }

        th.sat{
           color: blue;
        
        }

    </style>

    <script>
        $(function(){
            var today = new Date();
            var date = new Date();           

            $("input[name=preMon]").click(function() { // 이전달
                $("#calendar > tbody > td").remove();
                $("#calendar > tbody > tr").remove();
                today = new Date ( today.getFullYear(), today.getMonth()-1, today.getDate());
                buildCalendar();
            })
            
            $("input[name=nextMon]").click(function(){ //다음달
                $("#calendar > tbody > td").remove();
                $("#calendar > tbody > tr").remove();
                today = new Date ( today.getFullYear(), today.getMonth()+1, today.getDate());
                buildCalendar();
            })


            function buildCalendar() {
                
                nowYear = today.getFullYear();
                nowMonth = today.getMonth();
                firstDate = new Date(nowYear,nowMonth,1).getDate();
                firstDay = new Date(nowYear,nowMonth,1).getDay(); //1st의 요일
                lastDate = new Date(nowYear,nowMonth+1,0).getDate();

                if((nowYear%4===0 && nowYear % 100 !==0) || nowYear%400===0) { //윤년 적용
                    lastDate[1]=29;
                }

                $(".year_mon").text(nowYear+"년 "+(nowMonth+1)+"월");

                for (i=0; i<firstDay; i++) { //첫번째 줄 빈칸
                    $("#calendar tbody:last").append("<td></td>");
                }
                for (i=1; i <=lastDate; i++){ // 날짜 채우기
                    plusDate = new Date(nowYear,nowMonth,i).getDay();
                    if (plusDate==0) {
                        $("#calendar tbody:last").append("<tr></tr>");
                    }
                    $("#calendar tbody:last").append("<td class='date'>"+ i +"</td>");
                }
                if($("#calendar > tbody > td").length%7!=0) { //마지막 줄 빈칸
                    for(i=1; i<= $("#calendar > tbody > td").length%7; i++) {
                        $("#calendar tbody:last").append("<td></td>");
                    }
                }
                $(".date").each(function(index){ // 오늘 날짜 표시
                    if(nowYear==date.getFullYear() && nowMonth==date.getMonth() 
                    		&& $(".date").eq(index).text()==date.getDate()) {
                        $(".date").eq(index).addClass('Today');
                    }
                }) 
            }
            buildCalendar();
        })
    </script>

</head>
<body>
<h1>
		<a href="" name="preMon">◀◀◀</a>
		2023, November
		<a href="" name="nextMon">▶▶▶</a>
	</h1>
	
	<form id="selectDay">
		<div>
			YEAR : 
			<input type="number" value="2023" id="year" name="year"/>
			MONTH : 
			<select id="month" name="month"> </select>
		</div>
	</form>
	
	<br>
    <table colspan="1px" id="calendar">
        <thead>
            <tr>
                <th><input name="preMon" type="button" value="◀" class="btn"></th>
                <th colspan="5" class="year_mon"></th>
                <th><input name="nextMon" type="button" value="▶" class="btn"></th>
            </tr>
            <tr colspan="1px">
                <th class="son">일</th>
                <th>월</th>
                <th>화</th>
                <th>수</th>
                <th>목</th>
                <th>금</th>
                <th class="sat" >토</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</body>
</html>