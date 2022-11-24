package br.com.mesttra.bancomil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.mesttra.bancomil.cliente.Cliente;
import br.com.mesttra.bancomil.cliente.ClientePf;
import br.com.mesttra.bancomil.cliente.ClientePj;
import br.com.mesttra.bancomil.dao.ClienteDAO;
import br.com.mesttra.bancomil.service.FuncoesGerente;
import br.com.mesttra.bancomil.util.Menu;
import br.com.mesttra.bancomil.util.SaldoInsuficienteException;

public class Main {

	
	public static void main(String[] args) throws InterruptedException {
		
		ClienteDAO dao = new ClienteDAO();
		Scanner input = new Scanner(System.in);
		FuncoesGerente gerente = new FuncoesGerente();

		
		List<Cliente> clientes = new ArrayList<>();
		
		Menu ui = new Menu();
//		PopulaBanco();
		limpaConsole();
		int operacao;
		Integer numeroDaConta;
		boolean flag = true;
		while (flag) {
			input = new Scanner(System.in);
			ui.cabecalho();
			ui.opcoes();
			operacao = input.nextInt();
			try {
				switch (operacao) {
				case 1:
					limpaConsole();
					input = new Scanner(System.in);
					ui.opcaoCadastro();
					int op = verificaOperacaoCadastro(input);
					if (op == 1) {
						ClientePj cliente = gerente.cadastrarClientePj();
						dao.cadastrarClientePJ(cliente);
						Thread.sleep(2500);
						limpaConsole();
					} else if (op == 2) {
						ClientePf cliente = gerente.cadastrarClientePf();
						dao.cadastrarClientePF(cliente);
						Thread.sleep(2500);
						limpaConsole();
					} else {
						System.out.println("OPERAÇÃO CANCELADA");
						Thread.sleep(2500);
						limpaConsole();
						break;
					}
					break;

				case 2:
					limpaConsole();
					input = new Scanner(System.in);
					numeroDaConta = input.nextInt();
					Cliente clienteConsulta = gerente.consultarCliente(numeroDaConta, clientes);
					dao.consultarCliente(clienteConsulta, numeroDaConta);
					break;

				case 3:
					limpaConsole();
					input = new Scanner(System.in);
					ui.removerCliente();
					numeroDaConta = input.nextInt();
					Cliente clienteRemocao = gerente.consultarCliente(numeroDaConta, clientes);
					dao.removerCliente(clienteRemocao, numeroDaConta);
					gerente.removerCliente(numeroDaConta, clientes);
					break;

				case 4:
					limpaConsole();
					input = new Scanner(System.in);
					ui.transferenciaBancaria();
					ui.transFonte();
					Integer numeroFonte = input.nextInt();
					ui.transDestino();
					Integer numeroDestino = input.nextInt();
					ui.valorTrans();
					Double valorTrans = input.nextDouble();
					
					Cliente clienteFonte = gerente.consultarCliente(numeroFonte, clientes);
					Cliente clienteDestino = gerente.consultarCliente(numeroDestino, clientes);
				
					try {
						gerente.fazerTransferencia(numeroFonte, valorTrans, numeroDestino, clientes);
						dao.realizarTransferencia(clienteFonte, clienteDestino, valorTrans, numeroFonte, numeroDestino);
					} catch (SaldoInsuficienteException e) {
						System.out.println("Saldo insuficiente na conta depositante.");
					}
					break;

				case 5:
					limpaConsole();
					input = new Scanner(System.in);
					ui.alterarLimite();
					numeroDaConta = input.nextInt();
					Double limiteAtual = gerente.consultaLimite(numeroDaConta, clientes);
					System.out.print("Limite atual da conta [ " + numeroDaConta + " ]: " + limiteAtual);
					System.out.print("\nNovo limite: ");
					Double novoLimite = input.nextDouble();
					gerente.alterarLimite(numeroDaConta, novoLimite, clientes);
					break;

				case 6:
					limpaConsole();
					input = new Scanner(System.in);
					ui.deposito();
					numeroDaConta = input.nextInt();
					ui.valorDeposito();
					Double valorDeposito = input.nextDouble();
					gerente.adicionarSaldo(numeroDaConta, valorDeposito, clientes);
					break;

				case 7:
					limpaConsole();
					input = new Scanner(System.in);
					ui.clientesDevedores();
					gerente.consultarClientesNegativados(clientes);
					break;
					
				case 8:
					limpaConsole();
					input = new Scanner(System.in);
					ui.relatorio();
					gerente.relatorio(clientes);
					break;
				default:
					ui.sairDoSistema();
					flag = false;
				}
			} catch (NullPointerException ex) {
				System.out.println("Usuário não encontrado.");
			}
		}

	}

	public static int verificaOperacaoCadastro(Scanner input) {
		int op = input.nextInt();
		while (op < 0 && op > 2) {
			System.out.println("Opção inválida: ");
			op = input.nextInt();
		}
		return op;
	}


	public static void limpaConsole() {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
		}
	}
	

}
