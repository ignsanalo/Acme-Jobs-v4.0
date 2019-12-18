<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="auditor.auditrecord.form.label.title" path="title"/>

	<acme:form-textbox code="auditor.auditrecord.form.label.body" path="body"/>
	
	<acme:form-textbox code="auditor.auditrecord.form.label.status" path="finalMode"/>
	
	<acme:form-submit test="${command == 'create'}" code="auditor.auditrecord.form.button.create"
		action="/auditor/auditrecord/create?id=${id}"/>
	<acme:form-submit test="${command == 'show' && !finaMode}" code="auditor.auditrecord.form.button.update"
		action="/auditor/auditrecord/update"/>
	<acme:form-submit test="${command == 'update'}" code="auditor.auditrecord.form.button.update"
		action="/auditor/auditrecord/update"/>		
		
	
	<acme:form-return code="auditor.job.form.button.return"/>
</acme:form>