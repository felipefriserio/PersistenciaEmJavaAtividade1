package fiap.persistencia.atividade.interfaces;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import fiap.persistencia.atividade.modelo.Pedido;

public interface PedidoDao {
	public boolean insert(int id, int idCliente, Calendar data, String descricao, double valor) throws SQLException;
	public boolean delete(int id) throws SQLException;
	public Pedido get(int id) throws SQLException;
	public boolean update(int id, int idCliente, Calendar data, String descricao, double valor) throws SQLException;
	public List<Pedido> pedidosDoCliente(int idCliente) throws SQLException;
}
