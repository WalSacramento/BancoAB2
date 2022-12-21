package bancoAB2;
import java.util.ArrayList;
import java.util.Scanner;

public class TesteOperacoes {
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Conta> listaContas;
    
    public TesteOperacoes() {
        listaClientes = new ArrayList<>();
        listaContas = new ArrayList<>();
    }
    
    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }
    
    public void adicionarConta(Conta conta) {
        listaContas.add(conta);
    }
    
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    
    public ArrayList<Conta> getListaContas() {
        return listaContas;
    }
    
    public void criarCliente() {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Digite o nome do cliente:");
    	String nome = scanner.nextLine();
    	System.out.println("Digite o endereço do cliente:");
    	String endereco = scanner.nextLine();
    	System.out.println("Digite a profissao do cliente:");
    	String profissao = scanner.nextLine();	
    	
    	Cliente cliente = new Cliente(nome, endereco, profissao);
    	adicionarCliente(cliente);
    	
    	System.out.println("Digite o tipo de conta do cliente:\n1 para Conta Poupanca\n2 para Conta Corrente");
    	int tipoConta = scanner.nextInt();	
    	
    	if (tipoConta == 1) {
    		
    		System.out.println("Digite o numero da agencia da conta poupança:");
        	int numAgencia  = scanner.nextInt();
        	System.out.println("Digite o numero da conta poupança:");
        	int numConta  = scanner.nextInt();
        	System.out.println("Digite o saldo da conta poupança:");
        	int saldo  = scanner.nextInt();
    		
    		ContaPoupanca contaPoupanca = new ContaPoupanca(numAgencia, numConta, saldo, cliente);
    		adicionarConta(contaPoupanca);
    	} else if (tipoConta == 2) {
    		
    		System.out.println("Digite o numero da agencia da conta corrente:");
        	int numAgencia  = scanner.nextInt();
        	System.out.println("Digite o numero da conta corrente:");
        	int numConta  = scanner.nextInt();
        	System.out.println("Digite o saldo da conta corrente:");
        	int saldo  = scanner.nextInt();
    		
    		ContaCorrente contaCorrente = new ContaCorrente(numAgencia, numConta, saldo, cliente);
    		adicionarConta(contaCorrente);
    	} else {
    		System.out.println("Você digitou um número inválido!");
    	}
    	
    	
    }
    
    public void realizarOperacoes(int numAgenciaEnviar, int numContaEnviar, int numAgenciaReceber, int numContaReceber, double valor) {
        Conta contaEnviar = null;
        Conta contaReceber = null;
        for (Conta conta : listaContas) {
            if (conta.getNumAgencia() == numAgenciaEnviar && conta.getNumConta() == numContaEnviar) {
                contaEnviar = conta;
            }
            if (conta.getNumAgencia() == numAgenciaReceber && conta.getNumConta() == numContaReceber) {
                contaReceber = conta;
            }
        }
        if (contaEnviar != null && contaReceber != null) {
            contaEnviar.transferencia(contaReceber, valor);
            System.out.println("Transferência de "  + valor + " R$ realizada com sucesso!");
            System.out.println("Saldo atual da conta que enviou: "+ contaEnviar.getSaldo() + "R$");
            System.out.println("Saldo atual da conta que recebeu: "+ contaReceber.getSaldo() + "R$");
        } else {
            System.out.println("Conta inválida. Verifique os números da agência e da conta informados.");
        }
    }
    
    public void exibirSaldo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da agência: ");
        int numAgencia = scanner.nextInt();
        System.out.print("Digite o número da conta: ");
        int numConta = scanner.nextInt();
        Conta conta = null;
        for (Conta c : listaContas) {
            if (c.getNumAgencia() == numAgencia && c.getNumConta() == numConta) {
                conta = c;
                break;
            }
        }
        if (conta != null) {
            System.out.println("Nome: " + conta.getCliente().getNome());
            System.out.println("Saldo: " + conta.getSaldo());
        } else {
            System.out.println("Conta inválida. Verifique os números da agência e da conta informados.");
        }
    }
    
    public static void main(String[] args) {
    	
    	TesteOperacoes teste = new TesteOperacoes();
    	teste.criarCliente();
    	teste.criarCliente();

    	System.out.println(teste.getListaClientes());
    	
    	teste.exibirSaldo();
    	teste.exibirSaldo();
    	
    	

    }
}
