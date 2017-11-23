package fiap.persistencia.atividade.interfaces;

import java.sql.SQLException;

import fiap.persistencia.atividade.modelo.Cliente;

public interface ClienteDao {
	public boolean insert(int idCliente, String nome, String email) throws SQLException;
	public boolean delete(int idCliente) throws SQLException;
	public Cliente get(int idCliente) throws SQLException;
	public boolean update(int idCliente, String nome, String email) throws SQLException;
}
