package interfaces;

import java.sql.SQLException;
import java.util.List;

public interface Acoes<T> {
	public T inserir(T t) throws ClassNotFoundException, SQLException;
	public T atualizar(T t);
	public List<T> selecionarTodos();
	public T selecionarPorId(int id);
	public int deletar(int id);
}
