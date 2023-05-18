package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static Map <Integer, Empresa> idEmpresa = new HashMap<>(); 
	private static List<Usuario> listaUsuarios = new ArrayList<>();
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
		
		Usuario u1 = new Usuario();
		u1.setLogin("lucas");
		u1.setSenha("12345");
		Usuario u2 = new Usuario();
		u2.setLogin("fabiola");
		u2.setSenha("12345");
		Banco.listaUsuarios.add(u1);
		Banco.listaUsuarios.add(u2);
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

	public Empresa busca(Integer id) {
		return Banco.idEmpresa.get(id);
	}
	
	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario : Banco.listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
