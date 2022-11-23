package br.com.mesttra.bancomil.service;

import java.util.Scanner;

import br.com.mesttra.bancomil.cliente.Cliente;
import br.com.mesttra.bancomil.cliente.ClientePf;
import br.com.mesttra.bancomil.cliente.ClientePj;
import br.com.mesttra.bancomil.util.SaldoInsuficienteException;

public class FuncoesGerente {

	Scanner input = new Scanner(System.in);

	int qtdClientes = 48;

	public int cadastrarClientePj(Cliente[] clientes, int cadastrados) {

		input = new Scanner(System.in);
		System.out.print("Numero: ");
		Integer numero = input.nextInt();

		input = new Scanner(System.in);
		System.out.print("Agencia: ");
		Integer agencia = input.nextInt();

		input = new Scanner(System.in);
		System.out.print("Telefone: ");
		String telefone = input.nextLine();

		Double saldo = 0.0;
		
		input = new Scanner(System.in);
		System.out.print("Limite incial: ");
		Double limite = input.nextDouble();

		input = new Scanner(System.in);
		System.out.print("CNPJ: ");
		String cnpj = input.nextLine();

		input = new Scanner(System.in);
		System.out.print("Quantidade de sócios: ");
		Integer qtdSocios = input.nextInt();

		input = new Scanner(System.in);
		System.out.print("Razão social: ");
		String nomeSocial = input.nextLine();

		input = new Scanner(System.in);
		System.out.print("Nome fantasia: ");
		String nomeFantasia = input.nextLine();

		clientes[cadastrados] = new ClientePj(numero, agencia, telefone, saldo, limite, cnpj, 
				nomeSocial, nomeFantasia);
		cadastrados++;
		System.out.println("CLIENTE " + nomeSocial + " CADASTRADO COM NUMERO: " + numero);
		return cadastrados;
	}


	public int cadastrarClientePf(Cliente[] clientes, int cadastrados) {
		input = new Scanner(System.in);
		System.out.print("CPF: ");
		String cpf = input.nextLine();

		input = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = input.nextLine();

		input = new Scanner(System.in);
		System.out.print("Idade: ");
		Integer idade = input.nextInt();

		input = new Scanner(System.in);
		System.out.print("Numero: ");
		Integer numero = input.nextInt();

		input = new Scanner(System.in);
		System.out.print("Agencia: ");
		Integer agencia = input.nextInt();

		input = new Scanner(System.in);
		System.out.print("Telefone: ");
		String telefone = input.nextLine();

		Double saldo = 0.0;

		input = new Scanner(System.in);
		System.out.print("Limite incial: ");
		Double limite = input.nextDouble();


		clientes[cadastrados] = new ClientePf(numero, agencia, telefone, saldo, limite, cpf, nome, idade);
		System.out.println("CLIENTE " + nome + " CADASTRADO COM NUMERO: " + numero);
		cadastrados++;
		return cadastrados;
	}

	public void removerCliente(Integer numero, Cliente[] clientes) {
		for (int i = 0; i <= qtdClientes; i++) {
			if ((clientes[i] != null) && clientes[i].getNumero().compareTo(numero) == 0) {
				clientes[i] = null;
				System.out.println("CLIENTE FOI REMOVIDO COM SUCESSO");
				break;
			}
		}
	}

	public String consultarCliente(Integer numero, Cliente[] clientes) {
		for (int i = 0; i < qtdCadastros(clientes); i++) {
			if ((clientes[i] != null) && clientes[i].getNumero().compareTo(numero) == 0) {
				return (clientes[i].toString());
			}
		}
		throw new NullPointerException();
	}

	public void fazerTransferencia(Integer contaFonte, Double valor, Integer contaDestino, Cliente[] clientes)
			throws SaldoInsuficienteException {
		Cliente clienteDestino = null;
		for (int j = 0; j < qtdClientes; j++) {
			if ((clientes[j] != null) && clientes[j].getNumero().compareTo(contaDestino) == 0) {
				clienteDestino = clientes[j];
			}
		}

		for (int i = 0; i <= qtdClientes; i++) {
			if ((clientes[i] != null) && clientes[i].getNumero().compareTo(contaFonte) == 0) {
				clientes[i].transfere(valor, clienteDestino);
				System.out.println("TRANSFERENCIA REALIZADA COM SUCESSO");
				break;
			}
		}
	}

	public void adicionarSaldo(Integer numero, Double valor, Cliente[] clientes) {
		if (valor > 0) {
			for (int j = 0; j <= qtdClientes; j++) {
				if ((clientes[j] != null) && clientes[j].getNumero().compareTo(numero) == 0) {
					clientes[j].deposita(valor);
					System.out.println("DEPÓSITO EFETUADO COM SUCESSO");
					break;
				}
			}
		} else {
			System.out.println("Saldo deve ser positivo");
		}
	}

	public void relatorio(Cliente[] clientes) {
		for (int j = 0; j <= qtdClientes; j++) {
			if (clientes[j] != null) {
				System.out.print(clientes[j]);
				System.out.println("------------------------------");
			}
		}
	}

	public void alterarLimite(Integer numero, Double novoLimite, Cliente[] clientes) {
		for (int j = 0; j <= qtdClientes; j++) {
			if ((clientes[j] != null) && clientes[j].getNumero().compareTo(numero) == 0) {
				clientes[j].setLimite(novoLimite);
				System.out.println("LIMITE ALTERADO COM SUCESSO");
				break;
			}
		}
	}

	public Double consultaLimite(Integer numero, Cliente[] clientes) {
		for (int i = 0; i <= qtdClientes; i++) {
			if ((clientes[i] != null) && clientes[i].getNumero().compareTo(numero) == 0) {
				return clientes[i].getLimite();
			}
		}
		return 0.0;
	}

	public int qtdCadastros(Cliente[] clientes) {
		int qtdCadastros = 0;
		for (int i = 0; i < qtdClientes; i++) {
			if (clientes[i] != null) {
				qtdCadastros++;
			}
		}
		return qtdCadastros;
	}

	public void consultarClientesNegativados(Cliente[] clientes) {
		for (int i = 0; i < qtdClientes; i++) {
			if ((clientes[i] != null) && clientes[i].getSaldo() < 0) {
				System.out.println(clientes[i]);
				System.out.println("------------------------------");
			}
		}
	}
}
