package classes;

public class Funcionario extends Pessoa {
	private int id;
	private int registro;
	private String login;
	private String senha;
	
	public int getRegistro() {
		return registro;
	}
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public static void test() {
		System.out.println("Olá");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
