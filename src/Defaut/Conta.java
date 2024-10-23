package Defaut;

public abstract class Conta implements IConta {
	
	protected static final int AGENCIA_PADRAO = 1;
	
	private Cliente cliente;
	protected int agencia;
	protected int numero;
	protected double saldo;
	
	private static int SEQUENCIAL = 1;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	public void caixinha(double valor, int anos) {
		double investimento = (valor + valor*10/100) * anos;
		System.out.print("O valor que vc vai investir por " + anos + " anos é " + investimento);
	}
	@Override
	public void sacar(double valor) {
		if(valor <= this.saldo){
			this.saldo -= valor;
		}else {
			System.out.println("Saldo insuficiente na conta.");
		}
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(valor <= this.saldo) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		}else {
			System.out.println("Transfência não efetuada. Saldo insuficiente na conta.");
		}
		
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void imprimirExtrato() {
		// TODO Auto-generated method stub
		
	}
	protected void imprimirInfoComuns() {
		System.out.println(String.format("Titular: %s",this.cliente.getNome()));
		System.out.println(String.format("Agência: %d",this.agencia));
		System.out.println(String.format("Numero: %d",this.numero));
		System.out.println(String.format("Saldo: %.2f",this.saldo));
	}

	
}
