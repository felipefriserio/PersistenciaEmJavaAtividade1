package fiap.persistencia.atividade.main;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import fiap.persistencia.atividade.factory.DaoFactory;
import fiap.persistencia.atividade.modelo.Pedido;

public class MainPedidoCliente {
	public static void main(String[] args) {
		try {
			int id = 4;
			int idCliente = 1;
			Calendar data = Calendar.getInstance();
			String descricao = "testa descricao 2";
			double valor = 10d;
			
			// testa insert 
			System.out.println((DaoFactory.getDaoFactory(DaoFactory.MYSQL).getPedidoDao().insert(id, idCliente, data, descricao, valor)) ? "pedido inserido" : "erro ao inserir");
			
			// testa busca 
			System.out.println((DaoFactory.getDaoFactory(DaoFactory.MYSQL).getPedidoDao().get(id).toString()));
						
			// testa update 
			System.out.println((DaoFactory.getDaoFactory(DaoFactory.MYSQL).getPedidoDao().update(id, idCliente, data, descricao + " UPDATE", valor + 100)) ? "pedido alterado" : "erro ao alterar");
			System.out.println((DaoFactory.getDaoFactory(DaoFactory.MYSQL).getPedidoDao().get(id).toString()));
			
			// testa lista pedidos de um cliente
			List<Pedido> listaDePedidos = (DaoFactory.getDaoFactory(DaoFactory.MYSQL).getPedidoDao().pedidosDoCliente(idCliente));
			for (Pedido pedido : listaDePedidos){
				System.out.println(pedido.toString());
			}
			
			// testa delete 
			System.out.println((DaoFactory.getDaoFactory(DaoFactory.MYSQL).getPedidoDao().delete(id)) ? "pedido deletado" : "erro ao deletar");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
