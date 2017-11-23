package fiap.persistencia.atividade.mySqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fiap.persistencia.atividade.factory.MySqlDaoFactory;
import fiap.persistencia.atividade.interfaces.PedidoDao;
import fiap.persistencia.atividade.modelo.Pedido;
import fiap.persistencia.atividade.utils.Utils;

public class MySqlPedidoDao implements PedidoDao{

	@Override
	public boolean insert(int id, int idCliente, Calendar data, String descricao, double valor) throws SQLException {
		Connection conn      = MySqlDaoFactory.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("insert into Pedido (id, idCliente, data, descricao, valor ) values (?,?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setInt(2, idCliente);
			new Utils();
			ps.setDate(3,(java.sql.Date) Utils.toDate(data));
			ps.setString(4, descricao);
			ps.setDouble(5, valor);
			
			// ps.executeUpdate() = num linhas afetadas na execucao da query
			return (ps.executeUpdate() > 0) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
			ps.close();
		}
		return false;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		Connection conn      = MySqlDaoFactory.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("delete from Pedido where id = ?");
			ps.setInt(1, id);
			
			// ps.executeUpdate() = num linhas afetadas na execucao da query
			return (ps.executeUpdate() > 0) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
			ps.close();
		}
		return false;
	}

	@Override
	public Pedido get(int id) throws SQLException {
		Connection conn      = MySqlDaoFactory.getConnection();
		Pedido pedido        = null;
		PreparedStatement ps = null;
		ResultSet rs 		 = null;
		
		try {
			ps = conn.prepareStatement("select * from Pedido where id = ?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			rs.next();
			
			pedido = new Pedido(rs.getInt("id"), 
							rs.getInt("idCliente"), 
							rs.getDate("data"), 
							rs.getString("descricao"), 
							rs.getDouble("valor"));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
			ps.close();
			rs.close();
		}
		return pedido;
	}

	public boolean update(int id, int idCliente, Calendar data, String descricao, double valor) throws SQLException {
		Connection conn      = MySqlDaoFactory.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("update Pedido set idCliente = ?, data = ?, descricao = ?, valor = ? where id = ?");
			
			ps.setInt(5, id);
			ps.setInt(1, idCliente);
			ps.setDate(2, (java.sql.Date) Utils.toDate(data));
			ps.setString(3, descricao);
			ps.setDouble(4, valor);
			
			// ps.executeUpdate() = num linhas afetadas na execucao da query
			return (ps.executeUpdate() > 0) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
			ps.close();
		}
		return false;
	}

	@Override
	public List<Pedido> pedidosDoCliente(int idCliente) throws SQLException {
		List<Pedido> listaDePedidosDoCliente = new ArrayList<Pedido>();
		Connection conn      = MySqlDaoFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("select id, idCliente, data, descricao, valor from Pedido where idCliente = ?");
			ps.setInt(1, idCliente);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				listaDePedidosDoCliente.add(
						new Pedido(rs.getInt("id"), 
								   rs.getInt("idCliente"), 
								   rs.getDate("data"), 
								   rs.getString("descricao"), 
								   rs.getDouble("valor")
							)
						);
			}
			
			return listaDePedidosDoCliente;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
			ps.close();
			rs.close();
		}
		return listaDePedidosDoCliente;
	}

	
	

}
