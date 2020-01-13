<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.busit.form.label.text" path="text" />
	<acme:form-textbox code="employer.busit.form.label.keylet" path="keylet" />
	
	<acme:form-submit test="${command =='create' }" code="employer.busit.form.button.create" action="/employer/busit/create?id=${id}" />
	

	<acme:form-return code="employer.busit.form.button.return" />

</acme:form>