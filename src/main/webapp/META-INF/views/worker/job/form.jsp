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

	<acme:form-textbox code="worker.job.form.label.reference" path="reference" />
	<acme:form-textbox code="worker.job.form.label.title" path="title" />
	<acme:form-moment code="worker.job.form.label.deadline" path="deadline" />
	<acme:form-money code="worker.job.form.label.salary" path="salary" />
	<acme:form-url code="worker.job.form.label.moreInfo" path="moreInfo" />
	<acme:form-textarea code="worker.job.form.label.description" path="description" />
	
	<acme:form-submit code="auditor.job.form.label.auditRecord" method="get" 
	action="/authenticated/auditrecord/list-by-job?id=${id}"/>
	
	<acme:form-submit code="employer.job.form.button.duty-list" method="get" 
		action="/authenticated/duty/list-by-job?id=${id}"/>
		
	<acme:form-submit code="worker.job.application.form.button.apply" method="get"
		action="/worker/application/create?id=${id}"/>
	
	<acme:form-return code="worker.job.form.button.return" />
	
</acme:form>
