package bancoAB2;

public class ContaPoupanca extends Conta {
    private static final double taxaRendimento = 0.05;
    
    public ContaPoupanca(int numAgencia, int numConta, double saldo, Cliente cliente) {
        super(numAgencia, numConta, saldo, cliente);
    }
    
    public double getTaxaRendimento() {
        return taxaRendimento;
    }
    
    public void simularOperacao(int meses) {
        double rendimento = getSaldo() * Math.pow(1 + taxaRendimento, meses);
        System.out.println("Rendimento após " + meses + " meses: " + rendimento);
    }

    public static void main(String[] args) {
    	
    	Cliente cliente = new Cliente("João da Silva", "Rua das Flores, 123", "Engenheiro");
    	ContaPoupanca contaPoupanca = new ContaPoupanca(12345, 67890, 1000.0, cliente);
    	contaPoupanca.simularOperacao(12);


        }
}
