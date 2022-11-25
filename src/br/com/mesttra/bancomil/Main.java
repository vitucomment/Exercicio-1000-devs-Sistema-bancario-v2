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
		Menu ui = new Menu();
		
		List<Cliente> clientes = new ArrayList<>();

		limpaConsole();
		
		boolean flag = true;
		while (flag) {
			Integer numeroDaConta;
			int operacao;
			clientes.addAll(dao.relatorio());
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
						clientes.add(cliente);
						dao.cadastrarClientePJ(cliente);
						Thread.sleep(2500);
						limpaConsole();
					} else if (op == 2) {
						ClientePf cliente = gerente.cadastrarClientePf();
						clientes.add(cliente);
						dao.cadastrarClientePF(cliente);
						Thread.sleep(2500);
						limpaConsole();
					} else {
						operacaoCancelada();
						break;
					}
					break;

				case 2:
					limpaConsole();
					ui.opcaoConsulta();
					input = new Scanner(System.in);
					int opConsulta = input.nextInt();
					if (opConsulta == 1) {
						ui.consultarClientePj();
						numeroDaConta = input.nextInt();
						imprimeConsultaPj(dao, numeroDaConta);
					} else if (opConsulta == 2) {
						ui.consultarClientePf();
						numeroDaConta = input.nextInt();
						imprimeConsultaPf(dao, numeroDaConta);
					} else {
						operacaoCancelada();
						break;
					}
					break;

				case 3:
					limpaConsole();
					ui.opcaoRemocao();
					input = new Scanner(System.in);
					int opRemocao = input.nextInt();
					if (opRemocao == 1) {
						ui.removerCliente();
						numeroDaConta = input.nextInt();
						gerente.removerCliente(numeroDaConta, clientes);
						dao.removerClientePj(numeroDaConta);
					} else if (opRemocao == 2) {
						ui.removerCliente();
						numeroDaConta = input.nextInt();
						gerente.removerCliente(numeroDaConta, clientes);
						dao.removerClientePf(numeroDaConta);
					} else {
						operacaoCancelada();
						break;
					}
					break;

				case 4:
					limpaConsole();
					ui.opçoesTransferencia();
					input = new Scanner(System.in);
					int opTrans = input.nextInt();
					if (opTrans == 1) {
						transferenciaPjPf(dao, input, gerente, clientes, ui);
					} else if (opTrans == 2) {
						transferenciaPjPj(dao, input, gerente, clientes, ui);
					} else if (opTrans == 3) {
						transferenciaPfPj(dao, input, gerente, clientes, ui);
					} else if (opTrans == 4) {
						transferenciaPfPf(dao, input, gerente, clientes, ui);
					}
					break;

				case 5:
					limpaConsole();
					ui.opcaoAlterarLimite();
					input = new Scanner(System.in);
					int opLimite = input.nextInt();
					if (opLimite == 1) {
						alteraLimitePj(dao, input, gerente, clientes, ui);
					} else if (opLimite == 2) {
						alteraLimitePf(dao, input, gerente, clientes, ui);
					} else {
						operacaoCancelada();
						break;
					}
					break;

				case 6:
					limpaConsole();
					ui.opcaoDeposito();
					input = new Scanner(System.in);
					int opDeposito = input.nextInt();
					if (opDeposito == 1) {
						depositarPj(dao, input, gerente, clientes, ui);
					} else if (opDeposito == 2) {
						depositarPf(dao, input, gerente, clientes, ui);
					} else {
						operacaoCancelada();
						break;
					}
					break;

				case 7:
					limpaConsole();
					input = new Scanner(System.in);
					ui.clientesDevedores();
					gerente.consultarClientesNegativados(clientes);
					List<Cliente> devedores = null;
					devedores.addAll(dao.clientesDevedoresPF());
					devedores.addAll(dao.clientesDevedoresPJ());
					devedores.forEach(System.out::println);
					break;

				case 8:
					limpaConsole();
					input = new Scanner(System.in);
					ui.relatorio();
					List<Cliente> relatorio = dao.relatorio();
					relatorio.forEach(System.out::println);
					break;

				default:
					ui.sairDoSistema();
					input.close();
					flag = false;
				}
			} catch (NullPointerException ex) {
				System.out.println("Usuário não encontrado.");
			}
		}

	}

	private static void depositarPf(ClienteDAO dao, Scanner input, FuncoesGerente gerente, List<Cliente> clientes,
			Menu ui) {
		Integer numeroDaConta;
		ui.deposito();
		numeroDaConta = input.nextInt();
		ui.valorDeposito();
		Double valorDeposito = input.nextDouble();
		gerente.adicionarSaldo(numeroDaConta, valorDeposito, clientes);
		dao.depositarPf(valorDeposito, numeroDaConta);
	}

	private static void depositarPj(ClienteDAO dao, Scanner input, FuncoesGerente gerente, List<Cliente> clientes,
			Menu ui) {
		Integer numeroDaConta;
		ui.deposito();
		numeroDaConta = input.nextInt();
		ui.valorDeposito();
		Double valorDeposito = input.nextDouble();
		gerente.adicionarSaldo(numeroDaConta, valorDeposito, clientes);
		dao.depositarPj(valorDeposito, numeroDaConta);
	}

	private static void alteraLimitePf(ClienteDAO dao, Scanner input, FuncoesGerente gerente, List<Cliente> clientes,
			Menu ui) {
		Integer numeroDaConta = null;
		ui.alterarLimite();
		numeroDaConta = input.nextInt();
		imprimeLimiteAntigo(clientes, numeroDaConta);
		System.out.print("\nNovo limite: ");
		Double novoLimite = input.nextDouble();
		gerente.alterarLimite(numeroDaConta, novoLimite, clientes);
		dao.alterarLimitePf(novoLimite, numeroDaConta);
	}

	private static void alteraLimitePj(ClienteDAO dao, Scanner input, FuncoesGerente gerente, List<Cliente> clientes,
			Menu ui) {
		Integer numeroDaConta = null;
		ui.alterarLimite();
		numeroDaConta = input.nextInt();
		imprimeLimiteAntigo(clientes, numeroDaConta);
		System.out.print("\nNovo limite: ");
		Double novoLimite = input.nextDouble();
		gerente.alterarLimite(numeroDaConta, novoLimite, clientes);
		dao.alterarLimitePj(novoLimite, numeroDaConta);
	}

	private static void imprimeLimiteAntigo(List<Cliente> clientes, Integer numeroDaConta) {
		final int numeroConta = numeroDaConta;
		Double limiteAtual = clientes.stream().filter(c -> c.getNumero() == numeroConta).findFirst().get().getLimite();
		System.out.print("Limite atual da conta [ " + numeroDaConta + " ]: " + limiteAtual);
	}

	private static void transferenciaPfPf(ClienteDAO dao, Scanner input, FuncoesGerente gerente, List<Cliente> clientes,
			Menu ui) {
		ui.transferenciaBancariaPfPf();
		ui.transFonte();
		Integer numeroFonte = input.nextInt();
		ui.transDestino();
		Integer numeroDestino = input.nextInt();
		ui.valorTrans();
		Double valorTrans = input.nextDouble();
		try {
			gerente.fazerTransferencia(numeroFonte, valorTrans, numeroDestino, clientes);
			dao.realizarTransferenciaPfToPf(valorTrans, numeroFonte, numeroDestino);
		} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void transferenciaPfPj(ClienteDAO dao, Scanner input, FuncoesGerente gerente, List<Cliente> clientes,
			Menu ui) {
		ui.transferenciaBancariaPfPj();
		ui.transFonte();
		Integer numeroFonte = input.nextInt();
		ui.transDestino();
		Integer numeroDestino = input.nextInt();
		ui.valorTrans();
		Double valorTrans = input.nextDouble();
		try {
			gerente.fazerTransferencia(numeroFonte, valorTrans, numeroDestino, clientes);
			dao.realizarTransferenciaPfToPj(valorTrans, numeroFonte, numeroDestino);
		} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private static void transferenciaPjPj(ClienteDAO dao, Scanner input, FuncoesGerente gerente, List<Cliente> clientes,
			Menu ui) {
		ui.transferenciaBancariaPjPj();
		ui.transFonte();
		Integer numeroFonte = input.nextInt();
		ui.transDestino();
		Integer numeroDestino = input.nextInt();
		ui.valorTrans();
		Double valorTrans = input.nextDouble();
		try {
			gerente.fazerTransferencia(numeroFonte, valorTrans, numeroDestino, clientes);
			dao.realizarTransferenciaPjToPj(valorTrans, numeroFonte, numeroDestino);
		} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private static void transferenciaPjPf(ClienteDAO dao, Scanner input, FuncoesGerente gerente, List<Cliente> clientes,
			Menu ui) {
		ui.transferenciaBancariaPjPf();
		ui.transFonte();
		Integer numeroFonte = input.nextInt();
		ui.transDestino();
		Integer numeroDestino = input.nextInt();
		ui.valorTrans();
		Double valorTrans = input.nextDouble();
		try {
			gerente.fazerTransferencia(numeroFonte, valorTrans, numeroDestino, clientes);
			dao.realizarTransferenciaPjToPf(valorTrans, numeroFonte, numeroDestino);
		} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private static void operacaoCancelada() throws InterruptedException {
		System.out.println("OPERAÇÃO CANCELADA");
		Thread.sleep(2500);
		limpaConsole();
	}

	
	private static void imprimeConsultaPf(ClienteDAO dao, Integer numeroDaConta) {
		if (dao.ConsultarClientePf(numeroDaConta) == null) {
			System.out.println("Cliente não encontrado");
			;
		} else {
			System.out.println(dao.ConsultarClientePf(numeroDaConta));
		}
	}

	
	private static void imprimeConsultaPj(ClienteDAO dao, Integer numeroDaConta) {
		if (dao.ConsultarClientePj(numeroDaConta) == null) {
			System.out.println("Cliente não encontrado");
			;
		} else {
			System.out.println(dao.ConsultarClientePj(numeroDaConta));
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
