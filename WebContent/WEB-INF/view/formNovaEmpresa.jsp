<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="LinkEntradaServlet" />
<html>
	<body>
		<c:import url="logout-parcial.jsp"/>
		<form action="${LinkEntradaServlet }" method="post">
			Nome: <input type="text" name="nome">
			Data abertura: <input type="text" name="data">
			<input type="hidden" name="acao" value="NovaEmpresa">
			<input type="submit">
		</form>
	</body>
</html>