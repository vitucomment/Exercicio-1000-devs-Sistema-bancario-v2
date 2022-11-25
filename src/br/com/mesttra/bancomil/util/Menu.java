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

	public void opcaoConsulta() {
		System.out.println("====================-Consulta de cliente-====================");
		System.out.println("OPERAÇÕES:");
		System.out.println("\t - Consultar cliente PJ \t\t [1]");
		System.out.println("\t - Consultar cliente PF \t\t [2]\n");
		System.out.println("\t - CANCELAR OPERAÇÃO \t\t\t [0]\n");
		System.out.print("\t OPERAÇÃO: ");
	}
	
	public void consultarClientePj() {
		System.out.println("====================-Consulta de cliente PJ-====================");
		System.out.print("Número da conta: ");
	}
	
	public void consultarClientePf() {
		System.out.println("====================-Consulta de cliente PF-====================");
		System.out.print("Número da conta: ");
	}
	
	public void opcaoRemocao() {
		System.out.println("====================-Remover cliente-====================");
		System.out.println("OPERAÇÕES:");
		System.out.println("\t - Remover cliente PJ \t\t [1]");
		System.out.println("\t - Remover cliente PF \t\t [2]\n");
		System.out.println("\t - CANCELAR OPERAÇÃO \t\t [0]\n");
		System.out.print("\t OPERAÇÃO: ");
	}
	
	public void opçoesTransferencia() {
		System.out.println("====================-Realizar transferência-====================");
		System.out.println("OPERAÇÕES:");
		System.out.println("\t - Transferencia PJ -> PF \t\t [1]");
		System.out.println("\t - Transferencia PJ -> PJ \t\t [2]");
		System.out.println("\t - Transferencia PF -> PJ \t\t [3]");
		System.out.println("\t - Transferencia PF -> PF \t\t [4]");
		System.out.println("\t - CANCELAR OPERAÇÃO \t\t\t [0]\n");
		System.out.print("\t OPERAÇÃO: ");
	}
	
	
	public void removerCliente() {
		System.out.println("====================-Remover cliente-====================");
		System.out.print("Número da conta: ");
	}

	
	public void opcaoAlterarLimite() {
		System.out.println("====================-Alterar limite-====================");
		System.out.println("OPERAÇÕES:");
		System.out.println("\t - Alterar limite cliente PJ \t\t [1]");
		System.out.println("\t - Alterar limite cliente PF \t\t [2]\n");
		System.out.println("\t - CANCELAR OPERAÇÃO \t\t\t [0]\n");
		System.out.print("\t OPERAÇÃO: ");
	}
	

	public void transferenciaBancariaPjPf() {
		System.out.println("====================-Realizar transferência PJ -> PF -====================");
	}
	public void transferenciaBancariaPjPj() {
		System.out.println("====================-Realizar transferência PJ -> PJ -====================");
	}
	public void transferenciaBancariaPfPj() {
		System.out.println("====================-Realizar transferência PF -> PJ -====================");
	}
	public void transferenciaBancariaPfPf() {
		System.out.println("====================-Realizar transferência PF -> PF -====================");
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
	
	public void opcaoDeposito() {
			System.out.println("====================-Depositar-====================");
			System.out.println("OPERAÇÕES:");
			System.out.println("\t - Depositar em cliente PJ \t\t [1]");
			System.out.println("\t - Depositar em cliente PF \t\t [2]\n");
			System.out.println("\t - CANCELAR OPERAÇÃO \t\t\t [0]\n");
			System.out.print("\t OPERAÇÃO: ");
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


