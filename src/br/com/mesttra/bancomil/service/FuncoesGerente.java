package br.com.mesttra.bancomil.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import br.com.mesttra.bancomil.cliente.Cliente;
import br.com.mesttra.bancomil.cliente.ClientePf;
import br.com.mesttra.bancomil.cliente.ClientePj;
import br.com.mesttra.bancomil.util.SaldoInsuficienteException;

public class FuncoesGerente {

	Scanner input = new Scanner(System.in);

	int qtdClientes = 48;

	public ClientePj cadastrarClientePj() {

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
		System.out.print("Razão social: ");
		String nomeSocial = input.nextLine();

		input = new Scanner(System.in);
		System.out.print("Nome fantasia: ");
		String nomeFantasia = input.nextLine();

		ClientePj cliente = new ClientePj(numero, agencia, telefone, saldo, limite, cnpj, nomeSocial, nomeFantasia);
		System.out.println("CLIENTE " + nomeSocial + " CADASTRADO COM NUMERO: " + numero);
		return cliente;
	}

	public ClientePf cadastrarClientePf() {
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

		ClientePf cliente = new ClientePf(numero, agencia, telefone, saldo, limite, cpf, nome, idade);
		System.out.println("CLIENTE " + nome + " CADASTRADO COM NUMERO: " + numero);
		return cliente;
	}

	public void removerCliente(Integer numero, List<Cliente> clientes) {

		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getNumero().equals(numero)) {
				clientes.remove(i);
				System.out.println("CLIENTE FOI REMOVIDO COM SUCESSO");

			}
		}
	}

	public Cliente consultarCliente(Integer numero, List<Cliente> clientes) {
		for (int i = 0; i < clientes.size(); i++) {
			return (clientes.get(i).getNumero().equals(numero)) ? clientes.get(i) : null;
		}
		return null;
	}

	public void fazerTransferencia(Integer contaFonte, Double valor, Integer contaDestino, List<Cliente> clientes)
			throws SaldoInsuficienteException {
		Cliente clienteDestino = null;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente teste = clientes.get(i);
			if(teste.getNumero().equals(contaFonte)){
				clienteDestino = teste;
			}
		}
		for (int i = 0; i < clientes.size(); i++) {
			Cliente teste2 = clientes.get(i);
			if(teste2.getNumero().equals(contaFonte)){
				teste2.transfere(valor, clienteDestino);;
				
			}
		}
		
		
		
	}

	public void adicionarSaldo(Integer numero, Double valor, List<Cliente> clientes) {
		if (valor > 0) {
			for (int i = 0; i < clientes.size(); i++) {
				if (clientes.get(i).getNumero().equals(numero)) {
					clientes.get(i).deposita(valor);
				}
			}
		} else {
			System.out.println("Saldo deve ser positivo");
		}
	}

	public void relatorio(List<Cliente> clientes) {
		clientes.forEach(System.out::println);
	}

	public void alterarLimite(Integer numero, Double novoLimite, List<Cliente> clientes) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getNumero().equals(numero)) {
				clientes.get(i).setLimite(novoLimite);
			}
		}
	}

	public Double consultaLimite(Integer numero, List<Cliente> clientes) {
		return clientes.stream().filter(c -> c.getNumero().equals(numero)).findFirst().get().getLimite();

	}

	public void consultarClientesNegativados(List<Cliente> clientes) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getSaldo() < 0) {
				System.out.println(clientes.get(i));
				System.out.println("------------------------------");
			}
		}
	}
}
