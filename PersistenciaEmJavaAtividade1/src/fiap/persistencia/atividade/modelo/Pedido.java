package fiap.persistencia.atividade.modelo;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import fiap.persistencia.atividade.utils.Utils;

public class Pedido {
	private int id;
	private int idCliente;
	private Calendar data;
	private String descricao;
	private double valor;
	
	public Pedido(int id, int idCliente, Calendar data, String descricao, double valor){
		this.id 	   = id;
		this.idCliente = idCliente;
		this.data	   = data;
		this.descricao = descricao;
		this.valor     = valor;
	}
	
	public Pedido(int id, int idCliente, Date data, String descricao, double valor){
		this.id 	   = id;
		this.idCliente = idCliente;
		this.data	   = Utils.toCalendar(data);
		this.descricao = descricao;
		this.valor     = valor;
	}
	
	public String toString(){
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return "id: "+ this.id+
				" idCliente: "+ this.idCliente+
				" data: "+ df.format(this.data.getTime())+
				" descricao: "+this.descricao+
				" valor: "+this.valor;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
