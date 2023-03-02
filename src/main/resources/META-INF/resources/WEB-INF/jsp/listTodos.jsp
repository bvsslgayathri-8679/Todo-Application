<%@ include file="common/header.jspf" %>

	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<table class="table">
			<h3>Your todos</h3>
			<thead>
				<!-- <th>id</th> -->
				<th>description</th>
				<th>Target date</th>
				<th>is done?</th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<!-- <td>${todo.id}</td> -->
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
						<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>
	</div>
<%@ include file="common/footer.jspf"%>