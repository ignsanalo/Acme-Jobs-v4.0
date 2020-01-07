<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.solimek.form.label.text" path="text" />
	<acme:form-textbox code="employer.solimek.form.label.moreInfo" path="moreInfo" />

	<acme:form-return code="employer.solimek.form.button.return" />

</acme:form>