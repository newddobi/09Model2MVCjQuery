<%@page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>구매 목록조회</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">

	function fncGetPurchaseList(currentPage) {
		
		$("#currentPage").val(currentPage);
		$("form").attr("method", "POST").attr("action", "/purchase/listPurchase").submit();
		
	}
	
	function fncDeletePurchase(){
		if(confirm("정말 취소하시겠습니까?") == true){
			
		$("#tranNo").val($(this).parent().find('.tranNo').text().trim());
		$("form").attr("method", "POST").attr("action", "/purchase/deletePurchase").submit();
				
		}else{
			return;
		}
	}
	
	$(function(){
		$("td.ct_btn01:contains('검색')").on("click", function(){
			fncGetPurchaseList(1);
		});
		
		$("td.deleteOrUpdate:contains('구매취소')").on("click", function(){
			fncDeletePurchase();
		});
		
		$("td.deleteOrUpdate:contains('물건도착')").on("click", function(){
			self.location="/purchase/updateTranCode?prodNo=${purchase.purchaseProd.prodNo}&tranCode=${purchase.tranCode}"
		});
		
		$(".ct_list_pop td:nth-child(11)" ).css("color" , "red");
		
		$(".ct_list_pop:nth-child(4n+6)" ).css("background-color" , "whitesmoke");
		
	});
	
</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width: 98%; margin-left: 10px;">

<form name="detailForm">
<input type="hidden" id="tranNo" name="tranNo" value=""/>

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left: 10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">구매 목록조회</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37"><img src="/images/ct_ttl_img03.gif"	width="12" height="37"></td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td>
			<select name="pageCondition" class="ct_input_g" style="width:80px">
				<option value="" ${ ! empty search.pageSize && search.pageSize.equals("") ? "selected" : "" }>게시물개수</option>
				<option value="4" ${ ! empty search.pageSize && search.pageSize==4 ? "selected" : "" }>4</option>
				<option value="5" ${ ! empty search.pageSize && search.pageSize==5 ? "selected" : "" }>5</option>
				<option value="6" ${ ! empty search.pageSize && search.pageSize==6 ? "selected" : "" }>6</option>
				<option value="7" ${ ! empty search.pageSize && search.pageSize==7 ? "selected" : "" }>7</option>
				<option value="8" ${ ! empty search.pageSize && search.pageSize==8 ? "selected" : "" }>8</option>
				<option value="9" ${ ! empty search.pageSize && search.pageSize==9 ? "selected" : "" }>9</option>
				<option value="10" ${ ! empty search.pageSize && search.pageSize==10 ? "selected" : "" }>10</option>
			</select>
		</td>
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23">
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						검색
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top: 10px;">
	<tr>
		<td colspan="11">전체 ${resultPage.totalCount} 건수, 현재 ${resultPage.currentPage} 페이지</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">회원ID</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">회원명</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">상품명</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">배송현황</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">정보수정</td>
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>

	<c:set var="i" value="0"/>
		<c:forEach var="purchase" items="${list}">
			<c:set var="i" value="${i+1}" />
			<tr class="ct_list_pop">
			
				<td align="center">
					<a href="/purchase/getPurchase?tranNo=${purchase.tranNo}">${ i }</a>
				</td>
				<td></td>			
				<td align="left">
					<a href="/user/getUser?userId=${purchase.buyer.userId}">${purchase.buyer.userId}</a>
				</td>
				<td></td>
				<td align="left">${purchase.receiverName}</td>
				<td></td>
				<td align="left">${purchase.purchaseProd.prodName}</td>
				<td></td>
				<td align="left">
					<c:choose>
						<c:when test="${purchase.tranCode eq '3' }">
							현재 구매완료 상태입니다.
						</c:when>
						<c:when test="${purchase.tranCode eq '2' }">
							현재 배송중 입니다.
						</c:when>
						<c:when test="${purchase.tranCode eq '1' }">
							현재 배송완료 상태입니다.
						</c:when>
					</c:choose>
				</td>
				<td></td>
				<td align="left" class="deleteOrUpdate">
					<c:choose>
						<c:when test="${purchase.tranCode eq '3' }">
							구매취소							
						</c:when>
						<c:when test="${purchase.tranCode eq '2'}">
							물건도착
						</c:when>
					</c:choose>
				</td>				
				<input type="hidden" class="tranNo" value="${purchase.tranNo}"/>
			</tr>
			<tr>
				<td colspan="11" bgcolor="D6D7D6" height="1"></td>
			</tr>	
		</c:forEach>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 10px;">
	<tr>
		<td align="center">
			<input type="hidden" id="currentPage" name="currentPage" value=""/>

			<jsp:include page="../common/pageNavigator.jsp">
				<jsp:param name="what" value="Purchase"/>
			</jsp:include>	
		</td>
	</tr>
</table>

<!--  페이지 Navigator 끝 -->
</form>

</div>

</body>
</html>