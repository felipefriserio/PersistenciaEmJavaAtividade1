package fiap.persistencia.atividade.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fiap.persistencia.atividade.interfaces.ClienteDao;
import fiap.persistencia.atividade.interfaces.PedidoDao;
import fiap.persistencia.atividade.mySqlDao.MySqlClienteDao;
import fiap.persistencia.atividade.mySqlDao.MySqlPedidoDao;

public class MySqlDaoFactory extends DaoFactory{
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:8889/PersistenciaJava", "sistema", "fiap");
	}
	
	@Override
	public ClienteDao getClienteDao() {
		return new MySqlClienteDao();
	}

	@Override
	public PedidoDao getPedidoDao() {
		return new MySqlPedidoDao();
	}
}
