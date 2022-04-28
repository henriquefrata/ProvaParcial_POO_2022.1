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
            
            }else{

                JOptionPane.showMessageDialog(null,"O CPF inserido já está cadastrado");
        }
            }else if (tipo.equals("j")){
                
                String cnpj = JOptionPane.showInputDialog( "Insira seu CNPJ:" );
                valida = verificando(cnpj);
                 
                if (valida == -1){
                    PessoaJuridica pj = new PessoaJuridica(nome,cnpj);
                    c= pj;
                    JOptionPane.showMessageDialog(null,"Sua mesa foi cadastrada com sucesso");
                }else{
                    JOptionPane.showMessageDialog(null,"O CNPJ inserido já está cadastrado");
                }
            }
                    
        //Inserindo o cliente na lista        
        
        if (c != null){
           Reserva reserva = new Reserva(c,pag);
           reservas.add(reserva);
        }
    
    
        


    }


    
}
