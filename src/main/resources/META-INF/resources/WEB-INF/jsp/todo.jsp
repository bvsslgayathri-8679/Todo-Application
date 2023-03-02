<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h3>Enter Todo Details</h3>
	<!-- <p>${Size}</p>  -->
	<form:form method="post" modelAttribute="todo">
		<!-- modelAttribute="todo" maps to todo bean -->
		<fieldset class="mb-3">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>
		<fieldset class="mb-3">
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="date" path="targetDate" required="required"
				class="DatePicker" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>
		<!-- for jsp css warning -> cssClass="text-warning" -->
		<!-- form:error -> for validation error then no need of model.put and ${Size} -->
		<!-- path="description is also for mapping.. remove name="description" -->
		<!-- Hidden variables for id and done, coz of validation error ( Validation failed for argument,Field error in object 'todo' on field 'id': rejected value [null]; codes) -->
		<form:input type="hidden" path="id" />
		<!-- try removing hidden and check once-->
		<form:input  path="done" />
		<input type="submit" class="btn btn-success" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>