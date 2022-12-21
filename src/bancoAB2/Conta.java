package bancoAB2;

public class Conta {
    private int numAgencia;
    private int numConta;
    private double saldo;
    private Cliente cliente;
    
    public Conta(int numAgencia, int numConta, double saldo, Cliente cliente) {
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.saldo = saldo;
        this.cliente = cliente;
    }
    
    public int getNumAgencia() {
        return numAgencia;
    }
    
    public void setNumAgencia(int numAgencia) {
        this.numAgencia = numAgencia;
    }
    
    public int getNumConta() {
        return numConta;
    }
    
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void deposito(double quantia) {
    	saldo += quantia;
    }
    
    public void saque(double quantia) {
    	saldo -= quantia;
    }
    
    public void exibirSaldo() {
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Endereço: " + saldo);
    }
    
    public void transferencia(Conta contaDestino, double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para transferência.");
        } else {
            saldo -= valor;
            contaDestino.saldo += valor;
        }
    }

public static void main(String[] args) {
    	
	Cliente cliente = new Cliente("João da Silva", "Rua das Flores, 123", "Engenheiro");
	Conta conta = new Conta(12345, 67890, 1000.0, cliente);
	
	Cliente cliente1 = new Cliente("Jose da Silva", "Rua do Ypê, 321", "Desenvolvedor");
	Conta conta1 = new Conta(12345, 56789, 2000.0, cliente1);
	
	conta.exibirSaldo();
	conta1.exibirSaldo();
	
	conta.transferencia(conta1, 500);
	
	conta.exibirSaldo();
	conta1.exibirSaldo();
	
	
	

    }
}
