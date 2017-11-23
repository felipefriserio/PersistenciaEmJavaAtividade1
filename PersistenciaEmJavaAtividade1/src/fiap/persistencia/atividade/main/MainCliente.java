package fiap.persistencia.atividade.main;

import java.sql.SQLException;

import fiap.persistencia.atividade.factory.DaoFactory;

public class MainCliente {
	public static void main(String[] args) {
		try {
			int id = 10;
			String nome  = "Teste nome";
			String email = "Teste email";		
			
			// testa insert 
			System.out.println((DaoFactory.getDaoFactory(DaoFactory.MYSQL).getClienteDao().insert(id, nome, email)) ? "cliente inserido" : "erro ao inserir");
						
			// testa busca
			System.out.println((DaoFactory.getDaoFactory(DaoFactory.MYSQL).getClienteDao().get(id).toString()));
						
			//testa update 
			System.out.println((DaoFactory.getDaoFactory(DaoFactory.MYSQL).getClienteDao().update(id, nome+" atualizado", email+" atualizado") ? "cliente atualizado" : "erro ao atualizar"));
			System.out.println((DaoFactory.getDaoFactory(DaoFactory.MYSQL).getClienteDao().get(id).toString()));
			
			// testa delete 
			System.out.println((DaoFactory.getDaoFactory(DaoFactory.MYSQL).getClienteDao().delete(id)) ? "cliente deletado" : "erro ao deletar");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
