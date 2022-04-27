
public class Reserva implements Pagamento{
    
    Cliente cliente;
    boolean pagamentoAVista;

    public Reserva(Cliente cliente, boolean pagamentoAVista) {
        this.cliente = cliente;
        this.pagamentoAVista = pagamentoAVista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
      String tipoPagamento;
      String tipoPessoa;

        if(pagamentoAVista == true) {
            tipoPagamento = "Pagamento a Vista";
        } else {
            tipoPagamento = "Pagamento parcelado";
        }

        if (cliente instanceof PessoaFisica) {
            tipoPessoa = "Pessoa Fisica";
        } else {
            tipoPessoa = "Pessoa Juridica";
        }

        return "Cliente: " + cliente.getNome() + "\n" + tipoPessoa + "\n" + tipoPagamento;

    }

   @Override
    public double CalcularPagamento() {
        if (pagamentoAVista == true) {
            return 3200 * 0.9;
        }
        return 3200;
    }

    

   

}
