package Defaut;

public class Main {

	public static void main(String[] args) {
		Cliente lucas = new Cliente();
		lucas.setNome("Lucas");
		Conta cc = new ContaCorrente(lucas);
		Conta poupanca = new ContaPoupança(lucas);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		cc.depositar(1000);
		poupanca.depositar(500);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		cc.transferir(500, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
