package br.com.mesttra.bancomil.util;


public class Menu {

	public void cabecalho() {
		System.out.println("==============================-Banco 1000-==============================");
	}

	public void opcoes() {
		System.out.println("OPERAÇÕES:");
		System.out.println("\t - Cadastrar cliente \t\t [1]");
		System.out.println("\t - Consultar cliente \t\t [2]");
		System.out.println("\t - Remover cliente \t\t [3]");
		System.out.println("\t - Realizar transferência \t [4]");
		System.out.println("\t - Alterar limite \t\t [5]");
		System.out.println("\t - Depositar em conta \t\t [6]");
		System.out.println("\t - Clientes devedores \t\t [7]");
		System.out.println("\t - Gerar relatório \t\t [8]\n");
		System.out.println("\t - SAIR DO SISTEMA \t\t [0]\n");
		System.out.print("\t OPERAÇÃO: ");
	}

	public void opcaoCadastro() {
		System.out.println("====================-Cadastro de cliente-====================");
		System.out.println("OPERAÇÕES:");
		System.out.println("\t - Cadastrar cliente PJ \t\t [1]");
		System.out.println("\t - Cadastrar cliente PF \t\t [2]\n");
		System.out.println("\t - CANCELAR OPERAÇÃO \t\t\t [0]\n");
		System.out.print("\t OPERAÇÃO: ");
	}

	public void consultarCliente() {
		System.out.println("====================-Consulta de cliente-====================");
		System.out.print("Número da conta: ");
	}

	public void removerCliente() {
		System.out.println("====================-Remover cliente-====================");
		System.out.print("Número da conta: ");
	}

	public void transferenciaBancaria() {
		System.out.println("====================-Realizar transferência-====================");
	}

	public void transFonte() {
		System.out.print("Número da conta depositante: ");
	}

	public void transDestino() {
		System.out.print("Número da conta de destino: ");
	}

	public void valorTrans() {
		System.out.print("Valor da transferência: ");
	}

	public void alterarLimite() {
		System.out.println("====================-Alterar limite-====================");
		System.out.print("Número da conta: ");
	}
	
	public void deposito() {
		System.out.println("====================-Realizar depósito-====================");
		System.out.print("Número da conta: ");
	}
	
	public void valorDeposito() {
		System.out.print("Valor a ser depositado: ");
	}

	public void sairDoSistema() {
		System.out.println("SAINDO DO SISTEMA...");
	}
	
	public void clientesDevedores() {
		System.out.println("====================-Consulta de devedores-====================");
	}

	public void relatorio() {
		System.out.println("====================-Relatório de clientes-====================");
	}
	
}


