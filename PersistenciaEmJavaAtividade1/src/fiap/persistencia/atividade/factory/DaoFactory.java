package fiap.persistencia.atividade.factory;

import fiap.persistencia.atividade.interfaces.ClienteDao;
import fiap.persistencia.atividade.interfaces.PedidoDao;

public abstract class DaoFactory {
	public static final int MYSQL = 1;

	public abstract ClienteDao getClienteDao();
	public abstract PedidoDao getPedidoDao();
	
	public static DaoFactory getDaoFactory(int tipo){
		switch (tipo) {
		case MYSQL: return new MySqlDaoFactory();
		default: return null;
		}
		
	}

}
