<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-double code="administrator.dashboard.form.jobsSolimekRatio" path="jobsSolimekRatio"/>
	<acme:form-double code="administrator.dashboard.form.answerRatio" path="answerRatio"/>
	<acme:form-double code="administrator.dashboard.form.applicationTicketRatio" path="applicationTicketRatio"/>
	<acme:form-return code="administrator.dashboard.form.button.return" />
</acme:form>