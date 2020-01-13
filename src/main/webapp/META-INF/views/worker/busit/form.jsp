<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.busit.form.label.text" path="text" />
	<acme:form-textbox code="employer.busit.form.label.moreInfo" path="keylet" />

	<acme:form-return code="employer.busit.form.button.return" />

</acme:form>