package fiap.persistencia.atividade.mySqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fiap.persistencia.atividade.factory.MySqlDaoFactory;
import fiap.persistencia.atividade.interfaces.ClienteDao;
import fiap.persistencia.atividade.modelo.Cliente;

public class MySqlClienteDao implements ClienteDao{

	@Override
	public boolean insert(int idCliente, String nome, String email) throws SQLException {
		Connection conn      = MySqlDaoFactory.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("insert into Cliente (id,nome,email) values (?,?,?)");
			
			ps.setInt(1, idCliente);
			ps.setString(2, nome);
			ps.setString(3, email);
			
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
	public boolean delete(int idCliente) throws SQLException {
		Connection conn      = MySqlDaoFactory.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("delete from Cliente where id = ?");
			ps.setInt(1, idCliente);
			
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
	public Cliente get(int idCliente) throws SQLException {
		Connection conn      = MySqlDaoFactory.getConnection();
		Cliente cliente      = null;
		PreparedStatement ps = null;
		ResultSet rs 		 = null;
		
		try {
			ps = conn.prepareStatement("select * from Cliente where id = ?");
			ps.setInt(1, idCliente);
			
			rs = ps.executeQuery();
			rs.next();
			
			cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
			ps.close();
			rs.close();
		}
		return cliente;
	}

	public boolean update(int idCliente, String nome, String email) throws SQLException {
		Connection conn      = MySqlDaoFactory.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("update Cliente set nome = ?, email = ? where id = ?");
			
			ps.setInt(3, idCliente);
			ps.setString(1, nome);
			ps.setString(2, email);
			
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

}
