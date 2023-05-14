package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static Map <Integer, Empresa> idEmpresa = new HashMap<>(); 
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setId(Banco.chaveSequencial++);
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
		Banco.lista.add(empresa2);
		Banco.idEmpresa.put(empresa.getId(), empresa);
		Banco.idEmpresa.put(empresa2.getId(), empresa2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
		Banco.idEmpresa.put(empresa.getId(), empresa);
		
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void remove(Integer id) {
		Empresa empresa = Banco.idEmpresa.get(id);
		Banco.lista.remove(empresa);
		Banco.idEmpresa.remove(id);
	}

}
