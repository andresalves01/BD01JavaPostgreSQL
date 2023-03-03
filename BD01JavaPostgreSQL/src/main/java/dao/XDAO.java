package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.X;

public class XDAO extends DAO {
	public XDAO() {
		super ();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public boolean insert(X produto) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO produto (nome, codigo, custo, venda, quantidade) "
				       + "VALUES ('"+produto.getNome() + "', " + produto.getCodigo() + ", "  
				       + produto.getPrecoCusto() + ", " + produto.getPrecoVenda() + ", "
				       + produto.getQuantidade() + ");";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			System.out.println(u.toString());
		}
		return status;
	}
	
	private List<X> get(String orderBy) {
		List<X> produtos = new ArrayList<X>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	X p = new X( rs.getString("nome"), rs.getInt("codigo"), 
	        							rs.getDouble("custo"), rs.getDouble("venda"),
	        							rs.getInt("quantidade"));
	        	produtos.add(p);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produtos;
	}
	
	public List<X> getOrderByCodigo() {
		return get("codigo");
	}
	
	public List<X> getOrderbyNome(){
		return get("nome");
	}
	
	public List<X> getOrderbyPrecoCusto(){
		return get("preco custo");
	}
	
	public List<X> getOrderbyPrecoVenda(){
		return get("preco venda");
	}
	
	public List<X> getOrderbyQuantidade(){
		return get("preco custo");
	}
	
	public boolean update(X produto) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE produto SET nome = '" + produto.getNome()
					   + "', custo = '" + produto.getPrecoCusto() 
					   + "', venda = '" + produto.getPrecoVenda() 
					   + "', quantidade = '" + produto.getQuantidade() + "' "
					   + "WHERE codigo = " + produto.getCodigo();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			System.out.println(u.toString());
		}
		return status;
	}
	
	public boolean delete(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM produto WHERE codigo = " + codigo;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			System.out.println(u.toString());
		}
		return status;
	}

}
