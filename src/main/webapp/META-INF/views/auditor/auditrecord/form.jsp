<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="auditor.auditrecord.form.label.title" path="title"/>
	<jstl:if test="${command != 'create'}">
	<acme:form-moment code="auditor.auditrecord.form.label.moment" path="moment"/>
	</jstl:if>
	<acme:form-textbox code="auditor.auditrecord.form.label.body" path="body"/>
	<acme:form-textbox code="auditor.auditrecord.form.label.status" path="finalMode"/>
	
	<acme:form-submit test="${command == 'create'}" code="auditor.auditrecord.form.button.create"
		action="/auditor/auditrecord/create" />
	
	
	
	<acme:form-return code="auditor.job.form.button.return"/>
</acme:form>