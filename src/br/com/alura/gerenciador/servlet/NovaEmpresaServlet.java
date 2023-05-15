package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("Cadastrando nova empresa");
		//buscando parâmetro
		String nomeEmpresa = request.getParameter("nome");
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		
		String data = request.getParameter("data");
		Date dataAbertura;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = simpleDateFormat.parse(data);
		} catch (ParseException e1) {
			throw new ServletException(e1);
		}
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
	
		banco.getEmpresas().forEach(e -> System.out.println(e));
		
		response.sendRedirect("listaEmpresas");
		
		//chamar o JSP
//		RequestDispatcher rd = request.getRequestDispatcher("novaEmpresaCriada.jsp");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
		
	}

}
