<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurants</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link href="/temp.css" rel="stylesheet" />
<link href="/style.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h1>Welcome to the Restaurant Rater!</h1>
		<a href="/">Sort by name</a>
		<div></div>
		<a href="/rating">Sort by rating</a>
		<table class="table">
			<thead>
				<tr>
					<th>Restaurant</th>
					<th>Score</th>
					<th>Rate</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="restaurant" items="${ restaurants }">
					<tr>
						<td>${ restaurant.name }</td>
						<td>${ restaurant.rating }</td>
						<td><a href="/upvote/?id=${ restaurant.id }">Upvote</a> <span>
								or </span> <a href="/downvote/?id=${ restaurant.id }">Downvote</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>