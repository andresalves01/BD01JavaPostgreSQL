package app;

import java.util.List;
import java.util.Scanner;

import dao.XDAO;
import model.X;

public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		XDAO produtoDAO = new XDAO();
		
		Scanner scanner = new Scanner (System.in);
		while(true) {
			System.out.println ("\n\n==== Gerenciador de Xs" + 
								"Lista de Comandos === ");
			System.out.println("1) Inserir");
			System.out.println("2) Listar");
			System.out.println("3) Atualizar");
			System.out.println("4) Excluir");
			System.out.println("5) Sair");
			
			try {
				int comando = scanner.nextInt();
				switch (comando) {
					case 1:	
						System.out.println("\n\n==== Inserir produto === ");
						System.out.println ("Informe nome, código, preço de custo, preço de venda" +
											" e quantidade do produto que será inserido.");
						String nome = scanner.next();
						int codigo = Integer.parseInt(scanner.next());
						double precoCusto = Double.parseDouble(scanner.next());
						double precoVenda = Double.parseDouble(scanner.next());
						int quantidade = Integer.parseInt(scanner.next());
						X produto = new X (nome, codigo, precoCusto, precoVenda, quantidade);
						if(produtoDAO.insert(produto) == true) {
							System.out.println("Inserção com sucesso -> " + produto.toString());
						} else {
							System.out.println("Inserção falhou.");
						}
						break;
						
					case 2:
						System.out.println("\n\n==== Listar produtos === ");
						List<X> produtos = produtoDAO.getOrderByCodigo();
						for(X p : produtos) {
							System.out.println(p.toString());
						}
						break;
						
					case 3:
						System.out.println ("\n\n==== Atualizar produto === ");
						System.out.println ("Informe o novo nome, o código antigo, o novo preço de custo, " +
											"o novo preço de venda e a nova quantidade do produto" +
											" que será alterado.");
						X produtoProcurado = new X (scanner.next(), scanner.nextInt(), 
																scanner.nextDouble(),scanner.nextDouble(),
																scanner.nextInt());
						if (produtoDAO.update(produtoProcurado) == true) {
							System.out.println("Alteração com sucesso -> " + produtoProcurado.toString());
						} else {
							System.out.println("Alteração falhou.");
						}
						break;
						
					case 4:
						System.out.println ("\n\n==== Excluir produto === ");
						System.out.println ("Informe o código do produto que será excluido.");
						if(produtoDAO.delete(scanner.nextInt()) == true) {
							System.out.println("Excluído com sucesso");
						} else {
							System.out.println("A exclusão falhou");
						}
						break;
						
					case 5:
						System.out.println ("\n\n==== Saindo.. === ");
						scanner.close();
						produtoDAO.finalize();
						return;
						
					default:
						System.out.println ("Entrada inválida, tente novamente.");
						break;
				}
			} catch (Exception e) {  
				System.out.println("Houve um erro, tente novamente.");
			}
		}
	}
}