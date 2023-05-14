<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/alteraEmpresa" var="linkServletNovaEmpresa" />
<html>
	<body>
		
		<form action="${linkServletNovaEmpresa }" method="post">
			Nome: <input type="text" name="nome" value="${empresa.nome}">
			Data abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>">
			Id: <input type="hidden" name="id" value="${empresa.id}">
			<input type="submit">
		</form>
	</body>
</html>