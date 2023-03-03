package model;

public class X {
	private String _nome;
	private int _codigo;
	private double _precoCusto;
	private double _precoVenda;
	private int _quantidade;
	
	
	public X (String nome, int codigo, double precoCusto,
					double precoVenda, int quantidade) {
		_nome = nome;
		_codigo = codigo;
		_precoCusto = precoCusto;
		_precoVenda = precoVenda;
		_quantidade = quantidade;
	}


	public String getNome() {
		return _nome;
	}


	public int getCodigo() {
		return _codigo;
	}

	public double getPrecoCusto() {
		return _precoCusto;
	}


	public double getPrecoVenda() {
		return _precoVenda;
	}


	public int getQuantidade() {
		return _quantidade;
	}
	
	public String toString() {
		return "X [nome = " + _nome + ", codigo = " + _codigo +
				", preco custo = " + _precoCusto + 
				", preco venda = " + _precoVenda +
				", quantidade = " + _quantidade + "]";
	}	
}
