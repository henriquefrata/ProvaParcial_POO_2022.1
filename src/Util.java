import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Util {

    private static ArrayList<Reserva> reservas = new ArrayList<>();

    public static void reservarMesa() {

        int valida;
        boolean pag = true;
        Cliente c = null;

        if(reservas.size()>=6){
            JOptionPane.showMessageDialog(null, "No momento estamos sem mesas, iremos adicioná-lo em nossa lista de espera!"	);
        }

        String nome = JOptionPane.showInputDialog("Qual seu nome?");     
        
        //Validando tipo de pagamento       
        String pagamento = JOptionPane.showInputDialog("O pagamento será à vista? [ S / N ]:").toLowerCase();
                    
        if ( (!pagamento.equals("s")) && (!pagamento.equals("n"))){
        pagamento = JOptionPane.showInputDialog( "Insira apenas a letra S, se o pagamento será feito à vista, ou N, se o pagamento será feito à prazo").toLowerCase();
        }
        
        if (pagamento.equals("s")){
            pag = true;
        } else if (pagamento.equals("n")){
            pag = false;
        }
            
        //Validando o tipo do cliente e verificando duplicatas

        String tp = JOptionPane.showInputDialog( "O cliente se trata de Pessoa Física ou Pessoa Jurídica? [ F / J ]" ).toLowerCase();            
                    
        if ( (!tp.equals("f")) && (!tp.equals("j"))){
            tp = JOptionPane.showInputDialog( "Insira apenas F, se for pessoa física, ou J, se for pessoa jurídica").toLowerCase();            
        }

        if (tp.equals("f")){
            String cpf = JOptionPane.showInputDialog( "Insira seu CPF:" );
            valida = verificando(cpf);
            
            if (valida == -1){
            
                PessoaFisica pf = new PessoaFisica(nome,cpf);
                c= pf;
                JOptionPane.showMessageDialog(null,"Sua mesa foi cadastrada com sucesso");
            
            } else {

                JOptionPane.showMessageDialog(null,"O CPF inserido já está cadastrado");
        }
            } else if (tp.equals("j")){
                
                String cnpj = JOptionPane.showInputDialog( "Insira seu CNPJ:" );
                valida = verificando(cnpj);
                 
                if (valida == -1){
                    PessoaJuridica pj = new PessoaJuridica(nome,cnpj);
                    c= pj;
                    JOptionPane.showMessageDialog(null,"Sua mesa foi cadastrada com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null,"O CNPJ inserido já está cadastrado");
                }
            }
                    
        //Inserindo o cliente na lista        
        
        if (c != null){
           Reserva reserva = new Reserva(c,pag);
           reservas.add(reserva);
        }
    }

    public static void pesquisarReserva(){
        String buscar = JOptionPane.showInputDialog(null, "Insira o CPF OU CNPJ para consulta: ");
        int valida = verificando(buscar);

        if(valida != -1){
            if(valida < 6){
            JOptionPane.showMessageDialog(null, "Reserva Encontrada!:) \n" +reservas.get(valida).getCliente().toString());
            } else {
                JOptionPane.showMessageDialog(null, "Achamos sua reserva, mas você ainda está na lista de espera! \nCliente: " +reservas.get(valida).getCliente().toString() + "\nPosição na fila: "+ (valida-5)); 
            }
        } else {
           String novo =  JOptionPane.showInputDialog(null, "Não achamos sua reserva, gostaria de realizar uma reserva? [ S / N ]").toLowerCase();
            if (novo.equals("s")){
                reservarMesa();
            }
        }  
    }

    public static int verificando(String buscar){
        int valida = -1;
    
            for (int i=0; i<reservas.size() ; i++){
    
                if (reservas.get(i).getCliente() instanceof PessoaFisica){
                    PessoaFisica pf = (PessoaFisica) reservas.get(i).getCliente();
                    if (pf.getCpf().equals(buscar)){  
                        valida = i;                        
                    }
                }
    
                if (reservas.get(i).getCliente() instanceof PessoaJuridica){
                    PessoaJuridica pj = (PessoaJuridica) reservas.get(i).getCliente();
                    if (pj.getCnpj().equals(buscar)){                   
                        valida = i;
                    }
                }
            } 
        return valida;    
        }
    
    public static void imprimirListaEspera(){
        if(reservas.size()>6){   
            for ( int i=6; i<reservas.size(); i++){
                JOptionPane.showMessageDialog(null, reservas.get(i) + "\nVocê está na "+(i-5) + "º da fila");               
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma reserva na lista de espera!");
            }    
        }
    public static void imprimirReservas(){   
        if(reservas.size()>0){   
            for ( int i =0; i<reservas.size() ; i++){
                if(i<6){
                    JOptionPane.showMessageDialog(null, reservas.get(i));  
                 } else {
                    return;
                    }       
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma reserva feita! :(");
            }    
        }
    public static void cancelarReserva(){
        String achar = JOptionPane.showInputDialog(null, "Insira o CPF OU CNPJ para cancelar a reserva: ");
    
        int valida = verificando(achar);
        
            if(valida != -1){
                reservas.remove(valida);
                JOptionPane.showMessageDialog(null, "Reserva cancelada, mas fique a vontade para agendar com nós novamente!");
                
            } else {
             JOptionPane.showMessageDialog(null, "Reserva não encontrada!!");
            }
              
            }



    
}
