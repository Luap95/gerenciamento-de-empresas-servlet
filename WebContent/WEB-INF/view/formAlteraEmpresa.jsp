<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entrada" var="linkEntradaServlet" />
<html>
	<body>
		<c:import url="logout-parcial.jsp"/>
		<form action="${linkEntradaServlet }" method="post">
			Nome: <input type="text" name="nome" value="${empresa.nome}">
			Data abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>">
			<input type="hidden" name="id" value="${empresa.id}">
			<input type="hidden" name="acao" value="AlteraEmpresa">
			<input type="submit">
	</body>
</html>