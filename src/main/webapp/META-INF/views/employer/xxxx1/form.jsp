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
	<acme:form-textbox code="employer.xxxx1.form.label.text" path="text" />
	<acme:form-url code="employer.xxxx1.form.label.moreInfo" path="moreInfo" />
	
	<jstl:if test="${command == 'create'}">
		<acme:form-submit test="${command == 'create'}" code="employer.xxxx1.form.button.create"
		action="/employer/xxxx1/create?id=${id}" />
	</jstl:if>
	

	<acme:form-return code="employer.xxxx1.form.button.return" />

</acme:form>