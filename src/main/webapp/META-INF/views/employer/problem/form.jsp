<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.problem.form.label.title" path="text" />
	<acme:form-url code="employer.problem.form.label.description" path="moreInfo" />
	
	<acme:form-hidden path="id"/>
	<acme:form-hidden path="jobId"/>
	
	<jstl:if test="${command == 'create'}">
		<acme:form-submit test="${command == 'create'}" code="employer.problem.form.button.create"
		action="/employer/problem/create" />
	</jstl:if>
	

	<acme:form-return code="employer.problem.form.button.return" />

</acme:form>
