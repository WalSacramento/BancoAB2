package bancoAB2;

public class ContaCorrente extends Conta {
    private static final int taxaManutencao = 50;
    
    public ContaCorrente(int numAgencia, int numConta, double saldo, Cliente cliente) {
        super(numAgencia, numConta, saldo, cliente);
    }
    
    public int getTaxaManutencao() {
        return taxaManutencao;
    }
    
    public void simularOperacao(int meses) {
        double rendimento = getSaldo() -  (meses * taxaManutencao);
        System.out.println("Após " + meses + " meses de operação o saldo é : " + rendimento);
    }

    public static void main(String[] args) {
    	
    	Cliente cliente = new Cliente("João da Silva", "Rua das Flores, 123", "Engenheiro");
    	ContaCorrente contaCorrente = new ContaCorrente(12345, 67890, 1000.0, cliente);
    	contaCorrente.simularOperacao(12);


        }
}
